package org.bohnanza;

import java.util.List;

public class BohnanzaInteractor implements BohnanzaInteractorInterface {
    private BohnanzaRepositoryInterface repository;
    private BohnanzaPresenterInterface presenter;

    public BohnanzaInteractor(BohnanzaRepositoryInterface repository) {
        this.repository = repository;
    }

    @Override
    public void setPresenter(BohnanzaPresenterInterface presenter) {
        this.presenter = presenter;
    }

    @Override
    public void initializeGame(List<Player> players) {
        repository.generateInitialGameData(players.size());
        players.addAll(repository.getPlayers());
    }

    @Override
    public boolean executePlayerTurn(Player player) {
        // Simulated turn logic here
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
}