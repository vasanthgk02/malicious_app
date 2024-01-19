package org.spongycastle.openpgp.operator.jcajce;

import org.spongycastle.jcajce.util.DefaultJcaJceHelper;

public class JcaPGPContentVerifierBuilderProvider {
    public OperatorHelper helper = new OperatorHelper(new DefaultJcaJceHelper());
    public JcaPGPKeyConverter keyConverter = new JcaPGPKeyConverter();

    public class JcaPGPContentVerifierBuilder {
        public int hashAlgorithm;
        public int keyAlgorithm;

        public JcaPGPContentVerifierBuilder(int i, int i2) {
            this.keyAlgorithm = i;
            this.hashAlgorithm = i2;
        }
    }
}
