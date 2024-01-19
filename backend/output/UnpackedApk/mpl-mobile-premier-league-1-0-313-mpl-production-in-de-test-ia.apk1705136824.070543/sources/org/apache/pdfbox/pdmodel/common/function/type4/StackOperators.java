package org.apache.pdfbox.pdmodel.common.function.type4;

import com.android.tools.r8.GeneratedOutlineSupport;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Stack;

public class StackOperators {

    public static class Copy implements Operator {
        public void execute(ExecutionContext executionContext) {
            Stack<Object> stack = executionContext.getStack();
            int intValue = ((Number) stack.pop()).intValue();
            if (intValue > 0) {
                int size = stack.size();
                stack.addAll(new ArrayList(stack.subList(size - intValue, size)));
            }
        }
    }

    public static class Dup implements Operator {
        public void execute(ExecutionContext executionContext) {
            Stack<Object> stack = executionContext.getStack();
            stack.push(stack.peek());
        }
    }

    public static class Exch implements Operator {
        public void execute(ExecutionContext executionContext) {
            Stack<Object> stack = executionContext.getStack();
            Object pop = stack.pop();
            Object pop2 = stack.pop();
            stack.push(pop);
            stack.push(pop2);
        }
    }

    public static class Index implements Operator {
        public void execute(ExecutionContext executionContext) {
            Stack<Object> stack = executionContext.getStack();
            int intValue = ((Number) stack.pop()).intValue();
            if (intValue >= 0) {
                stack.push(stack.get((stack.size() - intValue) - 1));
                return;
            }
            throw new IllegalArgumentException(GeneratedOutlineSupport.outline41("rangecheck: ", intValue));
        }
    }

    public static class Pop implements Operator {
        public void execute(ExecutionContext executionContext) {
            executionContext.getStack().pop();
        }
    }

    public static class Roll implements Operator {
        public void execute(ExecutionContext executionContext) {
            Stack<Object> stack = executionContext.getStack();
            int intValue = ((Number) stack.pop()).intValue();
            int intValue2 = ((Number) stack.pop()).intValue();
            if (intValue != 0) {
                if (intValue2 >= 0) {
                    LinkedList linkedList = new LinkedList();
                    LinkedList linkedList2 = new LinkedList();
                    int i = 0;
                    if (intValue < 0) {
                        int i2 = intValue2 + intValue;
                        while (i < i2) {
                            linkedList2.addFirst(stack.pop());
                            i++;
                        }
                        while (intValue < 0) {
                            linkedList.addFirst(stack.pop());
                            intValue++;
                        }
                        stack.addAll(linkedList2);
                        stack.addAll(linkedList);
                    } else {
                        int i3 = intValue2 - intValue;
                        while (intValue > 0) {
                            linkedList.addFirst(stack.pop());
                            intValue--;
                        }
                        while (i < i3) {
                            linkedList2.addFirst(stack.pop());
                            i++;
                        }
                        stack.addAll(linkedList);
                        stack.addAll(linkedList2);
                    }
                    return;
                }
                throw new IllegalArgumentException(GeneratedOutlineSupport.outline41("rangecheck: ", intValue2));
            }
        }
    }
}
