package org.bohnanza.services;

import org.bohnanza.model.Player;
import org.bohnanza.services.servicesInterfaces.TradeServiceInterface;

import java.util.List;

public class TradeService implements TradeServiceInterface {
    @Override
    public void trade(Player activePlayer, List<Player> players) {
        // Logic for trading cards
        System.out.println(activePlayer.getName() + " is trading.");
    }
}