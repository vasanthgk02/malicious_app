package com.badlogic.gdx.scenes.scene2d.utils;

public interface Layout {
    float getMaxHeight();

    float getMaxWidth();

    float getMinHeight();

    float getMinWidth();

    float getPrefHeight();

    float getPrefWidth();

    void invalidateHierarchy();

    void validate();
}
