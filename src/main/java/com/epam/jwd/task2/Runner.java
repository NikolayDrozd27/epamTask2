package com.epam.jwd.task2;

import com.epam.jwd.task2.controller.TextController;

public class Runner {
    private static final String encoding = "UTF-8";
    private static final String filePathRead = "src\\main\\resources\\inputText";
    private static final String filePathWrite = "src\\main\\resources\\outputText";

    public static void main(String[] args) {
        new TextController().run(filePathRead, encoding, filePathWrite);
    }
}
