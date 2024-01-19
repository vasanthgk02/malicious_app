package org.spongycastle.math.field;

public interface PolynomialExtensionField extends FiniteField {
    GF2Polynomial getMinimalPolynomial();
}
