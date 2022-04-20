package com.jetbrains;
import java.io.*;
import java.util.*;
//Creates 'deck' of haikus from file
public class HaikuDeck {
    private ArrayList<Haiku> haikuDeck;
    private String file;
    private FileReader fReader;

    //read in file
    public HaikuDeck(String fileName) {

        try{
            fReader = new FileReader(fileName);
        } catch(Exception e){
        }
        Scanner in = new Scanner(fReader);
        this.file = fileName;
        this.haikuDeck = new ArrayList();
        while(in.hasNextLine()) {
            this.haikuDeck.add(new Haiku(in));
            in.nextLine();
        }
    }
//print list of haikus
    public void printDeck(){
        for (Haiku s : this.haikuDeck)
            s.print();
    }
    //prints syllabes for each haiku in list
    public void printDeckSyll(){
        for (Haiku s : this.haikuDeck){
            s.printSyll();
        }
    }
}
