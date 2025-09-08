package dev.dead.mssc_beer_service.web.controller;

import dev.dead.mssc_beer_service.service.BeerService;
import dev.dead.mssc_beer_service.web.model.BeerDto;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.UUID;

@RequestMapping("/api/v1/beer")
@RestController
@RequiredArgsConstructor
public class BeerController {
    private final BeerService beerService;

    @GetMapping("/{beerId}")
    public ResponseEntity<BeerDto> getBearById(@PathVariable("beerId") UUID beerId) {
        return new ResponseEntity<>(beerService.getBearById(beerId), HttpStatus.OK);
    }

    @PostMapping
    public ResponseEntity<BeerDto> saveNewBeer(@Valid @RequestBody BeerDto beerDto) {
        return new ResponseEntity<>(beerService.createNewBeer(beerDto), HttpStatus.CREATED);

    }

    @PutMapping("/{beerId}")
    public ResponseEntity<BeerDto> updateBeerById(@PathVariable("beerId") UUID beerId,
                                                  @Valid @RequestBody BeerDto beerDto) {
        return new ResponseEntity<>(beerService.updateBeer(beerId, beerDto), HttpStatus.NO_CONTENT);
    }
}
