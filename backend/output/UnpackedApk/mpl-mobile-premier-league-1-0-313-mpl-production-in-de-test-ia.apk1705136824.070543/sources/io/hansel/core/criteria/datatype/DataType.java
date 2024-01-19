package io.hansel.core.criteria.datatype;

import com.facebook.react.modules.datepicker.DatePickerDialogModule;
import com.facebook.react.modules.network.NetworkingModule;
import com.mpl.androidapp.onesignal.OneSingnalConstant;
import com.netcore.android.notification.SMTNotificationConstants;
import com.paynimo.android.payment.UPIFragment;
import io.hansel.core.criteria.b;
import io.hansel.core.json.CoreJSONArray;
import io.hansel.core.json.CoreJSONObject;
import java.util.ArrayList;

public enum DataType {
    string(NetworkingModule.REQUEST_BODY_KEY_STRING),
    number(UPIFragment.CONFIG_TYPE_NUMBER),
    bool("boolean"),
    device_model(OneSingnalConstant.TAG_DEVICE_MODEL),
    array("array"),
    date(DatePickerDialogModule.ARG_DATE),
    other(SMTNotificationConstants.NOTIF_ATTRIBUTION_OTHER),
    language("language");
    
    public String mName;

    /* renamed from: io.hansel.core.criteria.datatype.DataType$1  reason: invalid class name */
    public static /* synthetic */ class AnonymousClass1 {
        public static final /* synthetic */ int[] $SwitchMap$io$hansel$core$criteria$datatype$DataType = null;

        /* JADX WARNING: Can't wrap try/catch for region: R(12:0|(2:1|2)|3|(2:5|6)|7|9|10|11|12|13|14|16) */
        /* JADX WARNING: Code restructure failed: missing block: B:17:?, code lost:
            return;
         */
        /* JADX WARNING: Failed to process nested try/catch */
        /* JADX WARNING: Missing exception handler attribute for start block: B:11:0x001d */
        /* JADX WARNING: Missing exception handler attribute for start block: B:13:0x0025 */
        static {
            /*
                io.hansel.core.criteria.datatype.DataType[] r0 = io.hansel.core.criteria.datatype.DataType.values()
                int r0 = r0.length
                int[] r0 = new int[r0]
                $SwitchMap$io$hansel$core$criteria$datatype$DataType = r0
                r1 = 1
                io.hansel.core.criteria.datatype.DataType r2 = io.hansel.core.criteria.datatype.DataType.string     // Catch:{ NoSuchFieldError -> 0x000f }
                r2 = 0
                r0[r2] = r1     // Catch:{ NoSuchFieldError -> 0x000f }
            L_0x000f:
                r0 = 2
                int[] r2 = $SwitchMap$io$hansel$core$criteria$datatype$DataType     // Catch:{ NoSuchFieldError -> 0x0016 }
                io.hansel.core.criteria.datatype.DataType r3 = io.hansel.core.criteria.datatype.DataType.number     // Catch:{ NoSuchFieldError -> 0x0016 }
                r2[r1] = r0     // Catch:{ NoSuchFieldError -> 0x0016 }
            L_0x0016:
                r1 = 3
                int[] r2 = $SwitchMap$io$hansel$core$criteria$datatype$DataType     // Catch:{ NoSuchFieldError -> 0x001d }
                io.hansel.core.criteria.datatype.DataType r3 = io.hansel.core.criteria.datatype.DataType.bool     // Catch:{ NoSuchFieldError -> 0x001d }
                r2[r0] = r1     // Catch:{ NoSuchFieldError -> 0x001d }
            L_0x001d:
                int[] r0 = $SwitchMap$io$hansel$core$criteria$datatype$DataType     // Catch:{ NoSuchFieldError -> 0x0025 }
                io.hansel.core.criteria.datatype.DataType r2 = io.hansel.core.criteria.datatype.DataType.language     // Catch:{ NoSuchFieldError -> 0x0025 }
                r2 = 7
                r3 = 4
                r0[r2] = r3     // Catch:{ NoSuchFieldError -> 0x0025 }
            L_0x0025:
                int[] r0 = $SwitchMap$io$hansel$core$criteria$datatype$DataType     // Catch:{ NoSuchFieldError -> 0x002c }
                io.hansel.core.criteria.datatype.DataType r2 = io.hansel.core.criteria.datatype.DataType.device_model     // Catch:{ NoSuchFieldError -> 0x002c }
                r2 = 5
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x002c }
            L_0x002c:
                return
            */
            throw new UnsupportedOperationException("Method not decompiled: io.hansel.core.criteria.datatype.DataType.AnonymousClass1.<clinit>():void");
        }
    }

    /* access modifiers changed from: public */
    DataType(String str) {
        this.mName = str;
    }

    public static DataType getDataType(String str) {
        if (str != null) {
            DataType dataType = string;
            if (dataType.mName.equalsIgnoreCase(str)) {
                return dataType;
            }
            DataType dataType2 = number;
            if (dataType2.mName.equalsIgnoreCase(str)) {
                return dataType2;
            }
            DataType dataType3 = bool;
            if (dataType3.mName.equalsIgnoreCase(str)) {
                return dataType3;
            }
            DataType dataType4 = device_model;
            if (dataType4.mName.equalsIgnoreCase(str)) {
                return dataType4;
            }
        }
        return null;
    }

    public ArrayList<Object> getArrayValueObject(String str) {
        Object obj;
        ArrayList<Object> arrayList = new ArrayList<>();
        Object[] split = str.split(",");
        int length = split.length;
        for (int i = 0; i < length; i++) {
            int i2 = AnonymousClass1.$SwitchMap$io$hansel$core$criteria$datatype$DataType[ordinal()];
            if (i2 == 1) {
                obj = split[i];
            } else if (i2 != 2) {
            } else {
                obj = Double.valueOf(Double.parseDouble(split[i]));
            }
            arrayList.add(obj);
        }
        return arrayList;
    }

    public b getCriteriaDataType() {
        int ordinal = ordinal();
        return ordinal != 0 ? ordinal != 1 ? ordinal != 2 ? ordinal != 3 ? ordinal != 7 ? new b() : new LanguageDataType() : new DeviceModelDataType() : new BooleanDataType() : new NumberDataType() : new StringDataType();
    }

    public Object getValueObject(CoreJSONObject coreJSONObject) {
        if (AnonymousClass1.$SwitchMap$io$hansel$core$criteria$datatype$DataType[ordinal()] != 5) {
            return null;
        }
        return coreJSONObject;
    }

    /* JADX WARNING: type inference failed for: r3v2, types: [java.lang.Double] */
    /* JADX WARNING: Multi-variable type inference failed */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public java.lang.Object getValueObject(java.lang.String r3) {
        /*
            r2 = this;
            int[] r0 = io.hansel.core.criteria.datatype.DataType.AnonymousClass1.$SwitchMap$io$hansel$core$criteria$datatype$DataType
            int r1 = r2.ordinal()
            r0 = r0[r1]
            r1 = 1
            if (r0 == r1) goto L_0x0024
            r1 = 2
            if (r0 == r1) goto L_0x001c
            r1 = 3
            if (r0 == r1) goto L_0x0013
            r3 = 0
            return r3
        L_0x0013:
            boolean r3 = java.lang.Boolean.parseBoolean(r3)
            java.lang.Boolean r3 = java.lang.Boolean.valueOf(r3)
            return r3
        L_0x001c:
            double r0 = java.lang.Double.parseDouble(r3)
            java.lang.Double r3 = java.lang.Double.valueOf(r0)
        L_0x0024:
            return r3
        */
        throw new UnsupportedOperationException("Method not decompiled: io.hansel.core.criteria.datatype.DataType.getValueObject(java.lang.String):java.lang.Object");
    }

    public ArrayList<Object> getValueObject(CoreJSONArray coreJSONArray) {
        ArrayList<Object> arrayList = new ArrayList<>();
        if (coreJSONArray != null) {
            int length = coreJSONArray.length();
            for (int i = 0; i < length; i++) {
                CoreJSONObject optJSONObject = coreJSONArray.optJSONObject(i);
                arrayList.add(optJSONObject != null ? getValueObject(optJSONObject) : getValueObject(coreJSONArray.optString(i)));
            }
        }
        return arrayList;
    }
}
