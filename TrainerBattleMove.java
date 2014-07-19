public class TrainerBattleMove {
	private String command;
	private Trainer trainer;
	private Move move;
	private Trainer trainerTarget;

	public TrainerBattleMove(String command, Trainer trainer, Trainer trainerTarget, Move move) {
		this.command = command;
		this.trainer = trainer;
		this.move = move;
		this.trainerTarget = trainerTarget;
	}

	public String getCommand() {
		return command;
	}

	public Trainer getTrainer() {
		return trainer;
	}

	public Trainer getTrainerTarget() {
		return trainerTarget;
	}

	public Move getMove() {
		return move;
	}
}
