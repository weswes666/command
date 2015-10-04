package Commands;

import Commands.Command;
import devices.ElectronicDevice;

/**
 * Created by wessel on 30/09/2015.
 */
public class TurnTVOf implements Command {
    ElectronicDevice mDevice;

    public TurnTVOf(ElectronicDevice device){
        this.mDevice = device;
    }

    @Override
    public void execute() {
        mDevice.off();
    }
}
