/*
 * Copyright (c) by censhare AG
 */
package guru.sfg.beer.common.events;

/**
 * New inventory
 *
 * @author Martin Wunderlich
 */
public class NewInventoryEvent extends BeerEvent {

    public NewInventoryEvent(BeerDto beerDto) {
        super(beerDto);
    }
}
