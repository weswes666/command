package Commands;

import Commands.Command;
import devices.ElectronicDeviceStateCaretaker;

/**
 * Created by wessel on 04/10/2015.
 */
public class UndoLastCommand implements Command {
    ElectronicDeviceStateCaretaker mCaretaker;

    public UndoLastCommand(ElectronicDeviceStateCaretaker caretaker){
        mCaretaker = caretaker;
    }

    @Override
    public void execute() {
        mCaretaker.restore();
    }
}
