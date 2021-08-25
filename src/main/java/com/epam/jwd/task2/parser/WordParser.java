package com.epam.jwd.task2.parser;

import com.epam.jwd.task2.entity.TextPart;
import com.epam.jwd.task2.entity.Word;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import java.util.ArrayList;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class WordParser implements Parser {
    private static String WORD_NOT_FOUND = "Word wasn't found";
    private static String WORD_SUCCESSFULLY_BUILD  = "Word was built";
    private static final Logger logger= LogManager.getLogger(WordParser.class);
    private static final Parser NEXT_PARSER = null;
    private static final Pattern WORD_PARSER =
            Pattern.compile("(\\w+|\\-)([\\.\\,\\'\\!\\:\\?\\s]+)?");

    @Override
    public List <TextPart> parse(String text) {
        if (WORD_PARSER.matcher(text).find()) {
            List<TextPart> words = new ArrayList<>();
            Matcher wordMatcher = WORD_PARSER.matcher(text);
            while (wordMatcher.find()) {
                String end = wordMatcher.group(2);
                Word word = new Word(wordMatcher.group(1),
                        (end == null) ? "" : end);
                logger.info(WORD_SUCCESSFULLY_BUILD);
                words.add(word);
            }
            return words;
        } else {
            logger.error(WORD_NOT_FOUND);
            return new ArrayList<>();
        }
    }
}

