package ru.gb.at.wordcounter;

import ru.gb.at.wordcounter.controller.WordCountRequest;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.ResultActions;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;

@SpringBootTest
@AutoConfigureMockMvc
class WordCounterApplicationTests {

    @Autowired
    MockMvc mockMvc;

    @Test
    void contextLoads() {
    }

    @Test
    void check() throws Exception {
        ObjectMapper objectMapper = new ObjectMapper();
        WordCountRequest wordCountRequest = new WordCountRequest(1L, "Grut! I am grut!");
        ResultActions result = mockMvc.perform(MockMvcRequestBuilders
                .post("/wordCount")
                .content(objectMapper.writerFor(WordCountRequest.class).writeValueAsString(wordCountRequest))
                .contentType("application/json")
        );


        result.andExpect(MockMvcResultMatchers.status().isOk());
        Assertions.assertThat(result.andReturn().getResponse().getContentAsString()).isEqualTo("{\"idRequest\":1}","mapCounts\":{\"i\":1,\"grut\":2,\"am\":1}}");

        result.andExpect(MockMvcResultMatchers.status().isOk());
        System.out.println(result.andReturn().getResponse().getContentAsString());
    }

}
