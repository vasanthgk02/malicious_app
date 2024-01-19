package com.clevertap.android.sdk.db;

import com.android.tools.r8.GeneratedOutlineSupport;
import com.clevertap.android.sdk.db.DBAdapter.Table;
import org.json.JSONArray;

public final class QueueCursor {
    public JSONArray data;
    public String lastId;
    public Table tableName;

    public Boolean isEmpty() {
        boolean z;
        if (this.lastId != null) {
            JSONArray jSONArray = this.data;
            if (jSONArray != null && jSONArray.length() > 0) {
                z = false;
                return Boolean.valueOf(z);
            }
        }
        z = true;
        return Boolean.valueOf(z);
    }

    public String toString() {
        if (isEmpty().booleanValue()) {
            StringBuilder outline73 = GeneratedOutlineSupport.outline73("tableName: ");
            outline73.append(this.tableName);
            outline73.append(" | numItems: 0");
            return outline73.toString();
        }
        StringBuilder outline732 = GeneratedOutlineSupport.outline73("tableName: ");
        outline732.append(this.tableName);
        outline732.append(" | lastId: ");
        outline732.append(this.lastId);
        outline732.append(" | numItems: ");
        outline732.append(this.data.length());
        outline732.append(" | items: ");
        outline732.append(this.data.toString());
        return outline732.toString();
    }
}
