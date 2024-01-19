package com.idology.idscan.check;

import java.util.HashSet;
import java.util.Set;

public abstract class IdImageResultApprover {
    public int getFrontErrorCount(IdImageCheckResult idImageCheckResult) {
        if (idImageCheckResult.imageError) {
            return 1;
        }
        HashSet hashSet = new HashSet();
        if (isDocumentTooSmall(idImageCheckResult)) {
            hashSet.add("Document Too Small");
        }
        if (isBorderTooSmall(idImageCheckResult)) {
            hashSet.add("Document Border Too Small");
        }
        int i = idImageCheckResult.cornersLocated;
        if (i < 4) {
            hashSet.add("Document Missing Four Corners");
        } else if (i > 4) {
            hashSet.add("Document Edge Not Detected");
        } else if (idImageCheckResult.maxCornerAngle > 100.0d) {
            hashSet.add("Document is Skewed");
        }
        if (!idImageCheckResult.faceLocated) {
            hashSet.add("Face Image Not Detected");
        }
        removeInvalidFrontErrors(hashSet);
        return hashSet.size();
    }

    public abstract boolean isBorderTooSmall(IdImageCheckResult idImageCheckResult);

    public final boolean isDocumentTooSmall(IdImageCheckResult idImageCheckResult) {
        int i = idImageCheckResult.documentWidth;
        int i2 = idImageCheckResult.documentHeight;
        return ((double) Math.max(i, i2)) < ((double) 1012) * 0.5d || ((double) Math.min(i, i2)) < ((double) 635) * 0.5d;
    }

    public abstract void removeInvalidFrontErrors(Set<String> set);
}
