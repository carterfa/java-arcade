package com.talentpath.arcade;

import java.util.Random;
import java.util.Scanner;

public class RPS {

    public static int yourScore;
    public static int botScore;

    //Resets the score
    public static void reset(){
        yourScore = 0;
        botScore = 0;
    }

    //Ends the program
    public static void endGame(){
        System.out.println("GAME OVER");
        System.out.println(("You: " + yourScore + " Bot: " + botScore));
        reset();
        Main.startMenu();
    }

    //Check who is the winner
    static void checkWinner(String input){
        String botChoice = randStr();
        System.out.println("You: " + input);
        System.out.println(" Bot: " + botChoice);
        if (botChoice.equals(input)) {
            System.out.println("Tie!");
        } else if ((botChoice.equals("rock") && input.equals("paper") )
                || (botChoice.equals("paper") && input.equals("scissors"))
                || (botChoice.equals("scissors") && input.equals("rock"))
        ) {
            System.out.println("You won!");
            yourScore++;
        }else {
            System.out.println("You lost!");
            botScore++;
        }
        System.out.println(("You: " + yourScore + " Bot: " + botScore));
        gameValid(type());
    }

    //Generate random choice
    static String randStr(){
        Random rand = new Random();
        int rand_num = rand.nextInt(3);
        String botChoice = null;

        if(rand_num == 0){
            botChoice = "paper";
        }else if (rand_num == 1){
            botChoice = "rock";
        }else {
            botChoice = "scissors";
        }

        return botChoice;
    }

    //Taking user input from keyboard
    static String type(){
        Scanner keyboard = new Scanner(System.in);
        String input = keyboard.next();
        return input;
    }

    //Checking the input
    static void gameValid(String input){

        if (input.matches("rock") || input.matches("scissors") || input.matches("paper")){
            checkWinner(input);
        }else if (input.matches("exit")){
            endGame();
        }else if (input.matches("reset")) {
            reset();
        }else {
            System.out.println("Type in rock, paper, or scissors to play.");
            gameValid(Main.type());
        }

    }


}
