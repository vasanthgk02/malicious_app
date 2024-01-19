package net.sf.json.util;

public abstract class NewBeanInstanceStrategy {
    public static final NewBeanInstanceStrategy DEFAULT = new DefaultNewBeanInstanceStrategy(null);

    public static final class DefaultNewBeanInstanceStrategy extends NewBeanInstanceStrategy {
        public static final Object[] EMPTY_ARGS = new Object[0];

        public DefaultNewBeanInstanceStrategy(AnonymousClass1 r1) {
        }
    }
}
