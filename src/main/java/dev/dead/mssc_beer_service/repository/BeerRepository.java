package dev.dead.mssc_beer_service.repository;

import java.util.UUID;

import org.springframework.data.repository.PagingAndSortingRepository;

import dev.dead.mssc_beer_service.domain.Beer;

public interface BeerRepository extends PagingAndSortingRepository<Beer, UUID> {

}
