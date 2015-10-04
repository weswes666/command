import Commands.Command;
import Commands.ComplexCommand;
import Commands.TurnTVOn;
import devices.ElectronicDevice;

/**
 * Created by wessel on 30/09/2015.
 */
public class PlayWithRemote {

    public static void main(String[] args) {
        ElectronicDevice newDevice = UniversalRemote.getDevice("TV");

        Command onCommand = new TurnTVOn(newDevice);

        DeviceButton onPressed = new DeviceButton(onCommand);

        onPressed.press();

        newDevice = UniversalRemote.getDevice("CD");

        Command complexCommand = new ComplexCommand(newDevice);

        onPressed = new DeviceButton(complexCommand);

        onPressed.press();

    }

}
