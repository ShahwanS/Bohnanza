package org.bohnanza;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        BohnanzaRepositoryInterface repository = new BohnanzaRepository();

        // Get number of players
        int numberOfPlayers = repository.getNumberOfPlayers();

        List<Player> players = new ArrayList<>();

        // Initialize the VIP components
        BohnanzaViewInterface view = new BohnanzaView();
        BohnanzaInteractorInterface interactor = new BohnanzaInteractor(repository);
        BohnanzaPresenterInterface presenter = new BohnanzaPresenter();

        // Link components
        view.setInteractor(interactor);
        interactor.setPresenter(presenter);
        presenter.setView(view);

        // Initialize game data
        interactor.initializeGame(players);

        // Start the game
        presenter.startGame();

        scanner.close();
    }
}