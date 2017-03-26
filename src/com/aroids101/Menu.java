package com.aroids101;
import java.util.Scanner;

// Created by Eli on 3/6/17.

class Menu
{
    boolean continue_game()
    {
        Scanner reader = new Scanner(System.in);

        System.out.print("Enter 1 to play, 2 to exit: ");
        String input = reader.next();

        return input.equals("1");
    }
}
