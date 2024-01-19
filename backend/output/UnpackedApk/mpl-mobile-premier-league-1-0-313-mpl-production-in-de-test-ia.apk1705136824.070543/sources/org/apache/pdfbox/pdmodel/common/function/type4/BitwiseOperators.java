package org.apache.pdfbox.pdmodel.common.function.type4;

import java.util.Stack;

public class BitwiseOperators {

    public static abstract class AbstractLogicalOperator implements Operator {
        public AbstractLogicalOperator() {
        }

        public abstract boolean applyForBoolean(boolean z, boolean z2);

        public abstract int applyforInteger(int i, int i2);

        public void execute(ExecutionContext executionContext) {
            Stack<Object> stack = executionContext.getStack();
            Object pop = stack.pop();
            Object pop2 = stack.pop();
            if ((pop2 instanceof Boolean) && (pop instanceof Boolean)) {
                stack.push(Boolean.valueOf(applyForBoolean(((Boolean) pop2).booleanValue(), ((Boolean) pop).booleanValue())));
            } else if (!(pop2 instanceof Integer) || !(pop instanceof Integer)) {
                throw new ClassCastException("Operands must be bool/bool or int/int");
            } else {
                stack.push(Integer.valueOf(applyforInteger(((Integer) pop2).intValue(), ((Integer) pop).intValue())));
            }
        }
    }

    public static class And extends AbstractLogicalOperator {
        public And() {
            super();
        }

        public boolean applyForBoolean(boolean z, boolean z2) {
            return z & z2;
        }

        public int applyforInteger(int i, int i2) {
            return i & i2;
        }
    }

    public static class Bitshift implements Operator {
        public void execute(ExecutionContext executionContext) {
            Stack<Object> stack = executionContext.getStack();
            int intValue = ((Integer) stack.pop()).intValue();
            int intValue2 = ((Integer) stack.pop()).intValue();
            if (intValue < 0) {
                stack.push(Integer.valueOf(intValue2 >> Math.abs(intValue)));
            } else {
                stack.push(Integer.valueOf(intValue2 << intValue));
            }
        }
    }

    public static class False implements Operator {
        public void execute(ExecutionContext executionContext) {
            executionContext.getStack().push(Boolean.FALSE);
        }
    }

    public static class Not implements Operator {
        public void execute(ExecutionContext executionContext) {
            Stack<Object> stack = executionContext.getStack();
            Object pop = stack.pop();
            if (pop instanceof Boolean) {
                stack.push(Boolean.valueOf(!((Boolean) pop).booleanValue()));
            } else if (pop instanceof Integer) {
                stack.push(Integer.valueOf(-((Integer) pop).intValue()));
            } else {
                throw new ClassCastException("Operand must be bool or int");
            }
        }
    }

    public static class Or extends AbstractLogicalOperator {
        public Or() {
            super();
        }

        public boolean applyForBoolean(boolean z, boolean z2) {
            return z | z2;
        }

        public int applyforInteger(int i, int i2) {
            return i | i2;
        }
    }

    public static class True implements Operator {
        public void execute(ExecutionContext executionContext) {
            executionContext.getStack().push(Boolean.TRUE);
        }
    }

    public static class Xor extends AbstractLogicalOperator {
        public Xor() {
            super();
        }

        public boolean applyForBoolean(boolean z, boolean z2) {
            return z ^ z2;
        }

        public int applyforInteger(int i, int i2) {
            return i ^ i2;
        }
    }
}
