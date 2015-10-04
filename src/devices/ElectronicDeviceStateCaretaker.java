package devices;

import java.util.Stack;

/**
 * Created by wessel on 04/10/2015.
 */
public class ElectronicDeviceStateCaretaker {
    ElectronicDevice mDevice;
    Stack<Memento> states = new Stack<>();

    public ElectronicDeviceStateCaretaker(ElectronicDevice device) throws Exception {
        mDevice = device;
        if(!mDevice.subscribe(this)){
            throw new Exception("can't have more then one subscribtion per ElectronicDevice instance!");
        }
    }

    public void update(){
        states.push(mDevice.createMemento());
    }

    public void restore(){
        if(!states.empty())
            mDevice.setMemento(states.pop());
    }
}
