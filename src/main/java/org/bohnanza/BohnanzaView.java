package org.bohnanza;

import java.util.Scanner;

public class BohnanzaView {
    public String messages;
    private Scanner scanner;

    public BohnanzaView() {
        this.scanner = new Scanner(System.in);
    }

    // Display a drawn card
    public void displayCardDrawn(String cardInfo) {
        System.out.println("Card drawn: " + cardInfo);
    }

    // Display a shuffled deck
    public void displayDeckShuffled() {
        System.out.println("Deck shuffled.");
    }

    // Display a card added to a field
    public void displayCardAddedToField(String cardInfo, String fieldName) {
        System.out.println("Card " + cardInfo + " added to field " + fieldName + ".");
    }

    // Display an exchange offer
    public void displayExchangeOffer(String offerInfo) {
        System.out.println("Exchange offer: " + offerInfo);
    }

    // Receive user input
    public String receiveUserInput() {
        System.out.print("Enter your action: ");
        return scanner.nextLine();
    }

    // Close scanner when done
    public void closeScanner() {
        scanner.close();
    }
}