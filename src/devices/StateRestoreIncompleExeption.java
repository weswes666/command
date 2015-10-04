package devices;

/**
 * Created by wessel on 04/10/2015.
 */
public class StateRestoreIncompleExeption extends Exception {
    public StateRestoreIncompleExeption(){
        super("a state could not be recovered!");
    }

    public StateRestoreIncompleExeption(String message){
        super(message);
    }
}
