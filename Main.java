package com.jetbrains;
import java.util.*;
import java.io.*;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

class ButtonListener implements ActionListener{
    @Override
    public void actionPerformed(ActionEvent e){

        JOptionPane.showMessageDialog(null, "You pushed the Exit button!!");

    }
}
public class Main {


    public static void main(String[] args)throws FileNotFoundException, Exception  {
        //Black Panel
        JPanel auth = new JPanel();
        auth.setBackground(Color.black);
        auth.setBounds(0,0,240,240);

        //Blue Panel
        JPanel trivia = new JPanel();
        trivia.setBackground(Color.blue);
        trivia.setBounds(240,0,240,240);

        //Yellow Panel
        JPanel exit = new JPanel();
        exit.setBackground(Color.yellow);
        exit.setBounds(0,240,480,240);

        //JFrame
        JFrame frame = new JFrame();


        frame.setLayout(null);
        //Title
        frame.setTitle("Haiku GUI App 9000");
        //Does nothing when window is closed
        frame.setDefaultCloseOperation(JFrame.DO_NOTHING_ON_CLOSE);
        frame.setResizable(false);
        frame.setSize(480, 480);



        //Button 1 Authenticator
        JButton button1 = new JButton("Authenticator");
        frame.add(auth);
        auth.add(button1);

        //Button 2 Trivia
        JButton button2 = new JButton("Trivia mode");
        frame.add(trivia);
        trivia.add(button2);
        button2.addActionListener((event) -> System.exit(0));


        //Button 3 Exit
        // set the program to do a custom thing when we hit close
        JButton button3 = new JButton("Exit");
        frame.add(exit);
        exit.add(button3);
        //Exits program
        button3.addActionListener((event) -> System.exit(0));



        frame.setVisible(true);

        //Variables
        int option;
        int min =1000;

        //Scanner
        Scanner in = new Scanner(System.in);

        //Welcome Message
        System.out.println("Pick an option:");
        System.out.println("1. Trivia mode");
        System.out.println("2. Authenticator");
        System.out.println("3. Exit");
        System.out.print(": ");
        option = in.nextInt();

        while(option!=3) {
            //1
            if(option==1) {
                TriviaMode();
                //2
            }else if (option==2) {
                authenticHi( );

            }else{
                System.out.println("Please enter a number between 1 and 3.");
            }
            System.out.println("Pick an option:");
            System.out.println("1. Trivia mode");
            System.out.println("2. Authenticator");
            System.out.println("3. Exit");
            System.out.print(": ");
            option = in.nextInt();
        }//end of while loop
    }

    public static void TriviaMode() throws FileNotFoundException {
        //Create a variable to store the minimum value
        // start it at some huge value
        int min = 1000;
        String minQuestion= " ";
        ArrayList<Trivia> alternativeList= getTriv();

        //Go through the list of trivia questions(for-loop).
        for(int i=0;i<alternativeList.size();i++) {
            Trivia t = alternativeList.get(i);
            int tVal = t.getnewCardOrNot();
            if(tVal<min){
                min=tVal;
                minQuestion = t.gettrivQuestion();
                t.setnewCardOrNot(tVal+1);
            }
        }
        save(alternativeList);

        System.out.println("Here is a fun fact about Haiku's");
        System.out.println("Did you know.....");
        System.out.println(minQuestion);

    }
    public static ArrayList<Trivia> getTriv( )throws FileNotFoundException{
        //This is where you get the question
        File trivia = new File("facts.txt");
        Scanner s = new Scanner(trivia);
        ArrayList<Trivia> trivFact = new ArrayList<Trivia>();

        while(s.hasNextLine()) {
            //Save fact as a String
            String question = s.nextLine();
            //   System.out.println(question);

            //Save number as int.
            int num = s.nextInt();
            // System.out.println(num);
            if(s.hasNextLine()) {
                s.nextLine();
            }
            //Add string (fact)
            // int (NewOrNah)
            Trivia quest = new Trivia(question,num);
            trivFact.add(quest);
        }

        return trivFact;

    }
    public static void save(ArrayList<Trivia> trivFact)throws FileNotFoundException{
        PrintWriter out = null;
        try {
            FileWriter fw = new FileWriter("facts.txt");
            out = new PrintWriter(fw);
            for(int i =0;i<trivFact.size();i++){
                out.println(trivFact.get(i).gettrivQuestion());
                out.println(trivFact.get(i).getnewCardOrNot());
            }
            //file writing code here!!!!!
            out.close();
        } catch (IOException e) {
            e.printStackTrace();
        }

    }//End of save Method
    public static void authenticHi( ){
        String line1 = ("this is my haiku");
        String line2 = ("seven syllable word dog");
        String line3 = ("smooth brain coding hard");
        String file = ("haikus/haiku.haiku");

        Haiku haiku1 = new Haiku(line1,line2,line3);

        haiku1.print();

        HaikuDeck deck = new HaikuDeck(file);

//                deck.printDeckSyll();

        haiku1.printSyll();
//        Haiku random = haikuGen();
//        random.print();

    }
}
