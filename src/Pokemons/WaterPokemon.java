package Pokemons;

import Constants.Messages;

public class WaterPokemon extends Pokemon {
    public WaterPokemon(String name, int level) {
        super(name, level, "Water");
    }

    public WaterPokemon() {
        super();
    }

    public WaterPokemon(Pokemon other) {
        super(other);
    }

    /**
     * Method specific to this class
     */
    public void waterMethod() {
        System.out.println(Messages.WATER_MESSAGE);
    }
}
