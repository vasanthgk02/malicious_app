package org.apache.fontbox.type1;

import com.android.tools.r8.GeneratedOutlineSupport;
import com.razorpay.AnalyticsConstants;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import org.apache.fontbox.afm.AFMParser;
import org.apache.fontbox.encoding.CustomEncoding;
import org.apache.fontbox.encoding.StandardEncoding;
import org.apache.fontbox.type1.Token.Kind;
import org.apache.pdfbox.pdfparser.BaseParser;
import org.apache.pdfbox.pdmodel.documentinterchange.taggedpdf.StandardStructureTypes;

public final class Type1Parser {
    public static final int CHARSTRING_KEY = 4330;
    public static final int EEXEC_KEY = 55665;
    public Type1Font font;
    public Type1Lexer lexer;

    private List<Number> arrayToNumbers(List<Token> list) throws IOException {
        ArrayList arrayList = new ArrayList();
        int size = list.size() - 1;
        for (int i = 1; i < size; i++) {
            Token token = list.get(i);
            if (token.getKind() == Token.REAL) {
                arrayList.add(Float.valueOf(token.floatValue()));
            } else if (token.getKind() == Token.INTEGER) {
                arrayList.add(Integer.valueOf(token.intValue()));
            } else {
                StringBuilder outline73 = GeneratedOutlineSupport.outline73("Expected INTEGER or REAL but got ");
                outline73.append(token.getKind());
                throw new IOException(outline73.toString());
            }
        }
        return arrayList;
    }

    private byte[] decrypt(byte[] bArr, int i, int i2) {
        if (i2 == -1) {
            return bArr;
        }
        if (bArr.length == 0 || i2 > bArr.length) {
            return new byte[0];
        }
        byte[] bArr2 = new byte[(bArr.length - i2)];
        for (int i3 = 0; i3 < bArr.length; i3++) {
            byte b2 = bArr[i3] & 255;
            byte b3 = (i >> 8) ^ b2;
            if (i3 >= i2) {
                bArr2[i3 - i2] = (byte) b3;
            }
            i = 65535 & (((b2 + i) * 52845) + 22719);
        }
        return bArr2;
    }

    private void parseASCII(byte[] bArr) throws IOException {
        if (bArr.length != 0) {
            if (bArr.length >= 2) {
                if (bArr[0] == 37 || bArr[1] == 33) {
                    Type1Lexer type1Lexer = new Type1Lexer(bArr);
                    this.lexer = type1Lexer;
                    if (type1Lexer.peekToken().getText().equals("FontDirectory")) {
                        read(Token.NAME, "FontDirectory");
                        read(Token.LITERAL);
                        read(Token.NAME, "known");
                        read(Token.START_PROC);
                        readProc();
                        read(Token.START_PROC);
                        readProc();
                        read(Token.NAME, "ifelse");
                    }
                    int intValue = read(Token.INTEGER).intValue();
                    read(Token.NAME, "dict");
                    readMaybe(Token.NAME, "dup");
                    read(Token.NAME, "begin");
                    for (int i = 0; i < intValue && (this.lexer.peekToken().getKind() != Token.NAME || !this.lexer.peekToken().getText().equals("currentdict")); i++) {
                        String text = read(Token.LITERAL).getText();
                        if (text.equals("FontInfo")) {
                            readFontInfo(readSimpleDict());
                        } else if (text.equals("Metrics")) {
                            readSimpleDict();
                        } else if (text.equals("Encoding")) {
                            readEncoding();
                        } else {
                            readSimpleValue(text);
                        }
                    }
                    read(Token.NAME, "currentdict");
                    read(Token.NAME, AnalyticsConstants.END);
                    read(Token.NAME, "currentfile");
                    read(Token.NAME, "eexec");
                    return;
                }
            }
            throw new IOException("Invalid start of ASCII segment");
        }
        throw new IllegalArgumentException("byte[] is empty");
    }

    private void parseBinary(byte[] bArr) throws IOException {
        int i = 4;
        this.lexer = new Type1Lexer(decrypt(bArr, EEXEC_KEY, 4));
        while (!this.lexer.peekToken().getText().equals(StandardStructureTypes.PRIVATE)) {
            this.lexer.nextToken();
        }
        read(Token.LITERAL, StandardStructureTypes.PRIVATE);
        int intValue = read(Token.INTEGER).intValue();
        read(Token.NAME, "dict");
        readMaybe(Token.NAME, "dup");
        read(Token.NAME, "begin");
        for (int i2 = 0; i2 < intValue; i2++) {
            Kind kind = this.lexer.peekToken().getKind();
            Kind kind2 = Token.LITERAL;
            if (kind != kind2) {
                break;
            }
            String text = read(kind2).getText();
            if (text.equals("Subrs")) {
                readSubrs(i);
            } else if (text.equals("OtherSubrs")) {
                readOtherSubrs();
            } else if (text.equals("lenIV")) {
                i = readDictValue().get(0).intValue();
            } else if (text.equals("ND")) {
                read(Token.START_PROC);
                read(Token.NAME, "noaccess");
                read(Token.NAME, BaseParser.DEF);
                read(Token.END_PROC);
                read(Token.NAME, "executeonly");
                read(Token.NAME, BaseParser.DEF);
            } else if (text.equals("NP")) {
                read(Token.START_PROC);
                read(Token.NAME, "noaccess");
                read(Token.NAME);
                read(Token.END_PROC);
                read(Token.NAME, "executeonly");
                read(Token.NAME, BaseParser.DEF);
            } else {
                readPrivate(text, readDictValue());
            }
        }
        while (true) {
            if (this.lexer.peekToken().getKind() != Token.LITERAL || !this.lexer.peekToken().getText().equals("CharStrings")) {
                this.lexer.nextToken();
            } else {
                read(Token.LITERAL, "CharStrings");
                readCharStrings(i);
                return;
            }
        }
    }

    private Token read(Kind kind) throws IOException {
        Token nextToken = this.lexer.nextToken();
        if (nextToken.getKind() == kind) {
            return nextToken;
        }
        throw new IOException("Found " + nextToken + " but expected " + kind);
    }

    private void readCharStrings(int i) throws IOException {
        int intValue = read(Token.INTEGER).intValue();
        read(Token.NAME, "dict");
        read(Token.NAME, "dup");
        read(Token.NAME, "begin");
        for (int i2 = 0; i2 < intValue && (this.lexer.peekToken().getKind() != Token.NAME || !this.lexer.peekToken().getText().equals(AnalyticsConstants.END)); i2++) {
            String text = read(Token.LITERAL).getText();
            read(Token.INTEGER);
            this.font.charstrings.put(text, decrypt(read(Token.CHARSTRING).getData(), CHARSTRING_KEY, i));
            readDef();
        }
        read(Token.NAME, AnalyticsConstants.END);
    }

    private void readDef() throws IOException {
        readMaybe(Token.NAME, "readonly");
        readMaybe(Token.NAME, "noaccess");
        Token read = read(Token.NAME);
        if (!read.getText().equals("ND") && !read.getText().equals("|-")) {
            if (read.getText().equals("noaccess")) {
                read = read(Token.NAME);
            }
            if (!read.getText().equals(BaseParser.DEF)) {
                throw new IOException("Found " + read + " but expected ND");
            }
        }
    }

    private List<Token> readDictValue() throws IOException {
        List<Token> readValue = readValue();
        readDef();
        return readValue;
    }

    private void readEncoding() throws IOException {
        if (this.lexer.peekToken().getKind() == Token.NAME) {
            String text = this.lexer.nextToken().getText();
            if (text.equals("StandardEncoding")) {
                this.font.encoding = StandardEncoding.INSTANCE;
                readMaybe(Token.NAME, "readonly");
                read(Token.NAME, BaseParser.DEF);
                return;
            }
            throw new IOException(GeneratedOutlineSupport.outline50("Unknown encoding: ", text));
        }
        read(Token.INTEGER).intValue();
        readMaybe(Token.NAME, "array");
        while (true) {
            if (this.lexer.peekToken().getKind() != Token.NAME || (!this.lexer.peekToken().getText().equals("dup") && !this.lexer.peekToken().getText().equals("readonly") && !this.lexer.peekToken().getText().equals(BaseParser.DEF))) {
                this.lexer.nextToken();
            }
        }
        HashMap hashMap = new HashMap();
        while (this.lexer.peekToken().getKind() == Token.NAME && this.lexer.peekToken().getText().equals("dup")) {
            read(Token.NAME, "dup");
            int intValue = read(Token.INTEGER).intValue();
            String text2 = read(Token.LITERAL).getText();
            read(Token.NAME, "put");
            hashMap.put(Integer.valueOf(intValue), text2);
        }
        this.font.encoding = new CustomEncoding(hashMap);
        readMaybe(Token.NAME, "readonly");
        read(Token.NAME, BaseParser.DEF);
    }

    private void readFontInfo(Map<String, List<Token>> map) {
        for (Entry next : map.entrySet()) {
            String str = (String) next.getKey();
            List list = (List) next.getValue();
            if (str.equals("version")) {
                this.font.version = ((Token) list.get(0)).getText();
            } else if (str.equals(AFMParser.NOTICE)) {
                this.font.notice = ((Token) list.get(0)).getText();
            } else if (str.equals(AFMParser.FULL_NAME)) {
                this.font.fullName = ((Token) list.get(0)).getText();
            } else if (str.equals(AFMParser.FAMILY_NAME)) {
                this.font.familyName = ((Token) list.get(0)).getText();
            } else if (str.equals(AFMParser.WEIGHT)) {
                this.font.weight = ((Token) list.get(0)).getText();
            } else if (str.equals(AFMParser.ITALIC_ANGLE)) {
                this.font.italicAngle = ((Token) list.get(0)).floatValue();
            } else if (str.equals("isFixedPitch")) {
                this.font.isFixedPitch = ((Token) list.get(0)).booleanValue();
            } else if (str.equals(AFMParser.UNDERLINE_POSITION)) {
                this.font.underlinePosition = ((Token) list.get(0)).floatValue();
            } else if (str.equals(AFMParser.UNDERLINE_THICKNESS)) {
                this.font.underlineThickness = ((Token) list.get(0)).floatValue();
            }
        }
    }

    private Token readMaybe(Kind kind, String str) throws IOException {
        Token peekToken = this.lexer.peekToken();
        if (peekToken.getKind() != kind || !peekToken.getText().equals(str)) {
            return null;
        }
        return this.lexer.nextToken();
    }

    private void readOtherSubrs() throws IOException {
        if (this.lexer.peekToken().getKind() == Token.START_ARRAY) {
            readValue();
            readDef();
            return;
        }
        int intValue = read(Token.INTEGER).intValue();
        read(Token.NAME, "array");
        for (int i = 0; i < intValue; i++) {
            read(Token.NAME, "dup");
            read(Token.INTEGER);
            readValue();
            readPut();
        }
        readDef();
    }

    private void readPrivate(String str, List<Token> list) throws IOException {
        if (str.equals("BlueValues")) {
            this.font.blueValues = arrayToNumbers(list);
        } else if (str.equals("OtherBlues")) {
            this.font.otherBlues = arrayToNumbers(list);
        } else if (str.equals("FamilyBlues")) {
            this.font.familyBlues = arrayToNumbers(list);
        } else if (str.equals("FamilyOtherBlues")) {
            this.font.familyOtherBlues = arrayToNumbers(list);
        } else if (str.equals("BlueScale")) {
            this.font.blueScale = list.get(0).floatValue();
        } else if (str.equals("BlueShift")) {
            this.font.blueShift = list.get(0).intValue();
        } else if (str.equals("BlueFuzz")) {
            this.font.blueFuzz = list.get(0).intValue();
        } else if (str.equals(AFMParser.STD_HW)) {
            this.font.stdHW = arrayToNumbers(list);
        } else if (str.equals(AFMParser.STD_VW)) {
            this.font.stdVW = arrayToNumbers(list);
        } else if (str.equals("StemSnapH")) {
            this.font.stemSnapH = arrayToNumbers(list);
        } else if (str.equals("StemSnapV")) {
            this.font.stemSnapV = arrayToNumbers(list);
        } else if (str.equals("ForceBold")) {
            this.font.forceBold = list.get(0).booleanValue();
        } else if (str.equals("LanguageGroup")) {
            this.font.languageGroup = list.get(0).intValue();
        }
    }

    private List<Token> readProc() throws IOException {
        ArrayList arrayList = new ArrayList();
        int i = 1;
        while (true) {
            if (this.lexer.peekToken().getKind() == Token.START_PROC) {
                i++;
            }
            Token nextToken = this.lexer.nextToken();
            arrayList.add(nextToken);
            if (nextToken.getKind() == Token.END_PROC) {
                i--;
                if (i == 0) {
                    break;
                }
            }
        }
        Token readMaybe = readMaybe(Token.NAME, "executeonly");
        if (readMaybe != null) {
            arrayList.add(readMaybe);
        }
        return arrayList;
    }

    private void readPut() throws IOException {
        readMaybe(Token.NAME, "readonly");
        Token read = read(Token.NAME);
        if (!read.getText().equals("NP") && !read.getText().equals("|")) {
            if (read.getText().equals("noaccess")) {
                read = read(Token.NAME);
            }
            if (!read.getText().equals("put")) {
                throw new IOException("Found " + read + " but expected NP");
            }
        }
    }

    private Map<String, List<Token>> readSimpleDict() throws IOException {
        HashMap hashMap = new HashMap();
        int intValue = read(Token.INTEGER).intValue();
        read(Token.NAME, "dict");
        readMaybe(Token.NAME, "dup");
        read(Token.NAME, "begin");
        for (int i = 0; i < intValue; i++) {
            if (this.lexer.peekToken().getKind() == Token.NAME && !this.lexer.peekToken().getText().equals(AnalyticsConstants.END)) {
                read(Token.NAME);
            }
            if (this.lexer.peekToken().getKind() == Token.NAME && this.lexer.peekToken().getText().equals(AnalyticsConstants.END)) {
                break;
            }
            hashMap.put(read(Token.LITERAL).getText(), readDictValue());
        }
        read(Token.NAME, AnalyticsConstants.END);
        readMaybe(Token.NAME, "readonly");
        read(Token.NAME, BaseParser.DEF);
        return hashMap;
    }

    private void readSimpleValue(String str) throws IOException {
        List<Token> readDictValue = readDictValue();
        if (str.equals(AFMParser.FONT_NAME)) {
            this.font.fontName = readDictValue.get(0).getText();
        } else if (str.equals("PaintType")) {
            this.font.paintType = readDictValue.get(0).intValue();
        } else if (str.equals("FontType")) {
            this.font.fontType = readDictValue.get(0).intValue();
        } else if (str.equals("FontMatrix")) {
            this.font.fontMatrix = arrayToNumbers(readDictValue);
        } else if (str.equals(AFMParser.FONT_BBOX)) {
            this.font.fontBBox = arrayToNumbers(readDictValue);
        } else if (str.equals("UniqueID")) {
            this.font.uniqueID = readDictValue.get(0).intValue();
        } else if (str.equals("StrokeWidth")) {
            this.font.strokeWidth = readDictValue.get(0).floatValue();
        } else if (str.equals("FID")) {
            this.font.fontID = readDictValue.get(0).getText();
        }
    }

    private void readSubrs(int i) throws IOException {
        int intValue = read(Token.INTEGER).intValue();
        for (int i2 = 0; i2 < intValue; i2++) {
            this.font.subrs.add(null);
        }
        read(Token.NAME, "array");
        for (int i3 = 0; i3 < intValue && this.lexer.peekToken().getKind() == Token.NAME && this.lexer.peekToken().getText().equals("dup"); i3++) {
            read(Token.NAME, "dup");
            Token read = read(Token.INTEGER);
            read(Token.INTEGER);
            this.font.subrs.set(read.intValue(), decrypt(read(Token.CHARSTRING).getData(), CHARSTRING_KEY, i));
            readPut();
        }
        readDef();
    }

    private List<Token> readValue() throws IOException {
        ArrayList arrayList = new ArrayList();
        Token nextToken = this.lexer.nextToken();
        arrayList.add(nextToken);
        if (nextToken.getKind() == Token.START_ARRAY) {
            int i = 1;
            while (true) {
                if (this.lexer.peekToken().getKind() == Token.START_ARRAY) {
                    i++;
                }
                Token nextToken2 = this.lexer.nextToken();
                arrayList.add(nextToken2);
                if (nextToken2.getKind() == Token.END_ARRAY) {
                    i--;
                    if (i == 0) {
                        break;
                    }
                }
            }
        } else if (nextToken.getKind() == Token.START_PROC) {
            arrayList.addAll(readProc());
        }
        if (this.lexer.peekToken().getText().equals("systemdict")) {
            read(Token.NAME, "systemdict");
            read(Token.LITERAL, "internaldict");
            read(Token.NAME, "known");
            read(Token.START_PROC);
            readProc();
            read(Token.START_PROC);
            readProc();
            read(Token.NAME, "ifelse");
            read(Token.START_PROC);
            read(Token.NAME, "pop");
            arrayList.clear();
            arrayList.addAll(readValue());
            read(Token.END_PROC);
            read(Token.NAME, "if");
        }
        return arrayList;
    }

    public Type1Font parse(byte[] bArr, byte[] bArr2) throws IOException {
        this.font = new Type1Font();
        parseASCII(bArr);
        if (bArr2.length > 0) {
            parseBinary(bArr2);
        }
        return this.font;
    }

    private void read(Kind kind, String str) throws IOException {
        Token read = read(kind);
        if (!read.getText().equals(str)) {
            throw new IOException("Found " + read + " but expected " + str);
        }
    }
}
