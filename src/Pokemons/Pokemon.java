package Pokemons;

import Moves.Move;

import java.util.ArrayList;
import java.util.List;

public class Pokemon {
    private String name;
    private int level;
    private String type;
    private List<Move> moves;

    public Pokemon(String name, int level, String type) {
        this.name = name;
        this.level = level;
        this.type = type;
        this.moves = new ArrayList<>();
    }

    public Pokemon() {
        this("Default Name", 100, "Default Type");
    }

    public Pokemon(Pokemon other) {
        this(other.getName(), other.getLevel(), other.getType());
    }

    public String getName() {
        return name;
    }

    public int getLevel() {
        return level;
    }

    public void setLevel(int level) {
        this.level = level;
    }

    public String getType() {
        return type;
    }

    public List<Move> getMoves() {
        return moves;
    }

    public void addMove(Move move) {
        moves.add(move);
    }

    public void printStats() {
        System.out.println(this.getName() + "(health: " + this.getLevel() + " type: " + this.getType() + ")");
    }

    @Override
    public String toString() {
        return "My name is " + getName() + " and I am " + getType() + " pokemon.";
    }

    /**
     * Check if obj is equal to this
     *
     * @param obj object to compare
     * @return true if the objects are equal, false otherwise
     */
    @Override
    public boolean equals(Object obj) {
        if (this == obj)
            return true;
        if (obj == null && obj.getClass() != this.getClass())
            return false;
        Pokemon other = (Pokemon) obj;

        return name.equals(other.name) &&
                level == other.level &&
                type.equals(other.type) &&
                moves.equals(other.moves);
    }
}
