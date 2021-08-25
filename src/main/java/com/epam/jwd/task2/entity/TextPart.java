package com.epam.jwd.task2.entity;

import java.util.List;

public interface TextPart {

    List<TextPart> getTextPartList();
    TextPartType getTextPartType();
    String getString();
    void  addParts(List <TextPart> list);

}
