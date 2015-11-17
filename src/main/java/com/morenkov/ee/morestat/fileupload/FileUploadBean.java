package com.morenkov.ee.morestat.fileupload;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import javax.enterprise.context.RequestScoped;
import javax.inject.Named;
import javax.servlet.http.Part;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * @author emorenkov
 */
@Named
@RequestScoped
public class FileUploadBean {
    private static final Logger logger = LogManager.getLogger(FileUploadBean.class);
    private Part file;
    private String text;

    public Part getFile() {
        return file;
    }

    public void setFile(Part file) {
        Logger logger1 = LogManager.getRootLogger();
        Logger logger2 = LogManager.getLogger("com.morenkov.ee");
        logger.debug("Got file ...");
        logger1.debug("Got file1 ...");
        logger2.debug("Got file2 ...");
        this.file = file;
        if (null != file) {
            logger.debug("... and trying to read it ...");
            try {
                BufferedReader reader = new BufferedReader(new InputStreamReader(file.getInputStream()));
                String string = reader.readLine();
                StringBuilder builder = new StringBuilder();
                while (string != null) {
                    builder.append(string);
                    string = reader.readLine();
                }
                text = builder.toString();
            } catch (IOException ex) {
                ex.printStackTrace(System.err);
            }
            logger.debug("... completed reading file.");
        } else {
            logger.debug("... but its null.");
        }
    }

    public String getText() {
        logger.debug("Complete text: {}", text);
        return text;
    }
}
