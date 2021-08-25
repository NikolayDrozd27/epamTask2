package com.epam.jwd.task2.parser;

import com.epam.jwd.task2.entity.Text;
import com.epam.jwd.task2.entity.TextPart;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import java.util.List;

public class TextParser {
    private static String EMPTY_FILE = "File is empty";
    private static String TEXT_SUCCESSFULLY_BUILD = "Text was built";
    private static final Logger logger = LogManager.getLogger(TextParser.class);
    private static final Parser NEXT_PARSER = new ParagraphParser();

    public Text parse(String initialText){
        if(!initialText.isEmpty()) {
            Text text = new Text();
            List<TextPart> paragraphs = NEXT_PARSER.parse(initialText);
            text.addParts(paragraphs);
            logger.info(TEXT_SUCCESSFULLY_BUILD);
            return text;
        }else{
            logger.error(EMPTY_FILE);
            return new Text();
        }
    }

}
