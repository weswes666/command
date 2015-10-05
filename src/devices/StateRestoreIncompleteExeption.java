package devices;

/**
 * Created by wessel on 04/10/2015.
 */
public class StateRestoreIncompleteExeption extends Exception {
    public StateRestoreIncompleteExeption(){
        super("a state could not be recovered!");
    }

    public StateRestoreIncompleteExeption(String message){
        super(message);
    }
}
