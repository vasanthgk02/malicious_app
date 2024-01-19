package com.idology.idscan.check;

import java.util.Set;

public class PassportResultApprover extends IdImageResultApprover {
    public boolean isBorderTooSmall(IdImageCheckResult idImageCheckResult) {
        return false;
    }

    public void removeInvalidFrontErrors(Set<String> set) {
        set.remove("Document Edge Not Detected");
        set.remove("Document Border Too Small");
        set.remove("Document Missing Four Corners");
    }
}
