package Pokemons;

import Constants.Messages;

public class ElectricPokemon extends Pokemon {
    public ElectricPokemon(String name, int level) {
        super(name, level, "Electric");
    }

    public ElectricPokemon() {
        super();
    }

    public ElectricPokemon(Pokemon other) {
        super(other);
    }

    /**
     * Method specific to this class
     */
    public void electricMethod() {
        System.out.println(Messages.ELECTRIC_MESSAGE);
    }
}
