import java.io.*;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Random;
import java.util.Scanner;

public class Pokemon {
    
    public boolean isAlive;
    public String name;
    public int dexNumber;
    public Type type1;
    public Type type2;
    public int hp;
    public int attack;
    public int defense;
    public int specialAttack;
    public int specialDefense;
    public int speed;

    public Move[] movePool;
    public String[][] stats;

    public Pokemon(String pokemonName) {
        int index = -1;
        stats = textToArray();
	
	//System.out.println(pokemonName);
        // iterate through stats and find index of pokemonName
        for (int i = 0; i < stats.length; i++) {
            for (int j = 0; j < stats[0].length; j++) {
                if (stats[i][j].equals(pokemonName.toLowerCase())) {
                    index = i;
                }
            }
        }
        if (index < 0 && stats[index][0] != pokemonName) {
            throw new IllegalArgumentException("This pokemon does not exist");
        }
            isAlive = true;
            name = stats[index][0];
            dexNumber = Integer.parseInt(stats[index][1]);
            type1 = new Type(stats[index][2]);
            type2 = new Type(stats[index][3]);
            hp = Integer.parseInt(stats[index][4]);
            attack = Integer.parseInt(stats[index][5]);
            defense = Integer.parseInt(stats[index][6]);
            specialAttack = Integer.parseInt(stats[index][7]);
            specialDefense = Integer.parseInt(stats[index][8]);
            speed = Integer.parseInt(stats[index][9]);
            movePool = createMovePool();

    }

    public static Move[] createMovePool() {
        Move[] movePool = new Move[4];
        movePool[0] = new Move("Hydro Pump", 120, 5, 80, new Type("water"));
        movePool[1] = new Move("Fire Blast", 120, 5, 85, new Type("fire"));
        movePool[2] = new Move("Ice Punch", 75, 15, 100, new Type("ice"));
        movePool[3] = new Move("Thunderbolt", 95, 15, 100, new Type("electric"));
        return movePool;
    }


    public String[][] textToArray() {
	try {
        String[][] output = new String [151][10];
        Scanner scan = new Scanner(new File("stats.txt"));
        
        for (int i = 0; i < output.length; i++) {
            for (int j = 0; j < output[0].length; j++) {
                if (!scan.hasNext()) {
                    throw new IllegalArgumentException("error with scanner");
                }
                output[i][j] = scan.next();
            }
        }
	
        return output;
	} catch(Exception e) {}

	return null;
    }
}
