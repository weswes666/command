package devices;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by wessel on 05/10/2015.
 */
public abstract class AbstractElectronicDevice implements ElectronicDevice{
    private static final String VOLUME_TYPE = "java.lang.Integer";
    private static final String IS_ON_TYPE = "java.lang.Boolean";
    private static final String DRIVE_ON_TYPE = "java.lang.Boolean";
    private static final String VOLUME = "volume";
    private static final String IS_ON = "isOn";
    private static final String DRIVE_ON = "driveOn";

    protected int volume = 0;
    protected boolean isOn = false;
    protected boolean driveOn = false;
    private ElectronicDeviceStateCaretaker mCaretaker;

    public AbstractElectronicDevice(){}

    @Override
    public final void on() {
        notifyCaretaker();
        isOn = true;
        prntIsOn();
    }

    @Override
    public final void off() {
        notifyCaretaker();
        isOn = true;
        prntIsOn();
    }

    @Override
    public final void volumeUp() {
        notifyCaretaker();
        volume++;
        prntVolume();
    }

    @Override
    public final void volumeDown() {
        notifyCaretaker();
        volume--;
        prntVolume();
    }

    @Override
    public final void starVisualDrive() {
        notifyCaretaker();
        driveOn = true;
        prntDriveOn();
    }

    @Override
    public final void stopVisualDrive() {
        notifyCaretaker();
        driveOn = false;
        prntDriveOn();
    }

    @Override
    public final void setVolume(int volume) {
        notifyCaretaker();
        this.volume = volume;
        prntVolume();
    }

    @Override
    public final Memento createMemento() {
        Map<String, Object> state = new HashMap<>();
        state.put(VOLUME, volume);
        state.put(IS_ON, isOn);
        state.put(DRIVE_ON, driveOn);
        return new Memento(state);
    }

    @Override
    public final void setMemento(Memento memento) {
        System.out.print("Old state: ");
        prntState();
        memento.geState().entrySet().stream()
                .forEach((entry) -> {
                    try {
                        setProperty(entry);
                    } catch (StateRestoreIncompleteExeption stateRestoreIncompleteExeption) {
                        System.out.println(stateRestoreIncompleteExeption.getMessage());
                        return;
                    }
                });
        System.out.print("New state: ");
        prntState();
    }

    @Override
    public final boolean subscribe(ElectronicDeviceStateCaretaker caretaker) {
        if(mCaretaker == null){
            mCaretaker = caretaker;
            return true;
        }
        return false;
    }

    private final void notifyCaretaker(){
        mCaretaker.update();
    }

    private final  void setProperty(Map.Entry<String, Object> entry) throws StateRestoreIncompleteExeption {

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
                throw new StateRestoreIncompleteExeption();
        }
    }

    private final boolean checkClass(String type, Object value) {
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

    protected abstract void prntDriveOn();

    protected abstract void prntIsOn();

    protected abstract void prntVolume();
}
