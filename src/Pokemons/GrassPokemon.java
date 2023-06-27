package Pokemons;

import Constants.Messages;

public class GrassPokemon extends Pokemon {
    public GrassPokemon(String name, int level) {
        super(name, level, "Grass");
    }

    public GrassPokemon() {
        super();
    }

    public GrassPokemon(Pokemon other) {
        super(other);
    }

    /**
     * Method specific to this class
     */
    public void grassMethod() {
        System.out.println(Messages.GRASS_MESSAGE);
    }
}
