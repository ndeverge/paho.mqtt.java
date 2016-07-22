package org.eclipse.paho.client.mqttv3;

/**
 * Created by ahmadulil on 12/18/15.
 *
 * Interface untuk callback ketika ping sent
 */
public interface IMqttPingActionListener extends IMqttActionListener {
    void onPingSent(IMqttToken token);
}
