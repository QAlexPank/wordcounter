package ru.gb.at.wordcounter.controller;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import ru.gb.at.wordcounter.service.WordCounterService;

import java.util.Map;

@RestController
public class WordCounterController {

    private final WordCounterService wordCounterService;

    public WordCounterController(WordCounterService wordCounterService) {
        this.wordCounterService = wordCounterService;
    }


    @PostMapping("/wordCount")
    public WordCountResponse wordCounter(@RequestBody WordCountRequest wordCountRequest){

        Map<String, Long> stringLongMap = wordCounterService.countWord(wordCountRequest.getText());

        WordCountResponse response = new WordCountResponse();
        response.setIdRequest(wordCountRequest.getIdRequest());
        response.getMapCounts(stringLongMap);
        return response;
    }


}
