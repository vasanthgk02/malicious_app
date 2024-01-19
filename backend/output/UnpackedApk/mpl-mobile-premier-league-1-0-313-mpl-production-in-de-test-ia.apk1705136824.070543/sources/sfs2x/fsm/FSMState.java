package sfs2x.fsm;

import java.util.HashMap;
import java.util.Map;

public class FSMState {
    public int stateName;
    public Map<Integer, Integer> transitions = new HashMap();

    public void addTransition(int i, int i2) {
        this.transitions.put(Integer.valueOf(i), Integer.valueOf(i2));
    }

    public int applyTransition(int i) {
        return this.transitions.containsKey(Integer.valueOf(i)) ? this.transitions.get(Integer.valueOf(i)).intValue() : this.stateName;
    }

    public int getStateName() {
        return this.stateName;
    }

    public void setStateName(int i) {
        this.stateName = i;
    }
}
