package io.hansel.core.json;

import com.android.tools.r8.GeneratedOutlineSupport;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import org.apache.fontbox.cmap.CMapParser;

public class CoreJSONStringer {
    public final String indent;
    public final StringBuilder out;
    public final List<a> stack;

    public enum a {
        EMPTY_ARRAY,
        NONEMPTY_ARRAY,
        EMPTY_OBJECT,
        DANGLING_KEY,
        NONEMPTY_OBJECT,
        NULL
    }

    public CoreJSONStringer() {
        this.out = new StringBuilder();
        this.stack = new ArrayList();
        this.indent = null;
    }

    public CoreJSONStringer(int i) {
        this.out = new StringBuilder();
        this.stack = new ArrayList();
        char[] cArr = new char[i];
        Arrays.fill(cArr, ' ');
        this.indent = new String(cArr);
    }

    private void beforeKey() {
        a peek = peek();
        if (peek == a.NONEMPTY_OBJECT) {
            this.out.append(',');
        } else if (peek != a.EMPTY_OBJECT) {
            throw new CoreJSONException("Nesting problem");
        }
        newline();
        replaceTop(a.DANGLING_KEY);
    }

    private void beforeValue() {
        if (!this.stack.isEmpty()) {
            a peek = peek();
            if (peek == a.EMPTY_ARRAY) {
                replaceTop(a.NONEMPTY_ARRAY);
            } else if (peek == a.NONEMPTY_ARRAY) {
                this.out.append(',');
            } else {
                if (peek == a.DANGLING_KEY) {
                    this.out.append(this.indent == null ? ":" : ": ");
                    replaceTop(a.NONEMPTY_OBJECT);
                } else if (peek != a.NULL) {
                    throw new CoreJSONException("Nesting problem");
                }
            }
            newline();
        }
    }

    private void newline() {
        if (this.indent != null) {
            this.out.append("\n");
            int size = this.stack.size();
            for (int i = 0; i < size; i++) {
                this.out.append(this.indent);
            }
        }
    }

    private a peek() {
        if (!this.stack.isEmpty()) {
            return (a) GeneratedOutlineSupport.outline29(this.stack, -1);
        }
        throw new CoreJSONException("Nesting problem");
    }

    private void replaceTop(a aVar) {
        List<a> list = this.stack;
        list.set(list.size() - 1, aVar);
    }

    private void string(String str) {
        StringBuilder sb;
        String str2;
        StringBuilder sb2;
        this.out.append("\"");
        int length = str.length();
        for (int i = 0; i < length; i++) {
            char charAt = str.charAt(i);
            if (charAt == 12) {
                sb = this.out;
                str2 = "\\f";
            } else if (charAt != 13) {
                if (charAt != '\"' && charAt != '/' && charAt != '\\') {
                    switch (charAt) {
                        case 8:
                            sb = this.out;
                            str2 = "\\b";
                            break;
                        case 9:
                            sb = this.out;
                            str2 = "\\t";
                            break;
                        case 10:
                            sb = this.out;
                            str2 = "\\n";
                            break;
                        default:
                            if (charAt > 31) {
                                sb2 = this.out;
                                break;
                            } else {
                                this.out.append(String.format("\\u%04x", new Object[]{Integer.valueOf(charAt)}));
                                break;
                            }
                    }
                } else {
                    sb2 = this.out;
                    sb2.append('\\');
                }
                sb2.append(charAt);
            } else {
                sb = this.out;
                str2 = "\\r";
            }
            sb.append(str2);
        }
        this.out.append("\"");
    }

    public CoreJSONStringer array() {
        return open(a.EMPTY_ARRAY, "[");
    }

    public CoreJSONStringer close(a aVar, a aVar2, String str) {
        a peek = peek();
        if (peek == aVar2 || peek == aVar) {
            List<a> list = this.stack;
            list.remove(list.size() - 1);
            if (peek == aVar2) {
                newline();
            }
            this.out.append(str);
            return this;
        }
        throw new CoreJSONException("Nesting problem");
    }

    public CoreJSONStringer endArray() {
        return close(a.EMPTY_ARRAY, a.NONEMPTY_ARRAY, CMapParser.MARK_END_OF_ARRAY);
    }

    public CoreJSONStringer endObject() {
        return close(a.EMPTY_OBJECT, a.NONEMPTY_OBJECT, "}");
    }

    public CoreJSONStringer key(String str) {
        if (str != null) {
            beforeKey();
            string(str);
            return this;
        }
        throw new CoreJSONException("Names must be non-null");
    }

    public CoreJSONStringer object() {
        return open(a.EMPTY_OBJECT, "{");
    }

    public CoreJSONStringer open(a aVar, String str) {
        if (!this.stack.isEmpty() || this.out.length() <= 0) {
            beforeValue();
            this.stack.add(aVar);
            this.out.append(str);
            return this;
        }
        throw new CoreJSONException("Nesting problem: multiple top-level roots");
    }

    public String toString() {
        if (this.out.length() == 0) {
            return null;
        }
        return this.out.toString();
    }

    public CoreJSONStringer value(double d2) {
        if (!this.stack.isEmpty()) {
            beforeValue();
            this.out.append(CoreJSONObject.numberToString(Double.valueOf(d2)));
            return this;
        }
        throw new CoreJSONException("Nesting problem");
    }

    public CoreJSONStringer value(long j) {
        if (!this.stack.isEmpty()) {
            beforeValue();
            this.out.append(j);
            return this;
        }
        throw new CoreJSONException("Nesting problem");
    }

    public CoreJSONStringer value(Object obj) {
        if (this.stack.isEmpty()) {
            throw new CoreJSONException("Nesting problem");
        } else if (obj instanceof CoreJSONArray) {
            ((CoreJSONArray) obj).writeTo(this);
            return this;
        } else if (obj instanceof CoreJSONObject) {
            ((CoreJSONObject) obj).writeTo(this);
            return this;
        } else {
            beforeValue();
            if (obj == null || (obj instanceof Boolean) || obj == CoreJSONObject.NULL) {
                this.out.append(obj);
            } else if (obj instanceof Number) {
                this.out.append(CoreJSONObject.numberToString((Number) obj));
            } else {
                string(obj.toString());
            }
            return this;
        }
    }

    public CoreJSONStringer value(boolean z) {
        if (!this.stack.isEmpty()) {
            beforeValue();
            this.out.append(z);
            return this;
        }
        throw new CoreJSONException("Nesting problem");
    }
}
