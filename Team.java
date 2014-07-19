import java.util.*;

public class Team {
	public int index;
	public int player; //Either 1 or 2
    public Pokemon p1;
    public Pokemon p2;
    public Pokemon p3;
    public Pokemon p4;
    public Pokemon p5;
    public Pokemon p6;
    public Pokemon starter;
    public int dead;

    public Team(int player) {
    	index = 1;
    	this.player = player;
    	dead = 0;
    }

    public void add(Pokemon p) {
    	if (index == 1) {
    		p1 = p;
    		starter = p1;
    	}
    	else if (index == 2) {
    		p2 = p;
    	}
    	else if (index == 3) {
    		p3 = p;
    	}
    	else if (index == 4) {
    		p4 = p;
    	}
    	else if (index == 5) {
    		p5 = p;
    	}
    	else if (index == 6) {
    		p6 = p;
    	}
    	else {
    		//Error message here
    	}
    	index++;
    }

    public void update() {
    	if (!starter.isAlive) {
    		if (dead == 0) {
    			starter = p2;
    		}
    		else if (dead == 1) {
    			starter = p3;
    		}
    		else if (dead == 2) {
    			starter = p4;
    		}
    		else if (dead == 3) {
    			starter = p5;
    		}
    		else if (dead == 4) {
    			starter = p6;
    		}
    		else if (dead == 5) {
    			//Do Game Over stuff here
    		}
    		dead++;
		}
    }


}