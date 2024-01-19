package androidx.work.impl.model;

public class Preference {
    public String mKey;
    public Long mValue;

    public Preference(String str, long j) {
        this.mKey = str;
        this.mValue = Long.valueOf(j);
    }

    public boolean equals(Object obj) {
        boolean z = true;
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof Preference)) {
            return false;
        }
        Preference preference = (Preference) obj;
        if (!this.mKey.equals(preference.mKey)) {
            return false;
        }
        Long l = this.mValue;
        Long l2 = preference.mValue;
        if (l != null) {
            z = l.equals(l2);
        } else if (l2 != null) {
            z = false;
        }
        return z;
    }

    public int hashCode() {
        int hashCode = this.mKey.hashCode() * 31;
        Long l = this.mValue;
        return hashCode + (l != null ? l.hashCode() : 0);
    }

    public Preference(String str, boolean z) {
        long j = z ? 1 : 0;
        this.mKey = str;
        this.mValue = Long.valueOf(j);
    }
}
