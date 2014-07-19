import java.util.ArrayList;
import java.util.Arrays;
import java.util.Random;

public class Status {
    public String myStatus;
    private static final ArrayList<String> STATUS_LIST = (ArrayList) Arrays.asList("Burn", "Freeze", "Paralysis", "Poison", "Sleep");
    Random rand = new Random();
    
    public Status() {
        myStatus = STATUS_LIST.get(rand.nextInt(4));
    }
}
