/*
 * Copyright (c) by censhare AG
 */
package guru.sfg.beer.inventory.service.services;

import guru.sfg.beer.common.events.BeerDto;
import guru.sfg.beer.common.events.NewInventoryEvent;
import guru.sfg.beer.inventory.service.config.JmsConfig;
import guru.sfg.beer.inventory.service.domain.BeerInventory;
import guru.sfg.beer.inventory.service.repositories.BeerInventoryRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.jms.annotation.JmsListener;
import org.springframework.jms.core.JmsTemplate;
import org.springframework.stereotype.Component;

import javax.transaction.Transactional;

/**
 * JMS Listener
 *
 * @author Martin Wunderlich
 */
@Component
@RequiredArgsConstructor
@Slf4j
public class AddBeerListener {

    private final BeerInventoryRepository beerInventoryRepository;
    private final JmsTemplate jmsTemplate;

    @Transactional
    @JmsListener(destination = JmsConfig.NEW_INVENTORY_QUEUE)
    public void listen(NewInventoryEvent event) {
        BeerDto beerDto = event.getBeerDto();

        beerInventoryRepository.save(BeerInventory.builder()
                .beerId(event.getBeerDto().getId())
                .upc(event.getBeerDto().getUpc())
                .quantityOnHand(event.getBeerDto().getQuantityOnHand())
                .build()
        );

        log.debug("Beer stored: " + beerDto);
    }
}
