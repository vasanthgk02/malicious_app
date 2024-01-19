package androidx.navigation;

public final class NavOptions {
    public int mEnterAnim;
    public int mExitAnim;
    public int mPopEnterAnim;
    public int mPopExitAnim;
    public int mPopUpTo;
    public boolean mPopUpToInclusive;
    public boolean mSingleTop;

    public NavOptions(boolean z, int i, boolean z2, int i2, int i3, int i4, int i5) {
        this.mSingleTop = z;
        this.mPopUpTo = i;
        this.mPopUpToInclusive = z2;
        this.mEnterAnim = i2;
        this.mExitAnim = i3;
        this.mPopEnterAnim = i4;
        this.mPopExitAnim = i5;
    }

    public boolean equals(Object obj) {
        boolean z = true;
        if (this == obj) {
            return true;
        }
        if (obj == null || NavOptions.class != obj.getClass()) {
            return false;
        }
        NavOptions navOptions = (NavOptions) obj;
        if (!(this.mSingleTop == navOptions.mSingleTop && this.mPopUpTo == navOptions.mPopUpTo && this.mPopUpToInclusive == navOptions.mPopUpToInclusive && this.mEnterAnim == navOptions.mEnterAnim && this.mExitAnim == navOptions.mExitAnim && this.mPopEnterAnim == navOptions.mPopEnterAnim && this.mPopExitAnim == navOptions.mPopExitAnim)) {
            z = false;
        }
        return z;
    }

    public int hashCode() {
        return ((((((((((((this.mSingleTop ? 1 : 0) * true) + this.mPopUpTo) * 31) + (this.mPopUpToInclusive ? 1 : 0)) * 31) + this.mEnterAnim) * 31) + this.mExitAnim) * 31) + this.mPopEnterAnim) * 31) + this.mPopExitAnim;
    }
}
