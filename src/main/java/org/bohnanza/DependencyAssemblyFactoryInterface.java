package org.bohnanza;

public interface DependencyAssemblyFactoryInterface {
    BohnanzaRepositoryInterface createRepository();
    DeckServiceInterface createDeckService();
    PlayerServiceInterface createPlayerService();
    TradeServiceInterface createTradeService();
    PhaseServiceInterface createPhaseService(PlayerServiceInterface playerService, DeckServiceInterface deckService, TradeServiceInterface tradeService);
    GameServiceInterface createGameService();
    BohnanzaInteractorInterface createInteractor();
    BohnanzaPresenterInterface createPresenter(BohnanzaViewInterface view);
    BohnanzaViewInterface createView();
}