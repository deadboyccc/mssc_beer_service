package dev.dead.mssc_beer_service.service;

import dev.dead.mssc_beer_service.domain.Beer;
import dev.dead.mssc_beer_service.repository.BeerRepository;
import dev.dead.mssc_beer_service.web.mapper.BeerMapper;
import dev.dead.mssc_beer_service.web.model.BeerDto;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.UUID;

@RequiredArgsConstructor
@Service
public class BeerServiceImpl implements BeerService {
    private final BeerRepository beerRepository;
    private final BeerMapper beerMapper;

    @Override
    public BeerDto getBearById(UUID beerId) {
        return beerMapper.beerToBeerDto(beerRepository.getReferenceById(beerId));
    }

    @Override
    public BeerDto createNewBeer(BeerDto beerDto) {
        return beerMapper.
                beerToBeerDto(beerRepository.save(beerMapper.beerDtoToBeer(beerDto)));
    }

    @Override
    public BeerDto updateBeer(UUID beerId, BeerDto beerDto) {
        Beer beer = beerRepository.getReferenceById(beerId);

        beer.setBeerName(beerDto.getBeerName());
        beer.setBeerStyle(String.valueOf(beerDto.getBeerStyle()));
        beer.setPrice(beerDto.getPrice());
        beer.setUpc(String.valueOf(beerDto.getUpc()));

        return beerMapper.beerToBeerDto(beerRepository.save(beer));
    }
}
