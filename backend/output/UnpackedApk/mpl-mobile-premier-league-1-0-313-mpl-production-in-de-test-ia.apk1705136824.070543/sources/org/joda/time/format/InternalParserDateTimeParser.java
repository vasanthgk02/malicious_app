package org.joda.time.format;

public class InternalParserDateTimeParser implements DateTimeParser, InternalParser {
    public final InternalParser underlying;

    public InternalParserDateTimeParser(InternalParser internalParser) {
        this.underlying = internalParser;
    }

    public static DateTimeParser of(InternalParser internalParser) {
        if (internalParser instanceof DateTimeParserInternalParser) {
            return ((DateTimeParserInternalParser) internalParser).underlying;
        }
        if (internalParser instanceof DateTimeParser) {
            return (DateTimeParser) internalParser;
        }
        if (internalParser == null) {
            return null;
        }
        return new InternalParserDateTimeParser(internalParser);
    }

    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (obj instanceof InternalParserDateTimeParser) {
            return this.underlying.equals(((InternalParserDateTimeParser) obj).underlying);
        }
        return false;
    }

    public int estimateParsedLength() {
        return this.underlying.estimateParsedLength();
    }

    public int parseInto(DateTimeParserBucket dateTimeParserBucket, CharSequence charSequence, int i) {
        return this.underlying.parseInto(dateTimeParserBucket, charSequence, i);
    }

    public int parseInto(DateTimeParserBucket dateTimeParserBucket, String str, int i) {
        return this.underlying.parseInto(dateTimeParserBucket, str, i);
    }
}
