import Constants.Messages;
import Moves.Move;
import Pokemons.Pokemon;

import java.util.Random;

import static java.lang.Math.min;

class PokemonBattle {
    private Pokemon pokemon1;
    private Pokemon pokemon2;
    private Random rand = new Random();

    public PokemonBattle(Pokemon pokemon1, Pokemon pokemon2) {
        this.pokemon1 = pokemon1;
        this.pokemon2 = pokemon2;
    }

    /**
     * Function that simulates a battle between pokemon1 and pokemon2
     */
    public void simulateBattle() {
        /** Check if the pokemons are the same */
        if (pokemon1.equals(pokemon2)) {
            System.out.println(Messages.IDENTICAL_POKEMONS_ERROR);
            return;
        }

        System.out.println(pokemon1.getName() + Messages.INTRODUCE_BATTLE + pokemon2.getName());
        pokemon1.printStats();
        pokemon2.printStats();
        System.out.println(Messages.START_MESSAGE);
        System.out.println();

        /** Get the pokemon that will start the battle */
        Pokemon attacker = getFirstAttacker();
        /** Get another pokemon, different by the attacker */
        Pokemon defender = getSecondAttacker(attacker);

        while (pokemon1.getLevel() > 0 && pokemon2.getLevel() > 0) {
            /** Get a random move from attacker's list */
            Move attack = getRandomMove(attacker);
            /** Calculate the damage so the hp doesn't go below 0 hp */
            int damage = min(attack.getPower(), defender.getLevel());

            /** Deal damage */
            defender.setLevel(defender.getLevel() - damage);

            System.out.println(attacker.getName() + " used " + attack.getName() + " on " + defender.getName());
            System.out.println(defender.getName() + " received " + damage + " damage");
            defender.printStats();
            System.out.println();

            /** Swap attacker and defender, to make the battle correct */
            Pokemon aux = attacker;
            attacker = defender;
            defender = aux;
        }

        /** Check who is the winner */
        if (pokemon1.getLevel() > 0) {
            System.out.println(pokemon1.getName() + Messages.WIN_MESSAGE);
        } else {
            System.out.println(pokemon2.getName() + Messages.WIN_MESSAGE);
        }
    }

    /**
     * Get a random between 0 and 1
     *
     * @return first attacker
     */
    private Pokemon getFirstAttacker() {
        int number = rand.nextInt(2);

        if (number == 0) return pokemon1;
        return pokemon2;
    }

    /**
     * Get the defender
     *
     * @param first The chosen attacker
     * @return The other pokemon
     */
    private Pokemon getSecondAttacker(Pokemon first) {
        if (first.equals(pokemon1)) return pokemon2;
        return pokemon1;
    }

    /**
     * Get a random move from pokemon's list of moves
     *
     * @param pokemon The pokemon's whose move should be randomised
     * @return The random move
     */
    private Move getRandomMove(Pokemon pokemon) {
        int index = rand.nextInt(pokemon.getMoves().size());
        return pokemon.getMoves().get(index);
    }
}
