package net.minidev.json.parser;

public class JSONParserString extends JSONParserMemory {

    /* renamed from: in  reason: collision with root package name */
    public String f6147in;

    public JSONParserString(int i) {
        super(i);
    }

    public void extractStringTrim(int i, int i2) {
        while (i < i2 - 1 && Character.isWhitespace(this.f6147in.charAt(i))) {
            i++;
        }
        while (true) {
            int i3 = i2 - 1;
            if (i3 <= i || !Character.isWhitespace(this.f6147in.charAt(i3))) {
                this.xs = this.f6147in.substring(i, i2);
            } else {
                i2 = i3;
            }
        }
        this.xs = this.f6147in.substring(i, i2);
    }

    public void read() {
        int i = this.pos + 1;
        this.pos = i;
        if (i >= this.len) {
            this.f6145c = 26;
        } else {
            this.f6145c = this.f6147in.charAt(i);
        }
    }

    public void readS() {
        int i = this.pos + 1;
        this.pos = i;
        if (i >= this.len) {
            this.f6145c = 26;
        } else {
            this.f6145c = this.f6147in.charAt(i);
        }
    }
}
