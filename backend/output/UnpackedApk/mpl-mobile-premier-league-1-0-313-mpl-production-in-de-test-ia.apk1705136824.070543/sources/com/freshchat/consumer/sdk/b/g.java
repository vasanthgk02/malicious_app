package com.freshchat.consumer.sdk.b;

import com.android.tools.r8.GeneratedOutlineSupport;
import java.util.regex.Pattern;

public class g {
    public Pattern dN;
    public Pattern dO;
    public Pattern dP;

    public g(String str) {
        StringBuilder outline73 = GeneratedOutlineSupport.outline73("(?:");
        outline73.append(Pattern.quote(str.trim()));
        outline73.append(")");
        this.dN = Pattern.compile(outline73.toString(), 2);
        StringBuilder outline732 = GeneratedOutlineSupport.outline73("^");
        outline732.append(Pattern.quote(str.trim()));
        this.dO = Pattern.compile(outline732.toString(), 2);
        StringBuilder outline733 = GeneratedOutlineSupport.outline73("\\b(?:");
        outline733.append(Pattern.quote(str.trim()));
        outline733.append(")\\b");
        this.dP = Pattern.compile(outline733.toString(), 2);
    }

    public int a(String str, String str2) {
        int i = this.dN.matcher(str2).find() ? 1 : 0;
        if (this.dN.matcher(str).find()) {
            i += 2;
        }
        if (this.dO.matcher(str2).find()) {
            i++;
        }
        if (this.dO.matcher(str).find()) {
            i += 2;
        }
        if (this.dP.matcher(str2).find()) {
            i++;
        }
        return this.dP.matcher(str).find() ? i + 2 : i;
    }
}
