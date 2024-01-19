package kotlin.reflect.jvm.internal.impl.name;

import java.util.List;

public final class FqName {
    public static final FqName ROOT = new FqName((String) "");
    public final FqNameUnsafe fqName;
    public transient FqName parent;

    public static /* synthetic */ void $$$reportNull$$$0(int i) {
        String str;
        int i2;
        Throwable th;
        switch (i) {
            case 4:
            case 5:
            case 6:
            case 7:
            case 9:
            case 10:
            case 11:
                str = "@NotNull method %s.%s must not return null";
                break;
            default:
                str = "Argument for @NotNull parameter '%s' of %s.%s must not be null";
                break;
        }
        switch (i) {
            case 4:
            case 5:
            case 6:
            case 7:
            case 9:
            case 10:
            case 11:
                i2 = 2;
                break;
            default:
                i2 = 3;
                break;
        }
        Object[] objArr = new Object[i2];
        switch (i) {
            case 1:
            case 2:
            case 3:
                objArr[0] = "fqName";
                break;
            case 4:
            case 5:
            case 6:
            case 7:
            case 9:
            case 10:
            case 11:
                objArr[0] = "kotlin/reflect/jvm/internal/impl/name/FqName";
                break;
            case 8:
                objArr[0] = "name";
                break;
            case 12:
                objArr[0] = "segment";
                break;
            case 13:
                objArr[0] = "shortName";
                break;
            default:
                objArr[0] = "names";
                break;
        }
        switch (i) {
            case 4:
                objArr[1] = "asString";
                break;
            case 5:
                objArr[1] = "toUnsafe";
                break;
            case 6:
            case 7:
                objArr[1] = "parent";
                break;
            case 9:
                objArr[1] = "shortName";
                break;
            case 10:
                objArr[1] = "shortNameOrSpecial";
                break;
            case 11:
                objArr[1] = "pathSegments";
                break;
            default:
                objArr[1] = "kotlin/reflect/jvm/internal/impl/name/FqName";
                break;
        }
        switch (i) {
            case 1:
            case 2:
            case 3:
                objArr[2] = "<init>";
                break;
            case 4:
            case 5:
            case 6:
            case 7:
            case 9:
            case 10:
            case 11:
                break;
            case 8:
                objArr[2] = "child";
                break;
            case 12:
                objArr[2] = "startsWith";
                break;
            case 13:
                objArr[2] = "topLevel";
                break;
            default:
                objArr[2] = "fromSegments";
                break;
        }
        String format = String.format(str, objArr);
        switch (i) {
            case 4:
            case 5:
            case 6:
            case 7:
            case 9:
            case 10:
            case 11:
                th = new IllegalStateException(format);
                break;
            default:
                th = new IllegalArgumentException(format);
                break;
        }
        throw th;
    }

    public FqName(String str) {
        if (str != null) {
            this.fqName = new FqNameUnsafe(str, this);
        } else {
            $$$reportNull$$$0(1);
            throw null;
        }
    }

    public static FqName topLevel(Name name) {
        if (name == null) {
            $$$reportNull$$$0(13);
            throw null;
        } else if (name != null) {
            return new FqName(new FqNameUnsafe(name.asString(), ROOT.toUnsafe(), name));
        } else {
            FqNameUnsafe.$$$reportNull$$$0(16);
            throw null;
        }
    }

    public String asString() {
        String asString = this.fqName.asString();
        if (asString != null) {
            return asString;
        }
        $$$reportNull$$$0(4);
        throw null;
    }

    public FqName child(Name name) {
        if (name != null) {
            return new FqName(this.fqName.child(name), this);
        }
        $$$reportNull$$$0(8);
        throw null;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        return (obj instanceof FqName) && this.fqName.equals(((FqName) obj).fqName);
    }

    public int hashCode() {
        return this.fqName.hashCode();
    }

    public boolean isRoot() {
        return this.fqName.isRoot();
    }

    public FqName parent() {
        FqName fqName2 = this.parent;
        if (fqName2 != null) {
            if (fqName2 != null) {
                return fqName2;
            }
            $$$reportNull$$$0(6);
            throw null;
        } else if (!isRoot()) {
            FqNameUnsafe fqNameUnsafe = this.fqName;
            FqNameUnsafe fqNameUnsafe2 = fqNameUnsafe.parent;
            if (fqNameUnsafe2 == null) {
                if (!fqNameUnsafe.isRoot()) {
                    fqNameUnsafe.compute();
                    fqNameUnsafe2 = fqNameUnsafe.parent;
                    if (fqNameUnsafe2 == null) {
                        FqNameUnsafe.$$$reportNull$$$0(8);
                        throw null;
                    }
                } else {
                    throw new IllegalStateException("root");
                }
            }
            FqName fqName3 = new FqName(fqNameUnsafe2);
            this.parent = fqName3;
            if (fqName3 != null) {
                return fqName3;
            }
            $$$reportNull$$$0(7);
            throw null;
        } else {
            throw new IllegalStateException("root");
        }
    }

    public List<Name> pathSegments() {
        List<Name> pathSegments = this.fqName.pathSegments();
        if (pathSegments != null) {
            return pathSegments;
        }
        $$$reportNull$$$0(11);
        throw null;
    }

    public Name shortName() {
        Name shortName = this.fqName.shortName();
        if (shortName != null) {
            return shortName;
        }
        $$$reportNull$$$0(9);
        throw null;
    }

    public Name shortNameOrSpecial() {
        Name name;
        FqNameUnsafe fqNameUnsafe = this.fqName;
        if (fqNameUnsafe.isRoot()) {
            name = FqNameUnsafe.ROOT_NAME;
            if (name == null) {
                FqNameUnsafe.$$$reportNull$$$0(12);
                throw null;
            }
        } else {
            name = fqNameUnsafe.shortName();
            if (name == null) {
                FqNameUnsafe.$$$reportNull$$$0(13);
                throw null;
            }
        }
        return name;
    }

    public boolean startsWith(Name name) {
        if (name != null) {
            FqNameUnsafe fqNameUnsafe = this.fqName;
            if (fqNameUnsafe == null) {
                throw null;
            } else if (name == null) {
                FqNameUnsafe.$$$reportNull$$$0(15);
                throw null;
            } else if (fqNameUnsafe.isRoot()) {
                return false;
            } else {
                int indexOf = fqNameUnsafe.fqName.indexOf(46);
                String str = fqNameUnsafe.fqName;
                String asString = name.asString();
                if (indexOf == -1) {
                    indexOf = fqNameUnsafe.fqName.length();
                }
                return str.regionMatches(0, asString, 0, indexOf);
            }
        } else {
            $$$reportNull$$$0(12);
            throw null;
        }
    }

    public String toString() {
        return this.fqName.toString();
    }

    public FqNameUnsafe toUnsafe() {
        FqNameUnsafe fqNameUnsafe = this.fqName;
        if (fqNameUnsafe != null) {
            return fqNameUnsafe;
        }
        $$$reportNull$$$0(5);
        throw null;
    }

    public FqName(FqNameUnsafe fqNameUnsafe) {
        this.fqName = fqNameUnsafe;
    }

    public FqName(FqNameUnsafe fqNameUnsafe, FqName fqName2) {
        this.fqName = fqNameUnsafe;
        this.parent = fqName2;
    }
}
