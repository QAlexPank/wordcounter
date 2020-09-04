package ru.gb.at.wordcounter;

import ru.gb.at.wordcounter.service.WordCounterService;
import org.apache.commons.io.FileUtils;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.io.File;
import java.io.IOException;
import java.util.Map;

public class WordCounterTest {

    @Test
    public void bookTest() throws IOException {
        WordCounterService wordCounterService = new WordCounterService();
        String data = FileUtils.readFileToString(new File(this.getClass().getClassLoader().getResource("Dune.txt").getFile()), "cp1251");

        Map<String, Long> stringLongMap = wordCounterService.countWord(data);
        Assertions.assertEquals(329L, stringLongMap.get("Arrakis"));
    }



}
