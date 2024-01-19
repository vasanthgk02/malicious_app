package sfs2x.client.entities;

import java.util.Collections;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import sfs2x.client.entities.data.Vec3D;

public class MMORoom extends SFSRoom {
    public Vec3D defaultAOI;
    public Vec3D higherMapLimit;
    public Map<Integer, IMMOItem> itemsById = Collections.synchronizedMap(new HashMap());
    public Vec3D lowerMapLimit;

    public MMORoom(int i, String str) {
        super(i, str);
    }

    public void RemoveItem(int i) {
        this.itemsById.remove(Integer.valueOf(i));
    }

    public void addMMOItem(IMMOItem iMMOItem) {
        this.itemsById.put(Integer.valueOf(iMMOItem.getId()), iMMOItem);
    }

    public Vec3D getDefaultAOI() {
        return this.defaultAOI;
    }

    public Vec3D getHigherMapLimit() {
        return this.higherMapLimit;
    }

    public Vec3D getLowerMapLimit() {
        return this.lowerMapLimit;
    }

    public IMMOItem getMMOItem(int i) {
        return this.itemsById.get(Integer.valueOf(i));
    }

    public List<IMMOItem> getMMOItems() {
        LinkedList linkedList;
        synchronized (this.itemsById) {
            linkedList = new LinkedList(this.itemsById.values());
        }
        return linkedList;
    }

    public void setDefaultAOI(Vec3D vec3D) {
        if (this.defaultAOI == null) {
            this.defaultAOI = vec3D;
            return;
        }
        throw new IllegalArgumentException("This value is read-only");
    }

    public void setHigherMapLimit(Vec3D vec3D) {
        if (this.higherMapLimit == null) {
            this.higherMapLimit = vec3D;
            return;
        }
        throw new IllegalArgumentException("This value is read-only");
    }

    public void setLowerMapLimit(Vec3D vec3D) {
        if (this.lowerMapLimit == null) {
            this.lowerMapLimit = vec3D;
            return;
        }
        throw new IllegalArgumentException("This value is read-only");
    }

    public MMORoom(int i, String str, String str2) {
        super(i, str, str2);
    }
}
