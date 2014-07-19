
public class Main {

    public static void main(String[] args) {
        Team pokemon1 = new Team(0);
        Pokemon pikachu = new Pokemon("Pikachu");
        Pokemon bulbasaur = new Pokemon("Bulbasaur");
        Pokemon mewtwo = new Pokemon("Mewtwo");
        Pokemon venusaur = new Pokemon("Venusaur");
        Pokemon charizard = new Pokemon("Charizard");
        Pokemon eevee = new Pokemon("Eevee");
        pokemon1.add(pikachu);
        pokemon1.add(bulbasaur);
        pokemon1.add(mewtwo);
        pokemon1.add(venusaur);
        pokemon1.add(charizard);
        pokemon1.add(eevee);
	Trainer ash = new UserTrainer(0, pokemon1);        

        
        Team pokemon2 = new Team(1);
        Pokemon nidoking = new Pokemon("Nidoking");
        Pokemon raidon = new Pokemon("Rhydon");
        Pokemon jigglypuff = new Pokemon("Jigglypuff");
        Pokemon charmander = new Pokemon("charmander");
        Pokemon aerodactyl = new Pokemon("Aerodactyl");
        Pokemon articuno = new Pokemon("Articuno");
        pokemon2.add(nidoking);
        pokemon2.add(raidon);
        pokemon2.add(jigglypuff);
        pokemon2.add(charmander);
        pokemon2.add(aerodactyl);
        pokemon2.add(articuno);
	Trainer gary = new UserTrainer(1, pokemon2);       

 
	PokemonBattle swag = new PokemonBattle(ash, gary);
        swag.runBattle();
        
    }

}
