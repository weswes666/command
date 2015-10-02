/**
 * Created by wessel on 30/09/2015.
 */
public class TurnTVOn implements Command {
    ElectronicDevice mDevice;

    TurnTVOn(ElectronicDevice device){
        this.mDevice = device;
    }

    @Override
    public void undoCommand() {
        System.out.println("TurnTVOn can't be undone");
    }

    @Override
    public void execute() {
        mDevice.on();
    }
}
