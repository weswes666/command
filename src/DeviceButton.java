/**
 * Created by wessel on 30/09/2015.
 */
public class DeviceButton {
    private Command mCommand;

    public DeviceButton(Command command) {
        this.mCommand = command;
    }

    public void press(){
        mCommand.execute();
    }

}
