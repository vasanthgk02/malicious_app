package org.jdom.output;

public class Format implements Cloneable {
    public static /* synthetic */ Class class$java$lang$String;
    public String encoding = "UTF-8";
    public boolean expandEmptyElements = false;
    public boolean ignoreTrAXEscapingPIs = false;
    public String indent = null;
    public String lineSeparator = "\r\n";
    public TextMode mode = TextMode.PRESERVE;
    public boolean omitDeclaration = false;
    public boolean omitEncoding = false;

    public class DefaultEscapeStrategy {
        public Object encoder;

        public DefaultEscapeStrategy(String str) {
            Class<?> cls;
            if (!"UTF-8".equalsIgnoreCase(str) && !"UTF-16".equalsIgnoreCase(str) && !"ISO-8859-1".equalsIgnoreCase(str) && !"Latin1".equalsIgnoreCase(str) && !"US-ASCII".equalsIgnoreCase(str) && !"ASCII".equalsIgnoreCase(str)) {
                try {
                    Class<?> cls2 = Class.forName("java.nio.charset.Charset");
                    Class<?> cls3 = Class.forName("java.nio.charset.CharsetEncoder");
                    Class[] clsArr = new Class[1];
                    if (Format.class$java$lang$String == null) {
                        cls = Class.forName("java.lang.String");
                        Format.class$java$lang$String = cls;
                    } else {
                        cls = Format.class$java$lang$String;
                    }
                    clsArr[0] = cls;
                    this.encoder = cls2.getMethod("newEncoder", null).invoke(cls2.getMethod("forName", clsArr).invoke(null, new Object[]{str}), null);
                    cls3.getMethod("canEncode", new Class[]{Character.TYPE});
                } catch (ClassNotFoundException e2) {
                    throw new NoClassDefFoundError(e2.getMessage());
                } catch (Exception unused) {
                }
            }
        }
    }

    public static class TextMode {
        public static final TextMode PRESERVE = new TextMode("PRESERVE");
        public final String name;

        public TextMode(String str) {
            this.name = str;
        }

        public String toString() {
            return this.name;
        }
    }

    public Format() {
        new DefaultEscapeStrategy("UTF-8");
    }

    public Object clone() {
        try {
            return (Format) super.clone();
        } catch (CloneNotSupportedException unused) {
            return null;
        }
    }
}
