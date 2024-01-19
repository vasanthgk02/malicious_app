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
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;
import java.util.concurrent.ConcurrentHashMap;
import org.apache.fontbox.cmap.CMapParser;

public class SFSObject implements ISFSObject {
    public Map<String, SFSDataWrapper> dataHolder = new ConcurrentHashMap();
    public ISFSDataSerializer serializer = DefaultSFSDataSerializer.getInstance();

    private String dump() {
        StringBuilder outline72 = GeneratedOutlineSupport.outline72('{');
        for (String next : getKeys()) {
            SFSDataWrapper sFSDataWrapper = get(next);
            outline72.append("(");
            outline72.append(sFSDataWrapper.getTypeId().name().toLowerCase());
            outline72.append(") ");
            outline72.append(next);
            outline72.append(": ");
            if (sFSDataWrapper.getTypeId() == SFSDataType.SFS_OBJECT) {
                outline72.append(((SFSObject) sFSDataWrapper.getObject()).getDump(false));
            } else if (sFSDataWrapper.getTypeId() == SFSDataType.SFS_ARRAY) {
                outline72.append(((SFSArray) sFSDataWrapper.getObject()).getDump(false));
            } else if (sFSDataWrapper.getTypeId() == SFSDataType.BYTE_ARRAY) {
                outline72.append(DefaultObjectDumpFormatter.prettyPrintByteArray((byte[]) sFSDataWrapper.getObject()));
            } else if (sFSDataWrapper.getTypeId() == SFSDataType.CLASS) {
                outline72.append(sFSDataWrapper.getObject().getClass().getName());
            } else {
                outline72.append(sFSDataWrapper.getObject());
            }
            outline72.append(DefaultObjectDumpFormatter.TOKEN_DIVIDER);
        }
        outline72.append('}');
        return outline72.toString();
    }

    private Map<String, Object> flatten() {
        HashMap hashMap = new HashMap();
        DefaultSFSDataSerializer.getInstance().flattenObject(hashMap, this);
        return hashMap;
    }

    public static SFSObject newFromBinaryData(byte[] bArr) {
        return (SFSObject) DefaultSFSDataSerializer.getInstance().binary2object(bArr);
    }

    public static ISFSObject newFromJsonData(String str) {
        return DefaultSFSDataSerializer.getInstance().json2object(str);
    }

    public static SFSObject newFromObject(Object obj) {
        return (SFSObject) DefaultSFSDataSerializer.getInstance().pojo2sfs(obj);
    }

    public static SFSObject newFromResultSet(ResultSet resultSet) throws SQLException {
        return DefaultSFSDataSerializer.getInstance().resultSet2object(resultSet);
    }

    public static SFSObject newInstance() {
        return new SFSObject();
    }

    private void putObj(String str, Object obj, SFSDataType sFSDataType) {
        if (str == null) {
            throw new IllegalArgumentException("SFSObject requires a non-null key for a 'put' operation!");
        } else if (str.length() > 255) {
            throw new IllegalArgumentException("SFSObject keys must be less than 255 characters!");
        } else if (obj == null) {
            throw new IllegalArgumentException("SFSObject requires a non-null value! If you need to add a null use the putNull() method.");
        } else if (obj instanceof SFSDataWrapper) {
            this.dataHolder.put(str, (SFSDataWrapper) obj);
        } else {
            this.dataHolder.put(str, new SFSDataWrapper(sFSDataType, obj));
        }
    }

    public boolean containsKey(String str) {
        return this.dataHolder.containsKey(str);
    }

    public SFSDataWrapper get(String str) {
        return this.dataHolder.get(str);
    }

    public Boolean getBool(String str) {
        SFSDataWrapper sFSDataWrapper = this.dataHolder.get(str);
        if (sFSDataWrapper == null) {
            return null;
        }
        return (Boolean) sFSDataWrapper.getObject();
    }

    public Collection<Boolean> getBoolArray(String str) {
        SFSDataWrapper sFSDataWrapper = this.dataHolder.get(str);
        if (sFSDataWrapper == null) {
            return null;
        }
        return (Collection) sFSDataWrapper.getObject();
    }

    public Byte getByte(String str) {
        SFSDataWrapper sFSDataWrapper = this.dataHolder.get(str);
        if (sFSDataWrapper == null) {
            return null;
        }
        return (Byte) sFSDataWrapper.getObject();
    }

    public byte[] getByteArray(String str) {
        SFSDataWrapper sFSDataWrapper = this.dataHolder.get(str);
        if (sFSDataWrapper == null) {
            return null;
        }
        return (byte[]) sFSDataWrapper.getObject();
    }

    public Object getClass(String str) {
        SFSDataWrapper sFSDataWrapper = this.dataHolder.get(str);
        if (sFSDataWrapper == null) {
            return null;
        }
        return sFSDataWrapper.getObject();
    }

    public Double getDouble(String str) {
        SFSDataWrapper sFSDataWrapper = this.dataHolder.get(str);
        if (sFSDataWrapper == null) {
            return null;
        }
        return (Double) sFSDataWrapper.getObject();
    }

    public Collection<Double> getDoubleArray(String str) {
        SFSDataWrapper sFSDataWrapper = this.dataHolder.get(str);
        if (sFSDataWrapper == null) {
            return null;
        }
        return (Collection) sFSDataWrapper.getObject();
    }

    public String getDump() {
        if (size() == 0) {
            return "[ Empty SFSObject ]";
        }
        return DefaultObjectDumpFormatter.prettyPrintDump(dump());
    }

    public Float getFloat(String str) {
        SFSDataWrapper sFSDataWrapper = this.dataHolder.get(str);
        if (sFSDataWrapper == null) {
            return null;
        }
        return (Float) sFSDataWrapper.getObject();
    }

    public Collection<Float> getFloatArray(String str) {
        SFSDataWrapper sFSDataWrapper = this.dataHolder.get(str);
        if (sFSDataWrapper == null) {
            return null;
        }
        return (Collection) sFSDataWrapper.getObject();
    }

    public String getHexDump() {
        return ByteUtils.fullHexDump(toBinary());
    }

    public Integer getInt(String str) {
        SFSDataWrapper sFSDataWrapper = this.dataHolder.get(str);
        if (sFSDataWrapper == null) {
            return null;
        }
        return (Integer) sFSDataWrapper.getObject();
    }

    public Collection<Integer> getIntArray(String str) {
        SFSDataWrapper sFSDataWrapper = this.dataHolder.get(str);
        if (sFSDataWrapper == null) {
            return null;
        }
        return (Collection) sFSDataWrapper.getObject();
    }

    public Set<String> getKeys() {
        return this.dataHolder.keySet();
    }

    public Long getLong(String str) {
        SFSDataWrapper sFSDataWrapper = this.dataHolder.get(str);
        if (sFSDataWrapper == null) {
            return null;
        }
        return (Long) sFSDataWrapper.getObject();
    }

    public Collection<Long> getLongArray(String str) {
        SFSDataWrapper sFSDataWrapper = this.dataHolder.get(str);
        if (sFSDataWrapper == null) {
            return null;
        }
        return (Collection) sFSDataWrapper.getObject();
    }

    public ISFSArray getSFSArray(String str) {
        SFSDataWrapper sFSDataWrapper = this.dataHolder.get(str);
        if (sFSDataWrapper == null) {
            return null;
        }
        return (ISFSArray) sFSDataWrapper.getObject();
    }

    public ISFSObject getSFSObject(String str) {
        SFSDataWrapper sFSDataWrapper = this.dataHolder.get(str);
        if (sFSDataWrapper == null) {
            return null;
        }
        return (ISFSObject) sFSDataWrapper.getObject();
    }

    public Short getShort(String str) {
        SFSDataWrapper sFSDataWrapper = this.dataHolder.get(str);
        if (sFSDataWrapper == null) {
            return null;
        }
        return (Short) sFSDataWrapper.getObject();
    }

    public Collection<Short> getShortArray(String str) {
        SFSDataWrapper sFSDataWrapper = this.dataHolder.get(str);
        if (sFSDataWrapper == null) {
            return null;
        }
        return (Collection) sFSDataWrapper.getObject();
    }

    public String getText(String str) {
        return getUtfString(str);
    }

    public Integer getUnsignedByte(String str) {
        SFSDataWrapper sFSDataWrapper = this.dataHolder.get(str);
        if (sFSDataWrapper == null) {
            return null;
        }
        return Integer.valueOf(DefaultSFSDataSerializer.getInstance().getUnsignedByte(((Byte) sFSDataWrapper.getObject()).byteValue()));
    }

    public Collection<Integer> getUnsignedByteArray(String str) {
        SFSDataWrapper sFSDataWrapper = this.dataHolder.get(str);
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

    public String getUtfString(String str) {
        SFSDataWrapper sFSDataWrapper = this.dataHolder.get(str);
        if (sFSDataWrapper == null) {
            return null;
        }
        return (String) sFSDataWrapper.getObject();
    }

    public Collection<String> getUtfStringArray(String str) {
        SFSDataWrapper sFSDataWrapper = this.dataHolder.get(str);
        if (sFSDataWrapper == null) {
            return null;
        }
        return (Collection) sFSDataWrapper.getObject();
    }

    public boolean isNull(String str) {
        SFSDataWrapper sFSDataWrapper = this.dataHolder.get(str);
        if (sFSDataWrapper != null && sFSDataWrapper.getTypeId() == SFSDataType.NULL) {
            return true;
        }
        return false;
    }

    public Iterator<Entry<String, SFSDataWrapper>> iterator() {
        return this.dataHolder.entrySet().iterator();
    }

    public void put(String str, SFSDataWrapper sFSDataWrapper) {
        putObj(str, sFSDataWrapper, null);
    }

    public void putBool(String str, boolean z) {
        putObj(str, Boolean.valueOf(z), SFSDataType.BOOL);
    }

    public void putBoolArray(String str, Collection<Boolean> collection) {
        putObj(str, collection, SFSDataType.BOOL_ARRAY);
    }

    public void putByte(String str, byte b2) {
        putObj(str, Byte.valueOf(b2), SFSDataType.BYTE);
    }

    public void putByteArray(String str, byte[] bArr) {
        putObj(str, bArr, SFSDataType.BYTE_ARRAY);
    }

    public void putClass(String str, Object obj) {
        putObj(str, obj, SFSDataType.CLASS);
    }

    public void putDouble(String str, double d2) {
        putObj(str, Double.valueOf(d2), SFSDataType.DOUBLE);
    }

    public void putDoubleArray(String str, Collection<Double> collection) {
        putObj(str, collection, SFSDataType.DOUBLE_ARRAY);
    }

    public void putFloat(String str, float f2) {
        putObj(str, Float.valueOf(f2), SFSDataType.FLOAT);
    }

    public void putFloatArray(String str, Collection<Float> collection) {
        putObj(str, collection, SFSDataType.FLOAT_ARRAY);
    }

    public void putInt(String str, int i) {
        putObj(str, Integer.valueOf(i), SFSDataType.INT);
    }

    public void putIntArray(String str, Collection<Integer> collection) {
        putObj(str, collection, SFSDataType.INT_ARRAY);
    }

    public void putLong(String str, long j) {
        putObj(str, Long.valueOf(j), SFSDataType.LONG);
    }

    public void putLongArray(String str, Collection<Long> collection) {
        putObj(str, collection, SFSDataType.LONG_ARRAY);
    }

    public void putNull(String str) {
        this.dataHolder.put(str, new SFSDataWrapper(SFSDataType.NULL, null));
    }

    public void putSFSArray(String str, ISFSArray iSFSArray) {
        putObj(str, iSFSArray, SFSDataType.SFS_ARRAY);
    }

    public void putSFSObject(String str, ISFSObject iSFSObject) {
        putObj(str, iSFSObject, SFSDataType.SFS_OBJECT);
    }

    public void putShort(String str, short s) {
        putObj(str, Short.valueOf(s), SFSDataType.SHORT);
    }

    public void putShortArray(String str, Collection<Short> collection) {
        putObj(str, collection, SFSDataType.SHORT_ARRAY);
    }

    public void putText(String str, String str2) {
        putObj(str, str2, SFSDataType.TEXT);
    }

    public void putUtfString(String str, String str2) {
        putObj(str, str2, SFSDataType.UTF_STRING);
    }

    public void putUtfStringArray(String str, Collection<String> collection) {
        putObj(str, collection, SFSDataType.UTF_STRING_ARRAY);
    }

    public boolean removeElement(String str) {
        return this.dataHolder.remove(str) != null;
    }

    public int size() {
        return this.dataHolder.size();
    }

    public byte[] toBinary() {
        return this.serializer.object2binary(this);
    }

    public String toJson() {
        return this.serializer.object2json(flatten());
    }

    public String toString() {
        return "[SFSObject, size: " + size() + CMapParser.MARK_END_OF_ARRAY;
    }

    public String getDump(boolean z) {
        if (!z) {
            return dump();
        }
        return getDump();
    }
}
