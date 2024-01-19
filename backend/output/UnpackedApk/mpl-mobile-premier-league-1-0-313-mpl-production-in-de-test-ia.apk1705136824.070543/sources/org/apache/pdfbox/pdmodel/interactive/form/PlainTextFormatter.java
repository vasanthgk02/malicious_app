package org.apache.pdfbox.pdmodel.interactive.form;

import java.io.IOException;
import java.util.List;
import org.apache.pdfbox.pdmodel.font.PDFont;
import org.apache.pdfbox.pdmodel.interactive.form.PlainText.Line;
import org.apache.pdfbox.pdmodel.interactive.form.PlainText.Paragraph;
import org.apache.pdfbox.pdmodel.interactive.form.PlainText.TextAttribute;
import org.apache.pdfbox.pdmodel.interactive.form.PlainText.Word;

public class PlainTextFormatter {
    public AppearanceStyle appearanceStyle;
    public final AppearancePrimitivesComposer composer;
    public float horizontalOffset;
    public final TextAlign textAlignment;
    public final PlainText textContent;
    public float verticalOffset;
    public final float width;
    public final boolean wrapLines;

    /* renamed from: org.apache.pdfbox.pdmodel.interactive.form.PlainTextFormatter$1  reason: invalid class name */
    public static /* synthetic */ class AnonymousClass1 {
        public static final /* synthetic */ int[] $SwitchMap$org$apache$pdfbox$pdmodel$interactive$form$PlainTextFormatter$TextAlign;

        /* JADX WARNING: Can't wrap try/catch for region: R(8:0|1|2|3|4|5|6|8) */
        /* JADX WARNING: Code restructure failed: missing block: B:9:?, code lost:
            return;
         */
        /* JADX WARNING: Failed to process nested try/catch */
        /* JADX WARNING: Missing exception handler attribute for start block: B:3:0x000e */
        /* JADX WARNING: Missing exception handler attribute for start block: B:5:0x0015 */
        static {
            /*
                org.apache.pdfbox.pdmodel.interactive.form.PlainTextFormatter$TextAlign[] r0 = org.apache.pdfbox.pdmodel.interactive.form.PlainTextFormatter.TextAlign.values()
                int r0 = r0.length
                int[] r0 = new int[r0]
                $SwitchMap$org$apache$pdfbox$pdmodel$interactive$form$PlainTextFormatter$TextAlign = r0
                org.apache.pdfbox.pdmodel.interactive.form.PlainTextFormatter$TextAlign r1 = org.apache.pdfbox.pdmodel.interactive.form.PlainTextFormatter.TextAlign.CENTER     // Catch:{ NoSuchFieldError -> 0x000e }
                r1 = 1
                r0[r1] = r1     // Catch:{ NoSuchFieldError -> 0x000e }
            L_0x000e:
                int[] r0 = $SwitchMap$org$apache$pdfbox$pdmodel$interactive$form$PlainTextFormatter$TextAlign     // Catch:{ NoSuchFieldError -> 0x0015 }
                org.apache.pdfbox.pdmodel.interactive.form.PlainTextFormatter$TextAlign r1 = org.apache.pdfbox.pdmodel.interactive.form.PlainTextFormatter.TextAlign.RIGHT     // Catch:{ NoSuchFieldError -> 0x0015 }
                r1 = 2
                r0[r1] = r1     // Catch:{ NoSuchFieldError -> 0x0015 }
            L_0x0015:
                int[] r0 = $SwitchMap$org$apache$pdfbox$pdmodel$interactive$form$PlainTextFormatter$TextAlign     // Catch:{ NoSuchFieldError -> 0x001c }
                org.apache.pdfbox.pdmodel.interactive.form.PlainTextFormatter$TextAlign r1 = org.apache.pdfbox.pdmodel.interactive.form.PlainTextFormatter.TextAlign.JUSTIFY     // Catch:{ NoSuchFieldError -> 0x001c }
                r1 = 3
                r0[r1] = r1     // Catch:{ NoSuchFieldError -> 0x001c }
            L_0x001c:
                return
            */
            throw new UnsupportedOperationException("Method not decompiled: org.apache.pdfbox.pdmodel.interactive.form.PlainTextFormatter.AnonymousClass1.<clinit>():void");
        }
    }

    public static class Builder {
        public AppearanceStyle appearanceStyle;
        public AppearancePrimitivesComposer composer;
        public float horizontalOffset = 0.0f;
        public TextAlign textAlignment = TextAlign.LEFT;
        public PlainText textContent;
        public float verticalOffset = 0.0f;
        public float width = 0.0f;
        public boolean wrapLines = false;

        public Builder(AppearancePrimitivesComposer appearancePrimitivesComposer) {
            this.composer = appearancePrimitivesComposer;
        }

        public PlainTextFormatter build() {
            return new PlainTextFormatter(this, null);
        }

        public Builder initialOffset(float f2, float f3) {
            this.horizontalOffset = f2;
            this.verticalOffset = f3;
            return this;
        }

        public Builder style(AppearanceStyle appearanceStyle2) {
            this.appearanceStyle = appearanceStyle2;
            return this;
        }

        public Builder text(PlainText plainText) {
            this.textContent = plainText;
            return this;
        }

        public Builder textAlign(int i) {
            this.textAlignment = TextAlign.valueOf(i);
            return this;
        }

        public Builder width(float f2) {
            this.width = f2;
            return this;
        }

        public Builder wrapLines(boolean z) {
            this.wrapLines = z;
            return this;
        }

        public Builder textAlign(TextAlign textAlign) {
            this.textAlignment = textAlign;
            return this;
        }
    }

    public enum TextAlign {
        LEFT(0),
        CENTER(1),
        RIGHT(2),
        JUSTIFY(4);
        
        public final int alignment;

        /* access modifiers changed from: public */
        TextAlign(int i) {
            this.alignment = i;
        }

        public int getTextAlign() {
            return this.alignment;
        }

        public static TextAlign valueOf(int i) {
            for (TextAlign textAlign : values()) {
                if (textAlign.getTextAlign() == i) {
                    return textAlign;
                }
            }
            return LEFT;
        }
    }

    public /* synthetic */ PlainTextFormatter(Builder builder, AnonymousClass1 r2) {
        this(builder);
    }

    private void processLines(List<Line> list) throws IOException {
        PDFont font = this.appearanceStyle.getFont();
        float f2 = 0.0f;
        float f3 = 0.0f;
        float f4 = 0.0f;
        for (Line next : list) {
            int ordinal = this.textAlignment.ordinal();
            if (ordinal == 1) {
                f3 = (this.width - next.getWidth()) / 2.0f;
            } else if (ordinal == 2) {
                f3 = this.width - next.getWidth();
            } else if (ordinal != 3) {
                f3 = 0.0f;
            } else if (list.indexOf(next) != list.size() - 1) {
                f4 = next.getInterWordSpacing(this.width);
            }
            float f5 = (-f2) + f3 + this.horizontalOffset;
            if (list.indexOf(next) == 0) {
                this.composer.newLineAtOffset(f5, this.verticalOffset);
                this.verticalOffset = 0.0f;
                this.horizontalOffset = 0.0f;
            } else {
                this.verticalOffset -= this.appearanceStyle.getLeading();
                this.composer.newLineAtOffset(f5, -this.appearanceStyle.getLeading());
            }
            List<Word> words = next.getWords();
            float f6 = f3;
            for (Word next2 : words) {
                this.composer.showText(next2.getText(), font);
                float floatValue = ((Float) next2.getAttributes().getIterator().getAttribute(TextAttribute.WIDTH)).floatValue();
                if (words.indexOf(next2) != words.size() - 1) {
                    this.composer.newLineAtOffset(floatValue + f4, 0.0f);
                    f6 = f6 + floatValue + f4;
                }
            }
            f2 = f6;
        }
        this.horizontalOffset -= f2;
    }

    public void format() throws IOException {
        PlainText plainText = this.textContent;
        if (plainText != null && !plainText.getParagraphs().isEmpty()) {
            for (Paragraph next : this.textContent.getParagraphs()) {
                if (this.wrapLines) {
                    processLines(next.getLines(this.appearanceStyle.getFont(), this.appearanceStyle.getFontSize(), this.width));
                } else {
                    this.composer.showText(next.getText(), this.appearanceStyle.getFont());
                }
            }
        }
    }

    public PlainTextFormatter(Builder builder) {
        this.appearanceStyle = builder.appearanceStyle;
        this.wrapLines = builder.wrapLines;
        this.width = builder.width;
        this.composer = builder.composer;
        this.textContent = builder.textContent;
        this.textAlignment = builder.textAlignment;
        this.horizontalOffset = builder.horizontalOffset;
        this.verticalOffset = builder.verticalOffset;
    }
}
