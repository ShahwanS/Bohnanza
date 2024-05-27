package org.bohnanza;

public interface DeckServiceInterface {
    void initializeDeck();
    void shuffle();
    Card draw();
}