package androidx.navigation;

import com.android.tools.r8.GeneratedOutlineSupport;

public final class NavArgument {
    public final Object mDefaultValue;
    public final boolean mDefaultValuePresent;
    public final boolean mIsNullable;
    public final NavType mType;

    public NavArgument(NavType<?> navType, boolean z, Object obj, boolean z2) {
        if (!navType.mNullableAllowed && z) {
            throw new IllegalArgumentException(navType.getName() + " does not allow nullable values");
        } else if (z || !z2 || obj != null) {
            this.mType = navType;
            this.mIsNullable = z;
            this.mDefaultValue = obj;
            this.mDefaultValuePresent = z2;
        } else {
            StringBuilder outline73 = GeneratedOutlineSupport.outline73("Argument with type ");
            outline73.append(navType.getName());
            outline73.append(" has null value but is not nullable.");
            throw new IllegalArgumentException(outline73.toString());
        }
    }

    public boolean equals(Object obj) {
        boolean z = true;
        if (this == obj) {
            return true;
        }
        if (obj == null || NavArgument.class != obj.getClass()) {
            return false;
        }
        NavArgument navArgument = (NavArgument) obj;
        if (this.mIsNullable != navArgument.mIsNullable || this.mDefaultValuePresent != navArgument.mDefaultValuePresent || !this.mType.equals(navArgument.mType)) {
            return false;
        }
        Object obj2 = this.mDefaultValue;
        if (obj2 != null) {
            z = obj2.equals(navArgument.mDefaultValue);
        } else if (navArgument.mDefaultValue != null) {
            z = false;
        }
        return z;
    }

    public int hashCode() {
        int hashCode = ((((this.mType.hashCode() * 31) + (this.mIsNullable ? 1 : 0)) * 31) + (this.mDefaultValuePresent ? 1 : 0)) * 31;
        Object obj = this.mDefaultValue;
        return hashCode + (obj != null ? obj.hashCode() : 0);
    }
}
