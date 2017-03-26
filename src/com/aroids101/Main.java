package com.aroids101;

import java.util.Scanner;

public class Main
{
    public static void main(String[] args)
    {
        Scanner reader = new Scanner(System.in);

        System.out.println("Welcome to Tic Tac Toe!");
        Menu m = new Menu();

        while(m.continue_game())
        {
            Player player0 = new Player();
            Player player1 = new Player();
            Board board = new Board();

            System.out.println("Would you like to play against the computer or a human bean?");
            System.out.print("Enter 1 for human bean, 2 for computer: ");
            String input = reader.next();

            System.out.print("Player0 what is your name: ");
            player0.setName(reader.next());
            player0.setCharacter('X');

            if(input.equals("1"))
            {
                System.out.print("Player1 what is your name: ");
                player1.setName(reader.next());
                player1.setCharacter('O');
            }
            else {
                System.out.println("This feature is not implemented yet.");
                break;

                //player1.setIs_AI();
            }

            Player[] p = new Player[] {player0, player1};
            int whose_turn = 0;

            while(true)
            {
                int x, y;
                board.print_board();

                System.out.print(p[whose_turn].getName() + ", Enter your coordinates: ");
                String coordinates = reader.next();

                x = Integer.parseInt(coordinates.substring(0, 1));
                y = Integer.parseInt(coordinates.substring(1));

                while (!board.setVisual(x, y, p[whose_turn].getCharacter()))
                {
                    String name;
                    if(p[0].hasCharacter(board.getVisual(x, y)))
                    {
                        name = p[0].getName();
                    }
                    else {
                        name = p[1].getName();
                    }

                    if(p[whose_turn].getName().equals(name))
                    {
                        System.out.println("You already chose that spot.");
                    }
                    else {
                        System.out.println(name + " has already gone there.");
                    }

                    System.out.print("Please chose another spot: ");
                    coordinates = reader.next();

                    x = Integer.parseInt(coordinates.substring(0, 1));
                    y = Integer.parseInt(coordinates.substring(1));
                }

                if(board.won(x, y, p[whose_turn].getCharacter()))
                {
                    board.print_board();
                    System.out.println("Congratulations " + p[whose_turn].getName() + "! You won!");
                    break;
                }
                if(board.tie(x, y, p[whose_turn].getCharacter()))
                {
                    board.print_board();
                    System.out.println("You tied!");
                    break;
                }

                if(whose_turn == 0)
                {
                    whose_turn = 1;
                }
                else {
                    whose_turn = 0;
                }
            }
        }

        System.out.println("Good Bye. Thanks for playing!");
    }
}
