/*
 * Copyright (c) by censhare AG
 */
package guru.sfg.beer.common.events;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * beer event
 *
 * @author Martin Wunderlich
 */
@Data
@AllArgsConstructor
@Builder
@NoArgsConstructor
public class BeerEvent {

    static final long serialVersionUID = 5333452867634730824L;

    private BeerDto beerDto;
}
