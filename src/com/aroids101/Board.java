package com.aroids101;

// Created by Eli on 3/6/17.

class Board
{
    private int boardSize_X = 3, boardSize_Y = 3/*, connectSize = 3*/;
    private char[][] visual = new char[boardSize_X][boardSize_Y];
    //private int[][] weight = new int[boardSize_X][boardSize_Y];

    Board()
    {
        for(int i=0; i<visual.length; i++)
        {
            for(int j=0; j<visual[0].length; j++)
            {
                visual[i][j] = ' ';
            }
        }
    }

    void print_board()
    {
        System.out.println(" _____");
        System.out.println("|" + visual[0][2] + "|" + visual[1][2] + "|" + visual[2][2] + "|");
        System.out.println("|" + visual[0][1] + "|" + visual[1][1] + "|" + visual[2][1] + "|");
        System.out.println("|" + visual[0][0] + "|" + visual[1][0] + "|" + visual[2][0] + "|");
    }

    boolean setVisual(int x, int y, char character)
    {
        if(visual[x][y] == ' ')
        {
            visual[x][y] = character;
            return true;
        }
        return false;
    }

    char getVisual(int x, int y)
    {
        return visual[x][y];
    }

    boolean won(int x, int y, char character)
    {
        /*
         * take x, y and look at the row, column and diagonal it's in
         * and check to see if it's a win.
         *
         */

        return searchColumn(x, character) || searchRow(y, character) || searchDiagonal(x, y, character);
    }

    private boolean searchColumn(int column, char character)
    {
        boolean rValue = visual[column][0] == character;

        for(int i=0; i<boardSize_Y; i++)
        {
            rValue = rValue && visual[column][i] == character;
        }

        return rValue;
    }

    private boolean searchRow(int row, char character)
    {
        boolean rValue = visual[0][row] == character;

        for(int i=0; i<boardSize_X; i++)
        {
            rValue = rValue && visual[i][row] == character;
        }

        return rValue;
    }

    private boolean searchDiagonal(int x, int y, char character)
    {
        boolean f_slash = visual[0][2] == character && visual[1][1] == character && visual[2][0] == character;
        boolean b_slash = visual[0][0] == character && visual[1][1] == character && visual[2][2] == character;
        return f_slash || b_slash;
    }

    boolean tie(int x, int y, char character)
    {
        boolean visualIsFull = visual[0][0] != ' ';

        for(int i=0; i<visual.length; i++)
        {
            for(int j=1; j<visual[0].length; j++)
            {
                visualIsFull = visualIsFull && visual[i][j] != ' ';
            }
        }

        return !won(x, y, character) && visualIsFull;
    }
}
