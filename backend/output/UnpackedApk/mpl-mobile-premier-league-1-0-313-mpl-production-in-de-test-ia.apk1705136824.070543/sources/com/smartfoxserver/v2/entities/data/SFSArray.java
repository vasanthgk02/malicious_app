package com.smartfoxserver.v2.entities.data;

import com.android.tools.r8.GeneratedOutlineSupport;
import com.smartfoxserver.bitswarm.util.ByteUtils;
import com.smartfoxserver.v2.protocol.serialization.DefaultObjectDumpFormatter;
import com.smartfoxserver.v2.protocol.serialization.DefaultSFSDataSerializer;
import com.smartfoxserver.v2.protocol.serialization.ISFSDataSerializer;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import org.apache.fontbox.cmap.CMapParser;

public class SFSArray implements ISFSArray {
    public List<SFSDataWrapper> dataHolder = new ArrayList();
    public ISFSDataSerializer serializer = DefaultSFSDataSerializer.getInstance();

    private void addObject(Object obj, SFSDataType sFSDataType) {
        this.dataHolder.add(new SFSDataWrapper(sFSDataType, obj));
    }

    private String dump() {
        Object obj;
        StringBuilder outline72 = GeneratedOutlineSupport.outline72('{');
        for (SFSDataWrapper next : this.dataHolder) {
            if (next.getTypeId() == SFSDataType.SFS_OBJECT) {
                obj = ((ISFSObject) next.getObject()).getDump(false);
            } else if (next.getTypeId() == SFSDataType.SFS_ARRAY) {
                obj = ((ISFSArray) next.getObject()).getDump(false);
            } else if (next.getTypeId() == SFSDataType.BYTE_ARRAY) {
                obj = DefaultObjectDumpFormatter.prettyPrintByteArray((byte[]) next.getObject());
            } else if (next.getTypeId() == SFSDataType.CLASS) {
                obj = next.getObject().getClass().getName();
            } else {
                obj = next.getObject();
            }
            outline72.append(" (");
            outline72.append(next.getTypeId().name().toLowerCase());
            outline72.append(") ");
            outline72.append(obj);
            outline72.append(DefaultObjectDumpFormatter.TOKEN_DIVIDER);
        }
        if (size() > 0) {
            outline72.delete(outline72.length() - 1, outline72.length());
        }
        outline72.append('}');
        return outline72.toString();
    }

    private List<Object> flatten() {
        ArrayList arrayList = new ArrayList();
        DefaultSFSDataSerializer.getInstance().flattenArray(arrayList, this);
        return arrayList;
    }

    public static SFSArray newFromBinaryData(byte[] bArr) {
        return (SFSArray) DefaultSFSDataSerializer.getInstance().binary2array(bArr);
    }

    public static SFSArray newFromJsonData(String str) {
        return (SFSArray) DefaultSFSDataSerializer.getInstance().json2array(str);
    }

    public static SFSArray newFromResultSet(ResultSet resultSet) throws SQLException {
        return DefaultSFSDataSerializer.getInstance().resultSet2array(resultSet);
    }

    public static SFSArray newInstance() {
        return new SFSArray();
    }

    public void add(SFSDataWrapper sFSDataWrapper) {
        this.dataHolder.add(sFSDataWrapper);
    }

    public void addBool(boolean z) {
        addObject(Boolean.valueOf(z), SFSDataType.BOOL);
    }

    public void addBoolArray(Collection<Boolean> collection) {
        addObject(collection, SFSDataType.BOOL_ARRAY);
    }

    public void addByte(byte b2) {
        addObject(Byte.valueOf(b2), SFSDataType.BYTE);
    }

    public void addByteArray(byte[] bArr) {
        addObject(bArr, SFSDataType.BYTE_ARRAY);
    }

    public void addClass(Object obj) {
        addObject(obj, SFSDataType.CLASS);
    }

    public void addDouble(double d2) {
        addObject(Double.valueOf(d2), SFSDataType.DOUBLE);
    }

    public void addDoubleArray(Collection<Double> collection) {
        addObject(collection, SFSDataType.DOUBLE_ARRAY);
    }

    public void addFloat(float f2) {
        addObject(Float.valueOf(f2), SFSDataType.FLOAT);
    }

    public void addFloatArray(Collection<Float> collection) {
        addObject(collection, SFSDataType.FLOAT_ARRAY);
    }

    public void addInt(int i) {
        addObject(Integer.valueOf(i), SFSDataType.INT);
    }

    public void addIntArray(Collection<Integer> collection) {
        addObject(collection, SFSDataType.INT_ARRAY);
    }

    public void addLong(long j) {
        addObject(Long.valueOf(j), SFSDataType.LONG);
    }

    public void addLongArray(Collection<Long> collection) {
        addObject(collection, SFSDataType.LONG_ARRAY);
    }

    public void addNull() {
        addObject(null, SFSDataType.NULL);
    }

    public void addSFSArray(ISFSArray iSFSArray) {
        addObject(iSFSArray, SFSDataType.SFS_ARRAY);
    }

    public void addSFSObject(ISFSObject iSFSObject) {
        addObject(iSFSObject, SFSDataType.SFS_OBJECT);
    }

    public void addShort(short s) {
        addObject(Short.valueOf(s), SFSDataType.SHORT);
    }

    public void addShortArray(Collection<Short> collection) {
        addObject(collection, SFSDataType.SHORT_ARRAY);
    }

    public void addText(String str) {
        addObject(str, SFSDataType.TEXT);
    }

    public void addUtfString(String str) {
        addObject(str, SFSDataType.UTF_STRING);
    }

    public void addUtfStringArray(Collection<String> collection) {
        addObject(collection, SFSDataType.UTF_STRING_ARRAY);
    }

    public boolean contains(Object obj) {
        if ((obj instanceof ISFSArray) || (obj instanceof ISFSObject)) {
            throw new UnsupportedOperationException("ISFSArray and ISFSObject are not supported by this method.");
        }
        for (SFSDataWrapper object : this.dataHolder) {
            if (object.getObject().equals(obj)) {
                return true;
            }
        }
        return false;
    }

    public SFSDataWrapper get(int i) {
        return this.dataHolder.get(i);
    }

    public Boolean getBool(int i) {
        SFSDataWrapper sFSDataWrapper = this.dataHolder.get(i);
        if (sFSDataWrapper != null) {
            return (Boolean) sFSDataWrapper.getObject();
        }
        return null;
    }

    public Collection<Boolean> getBoolArray(int i) {
        SFSDataWrapper sFSDataWrapper = this.dataHolder.get(i);
        if (sFSDataWrapper != null) {
            return (Collection) sFSDataWrapper.getObject();
        }
        return null;
    }

    public Byte getByte(int i) {
        SFSDataWrapper sFSDataWrapper = this.dataHolder.get(i);
        if (sFSDataWrapper != null) {
            return (Byte) sFSDataWrapper.getObject();
        }
        return null;
    }

    public byte[] getByteArray(int i) {
        SFSDataWrapper sFSDataWrapper = this.dataHolder.get(i);
        if (sFSDataWrapper != null) {
            return (byte[]) sFSDataWrapper.getObject();
        }
        return null;
    }

    public Object getClass(int i) {
        SFSDataWrapper sFSDataWrapper = this.dataHolder.get(i);
        if (sFSDataWrapper != null) {
            return sFSDataWrapper.getObject();
        }
        return null;
    }

    public Double getDouble(int i) {
        SFSDataWrapper sFSDataWrapper = this.dataHolder.get(i);
        if (sFSDataWrapper != null) {
            return (Double) sFSDataWrapper.getObject();
        }
        return null;
    }

    public Collection<Double> getDoubleArray(int i) {
        SFSDataWrapper sFSDataWrapper = this.dataHolder.get(i);
        if (sFSDataWrapper != null) {
            return (Collection) sFSDataWrapper.getObject();
        }
        return null;
    }

    public String getDump() {
        if (size() == 0) {
            return "[ Empty SFSArray ]";
        }
        return DefaultObjectDumpFormatter.prettyPrintDump(dump());
    }

    public Object getElementAt(int i) {
        return this.dataHolder.get(i).getObject();
    }

    public Float getFloat(int i) {
        SFSDataWrapper sFSDataWrapper = this.dataHolder.get(i);
        if (sFSDataWrapper != null) {
            return (Float) sFSDataWrapper.getObject();
        }
        return null;
    }

    public Collection<Float> getFloatArray(int i) {
        SFSDataWrapper sFSDataWrapper = this.dataHolder.get(i);
        if (sFSDataWrapper != null) {
            return (Collection) sFSDataWrapper.getObject();
        }
        return null;
    }

    public String getHexDump() {
        return ByteUtils.fullHexDump(toBinary());
    }

    public Integer getInt(int i) {
        SFSDataWrapper sFSDataWrapper = this.dataHolder.get(i);
        if (sFSDataWrapper != null) {
            return (Integer) sFSDataWrapper.getObject();
        }
        return null;
    }

    public Collection<Integer> getIntArray(int i) {
        SFSDataWrapper sFSDataWrapper = this.dataHolder.get(i);
        if (sFSDataWrapper != null) {
            return (Collection) sFSDataWrapper.getObject();
        }
        return null;
    }

    public Long getLong(int i) {
        SFSDataWrapper sFSDataWrapper = this.dataHolder.get(i);
        if (sFSDataWrapper != null) {
            return (Long) sFSDataWrapper.getObject();
        }
        return null;
    }

    public Collection<Long> getLongArray(int i) {
        SFSDataWrapper sFSDataWrapper = this.dataHolder.get(i);
        if (sFSDataWrapper != null) {
            return (Collection) sFSDataWrapper.getObject();
        }
        return null;
    }

    public ISFSArray getSFSArray(int i) {
        SFSDataWrapper sFSDataWrapper = this.dataHolder.get(i);
        if (sFSDataWrapper != null) {
            return (ISFSArray) sFSDataWrapper.getObject();
        }
        return null;
    }

    public ISFSObject getSFSObject(int i) {
        SFSDataWrapper sFSDataWrapper = this.dataHolder.get(i);
        if (sFSDataWrapper != null) {
            return (ISFSObject) sFSDataWrapper.getObject();
        }
        return null;
    }

    public Short getShort(int i) {
        SFSDataWrapper sFSDataWrapper = this.dataHolder.get(i);
        if (sFSDataWrapper != null) {
            return (Short) sFSDataWrapper.getObject();
        }
        return null;
    }

    public Collection<Short> getShortArray(int i) {
        SFSDataWrapper sFSDataWrapper = this.dataHolder.get(i);
        if (sFSDataWrapper != null) {
            return (Collection) sFSDataWrapper.getObject();
        }
        return null;
    }

    public String getText(int i) {
        return getUtfString(i);
    }

    public Integer getUnsignedByte(int i) {
        SFSDataWrapper sFSDataWrapper = this.dataHolder.get(i);
        if (sFSDataWrapper != null) {
            return Integer.valueOf(DefaultSFSDataSerializer.getInstance().getUnsignedByte(((Byte) sFSDataWrapper.getObject()).byteValue()));
        }
        return null;
    }

    public Collection<Integer> getUnsignedByteArray(int i) {
        SFSDataWrapper sFSDataWrapper = this.dataHolder.get(i);
        if (sFSDataWrapper == null) {
            return null;
        }
        DefaultSFSDataSerializer instance = DefaultSFSDataSerializer.getInstance();
        ArrayList arrayList = new ArrayList();
        for (byte unsignedByte : (byte[]) sFSDataWrapper.getObject()) {
            arrayList.add(Integer.valueOf(instance.getUnsignedByte(unsignedByte)));
        }
        return arrayList;
    }

    public String getUtfString(int i) {
        SFSDataWrapper sFSDataWrapper = this.dataHolder.get(i);
        if (sFSDataWrapper != null) {
            return (String) sFSDataWrapper.getObject();
        }
        return null;
    }

    public Collection<String> getUtfStringArray(int i) {
        SFSDataWrapper sFSDataWrapper = this.dataHolder.get(i);
        if (sFSDataWrapper != null) {
            return (Collection) sFSDataWrapper.getObject();
        }
        return null;
    }

    public boolean isNull(int i) {
        SFSDataWrapper sFSDataWrapper = this.dataHolder.get(i);
        if (sFSDataWrapper != null && sFSDataWrapper.getTypeId() == SFSDataType.NULL) {
            return true;
        }
        return false;
    }

    public Iterator<SFSDataWrapper> iterator() {
        return this.dataHolder.iterator();
    }

    public void removeElementAt(int i) {
        this.dataHolder.remove(i);
    }

    public int size() {
        return this.dataHolder.size();
    }

    public byte[] toBinary() {
        return this.serializer.array2binary(this);
    }

    public String toJson() {
        return DefaultSFSDataSerializer.getInstance().array2json(flatten());
    }

    public String toString() {
        return "[SFSArray, size: " + size() + CMapParser.MARK_END_OF_ARRAY;
    }

    public String getDump(boolean z) {
        if (!z) {
            return dump();
        }
        return getDump();
    }
}
