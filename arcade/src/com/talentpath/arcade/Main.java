package com.talentpath.arcade;

import java.util.Scanner;

public class Main {

    //Taking user input from keyboard
    public static String type(){
        Scanner keyboard = new Scanner(System.in);
        String input = keyboard.next();
        return input.trim().toLowerCase();
    }

    //Begin Game
    static void beginGame(String input){
        if (input.matches("rps") || input.matches("rock paper scissors")) {
            System.out.println("Game started. Type exit to return to the start menu. Type reset to revert scores to 0. Type rock, paper, or scissors to play.");
            RPS.gameValid(type());
        } else {
            startMenu();
        }
    }

    //Start menu
    static void startMenu() {
        System.out.println("Type name of a game to begin playing.");
        System.out.println("-RPS (Rock Paper Scissors)");
        //System.out.println("-Psychic Game");
        //System.out.println("-Tic Tac Toe");
        beginGame(type());
    }

    //Driver class
    public static void main(String[] args) {
        startMenu();
    }



}
