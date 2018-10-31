/*******************************************************************************
 * Copyright (c) 2014 IBM Corp.
 *
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * and Eclipse Distribution License v1.0 which accompany this distribution. 
 *
 * The Eclipse Public License is available at 
 *    http://www.eclipse.org/legal/epl-v10.html
 * and the Eclipse Distribution License is available at 
 *   http://www.eclipse.org/org/documents/edl-v10.php.
 */
package org.eclipse.paho.android.service.test;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.net.URI;
import java.net.URISyntaxException;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;
import java.util.Properties;

import android.content.Context;
import android.util.Log;

public class TestProperties {
//	public int waitForCompletionTime = 6000;
//	public String serverURI = "tcp://9.125.29.127:1883";
	// public static String serverURI = "tcp://9.119.156.175:1883";
	// public static String sslServerURI = "ssl://9.119.156.175:8892";
//	public String sslServerURI = "ssl://9.125.29.12:8892";

	private final Class<?> cclass = TestProperties.class;
	private final String className = cclass.getName();

	public final String KEY_SERVER_URI = "SERVER_URI";
	public final String KEY_CLIENT_KEY_STORE = "CLIENT_KEY_STORE";
	public final String KEY_CLIENT_KEY_STORE_PASSWORD = "CLIENT_KEY_STORE_PASSWORD";
	public final String KEY_SERVER_SSL_URI = "SERVER_SSL_URI";
	public final String KEY_WAIT_FOR_COMPLETION_TIME = "WAIT_FOR_COMPLETION_TIME";

	private Properties properties = new Properties();
	
	private Context context;


	/**
	 * Reads properties from a properties file
	 */
	public TestProperties(Context context) {

		this.context = context;
		InputStream stream = null;
		try {
			String filename = "test.properties";
			stream = getPropertyFileAsStream(filename);

			// Read the properties from the property file
			if (stream != null) {
				Log.i("TestProperties","Loading properties from: '" + filename + "'");
				properties.load(stream);
			}
		} catch (Exception e) {
			Log.e("TestProperties", "caught exception:", e);
		} finally {
			if (stream != null) {
				try {
					stream.close();
				} catch (IOException e) {
					Log.e("TestProperties", "caught exception:", e);
				}
			}
		}
	}

	/**
	 * @param filename
	 * @return stream
	 * @throws IOException
	 */
	private InputStream getPropertyFileAsStream(String fileName) throws IOException {
	    InputStream stream = null;
	    try {
	      stream = this.context.getResources().getAssets().open(fileName);
	    }
	    catch (Exception exception) {
	      Log.e("TestProperties", "Property file: '" + fileName + "' not found");
	    }

	    return stream;
	  }


	/**
	 * @param key
	 * @return value
	 */
	public String getProperty(String key) {
		String value = properties.getProperty(key);
		return value;
	}

	/**
	 * @param key
	 * @return value
	 */
	public boolean getBooleanProperty(String key) {
		String value = getProperty(key);
		return Boolean.parseBoolean(value);
	}

	/**
	 * @param key
	 * @return value
	 */
	public int getIntProperty(String key) {
		String value = getProperty(key);
		return Integer.parseInt(value);
	}


	/**
	 * @return keystore file name
	 */

	public String getClientKeyStore() {
		
		return getProperty(KEY_CLIENT_KEY_STORE);
	}

	/**
	 * @return keystore file password
	 */

	public String getClientKeyStorePassword() {
		return getProperty(KEY_CLIENT_KEY_STORE_PASSWORD);
	}

	/**
	 * @return the SSL url of the server for testing
	 */

	public String getServerSSLURI() {
		return getProperty(KEY_SERVER_SSL_URI);
	}

	/**
	 * @return the server url for testing
	 */
	public String getServerURI() {
		return getProperty(KEY_SERVER_URI);

	}
	
	public int getWaitForCompletionTime(){
		return getIntProperty(KEY_WAIT_FOR_COMPLETION_TIME);
	}

}
