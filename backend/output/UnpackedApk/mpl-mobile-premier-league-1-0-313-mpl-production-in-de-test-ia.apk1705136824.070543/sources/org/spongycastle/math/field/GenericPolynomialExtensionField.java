package org.spongycastle.math.field;

import java.math.BigInteger;

public class GenericPolynomialExtensionField implements PolynomialExtensionField {
    public final GF2Polynomial minimalPolynomial;
    public final FiniteField subfield;

    public GenericPolynomialExtensionField(FiniteField finiteField, GF2Polynomial gF2Polynomial) {
        this.subfield = finiteField;
        this.minimalPolynomial = gF2Polynomial;
    }

    public boolean equals(Object obj) {
        boolean z = true;
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof GenericPolynomialExtensionField)) {
            return false;
        }
        GenericPolynomialExtensionField genericPolynomialExtensionField = (GenericPolynomialExtensionField) obj;
        if (!this.subfield.equals(genericPolynomialExtensionField.subfield) || !this.minimalPolynomial.equals(genericPolynomialExtensionField.minimalPolynomial)) {
            z = false;
        }
        return z;
    }

    public BigInteger getCharacteristic() {
        return this.subfield.getCharacteristic();
    }

    public int getDimension() {
        int dimension = this.subfield.getDimension();
        int[] iArr = this.minimalPolynomial.exponents;
        return dimension * iArr[iArr.length - 1];
    }

    public GF2Polynomial getMinimalPolynomial() {
        return this.minimalPolynomial;
    }

    public int hashCode() {
        return this.subfield.hashCode() ^ Integer.rotateLeft(this.minimalPolynomial.hashCode(), 16);
    }
}
