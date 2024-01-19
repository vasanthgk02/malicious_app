package com.cardinalcommerce.dependencies.internal.minidev.json.d;

import java.util.ArrayList;
import java.util.List;

public class a<T> extends j<T> {

    /* renamed from: a  reason: collision with root package name */
    public static j<int[]> f1936a = new a<int[]>(null) {
        public Object a(Object obj) {
            List<Number> list = (List) obj;
            int[] iArr = new int[list.size()];
            int i = 0;
            for (Number intValue : list) {
                iArr[i] = intValue.intValue();
                i++;
            }
            return iArr;
        }
    };

    /* renamed from: b  reason: collision with root package name */
    public static j<Integer[]> f1937b = new a<Integer[]>(null) {
        public Object a(Object obj) {
            List list = (List) obj;
            Integer[] numArr = new Integer[list.size()];
            int i = 0;
            for (Object next : list) {
                if (next != null) {
                    if (next instanceof Integer) {
                        numArr[i] = (Integer) next;
                    } else {
                        numArr[i] = Integer.valueOf(((Number) next).intValue());
                    }
                    i++;
                }
            }
            return numArr;
        }
    };

    /* renamed from: e  reason: collision with root package name */
    public static j<byte[]> f1938e = new a<byte[]>(null) {
        public Object a(Object obj) {
            List<Number> list = (List) obj;
            byte[] bArr = new byte[list.size()];
            int i = 0;
            for (Number byteValue : list) {
                bArr[i] = byteValue.byteValue();
                i++;
            }
            return bArr;
        }
    };

    /* renamed from: f  reason: collision with root package name */
    public static j<Byte[]> f1939f = new a<Byte[]>(null) {
        public Object a(Object obj) {
            List list = (List) obj;
            Byte[] bArr = new Byte[list.size()];
            int i = 0;
            for (Object next : list) {
                if (next != null) {
                    if (next instanceof Byte) {
                        bArr[i] = (Byte) next;
                    } else {
                        bArr[i] = Byte.valueOf(((Number) next).byteValue());
                    }
                    i++;
                }
            }
            return bArr;
        }
    };
    public static j<char[]> g = new a<char[]>(null) {
        public Object a(Object obj) {
            List<Object> list = (List) obj;
            char[] cArr = new char[list.size()];
            int i = 0;
            for (Object obj2 : list) {
                cArr[i] = obj2.toString().charAt(0);
                i++;
            }
            return cArr;
        }
    };
    public static j<Character[]> h = new a<Character[]>(null) {
        public Object a(Object obj) {
            List list = (List) obj;
            Character[] chArr = new Character[list.size()];
            int i = 0;
            for (Object next : list) {
                if (next != null) {
                    chArr[i] = Character.valueOf(next.toString().charAt(0));
                    i++;
                }
            }
            return chArr;
        }
    };
    public static j<long[]> i = new a<long[]>(null) {
        public Object a(Object obj) {
            List<Number> list = (List) obj;
            long[] jArr = new long[list.size()];
            int i = 0;
            for (Number intValue : list) {
                jArr[i] = (long) intValue.intValue();
                i++;
            }
            return jArr;
        }
    };
    public static j<Long[]> j = new a<Long[]>(null) {
        public Object a(Object obj) {
            List list = (List) obj;
            Long[] lArr = new Long[list.size()];
            int i = 0;
            for (Object next : list) {
                if (next != null) {
                    if (next instanceof Float) {
                        lArr[i] = (Long) next;
                    } else {
                        lArr[i] = Long.valueOf(((Number) next).longValue());
                    }
                    i++;
                }
            }
            return lArr;
        }
    };
    public static j<float[]> k = new a<float[]>(null) {
        public Object a(Object obj) {
            List<Number> list = (List) obj;
            float[] fArr = new float[list.size()];
            int i = 0;
            for (Number floatValue : list) {
                fArr[i] = floatValue.floatValue();
                i++;
            }
            return fArr;
        }
    };
    public static j<Float[]> l = new a<Float[]>(null) {
        public Object a(Object obj) {
            List list = (List) obj;
            Float[] fArr = new Float[list.size()];
            int i = 0;
            for (Object next : list) {
                if (next != null) {
                    if (next instanceof Float) {
                        fArr[i] = (Float) next;
                    } else {
                        fArr[i] = Float.valueOf(((Number) next).floatValue());
                    }
                    i++;
                }
            }
            return fArr;
        }
    };
    public static j<double[]> m = new a<double[]>(null) {
        public Object a(Object obj) {
            List<Number> list = (List) obj;
            double[] dArr = new double[list.size()];
            int i = 0;
            for (Number doubleValue : list) {
                dArr[i] = doubleValue.doubleValue();
                i++;
            }
            return dArr;
        }
    };
    public static j<Double[]> n = new a<Double[]>(null) {
        public Object a(Object obj) {
            List list = (List) obj;
            Double[] dArr = new Double[list.size()];
            int i = 0;
            for (Object next : list) {
                if (next != null) {
                    if (next instanceof Double) {
                        dArr[i] = (Double) next;
                    } else {
                        dArr[i] = Double.valueOf(((Number) next).doubleValue());
                    }
                    i++;
                }
            }
            return dArr;
        }
    };
    public static j<boolean[]> o = new a<boolean[]>(null) {
        public Object a(Object obj) {
            List<Boolean> list = (List) obj;
            boolean[] zArr = new boolean[list.size()];
            int i = 0;
            for (Boolean booleanValue : list) {
                zArr[i] = booleanValue.booleanValue();
                i++;
            }
            return zArr;
        }
    };
    public static j<Boolean[]> p = new a<Boolean[]>(null) {
        public Object a(Object obj) {
            List list = (List) obj;
            Boolean[] boolArr = new Boolean[list.size()];
            int i = 0;
            for (Object next : list) {
                if (next != null) {
                    if (next instanceof Boolean) {
                        boolArr[i] = Boolean.valueOf(((Boolean) next).booleanValue());
                    } else if (next instanceof Number) {
                        boolArr[i] = Boolean.valueOf(((Number) next).intValue() != 0);
                    } else {
                        throw new RuntimeException("can not convert " + next + " toBoolean");
                    }
                    i++;
                }
            }
            return boolArr;
        }
    };

    public a(i iVar) {
        super(iVar);
    }

    public Object a() {
        return new ArrayList();
    }

    public void a(Object obj, Object obj2) {
        ((List) obj).add(obj2);
    }
}
