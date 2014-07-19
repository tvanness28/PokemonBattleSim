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
	public Pokemon getFieldPokemon() {
		return fieldPokemon;
	}


	@Override
	public TrainerPreMove decidePreMove(Battlefield field) {
		// skip! wheeeeeeee
		return null;
	}

	@Override
	public TrainerBattleMove decideBattleMove(Battlefield field) {
		try {
			Scanner sc = new Scanner(System.in);
			boolean decided = false;

			while(true) {
				String[] commandParts = sc.nextLine().split(" ");
				if(commandParts.length >= 2) {
					String command = commandParts[0];
					String commandTarget = commandParts[1];

					if("use".equals(command)) {
						// iono do something lol						
						break;
					} else {
						continue;
					}
				}
			}

			sc.close();
		} catch(Exception e) {
			e.printStackTrace();
		}

		return null;
	}
}
