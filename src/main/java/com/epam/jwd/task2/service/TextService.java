package com.epam.jwd.task2.service;

import com.epam.jwd.task2.entity.Text;
import com.epam.jwd.task2.entity.TextPart;
import com.epam.jwd.task2.parser.Parser;
import java.util.*;
import java.util.stream.Collectors;

public class TextService {

    /**
     * task 1
     */
    public List <TextPart> findSentenceWithRepeatingWords(Text text){
        List<TextPart> sentences = getAllSentences(text);
        List <TextPart> sentencesWithRepeatingWords = new ArrayList<>();
        for (TextPart sentence : sentences) {
            List<TextPart> initialSentence = sentence.getTextPartList();
            Set<TextPart> sentenceSet = new HashSet<>(initialSentence );
            if(!(sentenceSet.size() == initialSentence.size())){
                sentencesWithRepeatingWords.add(sentence);
            }
        }
        return sentencesWithRepeatingWords;
    }

    /**
     * task 2
     */

    public  List<TextPart> sortStringsByNumberOfWords (Text text){
        List<TextPart> sentences = getAllSentences(text);
        sentences.sort((o1, o2) -> o1.getTextPartList().size() -
                o2.getTextPartList().size());
        return sentences;
    }
    /**
     * task 3
     */

    public Set<TextPart> findUniqueWordsFromFirstSentence(Text text){
        List<TextPart> sentences = getAllSentences(text);
        Set<TextPart> sentenceFirst = new HashSet<>(sentences.get(0).getTextPartList());
        for (TextPart sentence : sentences.subList(1,sentences.size())) {
            Set<TextPart> sentenceOther = new HashSet<>(sentence.getTextPartList());
            sentenceFirst.removeAll(sentenceOther);
        }
        return sentenceFirst;
    }

    /**
     * task 5
     */

    public  List<TextPart> replaceFirstAndLastWordInSentence (Text text) {
        List<TextPart> sentences = getAllSentences(text);
        for (TextPart sentence : sentences) {
            int size = sentence.getTextPartList().size();
            TextPart lastWord = sentence.getTextPartList().get(size-1);
            TextPart firstWord = sentence.getTextPartList().set(0, lastWord);
            sentence.getTextPartList().set(size-1, firstWord);
        }
        return sentences;

    }

    /**
     * task 6
     */

    public Set <String> sortWordsByAlphabet (Text text) {
        List<TextPart> sentences = getAllSentences(text);
        List<TextPart> words= new ArrayList<>();
        sentences.stream().map(TextPart::getTextPartList).forEach(words::addAll);
        List<String> sortList = words.stream().map(w -> w.toString().toLowerCase()).sorted().collect(Collectors.toList());
        return new TreeSet<>(sortList);

    }

    public List<TextPart> parseBy(String initialText, Parser parser){

        return parser.parse(initialText);
    }

    private List<TextPart> getAllSentences(Text text){
        List<TextPart> paragraphs = text.getTextPartList();
        List<TextPart> sentences = new ArrayList<>();
        paragraphs.stream().map(TextPart::getTextPartList).forEach(sentences::addAll);
        return sentences;
    }
}
