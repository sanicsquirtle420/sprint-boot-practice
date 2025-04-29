package com.raccoon2891.spring;

import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.web.servlet.MockMvc;
import static org.hamcrest.Matchers.equalTo;
import org.springframework.http.MediaType;
import org.junit.jupiter.api.Test;

@SpringBootTest
@AutoConfigureMockMvc
public class KirikoTest {
    @Autowired
    private MockMvc kiriko ;

    @Test
    public void helloTest() throws Exception {
        kiriko.perform(MockMvcRequestBuilders.get("/").accept(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk())
                .andExpect(content().string(equalTo("Let the kitsune guide you!\n")));
    }
}
