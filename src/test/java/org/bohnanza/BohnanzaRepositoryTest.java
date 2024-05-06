package org.bohnanza;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;
import java.io.ByteArrayInputStream;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.List;

class BohnanzaRepositoryTest {
    private BohnanzaRepository repository;

    @BeforeEach
    void setUp() {

        repository = new BohnanzaRepository();
    }

    @Test
    void getNumberOfPlayers() {
        repository.generateInitialGameData(3);
        int numberOfPlayers = repository.getNumberOfPlayers();
        assertEquals(3, numberOfPlayers, "The number of players should be 3.");
    }

    @Test
    void generateInitialGameData() {
        repository.generateInitialGameData(3);
        assertNotNull(repository.getFields(), "Fields should not be null after initialization.");
        assertEquals(3, repository.getFields().size(), "There should be 3 fields initialized for 3 players.");
        assertFalse(repository.getFields().get(0).getCards().isEmpty(), "Each field should have cards after initialization.");
    }

    @Test
    void getDeck() {
        assertNotNull(repository.getDeck(), "Deck should not be null.");
    }

    @Test
    void getFields() {
        repository.generateInitialGameData(3);
        assertEquals(3, repository.getFields().size(), "Should retrieve the list of 3 fields.");
    }

    @Test
    void saveDeck() {
        Deck newDeck = new Deck();
        repository.saveDeck(newDeck);
        assertSame(newDeck, repository.getDeck(), "The saved deck should be the same as the new deck.");
    }

    @Test
    void saveFields() {
        List<Field> newFields = new ArrayList<>();
        newFields.add(new Field("Field A"));
        newFields.add(new Field("Field B"));
        newFields.add(new Field("Field C"));
        repository.saveFields(newFields);
        assertSame(newFields, repository.getFields(), "The saved fields should be the same as the new fields.");
    }
}
