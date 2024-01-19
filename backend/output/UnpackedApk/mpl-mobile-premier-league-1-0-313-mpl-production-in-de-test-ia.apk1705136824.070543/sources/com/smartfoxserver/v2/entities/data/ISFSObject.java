package com.smartfoxserver.v2.entities.data;

import java.util.Collection;
import java.util.Iterator;
import java.util.Map.Entry;
import java.util.Set;

public interface ISFSObject {
    boolean containsKey(String str);

    SFSDataWrapper get(String str);

    Boolean getBool(String str);

    Collection<Boolean> getBoolArray(String str);

    Byte getByte(String str);

    byte[] getByteArray(String str);

    Object getClass(String str);

    Double getDouble(String str);

    Collection<Double> getDoubleArray(String str);

    String getDump();

    String getDump(boolean z);

    Float getFloat(String str);

    Collection<Float> getFloatArray(String str);

    String getHexDump();

    Integer getInt(String str);

    Collection<Integer> getIntArray(String str);

    Set<String> getKeys();

    Long getLong(String str);

    Collection<Long> getLongArray(String str);

    ISFSArray getSFSArray(String str);

    ISFSObject getSFSObject(String str);

    Short getShort(String str);

    Collection<Short> getShortArray(String str);

    String getText(String str);

    Integer getUnsignedByte(String str);

    Collection<Integer> getUnsignedByteArray(String str);

    String getUtfString(String str);

    Collection<String> getUtfStringArray(String str);

    boolean isNull(String str);

    Iterator<Entry<String, SFSDataWrapper>> iterator();

    void put(String str, SFSDataWrapper sFSDataWrapper);

    void putBool(String str, boolean z);

    void putBoolArray(String str, Collection<Boolean> collection);

    void putByte(String str, byte b2);

    void putByteArray(String str, byte[] bArr);

    void putClass(String str, Object obj);

    void putDouble(String str, double d2);

    void putDoubleArray(String str, Collection<Double> collection);

    void putFloat(String str, float f2);

    void putFloatArray(String str, Collection<Float> collection);

    void putInt(String str, int i);

    void putIntArray(String str, Collection<Integer> collection);

    void putLong(String str, long j);

    void putLongArray(String str, Collection<Long> collection);

    void putNull(String str);

    void putSFSArray(String str, ISFSArray iSFSArray);

    void putSFSObject(String str, ISFSObject iSFSObject);

    void putShort(String str, short s);

    void putShortArray(String str, Collection<Short> collection);

    void putText(String str, String str2);

    void putUtfString(String str, String str2);

    void putUtfStringArray(String str, Collection<String> collection);

    boolean removeElement(String str);

    int size();

    byte[] toBinary();

    String toJson();
}
