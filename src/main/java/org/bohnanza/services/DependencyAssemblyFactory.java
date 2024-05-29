package org.bohnanza.services;

import org.bohnanza.repository.BohnanzaInteractor;
import org.bohnanza.repository.BohnanzaInteractorInterface;
import org.bohnanza.repository.BohnanzaRepository;
import org.bohnanza.repository.BohnanzaRepositoryInterface;
import org.bohnanza.services.servicesInterfaces.*;
import org.bohnanza.view.BohnanzaPresenter;
import org.bohnanza.view.BohnanzaPresenterInterface;
import org.bohnanza.view.BohnanzaView;
import org.bohnanza.view.BohnanzaViewInterface;

public class DependencyAssemblyFactory implements DependencyAssemblyFactoryInterface {
    @Override
    // Creates and returns a new BohnanzaRepository instance

    public BohnanzaRepositoryInterface createRepository() {
        return new BohnanzaRepository();
    }
    // Creates and returns a new Deck instance

    @Override
    public DeckServiceInterface createDeckService() {
        return new DeckService();
    }
    // Creates and returns a new PlayerService instance

    @Override
    public PlayerServiceInterface createPlayerService() {
        return new PlayerService();
    }
    // Creates and returns a new TradeService instance

    @Override
    public TradeServiceInterface createTradeService() {
        return new TradeService();
    }
    // Creates and returns a new PhaseService instance with the given services

    @Override
    public PhaseServiceInterface createPhaseService(PlayerServiceInterface playerService, DeckServiceInterface deckService, TradeServiceInterface tradeService) {
        return new PhaseService(playerService, deckService, tradeService);
    }
    // Creates and returns a new GameService instance

    @Override
    public GameServiceInterface createGameService() {
        return new GameService();
    }
    // Creates and returns a new BohnanzaInteractor instance with initialized dependencies

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
    // Creates and returns a new BohnanzaPresenter instance with the given view

    @Override
    public BohnanzaPresenterInterface createPresenter(BohnanzaViewInterface view) {
        return new BohnanzaPresenter(view);
    }
    // Creates and returns a new BohnanzaView instance

    @Override
    public BohnanzaViewInterface createView() {
        return new BohnanzaView();
    }
}