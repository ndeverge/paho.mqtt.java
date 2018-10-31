package org.eclipse.paho.android.service;

public interface MqttAuthenticationFailureHandler {
	boolean isApplicationAuthenticationFailure(Throwable exception);

	void onApplicationAuthenticationFailure(Throwable exception);
}
