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
    private static final String VOLUME_TYPE = "java.lang.Integer";
    private static final String IS_ON_TYPE = "java.lang.Boolean";
    private static final String DRIVE_ON_TYPE = "java.lang.Boolean";
    private static final String VOLUME = "volume";
    private static final String IS_ON = "isOn";
    private static final String DRIVE_ON = "driveOn";

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
        prntIsOn();
        notifyObservers();
        isOn = true;
        prntIsOn();
    }

    @Override
    public void off() {
        notifyObservers();
        isOn = true;
        prntIsOn();
    }

    @Override
    public void volumeUp() {
        notifyObservers();
        volume++;
        prntVolume();
    }

    @Override
    public void volumeDown() {
        notifyObservers();
        volume--;
        prntVolume();
    }

    @Override
    public void starVisualDrive() {
        notifyObservers();
        driveOn = true;
        prntDriveOn();
    }

    @Override
    public void stopVisualDrive() {
        notifyObservers();
        driveOn = false;
        prntDriveOn();
    }

    @Override
     public void setVolume(int volume) {
        notifyObservers();
        this.volume = volume;
        prntVolume();
    }

    @Override
    public Memento createMemento() {
        Map<String, Object> state = new HashMap<>();
        state.put(VOLUME, volume);
        state.put(IS_ON, isOn);
        state.put(DRIVE_ON, driveOn);
        return new Memento(state);
    }

    @Override
    public void setMemento(Memento memento) {
        System.out.print("Old state: ");
        prntState();
        memento.geState().entrySet().stream()
                .forEach((entry) -> {
                    try {
                        setProperty(entry);
                    } catch (StateRestoreIncompleExeption stateRestoreIncompleExeption) {
                        return;
                    }
                });
        System.out.print("New state: ");
        prntState();
    }

    @Override
    public void suscribe(ElectronicDeviceStateCaretaker caretaker) {
        mCaretakers.add(caretaker);
    }

    private void setProperty(Map.Entry<String, Object> entry) throws StateRestoreIncompleExeption {

        switch (entry.getKey()) {

            case VOLUME:
                if (checkClass(VOLUME_TYPE, entry.getValue()))
                    volume = (Integer) entry.getValue();
                break;

            case IS_ON:
                if (checkClass(IS_ON_TYPE, entry.getValue()))
                    isOn = (Boolean) entry.getValue();
                break;

            case DRIVE_ON:
                if (checkClass(DRIVE_ON_TYPE, entry.getValue()))
                    driveOn = (Boolean) entry.getValue();
                break;

            default:
                throw new StateRestoreIncompleExeption();
        }
    }

    private boolean checkClass(String type, Object value) {
        try {
            return value.getClass() == Class.forName(type);
        } catch (ClassNotFoundException e) {
            return false;
        }
    }

    private void prntState(){
        System.out.println("state{");
        prntVolume();
        prntIsOn();
        prntDriveOn();
        System.out.println("}");
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
