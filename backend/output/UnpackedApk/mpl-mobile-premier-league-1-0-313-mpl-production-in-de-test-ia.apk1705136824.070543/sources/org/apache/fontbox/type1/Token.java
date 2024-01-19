package org.apache.fontbox.type1;

import com.android.tools.r8.GeneratedOutlineSupport;
import org.apache.fontbox.cmap.CMapParser;
import org.apache.pdfbox.pdfparser.BaseParser;

public class Token {
    public static final Kind CHARSTRING = Kind.CHARSTRING;
    public static final Kind END_ARRAY = Kind.END_ARRAY;
    public static final Kind END_PROC = Kind.END_PROC;
    public static final Kind INTEGER = Kind.INTEGER;
    public static final Kind LITERAL = Kind.LITERAL;
    public static final Kind NAME = Kind.NAME;
    public static final Kind REAL = Kind.REAL;
    public static final Kind START_ARRAY = Kind.START_ARRAY;
    public static final Kind START_PROC = Kind.START_PROC;
    public static final Kind STRING = Kind.STRING;
    public byte[] data;
    public Kind kind;
    public String text;

    public enum Kind {
        NONE,
        STRING,
        NAME,
        LITERAL,
        REAL,
        INTEGER,
        START_ARRAY,
        END_ARRAY,
        START_PROC,
        END_PROC,
        CHARSTRING
    }

    public Token(String str, Kind kind2) {
        this.text = str;
        this.kind = kind2;
    }

    public boolean booleanValue() {
        return this.text.equals(BaseParser.TRUE);
    }

    public float floatValue() {
        return Float.parseFloat(this.text);
    }

    public byte[] getData() {
        return this.data;
    }

    public Kind getKind() {
        return this.kind;
    }

    public String getText() {
        return this.text;
    }

    public int intValue() {
        return (int) Float.parseFloat(this.text);
    }

    public String toString() {
        if (this.kind == CHARSTRING) {
            return GeneratedOutlineSupport.outline57(GeneratedOutlineSupport.outline73("Token[kind=CHARSTRING, data="), this.data.length, " bytes]");
        }
        StringBuilder outline73 = GeneratedOutlineSupport.outline73("Token[kind=");
        outline73.append(this.kind);
        outline73.append(", text=");
        return GeneratedOutlineSupport.outline62(outline73, this.text, CMapParser.MARK_END_OF_ARRAY);
    }

    public Token(char c2, Kind kind2) {
        this.text = Character.toString(c2);
        this.kind = kind2;
    }

    public Token(byte[] bArr, Kind kind2) {
        this.data = bArr;
        this.kind = kind2;
    }
}
