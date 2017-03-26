package com.aroids101;

// Created by Eli on 3/6/17.

class Player
{
    private String name;
    private char character;
    private boolean is_AI;

    void setName(String name)
    {
        this.name = name;
    }

    String getName()
    {
        return name;
    }

    boolean hasCharacter(char character)
    {
        return this.character == character;
    }

    void setCharacter(char character)
    {
        this.character = character;
    }

    char getCharacter() { return character; }

    void setIs_AI()
    {
        is_AI = true;
    }
}
