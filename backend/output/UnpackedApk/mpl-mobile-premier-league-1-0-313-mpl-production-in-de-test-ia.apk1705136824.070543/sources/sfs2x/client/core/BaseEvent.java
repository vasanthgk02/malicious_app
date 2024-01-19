package sfs2x.client.core;

import com.android.tools.r8.GeneratedOutlineSupport;
import java.util.HashMap;
import java.util.Map;
import org.apache.fontbox.cmap.CMapParser;

public class BaseEvent {
    public Map<String, Object> arguments;
    public Object target;
    public String type;

    public BaseEvent(String str) {
        this.type = str;
        if (getArguments() == null) {
            setArguments(new HashMap());
        }
    }

    public Map<String, Object> getArguments() {
        return this.arguments;
    }

    public Object getTarget() {
        return this.target;
    }

    public String getType() {
        return this.type;
    }

    public void setArguments(Map<String, Object> map) {
        this.arguments = map;
    }

    public void setTarget(Object obj) {
        this.target = obj;
    }

    public String toString() {
        StringBuilder sb = new StringBuilder(String.valueOf(this.type));
        sb.append(" [ ");
        Object obj = this.target;
        return GeneratedOutlineSupport.outline62(sb, obj != null ? obj.toString() : "null", CMapParser.MARK_END_OF_ARRAY);
    }

    public BaseEvent clone() {
        return new BaseEvent(this.type, getArguments());
    }

    public BaseEvent(String str, Map<String, Object> map) {
        this.type = str;
        setArguments(map);
        if (getArguments() == null) {
            setArguments(new HashMap());
        }
    }
}
