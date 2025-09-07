package dev.dead.mssc_beer_service.web.model;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.json.JsonTest;
import org.springframework.test.context.ActiveProfiles;

import java.math.BigDecimal;
import java.time.OffsetDateTime;
import java.util.UUID;

@ActiveProfiles("snake")
@JsonTest
public class BeerDtoSnakeTest {

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
    void testSnake() throws JsonProcessingException {
        String json = objectMapper.writeValueAsString(validBeer);
        System.out.println(json);
    }
}
