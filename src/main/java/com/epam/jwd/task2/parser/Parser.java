package com.epam.jwd.task2.parser;

import com.epam.jwd.task2.entity.TextPart;
import java.util.List;

public interface Parser {
     List<TextPart> parse(String text);
}
