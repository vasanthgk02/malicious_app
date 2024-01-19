package org.apache.pdfbox.pdmodel.common.function.type4;

import java.util.Stack;
import java.util.regex.Pattern;
import org.apache.pdfbox.pdmodel.common.function.type4.Parser.AbstractSyntaxHandler;
import org.eclipse.paho.client.mqttv3.MqttTopic;

public final class InstructionSequenceBuilder extends AbstractSyntaxHandler {
    public static final Pattern INTEGER_PATTERN = Pattern.compile("[\\+\\-]?\\d+");
    public static final Pattern REAL_PATTERN = Pattern.compile("[\\-]?\\d*\\.\\d*([Ee]\\-?\\d+)?");
    public final InstructionSequence mainSequence = new InstructionSequence();
    public final Stack<InstructionSequence> seqStack;

    public InstructionSequenceBuilder() {
        Stack<InstructionSequence> stack = new Stack<>();
        this.seqStack = stack;
        stack.push(this.mainSequence);
    }

    private InstructionSequence getCurrentSequence() {
        return this.seqStack.peek();
    }

    public static InstructionSequence parse(CharSequence charSequence) {
        InstructionSequenceBuilder instructionSequenceBuilder = new InstructionSequenceBuilder();
        Parser.parse(charSequence, instructionSequenceBuilder);
        return instructionSequenceBuilder.getInstructionSequence();
    }

    public static int parseInt(String str) {
        if (str.startsWith(MqttTopic.SINGLE_LEVEL_WILDCARD)) {
            str = str.substring(1);
        }
        return Integer.parseInt(str);
    }

    public static float parseReal(String str) {
        return Float.parseFloat(str);
    }

    public InstructionSequence getInstructionSequence() {
        return this.mainSequence;
    }

    public void token(CharSequence charSequence) {
        token(charSequence.toString());
    }

    private void token(String str) {
        if ("{".equals(str)) {
            InstructionSequence instructionSequence = new InstructionSequence();
            getCurrentSequence().addProc(instructionSequence);
            this.seqStack.push(instructionSequence);
        } else if ("}".equals(str)) {
            this.seqStack.pop();
        } else if (INTEGER_PATTERN.matcher(str).matches()) {
            getCurrentSequence().addInteger(parseInt(str));
        } else if (REAL_PATTERN.matcher(str).matches()) {
            getCurrentSequence().addReal(parseReal(str));
        } else {
            getCurrentSequence().addName(str);
        }
    }
}
