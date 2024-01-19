package org.eclipse.paho.android.service;

import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;
import org.eclipse.paho.client.mqttv3.MqttMessage;

public class ParcelableMqttMessage extends MqttMessage implements Parcelable {
    public static final Creator<ParcelableMqttMessage> CREATOR = new Creator<ParcelableMqttMessage>() {
        public ParcelableMqttMessage createFromParcel(Parcel parcel) {
            return new ParcelableMqttMessage(parcel);
        }

        public ParcelableMqttMessage[] newArray(int i) {
            return new ParcelableMqttMessage[i];
        }
    };
    public String messageId = null;

    public ParcelableMqttMessage(MqttMessage mqttMessage) {
        super(mqttMessage.getPayload());
        setQos(mqttMessage.getQos());
        setRetained(mqttMessage.isRetained());
        setDuplicate(mqttMessage.isDuplicate());
    }

    public int describeContents() {
        return 0;
    }

    public String getMessageId() {
        return this.messageId;
    }

    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeByteArray(getPayload());
        parcel.writeInt(getQos());
        parcel.writeBooleanArray(new boolean[]{isRetained(), isDuplicate()});
        parcel.writeString(this.messageId);
    }

    public ParcelableMqttMessage(Parcel parcel) {
        super(parcel.createByteArray());
        setQos(parcel.readInt());
        boolean[] createBooleanArray = parcel.createBooleanArray();
        setRetained(createBooleanArray[0]);
        setDuplicate(createBooleanArray[1]);
        this.messageId = parcel.readString();
    }
}
