package com.badlogic.gdx.scenes.scene2d.ui;

import co.hyperverge.hypersnapsdk.c.k;
import com.badlogic.gdx.Files;
import com.badlogic.gdx.scenes.scene2d.Actor;
import com.badlogic.gdx.scenes.scene2d.ui.Value.Fixed;
import com.badlogic.gdx.utils.Pool.Poolable;

public class Cell<T extends Actor> implements Poolable {
    public static final Integer centeri;
    public static Cell defaults;
    public static Files files;
    public static final Float onef = Float.valueOf(1.0f);
    public static final Integer onei;
    public static final Float zerof = Float.valueOf(0.0f);
    public static final Integer zeroi = Integer.valueOf(0);
    public Actor actor;
    public float actorHeight;
    public float actorWidth;
    public float actorX;
    public float actorY;
    public Integer align;
    public int cellAboveIndex = -1;
    public Integer colspan;
    public int column;
    public float computedPadBottom;
    public float computedPadLeft;
    public float computedPadRight;
    public float computedPadTop;
    public boolean endRow;
    public Integer expandX;
    public Integer expandY;
    public Float fillX;
    public Float fillY;
    public Value maxHeight;
    public Value maxWidth;
    public Value minHeight;
    public Value minWidth;
    public Value padBottom;
    public Value padLeft;
    public Value padRight;
    public Value padTop;
    public Value prefHeight;
    public Value prefWidth;
    public int row;
    public Value spaceBottom;
    public Value spaceLeft;
    public Value spaceRight;
    public Value spaceTop;
    public Boolean uniformX;
    public Boolean uniformY;

    static {
        Integer valueOf = Integer.valueOf(1);
        onei = valueOf;
        centeri = valueOf;
    }

    public Cell() {
        Cell defaults2 = defaults();
        if (defaults2 != null) {
            set(defaults2);
        }
    }

    public static Cell defaults() {
        Files files2 = files;
        if (files2 == null || files2 != k.files) {
            files = k.files;
            Cell cell = new Cell();
            defaults = cell;
            cell.minWidth = Value.minWidth;
            defaults.minHeight = Value.minHeight;
            defaults.prefWidth = Value.prefWidth;
            defaults.prefHeight = Value.prefHeight;
            defaults.maxWidth = Value.maxWidth;
            defaults.maxHeight = Value.maxHeight;
            Cell cell2 = defaults;
            Fixed fixed = Value.zero;
            cell2.spaceTop = fixed;
            Cell cell3 = defaults;
            cell3.spaceLeft = fixed;
            cell3.spaceBottom = fixed;
            cell3.spaceRight = fixed;
            cell3.padTop = fixed;
            cell3.padLeft = fixed;
            cell3.padBottom = fixed;
            cell3.padRight = fixed;
            Float f2 = zerof;
            cell3.fillX = f2;
            cell3.fillY = f2;
            cell3.align = centeri;
            Integer num = zeroi;
            cell3.expandX = num;
            cell3.expandY = num;
            cell3.colspan = onei;
            cell3.uniformX = null;
            cell3.uniformY = null;
        }
        return defaults;
    }

    public void merge(Cell cell) {
        if (cell != null) {
            Value value = cell.minWidth;
            if (value != null) {
                this.minWidth = value;
            }
            Value value2 = cell.minHeight;
            if (value2 != null) {
                this.minHeight = value2;
            }
            Value value3 = cell.prefWidth;
            if (value3 != null) {
                this.prefWidth = value3;
            }
            Value value4 = cell.prefHeight;
            if (value4 != null) {
                this.prefHeight = value4;
            }
            Value value5 = cell.maxWidth;
            if (value5 != null) {
                this.maxWidth = value5;
            }
            Value value6 = cell.maxHeight;
            if (value6 != null) {
                this.maxHeight = value6;
            }
            Value value7 = cell.spaceTop;
            if (value7 != null) {
                this.spaceTop = value7;
            }
            Value value8 = cell.spaceLeft;
            if (value8 != null) {
                this.spaceLeft = value8;
            }
            Value value9 = cell.spaceBottom;
            if (value9 != null) {
                this.spaceBottom = value9;
            }
            Value value10 = cell.spaceRight;
            if (value10 != null) {
                this.spaceRight = value10;
            }
            Value value11 = cell.padTop;
            if (value11 != null) {
                this.padTop = value11;
            }
            Value value12 = cell.padLeft;
            if (value12 != null) {
                this.padLeft = value12;
            }
            Value value13 = cell.padBottom;
            if (value13 != null) {
                this.padBottom = value13;
            }
            Value value14 = cell.padRight;
            if (value14 != null) {
                this.padRight = value14;
            }
            Float f2 = cell.fillX;
            if (f2 != null) {
                this.fillX = f2;
            }
            Float f3 = cell.fillY;
            if (f3 != null) {
                this.fillY = f3;
            }
            Integer num = cell.align;
            if (num != null) {
                this.align = num;
            }
            Integer num2 = cell.expandX;
            if (num2 != null) {
                this.expandX = num2;
            }
            Integer num3 = cell.expandY;
            if (num3 != null) {
                this.expandY = num3;
            }
            Integer num4 = cell.colspan;
            if (num4 != null) {
                this.colspan = num4;
            }
            Boolean bool = cell.uniformX;
            if (bool != null) {
                this.uniformX = bool;
            }
            Boolean bool2 = cell.uniformY;
            if (bool2 != null) {
                this.uniformY = bool2;
            }
        }
    }

    public void reset() {
        this.actor = null;
        this.endRow = false;
        this.cellAboveIndex = -1;
        set(defaults());
    }

    public void set(Cell cell) {
        this.minWidth = cell.minWidth;
        this.minHeight = cell.minHeight;
        this.prefWidth = cell.prefWidth;
        this.prefHeight = cell.prefHeight;
        this.maxWidth = cell.maxWidth;
        this.maxHeight = cell.maxHeight;
        this.spaceTop = cell.spaceTop;
        this.spaceLeft = cell.spaceLeft;
        this.spaceBottom = cell.spaceBottom;
        this.spaceRight = cell.spaceRight;
        this.padTop = cell.padTop;
        this.padLeft = cell.padLeft;
        this.padBottom = cell.padBottom;
        this.padRight = cell.padRight;
        this.fillX = cell.fillX;
        this.fillY = cell.fillY;
        this.align = cell.align;
        this.expandX = cell.expandX;
        this.expandY = cell.expandY;
        this.colspan = cell.colspan;
        this.uniformX = cell.uniformX;
        this.uniformY = cell.uniformY;
    }

    public String toString() {
        Actor actor2 = this.actor;
        return actor2 != null ? actor2.toString() : super.toString();
    }
}
