import java.util.Stack;

/**
 * Created by wessel on 01/10/2015.
 */
public class ComplexCommand implements Command {
    private ElectronicDevice mDevice;
    private Stack<ElectronicDevice> mDeviceStates = new Stack<>();

    private ComplexCommand(){};
    ComplexCommand(ElectronicDevice device){
        mDevice = device;
    }

    @Override
    public void undoCommand() {
        if (!mDeviceStates.empty()){
            mDevice = mDeviceStates.pop();
            System.out.println("Command is undone.");
        }else {
            System.out.println("No command to undo.");
        }
    }

    @Override
    public void execute() {
        mDeviceStates.push(mDevice.clone());
        mDevice.on();
        mDevice.starVisualDrive();
        mDevice.setVolume(11);
    }
}
