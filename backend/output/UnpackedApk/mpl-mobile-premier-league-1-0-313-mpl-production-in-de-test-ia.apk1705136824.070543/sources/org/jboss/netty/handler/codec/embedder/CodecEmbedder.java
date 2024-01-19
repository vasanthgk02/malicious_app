package org.jboss.netty.handler.codec.embedder;

public interface CodecEmbedder<E> {
    boolean finish();

    boolean offer(Object obj);

    E peek();

    E poll();

    Object[] pollAll();

    <T> T[] pollAll(T[] tArr);

    int size();
}
