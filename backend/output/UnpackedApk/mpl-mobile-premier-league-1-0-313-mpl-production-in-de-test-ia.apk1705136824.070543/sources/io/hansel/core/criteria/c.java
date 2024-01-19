package io.hansel.core.criteria;

import io.hansel.core.logger.HSLLogger;

public enum c {
    and,
    or,
    not;

    public static c a(String str) {
        if (str != null) {
            if ("and".equals(str) || "AND".equals(str)) {
                return and;
            }
            if ("or".equals(str) || "OR".equals(str)) {
                return or;
            }
            if (HSLCriteriaBuilder.NOT.equals(str) || "NOT".equals(str)) {
                return not;
            }
        }
        HSLLogger.d("Getting operator method returns null");
        return null;
    }
}
