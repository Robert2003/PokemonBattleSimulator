import Constants.Messages;
import Moves.Move;
import Pokemons.*;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class Main {
    public static void main(String[] args) {
        PokemonBattle battle;
        Random rand = new Random();
        List<Pokemon> pokemons = new ArrayList<>();
        List<Pokemon> upcasting = new ArrayList<>();
        int firstPokemon, secondPokemon;

        System.out.println(Messages.BATTLE_DEMONSTRATION);

        ElectricPokemon pikachu = new ElectricPokemon("Pikachu", 80);
        FirePokemon charizard = new FirePokemon("Charizard", 100);
        WaterPokemon blastoise = new WaterPokemon("Blastoise", 75);
        GrassPokemon venusaur = new GrassPokemon("Venusaur", 78);

        pikachu.addMove(new Move("Thunderbolt", "Electric", 31));
        pikachu.addMove(new Move("Nuzzle", "Electric", 11));
        pikachu.addMove(new Move("Quick Attack", "Electric", 19));

        charizard.addMove(new Move("Flamethrower", "Fire", 23));
        charizard.addMove(new Move("Ember", "Fire", 12));

        blastoise.addMove(new Move("Hydro Pump", "Water", 25));
        blastoise.addMove(new Move("Water Gun", "Water", 9));
        blastoise.addMove(new Move("Bite", "Dark", 16));

        venusaur.addMove(new Move("Solar Beam", "Grass", 27));
        venusaur.addMove(new Move("Petal Blizzard", "Grass", 18));
        venusaur.addMove(new Move("Tackle", "Grass", 10));
        venusaur.addMove(new Move("Razor Leaf", "Grass", 15));

        pokemons.add(pikachu);
        pokemons.add(charizard);
        pokemons.add(blastoise);
        pokemons.add(venusaur);

        /** Generate two pokemons */
        firstPokemon = rand.nextInt(pokemons.size());
        secondPokemon = rand.nextInt(pokemons.size());

        /** Make sure not to fight the same pokmon */
        while (secondPokemon == firstPokemon) {
            secondPokemon = rand.nextInt(pokemons.size());
        }

        battle = new PokemonBattle(pokemons.get(firstPokemon), pokemons.get(secondPokemon));
        battle.simulateBattle();

        System.out.println("\n" + Messages.CASTING_MESSAGE);

        /**
         * Demonstration of upcasting
         *
         * Parent instance = new Child();
         */
        Pokemon pokemon1 = new ElectricPokemon("Pikachu", 80);
        Pokemon pokemon2 = new FirePokemon("Charizard", 100);
        Pokemon pokemon3 = new WaterPokemon("Blastoise", 75);
        Pokemon pokemon4 = new GrassPokemon("Venusaur", 78);

        upcasting.add(pokemon1);
        upcasting.add(pokemon2);
        upcasting.add(pokemon3);
        upcasting.add(pokemon4);

        /**
         * Demonstration of downcasting
         *
         * If pokemon is an instance of a class, call a method specific to that class
         */
        for (Pokemon pokemon : upcasting) {
            if (pokemon instanceof ElectricPokemon) {
                pikachu = (ElectricPokemon) pokemon;
                pikachu.electricMethod();
            } else if (pokemon instanceof FirePokemon) {
                charizard = (FirePokemon) pokemon;
                charizard.fireMethod();
            } else if (pokemon instanceof WaterPokemon) {
                blastoise = (WaterPokemon) pokemon;
                blastoise.waterMethod();
            } else if (pokemon instanceof GrassPokemon) {
                venusaur = (GrassPokemon) pokemon;
                venusaur.grassMethod();
            }
        }
    }
}