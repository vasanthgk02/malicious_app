package com.badlogic.gdx.graphics.g3d.decals;

import com.badlogic.gdx.utils.Array;
import com.badlogic.gdx.utils.IntMap;

public abstract class PluggableGroupStrategy implements GroupStrategy {
    public IntMap<GroupPlug> plugs = new IntMap<>();

    public void afterGroup(int i) {
        ((GroupPlug) this.plugs.get(i)).afterGroup();
    }

    public void beforeGroup(int i, Array<Decal> array) {
        ((GroupPlug) this.plugs.get(i)).beforeGroup(array);
    }

    public void plugIn(GroupPlug groupPlug, int i) {
        this.plugs.put(i, groupPlug);
    }

    public GroupPlug unPlug(int i) {
        IntMap<GroupPlug> intMap = this.plugs;
        GroupPlug groupPlug = null;
        if (i != 0) {
            int locateKey = intMap.locateKey(i);
            if (locateKey >= 0) {
                int[] iArr = intMap.keyTable;
                V[] vArr = intMap.valueTable;
                V v = vArr[locateKey];
                int i2 = intMap.mask;
                int i3 = locateKey + 1;
                while (true) {
                    int i4 = i3 & i2;
                    int i5 = iArr[i4];
                    if (i5 == 0) {
                        break;
                    }
                    int place = intMap.place(i5);
                    if (((i4 - place) & i2) > ((locateKey - place) & i2)) {
                        iArr[locateKey] = i5;
                        vArr[locateKey] = vArr[i4];
                        locateKey = i4;
                    }
                    i3 = i4 + 1;
                }
                iArr[locateKey] = 0;
                vArr[locateKey] = null;
                intMap.size--;
                groupPlug = v;
            }
        } else if (intMap.hasZeroValue) {
            intMap.hasZeroValue = false;
            V v2 = intMap.zeroValue;
            intMap.zeroValue = null;
            intMap.size--;
            groupPlug = v2;
        }
        return groupPlug;
    }
}
