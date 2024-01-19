package org.apache.pdfbox.pdmodel.common.function;

import com.android.tools.r8.GeneratedOutlineSupport;
import java.io.IOException;
import org.apache.pdfbox.cos.COSBase;
import org.apache.pdfbox.pdmodel.common.PDRange;
import org.apache.pdfbox.pdmodel.common.function.type4.ExecutionContext;
import org.apache.pdfbox.pdmodel.common.function.type4.InstructionSequence;
import org.apache.pdfbox.pdmodel.common.function.type4.InstructionSequenceBuilder;
import org.apache.pdfbox.pdmodel.common.function.type4.Operators;

public class PDFunctionType4 extends PDFunction {
    public static final Operators OPERATORS = new Operators();
    public final InstructionSequence instructions = InstructionSequenceBuilder.parse(getPDStream().getInputStreamAsString());

    public PDFunctionType4(COSBase cOSBase) throws IOException {
        super(cOSBase);
    }

    public float[] eval(float[] fArr) throws IOException {
        ExecutionContext executionContext = new ExecutionContext(OPERATORS);
        for (int i = 0; i < fArr.length; i++) {
            PDRange domainForInput = getDomainForInput(i);
            executionContext.getStack().push(Float.valueOf(clipToRange(fArr[i], domainForInput.getMin(), domainForInput.getMax())));
        }
        this.instructions.execute(executionContext);
        int numberOfOutputParameters = getNumberOfOutputParameters();
        int size = executionContext.getStack().size();
        if (size >= numberOfOutputParameters) {
            float[] fArr2 = new float[numberOfOutputParameters];
            while (true) {
                numberOfOutputParameters--;
                if (numberOfOutputParameters < 0) {
                    return fArr2;
                }
                PDRange rangeForOutput = getRangeForOutput(numberOfOutputParameters);
                fArr2[numberOfOutputParameters] = executionContext.popReal();
                fArr2[numberOfOutputParameters] = clipToRange(fArr2[numberOfOutputParameters], rangeForOutput.getMin(), rangeForOutput.getMax());
            }
        } else {
            throw new IllegalStateException(GeneratedOutlineSupport.outline44("The type 4 function returned ", size, " values but the Range entry indicates that ", numberOfOutputParameters, " values be returned."));
        }
    }

    public int getFunctionType() {
        return 4;
    }
}
