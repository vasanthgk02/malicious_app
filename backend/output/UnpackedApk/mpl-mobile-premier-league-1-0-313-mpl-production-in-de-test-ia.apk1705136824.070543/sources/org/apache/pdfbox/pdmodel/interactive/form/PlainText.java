package org.apache.pdfbox.pdmodel.interactive.form;

import java.io.IOException;
import java.text.AttributedCharacterIterator.Attribute;
import java.text.AttributedString;
import java.text.BreakIterator;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import org.apache.pdfbox.pdmodel.font.PDFont;

public class PlainText {
    public static final float FONTSCALE = 1000.0f;
    public final List<Paragraph> paragraphs = new ArrayList();

    public static class Line {
        public float lineWidth;
        public List<Word> words = new ArrayList();

        public void addWord(Word word) {
            this.words.add(word);
        }

        public float calculateWidth(PDFont pDFont, float f2) throws IOException {
            float f3 = f2 / 1000.0f;
            float f4 = 0.0f;
            for (Word next : this.words) {
                float floatValue = ((Float) next.getAttributes().getIterator().getAttribute(TextAttribute.WIDTH)).floatValue() + f4;
                String text = next.getText();
                if (this.words.indexOf(next) == this.words.size() - 1 && Character.isWhitespace(text.charAt(text.length() - 1))) {
                    floatValue -= pDFont.getStringWidth(text.substring(text.length() - 1)) * f3;
                }
                f4 = floatValue;
            }
            return f4;
        }

        public float getInterWordSpacing(float f2) {
            return (f2 - this.lineWidth) / ((float) (this.words.size() - 1));
        }

        public float getWidth() {
            return this.lineWidth;
        }

        public List<Word> getWords() {
            return this.words;
        }

        public void setWidth(float f2) {
            this.lineWidth = f2;
        }
    }

    public static class Paragraph {
        public String textContent;

        public Paragraph(String str) {
            this.textContent = str;
        }

        public List<Line> getLines(PDFont pDFont, float f2, float f3) throws IOException {
            BreakIterator lineInstance = BreakIterator.getLineInstance();
            lineInstance.setText(this.textContent);
            float f4 = f2 / 1000.0f;
            int first = lineInstance.first();
            int next = lineInstance.next();
            ArrayList arrayList = new ArrayList();
            Line line = new Line();
            float f5 = 0.0f;
            while (true) {
                int i = next;
                int i2 = first;
                first = i;
                if (first != -1) {
                    String substring = this.textContent.substring(i2, first);
                    float stringWidth = pDFont.getStringWidth(substring) * f4;
                    f5 += stringWidth;
                    if (f5 >= f3 && Character.isWhitespace(substring.charAt(substring.length() - 1))) {
                        f5 -= pDFont.getStringWidth(substring.substring(substring.length() - 1)) * f4;
                    }
                    if (f5 >= f3) {
                        line.setWidth(line.calculateWidth(pDFont, f2));
                        arrayList.add(line);
                        line = new Line();
                        f5 = pDFont.getStringWidth(substring) * f4;
                    }
                    AttributedString attributedString = new AttributedString(substring);
                    attributedString.addAttribute(TextAttribute.WIDTH, Float.valueOf(stringWidth));
                    Word word = new Word(substring);
                    word.setAttributes(attributedString);
                    line.addWord(word);
                    next = lineInstance.next();
                } else {
                    arrayList.add(line);
                    return arrayList;
                }
            }
        }

        public String getText() {
            return this.textContent;
        }
    }

    public static class TextAttribute extends Attribute {
        public static final Attribute WIDTH = new TextAttribute("width");
        public static final long serialVersionUID = -3138885145941283005L;

        public TextAttribute(String str) {
            super(str);
        }
    }

    public static class Word {
        public AttributedString attributedString;
        public String textContent;

        public Word(String str) {
            this.textContent = str;
        }

        public AttributedString getAttributes() {
            return this.attributedString;
        }

        public String getText() {
            return this.textContent;
        }

        public void setAttributes(AttributedString attributedString2) {
            this.attributedString = attributedString2;
        }
    }

    public PlainText(String str) {
        List<String> asList = Arrays.asList(str.split("\\n"));
        for (String paragraph : asList) {
            this.paragraphs.add(new Paragraph(paragraph));
        }
    }

    public List<Paragraph> getParagraphs() {
        return this.paragraphs;
    }

    public PlainText(List<String> list) {
        for (String paragraph : list) {
            this.paragraphs.add(new Paragraph(paragraph));
        }
    }
}
