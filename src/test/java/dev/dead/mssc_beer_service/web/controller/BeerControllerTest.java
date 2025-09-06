package dev.dead.mssc_beer_service.web.controller;

import com.fasterxml.jackson.databind.ObjectMapper;
import dev.dead.mssc_beer_service.web.model.BeerDto;
import dev.dead.mssc_beer_service.web.model.BeerStyleEnum;
import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;

import java.math.BigDecimal;
import java.util.UUID;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@Slf4j
@WebMvcTest(BeerController.class)
class BeerControllerTest {

  @Autowired
  ObjectMapper objectMapper;

  @Autowired
  MockMvc mockMvc;

  private BeerDto validBeer;

  @BeforeEach
  void setUp() {
    validBeer = BeerDto.builder()
        .beerName("Test Beer")
        .beerStyle(BeerStyleEnum.ALE)
        .price(BigDecimal.valueOf(2.99))
        .upc(123456789012L)
        .quantityOnHand(50)
        .build();
  }

  @Test
  void testGetBeerById() throws Exception {
      log.debug("testing get beer by id");
    mockMvc.perform(get("/api/v1/beer/" + UUID.randomUUID())
        .accept(MediaType.APPLICATION_JSON))
        .andExpect(status().isOk());
  }

  @Test
  void saveNewBeer() throws Exception {
      log.debug("testing save beer");
    String beerDtoJson = objectMapper.writeValueAsString(validBeer);

    mockMvc.perform(post("/api/v1/beer")
        .contentType(MediaType.APPLICATION_JSON)
        .content(beerDtoJson))
        .andExpect(status().isCreated());
  }

  @Test
  void updateBeerById() throws Exception {
      log.debug("testing update beer by id");
    String beerDtoJson = objectMapper.writeValueAsString(validBeer);

    mockMvc.perform(put("/api/v1/beer/" + UUID.randomUUID())
        .contentType(MediaType.APPLICATION_JSON)
        .content(beerDtoJson))
        .andExpect(status().isNoContent());
  }
}
