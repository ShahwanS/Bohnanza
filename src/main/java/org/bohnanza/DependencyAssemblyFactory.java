package org.bohnanza;

public class DependencyAssemblyFactory implements DependencyAssemblyFactoryInterface {
    @Override
    public BohnanzaRepositoryInterface createRepository() {
        return new BohnanzaRepository();
    }

    @Override
    public DeckServiceInterface createDeckService() {
        return new DeckService();
    }

    @Override
    public PlayerServiceInterface createPlayerService() {
        return new PlayerService();
    }

    @Override
    public TradeServiceInterface createTradeService() {
        return new TradeService();
    }

    @Override
    public PhaseServiceInterface createPhaseService(PlayerServiceInterface playerService, DeckServiceInterface deckService, TradeServiceInterface tradeService) {
        return new PhaseService(playerService, deckService, tradeService);
    }

    @Override
    public GameServiceInterface createGameService() {
        return new GameService();
    }

    @Override
    public BohnanzaInteractorInterface createInteractor() {
        BohnanzaRepositoryInterface repository = createRepository();
        DeckServiceInterface deckService = createDeckService();
        PlayerServiceInterface playerService = createPlayerService();
        TradeServiceInterface tradeService = createTradeService();
        PhaseServiceInterface phaseService = createPhaseService(playerService, deckService, tradeService);
        GameServiceInterface gameService = createGameService();
        BohnanzaInteractorInterface interactor = new BohnanzaInteractor(this);
        BohnanzaPresenterInterface presenter = createPresenter(createView());
        interactor.setPresenter(presenter);
        return interactor;
    }

    @Override
    public BohnanzaPresenterInterface createPresenter(BohnanzaViewInterface view) {
        return new BohnanzaPresenter(view);
    }

    @Override
    public BohnanzaViewInterface createView() {
        return new BohnanzaView();
    }
}