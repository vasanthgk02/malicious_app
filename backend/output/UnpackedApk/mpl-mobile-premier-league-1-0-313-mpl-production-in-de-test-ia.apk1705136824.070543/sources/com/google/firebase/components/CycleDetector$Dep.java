package com.google.firebase.components;

public class CycleDetector$Dep {
    public final Class<?> anInterface;
    public final boolean set;

    public CycleDetector$Dep(Class cls, boolean z, CycleDetector$1 cycleDetector$1) {
        this.anInterface = cls;
        this.set = z;
    }

    public boolean equals(Object obj) {
        if (!(obj instanceof CycleDetector$Dep)) {
            return false;
        }
        CycleDetector$Dep cycleDetector$Dep = (CycleDetector$Dep) obj;
        if (!cycleDetector$Dep.anInterface.equals(this.anInterface) || cycleDetector$Dep.set != this.set) {
            return false;
        }
        return true;
    }

    public int hashCode() {
        return ((this.anInterface.hashCode() ^ 1000003) * 1000003) ^ Boolean.valueOf(this.set).hashCode();
    }
}
