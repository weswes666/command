/**
 * Created by wessel on 30/09/2015.
 */
public interface Command {

    void undoCommand();
    void execute();

}
