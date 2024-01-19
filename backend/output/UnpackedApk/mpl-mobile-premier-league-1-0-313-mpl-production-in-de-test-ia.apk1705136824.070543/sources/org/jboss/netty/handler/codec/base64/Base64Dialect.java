package org.jboss.netty.handler.codec.base64;

import okio.Utf8;
import org.apache.fontbox.ttf.GlyfDescript;
import org.apache.pdfbox.pdfparser.BaseParser;
import org.eclipse.paho.client.mqttv3.internal.wire.MqttWireMessage;
import org.jboss.netty.handler.codec.http.HttpCodecUtil;

public enum Base64Dialect {
    STANDARD(new byte[]{65, 66, 67, 68, 69, 70, 71, 72, 73, 74, 75, 76, 77, 78, 79, 80, 81, 82, 83, 84, 85, 86, 87, 88, 89, 90, 97, 98, 99, 100, 101, 102, 103, 104, 105, 106, 107, 108, 109, 110, 111, 112, 113, 114, 115, 116, 117, 118, 119, 120, 121, 122, BaseParser.ASCII_ZERO, 49, 50, 51, 52, 53, 54, 55, 56, BaseParser.ASCII_NINE, 43, 47}, new byte[]{-9, -9, -9, -9, -9, -9, -9, -9, -9, -5, -5, -9, -9, -5, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -5, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, 62, -9, -9, -9, Utf8.REPLACEMENT_BYTE, 52, 53, 54, 55, 56, BaseParser.ASCII_NINE, HttpCodecUtil.COLON, HttpCodecUtil.SEMICOLON, 60, 61, -9, -9, -9, -1, -9, -9, -9, 0, 1, 2, 3, 4, 5, 6, 7, 8, 9, 10, MqttWireMessage.MESSAGE_TYPE_UNSUBACK, MqttWireMessage.MESSAGE_TYPE_PINGREQ, 13, MqttWireMessage.MESSAGE_TYPE_DISCONNECT, 15, GlyfDescript.X_DUAL, 17, 18, 19, 20, 21, 22, 23, 24, 25, -9, -9, -9, -9, -9, -9, 26, 27, 28, 29, 30, 31, 32, 33, HttpCodecUtil.DOUBLE_QUOTE, 35, 36, 37, 38, 39, 40, 41, 42, 43, HttpCodecUtil.COMMA, 45, 46, 47, BaseParser.ASCII_ZERO, 49, 50, 51, -9, -9, -9, -9}, true),
    URL_SAFE(new byte[]{65, 66, 67, 68, 69, 70, 71, 72, 73, 74, 75, 76, 77, 78, 79, 80, 81, 82, 83, 84, 85, 86, 87, 88, 89, 90, 97, 98, 99, 100, 101, 102, 103, 104, 105, 106, 107, 108, 109, 110, 111, 112, 113, 114, 115, 116, 117, 118, 119, 120, 121, 122, BaseParser.ASCII_ZERO, 49, 50, 51, 52, 53, 54, 55, 56, BaseParser.ASCII_NINE, 45, 95}, new byte[]{-9, -9, -9, -9, -9, -9, -9, -9, -9, -5, -5, -9, -9, -5, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -5, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, 62, -9, -9, 52, 53, 54, 55, 56, BaseParser.ASCII_NINE, HttpCodecUtil.COLON, HttpCodecUtil.SEMICOLON, 60, 61, -9, -9, -9, -1, -9, -9, -9, 0, 1, 2, 3, 4, 5, 6, 7, 8, 9, 10, MqttWireMessage.MESSAGE_TYPE_UNSUBACK, MqttWireMessage.MESSAGE_TYPE_PINGREQ, 13, MqttWireMessage.MESSAGE_TYPE_DISCONNECT, 15, GlyfDescript.X_DUAL, 17, 18, 19, 20, 21, 22, 23, 24, 25, -9, -9, -9, -9, Utf8.REPLACEMENT_BYTE, -9, 26, 27, 28, 29, 30, 31, 32, 33, HttpCodecUtil.DOUBLE_QUOTE, 35, 36, 37, 38, 39, 40, 41, 42, 43, HttpCodecUtil.COMMA, 45, 46, 47, BaseParser.ASCII_ZERO, 49, 50, 51, -9, -9, -9, -9}, false),
    ORDERED(new byte[]{45, BaseParser.ASCII_ZERO, 49, 50, 51, 52, 53, 54, 55, 56, BaseParser.ASCII_NINE, 65, 66, 67, 68, 69, 70, 71, 72, 73, 74, 75, 76, 77, 78, 79, 80, 81, 82, 83, 84, 85, 86, 87, 88, 89, 90, 95, 97, 98, 99, 100, 101, 102, 103, 104, 105, 106, 107, 108, 109, 110, 111, 112, 113, 114, 115, 116, 117, 118, 119, 120, 121, 122}, new byte[]{-9, -9, -9, -9, -9, -9, -9, -9, -9, -5, -5, -9, -9, -5, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -5, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, 0, -9, -9, 1, 2, 3, 4, 5, 6, 7, 8, 9, 10, -9, -9, -9, -1, -9, -9, -9, MqttWireMessage.MESSAGE_TYPE_UNSUBACK, MqttWireMessage.MESSAGE_TYPE_PINGREQ, 13, MqttWireMessage.MESSAGE_TYPE_DISCONNECT, 15, GlyfDescript.X_DUAL, 17, 18, 19, 20, 21, 22, 23, 24, 25, 26, 27, 28, 29, 30, 31, 32, 33, HttpCodecUtil.DOUBLE_QUOTE, 35, 36, -9, -9, -9, -9, 37, -9, 38, 39, 40, 41, 42, 43, HttpCodecUtil.COMMA, 45, 46, 47, BaseParser.ASCII_ZERO, 49, 50, 51, 52, 53, 54, 55, 56, BaseParser.ASCII_NINE, HttpCodecUtil.COLON, HttpCodecUtil.SEMICOLON, 60, 61, 62, Utf8.REPLACEMENT_BYTE, -9, -9, -9, -9}, true);
    
    public final byte[] alphabet;
    public final boolean breakLinesByDefault;
    public final byte[] decodabet;

    /* access modifiers changed from: public */
    Base64Dialect(byte[] bArr, byte[] bArr2, boolean z) {
        this.alphabet = bArr;
        this.decodabet = bArr2;
        this.breakLinesByDefault = z;
    }
}
