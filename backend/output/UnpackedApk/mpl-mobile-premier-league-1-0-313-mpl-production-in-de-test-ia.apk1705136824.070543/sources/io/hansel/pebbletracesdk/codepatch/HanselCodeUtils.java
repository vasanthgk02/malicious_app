package io.hansel.pebbletracesdk.codepatch;

import io.hansel.core.logger.HSLLogger;
import java.lang.reflect.Array;

public class HanselCodeUtils {
    public static boolean[] getBooleanArray(Object obj) {
        try {
            Class<?> cls = obj.getClass();
            if (cls.equals(boolean[].class)) {
                return (boolean[]) obj;
            }
            if (cls.isArray()) {
                int length = Array.getLength(obj);
                boolean[] zArr = new boolean[length];
                for (int i = 0; i < length; i++) {
                    zArr[i] = ((Boolean) Array.get(obj, i)).booleanValue();
                }
                return zArr;
            }
            return null;
        } catch (Throwable th) {
            HSLLogger.printStackTrace(th);
        }
    }

    public static byte[] getByteArray(Object obj) {
        try {
            Class<?> cls = obj.getClass();
            if (cls.equals(byte[].class)) {
                return (byte[]) obj;
            }
            if (cls.isArray()) {
                int length = Array.getLength(obj);
                byte[] bArr = new byte[length];
                for (int i = 0; i < length; i++) {
                    bArr[i] = ((Byte) Array.get(obj, i)).byteValue();
                }
                return bArr;
            }
            return null;
        } catch (Throwable th) {
            HSLLogger.printStackTrace(th);
        }
    }

    public static double[] getDoubleArray(Object obj) {
        try {
            Class<?> cls = obj.getClass();
            if (cls.equals(double[].class)) {
                return (double[]) obj;
            }
            if (cls.isArray()) {
                int length = Array.getLength(obj);
                double[] dArr = new double[length];
                for (int i = 0; i < length; i++) {
                    dArr[i] = ((Double) Array.get(obj, i)).doubleValue();
                }
                return dArr;
            }
            return null;
        } catch (Throwable th) {
            HSLLogger.printStackTrace(th);
        }
    }

    public static float[] getFloatArray(Object obj) {
        try {
            Class<?> cls = obj.getClass();
            if (cls.equals(float[].class)) {
                return (float[]) obj;
            }
            if (cls.isArray()) {
                int length = Array.getLength(obj);
                float[] fArr = new float[length];
                for (int i = 0; i < length; i++) {
                    fArr[i] = ((Float) Array.get(obj, i)).floatValue();
                }
                return fArr;
            }
            return null;
        } catch (Throwable th) {
            HSLLogger.printStackTrace(th);
        }
    }

    public static int[] getIntArray(Object obj) {
        try {
            Class<?> cls = obj.getClass();
            if (cls.equals(int[].class)) {
                return (int[]) obj;
            }
            if (cls.isArray()) {
                int length = Array.getLength(obj);
                int[] iArr = new int[length];
                for (int i = 0; i < length; i++) {
                    iArr[i] = ((Integer) Array.get(obj, i)).intValue();
                }
                return iArr;
            }
            return null;
        } catch (Throwable th) {
            HSLLogger.printStackTrace(th);
        }
    }

    public static long[] getLongArray(Object obj) {
        try {
            Class<?> cls = obj.getClass();
            if (cls.equals(long[].class)) {
                return (long[]) obj;
            }
            if (cls.isArray()) {
                int length = Array.getLength(obj);
                long[] jArr = new long[length];
                for (int i = 0; i < length; i++) {
                    jArr[i] = ((Long) Array.get(obj, i)).longValue();
                }
                return jArr;
            }
            return null;
        } catch (Throwable th) {
            HSLLogger.printStackTrace(th);
        }
    }

    public static short[] getShortArray(Object obj) {
        try {
            Class<?> cls = obj.getClass();
            if (cls.equals(short[].class)) {
                return (short[]) obj;
            }
            if (cls.isArray()) {
                int length = Array.getLength(obj);
                short[] sArr = new short[length];
                for (int i = 0; i < length; i++) {
                    sArr[i] = ((Short) Array.get(obj, i)).shortValue();
                }
                return sArr;
            }
            return null;
        } catch (Throwable th) {
            HSLLogger.printStackTrace(th);
        }
    }

    public static String[] getStringArray(Object obj) {
        try {
            Class<?> cls = obj.getClass();
            if (cls.equals(String[].class)) {
                return (String[]) obj;
            }
            if (cls.isArray()) {
                int length = Array.getLength(obj);
                String[] strArr = new String[length];
                for (int i = 0; i < length; i++) {
                    strArr[i] = (String) Array.get(obj, i);
                }
                return strArr;
            }
            return null;
        } catch (Throwable th) {
            HSLLogger.printStackTrace(th);
        }
    }
}
