package com.smartfoxserver.v2.protocol.serialization;

import com.android.tools.r8.GeneratedOutlineSupport;
import com.mpl.androidapp.miniprofile.ct.C.ReminderSet;
import com.mpl.androidapp.utils.Constant;
import com.smartfoxserver.v2.entities.data.ISFSArray;
import com.smartfoxserver.v2.entities.data.ISFSObject;
import com.smartfoxserver.v2.entities.data.SFSArray;
import com.smartfoxserver.v2.entities.data.SFSArrayLite;
import com.smartfoxserver.v2.entities.data.SFSDataType;
import com.smartfoxserver.v2.entities.data.SFSDataWrapper;
import com.smartfoxserver.v2.entities.data.SFSObject;
import com.smartfoxserver.v2.entities.data.SFSObjectLite;
import com.smartfoxserver.v2.exceptions.SFSCodecException;
import com.smartfoxserver.v2.exceptions.SFSRuntimeException;
import java.lang.reflect.Array;
import java.lang.reflect.Field;
import java.lang.reflect.Modifier;
import java.nio.ByteBuffer;
import java.sql.Blob;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.LinkedHashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.PriorityQueue;
import java.util.TreeSet;
import java.util.Vector;
import java.util.concurrent.ConcurrentLinkedQueue;
import java.util.concurrent.CopyOnWriteArrayList;
import java.util.concurrent.CopyOnWriteArraySet;
import java.util.concurrent.DelayQueue;
import java.util.concurrent.LinkedBlockingDeque;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.PriorityBlockingQueue;
import net.sf.json.JSONArray;
import net.sf.json.JSONArray.JSONArrayListIterator;
import net.sf.json.JSONObject;
import org.apache.commons.lang.StringUtils;
import org.apache.pdfbox.pdmodel.documentinterchange.taggedpdf.PDListAttributeObject;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class DefaultSFSDataSerializer implements ISFSDataSerializer {
    public static /* synthetic */ int[] $SWITCH_TABLE$com$smartfoxserver$v2$entities$data$SFSDataType = null;
    public static int BUFFER_CHUNK_SIZE = 512;
    public static final String CLASS_FIELDS_KEY = "$F";
    public static final String CLASS_MARKER_KEY = "$C";
    public static final String FIELD_NAME_KEY = "N";
    public static final String FIELD_VALUE_KEY = "V";
    public static DefaultSFSDataSerializer instance = new DefaultSFSDataSerializer();
    public final Logger logger = LoggerFactory.getLogger(DefaultSFSDataSerializer.class);

    /* JADX WARNING: Can't wrap try/catch for region: R(46:3|(2:4|5)|6|(2:8|9)|10|(2:12|13)|14|(2:16|17)|18|(2:20|21)|22|(2:24|25)|26|(2:28|29)|30|32|33|34|(2:36|37)|38|(2:40|41)|42|44|45|46|47|48|49|50|51|52|54|55|56|57|58|59|60|61|62|63|64|65|(2:66|67)|68|70) */
    /* JADX WARNING: Can't wrap try/catch for region: R(47:3|(2:4|5)|6|(2:8|9)|10|12|13|14|(2:16|17)|18|(2:20|21)|22|(2:24|25)|26|(2:28|29)|30|32|33|34|(2:36|37)|38|(2:40|41)|42|44|45|46|47|48|49|50|51|52|54|55|56|57|58|59|60|61|62|63|64|65|(2:66|67)|68|70) */
    /* JADX WARNING: Can't wrap try/catch for region: R(49:3|(2:4|5)|6|8|9|10|12|13|14|(2:16|17)|18|(2:20|21)|22|(2:24|25)|26|28|29|30|32|33|34|(2:36|37)|38|(2:40|41)|42|44|45|46|47|48|49|50|51|52|54|55|56|57|58|59|60|61|62|63|64|65|(2:66|67)|68|70) */
    /* JADX WARNING: Can't wrap try/catch for region: R(51:3|4|5|6|8|9|10|12|13|14|(2:16|17)|18|(2:20|21)|22|24|25|26|28|29|30|32|33|34|(2:36|37)|38|(2:40|41)|42|44|45|46|47|48|49|50|51|52|54|55|56|57|58|59|60|61|62|63|64|65|(2:66|67)|68|70) */
    /* JADX WARNING: Failed to process nested try/catch */
    /* JADX WARNING: Missing exception handler attribute for start block: B:46:0x0055 */
    /* JADX WARNING: Missing exception handler attribute for start block: B:48:0x0059 */
    /* JADX WARNING: Missing exception handler attribute for start block: B:50:0x005d */
    /* JADX WARNING: Missing exception handler attribute for start block: B:56:0x006a */
    /* JADX WARNING: Missing exception handler attribute for start block: B:58:0x006e */
    /* JADX WARNING: Missing exception handler attribute for start block: B:60:0x0072 */
    /* JADX WARNING: Missing exception handler attribute for start block: B:62:0x0076 */
    /* JADX WARNING: Missing exception handler attribute for start block: B:64:0x007c */
    /* JADX WARNING: Missing exception handler attribute for start block: B:66:0x0080 */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static /* synthetic */ int[] $SWITCH_TABLE$com$smartfoxserver$v2$entities$data$SFSDataType() {
        /*
            int[] r0 = $SWITCH_TABLE$com$smartfoxserver$v2$entities$data$SFSDataType
            if (r0 == 0) goto L_0x0005
            return r0
        L_0x0005:
            com.smartfoxserver.v2.entities.data.SFSDataType[] r0 = com.smartfoxserver.v2.entities.data.SFSDataType.values()
            int r0 = r0.length
            int[] r0 = new int[r0]
            r1 = 2
            r2 = 1
            com.smartfoxserver.v2.entities.data.SFSDataType r3 = com.smartfoxserver.v2.entities.data.SFSDataType.BOOL     // Catch:{ NoSuchFieldError -> 0x0012 }
            r0[r2] = r1     // Catch:{ NoSuchFieldError -> 0x0012 }
        L_0x0012:
            r3 = 10
            r4 = 9
            com.smartfoxserver.v2.entities.data.SFSDataType r5 = com.smartfoxserver.v2.entities.data.SFSDataType.BOOL_ARRAY     // Catch:{ NoSuchFieldError -> 0x001a }
            r0[r4] = r3     // Catch:{ NoSuchFieldError -> 0x001a }
        L_0x001a:
            r5 = 3
            com.smartfoxserver.v2.entities.data.SFSDataType r6 = com.smartfoxserver.v2.entities.data.SFSDataType.BYTE     // Catch:{ NoSuchFieldError -> 0x001f }
            r0[r1] = r5     // Catch:{ NoSuchFieldError -> 0x001f }
        L_0x001f:
            r1 = 11
            com.smartfoxserver.v2.entities.data.SFSDataType r6 = com.smartfoxserver.v2.entities.data.SFSDataType.BYTE_ARRAY     // Catch:{ NoSuchFieldError -> 0x0025 }
            r0[r3] = r1     // Catch:{ NoSuchFieldError -> 0x0025 }
        L_0x0025:
            r3 = 20
            r6 = 19
            com.smartfoxserver.v2.entities.data.SFSDataType r7 = com.smartfoxserver.v2.entities.data.SFSDataType.CLASS     // Catch:{ NoSuchFieldError -> 0x002d }
            r0[r6] = r3     // Catch:{ NoSuchFieldError -> 0x002d }
        L_0x002d:
            r7 = 8
            r8 = 7
            com.smartfoxserver.v2.entities.data.SFSDataType r9 = com.smartfoxserver.v2.entities.data.SFSDataType.DOUBLE     // Catch:{ NoSuchFieldError -> 0x0034 }
            r0[r8] = r7     // Catch:{ NoSuchFieldError -> 0x0034 }
        L_0x0034:
            r9 = 16
            r10 = 15
            com.smartfoxserver.v2.entities.data.SFSDataType r11 = com.smartfoxserver.v2.entities.data.SFSDataType.DOUBLE_ARRAY     // Catch:{ NoSuchFieldError -> 0x003c }
            r0[r10] = r9     // Catch:{ NoSuchFieldError -> 0x003c }
        L_0x003c:
            r11 = 6
            com.smartfoxserver.v2.entities.data.SFSDataType r12 = com.smartfoxserver.v2.entities.data.SFSDataType.FLOAT     // Catch:{ NoSuchFieldError -> 0x0041 }
            r0[r11] = r8     // Catch:{ NoSuchFieldError -> 0x0041 }
        L_0x0041:
            r8 = 14
            com.smartfoxserver.v2.entities.data.SFSDataType r12 = com.smartfoxserver.v2.entities.data.SFSDataType.FLOAT_ARRAY     // Catch:{ NoSuchFieldError -> 0x0047 }
            r0[r8] = r10     // Catch:{ NoSuchFieldError -> 0x0047 }
        L_0x0047:
            r10 = 5
            r12 = 4
            com.smartfoxserver.v2.entities.data.SFSDataType r13 = com.smartfoxserver.v2.entities.data.SFSDataType.INT     // Catch:{ NoSuchFieldError -> 0x004d }
            r0[r12] = r10     // Catch:{ NoSuchFieldError -> 0x004d }
        L_0x004d:
            r13 = 13
            r14 = 12
            com.smartfoxserver.v2.entities.data.SFSDataType r15 = com.smartfoxserver.v2.entities.data.SFSDataType.INT_ARRAY     // Catch:{ NoSuchFieldError -> 0x0055 }
            r0[r14] = r13     // Catch:{ NoSuchFieldError -> 0x0055 }
        L_0x0055:
            com.smartfoxserver.v2.entities.data.SFSDataType r15 = com.smartfoxserver.v2.entities.data.SFSDataType.LONG     // Catch:{ NoSuchFieldError -> 0x0059 }
            r0[r10] = r11     // Catch:{ NoSuchFieldError -> 0x0059 }
        L_0x0059:
            com.smartfoxserver.v2.entities.data.SFSDataType r10 = com.smartfoxserver.v2.entities.data.SFSDataType.LONG_ARRAY     // Catch:{ NoSuchFieldError -> 0x005d }
            r0[r13] = r8     // Catch:{ NoSuchFieldError -> 0x005d }
        L_0x005d:
            com.smartfoxserver.v2.entities.data.SFSDataType r8 = com.smartfoxserver.v2.entities.data.SFSDataType.NULL     // Catch:{ NoSuchFieldError -> 0x0062 }
            r8 = 0
            r0[r8] = r2     // Catch:{ NoSuchFieldError -> 0x0062 }
        L_0x0062:
            r2 = 18
            r8 = 17
            com.smartfoxserver.v2.entities.data.SFSDataType r10 = com.smartfoxserver.v2.entities.data.SFSDataType.SFS_ARRAY     // Catch:{ NoSuchFieldError -> 0x006a }
            r0[r8] = r2     // Catch:{ NoSuchFieldError -> 0x006a }
        L_0x006a:
            com.smartfoxserver.v2.entities.data.SFSDataType r10 = com.smartfoxserver.v2.entities.data.SFSDataType.SFS_OBJECT     // Catch:{ NoSuchFieldError -> 0x006e }
            r0[r2] = r6     // Catch:{ NoSuchFieldError -> 0x006e }
        L_0x006e:
            com.smartfoxserver.v2.entities.data.SFSDataType r2 = com.smartfoxserver.v2.entities.data.SFSDataType.SHORT     // Catch:{ NoSuchFieldError -> 0x0072 }
            r0[r5] = r12     // Catch:{ NoSuchFieldError -> 0x0072 }
        L_0x0072:
            com.smartfoxserver.v2.entities.data.SFSDataType r2 = com.smartfoxserver.v2.entities.data.SFSDataType.SHORT_ARRAY     // Catch:{ NoSuchFieldError -> 0x0076 }
            r0[r1] = r14     // Catch:{ NoSuchFieldError -> 0x0076 }
        L_0x0076:
            com.smartfoxserver.v2.entities.data.SFSDataType r1 = com.smartfoxserver.v2.entities.data.SFSDataType.TEXT     // Catch:{ NoSuchFieldError -> 0x007c }
            r1 = 21
            r0[r3] = r1     // Catch:{ NoSuchFieldError -> 0x007c }
        L_0x007c:
            com.smartfoxserver.v2.entities.data.SFSDataType r1 = com.smartfoxserver.v2.entities.data.SFSDataType.UTF_STRING     // Catch:{ NoSuchFieldError -> 0x0080 }
            r0[r7] = r4     // Catch:{ NoSuchFieldError -> 0x0080 }
        L_0x0080:
            com.smartfoxserver.v2.entities.data.SFSDataType r1 = com.smartfoxserver.v2.entities.data.SFSDataType.UTF_STRING_ARRAY     // Catch:{ NoSuchFieldError -> 0x0084 }
            r0[r9] = r8     // Catch:{ NoSuchFieldError -> 0x0084 }
        L_0x0084:
            $SWITCH_TABLE$com$smartfoxserver$v2$entities$data$SFSDataType = r0
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.smartfoxserver.v2.protocol.serialization.DefaultSFSDataSerializer.$SWITCH_TABLE$com$smartfoxserver$v2$entities$data$SFSDataType():int[]");
    }

    private ByteBuffer addData(ByteBuffer byteBuffer, byte[] bArr) {
        if (byteBuffer.remaining() < bArr.length) {
            int i = BUFFER_CHUNK_SIZE;
            if (i < bArr.length) {
                i = bArr.length;
            }
            ByteBuffer allocate = ByteBuffer.allocate(byteBuffer.capacity() + i);
            byteBuffer.flip();
            allocate.put(byteBuffer);
            byteBuffer = allocate;
        }
        byteBuffer.put(bArr);
        return byteBuffer;
    }

    private byte[] arr2bin(ISFSArray iSFSArray, ByteBuffer byteBuffer) {
        for (SFSDataWrapper next : iSFSArray) {
            byteBuffer = encodeObject(byteBuffer, next.getTypeId(), next.getObject());
        }
        int position = byteBuffer.position();
        byte[] bArr = new byte[position];
        byteBuffer.flip();
        byteBuffer.get(bArr, 0, position);
        return bArr;
    }

    private SFSDataWrapper binDecode_BOOL(ByteBuffer byteBuffer) throws SFSCodecException {
        Boolean bool;
        byte b2 = byteBuffer.get();
        if (b2 == 0) {
            bool = new Boolean(false);
        } else if (b2 == 1) {
            bool = new Boolean(true);
        } else {
            throw new SFSCodecException((String) "Error decoding Bool type. Illegal value: null");
        }
        return new SFSDataWrapper(SFSDataType.BOOL, bool);
    }

    private SFSDataWrapper binDecode_BOOL_ARRAY(ByteBuffer byteBuffer) throws SFSCodecException {
        short typeArraySize = getTypeArraySize(byteBuffer);
        ArrayList arrayList = new ArrayList();
        for (int i = 0; i < typeArraySize; i++) {
            byte b2 = byteBuffer.get();
            if (b2 == 0) {
                arrayList.add(Boolean.FALSE);
            } else if (b2 == 1) {
                arrayList.add(Boolean.TRUE);
            } else {
                throw new SFSCodecException(GeneratedOutlineSupport.outline40("Error decoding BoolArray. Invalid bool value: ", b2));
            }
        }
        return new SFSDataWrapper(SFSDataType.BOOL_ARRAY, arrayList);
    }

    private SFSDataWrapper binDecode_BYTE(ByteBuffer byteBuffer) {
        return new SFSDataWrapper(SFSDataType.BYTE, Byte.valueOf(byteBuffer.get()));
    }

    private SFSDataWrapper binDecode_BYTE_ARRAY(ByteBuffer byteBuffer) throws SFSCodecException {
        int i = byteBuffer.getInt();
        if (i >= 0) {
            byte[] bArr = new byte[i];
            byteBuffer.get(bArr, 0, i);
            return new SFSDataWrapper(SFSDataType.BYTE_ARRAY, bArr);
        }
        throw new SFSCodecException(GeneratedOutlineSupport.outline40("Error decoding typed array size. Negative size: ", i));
    }

    private SFSDataWrapper binDecode_DOUBLE(ByteBuffer byteBuffer) {
        return new SFSDataWrapper(SFSDataType.DOUBLE, Double.valueOf(byteBuffer.getDouble()));
    }

    private SFSDataWrapper binDecode_DOUBLE_ARRAY(ByteBuffer byteBuffer) throws SFSCodecException {
        short typeArraySize = getTypeArraySize(byteBuffer);
        ArrayList arrayList = new ArrayList();
        for (int i = 0; i < typeArraySize; i++) {
            arrayList.add(Double.valueOf(byteBuffer.getDouble()));
        }
        return new SFSDataWrapper(SFSDataType.DOUBLE_ARRAY, arrayList);
    }

    private SFSDataWrapper binDecode_FLOAT(ByteBuffer byteBuffer) {
        return new SFSDataWrapper(SFSDataType.FLOAT, Float.valueOf(byteBuffer.getFloat()));
    }

    private SFSDataWrapper binDecode_FLOAT_ARRAY(ByteBuffer byteBuffer) throws SFSCodecException {
        short typeArraySize = getTypeArraySize(byteBuffer);
        ArrayList arrayList = new ArrayList();
        for (int i = 0; i < typeArraySize; i++) {
            arrayList.add(Float.valueOf(byteBuffer.getFloat()));
        }
        return new SFSDataWrapper(SFSDataType.FLOAT_ARRAY, arrayList);
    }

    private SFSDataWrapper binDecode_INT(ByteBuffer byteBuffer) {
        return new SFSDataWrapper(SFSDataType.INT, Integer.valueOf(byteBuffer.getInt()));
    }

    private SFSDataWrapper binDecode_INT_ARRAY(ByteBuffer byteBuffer) throws SFSCodecException {
        short typeArraySize = getTypeArraySize(byteBuffer);
        ArrayList arrayList = new ArrayList();
        for (int i = 0; i < typeArraySize; i++) {
            arrayList.add(Integer.valueOf(byteBuffer.getInt()));
        }
        return new SFSDataWrapper(SFSDataType.INT_ARRAY, arrayList);
    }

    private SFSDataWrapper binDecode_LONG(ByteBuffer byteBuffer) {
        return new SFSDataWrapper(SFSDataType.LONG, Long.valueOf(byteBuffer.getLong()));
    }

    private SFSDataWrapper binDecode_LONG_ARRAY(ByteBuffer byteBuffer) throws SFSCodecException {
        short typeArraySize = getTypeArraySize(byteBuffer);
        ArrayList arrayList = new ArrayList();
        for (int i = 0; i < typeArraySize; i++) {
            arrayList.add(Long.valueOf(byteBuffer.getLong()));
        }
        return new SFSDataWrapper(SFSDataType.LONG_ARRAY, arrayList);
    }

    private SFSDataWrapper binDecode_NULL(ByteBuffer byteBuffer) {
        return new SFSDataWrapper(SFSDataType.NULL, null);
    }

    private SFSDataWrapper binDecode_SHORT(ByteBuffer byteBuffer) {
        return new SFSDataWrapper(SFSDataType.SHORT, Short.valueOf(byteBuffer.getShort()));
    }

    private SFSDataWrapper binDecode_SHORT_ARRAY(ByteBuffer byteBuffer) throws SFSCodecException {
        short typeArraySize = getTypeArraySize(byteBuffer);
        ArrayList arrayList = new ArrayList();
        for (int i = 0; i < typeArraySize; i++) {
            arrayList.add(Short.valueOf(byteBuffer.getShort()));
        }
        return new SFSDataWrapper(SFSDataType.SHORT_ARRAY, arrayList);
    }

    private SFSDataWrapper binDecode_TEXT(ByteBuffer byteBuffer) throws SFSCodecException {
        int i = byteBuffer.getInt();
        if (i >= 0) {
            byte[] bArr = new byte[i];
            byteBuffer.get(bArr, 0, i);
            return new SFSDataWrapper(SFSDataType.TEXT, new String(bArr));
        }
        throw new SFSCodecException(GeneratedOutlineSupport.outline40("Error decoding UtfString. Negative size: ", i));
    }

    private SFSDataWrapper binDecode_UTF_STRING(ByteBuffer byteBuffer) throws SFSCodecException {
        short s = byteBuffer.getShort();
        if (s >= 0) {
            byte[] bArr = new byte[s];
            byteBuffer.get(bArr, 0, s);
            return new SFSDataWrapper(SFSDataType.UTF_STRING, new String(bArr));
        }
        throw new SFSCodecException(GeneratedOutlineSupport.outline40("Error decoding UtfString. Negative size: ", s));
    }

    private SFSDataWrapper binDecode_UTF_STRING_ARRAY(ByteBuffer byteBuffer) throws SFSCodecException {
        short typeArraySize = getTypeArraySize(byteBuffer);
        ArrayList arrayList = new ArrayList();
        int i = 0;
        while (i < typeArraySize) {
            short s = byteBuffer.getShort();
            if (s >= 0) {
                byte[] bArr = new byte[s];
                byteBuffer.get(bArr, 0, s);
                arrayList.add(new String(bArr));
                i++;
            } else {
                throw new SFSCodecException(GeneratedOutlineSupport.outline40("Error decoding UtfStringArray element. Element has negative size: ", s));
            }
        }
        return new SFSDataWrapper(SFSDataType.UTF_STRING_ARRAY, arrayList);
    }

    private ByteBuffer binEncode_BOOL(ByteBuffer byteBuffer, Boolean bool) {
        return addData(byteBuffer, new byte[]{(byte) SFSDataType.BOOL.getTypeID(), bool.booleanValue()});
    }

    private ByteBuffer binEncode_BOOL_ARRAY(ByteBuffer byteBuffer, Collection<Boolean> collection) {
        ByteBuffer allocate = ByteBuffer.allocate(collection.size() + 3);
        allocate.put((byte) SFSDataType.BOOL_ARRAY.getTypeID());
        allocate.putShort((short) collection.size());
        for (Boolean booleanValue : collection) {
            allocate.put(booleanValue.booleanValue() ? (byte) 1 : 0);
        }
        return addData(byteBuffer, allocate.array());
    }

    private ByteBuffer binEncode_BYTE(ByteBuffer byteBuffer, Byte b2) {
        return addData(byteBuffer, new byte[]{(byte) SFSDataType.BYTE.getTypeID(), b2.byteValue()});
    }

    private ByteBuffer binEncode_BYTE_ARRAY(ByteBuffer byteBuffer, byte[] bArr) {
        ByteBuffer allocate = ByteBuffer.allocate(bArr.length + 5);
        allocate.put((byte) SFSDataType.BYTE_ARRAY.getTypeID());
        allocate.putInt(bArr.length);
        allocate.put(bArr);
        return addData(byteBuffer, allocate.array());
    }

    private ByteBuffer binEncode_DOUBLE(ByteBuffer byteBuffer, Double d2) {
        ByteBuffer allocate = ByteBuffer.allocate(9);
        allocate.put((byte) SFSDataType.DOUBLE.getTypeID());
        allocate.putDouble(d2.doubleValue());
        return addData(byteBuffer, allocate.array());
    }

    private ByteBuffer binEncode_DOUBLE_ARRAY(ByteBuffer byteBuffer, Collection<Double> collection) {
        ByteBuffer allocate = ByteBuffer.allocate((collection.size() * 8) + 3);
        allocate.put((byte) SFSDataType.DOUBLE_ARRAY.getTypeID());
        allocate.putShort((short) collection.size());
        for (Double doubleValue : collection) {
            allocate.putDouble(doubleValue.doubleValue());
        }
        return addData(byteBuffer, allocate.array());
    }

    private ByteBuffer binEncode_FLOAT(ByteBuffer byteBuffer, Float f2) {
        ByteBuffer allocate = ByteBuffer.allocate(5);
        allocate.put((byte) SFSDataType.FLOAT.getTypeID());
        allocate.putFloat(f2.floatValue());
        return addData(byteBuffer, allocate.array());
    }

    private ByteBuffer binEncode_FLOAT_ARRAY(ByteBuffer byteBuffer, Collection<Float> collection) {
        ByteBuffer allocate = ByteBuffer.allocate((collection.size() * 4) + 3);
        allocate.put((byte) SFSDataType.FLOAT_ARRAY.getTypeID());
        allocate.putShort((short) collection.size());
        for (Float floatValue : collection) {
            allocate.putFloat(floatValue.floatValue());
        }
        return addData(byteBuffer, allocate.array());
    }

    private ByteBuffer binEncode_INT(ByteBuffer byteBuffer, Integer num) {
        ByteBuffer allocate = ByteBuffer.allocate(5);
        allocate.put((byte) SFSDataType.INT.getTypeID());
        allocate.putInt(num.intValue());
        return addData(byteBuffer, allocate.array());
    }

    private ByteBuffer binEncode_INT_ARRAY(ByteBuffer byteBuffer, Collection<Integer> collection) {
        ByteBuffer allocate = ByteBuffer.allocate((collection.size() * 4) + 3);
        allocate.put((byte) SFSDataType.INT_ARRAY.getTypeID());
        allocate.putShort((short) collection.size());
        for (Integer intValue : collection) {
            allocate.putInt(intValue.intValue());
        }
        return addData(byteBuffer, allocate.array());
    }

    private ByteBuffer binEncode_LONG(ByteBuffer byteBuffer, Long l) {
        ByteBuffer allocate = ByteBuffer.allocate(9);
        allocate.put((byte) SFSDataType.LONG.getTypeID());
        allocate.putLong(l.longValue());
        return addData(byteBuffer, allocate.array());
    }

    private ByteBuffer binEncode_LONG_ARRAY(ByteBuffer byteBuffer, Collection<Long> collection) {
        ByteBuffer allocate = ByteBuffer.allocate((collection.size() * 8) + 3);
        allocate.put((byte) SFSDataType.LONG_ARRAY.getTypeID());
        allocate.putShort((short) collection.size());
        for (Long longValue : collection) {
            allocate.putLong(longValue.longValue());
        }
        return addData(byteBuffer, allocate.array());
    }

    private ByteBuffer binEncode_NULL(ByteBuffer byteBuffer) {
        return addData(byteBuffer, new byte[1]);
    }

    private ByteBuffer binEncode_SHORT(ByteBuffer byteBuffer, Short sh) {
        ByteBuffer allocate = ByteBuffer.allocate(3);
        allocate.put((byte) SFSDataType.SHORT.getTypeID());
        allocate.putShort(sh.shortValue());
        return addData(byteBuffer, allocate.array());
    }

    private ByteBuffer binEncode_SHORT_ARRAY(ByteBuffer byteBuffer, Collection<Short> collection) {
        ByteBuffer allocate = ByteBuffer.allocate((collection.size() * 2) + 3);
        allocate.put((byte) SFSDataType.SHORT_ARRAY.getTypeID());
        allocate.putShort((short) collection.size());
        for (Short shortValue : collection) {
            allocate.putShort(shortValue.shortValue());
        }
        return addData(byteBuffer, allocate.array());
    }

    private ByteBuffer binEncode_TEXT(ByteBuffer byteBuffer, String str) {
        byte[] bytes = str.getBytes();
        ByteBuffer allocate = ByteBuffer.allocate(bytes.length + 5);
        allocate.put((byte) SFSDataType.TEXT.getTypeID());
        allocate.putInt(bytes.length);
        allocate.put(bytes);
        return addData(byteBuffer, allocate.array());
    }

    private ByteBuffer binEncode_UTF_STRING(ByteBuffer byteBuffer, String str) {
        byte[] bytes = str.getBytes();
        ByteBuffer allocate = ByteBuffer.allocate(bytes.length + 3);
        allocate.put((byte) SFSDataType.UTF_STRING.getTypeID());
        allocate.putShort((short) bytes.length);
        allocate.put(bytes);
        return addData(byteBuffer, allocate.array());
    }

    private ByteBuffer binEncode_UTF_STRING_ARRAY(ByteBuffer byteBuffer, Collection<String> collection) {
        int size = collection.size();
        byte[][] bArr = new byte[size][];
        int i = 0;
        int i2 = 0;
        for (String bytes : collection) {
            byte[] bytes2 = bytes.getBytes();
            bArr[i] = bytes2;
            i2 += bytes2.length + 2;
            i++;
        }
        ByteBuffer allocate = ByteBuffer.allocate(i2 + 3);
        allocate.put((byte) SFSDataType.UTF_STRING_ARRAY.getTypeID());
        allocate.putShort((short) collection.size());
        for (int i3 = 0; i3 < size; i3++) {
            byte[] bArr2 = bArr[i3];
            allocate.putShort((short) bArr2.length);
            allocate.put(bArr2);
        }
        return addData(byteBuffer, allocate.array());
    }

    private void convertPojo(Object obj, ISFSObject iSFSObject) throws Exception {
        Object obj2;
        Class<?> cls = obj.getClass();
        String canonicalName = cls.getCanonicalName();
        if (canonicalName == null) {
            throw new IllegalArgumentException("Anonymous classes cannot be serialized!");
        } else if (obj instanceof SerializableSFSType) {
            SFSArray newInstance = SFSArray.newInstance();
            iSFSObject.putUtfString(CLASS_MARKER_KEY, canonicalName);
            iSFSObject.putSFSArray(CLASS_FIELDS_KEY, newInstance);
            for (Field field : cls.getDeclaredFields()) {
                try {
                    int modifiers = field.getModifiers();
                    if (!Modifier.isTransient(modifiers)) {
                        if (!Modifier.isStatic(modifiers)) {
                            String name = field.getName();
                            if (Modifier.isPublic(modifiers)) {
                                obj2 = field.get(obj);
                            } else {
                                obj2 = readValueFromGetter(name, field.getType().getSimpleName(), obj);
                            }
                            SFSObject newInstance2 = SFSObject.newInstance();
                            newInstance2.putUtfString("N", name);
                            newInstance2.put(FIELD_VALUE_KEY, wrapPojoField(obj2));
                            newInstance.addSFSObject(newInstance2);
                        }
                    }
                } catch (NoSuchMethodException e2) {
                    this.logger.info("-- No public getter -- Serializer skipping private field: " + field.getName() + ", from class: " + cls);
                    e2.printStackTrace();
                }
            }
        } else {
            throw new IllegalStateException("Cannot serialize object: " + obj + ", type: " + canonicalName + " -- It doesn't implement the SerializableSFSType interface");
        }
    }

    private void convertSFSObject(ISFSArray iSFSArray, Object obj) throws Exception {
        for (int i = 0; i < iSFSArray.size(); i++) {
            ISFSObject sFSObject = iSFSArray.getSFSObject(i);
            setObjectField(obj, sFSObject.getUtfString("N"), unwrapPojoField(sFSObject.get(FIELD_VALUE_KEY)));
        }
    }

    private SFSDataWrapper decodeJsonObject(Object obj) {
        Object obj2;
        if (obj instanceof Integer) {
            return new SFSDataWrapper(SFSDataType.INT, obj);
        }
        if (obj instanceof Long) {
            return new SFSDataWrapper(SFSDataType.LONG, obj);
        }
        if (obj instanceof Double) {
            return new SFSDataWrapper(SFSDataType.DOUBLE, obj);
        }
        if (obj instanceof Boolean) {
            return new SFSDataWrapper(SFSDataType.BOOL, obj);
        }
        if (obj instanceof String) {
            SFSDataType sFSDataType = SFSDataType.UTF_STRING;
            if (((String) obj).length() > 32767) {
                sFSDataType = SFSDataType.TEXT;
            }
            return new SFSDataWrapper(sFSDataType, obj);
        } else if (obj instanceof JSONObject) {
            JSONObject jSONObject = (JSONObject) obj;
            if (jSONObject.nullObject) {
                return new SFSDataWrapper(SFSDataType.NULL, null);
            }
            return new SFSDataWrapper(SFSDataType.SFS_OBJECT, decodeSFSObject(jSONObject));
        } else if (obj instanceof JSONArray) {
            return new SFSDataWrapper(SFSDataType.SFS_ARRAY, decodeSFSArray((JSONArray) obj));
        } else {
            Object[] objArr = new Object[2];
            objArr[0] = obj;
            if (obj == null) {
                obj2 = "null";
            } else {
                obj2 = obj.getClass();
            }
            objArr[1] = obj2;
            throw new IllegalArgumentException(String.format("Unrecognized DataType while converting JSONObject 2 SFSObject. Object: %s, Type: %s", objArr));
        }
    }

    private SFSDataWrapper decodeObject(ByteBuffer byteBuffer) throws SFSCodecException {
        byte b2 = byteBuffer.get();
        if (b2 == SFSDataType.NULL.getTypeID()) {
            return binDecode_NULL(byteBuffer);
        }
        if (b2 == SFSDataType.BOOL.getTypeID()) {
            return binDecode_BOOL(byteBuffer);
        }
        if (b2 == SFSDataType.BOOL_ARRAY.getTypeID()) {
            return binDecode_BOOL_ARRAY(byteBuffer);
        }
        if (b2 == SFSDataType.BYTE.getTypeID()) {
            return binDecode_BYTE(byteBuffer);
        }
        if (b2 == SFSDataType.BYTE_ARRAY.getTypeID()) {
            return binDecode_BYTE_ARRAY(byteBuffer);
        }
        if (b2 == SFSDataType.SHORT.getTypeID()) {
            return binDecode_SHORT(byteBuffer);
        }
        if (b2 == SFSDataType.SHORT_ARRAY.getTypeID()) {
            return binDecode_SHORT_ARRAY(byteBuffer);
        }
        if (b2 == SFSDataType.INT.getTypeID()) {
            return binDecode_INT(byteBuffer);
        }
        if (b2 == SFSDataType.INT_ARRAY.getTypeID()) {
            return binDecode_INT_ARRAY(byteBuffer);
        }
        if (b2 == SFSDataType.LONG.getTypeID()) {
            return binDecode_LONG(byteBuffer);
        }
        if (b2 == SFSDataType.LONG_ARRAY.getTypeID()) {
            return binDecode_LONG_ARRAY(byteBuffer);
        }
        if (b2 == SFSDataType.FLOAT.getTypeID()) {
            return binDecode_FLOAT(byteBuffer);
        }
        if (b2 == SFSDataType.FLOAT_ARRAY.getTypeID()) {
            return binDecode_FLOAT_ARRAY(byteBuffer);
        }
        if (b2 == SFSDataType.DOUBLE.getTypeID()) {
            return binDecode_DOUBLE(byteBuffer);
        }
        if (b2 == SFSDataType.DOUBLE_ARRAY.getTypeID()) {
            return binDecode_DOUBLE_ARRAY(byteBuffer);
        }
        if (b2 == SFSDataType.UTF_STRING.getTypeID()) {
            return binDecode_UTF_STRING(byteBuffer);
        }
        if (b2 == SFSDataType.TEXT.getTypeID()) {
            return binDecode_TEXT(byteBuffer);
        }
        if (b2 == SFSDataType.UTF_STRING_ARRAY.getTypeID()) {
            return binDecode_UTF_STRING_ARRAY(byteBuffer);
        }
        if (b2 == SFSDataType.SFS_ARRAY.getTypeID()) {
            byteBuffer.position(byteBuffer.position() - 1);
            return new SFSDataWrapper(SFSDataType.SFS_ARRAY, decodeSFSArray(byteBuffer));
        } else if (b2 == SFSDataType.SFS_OBJECT.getTypeID()) {
            byteBuffer.position(byteBuffer.position() - 1);
            ISFSObject decodeSFSObject = decodeSFSObject(byteBuffer);
            SFSDataType sFSDataType = SFSDataType.SFS_OBJECT;
            if (decodeSFSObject.containsKey(CLASS_MARKER_KEY) && decodeSFSObject.containsKey(CLASS_FIELDS_KEY)) {
                sFSDataType = SFSDataType.CLASS;
                decodeSFSObject = sfs2pojo(decodeSFSObject);
            }
            return new SFSDataWrapper(sFSDataType, decodeSFSObject);
        } else {
            throw new SFSCodecException(GeneratedOutlineSupport.outline40("Unknow SFSDataType ID: ", b2));
        }
    }

    private ISFSArray decodeSFSArray(ByteBuffer byteBuffer) {
        SFSArray newInstance = SFSArray.newInstance();
        byte b2 = byteBuffer.get();
        if (b2 == SFSDataType.SFS_ARRAY.getTypeID()) {
            short s = byteBuffer.getShort();
            if (s >= 0) {
                int i = 0;
                while (i < s) {
                    try {
                        SFSDataWrapper decodeObject = decodeObject(byteBuffer);
                        if (decodeObject != null) {
                            newInstance.add(decodeObject);
                            i++;
                        } else {
                            throw new IllegalStateException("Could not decode SFSArray item at index: " + i);
                        }
                    } catch (SFSCodecException e2) {
                        throw new IllegalArgumentException(e2.getMessage());
                    }
                }
                return newInstance;
            }
            throw new IllegalStateException(GeneratedOutlineSupport.outline40("Can't decode SFSArray. Size is negative = ", s));
        }
        throw new IllegalStateException("Invalid SFSDataType. Expected: " + SFSDataType.SFS_ARRAY.getTypeID() + ", found: " + b2);
    }

    private ISFSObject decodeSFSObject(ByteBuffer byteBuffer) {
        SFSObject newInstance = SFSObject.newInstance();
        byte b2 = byteBuffer.get();
        if (b2 == SFSDataType.SFS_OBJECT.getTypeID()) {
            short s = byteBuffer.getShort();
            if (s >= 0) {
                int i = 0;
                while (i < s) {
                    try {
                        short s2 = byteBuffer.getShort();
                        if (s2 < 0 || s2 > 255) {
                            throw new IllegalStateException("Invalid SFSObject key length. Found = " + s2);
                        }
                        byte[] bArr = new byte[s2];
                        byteBuffer.get(bArr, 0, s2);
                        String str = new String(bArr);
                        SFSDataWrapper decodeObject = decodeObject(byteBuffer);
                        if (decodeObject != null) {
                            newInstance.put(str, decodeObject);
                            i++;
                        } else {
                            throw new IllegalStateException("Could not decode value for key: " + bArr);
                        }
                    } catch (SFSCodecException e2) {
                        throw new IllegalArgumentException(e2.getMessage());
                    }
                }
                return newInstance;
            }
            throw new IllegalStateException(GeneratedOutlineSupport.outline40("Can't decode SFSObject. Size is negative = ", s));
        }
        throw new IllegalStateException("Invalid SFSDataType. Expected: " + SFSDataType.SFS_OBJECT.getTypeID() + ", found: " + b2);
    }

    private ByteBuffer encodeObject(ByteBuffer byteBuffer, SFSDataType sFSDataType, Object obj) {
        switch ($SWITCH_TABLE$com$smartfoxserver$v2$entities$data$SFSDataType()[sFSDataType.ordinal()]) {
            case 1:
                return binEncode_NULL(byteBuffer);
            case 2:
                return binEncode_BOOL(byteBuffer, (Boolean) obj);
            case 3:
                return binEncode_BYTE(byteBuffer, (Byte) obj);
            case 4:
                return binEncode_SHORT(byteBuffer, (Short) obj);
            case 5:
                return binEncode_INT(byteBuffer, (Integer) obj);
            case 6:
                return binEncode_LONG(byteBuffer, (Long) obj);
            case 7:
                return binEncode_FLOAT(byteBuffer, (Float) obj);
            case 8:
                return binEncode_DOUBLE(byteBuffer, (Double) obj);
            case 9:
                return binEncode_UTF_STRING(byteBuffer, (String) obj);
            case 10:
                return binEncode_BOOL_ARRAY(byteBuffer, (Collection) obj);
            case 11:
                return binEncode_BYTE_ARRAY(byteBuffer, (byte[]) obj);
            case 12:
                return binEncode_SHORT_ARRAY(byteBuffer, (Collection) obj);
            case 13:
                return binEncode_INT_ARRAY(byteBuffer, (Collection) obj);
            case 14:
                return binEncode_LONG_ARRAY(byteBuffer, (Collection) obj);
            case 15:
                return binEncode_FLOAT_ARRAY(byteBuffer, (Collection) obj);
            case 16:
                return binEncode_DOUBLE_ARRAY(byteBuffer, (Collection) obj);
            case 17:
                return binEncode_UTF_STRING_ARRAY(byteBuffer, (Collection) obj);
            case 18:
                return addData(byteBuffer, array2binary((SFSArray) obj));
            case 19:
                return addData(byteBuffer, object2binary((SFSObject) obj));
            case 20:
                return addData(byteBuffer, object2binary(pojo2sfs(obj)));
            case 21:
                return binEncode_TEXT(byteBuffer, (String) obj);
            default:
                throw new IllegalArgumentException("Unrecognized type in SFSObject serialization: " + sFSDataType);
        }
    }

    private ByteBuffer encodeSFSObjectKey(ByteBuffer byteBuffer, String str) {
        ByteBuffer allocate = ByteBuffer.allocate(str.length() + 2);
        allocate.putShort((short) str.length());
        allocate.put(str.getBytes());
        return addData(byteBuffer, allocate.array());
    }

    /* JADX WARNING: Can't wrap try/catch for region: R(2:5|6) */
    /* JADX WARNING: Code restructure failed: missing block: B:4:0x0013, code lost:
        r5 = move-exception;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:6:?, code lost:
        r1 = r4.logger;
        r1.warn("SFSObject serialize error. Failed reading BLOB data for column: " + r5);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:8:0x002a, code lost:
        org.apache.commons.io.IOUtils.closeQuietly(r0);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:9:0x002d, code lost:
        throw r5;
     */
    /* JADX WARNING: Failed to process nested try/catch */
    /* JADX WARNING: Missing exception handler attribute for start block: B:5:0x0015 */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private byte[] getBlobData(java.lang.String r5, java.io.InputStream r6) {
        /*
            r4 = this;
            java.io.BufferedInputStream r0 = new java.io.BufferedInputStream
            r0.<init>(r6)
            r6 = 0
            int r1 = r0.available()     // Catch:{ IOException -> 0x0015 }
            byte[] r6 = new byte[r1]     // Catch:{ IOException -> 0x0015 }
            r0.read(r6)     // Catch:{ IOException -> 0x0015 }
        L_0x000f:
            org.apache.commons.io.IOUtils.closeQuietly(r0)
            goto L_0x0029
        L_0x0013:
            r5 = move-exception
            goto L_0x002a
        L_0x0015:
            org.slf4j.Logger r1 = r4.logger     // Catch:{ all -> 0x0013 }
            java.lang.StringBuilder r2 = new java.lang.StringBuilder     // Catch:{ all -> 0x0013 }
            java.lang.String r3 = "SFSObject serialize error. Failed reading BLOB data for column: "
            r2.<init>(r3)     // Catch:{ all -> 0x0013 }
            r2.append(r5)     // Catch:{ all -> 0x0013 }
            java.lang.String r5 = r2.toString()     // Catch:{ all -> 0x0013 }
            r1.warn(r5)     // Catch:{ all -> 0x0013 }
            goto L_0x000f
        L_0x0029:
            return r6
        L_0x002a:
            org.apache.commons.io.IOUtils.closeQuietly(r0)
            throw r5
        */
        throw new UnsupportedOperationException("Method not decompiled: com.smartfoxserver.v2.protocol.serialization.DefaultSFSDataSerializer.getBlobData(java.lang.String, java.io.InputStream):byte[]");
    }

    public static DefaultSFSDataSerializer getInstance() {
        return instance;
    }

    private short getTypeArraySize(ByteBuffer byteBuffer) throws SFSCodecException {
        short s = byteBuffer.getShort();
        if (s >= 0) {
            return s;
        }
        throw new SFSCodecException(GeneratedOutlineSupport.outline40("Error decoding typed array size. Negative size: ", s));
    }

    private byte[] obj2bin(ISFSObject iSFSObject, ByteBuffer byteBuffer) {
        for (String next : iSFSObject.getKeys()) {
            SFSDataWrapper sFSDataWrapper = iSFSObject.get(next);
            byteBuffer = encodeObject(encodeSFSObjectKey(byteBuffer, next), sFSDataWrapper.getTypeId(), sFSDataWrapper.getObject());
        }
        int position = byteBuffer.position();
        byte[] bArr = new byte[position];
        byteBuffer.flip();
        byteBuffer.get(bArr, 0, position);
        return bArr;
    }

    private Object readValueFromGetter(String str, String str2, Object obj) throws Exception {
        StringBuilder sb = str2.equalsIgnoreCase("boolean") ? new StringBuilder("is") : new StringBuilder(Constant.GET);
        sb.append(StringUtils.capitalize(str));
        return obj.getClass().getMethod(sb.toString(), new Class[0]).invoke(obj, new Object[0]);
    }

    private Object rebuildArray(ISFSArray<SFSDataWrapper> iSFSArray) {
        ArrayList arrayList = new ArrayList();
        for (SFSDataWrapper unwrapPojoField : iSFSArray) {
            arrayList.add(unwrapPojoField(unwrapPojoField));
        }
        return arrayList;
    }

    private Object rebuildMap(ISFSObject iSFSObject) {
        HashMap hashMap = new HashMap();
        for (String next : iSFSObject.getKeys()) {
            hashMap.put(next, unwrapPojoField(iSFSObject.get(next)));
        }
        return hashMap;
    }

    private void setObjectField(Object obj, String str, Object obj2) throws Exception {
        Field declaredField = obj.getClass().getDeclaredField(str);
        int modifiers = declaredField.getModifiers();
        if (!Modifier.isTransient(modifiers)) {
            if (declaredField.getType().isArray()) {
                if (obj2 instanceof Collection) {
                    Collection collection = (Collection) obj2;
                    Object[] array = collection.toArray();
                    int size = collection.size();
                    Object newInstance = Array.newInstance(declaredField.getType().getComponentType(), size);
                    System.arraycopy(array, 0, newInstance, 0, size);
                    obj2 = newInstance;
                } else {
                    throw new SFSRuntimeException(GeneratedOutlineSupport.outline51("Problem during SFSObject => POJO conversion. Found array field in POJO: ", str, ", but data is not a Collection!"));
                }
            } else if (obj2 instanceof Collection) {
                Collection collection2 = (Collection) obj2;
                String simpleName = declaredField.getType().getSimpleName();
                if (simpleName.equals("ArrayList") || simpleName.equals(PDListAttributeObject.OWNER_LIST)) {
                    obj2 = new ArrayList(collection2);
                }
                if (simpleName.equals("CopyOnWriteArrayList")) {
                    obj2 = new CopyOnWriteArrayList(collection2);
                } else if (simpleName.equals("LinkedList")) {
                    obj2 = new LinkedList(collection2);
                } else if (simpleName.equals("Vector")) {
                    obj2 = new Vector(collection2);
                } else if (simpleName.equals(ReminderSet.STATE_SET) || simpleName.equals("HashSet")) {
                    obj2 = new HashSet(collection2);
                } else if (simpleName.equals("LinkedHashSet")) {
                    obj2 = new LinkedHashSet(collection2);
                } else if (simpleName.equals("TreeSet")) {
                    obj2 = new TreeSet(collection2);
                } else if (simpleName.equals("CopyOnWriteArraySet")) {
                    obj2 = new CopyOnWriteArraySet(collection2);
                } else if (simpleName.equals("Queue") || simpleName.equals("PriorityQueue")) {
                    obj2 = new PriorityQueue(collection2);
                } else if (simpleName.equals("BlockingQueue") || simpleName.equals("LinkedBlockingQueue")) {
                    obj2 = new LinkedBlockingQueue(collection2);
                } else if (simpleName.equals("PriorityBlockingQueue")) {
                    obj2 = new PriorityBlockingQueue(collection2);
                } else if (simpleName.equals("ConcurrentLinkedQueue")) {
                    obj2 = new ConcurrentLinkedQueue(collection2);
                } else if (simpleName.equals("DelayQueue")) {
                    obj2 = new DelayQueue(collection2);
                } else if (simpleName.equals("Deque") || simpleName.equals("ArrayDeque")) {
                    obj2 = new ArrayDeque(collection2);
                } else if (simpleName.equals("LinkedBlockingDeque")) {
                    obj2 = new LinkedBlockingDeque(collection2);
                }
            }
            if (Modifier.isPublic(modifiers)) {
                declaredField.set(obj, obj2);
            } else {
                writeValueFromSetter(declaredField, obj, obj2);
            }
        }
    }

    private ISFSArray unrollArray(Object[] objArr) {
        SFSArray newInstance = SFSArray.newInstance();
        for (Object wrapPojoField : objArr) {
            newInstance.add(wrapPojoField(wrapPojoField));
        }
        return newInstance;
    }

    private ISFSArray unrollCollection(Collection<Object> collection) {
        SFSArray newInstance = SFSArray.newInstance();
        for (Object wrapPojoField : collection) {
            newInstance.add(wrapPojoField(wrapPojoField));
        }
        return newInstance;
    }

    private ISFSObject unrollMap(Map map) {
        SFSObject newInstance = SFSObject.newInstance();
        for (Entry entry : map.entrySet()) {
            Object key = entry.getKey();
            if (key instanceof String) {
                newInstance.put((String) key, wrapPojoField(entry.getValue()));
            }
        }
        return newInstance;
    }

    private Object unwrapPojoField(SFSDataWrapper sFSDataWrapper) {
        SFSDataType typeId = sFSDataWrapper.getTypeId();
        if (typeId.getTypeID() <= SFSDataType.UTF_STRING.getTypeID()) {
            return sFSDataWrapper.getObject();
        }
        if (typeId == SFSDataType.SFS_ARRAY) {
            return rebuildArray((ISFSArray) sFSDataWrapper.getObject());
        }
        if (typeId == SFSDataType.SFS_OBJECT) {
            return rebuildMap((ISFSObject) sFSDataWrapper.getObject());
        }
        if (typeId == SFSDataType.CLASS) {
            return sFSDataWrapper.getObject();
        }
        return null;
    }

    private SFSDataWrapper wrapPojoField(Object obj) {
        SFSDataWrapper sFSDataWrapper = null;
        if (obj == null) {
            return new SFSDataWrapper(SFSDataType.NULL, null);
        }
        if (obj instanceof Boolean) {
            sFSDataWrapper = new SFSDataWrapper(SFSDataType.BOOL, obj);
        } else if (obj instanceof Byte) {
            sFSDataWrapper = new SFSDataWrapper(SFSDataType.BYTE, obj);
        } else if (obj instanceof Short) {
            sFSDataWrapper = new SFSDataWrapper(SFSDataType.SHORT, obj);
        } else if (obj instanceof Integer) {
            sFSDataWrapper = new SFSDataWrapper(SFSDataType.INT, obj);
        } else if (obj instanceof Long) {
            sFSDataWrapper = new SFSDataWrapper(SFSDataType.LONG, obj);
        } else if (obj instanceof Float) {
            sFSDataWrapper = new SFSDataWrapper(SFSDataType.FLOAT, obj);
        } else if (obj instanceof Double) {
            sFSDataWrapper = new SFSDataWrapper(SFSDataType.DOUBLE, obj);
        } else if (obj instanceof String) {
            sFSDataWrapper = new SFSDataWrapper(SFSDataType.UTF_STRING, obj);
        } else if (obj.getClass().isArray()) {
            sFSDataWrapper = new SFSDataWrapper(SFSDataType.SFS_ARRAY, unrollArray((Object[]) obj));
        } else if (obj instanceof Collection) {
            sFSDataWrapper = new SFSDataWrapper(SFSDataType.SFS_ARRAY, unrollCollection((Collection) obj));
        } else if (obj instanceof Map) {
            sFSDataWrapper = new SFSDataWrapper(SFSDataType.SFS_OBJECT, unrollMap((Map) obj));
        } else if (obj instanceof SerializableSFSType) {
            sFSDataWrapper = new SFSDataWrapper(SFSDataType.SFS_OBJECT, pojo2sfs(obj));
        }
        return sFSDataWrapper;
    }

    private void writeValueFromSetter(Field field, Object obj, Object obj2) throws Exception {
        try {
            obj.getClass().getMethod("set" + StringUtils.capitalize(field.getName()), new Class[]{field.getType()}).invoke(obj, new Object[]{obj2});
        } catch (NoSuchMethodException unused) {
            this.logger.info("-- No public setter -- Serializer skipping private field: " + field.getName() + ", from class: " + obj.getClass().getName());
        }
    }

    public byte[] array2binary(ISFSArray iSFSArray) {
        ByteBuffer allocate = ByteBuffer.allocate(BUFFER_CHUNK_SIZE);
        allocate.put((byte) SFSDataType.SFS_ARRAY.getTypeID());
        allocate.putShort((short) iSFSArray.size());
        return arr2bin(iSFSArray, allocate);
    }

    public String array2json(List<Object> list) {
        return JSONArray.fromObject(list).toString();
    }

    public ISFSArray binary2array(byte[] bArr) {
        if (bArr.length >= 3) {
            ByteBuffer allocate = ByteBuffer.allocate(bArr.length);
            allocate.put(bArr);
            allocate.flip();
            return decodeSFSArray(allocate);
        }
        throw new IllegalStateException(GeneratedOutlineSupport.outline57(new StringBuilder("Can't decode an SFSArray. Byte data is insufficient. Size: "), bArr.length, " bytes"));
    }

    public ISFSObject binary2object(byte[] bArr) {
        if (bArr.length >= 3) {
            ByteBuffer allocate = ByteBuffer.allocate(bArr.length);
            allocate.put(bArr);
            allocate.flip();
            return decodeSFSObject(allocate);
        }
        throw new IllegalStateException(GeneratedOutlineSupport.outline57(new StringBuilder("Can't decode an SFSObject. Byte data is insufficient. Size: "), bArr.length, " bytes"));
    }

    public void flattenArray(List<Object> list, SFSArray sFSArray) {
        Iterator<SFSDataWrapper> it = sFSArray.iterator();
        while (it.hasNext()) {
            SFSDataWrapper next = it.next();
            if (next.getTypeId() == SFSDataType.SFS_OBJECT) {
                HashMap hashMap = new HashMap();
                list.add(hashMap);
                flattenObject(hashMap, (SFSObject) next.getObject());
            } else if (next.getTypeId() == SFSDataType.SFS_ARRAY) {
                ArrayList arrayList = new ArrayList();
                list.add(arrayList);
                flattenArray(arrayList, (SFSArray) next.getObject());
            } else {
                list.add(next.getObject());
            }
        }
    }

    public void flattenObject(Map<String, Object> map, SFSObject sFSObject) {
        Iterator<Entry<String, SFSDataWrapper>> it = sFSObject.iterator();
        while (it.hasNext()) {
            Entry next = it.next();
            String str = (String) next.getKey();
            SFSDataWrapper sFSDataWrapper = (SFSDataWrapper) next.getValue();
            if (sFSDataWrapper.getTypeId() == SFSDataType.SFS_OBJECT) {
                HashMap hashMap = new HashMap();
                map.put(str, hashMap);
                flattenObject(hashMap, (SFSObject) sFSDataWrapper.getObject());
            } else if (sFSDataWrapper.getTypeId() == SFSDataType.SFS_ARRAY) {
                ArrayList arrayList = new ArrayList();
                map.put(str, arrayList);
                flattenArray(arrayList, (SFSArray) sFSDataWrapper.getObject());
            } else {
                map.put(str, sFSDataWrapper.getObject());
            }
        }
    }

    public int getUnsignedByte(byte b2) {
        return b2 & 255;
    }

    public ISFSArray json2array(String str) {
        if (str.length() >= 2) {
            return decodeSFSArray(JSONArray.fromObject(str));
        }
        throw new IllegalStateException("Can't decode SFSObject. JSON String is too short. Len: " + str.length());
    }

    public ISFSObject json2object(String str) {
        if (str.length() >= 2) {
            return decodeSFSObject(JSONObject.fromObject(str));
        }
        throw new IllegalStateException("Can't decode SFSObject. JSON String is too short. Len: " + str.length());
    }

    public byte[] object2binary(ISFSObject iSFSObject) {
        ByteBuffer allocate = ByteBuffer.allocate(BUFFER_CHUNK_SIZE);
        allocate.put((byte) SFSDataType.SFS_OBJECT.getTypeID());
        allocate.putShort((short) iSFSObject.size());
        return obj2bin(iSFSObject, allocate);
    }

    public String object2json(Map<String, Object> map) {
        return JSONObject.fromObject(map).toString();
    }

    public ISFSObject pojo2sfs(Object obj) {
        SFSObject newInstance = SFSObject.newInstance();
        try {
            convertPojo(obj, newInstance);
            return newInstance;
        } catch (Exception e2) {
            throw new SFSRuntimeException((Throwable) e2);
        }
    }

    public SFSArray resultSet2array(ResultSet resultSet) throws SQLException {
        SFSArray sFSArray = new SFSArray();
        while (resultSet.next()) {
            sFSArray.addSFSObject(resultSet2object(resultSet));
        }
        return sFSArray;
    }

    public SFSObject resultSet2object(ResultSet resultSet) throws SQLException {
        ResultSetMetaData metaData = resultSet.getMetaData();
        SFSObject sFSObject = new SFSObject();
        if (resultSet.isBeforeFirst()) {
            resultSet.next();
        }
        for (int i = 1; i <= metaData.getColumnCount(); i++) {
            String columnLabel = metaData.getColumnLabel(i);
            int columnType = metaData.getColumnType(i);
            if (resultSet.getObject(i) != null) {
                if (columnType == 0) {
                    sFSObject.putNull(columnLabel);
                } else if (columnType == 16) {
                    sFSObject.putBool(columnLabel, resultSet.getBoolean(i));
                } else if (columnType == 91) {
                    sFSObject.putLong(columnLabel, resultSet.getDate(i).getTime());
                } else if (columnType == 6 || columnType == 3 || columnType == 8 || columnType == 7) {
                    sFSObject.putDouble(columnLabel, resultSet.getDouble(i));
                } else if (columnType == 4 || columnType == -6 || columnType == 5) {
                    sFSObject.putInt(columnLabel, resultSet.getInt(i));
                } else if (columnType == -1 || columnType == 12 || columnType == 1) {
                    sFSObject.putUtfString(columnLabel, resultSet.getString(i));
                } else if (columnType == -9 || columnType == -16 || columnType == -15) {
                    sFSObject.putUtfString(columnLabel, resultSet.getNString(i));
                } else if (columnType == 93) {
                    sFSObject.putLong(columnLabel, resultSet.getTimestamp(i).getTime());
                } else if (columnType == -5) {
                    sFSObject.putLong(columnLabel, resultSet.getLong(i));
                } else if (columnType == -4) {
                    byte[] blobData = getBlobData(columnLabel, resultSet.getBinaryStream(i));
                    if (blobData != null) {
                        sFSObject.putByteArray(columnLabel, blobData);
                    }
                } else if (columnType == 2004) {
                    Blob blob = resultSet.getBlob(i);
                    sFSObject.putByteArray(columnLabel, blob.getBytes(0, (int) blob.length()));
                } else {
                    Logger logger2 = this.logger;
                    logger2.info("Skipping Unsupported SQL TYPE: " + columnType + ", Column:" + columnLabel);
                }
            }
        }
        return sFSObject;
    }

    public Object sfs2pojo(ISFSObject iSFSObject) {
        if (iSFSObject.containsKey(CLASS_MARKER_KEY) || iSFSObject.containsKey(CLASS_FIELDS_KEY)) {
            try {
                String utfString = iSFSObject.getUtfString(CLASS_MARKER_KEY);
                Object newInstance = Class.forName(utfString).newInstance();
                if (newInstance instanceof SerializableSFSType) {
                    convertSFSObject(iSFSObject.getSFSArray(CLASS_FIELDS_KEY), newInstance);
                    return newInstance;
                }
                throw new IllegalStateException("Cannot deserialize object: " + newInstance + ", type: " + utfString + " -- It doesn't implement the SerializableSFSType interface");
            } catch (Exception e2) {
                throw new SFSRuntimeException((Throwable) e2);
            }
        } else {
            throw new SFSRuntimeException((String) "The SFSObject passed does not represent any serialized class.");
        }
    }

    private ISFSArray decodeSFSArray(JSONArray jSONArray) {
        SFSArrayLite newInstance = SFSArrayLite.newInstance();
        if (jSONArray != null) {
            JSONArrayListIterator jSONArrayListIterator = new JSONArrayListIterator();
            while (jSONArrayListIterator.hasNext()) {
                Object next = jSONArrayListIterator.next();
                SFSDataWrapper decodeJsonObject = decodeJsonObject(next);
                if (decodeJsonObject != null) {
                    newInstance.add(decodeJsonObject);
                } else {
                    throw new IllegalStateException("(json2sfarray) Could not decode value for object: " + next);
                }
            }
            return newInstance;
        }
        throw null;
    }

    private ISFSObject decodeSFSObject(JSONObject jSONObject) {
        SFSObject newInstance = SFSObjectLite.newInstance();
        for (Object next : jSONObject.keySet()) {
            SFSDataWrapper decodeJsonObject = decodeJsonObject(jSONObject.get(next));
            if (decodeJsonObject != null) {
                newInstance.put((String) next, decodeJsonObject);
            } else {
                throw new IllegalStateException("(json2sfsobj) Could not decode value for key: " + next);
            }
        }
        return newInstance;
    }
}
