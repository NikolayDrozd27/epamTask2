package com.epam.jwd.task2.parser;

import com.epam.jwd.task2.entity.Paragraph;
import com.epam.jwd.task2.entity.TextPart;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.util.ArrayList;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class ParagraphParser implements Parser{
    private static final String PARAGRAPH_NOT_FOUND = "Paragraph wasn't found";
    private static final String PARAGRAPH_SUCCESSFULLY_BUILD = "Paragraph was built";
    private static final Logger logger= LogManager.getLogger(ParagraphParser.class);
    private static final Parser NEXT_PARSER =new SentenceParser();;
    private static final Pattern PARAGRAPH_PARSER =
            Pattern.compile("\\t[^\\t]+[\\.\\?\\!]+");


    @Override
    public List<TextPart> parse(String initialText) {
        if (PARAGRAPH_PARSER.matcher(initialText).find()) {
            List<TextPart> paragraphs = new ArrayList<>();
            Matcher paragraphMatcher = PARAGRAPH_PARSER.matcher(initialText);
            while (paragraphMatcher.find()) {
                Paragraph paragraph = new Paragraph();
                List<TextPart> sentences =
                        NEXT_PARSER.parse(paragraphMatcher.group());
                paragraph.addParts(sentences);
                logger.info(PARAGRAPH_SUCCESSFULLY_BUILD);
                paragraphs.add(paragraph);
            }
            return paragraphs;
        } else {
            logger.error(PARAGRAPH_NOT_FOUND);
            return new ArrayList<>();
        }
    }
}
