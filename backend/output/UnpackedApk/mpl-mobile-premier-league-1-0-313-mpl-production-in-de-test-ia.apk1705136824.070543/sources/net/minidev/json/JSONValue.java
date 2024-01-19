package net.minidev.json;

import java.io.IOException;
import java.util.Iterator;
import net.minidev.json.reader.JsonWriter;
import net.minidev.json.reader.JsonWriter.WriterByInterface;
import net.minidev.json.reader.JsonWriterI;
import net.minidev.json.writer.JsonReader;

public class JSONValue {
    public static JSONStyle COMPRESSION = JSONStyle.NO_COMPRESS;
    public static final JsonReader defaultReader = new JsonReader();
    public static final JsonWriter defaultWriter = new JsonWriter();

    public static void escape(String str, Appendable appendable, JSONStyle jSONStyle) {
        if (str != null) {
            jSONStyle.esc.escape(str, appendable);
        }
    }

    public static void writeJSONString(Object obj, Appendable appendable, JSONStyle jSONStyle) throws IOException {
        if (obj == null) {
            appendable.append("null");
            return;
        }
        Class<?> cls = obj.getClass();
        JsonWriterI jsonWriterI = defaultWriter.data.get(cls);
        if (jsonWriterI == null) {
            if (cls.isArray()) {
                jsonWriterI = JsonWriter.arrayWriter;
            } else {
                JsonWriter jsonWriter = defaultWriter;
                Class<?> cls2 = obj.getClass();
                Iterator it = jsonWriter.writerInterfaces.iterator();
                while (true) {
                    if (it.hasNext()) {
                        WriterByInterface writerByInterface = (WriterByInterface) it.next();
                        if (writerByInterface._interface.isAssignableFrom(cls2)) {
                            jsonWriterI = writerByInterface._writer;
                            break;
                        }
                    } else {
                        jsonWriterI = null;
                        break;
                    }
                }
                if (jsonWriterI == null) {
                    jsonWriterI = JsonWriter.beansWriterASM;
                }
            }
            defaultWriter.registerWriter(jsonWriterI, cls);
        }
        jsonWriterI.writeJSONString(obj, appendable, jSONStyle);
    }

    public static String escape(String str) {
        JSONStyle jSONStyle = COMPRESSION;
        if (str == null) {
            return null;
        }
        StringBuilder sb = new StringBuilder();
        jSONStyle.esc.escape(str, sb);
        return sb.toString();
    }
}
