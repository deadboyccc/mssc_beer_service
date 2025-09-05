package dev.dead.mssc_beer_service.web.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import dev.dead.mssc_beer_service.web.model.BeerDto;

import java.util.UUID;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;

@RequestMapping("/api/v1/beer")
@RestController
public class BeerController {
  @GetMapping("/{beerId}")
  public ResponseEntity<BeerDto> getBearById(@PathVariable("beerId") UUID beerId) {
    // TODO imp
    return new ResponseEntity<>(null, HttpStatus.OK);
  }

  @PostMapping
  public ResponseEntity<BeerDto> saveNewBeer(@RequestBody BeerDto beerDto) {
    // TODO imp
    return new ResponseEntity<>(null, HttpStatus.CREATED);

  }

  @PutMapping("/{beerId}")
  public ResponseEntity<BeerDto> updateBeerById(@PathVariable("beerId") UUID beerId, @RequestBody BeerDto beerDto) {
    // TODO imp
    return new ResponseEntity<>(null, HttpStatus.NO_CONTENT);
  }
}
