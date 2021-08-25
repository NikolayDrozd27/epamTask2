package com.epam.jwd.task2.writer;

import com.epam.jwd.task2.entity.Text;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;

public class WriterToFile {

    private static final Logger logger = LogManager.getLogger(WriterToFile.class);
    private static final String FILE_WRITE = "Text was written";
    private static final String INVALID_FILE_PATH = "Filepath is invalid";

    public void writeText(Text text, String filePath)  {
        String outText = text.getString();
        try(BufferedWriter writer = new BufferedWriter(new FileWriter(filePath))) {
            writer.write(outText);
            logger.info(FILE_WRITE);
        } catch (IOException e) {
            logger.error(INVALID_FILE_PATH);
        }
    }
}
