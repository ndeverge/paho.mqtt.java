package org.eclipse.paho.android.service;

public interface MqttAuthenticationFailureHandler {
	boolean isApplicationAuthenticationFailure();

	void onApplicationAuthenticationFailure();
}
