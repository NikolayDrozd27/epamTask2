package com.epam.jwd.task2.entity;

import java.util.ArrayList;
import java.util.List;

public class Paragraph implements TextPart{

    private static final TextPartType type = TextPartType.PARAGRAPH;
    private  List<TextPart> sentences;

    public Paragraph() {
    }

    @Override
    public void addParts(List<TextPart> list) {
        sentences =new ArrayList<>(list);
    }

    @Override
    public List<TextPart> getTextPartList() {
        return sentences;
    }

    @Override
    public TextPartType getTextPartType() {
        return type;
    }

    @Override
    public String getString() {
        StringBuilder paragraph = new StringBuilder();
        for (TextPart sentence : getTextPartList()) {
            paragraph.append(sentence.toString());
        }
        return String.valueOf(paragraph);
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

        Paragraph paragraph2 = (Paragraph) o;
        return this.getString().equals(paragraph2.getString());
    }
}
