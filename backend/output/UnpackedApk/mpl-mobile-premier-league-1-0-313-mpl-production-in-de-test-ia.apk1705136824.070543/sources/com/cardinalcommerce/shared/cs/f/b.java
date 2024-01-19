package com.cardinalcommerce.shared.cs.f;

import android.annotation.SuppressLint;
import android.bluetooth.BluetoothDevice;
import android.bluetooth.BluetoothManager;
import android.content.Context;
import com.cardinalcommerce.shared.cs.utils.a;
import com.cardinalcommerce.shared.cs.utils.h;
import com.razorpay.AnalyticsConstants;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

public class b implements Serializable {

    /* renamed from: a  reason: collision with root package name */
    public char[] f2117a;

    /* renamed from: b  reason: collision with root package name */
    public List<char[]> f2118b;

    /* renamed from: c  reason: collision with root package name */
    public boolean f2119c;

    @SuppressLint({"MissingPermission", "HardwareIds"})
    public b(Context context) {
        BluetoothManager bluetoothManager = (BluetoothManager) context.getSystemService(AnalyticsConstants.BLUETOOTH);
        if (bluetoothManager != null && bluetoothManager.getAdapter() != null) {
            this.f2117a = h.a(bluetoothManager.getAdapter().getAddress());
            ArrayList arrayList = new ArrayList();
            for (BluetoothDevice name : bluetoothManager.getAdapter().getBondedDevices()) {
                arrayList.add(h.a(name.getName()));
            }
            this.f2118b = arrayList;
            this.f2119c = bluetoothManager.getAdapter().isEnabled();
        }
    }

    public JSONObject a() {
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.putOpt("Address", h.b(this.f2117a));
            if (this.f2118b != null && !this.f2118b.isEmpty()) {
                List<char[]> list = this.f2118b;
                StringBuilder sb = new StringBuilder();
                for (char[] append : list) {
                    sb.append(append);
                }
                jSONObject.putOpt("BondedDevices", new JSONArray(sb.toString()));
            }
            jSONObject.putOpt("IsBluetoothEnabled", Boolean.valueOf(this.f2119c));
        } catch (JSONException e2) {
            a.e().b(String.valueOf(13101), e2.getLocalizedMessage(), null);
        }
        return jSONObject;
    }
}
