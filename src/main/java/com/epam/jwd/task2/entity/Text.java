package com.epam.jwd.task2.entity;

import java.util.ArrayList;
import java.util.List;

public class Text implements TextPart{

    private  List<TextPart> paragraphs;
    private  static TextPartType type = TextPartType.TEXT;

    public Text(){}

    @Override
    public void addParts(List<TextPart> list) {
        paragraphs =new ArrayList<>(list);
    }

    @Override
    public List<TextPart> getTextPartList() {
        return paragraphs;
    }

    @Override
    public String getString() {
        StringBuilder text = new StringBuilder();
        for (TextPart paragraph : getTextPartList()) {
            text.append("\t"+paragraph.toString()+"\n");
        }
        String textString = String.valueOf(text);
        return textString;
    }

    @Override
    public TextPartType getTextPartType() {
        return type;
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

        Text text2 = (Text) o;
        return this.getString().equals(text2.getString());
    }
}
