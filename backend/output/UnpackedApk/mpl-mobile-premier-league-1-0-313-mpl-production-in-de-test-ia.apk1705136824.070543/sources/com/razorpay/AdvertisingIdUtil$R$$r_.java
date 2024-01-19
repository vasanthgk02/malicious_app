package com.razorpay;

import android.content.Context;
import android.content.Intent;
import android.os.AsyncTask;
import com.razorpay.AdvertisingIdUtil.G__G_;
import com.razorpay.AdvertisingIdUtil.d__1_;

public class AdvertisingIdUtil$R$$r_ extends AsyncTask<Void, Void, String> {
    public Context Q_$2$;
    public d__1_ d__1_;

    public AdvertisingIdUtil$R$$r_(Context context, d__1_ d__1_2) {
        this.Q_$2$ = context;
        this.d__1_ = d__1_2;
    }

    private String d__1_() {
        String message;
        G__G_ g__g_ = new G__G_(0);
        Intent intent = new Intent("com.google.android.gms.ads.identifier.service.START");
        intent.setPackage("com.google.android.gms");
        if (!this.Q_$2$.bindService(intent, g__g_, 1)) {
            return AdvertisingIdUtil.R$$r_;
        }
        try {
            message = new AdvertisingIdUtil$Q_$2$(g__g_.a_$P$()).R$$r_();
        } catch (Exception e2) {
            message = e2.getMessage();
        } catch (Throwable th) {
            this.Q_$2$.unbindService(g__g_);
            throw th;
        }
        this.Q_$2$.unbindService(g__g_);
        return message;
    }

    public final /* synthetic */ Object doInBackground(Object[] objArr) {
        return d__1_();
    }

    public final /* synthetic */ void onPostExecute(Object obj) {
        String str = (String) obj;
        super.onPostExecute(str);
        this.d__1_.Q_$2$(str);
    }
}
