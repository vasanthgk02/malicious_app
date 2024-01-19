package net.minidev.json.parser;

import java.io.IOException;
import net.minidev.json.JSONAwareEx;
import net.minidev.json.JSONValue;
import net.minidev.json.writer.JsonReader;
import net.minidev.json.writer.JsonReaderI;

public class JSONParser {
    public int mode;
    public JSONParserString pString;

    static {
        String property = System.getProperty("JSON_SMART_SIMPLE");
    }

    public JSONParser(int i) {
        this.mode = i;
    }

    public Object parse(String str) throws ParseException {
        if (this.pString == null) {
            this.pString = new JSONParserString(this.mode);
        }
        JSONParserString jSONParserString = this.pString;
        if (jSONParserString != null) {
            JsonReaderI<JSONAwareEx> jsonReaderI = JSONValue.defaultReader.DEFAULT;
            JsonReader jsonReader = jsonReaderI.base;
            jSONParserString.f6147in = str;
            jSONParserString.len = str.length();
            jSONParserString.pos = -1;
            try {
                jSONParserString.read();
                Object readFirst = jSONParserString.readFirst(jsonReaderI);
                if (jSONParserString.checkTaillingData) {
                    if (!jSONParserString.checkTaillingSpace) {
                        jSONParserString.skipSpace();
                    }
                    if (jSONParserString.f6145c != 26) {
                        throw new ParseException(jSONParserString.pos - 1, 1, Character.valueOf(jSONParserString.f6145c));
                    }
                }
                jSONParserString.xs = null;
                jSONParserString.xo = null;
                return readFirst;
            } catch (IOException e2) {
                throw new ParseException(jSONParserString.pos, e2);
            }
        } else {
            throw null;
        }
    }
}
