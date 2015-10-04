package devices;

import java.util.Map;

/**
 * Created by wessel on 03/10/2015.
 */
public class Memento {
    private Map<String, Object> mState;

    public Memento(Map<String, Object> state) {
        mState = state;
    }

    void setState(Map<String, Object> state){
        mState = state;
    }

    Map<String, Object> geState(){
        return mState;
    }
}
