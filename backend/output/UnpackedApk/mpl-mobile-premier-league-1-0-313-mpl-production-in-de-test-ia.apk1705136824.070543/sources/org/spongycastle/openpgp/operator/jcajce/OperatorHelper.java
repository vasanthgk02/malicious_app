package org.spongycastle.openpgp.operator.jcajce;

import org.spongycastle.jcajce.util.JcaJceHelper;

public class OperatorHelper {
    public JcaJceHelper helper;

    public OperatorHelper(JcaJceHelper jcaJceHelper) {
        this.helper = jcaJceHelper;
    }
}
