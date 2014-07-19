import java.util.*;

public class Type {
    public String type;
    public boolean isPhysical;
    public int number;
    
    public Type(String t) {
        type = t;
        if (type.equals("none")) {
            type = null;
            number = 0;
        }
        else if (type.equals("Normal")) {
            number = 0;
        }
        else if (type.equals("Fighting")) {
            number = 1;
        }
        else if (type.equals("Flying")) {
            number = 2;
        }
        else if (type.equals("Poison")) {
            number = 3;
        }
        else if (type.equals("Ground")) {
            number = 4;
        }
        else if (type.equals("Rock")) {
            number = 5;
        }
        else if (type.equals("Bug")) {
            number = 6;
        }
        else if (type.equals("Ghost")) {
            number = 7;
        }
        else if (type.equals("Fire")) {
            number = 8;
        }
        else if (type.equals("Water")) {
            number = 9;
        }
        else if (type.equals("Grass")) {
            number = 10;
        }
        else if (type.equals("Electric")) {
            number = 11;
        }
        else if (type.equals("Psychic")) {
            number = 12;
        }
        else if (type.equals("Ice")) {
            number = 13;
        }
        else if (type.equals("Dragon")) {
            number = 14;
        }
        else {
            //InvalidType;
        }
        
        ArrayList<String> physical = new ArrayList<String>();
        physical.add("Normal");
        physical.add("Fighting");
        physical.add("Poison");
        physical.add("Ground");
        physical.add("Flying");
        physical.add("Bug");
        physical.add("Rock");
        physical.add("Ghost");
        if (physical.contains(t)) {
            isPhysical = true;
        }
        else {
            isPhysical = false;
        }
    }
    
    public boolean equals(Type t) {
        return (type.equals(t));
    }
    
    public double typeModifier(Type t) {
        double[][] typeModifier = new double[][] {
        {1, 1, 1, 1, 1, .5, 1, 0, 1, 1, 1, 1, 1, 1, 1}, 
        {2, 1, .5, .5, 1, 2, .5, 0, 1, 1, 1, 1, .5, 2, 1},
        {1, 2, 1, 1, 1, .5, 2, 1, 1, 1, 2, .5, 1, 1, 1},
        {1, 1, 1, .5, .5, .5, 2, .5, 1, 1, 2, 1, 1, 1, 1},
        {1, 1, 0, 2, 1, 2, .5, 1, 2, 1, .5, 2, 1, 1, 1},
        {1, .5, 2, 1, .5, 1, 2, 1, 2, 1, 1, 1, 1, 2, 1},
        {1, .5, .5, 2, 1, 1, 1, .5, .5, 1, 2, 1, 2, 1, 1},
        {0, 1, 1, 1, 1, 1, 1, 2, 1, 1, 1, 1, 0, 1, 1},
        {1, 1, 1, 1, 1, .5, 2, 1, .5, .5, 2, 1, 1, 2, .5},
        {1, 1, 1, 1, 2, 2, 1, 1, 2, .5, .5, 1, 1, 1, .5},
        {1, 1, .5, .5, 2, 2, .5, 1, .5, 2, .5, 1, 1, 1, .5},
        {1, 1, 2, 1, 0, 1, 1, 1, 1, 2, .5, .5, 1, 1, .5},
        {1, 2, 1, 2, 1, 1, 1, 1, 1, 1, 1, 1, .5, 1, 1},
        {1, 1, 2, 1, 2, 1, 1, 1, 1, .5, 2, 1, 1, .5, 2},
        {1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 2}
        };
        return typeModifier[number][t.number];
    }
        
}