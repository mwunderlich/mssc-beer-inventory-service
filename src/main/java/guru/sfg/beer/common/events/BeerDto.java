/*
 * Copyright (c) by censhare AG
 */
package guru.sfg.beer.common.events;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.validation.constraints.*;
import java.io.Serializable;
import java.math.BigDecimal;
import java.time.OffsetDateTime;
import java.util.UUID;

/**
 * Beer object
 *
 * @author Martin Wunderlich
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class BeerDto implements Serializable {

    static final long serialVersionUID = -2574155613564323149L;

    @Null
    private UUID id;

    @Null
    private Integer version;

    @Null
    @JsonFormat(pattern = "yyyy-MM-dd'T'hh:mm:ssZ", shape = JsonFormat.Shape.STRING)
    private OffsetDateTime createdDate;

    @Null
    @JsonFormat(pattern = "yyyy-MM-dd'T'hh:mm:ssZ", shape = JsonFormat.Shape.STRING)
    private OffsetDateTime lastmodifiedDate;

    @NotNull
    @Size(min=3, max = 100)
    private String beerName;

    @NotBlank
    private String beerStyle;

    @NotNull
    private String upc;

    @JsonFormat(shape = JsonFormat.Shape.STRING)
    @NotNull
    @Positive
    private BigDecimal price;

    private Integer quantityOnHand;
}
