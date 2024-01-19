package com.clevertap.android.sdk.displayunits.model;

import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;
import android.text.TextUtils;
import com.android.tools.r8.GeneratedOutlineSupport;
import com.clevertap.android.sdk.Logger;
import com.clevertap.android.sdk.displayunits.CTDisplayUnitType;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import org.apache.fontbox.cmap.CMap;
import org.json.JSONArray;
import org.json.JSONObject;

public class CleverTapDisplayUnit implements Parcelable {
    public static final Creator<CleverTapDisplayUnit> CREATOR = new Creator<CleverTapDisplayUnit>() {
        public Object createFromParcel(Parcel parcel) {
            return new CleverTapDisplayUnit(parcel, null);
        }

        public Object[] newArray(int i) {
            return new CleverTapDisplayUnit[i];
        }
    };
    public String bgColor;
    public ArrayList<CleverTapDisplayUnitContent> contents;
    public HashMap<String, String> customExtras;
    public String error;
    public JSONObject jsonObject;
    public CTDisplayUnitType type;
    public String unitID;

    public CleverTapDisplayUnit(JSONObject jSONObject, String str, CTDisplayUnitType cTDisplayUnitType, String str2, ArrayList<CleverTapDisplayUnitContent> arrayList, JSONObject jSONObject2, String str3) {
        this.jsonObject = jSONObject;
        this.unitID = str;
        this.type = cTDisplayUnitType;
        this.bgColor = str2;
        this.contents = arrayList;
        HashMap<String, String> hashMap = null;
        if (jSONObject2 != null) {
            try {
                Iterator<String> keys = jSONObject2.keys();
                if (keys != null) {
                    HashMap<String, String> hashMap2 = null;
                    while (keys.hasNext()) {
                        String next = keys.next();
                        String string = jSONObject2.getString(next);
                        if (!TextUtils.isEmpty(next)) {
                            hashMap2 = hashMap2 == null ? new HashMap<>() : hashMap2;
                            hashMap2.put(next, string);
                        }
                    }
                    hashMap = hashMap2;
                }
            } catch (Exception e2) {
                StringBuilder outline73 = GeneratedOutlineSupport.outline73("Error in getting Key Value Pairs ");
                outline73.append(e2.getLocalizedMessage());
                Logger.d("DisplayUnit : ", outline73.toString());
            }
        }
        this.customExtras = hashMap;
        this.error = str3;
    }

    public static CleverTapDisplayUnit toDisplayUnit(JSONObject jSONObject) {
        try {
            String string = jSONObject.has("wzrk_id") ? jSONObject.getString("wzrk_id") : "0_0";
            CTDisplayUnitType type2 = jSONObject.has("type") ? CTDisplayUnitType.type(jSONObject.getString("type")) : null;
            String string2 = jSONObject.has("bg") ? jSONObject.getString("bg") : "";
            JSONArray jSONArray = jSONObject.has("content") ? jSONObject.getJSONArray("content") : null;
            ArrayList arrayList = new ArrayList();
            if (jSONArray != null) {
                for (int i = 0; i < jSONArray.length(); i++) {
                    CleverTapDisplayUnitContent content = CleverTapDisplayUnitContent.toContent(jSONArray.getJSONObject(i));
                    if (TextUtils.isEmpty(content.error)) {
                        arrayList.add(content);
                    }
                }
            }
            CleverTapDisplayUnit cleverTapDisplayUnit = new CleverTapDisplayUnit(jSONObject, string, type2, string2, arrayList, jSONObject.has("custom_kv") ? jSONObject.getJSONObject("custom_kv") : null, null);
            return cleverTapDisplayUnit;
        } catch (Exception e2) {
            StringBuilder outline73 = GeneratedOutlineSupport.outline73("Unable to init CleverTapDisplayUnit with JSON - ");
            outline73.append(e2.getLocalizedMessage());
            Logger.d("DisplayUnit : ", outline73.toString());
            CleverTapDisplayUnit cleverTapDisplayUnit2 = new CleverTapDisplayUnit(null, "", null, null, null, null, GeneratedOutlineSupport.outline38(e2, GeneratedOutlineSupport.outline73("Error Creating Display Unit from JSON : ")));
            return cleverTapDisplayUnit2;
        }
    }

    public int describeContents() {
        return 0;
    }

    public String toString() {
        try {
            StringBuilder sb = new StringBuilder();
            sb.append("[");
            sb.append(" Unit id- ");
            sb.append(this.unitID);
            sb.append(", Type- ");
            sb.append(this.type != null ? this.type.toString() : null);
            sb.append(", bgColor- ");
            sb.append(this.bgColor);
            if (this.contents != null && !this.contents.isEmpty()) {
                for (int i = 0; i < this.contents.size(); i++) {
                    CleverTapDisplayUnitContent cleverTapDisplayUnitContent = this.contents.get(i);
                    if (cleverTapDisplayUnitContent != null) {
                        sb.append(", Content Item:");
                        sb.append(i);
                        sb.append(CMap.SPACE);
                        sb.append(cleverTapDisplayUnitContent.toString());
                        sb.append("\n");
                    }
                }
            }
            if (this.customExtras != null) {
                sb.append(", Custom KV:");
                sb.append(this.customExtras);
            }
            sb.append(", JSON -");
            sb.append(this.jsonObject);
            sb.append(", Error-");
            sb.append(this.error);
            sb.append(" ]");
            return sb.toString();
        } catch (Exception e2) {
            Logger.d("DisplayUnit : ", "Exception in toString:" + e2);
            return super.toString();
        }
    }

    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeString(this.unitID);
        parcel.writeValue(this.type);
        parcel.writeString(this.bgColor);
        if (this.contents == null) {
            parcel.writeByte(0);
        } else {
            parcel.writeByte(1);
            parcel.writeList(this.contents);
        }
        parcel.writeMap(this.customExtras);
        if (this.jsonObject == null) {
            parcel.writeByte(0);
        } else {
            parcel.writeByte(1);
            parcel.writeString(this.jsonObject.toString());
        }
        parcel.writeString(this.error);
    }

    public CleverTapDisplayUnit(Parcel parcel, AnonymousClass1 r4) {
        try {
            this.unitID = parcel.readString();
            this.type = (CTDisplayUnitType) parcel.readValue(CTDisplayUnitType.class.getClassLoader());
            this.bgColor = parcel.readString();
            JSONObject jSONObject = null;
            if (parcel.readByte() == 1) {
                ArrayList<CleverTapDisplayUnitContent> arrayList = new ArrayList<>();
                this.contents = arrayList;
                parcel.readList(arrayList, CleverTapDisplayUnitContent.class.getClassLoader());
            } else {
                this.contents = null;
            }
            this.customExtras = parcel.readHashMap(null);
            if (parcel.readByte() != 0) {
                jSONObject = new JSONObject(parcel.readString());
            }
            this.jsonObject = jSONObject;
            this.error = parcel.readString();
        } catch (Exception e2) {
            String outline38 = GeneratedOutlineSupport.outline38(e2, GeneratedOutlineSupport.outline73("Error Creating Display Unit from parcel : "));
            this.error = outline38;
            Logger.d("DisplayUnit : ", outline38);
        }
    }
}
