package com.google.android.gms.internal.auth;

import com.mpl.androidapp.utils.Constant;
import io.hansel.core.criteria.HSLCriteriaBuilder;
import java.lang.reflect.Method;
import java.lang.reflect.Modifier;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.TreeSet;
import org.apache.commons.lang.StringEscapeUtils;
import org.apache.pdfbox.pdmodel.documentinterchange.taggedpdf.PDListAttributeObject;

/* compiled from: com.google.android.gms:play-services-auth-base@@17.1.4 */
public final class zzfs {
    public static String zza(zzfq zzfq, String str) {
        StringBuilder sb = new StringBuilder();
        sb.append("# ");
        sb.append(str);
        zzd(zzfq, sb, 0);
        return sb.toString();
    }

    public static final void zzb(StringBuilder sb, int i, String str, Object obj) {
        if (obj instanceof List) {
            for (Object zzb : (List) obj) {
                zzb(sb, i, str, zzb);
            }
        } else if (obj instanceof Map) {
            for (Entry zzb2 : ((Map) obj).entrySet()) {
                zzb(sb, i, str, zzb2);
            }
        } else {
            sb.append(10);
            int i2 = 0;
            for (int i3 = 0; i3 < i; i3++) {
                sb.append(' ');
            }
            sb.append(str);
            if (obj instanceof String) {
                sb.append(": \"");
                sb.append(zzgn.zza(zzeb.zzl((String) obj)));
                sb.append(StringEscapeUtils.CSV_QUOTE);
            } else if (obj instanceof zzeb) {
                sb.append(": \"");
                sb.append(zzgn.zza((zzeb) obj));
                sb.append(StringEscapeUtils.CSV_QUOTE);
            } else if (obj instanceof zzeq) {
                sb.append(" {");
                zzd((zzeq) obj, sb, i + 2);
                sb.append("\n");
                while (i2 < i) {
                    sb.append(' ');
                    i2++;
                }
                sb.append("}");
            } else if (obj instanceof Entry) {
                sb.append(" {");
                Entry entry = (Entry) obj;
                int i4 = i + 2;
                zzb(sb, i4, "key", entry.getKey());
                zzb(sb, i4, HSLCriteriaBuilder.VALUE, entry.getValue());
                sb.append("\n");
                while (i2 < i) {
                    sb.append(' ');
                    i2++;
                }
                sb.append("}");
            } else {
                sb.append(": ");
                sb.append(obj.toString());
            }
        }
    }

    public static final String zzc(String str) {
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < str.length(); i++) {
            char charAt = str.charAt(i);
            if (Character.isUpperCase(charAt)) {
                sb.append("_");
            }
            sb.append(Character.toLowerCase(charAt));
        }
        return sb.toString();
    }

    public static void zzd(zzfq zzfq, StringBuilder sb, int i) {
        String str;
        String str2;
        String str3;
        String str4;
        boolean z;
        String str5;
        String str6;
        String str7;
        HashMap hashMap = new HashMap();
        HashMap hashMap2 = new HashMap();
        TreeSet treeSet = new TreeSet();
        for (Method method : zzfq.getClass().getDeclaredMethods()) {
            hashMap2.put(method.getName(), method);
            if (method.getParameterTypes().length == 0) {
                hashMap.put(method.getName(), method);
                if (method.getName().startsWith(Constant.GET)) {
                    treeSet.add(method.getName());
                }
            }
        }
        Iterator it = treeSet.iterator();
        while (it.hasNext()) {
            String str8 = (String) it.next();
            String substring = str8.startsWith(Constant.GET) ? str8.substring(3) : str8;
            if (substring.endsWith(PDListAttributeObject.OWNER_LIST) && !substring.endsWith("OrBuilderList") && !substring.equals(PDListAttributeObject.OWNER_LIST)) {
                String valueOf = String.valueOf(substring.substring(0, 1).toLowerCase());
                String valueOf2 = String.valueOf(substring.substring(1, substring.length() - 4));
                if (valueOf2.length() != 0) {
                    str7 = valueOf.concat(valueOf2);
                } else {
                    str7 = new String(valueOf);
                }
                Method method2 = (Method) hashMap.get(str8);
                if (method2 != null && method2.getReturnType().equals(List.class)) {
                    zzb(sb, i, zzc(str7), zzeq.zzf(method2, zzfq, new Object[0]));
                }
            }
            if (substring.endsWith("Map") && !substring.equals("Map")) {
                String valueOf3 = String.valueOf(substring.substring(0, 1).toLowerCase());
                String valueOf4 = String.valueOf(substring.substring(1, substring.length() - 3));
                if (valueOf4.length() != 0) {
                    str6 = valueOf3.concat(valueOf4);
                } else {
                    str6 = new String(valueOf3);
                }
                Method method3 = (Method) hashMap.get(str8);
                if (method3 != null && method3.getReturnType().equals(Map.class) && !method3.isAnnotationPresent(Deprecated.class) && Modifier.isPublic(method3.getModifiers())) {
                    zzb(sb, i, zzc(str6), zzeq.zzf(method3, zzfq, new Object[0]));
                }
            }
            if (substring.length() != 0) {
                str = "set".concat(substring);
            } else {
                str = new String("set");
            }
            if (((Method) hashMap2.get(str)) != null) {
                if (substring.endsWith("Bytes")) {
                    String valueOf5 = String.valueOf(substring.substring(0, substring.length() - 5));
                    if (valueOf5.length() != 0) {
                        str5 = Constant.GET.concat(valueOf5);
                    } else {
                        str5 = new String(Constant.GET);
                    }
                    if (hashMap.containsKey(str5)) {
                    }
                }
                String valueOf6 = String.valueOf(substring.substring(0, 1).toLowerCase());
                String valueOf7 = String.valueOf(substring.substring(1));
                if (valueOf7.length() != 0) {
                    str2 = valueOf6.concat(valueOf7);
                } else {
                    str2 = new String(valueOf6);
                }
                if (substring.length() != 0) {
                    str3 = Constant.GET.concat(substring);
                } else {
                    str3 = new String(Constant.GET);
                }
                Method method4 = (Method) hashMap.get(str3);
                if (substring.length() != 0) {
                    str4 = "has".concat(substring);
                } else {
                    str4 = new String("has");
                }
                Method method5 = (Method) hashMap.get(str4);
                if (method4 != null) {
                    Object zzf = zzeq.zzf(method4, zzfq, new Object[0]);
                    if (method5 == null) {
                        if (zzf instanceof Boolean) {
                            if (!((Boolean) zzf).booleanValue()) {
                            }
                        } else if (zzf instanceof Integer) {
                            if (((Integer) zzf).intValue() == 0) {
                            }
                        } else if (zzf instanceof Float) {
                            if (((Float) zzf).floatValue() == 0.0f) {
                            }
                        } else if (!(zzf instanceof Double)) {
                            if (zzf instanceof String) {
                                z = zzf.equals("");
                            } else if (zzf instanceof zzeb) {
                                z = zzf.equals(zzeb.zzb);
                            } else if (zzf instanceof zzfq) {
                                if (zzf == ((zzfq) zzf).zzh()) {
                                }
                            } else if ((zzf instanceof Enum) && ((Enum) zzf).ordinal() == 0) {
                            }
                            if (z) {
                            }
                        } else if (((Double) zzf).doubleValue() == 0.0d) {
                        }
                    } else if (!((Boolean) zzeq.zzf(method5, zzfq, new Object[0])).booleanValue()) {
                    }
                    zzb(sb, i, zzc(str2), zzf);
                }
            }
        }
        if (!(zzfq instanceof zzep)) {
            zzgq zzgq = ((zzeq) zzfq).zzc;
            if (zzgq != null) {
                zzgq.zze(sb, i);
                return;
            }
            return;
        }
        zzep zzep = (zzep) zzfq;
        throw null;
    }
}
