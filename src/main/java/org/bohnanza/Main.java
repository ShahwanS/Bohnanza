package org.bohnanza;

import org.bohnanza.model.Player;
import org.bohnanza.repository.BohnanzaInteractorInterface;
import org.bohnanza.services.DependencyAssemblyFactory;
import org.bohnanza.services.servicesInterfaces.DependencyAssemblyFactoryInterface;
import org.bohnanza.view.BohnanzaPresenterInterface;
import org.bohnanza.view.BohnanzaViewInterface;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // Initialize the factory
        DependencyAssemblyFactoryInterface factory = new DependencyAssemblyFactory();

        // Create dependencies
        BohnanzaInteractorInterface interactor = factory.createInteractor();
        BohnanzaViewInterface view = factory.createView();
        BohnanzaPresenterInterface presenter = factory.createPresenter(view);

        // Link components
        view.setInteractor(interactor);
        interactor.setPresenter(presenter);
        presenter.setView(view);

        List<Player> players = new ArrayList<>();
        // Initialize game data
        interactor.initializeGame(players);

        // Start the game
        presenter.startGame();

        // Play turns for each player
        for (Player player : players) {
            interactor.executePlayerTurn(player);
        }

        // Determine and announce the winner
        Player winner = interactor.getGameService().determineWinner(players);
        System.out.println("The winner is: " + winner.getName());

        scanner.close();
    }
}