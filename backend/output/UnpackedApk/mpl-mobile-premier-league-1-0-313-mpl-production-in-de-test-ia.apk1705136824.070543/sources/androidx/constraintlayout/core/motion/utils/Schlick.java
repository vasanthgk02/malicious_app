package androidx.constraintlayout.core.motion.utils;

public class Schlick extends Easing {
    public double mS;
    public double mT;

    public Schlick(String str) {
        this.str = str;
        int indexOf = str.indexOf(40);
        int indexOf2 = str.indexOf(44, indexOf);
        this.mS = Double.parseDouble(str.substring(indexOf + 1, indexOf2).trim());
        int i = indexOf2 + 1;
        this.mT = Double.parseDouble(str.substring(i, str.indexOf(44, i)).trim());
    }

    public double get(double d2) {
        double d3 = this.mT;
        if (d2 < d3) {
            return (d3 * d2) / (((d3 - d2) * this.mS) + d2);
        }
        return ((d2 - 1.0d) * (1.0d - d3)) / ((1.0d - d2) - ((d3 - d2) * this.mS));
    }

    public double getDiff(double d2) {
        double d3 = this.mT;
        if (d2 < d3) {
            double d4 = this.mS;
            double d5 = d4 * d3 * d3;
            double d6 = ((d3 - d2) * d4) + d2;
            return d5 / (d6 * d6);
        }
        double d7 = this.mS;
        double d8 = d3 - 1.0d;
        double d9 = (((d3 - d2) * (-d7)) - d2) + 1.0d;
        return ((d8 * d7) * d8) / (d9 * d9);
    }
}
