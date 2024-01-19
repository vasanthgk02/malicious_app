package org.apache.pdfbox.pdmodel.common.function.type4;

import java.util.Stack;

public class ConditionalOperators {

    public static class If implements Operator {
        public void execute(ExecutionContext executionContext) {
            Stack<Object> stack = executionContext.getStack();
            InstructionSequence instructionSequence = (InstructionSequence) stack.pop();
            if (((Boolean) stack.pop()).booleanValue()) {
                instructionSequence.execute(executionContext);
            }
        }
    }

    public static class IfElse implements Operator {
        public void execute(ExecutionContext executionContext) {
            Stack<Object> stack = executionContext.getStack();
            InstructionSequence instructionSequence = (InstructionSequence) stack.pop();
            InstructionSequence instructionSequence2 = (InstructionSequence) stack.pop();
            if (((Boolean) stack.pop()).booleanValue()) {
                instructionSequence2.execute(executionContext);
            } else {
                instructionSequence.execute(executionContext);
            }
        }
    }
}
