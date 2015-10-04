package devices;

import devices.ElectronicDevice;
import devices.Memento;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by wessel on 30/09/2015.
 */
public class Television implements ElectronicDevice {
    private int volume = 0;
    private boolean isOn = false;
    private boolean driveOn = false;
    private List<ElectronicDeviceStateCaretaker> mCaretakers = new ArrayList<>();

    public Television(){};
    private Television(int volume, boolean driveOn, boolean isOn) {
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
    public Memento createMemento() {
        Map<String, Object> state = new HashMap<>();


        return new Memento(state);
    }

    @Override
    public void setMemento(Memento memento) {

    }

    @Override
    public void suscribe(ElectronicDeviceStateCaretaker caretaker) {
        mCaretakers.add(caretaker);
    }

    private void notifyObservers(){
        mCaretakers.stream()
                .forEach(ElectronicDeviceStateCaretaker::update);
    }

    private void prntDriveOn() {
        String driveOnString = driveOn ? "Running" : "Stopped";
        System.out.println("TV's DVD drive is " + driveOnString);
    }

    private void prntVolume(){
        System.out.println("TV Volume is at " + volume);
    }

    private void prntIsOn(){
        String onString = isOn ? "ON" : "OFF";
        System.out.println("TV is " + onString);
    }

}
