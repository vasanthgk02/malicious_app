package androidx.work.impl.utils;

import androidx.work.impl.WorkDatabase;
import androidx.work.impl.model.Preference;
import androidx.work.impl.model.PreferenceDao_Impl;

public class IdGenerator {
    public final WorkDatabase mWorkDatabase;

    public IdGenerator(WorkDatabase workDatabase) {
        this.mWorkDatabase = workDatabase;
    }

    public final int nextId(String str) {
        this.mWorkDatabase.beginTransaction();
        try {
            Long longValue = ((PreferenceDao_Impl) this.mWorkDatabase.preferenceDao()).getLongValue(str);
            int i = 0;
            int intValue = longValue != null ? longValue.intValue() : 0;
            if (intValue != Integer.MAX_VALUE) {
                i = intValue + 1;
            }
            ((PreferenceDao_Impl) this.mWorkDatabase.preferenceDao()).insertPreference(new Preference(str, (long) i));
            this.mWorkDatabase.setTransactionSuccessful();
            return intValue;
        } finally {
            this.mWorkDatabase.endTransaction();
        }
    }

    public int nextJobSchedulerIdWithRange(int i, int i2) {
        synchronized (IdGenerator.class) {
            try {
                int nextId = nextId("next_job_scheduler_id");
                if (nextId >= i) {
                    if (nextId <= i2) {
                        i = nextId;
                    }
                }
                ((PreferenceDao_Impl) this.mWorkDatabase.preferenceDao()).insertPreference(new Preference((String) "next_job_scheduler_id", (long) (i + 1)));
            }
        }
        return i;
    }
}
