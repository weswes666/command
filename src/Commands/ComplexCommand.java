package Commands;

import Commands.Command;
import devices.ElectronicDevice;
import devices.Memento;

import java.util.Stack;

/**
 * Created by wessel on 01/10/2015.
 */
public class ComplexCommand implements Command {
    private ElectronicDevice mDevice;
    private Stack<Memento> mDeviceStates = new Stack<>();

    public ComplexCommand(ElectronicDevice device){
        mDevice = device;
    }

    @Override
    public void execute() {
        mDeviceStates.push(mDevice.createMemento());
        mDevice.on();
        mDevice.starVisualDrive();
        mDevice.setVolume(11);
    }
}
