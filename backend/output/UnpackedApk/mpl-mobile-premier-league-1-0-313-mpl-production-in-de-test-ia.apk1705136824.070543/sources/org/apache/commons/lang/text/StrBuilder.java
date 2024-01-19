package org.apache.commons.lang.text;

import java.io.Reader;
import java.io.Writer;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import org.apache.commons.lang.ArrayUtils;
import org.apache.commons.lang.SystemUtils;
import org.apache.pdfbox.filter.ASCII85InputStream;

public class StrBuilder implements Cloneable {
    public static final int CAPACITY = 32;
    public static final long serialVersionUID = 7628716375283629643L;
    public char[] buffer;
    public String newLine;
    public String nullText;
    public int size;

    public class StrBuilderReader extends Reader {
        public int mark;
        public int pos;

        public StrBuilderReader() {
        }

        public void close() {
        }

        public void mark(int i) {
            this.mark = this.pos;
        }

        public boolean markSupported() {
            return true;
        }

        public int read() {
            if (!ready()) {
                return -1;
            }
            StrBuilder strBuilder = StrBuilder.this;
            int i = this.pos;
            this.pos = i + 1;
            return strBuilder.charAt(i);
        }

        public boolean ready() {
            return this.pos < StrBuilder.this.size();
        }

        public void reset() {
            this.pos = this.mark;
        }

        public long skip(long j) {
            if (((long) this.pos) + j > ((long) StrBuilder.this.size())) {
                j = (long) (StrBuilder.this.size() - this.pos);
            }
            if (j < 0) {
                return 0;
            }
            this.pos = (int) (((long) this.pos) + j);
            return j;
        }

        public int read(char[] cArr, int i, int i2) {
            if (i >= 0 && i2 >= 0 && i <= cArr.length) {
                int i3 = i + i2;
                if (i3 <= cArr.length && i3 >= 0) {
                    if (i2 == 0) {
                        return 0;
                    }
                    if (this.pos >= StrBuilder.this.size()) {
                        return -1;
                    }
                    if (this.pos + i2 > StrBuilder.this.size()) {
                        i2 = StrBuilder.this.size() - this.pos;
                    }
                    StrBuilder strBuilder = StrBuilder.this;
                    int i4 = this.pos;
                    strBuilder.getChars(i4, i4 + i2, cArr, i);
                    this.pos += i2;
                    return i2;
                }
            }
            throw new IndexOutOfBoundsException();
        }
    }

    public class StrBuilderTokenizer extends StrTokenizer {
        public StrBuilderTokenizer() {
        }

        public String getContent() {
            String content = super.getContent();
            return content == null ? StrBuilder.this.toString() : content;
        }

        public List tokenize(char[] cArr, int i, int i2) {
            if (cArr != null) {
                return super.tokenize(cArr, i, i2);
            }
            StrBuilder strBuilder = StrBuilder.this;
            return super.tokenize(strBuilder.buffer, 0, strBuilder.size());
        }
    }

    public class StrBuilderWriter extends Writer {
        public StrBuilderWriter() {
        }

        public void close() {
        }

        public void flush() {
        }

        public void write(int i) {
            StrBuilder.this.append((char) i);
        }

        public void write(char[] cArr) {
            StrBuilder.this.append(cArr);
        }

        public void write(char[] cArr, int i, int i2) {
            StrBuilder.this.append(cArr, i, i2);
        }

        public void write(String str) {
            StrBuilder.this.append(str);
        }

        public void write(String str, int i, int i2) {
            StrBuilder.this.append(str, i, i2);
        }
    }

    public StrBuilder() {
        this(32);
    }

    private void deleteImpl(int i, int i2, int i3) {
        char[] cArr = this.buffer;
        System.arraycopy(cArr, i2, cArr, i, this.size - i2);
        this.size -= i3;
    }

    private void replaceImpl(int i, int i2, int i3, String str, int i4) {
        int i5 = (this.size - i3) + i4;
        if (i4 != i3) {
            ensureCapacity(i5);
            char[] cArr = this.buffer;
            System.arraycopy(cArr, i2, cArr, i + i4, this.size - i2);
            this.size = i5;
        }
        if (i4 > 0) {
            str.getChars(0, i4, this.buffer, i);
        }
    }

    public StrBuilder append(Object obj) {
        if (obj == null) {
            return appendNull();
        }
        return append(obj.toString());
    }

    public StrBuilder appendAll(Object[] objArr) {
        if (objArr != null && objArr.length > 0) {
            for (Object append : objArr) {
                append(append);
            }
        }
        return this;
    }

    public StrBuilder appendFixedWidthPadLeft(Object obj, int i, char c2) {
        if (i > 0) {
            ensureCapacity(this.size + i);
            String nullText2 = obj == null ? getNullText() : obj.toString();
            if (nullText2 == null) {
                nullText2 = "";
            }
            int length = nullText2.length();
            if (length >= i) {
                nullText2.getChars(length - i, length, this.buffer, this.size);
            } else {
                int i2 = i - length;
                for (int i3 = 0; i3 < i2; i3++) {
                    this.buffer[this.size + i3] = c2;
                }
                nullText2.getChars(0, length, this.buffer, this.size + i2);
            }
            this.size += i;
        }
        return this;
    }

    public StrBuilder appendFixedWidthPadRight(Object obj, int i, char c2) {
        if (i > 0) {
            ensureCapacity(this.size + i);
            String nullText2 = obj == null ? getNullText() : obj.toString();
            if (nullText2 == null) {
                nullText2 = "";
            }
            int length = nullText2.length();
            if (length >= i) {
                nullText2.getChars(0, i, this.buffer, this.size);
            } else {
                int i2 = i - length;
                nullText2.getChars(0, length, this.buffer, this.size);
                for (int i3 = 0; i3 < i2; i3++) {
                    this.buffer[this.size + length + i3] = c2;
                }
            }
            this.size += i;
        }
        return this;
    }

    public StrBuilder appendNewLine() {
        String str = this.newLine;
        if (str != null) {
            return append(str);
        }
        append(SystemUtils.LINE_SEPARATOR);
        return this;
    }

    public StrBuilder appendNull() {
        String str = this.nullText;
        if (str == null) {
            return this;
        }
        return append(str);
    }

    public StrBuilder appendPadding(int i, char c2) {
        if (i >= 0) {
            ensureCapacity(this.size + i);
            for (int i2 = 0; i2 < i; i2++) {
                char[] cArr = this.buffer;
                int i3 = this.size;
                this.size = i3 + 1;
                cArr[i3] = c2;
            }
        }
        return this;
    }

    public StrBuilder appendSeparator(String str) {
        if (str != null && size() > 0) {
            append(str);
        }
        return this;
    }

    public StrBuilder appendWithSeparators(Object[] objArr, String str) {
        if (objArr != null && objArr.length > 0) {
            if (str == null) {
                str = "";
            }
            append(objArr[0]);
            for (int i = 1; i < objArr.length; i++) {
                append(str);
                append(objArr[i]);
            }
        }
        return this;
    }

    public StrBuilder appendln(Object obj) {
        return append(obj).appendNewLine();
    }

    public Reader asReader() {
        return new StrBuilderReader();
    }

    public StrTokenizer asTokenizer() {
        return new StrBuilderTokenizer();
    }

    public Writer asWriter() {
        return new StrBuilderWriter();
    }

    public int capacity() {
        return this.buffer.length;
    }

    public char charAt(int i) {
        if (i >= 0 && i < length()) {
            return this.buffer[i];
        }
        throw new StringIndexOutOfBoundsException(i);
    }

    public StrBuilder clear() {
        this.size = 0;
        return this;
    }

    public boolean contains(char c2) {
        char[] cArr = this.buffer;
        for (int i = 0; i < this.size; i++) {
            if (cArr[i] == c2) {
                return true;
            }
        }
        return false;
    }

    public StrBuilder delete(int i, int i2) {
        int validateRange = validateRange(i, i2);
        int i3 = validateRange - i;
        if (i3 > 0) {
            deleteImpl(i, validateRange, i3);
        }
        return this;
    }

    public StrBuilder deleteAll(char c2) {
        int i = 0;
        while (i < this.size) {
            if (this.buffer[i] == c2) {
                int i2 = i;
                do {
                    i2++;
                    if (i2 >= this.size) {
                        break;
                    }
                } while (this.buffer[i2] == c2);
                int i3 = i2 - i;
                deleteImpl(i, i2, i3);
                i = i2 - i3;
            }
            i++;
        }
        return this;
    }

    public StrBuilder deleteCharAt(int i) {
        if (i < 0 || i >= this.size) {
            throw new StringIndexOutOfBoundsException(i);
        }
        deleteImpl(i, i + 1, 1);
        return this;
    }

    public StrBuilder deleteFirst(char c2) {
        int i = 0;
        while (true) {
            if (i >= this.size) {
                break;
            } else if (this.buffer[i] == c2) {
                deleteImpl(i, i + 1, 1);
                break;
            } else {
                i++;
            }
        }
        return this;
    }

    public boolean endsWith(String str) {
        if (str == null) {
            return false;
        }
        int length = str.length();
        if (length == 0) {
            return true;
        }
        int i = this.size;
        if (length > i) {
            return false;
        }
        int i2 = i - length;
        int i3 = 0;
        while (i3 < length) {
            if (this.buffer[i2] != str.charAt(i3)) {
                return false;
            }
            i3++;
            i2++;
        }
        return true;
    }

    public StrBuilder ensureCapacity(int i) {
        char[] cArr = this.buffer;
        if (i > cArr.length) {
            char[] cArr2 = new char[i];
            this.buffer = cArr2;
            System.arraycopy(cArr, 0, cArr2, 0, this.size);
        }
        return this;
    }

    public boolean equals(StrBuilder strBuilder) {
        if (this == strBuilder) {
            return true;
        }
        int i = this.size;
        if (i != strBuilder.size) {
            return false;
        }
        char[] cArr = this.buffer;
        char[] cArr2 = strBuilder.buffer;
        for (int i2 = i - 1; i2 >= 0; i2--) {
            if (cArr[i2] != cArr2[i2]) {
                return false;
            }
        }
        return true;
    }

    public boolean equalsIgnoreCase(StrBuilder strBuilder) {
        if (this == strBuilder) {
            return true;
        }
        int i = this.size;
        if (i != strBuilder.size) {
            return false;
        }
        char[] cArr = this.buffer;
        char[] cArr2 = strBuilder.buffer;
        for (int i2 = i - 1; i2 >= 0; i2--) {
            char c2 = cArr[i2];
            char c3 = cArr2[i2];
            if (c2 != c3 && Character.toUpperCase(c2) != Character.toUpperCase(c3)) {
                return false;
            }
        }
        return true;
    }

    public char[] getChars(char[] cArr) {
        int length = length();
        if (cArr == null || cArr.length < length) {
            cArr = new char[length];
        }
        System.arraycopy(this.buffer, 0, cArr, 0, length);
        return cArr;
    }

    public String getNewLineText() {
        return this.newLine;
    }

    public String getNullText() {
        return this.nullText;
    }

    public int hashCode() {
        char[] cArr = this.buffer;
        int i = 0;
        for (int i2 = this.size - 1; i2 >= 0; i2--) {
            i = (i * 31) + cArr[i2];
        }
        return i;
    }

    public int indexOf(char c2) {
        return indexOf(c2, 0);
    }

    public StrBuilder insert(int i, Object obj) {
        if (obj == null) {
            return insert(i, this.nullText);
        }
        return insert(i, obj.toString());
    }

    public boolean isEmpty() {
        return this.size == 0;
    }

    public int lastIndexOf(char c2) {
        return lastIndexOf(c2, this.size - 1);
    }

    public String leftString(int i) {
        if (i <= 0) {
            return "";
        }
        if (i >= this.size) {
            return new String(this.buffer, 0, this.size);
        }
        return new String(this.buffer, 0, i);
    }

    public int length() {
        return this.size;
    }

    public String midString(int i, int i2) {
        if (i < 0) {
            i = 0;
        }
        if (i2 > 0) {
            int i3 = this.size;
            if (i < i3) {
                if (i3 <= i + i2) {
                    return new String(this.buffer, i, this.size - i);
                }
                return new String(this.buffer, i, i2);
            }
        }
        return "";
    }

    public StrBuilder minimizeCapacity() {
        if (this.buffer.length > length()) {
            char[] cArr = this.buffer;
            char[] cArr2 = new char[length()];
            this.buffer = cArr2;
            System.arraycopy(cArr, 0, cArr2, 0, this.size);
        }
        return this;
    }

    public StrBuilder replace(int i, int i2, String str) {
        int i3;
        int validateRange = validateRange(i, i2);
        if (str == null) {
            i3 = 0;
        } else {
            i3 = str.length();
        }
        replaceImpl(i, validateRange, validateRange - i, str, i3);
        return this;
    }

    public StrBuilder replaceAll(char c2, char c3) {
        if (c2 != c3) {
            for (int i = 0; i < this.size; i++) {
                char[] cArr = this.buffer;
                if (cArr[i] == c2) {
                    cArr[i] = c3;
                }
            }
        }
        return this;
    }

    public StrBuilder replaceFirst(char c2, char c3) {
        if (c2 != c3) {
            int i = 0;
            while (true) {
                if (i >= this.size) {
                    break;
                }
                char[] cArr = this.buffer;
                if (cArr[i] == c2) {
                    cArr[i] = c3;
                    break;
                }
                i++;
            }
        }
        return this;
    }

    public StrBuilder reverse() {
        int i = this.size;
        if (i == 0) {
            return this;
        }
        int i2 = i / 2;
        char[] cArr = this.buffer;
        int i3 = 0;
        int i4 = i - 1;
        while (i3 < i2) {
            char c2 = cArr[i3];
            cArr[i3] = cArr[i4];
            cArr[i4] = c2;
            i3++;
            i4--;
        }
        return this;
    }

    public String rightString(int i) {
        if (i <= 0) {
            return "";
        }
        if (i >= this.size) {
            return new String(this.buffer, 0, this.size);
        }
        return new String(this.buffer, this.size - i, i);
    }

    public StrBuilder setCharAt(int i, char c2) {
        if (i < 0 || i >= length()) {
            throw new StringIndexOutOfBoundsException(i);
        }
        this.buffer[i] = c2;
        return this;
    }

    public StrBuilder setLength(int i) {
        if (i >= 0) {
            int i2 = this.size;
            if (i < i2) {
                this.size = i;
            } else if (i > i2) {
                ensureCapacity(i);
                this.size = i;
                for (int i3 = this.size; i3 < i; i3++) {
                    this.buffer[i3] = 0;
                }
            }
            return this;
        }
        throw new StringIndexOutOfBoundsException(i);
    }

    public StrBuilder setNewLineText(String str) {
        this.newLine = str;
        return this;
    }

    public StrBuilder setNullText(String str) {
        if (str != null && str.length() == 0) {
            str = null;
        }
        this.nullText = str;
        return this;
    }

    public int size() {
        return this.size;
    }

    public boolean startsWith(String str) {
        if (str == null) {
            return false;
        }
        int length = str.length();
        if (length == 0) {
            return true;
        }
        if (length > this.size) {
            return false;
        }
        for (int i = 0; i < length; i++) {
            if (this.buffer[i] != str.charAt(i)) {
                return false;
            }
        }
        return true;
    }

    public String substring(int i) {
        return substring(i, this.size);
    }

    public char[] toCharArray() {
        int i = this.size;
        if (i == 0) {
            return ArrayUtils.EMPTY_CHAR_ARRAY;
        }
        char[] cArr = new char[i];
        System.arraycopy(this.buffer, 0, cArr, 0, i);
        return cArr;
    }

    public String toString() {
        return new String(this.buffer, 0, this.size);
    }

    public StringBuffer toStringBuffer() {
        StringBuffer stringBuffer = new StringBuffer(this.size);
        stringBuffer.append(this.buffer, 0, this.size);
        return stringBuffer;
    }

    public StrBuilder trim() {
        int i = this.size;
        if (i == 0) {
            return this;
        }
        char[] cArr = this.buffer;
        int i2 = 0;
        while (i2 < i && cArr[i2] <= ' ') {
            i2++;
        }
        while (i2 < i && cArr[i - 1] <= ' ') {
            i--;
        }
        int i3 = this.size;
        if (i < i3) {
            delete(i, i3);
        }
        if (i2 > 0) {
            delete(0, i2);
        }
        return this;
    }

    public void validateIndex(int i) {
        if (i < 0 || i > this.size) {
            throw new StringIndexOutOfBoundsException(i);
        }
    }

    public int validateRange(int i, int i2) {
        if (i >= 0) {
            int i3 = this.size;
            if (i2 > i3) {
                i2 = i3;
            }
            if (i <= i2) {
                return i2;
            }
            throw new StringIndexOutOfBoundsException("end < start");
        }
        throw new StringIndexOutOfBoundsException(i);
    }

    public StrBuilder(int i) {
        this.buffer = new char[(i <= 0 ? 32 : i)];
    }

    public StrBuilder appendln(String str) {
        return append(str).appendNewLine();
    }

    public int indexOf(char c2, int i) {
        if (i < 0) {
            i = 0;
        }
        if (i >= this.size) {
            return -1;
        }
        char[] cArr = this.buffer;
        while (i < this.size) {
            if (cArr[i] == c2) {
                return i;
            }
            i++;
        }
        return -1;
    }

    public int lastIndexOf(char c2, int i) {
        int i2 = this.size;
        if (i >= i2) {
            i = i2 - 1;
        }
        if (i < 0) {
            return -1;
        }
        while (i >= 0) {
            if (this.buffer[i] == c2) {
                return i;
            }
            i--;
        }
        return -1;
    }

    public String substring(int i, int i2) {
        return new String(this.buffer, i, validateRange(i, i2) - i);
    }

    public StrBuilder append(String str) {
        if (str == null) {
            return appendNull();
        }
        int length = str.length();
        if (length > 0) {
            int length2 = length();
            ensureCapacity(length2 + length);
            str.getChars(0, length, this.buffer, length2);
            this.size += length;
        }
        return this;
    }

    public StrBuilder appendSeparator(char c2) {
        if (size() > 0) {
            append(c2);
        }
        return this;
    }

    public StrBuilder appendln(String str, int i, int i2) {
        return append(str, i, i2).appendNewLine();
    }

    public StrBuilder insert(int i, String str) {
        int i2;
        validateIndex(i);
        if (str == null) {
            str = this.nullText;
        }
        if (str == null) {
            i2 = 0;
        } else {
            i2 = str.length();
        }
        if (i2 > 0) {
            int i3 = this.size + i2;
            ensureCapacity(i3);
            char[] cArr = this.buffer;
            System.arraycopy(cArr, i, cArr, i + i2, this.size - i);
            this.size = i3;
            str.getChars(0, i2, this.buffer, i);
        }
        return this;
    }

    public StrBuilder(String str) {
        if (str == null) {
            this.buffer = new char[32];
            return;
        }
        this.buffer = new char[(str.length() + 32)];
        append(str);
    }

    public StrBuilder appendAll(Collection<Object> collection) {
        if (collection != null && collection.size() > 0) {
            for (Object append : collection) {
                append(append);
            }
        }
        return this;
    }

    public StrBuilder appendln(StringBuffer stringBuffer) {
        return append(stringBuffer).appendNewLine();
    }

    public boolean contains(String str) {
        return indexOf(str, 0) >= 0;
    }

    public StrBuilder deleteFirst(String str) {
        int length = str == null ? 0 : str.length();
        if (length > 0) {
            int indexOf = indexOf(str, 0);
            if (indexOf >= 0) {
                deleteImpl(indexOf, indexOf + length, length);
            }
        }
        return this;
    }

    public int lastIndexOf(String str) {
        return lastIndexOf(str, this.size - 1);
    }

    public StrBuilder replace(StrMatcher strMatcher, String str, int i, int i2, int i3) {
        return replaceImpl(strMatcher, str, i, validateRange(i, i2), i3);
    }

    public StrBuilder replaceAll(String str, String str2) {
        int i;
        int length = str == null ? 0 : str.length();
        if (length > 0) {
            if (str2 == null) {
                i = 0;
            } else {
                i = str2.length();
            }
            int indexOf = indexOf(str, 0);
            while (indexOf >= 0) {
                replaceImpl(indexOf, indexOf + length, length, str2, i);
                indexOf = indexOf(str, indexOf + i);
            }
        }
        return this;
    }

    public StrBuilder replaceFirst(String str, String str2) {
        int i;
        int length = str == null ? 0 : str.length();
        if (length > 0) {
            int indexOf = indexOf(str, 0);
            if (indexOf >= 0) {
                if (str2 == null) {
                    i = 0;
                } else {
                    i = str2.length();
                }
                replaceImpl(indexOf, indexOf + length, length, str2, i);
            }
        }
        return this;
    }

    public StrBuilder appendSeparator(String str, int i) {
        if (str != null && i > 0) {
            append(str);
        }
        return this;
    }

    public StrBuilder appendln(StringBuffer stringBuffer, int i, int i2) {
        return append(stringBuffer, i, i2).appendNewLine();
    }

    public boolean contains(StrMatcher strMatcher) {
        return indexOf(strMatcher, 0) >= 0;
    }

    public boolean equals(Object obj) {
        if (obj instanceof StrBuilder) {
            return equals((StrBuilder) obj);
        }
        return false;
    }

    public void getChars(int i, int i2, char[] cArr, int i3) {
        if (i < 0) {
            throw new StringIndexOutOfBoundsException(i);
        } else if (i2 < 0 || i2 > length()) {
            throw new StringIndexOutOfBoundsException(i2);
        } else if (i <= i2) {
            System.arraycopy(this.buffer, i, cArr, i3, i2 - i);
        } else {
            throw new StringIndexOutOfBoundsException("end < start");
        }
    }

    public int lastIndexOf(String str, int i) {
        int i2 = this.size;
        if (i >= i2) {
            i = i2 - 1;
        }
        if (str != null && i >= 0) {
            int length = str.length();
            if (length <= 0 || length > this.size) {
                if (length == 0) {
                    return i;
                }
            } else if (length == 1) {
                return lastIndexOf(str.charAt(0), i);
            } else {
                int i3 = (i - length) + 1;
                while (i3 >= 0) {
                    int i4 = 0;
                    while (i4 < length) {
                        if (str.charAt(i4) != this.buffer[i3 + i4]) {
                            i3--;
                        } else {
                            i4++;
                        }
                    }
                    return i3;
                }
            }
        }
        return -1;
    }

    public char[] toCharArray(int i, int i2) {
        int validateRange = validateRange(i, i2) - i;
        if (validateRange == 0) {
            return ArrayUtils.EMPTY_CHAR_ARRAY;
        }
        char[] cArr = new char[validateRange];
        System.arraycopy(this.buffer, i, cArr, 0, validateRange);
        return cArr;
    }

    private StrBuilder replaceImpl(StrMatcher strMatcher, String str, int i, int i2, int i3) {
        int i4;
        if (!(strMatcher == null || this.size == 0)) {
            if (str == null) {
                i4 = 0;
            } else {
                i4 = str.length();
            }
            char[] cArr = this.buffer;
            int i5 = i;
            while (i5 < i2 && i3 != 0) {
                int isMatch = strMatcher.isMatch(cArr, i5, i, i2);
                if (isMatch > 0) {
                    replaceImpl(i5, i5 + isMatch, isMatch, str, i4);
                    i2 = (i2 - isMatch) + i4;
                    i5 = (i5 + i4) - 1;
                    if (i3 > 0) {
                        i3--;
                    }
                }
                i5++;
            }
        }
        return this;
    }

    public StrBuilder appendSeparator(char c2, int i) {
        if (i > 0) {
            append(c2);
        }
        return this;
    }

    public StrBuilder appendWithSeparators(Collection collection, String str) {
        if (collection != null && collection.size() > 0) {
            if (str == null) {
                str = "";
            }
            Iterator it = collection.iterator();
            while (it.hasNext()) {
                append(it.next());
                if (it.hasNext()) {
                    append(str);
                }
            }
        }
        return this;
    }

    public StrBuilder appendln(StrBuilder strBuilder) {
        return append(strBuilder).appendNewLine();
    }

    public StrBuilder deleteAll(String str) {
        int length = str == null ? 0 : str.length();
        if (length > 0) {
            int indexOf = indexOf(str, 0);
            while (indexOf >= 0) {
                deleteImpl(indexOf, indexOf + length, length);
                indexOf = indexOf(str, indexOf);
            }
        }
        return this;
    }

    public int indexOf(String str) {
        return indexOf(str, 0);
    }

    public StrBuilder appendln(StrBuilder strBuilder, int i, int i2) {
        return append(strBuilder, i, i2).appendNewLine();
    }

    public StrBuilder deleteFirst(StrMatcher strMatcher) {
        return replace(strMatcher, null, 0, this.size, 1);
    }

    public int indexOf(String str, int i) {
        if (i < 0) {
            i = 0;
        }
        if (str != null && i < this.size) {
            int length = str.length();
            if (length == 1) {
                return indexOf(str.charAt(0), i);
            }
            if (length == 0) {
                return i;
            }
            int i2 = this.size;
            if (length > i2) {
                return -1;
            }
            char[] cArr = this.buffer;
            int i3 = (i2 - length) + 1;
            while (i < i3) {
                int i4 = 0;
                while (i4 < length) {
                    if (str.charAt(i4) != cArr[i + i4]) {
                        i++;
                    } else {
                        i4++;
                    }
                }
                return i;
            }
        }
        return -1;
    }

    public StrBuilder appendAll(Iterator it) {
        if (it != null) {
            while (it.hasNext()) {
                append(it.next());
            }
        }
        return this;
    }

    public StrBuilder appendFixedWidthPadLeft(int i, int i2, char c2) {
        return appendFixedWidthPadLeft((Object) String.valueOf(i), i2, c2);
    }

    public StrBuilder appendFixedWidthPadRight(int i, int i2, char c2) {
        return appendFixedWidthPadRight((Object) String.valueOf(i), i2, c2);
    }

    public StrBuilder appendln(char[] cArr) {
        return append(cArr).appendNewLine();
    }

    public StrBuilder replaceFirst(StrMatcher strMatcher, String str) {
        return replace(strMatcher, str, 0, this.size, 1);
    }

    public StrBuilder append(String str, int i, int i2) {
        if (str == null) {
            return appendNull();
        }
        if (i < 0 || i > str.length()) {
            throw new StringIndexOutOfBoundsException("startIndex must be valid");
        }
        if (i2 >= 0) {
            int i3 = i + i2;
            if (i3 <= str.length()) {
                if (i2 > 0) {
                    int length = length();
                    ensureCapacity(length + i2);
                    str.getChars(i, i3, this.buffer, length);
                    this.size += i2;
                }
                return this;
            }
        }
        throw new StringIndexOutOfBoundsException("length must be valid");
    }

    public StrBuilder appendln(char[] cArr, int i, int i2) {
        return append(cArr, i, i2).appendNewLine();
    }

    public StrBuilder replaceAll(StrMatcher strMatcher, String str) {
        return replace(strMatcher, str, 0, this.size, -1);
    }

    public StrBuilder appendln(boolean z) {
        return append(z).appendNewLine();
    }

    public StrBuilder deleteAll(StrMatcher strMatcher) {
        return replace(strMatcher, null, 0, this.size, -1);
    }

    public int lastIndexOf(StrMatcher strMatcher) {
        return lastIndexOf(strMatcher, this.size);
    }

    public StrBuilder appendln(char c2) {
        return append(c2).appendNewLine();
    }

    public StrBuilder insert(int i, char[] cArr) {
        validateIndex(i);
        if (cArr == null) {
            return insert(i, this.nullText);
        }
        int length = cArr.length;
        if (length > 0) {
            ensureCapacity(this.size + length);
            char[] cArr2 = this.buffer;
            System.arraycopy(cArr2, i, cArr2, i + length, this.size - i);
            System.arraycopy(cArr, 0, this.buffer, i, length);
            this.size += length;
        }
        return this;
    }

    public int lastIndexOf(StrMatcher strMatcher, int i) {
        int i2 = this.size;
        if (i >= i2) {
            i = i2 - 1;
        }
        if (strMatcher != null && i >= 0) {
            char[] cArr = this.buffer;
            int i3 = i + 1;
            while (i >= 0) {
                if (strMatcher.isMatch(cArr, i, 0, i3) > 0) {
                    return i;
                }
                i--;
            }
        }
        return -1;
    }

    public StrBuilder appendWithSeparators(Iterator it, String str) {
        if (it != null) {
            if (str == null) {
                str = "";
            }
            while (it.hasNext()) {
                append(it.next());
                if (it.hasNext()) {
                    append(str);
                }
            }
        }
        return this;
    }

    public StrBuilder appendln(int i) {
        return append(i).appendNewLine();
    }

    public StrBuilder appendln(long j) {
        return append(j).appendNewLine();
    }

    public int indexOf(StrMatcher strMatcher) {
        return indexOf(strMatcher, 0);
    }

    public StrBuilder appendln(float f2) {
        return append(f2).appendNewLine();
    }

    public int indexOf(StrMatcher strMatcher, int i) {
        if (i < 0) {
            i = 0;
        }
        if (strMatcher != null) {
            int i2 = this.size;
            if (i < i2) {
                char[] cArr = this.buffer;
                for (int i3 = i; i3 < i2; i3++) {
                    if (strMatcher.isMatch(cArr, i3, i, i2) > 0) {
                        return i3;
                    }
                }
            }
        }
        return -1;
    }

    public StrBuilder appendln(double d2) {
        return append(d2).appendNewLine();
    }

    public StrBuilder append(StringBuffer stringBuffer) {
        if (stringBuffer == null) {
            return appendNull();
        }
        int length = stringBuffer.length();
        if (length > 0) {
            int length2 = length();
            ensureCapacity(length2 + length);
            stringBuffer.getChars(0, length, this.buffer, length2);
            this.size += length;
        }
        return this;
    }

    public StrBuilder insert(int i, char[] cArr, int i2, int i3) {
        validateIndex(i);
        if (cArr == null) {
            return insert(i, this.nullText);
        }
        if (i2 < 0 || i2 > cArr.length) {
            StringBuffer stringBuffer = new StringBuffer();
            stringBuffer.append("Invalid offset: ");
            stringBuffer.append(i2);
            throw new StringIndexOutOfBoundsException(stringBuffer.toString());
        } else if (i3 < 0 || i2 + i3 > cArr.length) {
            StringBuffer stringBuffer2 = new StringBuffer();
            stringBuffer2.append("Invalid length: ");
            stringBuffer2.append(i3);
            throw new StringIndexOutOfBoundsException(stringBuffer2.toString());
        } else {
            if (i3 > 0) {
                ensureCapacity(this.size + i3);
                char[] cArr2 = this.buffer;
                System.arraycopy(cArr2, i, cArr2, i + i3, this.size - i);
                System.arraycopy(cArr, i2, this.buffer, i, i3);
                this.size += i3;
            }
            return this;
        }
    }

    public StrBuilder append(StringBuffer stringBuffer, int i, int i2) {
        if (stringBuffer == null) {
            return appendNull();
        }
        if (i < 0 || i > stringBuffer.length()) {
            throw new StringIndexOutOfBoundsException("startIndex must be valid");
        }
        if (i2 >= 0) {
            int i3 = i + i2;
            if (i3 <= stringBuffer.length()) {
                if (i2 > 0) {
                    int length = length();
                    ensureCapacity(length + i2);
                    stringBuffer.getChars(i, i3, this.buffer, length);
                    this.size += i2;
                }
                return this;
            }
        }
        throw new StringIndexOutOfBoundsException("length must be valid");
    }

    public StrBuilder insert(int i, boolean z) {
        validateIndex(i);
        if (z) {
            ensureCapacity(this.size + 4);
            char[] cArr = this.buffer;
            System.arraycopy(cArr, i, cArr, i + 4, this.size - i);
            char[] cArr2 = this.buffer;
            int i2 = i + 1;
            cArr2[i] = 't';
            int i3 = i2 + 1;
            cArr2[i2] = 'r';
            cArr2[i3] = ASCII85InputStream.PADDING_U;
            cArr2[i3 + 1] = 'e';
            this.size += 4;
        } else {
            ensureCapacity(this.size + 5);
            char[] cArr3 = this.buffer;
            System.arraycopy(cArr3, i, cArr3, i + 5, this.size - i);
            char[] cArr4 = this.buffer;
            int i4 = i + 1;
            cArr4[i] = 'f';
            int i5 = i4 + 1;
            cArr4[i4] = 'a';
            int i6 = i5 + 1;
            cArr4[i5] = 'l';
            cArr4[i6] = 's';
            cArr4[i6 + 1] = 'e';
            this.size += 5;
        }
        return this;
    }

    public StrBuilder append(StrBuilder strBuilder) {
        if (strBuilder == null) {
            return appendNull();
        }
        int length = strBuilder.length();
        if (length > 0) {
            int length2 = length();
            ensureCapacity(length2 + length);
            System.arraycopy(strBuilder.buffer, 0, this.buffer, length2, length);
            this.size += length;
        }
        return this;
    }

    public StrBuilder append(StrBuilder strBuilder, int i, int i2) {
        if (strBuilder == null) {
            return appendNull();
        }
        if (i < 0 || i > strBuilder.length()) {
            throw new StringIndexOutOfBoundsException("startIndex must be valid");
        }
        if (i2 >= 0) {
            int i3 = i + i2;
            if (i3 <= strBuilder.length()) {
                if (i2 > 0) {
                    int length = length();
                    ensureCapacity(length + i2);
                    strBuilder.getChars(i, i3, this.buffer, length);
                    this.size += i2;
                }
                return this;
            }
        }
        throw new StringIndexOutOfBoundsException("length must be valid");
    }

    public StrBuilder insert(int i, char c2) {
        validateIndex(i);
        ensureCapacity(this.size + 1);
        char[] cArr = this.buffer;
        System.arraycopy(cArr, i, cArr, i + 1, this.size - i);
        this.buffer[i] = c2;
        this.size++;
        return this;
    }

    public StrBuilder append(char[] cArr) {
        if (cArr == null) {
            return appendNull();
        }
        int length = cArr.length;
        if (length > 0) {
            int length2 = length();
            ensureCapacity(length2 + length);
            System.arraycopy(cArr, 0, this.buffer, length2, length);
            this.size += length;
        }
        return this;
    }

    public StrBuilder insert(int i, int i2) {
        return insert(i, String.valueOf(i2));
    }

    public StrBuilder insert(int i, long j) {
        return insert(i, String.valueOf(j));
    }

    public StrBuilder insert(int i, float f2) {
        return insert(i, String.valueOf(f2));
    }

    public StrBuilder insert(int i, double d2) {
        return insert(i, String.valueOf(d2));
    }

    public StrBuilder append(char[] cArr, int i, int i2) {
        if (cArr == null) {
            return appendNull();
        }
        if (i < 0 || i > cArr.length) {
            StringBuffer stringBuffer = new StringBuffer();
            stringBuffer.append("Invalid startIndex: ");
            stringBuffer.append(i2);
            throw new StringIndexOutOfBoundsException(stringBuffer.toString());
        } else if (i2 < 0 || i + i2 > cArr.length) {
            StringBuffer stringBuffer2 = new StringBuffer();
            stringBuffer2.append("Invalid length: ");
            stringBuffer2.append(i2);
            throw new StringIndexOutOfBoundsException(stringBuffer2.toString());
        } else {
            if (i2 > 0) {
                int length = length();
                ensureCapacity(length + i2);
                System.arraycopy(cArr, i, this.buffer, length, i2);
                this.size += i2;
            }
            return this;
        }
    }

    public StrBuilder append(boolean z) {
        if (z) {
            ensureCapacity(this.size + 4);
            char[] cArr = this.buffer;
            int i = this.size;
            int i2 = i + 1;
            this.size = i2;
            cArr[i] = 't';
            int i3 = i2 + 1;
            this.size = i3;
            cArr[i2] = 'r';
            int i4 = i3 + 1;
            this.size = i4;
            cArr[i3] = ASCII85InputStream.PADDING_U;
            this.size = i4 + 1;
            cArr[i4] = 'e';
        } else {
            ensureCapacity(this.size + 5);
            char[] cArr2 = this.buffer;
            int i5 = this.size;
            int i6 = i5 + 1;
            this.size = i6;
            cArr2[i5] = 'f';
            int i7 = i6 + 1;
            this.size = i7;
            cArr2[i6] = 'a';
            int i8 = i7 + 1;
            this.size = i8;
            cArr2[i7] = 'l';
            int i9 = i8 + 1;
            this.size = i9;
            cArr2[i8] = 's';
            this.size = i9 + 1;
            cArr2[i9] = 'e';
        }
        return this;
    }

    public StrBuilder append(char c2) {
        ensureCapacity(length() + 1);
        char[] cArr = this.buffer;
        int i = this.size;
        this.size = i + 1;
        cArr[i] = c2;
        return this;
    }

    public StrBuilder append(int i) {
        return append(String.valueOf(i));
    }

    public StrBuilder append(long j) {
        return append(String.valueOf(j));
    }

    public StrBuilder append(float f2) {
        return append(String.valueOf(f2));
    }

    public StrBuilder append(double d2) {
        return append(String.valueOf(d2));
    }
}
