package com.jetbrains;
//This class pulls questions and answers from the facts.txt file

public class Trivia {
    private String trivQuestion;
    private int newCardOrNot;
    // private ArrayList<Trivia> triviaArrayList;

    public Trivia(String trivQuestion, int newCardOrNot ) {
        this.trivQuestion = trivQuestion;
        this.newCardOrNot = newCardOrNot;
    }

    //getter and setter
    public void settrivQuestion(String trivQuestion){
        this.trivQuestion = trivQuestion;
    }
    public void setnewCardOrNot(int newCardOrNot ){
        this.newCardOrNot = newCardOrNot;
    }
    public String gettrivQuestion(){
        return this.trivQuestion;
    }
    public int getnewCardOrNot() {
        return this.newCardOrNot;
    }

}


