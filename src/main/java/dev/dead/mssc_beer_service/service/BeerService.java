package dev.dead.mssc_beer_service.service;

import dev.dead.mssc_beer_service.web.model.BeerDto;
import jakarta.validation.Valid;

import java.util.UUID;

public interface BeerService {
    BeerDto getBearById(UUID beerId);

    BeerDto createNewBeer(@Valid BeerDto beerDto);

    BeerDto updateBeer(UUID beerId, @Valid BeerDto beerDto);
}
