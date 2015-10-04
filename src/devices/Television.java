package devices;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by wessel on 30/09/2015.
 */
public class Television extends AbstractElectronicDevice {
    public Television(){
        super();
    }

    protected void prntDriveOn() {
        String driveOnString = super.driveOn ? "Running" : "Stopped";
        System.out.println("devices.Television's DVD drive is " + driveOnString);
    }

    protected void prntVolume(){
        System.out.println("devices.Television Volume is at " + super.volume);
    }

    protected void prntIsOn(){
        String onString = super.isOn ? "ON" : "OFF";
        System.out.println("devices.Television is " + onString);
    }
}
