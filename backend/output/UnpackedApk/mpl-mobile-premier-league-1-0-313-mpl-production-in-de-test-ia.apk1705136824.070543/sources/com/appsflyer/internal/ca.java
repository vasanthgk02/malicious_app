package com.appsflyer.internal;

import android.content.Context;
import com.appsflyer.AFLogger;
import com.appsflyer.internal.bz.c;
import java.lang.reflect.InvocationHandler;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;
import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

public final class ca {
    public final be AFInAppEventType;
    public boolean valueOf = false;
    public Map<String, Object> values;

    public ca(be beVar) {
        this.AFInAppEventType = beVar;
    }

    private boolean valueOf() {
        Map<String, Object> map = this.values;
        return map != null && !map.isEmpty();
    }

    public final Map<String, Object> AFInAppEventParameterName() {
        HashMap hashMap = new HashMap();
        if (valueOf()) {
            hashMap.put("lvl", this.values);
        } else if (this.valueOf) {
            HashMap hashMap2 = new HashMap();
            this.values = hashMap2;
            hashMap2.put("error", "operation timed out.");
            hashMap.put("lvl", this.values);
        }
        return hashMap;
    }

    public final boolean AFInAppEventType() {
        return this.valueOf && !valueOf();
    }

    public final boolean values() {
        try {
            Class.forName("com.appsflyer.lvl.AppsFlyerLVL");
            final long currentTimeMillis = System.currentTimeMillis();
            this.values = new ConcurrentHashMap();
            Context context = this.AFInAppEventType.values;
            AnonymousClass2 r5 = new c() {
                public final void AFKeystoreWrapper(String str, Exception exc) {
                    String message = exc.getMessage();
                    if (message == null) {
                        message = "unknown";
                    }
                    ca.this.values.put("error", message);
                    AFLogger.AFInAppEventParameterName(str, (Throwable) exc);
                }

                public final void values(String str, String str2) {
                    ca.this.values.put("signedData", str);
                    ca.this.values.put("signature", str2);
                    ca.this.values.put("ttr", Long.valueOf(System.currentTimeMillis() - currentTimeMillis));
                    AFLogger.values((String) "Successfully retrieved Google LVL data.");
                }
            };
            try {
                Class<?> cls = Class.forName("com.appsflyer.lvl.AppsFlyerLVL");
                Class<?> cls2 = Class.forName("com.appsflyer.lvl.AppsFlyerLVL$resultListener");
                Method method = cls.getMethod("checkLicense", new Class[]{Long.TYPE, Context.class, cls2});
                com.appsflyer.internal.bz.AnonymousClass2 r8 = new InvocationHandler() {
                    public final Object invoke(Object obj, Method method, Object[] objArr) {
                        if (method.getName().equals("onLvlResult")) {
                            String str = objArr[0] != null ? objArr[0] : null;
                            String str2 = objArr[1] != null ? objArr[1] : null;
                            c cVar = c.this;
                            if (cVar == null) {
                                AFLogger.AFInAppEventParameterName("onLvlResult invocation succeeded, but listener is null");
                            } else if (str != null && str2 != null) {
                                cVar.values(str, str2);
                            } else if (str2 == null) {
                                c.this.AFKeystoreWrapper("onLvlResult with error", new Exception("AFLVL Invalid signature"));
                            } else {
                                c.this.AFKeystoreWrapper("onLvlResult with error", new Exception("AFLVL Invalid signedData"));
                            }
                        } else if (method.getName().equals("onLvlFailure")) {
                            c cVar2 = c.this;
                            if (cVar2 == null) {
                                AFLogger.AFInAppEventParameterName("onLvlFailure: listener is null");
                            } else if (objArr[0] != null) {
                                cVar2.AFKeystoreWrapper("onLvlFailure with exception", objArr[0]);
                            } else {
                                cVar2.AFKeystoreWrapper("onLvlFailure", new Exception("unknown"));
                            }
                        } else {
                            c cVar3 = c.this;
                            if (cVar3 != null) {
                                cVar3.AFKeystoreWrapper("lvlInvocation failed", new Exception("com.appsflyer.lvl.AppsFlyerLVL$resultListener invocation failed"));
                            }
                        }
                        return null;
                    }
                };
                method.invoke(null, new Object[]{Long.valueOf(currentTimeMillis), context, Proxy.newProxyInstance(cls2.getClassLoader(), new Class[]{cls2}, r8)});
            } catch (ClassNotFoundException e2) {
                r5.AFKeystoreWrapper(e2.getClass().getSimpleName(), e2);
            } catch (NoSuchMethodException e3) {
                r5.AFKeystoreWrapper(e3.getClass().getSimpleName(), e3);
            } catch (IllegalAccessException e4) {
                r5.AFKeystoreWrapper(e4.getClass().getSimpleName(), e4);
            } catch (InvocationTargetException e5) {
                r5.AFKeystoreWrapper(e5.getClass().getSimpleName(), e5);
            }
            this.valueOf = true;
        } catch (ClassNotFoundException unused) {
            this.valueOf = false;
        }
        return this.valueOf;
    }
}
