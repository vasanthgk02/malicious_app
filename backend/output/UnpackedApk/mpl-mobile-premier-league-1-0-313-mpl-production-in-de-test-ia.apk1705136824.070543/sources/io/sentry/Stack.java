package io.sentry;

import io.sentry.util.Objects;
import java.util.Deque;
import java.util.Iterator;
import java.util.concurrent.LinkedBlockingDeque;

public final class Stack {
    public final Deque<StackItem> items;
    public final ILogger logger;

    public static final class StackItem {
        public volatile ISentryClient client;
        public final SentryOptions options;
        public volatile Scope scope;

        public StackItem(SentryOptions sentryOptions, ISentryClient iSentryClient, Scope scope2) {
            this.client = (ISentryClient) Objects.requireNonNull(iSentryClient, "ISentryClient is required.");
            this.scope = (Scope) Objects.requireNonNull(scope2, "Scope is required.");
            this.options = (SentryOptions) Objects.requireNonNull(sentryOptions, "Options is required");
        }

        public ISentryClient getClient() {
            return this.client;
        }

        public SentryOptions getOptions() {
            return this.options;
        }

        public Scope getScope() {
            return this.scope;
        }

        public void setClient(ISentryClient iSentryClient) {
            this.client = iSentryClient;
        }

        public StackItem(StackItem stackItem) {
            this.options = stackItem.options;
            this.client = stackItem.client;
            this.scope = new Scope(stackItem.scope);
        }
    }

    public Stack(ILogger iLogger, StackItem stackItem) {
        this.items = new LinkedBlockingDeque();
        this.logger = (ILogger) Objects.requireNonNull(iLogger, "logger is required");
        this.items.push((StackItem) Objects.requireNonNull(stackItem, "rootStackItem is required"));
    }

    public StackItem peek() {
        return this.items.peek();
    }

    public void pop() {
        synchronized (this.items) {
            if (this.items.size() != 1) {
                this.items.pop();
            } else {
                this.logger.log(SentryLevel.WARNING, (String) "Attempt to pop the root scope.", new Object[0]);
            }
        }
    }

    public void push(StackItem stackItem) {
        this.items.push(stackItem);
    }

    public int size() {
        return this.items.size();
    }

    public Stack(Stack stack) {
        this(stack.logger, new StackItem(stack.items.getLast()));
        Iterator<StackItem> descendingIterator = stack.items.descendingIterator();
        if (descendingIterator.hasNext()) {
            descendingIterator.next();
        }
        while (descendingIterator.hasNext()) {
            push(new StackItem(descendingIterator.next()));
        }
    }
}
