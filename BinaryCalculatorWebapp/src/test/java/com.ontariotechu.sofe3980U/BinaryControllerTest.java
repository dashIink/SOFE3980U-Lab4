package com.ontariotechu.sofe3980U;

import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.test.web.servlet.MockMvc;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;

import org.junit.runner.RunWith;

import org.junit.*;
import org.junit.runner.*;
import org.springframework.beans.factory.annotation.*;
import org.springframework.boot.test.context.*;
import org.springframework.boot.test.mock.mockito.*;
import org.springframework.test.context.junit4.*;

import static org.hamcrest.Matchers.containsString;

import static org.assertj.core.api.Assertions.*;
import static org.mockito.BDDMockito.*;

@RunWith(SpringRunner.class)
@WebMvcTest(BinaryController.class)
public class BinaryControllerTest {

    @Autowired
    private MockMvc mvc;

   
    @Test
    public void getDefault() throws Exception {
        this.mvc.perform(get("/"))//.andDo(print())
            .andExpect(status().isOk())
            .andExpect(view().name("calculator"))
            .andExpect(model().attribute("operand1", ""))
            .andExpect(model().attribute("operand1Focused", false));
    }
    
    @Test
    public void getParameter() throws Exception {
        this.mvc.perform(get("/").param("operand1","111"))
            .andExpect(status().isOk())
            .andExpect(view().name("calculator"))
            .andExpect(model().attribute("operand1", "111"))
            .andExpect(model().attribute("operand1Focused", true));
    }


    @Test
        public void postParameter() throws Exception {
        this.mvc.perform(post("/").param("operand1","111").param("operator","+").param("operand2","111"))//.andDo(print())
            .andExpect(status().isOk())
            .andExpect(view().name("result"))
            .andExpect(model().attribute("result", "1110"))
            .andExpect(model().attribute("operand1", "111"));
    }


    @Test
    public void postParameter1() throws Exception {
        this.mvc.perform(post("/").param("operand1", "1110").param("operator", "*").param("operand2", "0010"))
                .andExpect(status().isOk())
                .andExpect(view().name("result"))
                .andExpect(model().attribute("result", "11100"))
                .andExpect(model().attribute("operand1", "1110"));
    }

    @Test
    public void postParameter2() throws Exception {
        this.mvc.perform(post("/").param("operand1","1001").param("operator","+").param("operand2","0110"))//.andDo(print())
            .andExpect(status().isOk())
            .andExpect(view().name("result"))
            .andExpect(model().attribute("result", "1111"))
            .andExpect(model().attribute("operand1", "1001"));
    }

    @Test
    public void postParameter3() throws Exception {
        this.mvc.perform(post("/").param("operand1", "0110").param("operator", "*").param("operand2", "0110"))
                .andExpect(status().isOk())
                .andExpect(view().name("result"))
                .andExpect(model().attribute("result", "100100"))
                .andExpect(model().attribute("operand1", "0110"));
    }

    @Test
    public void postParameter4() throws Exception {
        this.mvc.perform(post("/").param("operand1", "1010").param("operator", "|").param("operand2", "1001"))
            .andExpect(status().isOk())
            .andExpect(view().name("result"))
            .andExpect(model().attribute("result", "1011"))
            .andExpect(model().attribute("operand1", "1010"));
    }

    @Test
    public void postParameter5() throws Exception {
        this.mvc.perform(post("/").param("operand1", "1010").param("operator", "+").param("operand2", "1001"))
            .andExpect(status().isOk())
            .andExpect(view().name("result"))
            .andExpect(model().attribute("result", "10011"))
            .andExpect(model().attribute("operand1", "1010"))
            .andExpect(model().attribute("operand2", "1001"))
            .andExpect(model().attribute("operator", "+"));
    }

    @Test
    public void postParameter6() throws Exception {
        this.mvc.perform(post("/").param("operand1", "10101").param("operator", "+").param("operand2", "10001"))
            .andExpect(status().isOk())
            .andExpect(view().name("result"))
            .andExpect(model().attribute("result", "100110"))
            .andExpect(model().attribute("operand1", "10101"))
            .andExpect(model().attribute("operand2", "10001"))
            .andExpect(model().attribute("operator", "+"));
    }

    @Test
    public void postParameter7() throws Exception {
        this.mvc.perform(post("/").param("operand1", "101").param("operator", "+").param("operand2", "101"))
            .andExpect(status().isOk())
            .andExpect(view().name("result"))
            .andExpect(model().attribute("result", "1010"))
            .andExpect(model().attribute("operand1", "101"))
            .andExpect(model().attribute("operand2", "101"))
            .andExpect(model().attribute("operator", "+"));
    }
}