package io.hansel.actions.configs;

import android.content.Context;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import com.android.tools.r8.GeneratedOutlineSupport;
import io.hansel.core.GetDataStatusListener;
import io.hansel.core.json.CoreJSONArray;
import io.hansel.core.json.CoreJSONException;
import io.hansel.core.json.CoreJSONObject;
import io.hansel.core.logger.HSLLogger;
import io.hansel.core.logger.LogGroup;
import io.hansel.core.module.EventsConstants;
import io.hansel.core.module.IMessageBroker;
import java.util.ArrayList;
import java.util.HashMap;
import org.jboss.netty.channel.ChannelPipelineCoverage;

public class a implements GetDataStatusListener {
    public static final a g = new a();

    /* renamed from: a  reason: collision with root package name */
    public Context f5049a;

    /* renamed from: b  reason: collision with root package name */
    public HashMap<String, d> f5050b = new HashMap<>();

    /* renamed from: c  reason: collision with root package name */
    public CoreJSONObject f5051c;

    /* renamed from: d  reason: collision with root package name */
    public HashMap<String, d> f5052d;

    /* renamed from: e  reason: collision with root package name */
    public CoreJSONObject f5053e;

    /* renamed from: f  reason: collision with root package name */
    public Boolean f5054f = Boolean.FALSE;

    private CoreJSONObject a() {
        SharedPreferences c2 = c();
        if (c2 == null) {
            return null;
        }
        String string = c2.getString("config_name_id", null);
        if (string != null) {
            try {
                return new CoreJSONObject(string);
            } catch (CoreJSONException e2) {
                HSLLogger.printStackTrace(e2);
            }
        }
        return null;
    }

    public static a b() {
        return g;
    }

    public static String b(String str) {
        a aVar = g;
        if (aVar.f5054f.booleanValue()) {
            LogGroup logGroup = LogGroup.GT;
            HSLLogger.d("ConfigsHandler: Reading from cache in getConfigIdFromName method.", logGroup);
            HSLLogger.d("ConfigsHandler: tempConfignameIdMap in onGetDataStarted is " + aVar.f5053e, logGroup);
            CoreJSONObject coreJSONObject = aVar.f5053e;
            if (coreJSONObject != null) {
                return coreJSONObject.optString(str);
            }
        } else {
            if (aVar.f5051c == null) {
                aVar.f5051c = aVar.a();
            }
            CoreJSONObject coreJSONObject2 = aVar.f5051c;
            if (coreJSONObject2 != null) {
                return coreJSONObject2.optString(str);
            }
        }
        return null;
    }

    private SharedPreferences c() {
        Context context = this.f5049a;
        if (context == null) {
            return null;
        }
        return context.getSharedPreferences("experiences_su", 0);
    }

    private CoreJSONObject c(String str) {
        SharedPreferences c2 = c();
        if (c2 == null) {
            return null;
        }
        String string = c2.getString(str, null);
        if (string != null) {
            try {
                return new CoreJSONObject(string);
            } catch (CoreJSONException e2) {
                HSLLogger.printStackTrace(e2);
            }
        }
        return null;
    }

    private void d(String str) {
        SharedPreferences c2 = c();
        if (c2 != null) {
            GeneratedOutlineSupport.outline93(c2, str);
        }
    }

    /* JADX WARNING: Code restructure failed: missing block: B:3:0x002a, code lost:
        if (r0 != null) goto L_0x002c;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public io.hansel.actions.configs.d a(java.lang.String r5) {
        /*
            r4 = this;
            java.lang.Boolean r0 = r4.f5054f
            boolean r0 = r0.booleanValue()
            r1 = 0
            if (r0 == 0) goto L_0x0033
            io.hansel.core.logger.LogGroup r0 = io.hansel.core.logger.LogGroup.GT
            java.lang.String r2 = "ConfigsHandler: Reading from cache in getConfig method."
            io.hansel.core.logger.HSLLogger.d(r2, r0)
            java.lang.StringBuilder r2 = new java.lang.StringBuilder
            r2.<init>()
            java.lang.String r3 = "ConfigsHandler: tempHanselConfigsMap in onGetDataStarted is "
            r2.append(r3)
            io.hansel.actions.configs.a r3 = g
            java.util.HashMap<java.lang.String, io.hansel.actions.configs.d> r3 = r3.f5052d
            r2.append(r3)
            java.lang.String r2 = r2.toString()
            io.hansel.core.logger.HSLLogger.d(r2, r0)
            java.util.HashMap<java.lang.String, io.hansel.actions.configs.d> r0 = r4.f5052d
            if (r0 == 0) goto L_0x0056
        L_0x002c:
            java.lang.Object r5 = r0.get(r5)
            io.hansel.actions.configs.d r5 = (io.hansel.actions.configs.d) r5
            return r5
        L_0x0033:
            android.content.Context r0 = r4.f5049a
            if (r0 == 0) goto L_0x0056
            java.util.HashMap<java.lang.String, io.hansel.actions.configs.d> r0 = r4.f5050b
            boolean r0 = r0.containsKey(r5)
            if (r0 != 0) goto L_0x0053
            io.hansel.core.json.CoreJSONObject r0 = r4.c(r5)
            java.util.HashMap<java.lang.String, io.hansel.actions.configs.d> r2 = r4.f5050b
            if (r0 == 0) goto L_0x0050
            io.hansel.actions.configs.d r1 = new io.hansel.actions.configs.d
            r1.<init>()
            io.hansel.actions.configs.d r1 = r1.a(r5, r0)
        L_0x0050:
            r2.put(r5, r1)
        L_0x0053:
            java.util.HashMap<java.lang.String, io.hansel.actions.configs.d> r0 = r4.f5050b
            goto L_0x002c
        L_0x0056:
            return r1
        */
        throw new UnsupportedOperationException("Method not decompiled: io.hansel.actions.configs.a.a(java.lang.String):io.hansel.actions.configs.d");
    }

    public void a(Context context) {
        this.f5049a = context;
    }

    public void a(CoreJSONObject coreJSONObject) {
        SharedPreferences c2 = c();
        if (c2 != null) {
            Editor edit = c2.edit();
            if (coreJSONObject != null) {
                this.f5050b.clear();
                this.f5051c = null;
                CoreJSONObject a2 = a();
                if (a2 == null) {
                    a2 = new CoreJSONObject();
                }
                if (coreJSONObject.optBoolean(ChannelPipelineCoverage.ALL, false)) {
                    edit.clear().apply();
                    edit = c().edit();
                    a2 = new CoreJSONObject();
                } else {
                    CoreJSONArray optJSONArray = coreJSONObject.optJSONArray("configs_to_delete");
                    if (optJSONArray != null && optJSONArray.length() > 0) {
                        int length = optJSONArray.length();
                        for (int i = 0; i < length; i++) {
                            String optString = optJSONArray.optString(i);
                            CoreJSONObject c3 = c(optString);
                            if (c3 != null) {
                                String optString2 = c3.optString("key");
                                if (a2.has(optString2)) {
                                    d(optString);
                                    a2.remove(optString2);
                                }
                            }
                        }
                    }
                }
                CoreJSONObject optJSONObject = coreJSONObject.optJSONObject("super_configs");
                if (optJSONObject != null) {
                    ArrayList arrayList = new ArrayList(optJSONObject.keySet());
                    int size = arrayList.size();
                    for (int i2 = 0; i2 < size; i2++) {
                        String str = (String) arrayList.get(i2);
                        edit.putString(str, optJSONObject.optJSONObject(str).toString());
                    }
                }
                CoreJSONObject optJSONObject2 = coreJSONObject.optJSONObject("config_name_id_map");
                if (optJSONObject2 != null) {
                    if (a2.length() > 0) {
                        ArrayList arrayList2 = new ArrayList(optJSONObject2.keySet());
                        int size2 = arrayList2.size();
                        for (int i3 = 0; i3 < size2; i3++) {
                            String str2 = (String) arrayList2.get(i3);
                            try {
                                a2.put(str2, (Object) optJSONObject2.optString(str2));
                            } catch (CoreJSONException e2) {
                                HSLLogger.printStackTrace(e2);
                            }
                        }
                    } else {
                        a2 = optJSONObject2;
                    }
                }
                edit.putString("config_name_id", a2.toString());
                edit.apply();
            }
        }
    }

    public void a(IMessageBroker iMessageBroker) {
        iMessageBroker.publishBlockingEvent(EventsConstants.REGISTER_GET_DATA_STATUS_LISTENER.name(), b());
    }

    public void onGetDataFinished() {
        HSLLogger.d("ConfigsHandler: onGetDataFinished method begin.", LogGroup.GT);
        this.f5054f = Boolean.FALSE;
    }

    public void onGetDataStarted() {
        HSLLogger.d("ConfigsHandler: onGetDataStarted method begin.", LogGroup.GT);
        this.f5053e = a();
        this.f5052d = new HashMap<>();
        for (String optString : this.f5053e.keySet()) {
            String optString2 = this.f5053e.optString(optString, null);
            if (optString2 != null) {
                this.f5052d.put(optString2, a(optString2));
            }
        }
        this.f5054f = Boolean.TRUE;
        StringBuilder outline73 = GeneratedOutlineSupport.outline73("ConfigsHandler: tempHanselConfigsMap in onGetDataStarted is ");
        a aVar = g;
        outline73.append(aVar.f5052d);
        String sb = outline73.toString();
        LogGroup logGroup = LogGroup.GT;
        HSLLogger.d(sb, logGroup);
        HSLLogger.d("ConfigsHandler: tempConfignameIdMap in onGetDataStarted is " + aVar.f5053e, logGroup);
        HSLLogger.d("ConfigsHandler: onGetDataStarted method end.", logGroup);
    }
}
