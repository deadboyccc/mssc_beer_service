package dev.dead.mssc_beer_service.web.model;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.json.JsonTest;

import java.math.BigDecimal;
import java.time.OffsetDateTime;
import java.util.UUID;

@Slf4j
@JsonTest
class BeerDtoJacksonTest {
    @Autowired
    ObjectMapper objectMapper;
    private BeerDto validBeer;

    @BeforeEach
    void setUp() {
        validBeer = BeerDto.builder()
                .id(UUID.randomUUID())
                .beerName("Test Beer")
                .createdDate(OffsetDateTime.now())
                .lastModified(OffsetDateTime.now())
                .beerStyle(BeerStyleEnum.ALE)
                .price(BigDecimal.valueOf(2.99))
                .upc(123456789012L)
                .build();
    }

    @Test
    void testSerializeDto() throws JsonProcessingException {
        var serial = objectMapper.writeValueAsString(validBeer);
        log.debug(serial.toUpperCase());
        System.out.println(serial);


    }

    @Test
    void testDeserialize() throws JsonProcessingException {
        String jsonString = "{\"beerId\":\"6d00a010-b648-4bf3-ba11-ef7ff6afae0d\",\"version\":null,\"createdDate\":\"2025-09-07T21:33:33.974881548+03:00\",\"lastModified\":\"2025-09-07T21:33:33.974917599+03:00\",\"beerName\":\"Test Beer\",\"beerStyle\":\"ALE\",\"upc\":123456789012,\"price\":2.99,\"quantityOnHand\":null}";
        BeerDto beerDto = objectMapper.readValue(jsonString, BeerDto.class);
        System.out.println(beerDto.getBeerName() + " : " + beerDto.getBeerStyle().toString());
        System.out.println(beerDto);
        System.out.println(beerDto);
        System.out.println(beerDto);
    }
}


























