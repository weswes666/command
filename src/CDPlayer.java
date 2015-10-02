/**
 * Created by wessel on 30/09/2015.
 */
public class CDPlayer implements ElectronicDevice {
    private int volume = 0;
    private boolean isOn = false;
    private boolean driveOn = false;

    public CDPlayer(){};
    private CDPlayer(int volume, boolean driveOn, boolean isOn) {
        this.volume = volume;
        this.driveOn = driveOn;
        this.isOn = isOn;
    }

    @Override
    public void on() {
        isOn = true;
        prntIsOn();
    }

    @Override
    public void off() {
        isOn = true;
        prntIsOn();
    }

    @Override
    public void volumeUp() {
        volume++;
        prntVolume();
    }

    @Override
    public void volumeDown() {
        volume--;
        prntVolume();
    }

    @Override
    public void starVisualDrive() {
        driveOn = true;
        prntDriveOn();
    }

    @Override
    public void stopVisualDrive() {
        driveOn = false;
        prntDriveOn();
    }

    @Override
    public void setVolume(int volume) {
        this.volume = volume;
        prntVolume();
    }

    @Override
    public ElectronicDevice clone() {
        return new CDPlayer(this.volume, this.driveOn, this.isOn);
    }

    private void prntDriveOn() {
        String driveOnString = driveOn ? "Running" : "Stopped";
        System.out.println("CDPlayer's CD drive is " + driveOnString);
    }

    private void prntVolume(){
        System.out.println("CDPlayer Volume is at " + volume);
    }

    private void prntIsOn(){
        String onString = isOn ? "ON" : "OFF";
        System.out.println("CDPlayer is " + onString);
    }
}
