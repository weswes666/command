import devices.CDPlayer;
import devices.ElectronicDevice;
import devices.Television;

/**
 * Created by wessel on 30/09/2015.
 */
public class UniversalRemote {
    public static ElectronicDevice getDevice(String type){
        switch (type){
            case "TV":
                return new Television();
            case "CD":
                return new CDPlayer();
            default:
                return new Television();
        }
    }
}
