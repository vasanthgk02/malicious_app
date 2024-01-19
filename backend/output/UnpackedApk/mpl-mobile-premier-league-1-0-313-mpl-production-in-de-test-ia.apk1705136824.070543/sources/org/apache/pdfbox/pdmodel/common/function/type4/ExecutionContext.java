package org.apache.pdfbox.pdmodel.common.function.type4;

import java.util.Stack;

public class ExecutionContext {
    public Operators operators;
    public Stack<Object> stack = new Stack<>();

    public ExecutionContext(Operators operators2) {
        this.operators = operators2;
    }

    public Operators getOperators() {
        return this.operators;
    }

    public Stack<Object> getStack() {
        return this.stack;
    }

    public int popInt() {
        return ((Integer) this.stack.pop()).intValue();
    }

    public Number popNumber() {
        return (Number) this.stack.pop();
    }

    public float popReal() {
        return ((Number) this.stack.pop()).floatValue();
    }
}
