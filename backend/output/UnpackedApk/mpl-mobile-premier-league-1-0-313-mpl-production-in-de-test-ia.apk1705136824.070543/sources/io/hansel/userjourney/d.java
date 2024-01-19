package io.hansel.userjourney;

import android.content.Context;
import com.android.tools.r8.GeneratedOutlineSupport;
import io.hansel.actions.HSLConfigDataType;
import io.hansel.actions.HSLConfigPriority;
import io.hansel.actions.HSLConfigSource;
import io.hansel.actions.HSLConfigSourceCode;
import io.hansel.core.GetDataStatusListener;
import io.hansel.core.base.utils.HSLVersion;
import io.hansel.core.logger.HSLLogger;
import io.hansel.core.logger.LogGroup;
import io.hansel.core.utils.HSLUtils;
import java.util.HashMap;

public class d extends HSLConfigSource implements GetDataStatusListener {

    /* renamed from: a  reason: collision with root package name */
    public HashMap<String, String> f5417a = new HashMap<>();

    /* renamed from: b  reason: collision with root package name */
    public HashMap<String, HashMap<String, Object>> f5418b = new HashMap<>();

    /* renamed from: c  reason: collision with root package name */
    public HashMap<String, String> f5419c = new HashMap<>();

    /* renamed from: d  reason: collision with root package name */
    public HashMap<String, HashMap<String, Object>> f5420d = new HashMap<>();

    /* renamed from: e  reason: collision with root package name */
    public Boolean f5421e = Boolean.FALSE;

    public d(Context context, HSLVersion hSLVersion) {
        super(context, hSLVersion);
    }

    public void clear() {
        this.f5417a.clear();
        this.f5418b.clear();
    }

    public Object getConfig(String str, HSLConfigDataType hSLConfigDataType) {
        Object obj = null;
        if (this.f5421e.booleanValue()) {
            LogGroup logGroup = LogGroup.GT;
            HSLLogger.d("JourneyConfigSource: Reading from cache in getConfig method.", logGroup);
            HSLLogger.d("JourneyConfigSource: tempConfigIdJourneyIdMap in getConfig is " + this.f5419c, logGroup);
            HSLLogger.d("JourneyConfigSource: tempJourneyIdConfigIdValueMap in getConfig is " + this.f5420d, logGroup);
            if (this.f5419c.containsKey(str)) {
                HashMap hashMap = this.f5420d.get(this.f5419c.get(str));
                if (hashMap != null) {
                    obj = hashMap.get(str);
                }
                return obj;
            }
        } else if (this.f5417a.containsKey(str)) {
            HashMap hashMap2 = this.f5418b.get(this.f5417a.get(str));
            if (hashMap2 != null) {
                obj = hashMap2.get(str);
            }
            return obj;
        } else {
            String g = p.g(this.mContext, str);
            if (HSLUtils.isSet(g)) {
                this.f5417a.put(str, g);
                HashMap hashMap3 = this.f5418b.get(g);
                if (hashMap3 == null) {
                    hashMap3 = new HashMap();
                }
                Object a2 = p.a(this.mContext, g, str, null, hSLConfigDataType);
                if (a2 == null) {
                    HSLLogger.d("Unable to find config value for id " + str + " in journey " + g);
                }
                hashMap3.put(str, a2);
                this.f5418b.put(g, hashMap3);
                return a2;
            }
        }
        return null;
    }

    public HSLConfigSourceCode getConfigSourceCode() {
        return HSLConfigSourceCode.ujm;
    }

    public int getPriority() {
        return HSLConfigPriority.JOURNEY.getPriority();
    }

    public void onGetDataFinished() {
        HSLLogger.d("JourneyConfigSource: onGetDataFinished method begin.", LogGroup.GT);
        this.f5421e = Boolean.FALSE;
    }

    public void onGetDataStarted() {
        HSLLogger.d("JourneyConfigSource: onGetDataStarted method begin.", LogGroup.GT);
        this.f5419c = p.e(this.mContext);
        this.f5420d = new HashMap<>();
        HashMap<String, String> hashMap = this.f5419c;
        if (hashMap != null) {
            for (String str : hashMap.keySet()) {
                String str2 = this.f5419c.get(str);
                if (str2 != null) {
                    this.f5420d.put(str2, p.d(this.mContext, str2));
                }
            }
        }
        this.f5421e = Boolean.TRUE;
        StringBuilder outline73 = GeneratedOutlineSupport.outline73("JourneyConfigSource: tempConfigIdJourneyIdMap in onGetDataStarted is ");
        outline73.append(this.f5419c);
        String sb = outline73.toString();
        LogGroup logGroup = LogGroup.GT;
        HSLLogger.d(sb, logGroup);
        HSLLogger.d("JourneyConfigSource: tempJourneyIdConfigIdValueMap in onGetDataStarted is " + this.f5420d, logGroup);
        HSLLogger.d("JourneyConfigSource: onGetDataStarted method end.", logGroup);
    }
}
