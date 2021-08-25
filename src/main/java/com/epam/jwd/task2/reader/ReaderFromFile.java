package com.epam.jwd.task2.reader;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import java.io.*;


public class  ReaderFromFile {

    private static final Logger logger = LogManager.getLogger(ReaderFromFile.class);
    private static final String FILE_READ = "File was read";
    private static final String UNSUPPORTED_ENCODING = "File with unsupported encoding";
    private static final String INVALID_FILEPATH = "Path to file is invalid";
    private static final String INVALID_FILE = "";

    public String readFile(String filePath, String encoding)  {
        StringBuilder sb = new StringBuilder();
        try (BufferedReader br =
                     new BufferedReader(
                             new InputStreamReader(
                                     new FileInputStream(
                                             new File(filePath)), encoding))) {
            String line;
            while ((line = br.readLine()) != null) {
                sb.append(line);
                sb.append('\n');
            }
            logger.info(FILE_READ);
            return String.valueOf(sb);
        }catch (UnsupportedEncodingException e) {
            logger.error(UNSUPPORTED_ENCODING);
        } catch (IOException e) {
            logger.error(INVALID_FILEPATH);
        }
        return INVALID_FILE;
    }

}
