import java.util.*;

public abstract class Trainer {
	

	public abstract int getId();
	public abstract Pokemon getFieldPokemon();

	public abstract TrainerPreMove decidePreMove(Battlefield field);
	public abstract TrainerBattleMove decideBattleMove(Battlefield field);
}
