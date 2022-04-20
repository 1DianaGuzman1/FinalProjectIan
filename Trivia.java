package com.jetbrains;
//This class pulls questions and answers from the facts.txt file

public class Trivia {
    private String trivQuestion;
    private int newCardOrNot;
    // private ArrayList<Trivia> triviaArrayList;

    //Constructor for Trivia Class
    public Trivia(String trivQuestion, int newCardOrNot ) {
        this.trivQuestion = trivQuestion;
        this.newCardOrNot = newCardOrNot;
    }

    //getter and setter

    //Setter for trivQuestion
    public void settrivQuestion(String trivQuestion){
        this.trivQuestion = trivQuestion;
    }
    //Setter for newCardOrNot
    public void setnewCardOrNot(int newCardOrNot ){
        this.newCardOrNot = newCardOrNot;
    }
    //Getter for trivQuestion
    public String gettrivQuestion(){
        return this.trivQuestion;
    }
    //Setter for newCardOrNot
    public int getnewCardOrNot() {
        return this.newCardOrNot;
    }

}


