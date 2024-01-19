package org.apache.commons.lang.text;

import java.text.FieldPosition;
import java.text.Format;
import java.text.ParseException;
import java.text.ParsePosition;

public class CompositeFormat extends Format {
    public static final long serialVersionUID = -4329119827877627683L;
    public final Format formatter;
    public final Format parser;

    public CompositeFormat(Format format, Format format2) {
        this.parser = format;
        this.formatter = format2;
    }

    public StringBuffer format(Object obj, StringBuffer stringBuffer, FieldPosition fieldPosition) {
        return this.formatter.format(obj, stringBuffer, fieldPosition);
    }

    public Format getFormatter() {
        return this.formatter;
    }

    public Format getParser() {
        return this.parser;
    }

    public Object parseObject(String str, ParsePosition parsePosition) {
        return this.parser.parseObject(str, parsePosition);
    }

    public String reformat(String str) throws ParseException {
        return format(parseObject(str));
    }
}
