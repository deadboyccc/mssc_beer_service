package dev.dead.mssc_beer_service.web.model;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonProperty;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Null;
import jakarta.validation.constraints.Positive;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;
import java.time.OffsetDateTime;
import java.util.UUID;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class BeerDto {

  @Null
  @JsonProperty("beerId")
  private UUID id;
  @Null
  private Integer version;

  @Null
//  @JsonFormat(pattern = "yyyy-MM-dd",shape = JsonFormat.Shape.STRING)
  private OffsetDateTime createdDate;

    @Null
  private OffsetDateTime lastModified;

  @NotBlank
  private String beerName;

    @NotNull
  private BeerStyleEnum beerStyle;

  @NotNull
  @Positive
  private Long upc;

    @NotNull
  @Positive
    @JsonFormat(shape = JsonFormat.Shape.STRING)
  private BigDecimal price;
  private Integer quantityOnHand;
}
