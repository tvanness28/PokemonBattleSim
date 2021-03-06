public class Move {
    private String name;
    private int power;
    private int pp;
    private int accuracy;
    //private int secondaryChance;
    private int critChance;
    //private String secondary;
    private Type type;
    
    public Move(String name, int power, int pp, int accuracy, Type type) {
        this.name = name;
        this.power = power;
        this.pp = pp;
        this.accuracy = accuracy;
        this.type = type;
    }
    
    public int use(Pokemon p1, Pokemon p2) {
        boolean stab = (p1.type1).equals(type);
        double stabModifier = 1.0;
        if (stab) {
            stabModifier = 1.5;
        }
        
        double damage = 0;
        if (pp > 0) {
            int random = (int) (Math.random() * 38 + 217);
            //if (type.isPhysical) {
                damage = ((42.0 * p1.attack * power) / (double)p2.defense / 50.0 + 2.0) / 10.0 * (double)random / 255.0; 
            //}
        }
        
        return (int)damage;
        /*
        else {
            throw new OutOfPPException("No more PP for that Move");
        } */
    }

	public String getName() {
		return name;
	}

}
