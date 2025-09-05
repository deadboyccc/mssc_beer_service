package dev.dead.mssc_beer_service.web.controller;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import java.util.UUID;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.test.web.servlet.MockMvc;

@WebMvcTest(BeerController.class)
public class BeerControllerTest {

  @Autowired
  MockMvc mockMvc;

  @Test
  void testGetBearById() throws Exception {
    mockMvc.perform(get("/api/v1/beer/" + UUID.randomUUID().toString())
        .accept(org.springframework.http.MediaType.APPLICATION_JSON))
        .andExpect(status().isOk());

  }

  @Test
  void testSaveNewBeer() {

  }

  @Test
  void testUpdateBeerById() {

  }
}
