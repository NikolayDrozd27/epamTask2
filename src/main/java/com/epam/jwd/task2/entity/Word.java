package com.epam.jwd.task2.entity;

import java.util.ArrayList;
import java.util.List;

public class Word implements TextPart,Comparable<Object> {

    private String word;
    private String end;
    private static final TextPartType type = TextPartType.WORD;

    public Word(String word,  String end) {
        this.word = word;
        this.end = end;
    }

    @Override
    public void addParts(List<TextPart> list) {
        //not
    }

    @Override
    public List<TextPart> getTextPartList() {
        return new ArrayList<>();
    }

    @Override
    public TextPartType getTextPartType() {
        return type;
    }

    @Override
    public String getString() {
        return word+end;
    }

    @Override
    public String toString() {
        return  getString();
    }

    @Override
    public int compareTo(Object o) {
        Word otherWord = (Word) o;
        return word.length()-
                otherWord.word.length();
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Word word1 = (Word) o;

        return word.equals(word1.word);
    }

    @Override
    public int hashCode() {
        return word.hashCode();
    }
}
