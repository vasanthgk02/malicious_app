package com.badlogic.gdx.scenes.scene2d.ui;

import com.android.tools.r8.GeneratedOutlineSupport;
import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.graphics.g2d.BitmapFont;
import com.badlogic.gdx.scenes.scene2d.ui.Button.ButtonStyle;
import com.badlogic.gdx.scenes.scene2d.ui.Label.LabelStyle;

public class TextButton extends Button {
    public Label label;
    public TextButtonStyle style;

    public static class TextButtonStyle extends ButtonStyle {
        public Color checkedDownFontColor;
        public Color checkedFocusedFontColor;
        public Color checkedFontColor;
        public Color checkedOverFontColor;
        public Color downFontColor;
        public Color focusedFontColor;
        public BitmapFont font;
        public Color fontColor;
        public Color overFontColor;
    }

    public TextButton(String str, TextButtonStyle textButtonStyle) {
        setStyle(textButtonStyle);
        Label label2 = new Label(str, new LabelStyle(textButtonStyle.font, null));
        this.label = label2;
        label2.setAlignment(1);
        Cell add = add(this.label);
        Integer num = Cell.onei;
        add.expandX = num;
        add.expandY = num;
        Float f2 = Cell.onef;
        add.fillX = f2;
        add.fillY = f2;
        setSize(getPrefWidth(), getPrefHeight());
    }

    /* JADX WARNING: Code restructure failed: missing block: B:13:0x002a, code lost:
        if (r1 != null) goto L_0x006e;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:15:0x0031, code lost:
        if (r1 != null) goto L_0x006e;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:26:0x0049, code lost:
        if (r2 != null) goto L_0x0052;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:33:0x005e, code lost:
        if (r2 != null) goto L_0x0052;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:36:0x0067, code lost:
        if (r1 != null) goto L_0x006e;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:5:0x0012, code lost:
        if (r1 != null) goto L_0x006e;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:7:0x0019, code lost:
        if (r1 != null) goto L_0x006e;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public void draw(com.badlogic.gdx.graphics.g2d.Batch r4, float r5) {
        /*
            r3 = this;
            com.badlogic.gdx.scenes.scene2d.ui.Label r0 = r3.label
            com.badlogic.gdx.scenes.scene2d.ui.Label$LabelStyle r0 = r0.style
            boolean r1 = r3.isPressed()
            if (r1 == 0) goto L_0x001c
            boolean r1 = r3.isChecked
            if (r1 == 0) goto L_0x0015
            com.badlogic.gdx.scenes.scene2d.ui.TextButton$TextButtonStyle r1 = r3.style
            com.badlogic.gdx.graphics.Color r1 = r1.checkedDownFontColor
            if (r1 == 0) goto L_0x0015
            goto L_0x006e
        L_0x0015:
            com.badlogic.gdx.scenes.scene2d.ui.TextButton$TextButtonStyle r1 = r3.style
            com.badlogic.gdx.graphics.Color r1 = r1.downFontColor
            if (r1 == 0) goto L_0x001c
            goto L_0x006e
        L_0x001c:
            boolean r1 = r3.isOver()
            if (r1 == 0) goto L_0x0034
            boolean r1 = r3.isChecked
            if (r1 == 0) goto L_0x002d
            com.badlogic.gdx.scenes.scene2d.ui.TextButton$TextButtonStyle r1 = r3.style
            com.badlogic.gdx.graphics.Color r1 = r1.checkedOverFontColor
            if (r1 == 0) goto L_0x0034
            goto L_0x006e
        L_0x002d:
            com.badlogic.gdx.scenes.scene2d.ui.TextButton$TextButtonStyle r1 = r3.style
            com.badlogic.gdx.graphics.Color r1 = r1.overFontColor
            if (r1 == 0) goto L_0x0034
            goto L_0x006e
        L_0x0034:
            com.badlogic.gdx.scenes.scene2d.Stage r1 = r3.stage
            if (r1 == 0) goto L_0x003e
            com.badlogic.gdx.scenes.scene2d.Actor r1 = r1.keyboardFocus
            if (r1 != r3) goto L_0x003e
            r1 = 1
            goto L_0x003f
        L_0x003e:
            r1 = 0
        L_0x003f:
            boolean r2 = r3.isChecked
            if (r2 == 0) goto L_0x0061
            if (r1 == 0) goto L_0x004c
            com.badlogic.gdx.scenes.scene2d.ui.TextButton$TextButtonStyle r2 = r3.style
            com.badlogic.gdx.graphics.Color r2 = r2.checkedFocusedFontColor
            if (r2 == 0) goto L_0x004c
            goto L_0x0052
        L_0x004c:
            com.badlogic.gdx.scenes.scene2d.ui.TextButton$TextButtonStyle r2 = r3.style
            com.badlogic.gdx.graphics.Color r2 = r2.checkedFontColor
            if (r2 == 0) goto L_0x0054
        L_0x0052:
            r1 = r2
            goto L_0x006e
        L_0x0054:
            boolean r2 = r3.isOver()
            if (r2 == 0) goto L_0x0061
            com.badlogic.gdx.scenes.scene2d.ui.TextButton$TextButtonStyle r2 = r3.style
            com.badlogic.gdx.graphics.Color r2 = r2.overFontColor
            if (r2 == 0) goto L_0x0061
            goto L_0x0052
        L_0x0061:
            if (r1 == 0) goto L_0x006a
            com.badlogic.gdx.scenes.scene2d.ui.TextButton$TextButtonStyle r1 = r3.style
            com.badlogic.gdx.graphics.Color r1 = r1.focusedFontColor
            if (r1 == 0) goto L_0x006a
            goto L_0x006e
        L_0x006a:
            com.badlogic.gdx.scenes.scene2d.ui.TextButton$TextButtonStyle r1 = r3.style
            com.badlogic.gdx.graphics.Color r1 = r1.fontColor
        L_0x006e:
            r0.fontColor = r1
            super.draw(r4, r5)
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.badlogic.gdx.scenes.scene2d.ui.TextButton.draw(com.badlogic.gdx.graphics.g2d.Batch, float):void");
    }

    public void setStyle(ButtonStyle buttonStyle) {
        if (buttonStyle == null) {
            throw new NullPointerException("style cannot be null");
        } else if (buttonStyle instanceof TextButtonStyle) {
            TextButtonStyle textButtonStyle = (TextButtonStyle) buttonStyle;
            this.style = textButtonStyle;
            this.style = buttonStyle;
            setBackground(getBackgroundDrawable());
            Label label2 = this.label;
            if (label2 != null) {
                LabelStyle labelStyle = label2.style;
                labelStyle.font = textButtonStyle.font;
                labelStyle.fontColor = textButtonStyle.fontColor;
                label2.setStyle(labelStyle);
            }
        } else {
            throw new IllegalArgumentException("style must be a TextButtonStyle.");
        }
    }

    public String toString() {
        String str = this.name;
        if (str != null) {
            return str;
        }
        String name = TextButton.class.getName();
        int lastIndexOf = name.lastIndexOf(46);
        if (lastIndexOf != -1) {
            name = name.substring(lastIndexOf + 1);
        }
        StringBuilder sb = new StringBuilder();
        GeneratedOutlineSupport.outline102(sb, name.indexOf(36) != -1 ? "TextButton " : "", name, ": ");
        sb.append(this.label.text);
        return sb.toString();
    }
}
