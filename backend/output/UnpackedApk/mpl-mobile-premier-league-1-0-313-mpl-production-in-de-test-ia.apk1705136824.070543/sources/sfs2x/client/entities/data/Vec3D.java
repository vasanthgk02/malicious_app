package sfs2x.client.entities.data;

import com.smartfoxserver.v2.entities.data.ISFSArray;
import com.smartfoxserver.v2.entities.data.SFSDataType;
import com.smartfoxserver.v2.entities.data.SFSDataWrapper;
import java.util.Arrays;
import java.util.List;

public class Vec3D {
    public final Number px;
    public final Number py;
    public final Number pz;
    public final boolean useFloat;

    public Vec3D(int i, int i2, int i3) {
        this.px = Integer.valueOf(i);
        this.py = Integer.valueOf(i2);
        this.pz = Integer.valueOf(i3);
        this.useFloat = false;
    }

    public static Vec3D fromArray(SFSDataWrapper sFSDataWrapper) {
        SFSDataType typeId = sFSDataWrapper.getTypeId();
        if (typeId == SFSDataType.SFS_ARRAY) {
            ISFSArray iSFSArray = (ISFSArray) sFSDataWrapper.getObject();
            if (iSFSArray.get(0).getTypeId() == SFSDataType.INT) {
                return new Vec3D(iSFSArray.getInt(0).intValue(), iSFSArray.getInt(1).intValue(), iSFSArray.getInt(2).intValue());
            }
            return new Vec3D(iSFSArray.getFloat(0).floatValue(), iSFSArray.getFloat(1).floatValue(), iSFSArray.getFloat(2).floatValue());
        } else if (typeId == SFSDataType.INT_ARRAY) {
            return fromIntArray((List) sFSDataWrapper.getObject());
        } else {
            if (typeId == SFSDataType.FLOAT_ARRAY) {
                return fromFloatArray((List) sFSDataWrapper.getObject());
            }
            throw new IllegalArgumentException("Invalid Array Type, cannot convert to Vec3D!");
        }
    }

    public static Vec3D fromFloatArray(List<Float> list) {
        if (list.size() == 3) {
            return new Vec3D(list.get(0).floatValue(), list.get(1).floatValue(), list.get(2).floatValue());
        }
        throw new IllegalArgumentException("Wrong array size. Vec3D requires an array with 3 parameters (x,y,z)");
    }

    public static Vec3D fromIntArray(List<Integer> list) {
        if (list.size() == 3) {
            return new Vec3D(list.get(0).intValue(), list.get(1).intValue(), list.get(2).intValue());
        }
        throw new IllegalArgumentException("Wrong array size. Vec3D requires an array with 3 parameters (x,y,z)");
    }

    public float floatX() {
        return this.px.floatValue();
    }

    public float floatY() {
        return this.py.floatValue();
    }

    public float floatZ() {
        return this.pz.floatValue();
    }

    public int intX() {
        return this.px.intValue();
    }

    public int intY() {
        return this.py.intValue();
    }

    public int intZ() {
        return this.pz.intValue();
    }

    public boolean isFloat() {
        return this.useFloat;
    }

    public List<Float> toFloatArray() {
        return Arrays.asList(new Float[]{Float.valueOf(floatX()), Float.valueOf(floatY()), Float.valueOf(floatZ())});
    }

    public List<Integer> toIntArray() {
        return Arrays.asList(new Integer[]{Integer.valueOf(intX()), Integer.valueOf(intY()), Integer.valueOf(intZ())});
    }

    public String toString() {
        return String.format("(%s, %s, %s)", new Object[]{this.px, this.py, this.pz});
    }

    public Vec3D(float f2, float f3, float f4) {
        this.px = Float.valueOf(f2);
        this.py = Float.valueOf(f3);
        this.pz = Float.valueOf(f4);
        this.useFloat = true;
    }

    public Vec3D(int i, int i2) {
        this(i, i2, 0);
    }

    public Vec3D(float f2, float f3) {
        this(f2, f3, 0.0f);
    }
}
