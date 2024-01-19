package io.hansel.core.criteria.datatype;

import io.hansel.core.criteria.b;
import io.hansel.core.logger.HSLLogger;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.Locale;

public class LanguageDataType extends b implements Serializable {
    public boolean in(Object obj, String str) {
        if (str != null) {
            try {
                if (obj instanceof ArrayList) {
                    Locale locale = new Locale(str);
                    Iterator it = ((ArrayList) obj).iterator();
                    while (it.hasNext()) {
                        if (locale.getLanguage().equals(new Locale((String) it.next()).getLanguage())) {
                            return true;
                        }
                    }
                }
            } catch (Exception e2) {
                HSLLogger.printStackTrace(e2);
            }
        }
        return false;
    }
}
