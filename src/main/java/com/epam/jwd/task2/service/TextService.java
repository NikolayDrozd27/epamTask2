package com.epam.jwd.task2.service;

import com.epam.jwd.task2.entity.Text;
import com.epam.jwd.task2.entity.TextPart;
import com.epam.jwd.task2.parser.Parser;
import java.util.*;
import java.util.stream.Collectors;

public class TextService {

    /**
     * 1. Найти наибольшее количество предложений текста, в которых есть одинаковые
     * слова.
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
     * 2. Вывести все предложения заданного текста в порядке возрастания
     * количества слов в каждом из них.
     */

    public  List<TextPart> sortStringsByNumberOfWords (Text text){
        List<TextPart> sentences = getAllSentences(text);
        sentences.sort((o1, o2) -> o1.getTextPartList().size() -
                o2.getTextPartList().size());
        return sentences;
    }
    /**
     * 3. Найти такое слово в первом предложении, которого нет ни в одном из остальных
     * предложений.
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
     * 5. В каждом предложении текста поменять местами первое слово с последним, не
     * изменяя длины предложения.
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
     * 6. Напечатать слова текста в алфавитном порядке по первой
     * букве. Слова, начинающиеся с новой буквы, печатать с красной строки.
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
