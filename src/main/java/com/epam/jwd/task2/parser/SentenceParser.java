package com.epam.jwd.task2.parser;

import com.epam.jwd.task2.entity.Sentence;
import com.epam.jwd.task2.entity.TextPart;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import java.util.ArrayList;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class SentenceParser implements Parser {
    private static final String SENTENCE_NOT_FOUND = "Sentence wasn't found";
    private static final String SENTENCE_SUCCESSFULLY_BUILD = "Sentence was built";
    private static final Logger logger = LogManager.getLogger(SentenceParser.class);
    private static final Parser NEXT_PARSER= new WordParser();
    private static final Pattern SENTENCE_PARSER =
            Pattern.compile("([^(\\.|!|\\?)]+)(\\.|!|\\?)");

    @Override
    public List <TextPart> parse(String text) {
        StringBuilder correctText =
                new StringBuilder(text.replaceAll("[\\t\\n\\r]+", " "));
        if (SENTENCE_PARSER.matcher(correctText).find()) {
            List<TextPart> sentences= new ArrayList<>();
            Matcher sentenceMatcher = SENTENCE_PARSER.matcher(correctText);
            while (sentenceMatcher.find()) {
                Sentence sentence = new Sentence();
                List<TextPart> words =
                        NEXT_PARSER.parse(sentenceMatcher.group());
                sentence.addParts(words);
                logger.info(SENTENCE_SUCCESSFULLY_BUILD);
                sentences.add(sentence);
            }
            return sentences;
        }else{
            logger.error(SENTENCE_NOT_FOUND);
            return new ArrayList<>();
        }
    }
}