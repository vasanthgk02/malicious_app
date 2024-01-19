package org.apache.pdfbox.pdmodel.common.function.type4;

import java.util.Stack;

public class RelationalOperators {

    public static abstract class AbstractNumberComparisonOperator implements Operator {
        public AbstractNumberComparisonOperator() {
        }

        public abstract boolean compare(Number number, Number number2);

        public void execute(ExecutionContext executionContext) {
            Stack<Object> stack = executionContext.getStack();
            stack.push(Boolean.valueOf(compare((Number) stack.pop(), (Number) stack.pop())));
        }
    }

    public static class Eq implements Operator {
        public void execute(ExecutionContext executionContext) {
            Stack<Object> stack = executionContext.getStack();
            stack.push(Boolean.valueOf(isEqual(stack.pop(), stack.pop())));
        }

        public boolean isEqual(Object obj, Object obj2) {
            if (!(obj instanceof Number) || !(obj2 instanceof Number)) {
                return obj.equals(obj2);
            }
            return ((Number) obj).floatValue() == ((Number) obj2).floatValue();
        }
    }

    public static class Ge extends AbstractNumberComparisonOperator {
        public Ge() {
            super();
        }

        public boolean compare(Number number, Number number2) {
            return number.floatValue() >= number2.floatValue();
        }
    }

    public static class Gt extends AbstractNumberComparisonOperator {
        public Gt() {
            super();
        }

        public boolean compare(Number number, Number number2) {
            return number.floatValue() > number2.floatValue();
        }
    }

    public static class Le extends AbstractNumberComparisonOperator {
        public Le() {
            super();
        }

        public boolean compare(Number number, Number number2) {
            return number.floatValue() <= number2.floatValue();
        }
    }

    public static class Lt extends AbstractNumberComparisonOperator {
        public Lt() {
            super();
        }

        public boolean compare(Number number, Number number2) {
            return number.floatValue() < number2.floatValue();
        }
    }

    public static class Ne extends Eq {
        public boolean isEqual(Object obj, Object obj2) {
            return !super.isEqual(obj, obj2);
        }
    }
}
