package com.mpl.network.modules.listeners;

import java.io.IOException;
import java.net.InetAddress;
import java.net.InetSocketAddress;
import java.net.Proxy;
import java.util.List;
import java.util.concurrent.atomic.AtomicLong;
import okhttp3.Call;
import okhttp3.Connection;
import okhttp3.EventListener;
import okhttp3.EventListener.Factory;
import okhttp3.Handshake;
import okhttp3.Protocol;
import okhttp3.Request;
import okhttp3.Response;

public final class PrintingEventListener extends EventListener {
    public static final Factory FACTORY = new Factory() {
        public final AtomicLong nextCallId = new AtomicLong(1);

        public EventListener create(Call call) {
            long andIncrement = this.nextCallId.getAndIncrement();
            System.out.printf("%04d %s%n", new Object[]{Long.valueOf(andIncrement), call.request().url()});
            return new PrintingEventListener(andIncrement, System.nanoTime());
        }
    };
    public final long callId;
    public final long callStartNanos;

    public PrintingEventListener(long j, long j2) {
        this.callId = j;
        this.callStartNanos = j2;
    }

    private void printEvent(String str) {
        long nanoTime = System.nanoTime() - this.callStartNanos;
        System.out.printf("%04d %.3f %s%n", new Object[]{Long.valueOf(this.callId), Double.valueOf(((double) nanoTime) / 1.0E9d), str});
    }

    public void callEnd(Call call) {
        printEvent("callEnd");
    }

    public void callFailed(Call call, IOException iOException) {
        printEvent("callFailed");
    }

    public void callStart(Call call) {
        printEvent("callStart");
    }

    public void connectEnd(Call call, InetSocketAddress inetSocketAddress, Proxy proxy, Protocol protocol) {
        printEvent("connectEnd");
    }

    public void connectFailed(Call call, InetSocketAddress inetSocketAddress, Proxy proxy, Protocol protocol, IOException iOException) {
        printEvent("connectFailed");
    }

    public void connectStart(Call call, InetSocketAddress inetSocketAddress, Proxy proxy) {
        printEvent("connectStart");
    }

    public void connectionAcquired(Call call, Connection connection) {
        printEvent("connectionAcquired");
    }

    public void connectionReleased(Call call, Connection connection) {
        printEvent("connectionReleased");
    }

    public void dnsEnd(Call call, String str, List<InetAddress> list) {
        printEvent("dnsEnd");
    }

    public void dnsStart(Call call, String str) {
        printEvent("dnsStart");
    }

    public void requestBodyEnd(Call call, long j) {
        printEvent("requestBodyEnd");
    }

    public void requestBodyStart(Call call) {
        printEvent("requestBodyStart");
    }

    public void requestHeadersEnd(Call call, Request request) {
        printEvent("requestHeadersEnd");
    }

    public void requestHeadersStart(Call call) {
        printEvent("requestHeadersStart");
    }

    public void responseBodyEnd(Call call, long j) {
        printEvent("responseBodyEnd");
    }

    public void responseBodyStart(Call call) {
        printEvent("responseBodyStart");
    }

    public void responseHeadersEnd(Call call, Response response) {
        printEvent("responseHeadersEnd");
    }

    public void responseHeadersStart(Call call) {
        printEvent("responseHeadersStart");
    }

    public void secureConnectEnd(Call call, Handshake handshake) {
        printEvent("secureConnectEnd");
    }

    public void secureConnectStart(Call call) {
        printEvent("secureConnectStart");
    }
}
