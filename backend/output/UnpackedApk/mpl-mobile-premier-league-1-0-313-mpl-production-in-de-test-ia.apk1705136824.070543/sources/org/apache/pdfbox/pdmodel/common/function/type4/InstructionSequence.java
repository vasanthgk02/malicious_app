package org.apache.pdfbox.pdmodel.common.function.type4;

import com.android.tools.r8.GeneratedOutlineSupport;
import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

public class InstructionSequence {
    public List<Object> instructions = new ArrayList();

    public void addBoolean(boolean z) {
        this.instructions.add(Boolean.valueOf(z));
    }

    public void addInteger(int i) {
        this.instructions.add(Integer.valueOf(i));
    }

    public void addName(String str) {
        this.instructions.add(str);
    }

    public void addProc(InstructionSequence instructionSequence) {
        this.instructions.add(instructionSequence);
    }

    public void addReal(float f2) {
        this.instructions.add(Float.valueOf(f2));
    }

    public void execute(ExecutionContext executionContext) {
        Stack<Object> stack = executionContext.getStack();
        for (Object next : this.instructions) {
            if (next instanceof String) {
                String str = (String) next;
                Operator operator = executionContext.getOperators().getOperator(str);
                if (operator != null) {
                    operator.execute(executionContext);
                } else {
                    throw new UnsupportedOperationException(GeneratedOutlineSupport.outline50("Unknown operator or name: ", str));
                }
            } else {
                stack.push(next);
            }
        }
        while (!stack.isEmpty() && (stack.peek() instanceof InstructionSequence)) {
            ((InstructionSequence) stack.pop()).execute(executionContext);
        }
    }
}
