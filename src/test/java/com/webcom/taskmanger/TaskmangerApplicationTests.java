package com.webcom.taskmanger;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;


@SpringBootTest
@AutoConfigureMockMvc
class TaskmangerApplicationTests {

    @Autowired
    private MockMvc mockMvc;

    @Test
    void getNamesTest() throws Exception {
        mockMvc.perform(get("/task-set/get-task-sets"))
                .andExpect(status().isOk());

    }

    @Test
    void saveTaskSetTest() throws Exception {
        String saveJson="{\"name\": \"test\"}";
        mockMvc.perform(post("/task-set/save")
                .content(saveJson)
                .contentType(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk());
    }
}
