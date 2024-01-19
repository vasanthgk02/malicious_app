package com.freshchat.consumer.sdk.service.a;

import com.android.tools.r8.GeneratedOutlineSupport;
import com.badlogic.gdx.graphics.PixmapIO.CIM;
import java.util.HashMap;
import java.util.Map;
import org.apache.fontbox.cmap.CMapParser;

public class a {
    public static final Map<Integer, Integer> fs;
    public String fr;
    public Map<String, String> meta;
    public int priority;
    public int type;

    static {
        HashMap hashMap = new HashMap();
        fs = hashMap;
        hashMap.put(Integer.valueOf(1), Integer.valueOf(1024));
        fs.put(Integer.valueOf(2), Integer.valueOf(2048));
        fs.put(Integer.valueOf(3), Integer.valueOf(8192));
        fs.put(Integer.valueOf(4), Integer.valueOf(1536));
        fs.put(Integer.valueOf(6), Integer.valueOf(16384));
        fs.put(Integer.valueOf(7), Integer.valueOf(4096));
        fs.put(Integer.valueOf(10), Integer.valueOf(CIM.BUFFER_SIZE));
        fs.put(Integer.valueOf(9), Integer.valueOf(2560));
        fs.put(Integer.valueOf(11), Integer.valueOf(1000));
    }

    public a(int i) {
        this(i, String.valueOf("type_" + i));
    }

    public a(int i, String str) {
        this.priority = Integer.MAX_VALUE;
        this.type = i;
        this.fr = str;
        this.priority = fs.get(Integer.valueOf(i)).intValue();
    }

    public a b(Map<String, String> map) {
        this.meta = map;
        return this;
    }

    public String dr() {
        return this.fr;
    }

    public Map<String, String> getMeta() {
        return this.meta;
    }

    public int getPriority() {
        return this.priority;
    }

    public int getType() {
        return this.type;
    }

    public String toString() {
        StringBuilder outline73 = GeneratedOutlineSupport.outline73("BacklogHolder [backlogId=");
        outline73.append(this.fr);
        outline73.append(", priority=");
        outline73.append(this.priority);
        outline73.append(", type=");
        outline73.append(this.type);
        outline73.append(", meta=");
        outline73.append(this.meta);
        outline73.append(CMapParser.MARK_END_OF_ARRAY);
        return outline73.toString();
    }
}
