package org.bohnanza;

import java.util.List;

public class TradeService implements TradeServiceInterface {
    @Override
    public void trade(Player activePlayer, List<Player> players) {
        // Logic for trading cards
        System.out.println(activePlayer.getName() + " is trading.");
    }
}