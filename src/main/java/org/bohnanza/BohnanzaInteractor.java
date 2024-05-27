package org.bohnanza;

import java.util.List;

public class BohnanzaInteractor implements BohnanzaInteractorInterface {
    private BohnanzaRepositoryInterface repository;
    private BohnanzaPresenterInterface presenter;
    private GameServiceInterface gameService;
    private PhaseServiceInterface phaseService;

    public BohnanzaInteractor(DependencyAssemblyFactoryInterface factory) {
        this.repository = factory.createRepository();
        this.gameService = factory.createGameService();
        DeckServiceInterface deckService = factory.createDeckService();
        PlayerServiceInterface playerService = factory.createPlayerService();
        TradeServiceInterface tradeService = factory.createTradeService();
        this.phaseService = factory.createPhaseService(playerService, deckService, tradeService);
    }

    @Override
    public void setPresenter(BohnanzaPresenterInterface presenter) {
        this.presenter = presenter;
    }

    @Override
    public void initializeGame(List<Player> players) {
        int numPlayers = repository.getNumberOfPlayers();
        repository.generateInitialGameData(numPlayers);
        players.addAll(repository.getPlayers());
        gameService.initializeGame(players, new DeckService(), GameVersion.STANDARD);
    }

    @Override
    public boolean executePlayerTurn(Player player) {
        gameService.playTurn(player, phaseService, repository.getPlayers());
        if (presenter != null) {
            presenter.presentUpdatedData(player);
        }
        return true;
    }

    @Override
    public void updatePlayers(List<Player> players) {
        repository.savePlayers(players);
    }

    @Override
    public List<Player> getPlayers() {
        return repository.getPlayers();
    }

    @Override
    public BohnanzaRepositoryInterface getRepository() {
        return repository;
    }

    @Override
    public GameServiceInterface getGameService() {
        return gameService;
    }

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