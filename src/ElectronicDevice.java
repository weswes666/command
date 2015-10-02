/**
 * Created by wessel on 30/09/2015.
 */
public interface ElectronicDevice {

    void on();
    void off();
    void volumeUp();
    void volumeDown();
    void starVisualDrive();
    void stopVisualDrive();
    void setVolume(int volume);
    ElectronicDevice clone();

}
