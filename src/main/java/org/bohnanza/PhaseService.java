package org.bohnanza;

import java.util.List;

import java.util.List;

public class PhaseService implements PhaseServiceInterface {
    private PlayerServiceInterface playerService;
    private DeckServiceInterface deckService;
    private TradeServiceInterface tradeService;

    public PhaseService(PlayerServiceInterface playerService, DeckServiceInterface deckService, TradeServiceInterface tradeService) {
        this.playerService = playerService;
        this.deckService = deckService;
        this.tradeService = tradeService;
    }

    @Override
    public void executePlantPhase(Player player) {
        System.out.println(player.getName() + " is planting beans.");
        if (!player.getHand().isEmpty()) {
            Card card = player.getHand().get(0);
            playerService.plantBean(player, card, 0); // Assuming the first field is chosen for simplicity
        }
    }

    @Override
    public void executeTradePhase(Player activePlayer, List<Player> players) {
        playerService.executeTrade(activePlayer, players, tradeService);
    }

    @Override
    public void executePlantAllPlayersPhase(List<Player> players) {
        for (Player player : players) {
            if (!player.getHand().isEmpty()) {
                Card card = player.getHand().get(0);
                playerService.plantBean(player, card, 0); // Assuming the first field is chosen for simplicity
            }
        }
    }

    @Override
    public void executeDrawPhase(Player player) {
        System.out.println(player.getName() + " is drawing 3 cards.");
        playerService.drawCards(player, deckService, 3);
    }
}