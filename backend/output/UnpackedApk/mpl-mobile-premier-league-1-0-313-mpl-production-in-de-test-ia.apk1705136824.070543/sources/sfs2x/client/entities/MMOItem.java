package sfs2x.client.entities;

import com.smartfoxserver.v2.entities.data.ISFSArray;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import sfs2x.client.entities.data.Vec3D;
import sfs2x.client.entities.variables.IMMOItemVariable;
import sfs2x.client.entities.variables.MMOItemVariable;

public class MMOItem implements IMMOItem {
    public Vec3D aoiEntryPoint;
    public final int id;
    public final Map<String, IMMOItemVariable> variables = new HashMap();

    public MMOItem(int i) {
        this.id = i;
    }

    public static IMMOItem fromSFSArray(ISFSArray iSFSArray) {
        MMOItem mMOItem = new MMOItem(iSFSArray.getInt(0).intValue());
        ISFSArray sFSArray = iSFSArray.getSFSArray(1);
        for (int i = 0; i < sFSArray.size(); i++) {
            mMOItem.setVariable(MMOItemVariable.fromSFSArray(sFSArray.getSFSArray(i)));
        }
        return mMOItem;
    }

    public boolean containsVariable(String str) {
        boolean containsKey;
        synchronized (this.variables) {
            containsKey = this.variables.containsKey(str);
        }
        return containsKey;
    }

    public Vec3D getAOIEntryPoint() {
        return this.aoiEntryPoint;
    }

    public int getId() {
        return this.id;
    }

    public IMMOItemVariable getVariable(String str) {
        IMMOItemVariable iMMOItemVariable;
        synchronized (this.variables) {
            iMMOItemVariable = this.variables.get(str);
        }
        return iMMOItemVariable;
    }

    public List<IMMOItemVariable> getVariables() {
        LinkedList linkedList;
        synchronized (this.variables) {
            linkedList = new LinkedList(this.variables.values());
        }
        return linkedList;
    }

    public void setAOIEntryPoint(Vec3D vec3D) {
        this.aoiEntryPoint = vec3D;
    }

    public void setVariable(IMMOItemVariable iMMOItemVariable) {
        synchronized (this.variables) {
            this.variables.put(iMMOItemVariable.getName(), iMMOItemVariable);
        }
    }

    public void setVariables(List<IMMOItemVariable> list) {
        synchronized (this.variables) {
            for (IMMOItemVariable next : list) {
                this.variables.put(next.getName(), next);
            }
        }
    }

    public String toString() {
        return String.format("[id: %s, %s ]", new Object[]{Integer.valueOf(this.id), this.variables});
    }
}
