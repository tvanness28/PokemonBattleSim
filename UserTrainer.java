import java.util.*;
import java.io.*;

public class UserTrainer extends Trainer {
	private int id;
	private Team team;
	private Pokemon fieldPokemon;

	public UserTrainer(int id, Team team) {
		this.id = id;
		this.team = team;
	}

	@Override
	public int getId() {
		return id;
	}

	@Override
	public Team getTeam() {
		return team;
	}

	@Override
	public Pokemon getFieldPokemon() {
		return team.starter;
	}

	@Override
	public void setFieldPokemon(Pokemon pokemon) {
		// DO NOTHING
		this.fieldPokemon = pokemon;
	}


	@Override
	public TrainerPreMove decidePreMove(Battlefield field) {
		// skip! wheeeeeeee
		return null;
	}

	@Override
	public TrainerBattleMove decideBattleMove(Battlefield field) {
		try {
			//Scanner sc = new Scanner(System.in);
			boolean decided = false;

			while(true) {
				String[] commandParts = PokemonBattle.sc.nextLine().split(" ");
				if(commandParts.length >= 2) {
					String command = commandParts[0];
					String commandTarget = commandParts[1];

					if("use".equals(command)) {
						int move = Integer.parseInt(commandTarget);
						Trainer enemy = (id == 0) ? field.getTrainer(1) : field.getTrainer(0);
						/*for(Trainer trainer : field.getTrainers()) {
							if(!trainer.equals(this)) {
								enemy = trainer;
								break;
							}
						}*/
					
						
						return new TrainerBattleMove("use", this, enemy, getFieldPokemon().movePool[move]);
					} else {
						continue;
					}
				}
			}
		} catch(Exception e) {
			e.printStackTrace();
		}

		return null;
	}
}
