/*******************************************************************************
 * Copyright (c) 2013 IBM Corp.
 *
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * and Eclipse Distribution License v1.0 which accompany this distribution. 
 *
 * The Eclipse Public License is available at 
 *    http://www.eclipse.org/legal/epl-v10.html
 * and the Eclipse Distribution License is available at 
 *   http://www.eclipse.org/org/documents/edl-v10.php.
 *
 * Contributors:
 *    Bin Zhang - initial API and implementation and/or initial documentation
 *******************************************************************************/
package org.eclipse.paho.mqtt.ui.core;

import org.eclipse.paho.mqtt.ui.PahoException;
import org.eclipse.paho.mqtt.ui.core.model.Connection;

/**
 * Manages all MQTT connections
 * 
 * @author Bin Zhang
 */
public interface IConnectionManager {

	/**
	 * Connect to a MQTT connection
	 * 
	 * @param connection
	 * @throws PahoException
	 */
	void connect(Connection connection);

	/**
	 * Disconnect from a MQTT connection
	 * 
	 * @param connection
	 * @throws PahoException
	 */
	void disconnect(Connection connection);
}
