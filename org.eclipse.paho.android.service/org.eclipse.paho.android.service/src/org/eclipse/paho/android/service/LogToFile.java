package org.eclipse.paho.android.service;

import android.content.Context;

import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * Created by erdian on 5/12/16.
 */
public class LogToFile {
    private static final String PATH = ".";
    private static final String FILENAME = "netzme.log";
    private static final String DELIMITER = " : ";
    private static final char EOL = '\n';

    private BufferedOutputStream stream;
    private DateFormat dateFormat = SimpleDateFormat.getDateTimeInstance();

    public LogToFile(Context context) {
        File file = new File(context.getExternalFilesDir(PATH), FILENAME);
        try {
            stream = new BufferedOutputStream(new FileOutputStream(file, true));
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
    }

    public void write(String tag, String message) {
        if (stream != null) {
            StringBuilder sb = new StringBuilder();
            sb.append(dateFormat.format(new Date()));
            sb.append(DELIMITER);
            sb.append(tag);
            sb.append(DELIMITER);
            sb.append(message);
            sb.append(EOL);

            writeToFile(sb.toString());
        }
    }

    private void writeToFile(String message) {
        try {
            stream.write(message.getBytes());
        } catch (IOException e) {
        }
    }
}
