package net.sf.json;

import com.android.tools.r8.GeneratedOutlineSupport;
import java.io.Serializable;
import net.sf.json.regexp.RegexpUtils;
import net.sf.json.util.JSONUtils;
import org.apache.commons.lang.StringUtils;
import org.apache.commons.lang.builder.EqualsBuilder;
import org.apache.commons.lang.builder.HashCodeBuilder;

public class JSONFunction implements Serializable {
    public static final String[] EMPTY_PARAM_ARRAY = new String[0];
    public String[] params;
    public String text;

    public JSONFunction(String[] strArr, String str) {
        String str2;
        if (str != null) {
            str2 = str.trim();
        } else {
            str2 = "";
        }
        this.text = str2;
        if (strArr != null) {
            if (strArr.length != 1 || !strArr[0].trim().equals("")) {
                String[] strArr2 = new String[strArr.length];
                this.params = strArr2;
                System.arraycopy(strArr, 0, strArr2, 0, strArr.length);
                for (int i = 0; i < strArr.length; i++) {
                    String[] strArr3 = this.params;
                    strArr3[i] = strArr3[i].trim();
                }
                return;
            }
            this.params = EMPTY_PARAM_ARRAY;
            return;
        }
        this.params = EMPTY_PARAM_ARRAY;
    }

    public static JSONFunction parse(String str) {
        if (JSONUtils.isFunction(str)) {
            String functionParams = JSONUtils.getFunctionParams(str);
            String groupIfMatches = RegexpUtils.getMatchera("^function[ ]?\\(.*?\\)[ \n\t]*\\{(.*?)\\}$").getGroupIfMatches(str, 1);
            String[] split = functionParams != null ? StringUtils.split(functionParams, (String) ",") : null;
            if (groupIfMatches == null) {
                groupIfMatches = "";
            }
            return new JSONFunction(split, groupIfMatches);
        }
        throw new JSONException(GeneratedOutlineSupport.outline49("String is not a function. ", str));
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        int i = 0;
        if (obj == null) {
            return false;
        }
        if (obj instanceof String) {
            try {
                return equals(parse((String) obj));
            } catch (JSONException unused) {
                return false;
            }
        } else if (!(obj instanceof JSONFunction)) {
            return false;
        } else {
            JSONFunction jSONFunction = (JSONFunction) obj;
            if (this.params.length != jSONFunction.params.length) {
                return false;
            }
            EqualsBuilder equalsBuilder = new EqualsBuilder();
            while (true) {
                String[] strArr = this.params;
                if (i < strArr.length) {
                    equalsBuilder.append((Object) strArr[i], (Object) jSONFunction.params[i]);
                    i++;
                } else {
                    equalsBuilder.append((Object) this.text, (Object) jSONFunction.text);
                    return equalsBuilder.isEquals();
                }
            }
        }
    }

    public int hashCode() {
        HashCodeBuilder hashCodeBuilder = new HashCodeBuilder();
        int i = 0;
        while (true) {
            String[] strArr = this.params;
            if (i < strArr.length) {
                hashCodeBuilder.append((Object) strArr[i]);
                i++;
            } else {
                hashCodeBuilder.append((Object) this.text);
                return hashCodeBuilder.toHashCode();
            }
        }
    }

    public String toString() {
        String[] strArr;
        StringBuffer stringBuffer = new StringBuffer("function(");
        if (this.params.length > 0) {
            int i = 0;
            while (true) {
                strArr = this.params;
                if (i >= strArr.length - 1) {
                    break;
                }
                stringBuffer.append(strArr[i]);
                stringBuffer.append(',');
                i++;
            }
            stringBuffer.append(strArr[strArr.length - 1]);
        }
        stringBuffer.append("){");
        if (this.text.length() > 0) {
            stringBuffer.append(' ');
            stringBuffer.append(this.text);
            stringBuffer.append(' ');
        }
        stringBuffer.append('}');
        return stringBuffer.toString();
    }
}
