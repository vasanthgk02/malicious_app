package com.freshchat.consumer.sdk.c;

import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteStatement;
import com.android.tools.r8.GeneratedOutlineSupport;
import com.facebook.react.bridge.ColorPropConverter;
import com.freshchat.consumer.sdk.beans.Tag;
import com.freshchat.consumer.sdk.beans.Tag.TaggedType;
import com.freshchat.consumer.sdk.c.a.l;
import com.freshchat.consumer.sdk.j.as;
import java.util.List;
import java.util.Map;

public class j extends b {
    public Context context;

    public j(Context context2) {
        super(context2);
        this.context = context2.getApplicationContext();
    }

    public static String a(int i, TaggedType... taggedTypeArr) {
        if (i == 0) {
            return null;
        }
        StringBuilder outline78 = GeneratedOutlineSupport.outline78("name", " IN (");
        outline78.append(as.a(ColorPropConverter.PREFIX_ATTR, ",", i));
        outline78.append(")");
        if (taggedTypeArr != null && taggedTypeArr.length > 0) {
            GeneratedOutlineSupport.outline102(outline78, " AND ", "tagged_type", " IN (");
            int length = taggedTypeArr.length;
            int i2 = 0;
            String str = "";
            while (i2 < length) {
                TaggedType taggedType = taggedTypeArr[i2];
                outline78.append(str);
                outline78.append("\"");
                outline78.append(taggedType.asInt());
                outline78.append("\"");
                i2++;
                str = ",";
            }
            outline78.append(")");
        }
        return outline78.toString();
    }

    public Map<String, Integer> a(Cursor cursor) {
        return null;
    }

    public void a(TaggedType taggedType) {
        cs().delete("tags", "tagged_type = ? ", new String[]{Integer.toString(taggedType.asInt())});
    }

    public void f(List<Tag> list) {
        SQLiteStatement compileStatement = cs().compileStatement(new l().cS());
        if (compileStatement != null) {
            for (int i = 0; i < list.size(); i++) {
                Tag tag = list.get(i);
                compileStatement.clearBindings();
                compileStatement.bindString(1, tag.getTagName());
                compileStatement.bindString(2, tag.getTaggedItemId());
                compileStatement.bindString(3, Integer.toString(tag.getTaggedItemType().asInt()));
                compileStatement.execute();
            }
            b.a(compileStatement);
        }
    }
}
