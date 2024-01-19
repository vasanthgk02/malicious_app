package org.apache.pdfbox.pdmodel.interactive.form;

import java.io.IOException;
import org.apache.pdfbox.pdmodel.common.PDTextStream;

public final class AppearanceGenerator {
    public static void generateFieldAppearances(PDField pDField) throws IOException {
        if (pDField instanceof PDVariableText) {
            AppearanceGeneratorHelper appearanceGeneratorHelper = new AppearanceGeneratorHelper(pDField.getAcroForm(), (PDVariableText) pDField);
            Object value = pDField.getValue();
            if (value instanceof String) {
                appearanceGeneratorHelper.setAppearanceValue((String) value);
            } else if (value instanceof PDTextStream) {
                appearanceGeneratorHelper.setAppearanceValue(((PDTextStream) value).getAsString());
            } else if (value != null) {
                value.getClass().getName();
            }
        }
    }
}
