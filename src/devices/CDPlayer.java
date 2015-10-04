package devices;

/**
 * Created by wessel on 30/09/2015.
 */
public class CDPlayer extends AbstractElectronicDevice {

    public CDPlayer(){
        super();
    }

    protected void prntDriveOn() {
        String driveOnString = super.driveOn ? "Running" : "Stopped";
        System.out.println("devices.CDPlayer's CD drive is " + driveOnString);
    }

    protected void prntVolume(){
        System.out.println("devices.CDPlayer Volume is at " + super.volume);
    }

    protected void prntIsOn(){
        String onString = super.isOn ? "ON" : "OFF";
        System.out.println("devices.CDPlayer is " + onString);
    }

}
