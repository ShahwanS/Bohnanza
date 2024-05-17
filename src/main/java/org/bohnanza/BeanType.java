package org.bohnanza;

//fill up an enum with a card type the amount of cards in the deck and the payouts for the amount of cards in the field
public enum BeanType {
    GARTEN_BOHNE("GartenBohne", 6, new int[] { 0, 0, 2, 3, 4 }),
    ROTE_BOHNE("RoteBohne", 8, new int[] { 0, 0, 3, 4, 5 }),
    AUGEN_BOHNE("AugenBohne", 10, new int[] { 0, 0, 4, 5, 6 }),
    SOJA_BOHNE("SojaBohne", 12, new int[] { 0, 0, 4, 6, 7 }),
    BRECHEN_BOHNE("BrechenBohne", 14, new int[] { 0, 0, 5, 6, 7 }),
    FIRE_BOHNE("Saubohne", 16, new int[] { 0, 0, 5, 7, 8 }),
    FEUER_BOHNE("FeuerBohne", 18, new int[] { 0, 0, 6, 8, 9 }),
    BLAU_BOHNE("FeuerBohne", 20, new int[] { 0, 0, 6, 8, 9 });

    private final String displayName;
    private final int cardCount;
    private final int[] payouts;

    BeanType(String displayName, int cardCount, int[] payouts) {
        this.displayName = displayName;
        this.cardCount = cardCount;
        this.payouts = payouts;
    }

    public String getDisplayName() {
        return displayName;
    }

    public int getCardCount() {
        return cardCount;
    }

    public int getPayout(int count) {
        if (count < payouts.length) {
            return payouts[count];
        } else {
            return 0;

        }
    }
}
