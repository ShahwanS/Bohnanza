package org.bohnanza.repository;

import org.bohnanza.model.Card;
import org.bohnanza.model.GameVersion;
import org.bohnanza.model.Player;
import org.bohnanza.services.DeckService;
import org.bohnanza.services.servicesInterfaces.*;
import org.bohnanza.view.BohnanzaPresenterInterface;

import java.util.List;

public class BohnanzaInteractor implements BohnanzaInteractorInterface {
    // Dependencies for repository, presenter, game service, and phase service
    private BohnanzaRepositoryInterface repository;
    private BohnanzaPresenterInterface presenter;
    private GameServiceInterface gameService;
    private PhaseServiceInterface phaseService;

    // Constructor initializes dependencies using a factory
    public BohnanzaInteractor(DependencyAssemblyFactoryInterface factory) {
        this.repository = factory.createRepository();
        this.gameService = factory.createGameService();
        DeckServiceInterface deckService = factory.createDeckService();
        PlayerServiceInterface playerService = factory.createPlayerService();
        TradeServiceInterface tradeService = factory.createTradeService();
        this.phaseService = factory.createPhaseService(playerService, deckService, tradeService);
    }

    // Sets the presenter
    @Override
    public void setPresenter(BohnanzaPresenterInterface presenter) {
        this.presenter = presenter;
    }

    // Initializes the game with the given players
    @Override
    public void initializeGame(List<Player> players) {
        int numPlayers = repository.getNumberOfPlayers();
        repository.generateInitialGameData(numPlayers);
        players.addAll(repository.getPlayers());
        gameService.initializeGame(players, new DeckService(), GameVersion.STANDARD);
    }

    // Executes a player's turn and updates the presenter
    @Override
    public boolean executePlayerTurn(Player player) {
        gameService.playTurn(player, phaseService, repository.getPlayers());
        if (presenter != null) {
            presenter.presentUpdatedData(player);
        }
        return true;
    }

    // Updates the repository with the current players list
    @Override
    public void updatePlayers(List<Player> players) {
        repository.savePlayers(players);
    }

    // Retrieves the current list of players from the repository
    @Override
    public List<Player> getPlayers() {
        return repository.getPlayers();
    }

    // Returns the repository instance
    @Override
    public BohnanzaRepositoryInterface getRepository() {
        return repository;
    }

    // Returns the game service instance
    @Override
    public GameServiceInterface getGameService() {
        return gameService;
    }

    // Plants a bean card in the specified field for the appropriate player
    @Override
    public void plantBean(Card card, int fieldIndex) {
        for (Player player : repository.getPlayers()) {
            if (player.getHand().contains(card)) {
                player.plantBean(card, fieldIndex);
                presenter.presentUpdatedData(player);
                break;
            }
        }
    }
}
