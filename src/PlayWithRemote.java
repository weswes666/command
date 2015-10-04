import Commands.*;
import devices.ElectronicDevice;
import devices.ElectronicDeviceStateCaretaker;

/**
 * Created by wessel on 30/09/2015.
 */
public class PlayWithRemote {

    public static void main(String[] args) {
        ElectronicDevice newDevice = UniversalRemote.getDevice("TV");
        Command undoCommandTV = new UndoLastCommand(new ElectronicDeviceStateCaretaker(newDevice));
        Command onCommand = new TurnTVOn(newDevice);
        DeviceButton onPressed1 = new DeviceButton(onCommand);
        DeviceButton onPressed2 = new DeviceButton(undoCommandTV);

        onPressed1.press();
        onPressed2.press();

        newDevice = UniversalRemote.getDevice("CD");
        Command undoCommandCD = new UndoLastCommand(new ElectronicDeviceStateCaretaker(newDevice));
        Command complexCommandCD = new ComplexCommand(newDevice);
        Command ofCommandCD = new TurnTVOf(newDevice);
        DeviceButton onPressed3 = new DeviceButton(undoCommandCD);
        DeviceButton onPressed4 = new DeviceButton(complexCommandCD);
        DeviceButton onPressed5 = new DeviceButton(ofCommandCD);

        onPressed4.press();
        onPressed3.press();
        onPressed5.press();
        onPressed3.press();

    }

}
