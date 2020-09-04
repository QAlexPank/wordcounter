package ru.gb.at.wordcounter.service;

import org.springframework.stereotype.Service;

import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
public class WordCounterService {

    public Map<String, Long> countWord(String input) {

        List<String> listStrings = Arrays.asList(input.toLowerCase().split("\\W+"));
        Map<String, Long> result = new HashMap<>();
        for (String el : listStrings) {
            if (result.containsKey(el)) {
                Long currentCount = result.get(el);
                result.put(el, currentCount + 1);
            } else {
                result.put(el, 1L);
            }
        }
        return result;
    }

}
