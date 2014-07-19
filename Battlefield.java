import java.util.*;

public class Battlefield {
	Map<Integer, Trainer> trainers;

	public Battlefield(Trainer[] trainers) {
		this.trainers = new HashMap<Integer, Trainer>();
		
		for(Trainer trainer : trainers) {
			this.trainers.put(trainer.getId(), trainer);
		}
	}

	public Collection<Trainer> getTrainers() {
		return trainers.values();
	}

	public Trainer getTrainer(int id) {
		return trainers.get(id);
	}

	public Collection<Pokemon> getFieldPokemon() {
		Collection<Pokemon> pokemons = new ArrayList<Pokemon>(trainers.size());;
		for(Trainer trainer : getTrainers()) {
			pokemons.add(trainer.getFieldPokemon());
		}

		return pokemons;
	}

	public Pokemon getFieldPokemon(int trainerId) {
		return trainers.get(trainerId).getFieldPokemon();
	}
}
