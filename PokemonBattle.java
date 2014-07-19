import java.util.*;

public class PokemonBattle {
	private Trainer[] trainers;	
	private Battlefield field;// queue move history
	private boolean roundFinish;
	public static Scanner sc;
	

	public PokemonBattle(Trainer trainerA, Trainer trainerB) {
		this.trainers = new Trainer[2];
		trainers[0] = trainerA;
		trainers[1] = trainerB;
		field = new Battlefield(trainers);
		
		roundFinish = false;
		sc = new Scanner(System.in);
	}

	public void runBattle() {
		Collection<TrainerPreMove> preMoves = new ArrayList<TrainerPreMove>(getTrainerCount());
		Collection<TrainerBattleMove> battleMoves = new ArrayList<TrainerBattleMove>(getTrainerCount());
		
		while(!battleFinished()) {
			printBattleStatus();

			// have trainers decide their move!
			for(Trainer trainer : determineTrainerOrder()) {
				
				battleMoves.add(trainer.decideBattleMove(field));
				
			}

			
			// perform calculations
			for(TrainerBattleMove move : determineTrainerBattleMoveOrder(battleMoves)) {
				executeBattleMove(move);

				Pokemon enemy = move.getTrainerTarget().getFieldPokemon();
				if(enemy.hp <= 0) {
					enemy.isAlive = false;
					move.getTrainerTarget().getTeam().update();
					break;
				}
			}
			
			// do any other... effects
			battleMoves.clear();
			executeExtra();
		}
	}



	

	// EXECUTE STUFF
	protected void executePreMove(TrainerPreMove move) {
		System.out.print("\n\n\nMOVES HAPPENED\n\n\n");
	}

	protected void executeBattleMove(TrainerBattleMove move) {
		Pokemon user = move.getTrainer().getFieldPokemon();
		Pokemon enemy = move.getTrainerTarget().getFieldPokemon();

		int damage = move.getMove().use(user, enemy);
		//System.out.println(damage);
		enemy.hp -= damage;
	}

	protected void executeExtra() {

	}


	
	// DETERMINE STUFF
	protected Iterable<Trainer> determineTrainerOrder() {
		ArrayList<Trainer> trainerOrder = new ArrayList<Trainer>(getTrainerCount());		
		for(Trainer trainer : trainers) trainerOrder.add(trainer);		

		return trainerOrder;
	}

	protected Iterable<TrainerPreMove> determineTrainerPreMoveOrder(Collection<TrainerPreMove> moves) {
		return null;
	}

	protected Iterable<TrainerBattleMove> determineTrainerBattleMoveOrder(Collection<TrainerBattleMove> moves) {
		
		//TrainerBattleMove move1 = moves.get(1);
		return moves;
	}




	
	protected int getTrainerCount() {
		return trainers.length;
	}

	protected boolean battleFinished() {
		for(Trainer trainer : trainers) {
			if(trainer.getTeam().dead == 6) {
				return true;
			}
		}

		return false;
	}

	protected void printBattleStatus() {
		for(Trainer trainer : trainers) {
			Pokemon starter = trainer.getFieldPokemon();
			System.out.println(trainer.getId() + " " + starter.name + ": " + starter.hp);
		}
	}
}
