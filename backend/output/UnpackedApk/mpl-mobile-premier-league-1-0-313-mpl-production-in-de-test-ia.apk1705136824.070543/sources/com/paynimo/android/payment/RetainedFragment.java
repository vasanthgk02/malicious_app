package com.paynimo.android.payment;

import android.os.Bundle;
import androidx.fragment.app.Fragment;
import com.paynimo.android.payment.model.a;

public class RetainedFragment extends Fragment {
    public a data;

    public a getData() {
        return this.data;
    }

    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        setRetainInstance(true);
    }

    public void setData(a aVar) {
        this.data = aVar;
    }
}
