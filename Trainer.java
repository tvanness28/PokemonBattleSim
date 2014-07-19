import java.util.*;

public abstract class Trainer {
	
	public abstract void setFieldPokemon(Pokemon pokemon);

	public abstract int getId();
	public abstract Team getTeam();
	public abstract Pokemon getFieldPokemon();


	public abstract TrainerPreMove decidePreMove(Battlefield field);
	public abstract TrainerBattleMove decideBattleMove(Battlefield field);
}
