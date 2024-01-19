package com.firebase.jobdispatcher;

import android.text.TextUtils;
import com.android.tools.r8.GeneratedOutlineSupport;
import java.util.List;

public class ValidationEnforcer implements JobValidator {
    public final JobValidator validator;

    public static final class ValidationException extends RuntimeException {
        /* JADX WARN: Illegal instructions before constructor call commented (this can break semantics) */
        public ValidationException(String str, List<String> list) {
            // StringBuilder outline78 = GeneratedOutlineSupport.outline78(str, ": ");
            // outline78.append(TextUtils.join("\n  - ", list));
            super(outline78.toString());
        }
    }

    public ValidationEnforcer(JobValidator jobValidator) {
        this.validator = jobValidator;
    }

    public List<String> validate(JobParameters jobParameters) {
        return this.validator.validate(jobParameters);
    }
}
