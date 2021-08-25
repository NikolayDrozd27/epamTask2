package com.epam.jwd.task2.entity;

import java.util.ArrayList;
import java.util.List;

public class Sentence implements TextPart,Comparable<TextPart>{

    private static final TextPartType type = TextPartType.SENTENCE;
    private  List<TextPart> words = new ArrayList<>();

    public Sentence() {}

    @Override
    public void addParts(List<TextPart> list) {
        words=new ArrayList<>(list);
    }

    @Override
    public List<TextPart> getTextPartList() {
        return words;
    }

    @Override
    public TextPartType getTextPartType() {
        return type;
    }

    @Override
    public int compareTo(TextPart o) {
        Sentence otherSentence = (Sentence) o;
        return this.getTextPartList().size()-
                otherSentence.getTextPartList().size();
    }

    @Override
    public String getString() {
        StringBuilder sentence = new StringBuilder();
        for (TextPart word : getTextPartList()) {
            sentence.append(word.toString());
        }
        return sentence+" ";
    }

    @Override
    public String toString() {
        return this.getString();
    }

    @Override
    public int hashCode() {
        return getString().hashCode();
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Sentence sentence2 = (Sentence) o;
        return this.getString().equals(sentence2.getString());
    }
}
