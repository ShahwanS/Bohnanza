package org.bohnanza.services.servicesInterfaces;

import org.bohnanza.model.Card;

public interface DeckServiceInterface {
    void initializeDeck();
    void shuffle();
    Card draw();
}