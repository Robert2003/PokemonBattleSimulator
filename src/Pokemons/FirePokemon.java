package Pokemons;

import Constants.Messages;

public class FirePokemon extends Pokemon {
    public FirePokemon(String name, int level) {
        super(name, level, "Fire");
    }

    public FirePokemon() {
        super();
    }

    public FirePokemon(Pokemon other) {
        super(other);
    }

    /**
     * Method specific to this class
     */
    public void fireMethod() {
        System.out.println(Messages.FIRE_MESSAGE);
    }
}
