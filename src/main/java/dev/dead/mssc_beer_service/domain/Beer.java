package dev.dead.mssc_beer_service.domain;

import java.math.BigDecimal;
import java.sql.Timestamp;
import java.util.UUID;

import jakarta.persistence.*;
import lombok.*;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;
import org.hibernate.annotations.JdbcTypeCode;
import org.hibernate.type.SqlTypes;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Entity
@Table(name = "beer")
public class Beer {

  @Id
  @GeneratedValue
  @JdbcTypeCode(SqlTypes.CHAR) // store UUID as CHAR(36) in MySQL
  @Column(length = 36, updatable = false, nullable = false)
  private UUID id;

  @Version
  private Long version;

  @CreationTimestamp
  @Column(name = "created_date", nullable = false, updatable = false)
  private Timestamp createdDate;

  @UpdateTimestamp
  @Column(name = "last_modified_date")
  private Timestamp lastModifiedDate;

  @Column(name = "beer_name", nullable = false, length = 100)
  private String beerName;

  @Column(name = "beer_style", nullable = false, length = 50)
  private String beerStyle;

  @Column(unique = true, nullable = false)
  private String upc;

  @Column(nullable = false, precision = 10, scale = 2)
  private BigDecimal price;

  @Column(name = "min_on_hand")
  private Integer minOnHand;

  @Column(name = "quantity_to_brew")
  private Integer quantityToBrew;
}
