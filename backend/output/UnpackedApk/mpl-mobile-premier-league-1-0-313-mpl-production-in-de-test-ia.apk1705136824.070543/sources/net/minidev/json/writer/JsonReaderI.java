package net.minidev.json.writer;

import java.io.IOException;
import net.minidev.json.parser.ParseException;

public abstract class JsonReaderI<T> {
    public final JsonReader base;

    public JsonReaderI(JsonReader jsonReader) {
        this.base = jsonReader;
    }

    public abstract void addValue(Object obj, Object obj2) throws ParseException, IOException;

    public T convert(Object obj) {
        return obj;
    }

    public abstract Object createArray();

    public Object createObject() {
        throw new RuntimeException("Invalid or non Implemented status" + " createObject() in " + getClass());
    }

    public void setValue(Object obj, String str, Object obj2) throws ParseException, IOException {
        throw new RuntimeException("Invalid or non Implemented status" + " setValue in " + getClass() + " key=" + str);
    }

    public JsonReaderI<?> startArray(String str) throws ParseException, IOException {
        throw new RuntimeException("Invalid or non Implemented status" + " startArray in " + getClass() + " key=" + str);
    }

    public JsonReaderI<?> startObject(String str) throws ParseException, IOException {
        throw new RuntimeException("Invalid or non Implemented status" + " startObject(String key) in " + getClass() + " key=" + str);
    }
}
