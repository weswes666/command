/**
 * Created by wessel on 30/09/2015.
 */
public class TurnTVOf implements Command {
    ElectronicDevice mDevice;

    TurnTVOf(ElectronicDevice device){
        this.mDevice = device;
    }

    @Override
    public void undoCommand() {
        System.out.println("TurnTVOf can't be undone");
    }

    @Override
    public void execute() {
        mDevice.off();
    }
}
