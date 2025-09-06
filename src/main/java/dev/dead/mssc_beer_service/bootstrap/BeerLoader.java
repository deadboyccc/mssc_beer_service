package dev.dead.mssc_beer_service.bootstrap;

import dev.dead.mssc_beer_service.domain.Beer;
import dev.dead.mssc_beer_service.web.model.BeerStyleEnum;
import dev.dead.mssc_beer_service.repository.BeerRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import java.math.BigDecimal;
import java.util.List;

@Slf4j
@RequiredArgsConstructor
@Component
public class BeerLoader implements CommandLineRunner {

  public static final String BEER_1_UPC = "0631234200036";
  public static final String BEER_2_UPC = "0631234300019";
  public static final String BEER_3_UPC = "0083783375213";

  private final BeerRepository beerRepository;

  @Override
  @Transactional
  public void run(String... args) {
    if (beerRepository.count() == 0) {
      log.info("🍺 Loading initial beer data...");
      loadBeerObjects();
      log.info("✅ Beer data loaded. Total beers in DB: {}", beerRepository.count());
    } else {
      log.info("✅ Beer data already exists. Skipping bootstrap.");
    }
  }

  private void loadBeerObjects() {
    Beer b1 = Beer.builder()
        .beerName("Mango Bobs")
        .beerStyle("IPA") // string now
        .minOnHand(12)
        .quantityToBrew(200)
        .price(BigDecimal.valueOf(12.95))
        .upc(BEER_1_UPC)
        .build();

    Beer b2 = Beer.builder()
        .beerName("Galaxy Cat")
        .beerStyle("PALE_ALE")
        .minOnHand(12)
        .quantityToBrew(200)
        .price(BigDecimal.valueOf(12.95))
        .upc(BEER_2_UPC)
        .build();

    Beer b3 = Beer.builder()
        .beerName("Pinball Porter")
        .beerStyle("PALE_ALE")
        .minOnHand(12)
        .quantityToBrew(200)
        .price(BigDecimal.valueOf(12.95))
        .upc(BEER_3_UPC)
        .build();

    beerRepository.saveAll(List.of(b1, b2, b3));
    System.out.println("Beer Count: " + beerRepository.count());
  }

}
