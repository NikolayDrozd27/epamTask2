package com.epam.jwd.task2.controller;

import com.epam.jwd.task2.entity.*;
import com.epam.jwd.task2.parser.TextParser;
import com.epam.jwd.task2.reader.ReaderFromFile;
import com.epam.jwd.task2.service.TextService;
import com.epam.jwd.task2.writer.WriterToFile;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;


public class TextController {

    private static final Logger logger = LogManager.getLogger(TextController.class);
    private static final String INVALID_FILE = "Read invalid file";

    public void run(String filePathRead, String encoding,String filePathWrite){
        String initialText = new ReaderFromFile().readFile(filePathRead, encoding);
        if(initialText!="") {
            Text text = new TextParser().parse(initialText);
            new WriterToFile().writeText(text,filePathWrite);
//            System.out.println(new TextService().sortStringsByNumberOfWords(text));
        }else {
            logger.error(INVALID_FILE );
        }

    }
}



