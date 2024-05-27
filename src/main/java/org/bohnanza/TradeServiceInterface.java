package org.bohnanza;

import java.util.List;

public interface TradeServiceInterface {
    void trade(Player activePlayer, List<Player> players);
}