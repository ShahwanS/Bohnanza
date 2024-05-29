package org.bohnanza.services;

import org.bohnanza.model.Card;
import org.bohnanza.model.Player;
import org.bohnanza.services.servicesInterfaces.DeckServiceInterface;
import org.bohnanza.services.servicesInterfaces.PhaseServiceInterface;
import org.bohnanza.services.servicesInterfaces.PlayerServiceInterface;
import org.bohnanza.services.servicesInterfaces.TradeServiceInterface;

import java.util.List;

public class PhaseService implements PhaseServiceInterface {
    private PlayerServiceInterface playerService;
    private DeckServiceInterface deckService;
    private TradeServiceInterface tradeService;

    // Constructor to initialize services
    public PhaseService(PlayerServiceInterface playerService, DeckServiceInterface deckService, TradeServiceInterface tradeService) {
        this.playerService = playerService;
        this.deckService = deckService;
        this.tradeService = tradeService;
    }

    // Executes the planting phase for a player
    @Override
    public void executePlantPhase(Player player) {
        System.out.println(player.getName() + " is planting beans.");
        if (!player.getHand().isEmpty()) {
            Card card = player.getHand().get(0);
            playerService.plantBean(player, card, 0); // Assuming the first field is chosen for simplicity
        }
    }

    // Executes the trading phase for the active player and other players
    @Override
    public void executeTradePhase(Player activePlayer, List<Player> players) {
        playerService.executeTrade(activePlayer, players, tradeService);
    }

    // Executes the planting phase for all players
    @Override
    public void executePlantAllPlayersPhase(List<Player> players) {
        for (Player player : players) {
            if (!player.getHand().isEmpty()) {
                Card card = player.getHand().get(0);
                playerService.plantBean(player, card, 0); // Assuming the first field is chosen for simplicity
            }
        }
    }

    // Executes the drawing phase for a player
    @Override
    public void executeDrawPhase(Player player) {
        System.out.println(player.getName() + " is drawing 3 cards.");
        playerService.drawCards(player, deckService, 3);
    }
}
