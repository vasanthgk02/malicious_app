package a.a.a.a;

import a.a.a.a.d.b;
import com.android.tools.r8.GeneratedOutlineSupport;
import com.mpl.MLog;
import com.mpl.network.modules.listeners.IResponseListener;

public class i extends IResponseListener<String> {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ j f2423a;

    public i(j jVar) {
        this.f2423a = jVar;
    }

    public void onResponseFail(Exception exc) {
        try {
            if (b.f6a) {
                MLog.e(IResponseListener.TAG, "onResponseFail: ", exc);
            }
            if (this.f2423a.f2424a.getResponseCallback() != null) {
                this.f2423a.f2424a.getResponseCallback().callback("fail");
                if (!this.f2423a.f2424a.getSendingOnFailure() && this.f2423a.f2425b != null && this.f2423a.f2425b.a() != null) {
                    int a2 = this.f2423a.f2425b.a().a(this.f2423a.f2427d);
                    b.a((String) IResponseListener.TAG, "sendEventToKafka:deleted index " + a2);
                }
            }
        } catch (Exception unused) {
        }
    }

    public void onResponseSuccess(Object obj) {
        String str = (String) obj;
        b.a((String) IResponseListener.TAG, GeneratedOutlineSupport.outline50("onResponseSuccess: ", str));
        try {
            if (!(this.f2423a.f2425b == null || this.f2423a.f2425b.a() == null)) {
                int a2 = this.f2423a.f2425b.a().a(this.f2423a.f2427d);
                b.a((String) IResponseListener.TAG, "sendEventToKafka:deleted index " + a2);
            }
            if (this.f2423a.f2424a.getResponseCallback() != null) {
                this.f2423a.f2424a.getResponseCallback().callback(str);
            }
        } catch (Exception unused) {
        }
    }

    public void progressResponse(long j, long j2, boolean z) {
    }
}
