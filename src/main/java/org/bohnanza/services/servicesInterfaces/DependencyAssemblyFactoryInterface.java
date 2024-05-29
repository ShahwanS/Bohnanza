package org.bohnanza.services.servicesInterfaces;

import org.bohnanza.repository.BohnanzaInteractorInterface;
import org.bohnanza.view.BohnanzaPresenterInterface;
import org.bohnanza.repository.BohnanzaRepositoryInterface;
import org.bohnanza.view.BohnanzaViewInterface;

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