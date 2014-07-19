import java.util.*;

public class PokemonBattle {
	private Trainer[] trainers;	
	private Battlefield field;
	// queue move history

	public PokemonBattle(Trainer trainerA, Trainer trainerB) {
		this.trainers = new Trainer[2];
		trainers[0] = trainerA;
		trainers[1] = trainerB;
	}

	public void runBattle() {
		Collection<TrainerPreMove> preMoves = new ArrayList<TrainerPreMove>(getTrainerCount());
		Collection<TrainerBattleMove> battleMoves = new ArrayList<TrainerBattleMove>(getTrainerCount());
		
		while(!battleFinished()) {
			// before battle (like choose new pokemon, etc)
			for(Trainer trainer : determineTrainerOrder()) {
				preMoves.add(trainer.decidePreMove(field));
			}

			for(TrainerPreMove move : determineTrainerPreMoveOrder(preMoves)) {
				executePreMove(move);
			}
		
			// END PREMOVE PHASE
			preMoves.clear();
			printBattleStatus();
			




			// have trainers decide their move!
			for(Trainer trainer : determineTrainerOrder()) {
				battleMoves.add(trainer.decideBattleMove(field));
			}

			
			// perform calculations
			for(TrainerBattleMove move : determineTrainerBattleMoveOrder(battleMoves)) {
				executeBattleMove(move);
			}
			
			// do any other... effects
			battleMoves.clear();
			executeExtra();
			printBattleStatus();
		}
	}



	

	// EXECUTE STUFF
	protected void executePreMove(TrainerPreMove move) {
		// do stuff lol
	}

	protected void executeBattleMove(TrainerBattleMove move) {
		// do stuff lol
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
		return null;
	}




	
	protected int getTrainerCount() {
		return trainers.length;
	}

	protected boolean battleFinished() {
		return true; // lol
	}

	protected void printBattleStatus() {
		// do nothing! YAY! well not yet :P
	}
}
