package com.idology.idscan.check;

import com.idology.idscan.check.IdImageCheckResult.Border;
import java.util.Set;

public class DuplexCardResultApprover extends IdImageResultApprover {
    public DuplexCardResultApprover(String str, String str2) {
    }

    public boolean isBorderTooSmall(IdImageCheckResult idImageCheckResult) {
        return idImageCheckResult.isBorderTooSmall(Border.Top) || idImageCheckResult.isBorderTooSmall(Border.Right) || idImageCheckResult.isBorderTooSmall(Border.Bottom) || idImageCheckResult.isBorderTooSmall(Border.Left);
    }

    public void removeInvalidFrontErrors(Set<String> set) {
    }
}
