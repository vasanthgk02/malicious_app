package com.facebook.debug.holder;

public class NoopPrinter implements Printer {
    public static final NoopPrinter INSTANCE = new NoopPrinter();
}
