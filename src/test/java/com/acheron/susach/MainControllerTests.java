package com.acheron.susach;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;

import java.util.Collections;
import java.util.Optional;

import static org.mockito.Mockito.when;

@WebMvcTest(MainController.class)
public class MainControllerTests {

    @Autowired
    private MockMvc mockMvc;

    @MockBean
    private EntityRepo repo;

    @MockBean
    private ValueRepo valueRepo;

    @MockBean
    private ValueGenerator generator;

    @MockBean
    private ValueMapper mapper;

    @Test
    public void testHome() throws Exception {
        when(repo.findAll()).thenReturn(Collections.emptyList());

        mockMvc.perform(MockMvcRequestBuilders.get("/"))
                .andExpect(MockMvcResultMatchers.status().isOk())
                .andExpect(MockMvcResultMatchers.model().attributeExists("users"))
                .andExpect(MockMvcResultMatchers.view().name("index"));
    }

    @Test
    public void testAddUser() throws Exception {
        when(repo.findAll()).thenReturn(Collections.emptyList());

        mockMvc.perform(MockMvcRequestBuilders.post("/addUser")
                        .param("email", "test@example.com"))
                .andExpect(MockMvcResultMatchers.status().is3xxRedirection())
                .andExpect(MockMvcResultMatchers.redirectedUrl("/"));
    }

    @Test
    public void testFindById() throws Exception {
        User user = new User(1, "test@example.com");
        when(repo.findById(1)).thenReturn(Optional.of(user));
        when(valueRepo.findValuesByUser(user)).thenReturn(Collections.emptyList());
        when(mapper.convert(Mockito.any())).thenReturn(new ValueDto());

        mockMvc.perform(MockMvcRequestBuilders.get("/user/{id}", 1))
                .andExpect(MockMvcResultMatchers.status().isOk())
                .andExpect(MockMvcResultMatchers.model().attributeExists("values"))
                .andExpect(MockMvcResultMatchers.model().attributeExists("user"))
                .andExpect(MockMvcResultMatchers.model().attributeExists("mapper"))
                .andExpect(MockMvcResultMatchers.model().attributeExists("sum"))
                .andExpect(MockMvcResultMatchers.view().name("user"));
    }
}
