package org.apache.pdfbox.pdmodel.common.function.type4;

import java.util.Stack;

public class ArithmeticOperators {

    public static class Abs implements Operator {
        public void execute(ExecutionContext executionContext) {
            Number popNumber = executionContext.popNumber();
            if (popNumber instanceof Integer) {
                executionContext.getStack().push(Integer.valueOf(Math.abs(popNumber.intValue())));
            } else {
                executionContext.getStack().push(Float.valueOf(Math.abs(popNumber.floatValue())));
            }
        }
    }

    public static class Add implements Operator {
        public void execute(ExecutionContext executionContext) {
            Number popNumber = executionContext.popNumber();
            Number popNumber2 = executionContext.popNumber();
            if (!(popNumber2 instanceof Integer) || !(popNumber instanceof Integer)) {
                executionContext.getStack().push(Float.valueOf(popNumber.floatValue() + popNumber2.floatValue()));
                return;
            }
            long longValue = popNumber.longValue() + popNumber2.longValue();
            if (longValue < -2147483648L || longValue > 2147483647L) {
                executionContext.getStack().push(Float.valueOf((float) longValue));
            } else {
                executionContext.getStack().push(Integer.valueOf((int) longValue));
            }
        }
    }

    public static class Atan implements Operator {
        public void execute(ExecutionContext executionContext) {
            float degrees = ((float) Math.toDegrees((double) ((float) Math.atan2((double) executionContext.popReal(), (double) executionContext.popReal())))) % 360.0f;
            if (degrees < 0.0f) {
                degrees += 360.0f;
            }
            executionContext.getStack().push(Float.valueOf(degrees));
        }
    }

    public static class Ceiling implements Operator {
        public void execute(ExecutionContext executionContext) {
            Number popNumber = executionContext.popNumber();
            if (popNumber instanceof Integer) {
                executionContext.getStack().push(popNumber);
            } else {
                executionContext.getStack().push(Float.valueOf((float) Math.ceil(popNumber.doubleValue())));
            }
        }
    }

    public static class Cos implements Operator {
        public void execute(ExecutionContext executionContext) {
            executionContext.getStack().push(Float.valueOf((float) Math.cos(Math.toRadians((double) executionContext.popReal()))));
        }
    }

    public static class Cvi implements Operator {
        public void execute(ExecutionContext executionContext) {
            executionContext.getStack().push(Integer.valueOf(executionContext.popNumber().intValue()));
        }
    }

    public static class Cvr implements Operator {
        public void execute(ExecutionContext executionContext) {
            executionContext.getStack().push(Float.valueOf(executionContext.popNumber().floatValue()));
        }
    }

    public static class Div implements Operator {
        public void execute(ExecutionContext executionContext) {
            Number popNumber = executionContext.popNumber();
            executionContext.getStack().push(Float.valueOf(executionContext.popNumber().floatValue() / popNumber.floatValue()));
        }
    }

    public static class Exp implements Operator {
        public void execute(ExecutionContext executionContext) {
            executionContext.getStack().push(Float.valueOf((float) Math.pow(executionContext.popNumber().doubleValue(), executionContext.popNumber().doubleValue())));
        }
    }

    public static class Floor implements Operator {
        public void execute(ExecutionContext executionContext) {
            Number popNumber = executionContext.popNumber();
            if (popNumber instanceof Integer) {
                executionContext.getStack().push(popNumber);
            } else {
                executionContext.getStack().push(Float.valueOf((float) Math.floor(popNumber.doubleValue())));
            }
        }
    }

    public static class IDiv implements Operator {
        public void execute(ExecutionContext executionContext) {
            int popInt = executionContext.popInt();
            executionContext.getStack().push(Integer.valueOf(executionContext.popInt() / popInt));
        }
    }

    public static class Ln implements Operator {
        public void execute(ExecutionContext executionContext) {
            executionContext.getStack().push(Float.valueOf((float) Math.log(executionContext.popNumber().doubleValue())));
        }
    }

    public static class Log implements Operator {
        public void execute(ExecutionContext executionContext) {
            executionContext.getStack().push(Float.valueOf((float) Math.log10(executionContext.popNumber().doubleValue())));
        }
    }

    public static class Mod implements Operator {
        public void execute(ExecutionContext executionContext) {
            int popInt = executionContext.popInt();
            executionContext.getStack().push(Integer.valueOf(executionContext.popInt() % popInt));
        }
    }

    public static class Mul implements Operator {
        public void execute(ExecutionContext executionContext) {
            Number popNumber = executionContext.popNumber();
            Number popNumber2 = executionContext.popNumber();
            if (!(popNumber2 instanceof Integer) || !(popNumber instanceof Integer)) {
                executionContext.getStack().push(Float.valueOf((float) (popNumber.doubleValue() * popNumber2.doubleValue())));
                return;
            }
            long longValue = popNumber.longValue() * popNumber2.longValue();
            if (longValue < -2147483648L || longValue > 2147483647L) {
                executionContext.getStack().push(Float.valueOf((float) longValue));
            } else {
                executionContext.getStack().push(Integer.valueOf((int) longValue));
            }
        }
    }

    public static class Neg implements Operator {
        public void execute(ExecutionContext executionContext) {
            Number popNumber = executionContext.popNumber();
            if (!(popNumber instanceof Integer)) {
                executionContext.getStack().push(Float.valueOf(-popNumber.floatValue()));
            } else if (popNumber.intValue() == Integer.MIN_VALUE) {
                executionContext.getStack().push(Float.valueOf(-popNumber.floatValue()));
            } else {
                executionContext.getStack().push(Integer.valueOf(-popNumber.intValue()));
            }
        }
    }

    public static class Round implements Operator {
        public void execute(ExecutionContext executionContext) {
            Number popNumber = executionContext.popNumber();
            if (popNumber instanceof Integer) {
                executionContext.getStack().push(Integer.valueOf(popNumber.intValue()));
            } else {
                executionContext.getStack().push(Float.valueOf((float) Math.round(popNumber.doubleValue())));
            }
        }
    }

    public static class Sin implements Operator {
        public void execute(ExecutionContext executionContext) {
            executionContext.getStack().push(Float.valueOf((float) Math.sin(Math.toRadians((double) executionContext.popReal()))));
        }
    }

    public static class Sqrt implements Operator {
        public void execute(ExecutionContext executionContext) {
            float popReal = executionContext.popReal();
            if (popReal >= 0.0f) {
                executionContext.getStack().push(Float.valueOf((float) Math.sqrt((double) popReal)));
                return;
            }
            throw new IllegalArgumentException("argument must be nonnegative");
        }
    }

    public static class Sub implements Operator {
        public void execute(ExecutionContext executionContext) {
            Stack<Object> stack = executionContext.getStack();
            Number popNumber = executionContext.popNumber();
            Number popNumber2 = executionContext.popNumber();
            if (!(popNumber2 instanceof Integer) || !(popNumber instanceof Integer)) {
                stack.push(Float.valueOf(popNumber2.floatValue() - popNumber.floatValue()));
                return;
            }
            long longValue = popNumber2.longValue() - popNumber.longValue();
            if (longValue < -2147483648L || longValue > 2147483647L) {
                stack.push(Float.valueOf((float) longValue));
            } else {
                stack.push(Integer.valueOf((int) longValue));
            }
        }
    }

    public static class Truncate implements Operator {
        public void execute(ExecutionContext executionContext) {
            Number popNumber = executionContext.popNumber();
            if (popNumber instanceof Integer) {
                executionContext.getStack().push(Integer.valueOf(popNumber.intValue()));
            } else {
                executionContext.getStack().push(Float.valueOf((float) ((int) popNumber.floatValue())));
            }
        }
    }
}
