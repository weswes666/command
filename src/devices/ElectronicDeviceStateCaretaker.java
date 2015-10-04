package devices;

import devices.ElectronicDevice;
import devices.Memento;

import java.util.Stack;

/**
 * Created by wessel on 04/10/2015.
 */
public class ElectronicDeviceStateCaretaker {
    ElectronicDevice mDevice;
    Stack<Memento> states = new Stack<>();

    public ElectronicDeviceStateCaretaker(ElectronicDevice device){
        mDevice = device;
        mDevice.suscribe(this);
    }

    public void update(){
        states.push(mDevice.createMemento());
    }

    public void restore(){
        if(!states.empty())
            mDevice.setMemento(states.pop());
    }
}
