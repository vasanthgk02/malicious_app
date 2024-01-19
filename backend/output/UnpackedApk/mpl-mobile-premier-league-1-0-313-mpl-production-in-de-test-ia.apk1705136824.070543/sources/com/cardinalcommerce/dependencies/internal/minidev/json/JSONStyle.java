package com.cardinalcommerce.dependencies.internal.minidev.json;

import com.cardinalcommerce.dependencies.internal.minidev.json.JStylerObj.MustProtect;
import com.cardinalcommerce.dependencies.internal.minidev.json.JStylerObj.StringProtector;
import org.apache.commons.lang.StringEscapeUtils;

public class JSONStyle {
    public static final JSONStyle NO_COMPRESS = new JSONStyle(0);
    public boolean _ignore_null;
    public boolean _protect4Web;
    public boolean _protectKeys;
    public boolean _protectValues;
    public StringProtector esc;
    public MustProtect mpKey;
    public MustProtect mpValue;

    public JSONStyle(int i) {
        boolean z = false;
        this._protectKeys = (i & 1) == 0;
        this._protectValues = (i & 4) == 0;
        this._protect4Web = (i & 2) == 0;
        this._ignore_null = (i & 16) > 0 ? true : z;
        MustProtect mustProtect = (i & 8) > 0 ? JStylerObj.MP_AGGRESIVE : JStylerObj.MP_SIMPLE;
        if (this._protectValues) {
            this.mpValue = JStylerObj.MP_TRUE;
        } else {
            this.mpValue = mustProtect;
        }
        this.mpKey = this._protectKeys ? JStylerObj.MP_TRUE : mustProtect;
        this.esc = this._protect4Web ? JStylerObj.ESCAPE4Web : JStylerObj.ESCAPE_LT;
    }

    public void writeString(Appendable appendable, String str) {
        if (!this.mpValue.mustBeProtect(str)) {
            appendable.append(str);
            return;
        }
        appendable.append(StringEscapeUtils.CSV_QUOTE);
        JSONValue.escape(str, appendable, this);
        appendable.append(StringEscapeUtils.CSV_QUOTE);
    }
}
