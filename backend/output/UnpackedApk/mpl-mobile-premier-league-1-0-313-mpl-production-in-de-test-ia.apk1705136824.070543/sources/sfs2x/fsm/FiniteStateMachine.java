package sfs2x.fsm;

import java.util.ArrayList;
import java.util.List;

public class FiniteStateMachine {
    public int currentStateName;
    public Object locker = new Object();
    public List<FSMState> states = new ArrayList();

    private FSMState findStateObjByName(int i) {
        for (FSMState next : this.states) {
            if (i == next.getStateName()) {
                return next;
            }
        }
        return null;
    }

    public void addAllStates(int i) {
        for (int i2 = 0; i2 < i; i2++) {
            addState(i2);
        }
    }

    public void addState(int i) {
        FSMState fSMState = new FSMState();
        fSMState.setStateName(i);
        this.states.add(fSMState);
    }

    public void addStateTransition(int i, int i2, int i3) {
        findStateObjByName(i).addTransition(i3, i2);
    }

    public int applyTransition(int i) {
        int applyTransition;
        synchronized (this.locker) {
            applyTransition = findStateObjByName(this.currentStateName).applyTransition(i);
            this.currentStateName = applyTransition;
        }
        return applyTransition;
    }

    public int getCurrentState() {
        int i;
        synchronized (this.locker) {
            try {
                i = this.currentStateName;
            }
        }
        return i;
    }

    public void setCurrentState(int i) {
        this.currentStateName = i;
    }
}
