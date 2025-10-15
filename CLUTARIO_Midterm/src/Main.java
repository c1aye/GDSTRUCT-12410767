import java.util.Random;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        CardStack playerDeck = new CardStack();
        CardStack playerHand = new CardStack();
        CardStack discardPile = new CardStack();

        // create deck of 30 cards
        String[] cardNames = {
                "Ace of Spades", "Two of Spades", "Three of Spades", "Four of Spades", "Five of Spades",
                "Six of Hearts", "Seven of Hearts", "Eight of Hearts", "Nine of Hearts", "Ten of Hearts",
                "Jack of Clubs", "Queen of Clubs", "King of Clubs",
                "Ace of Diamonds", "Two of Diamonds", "Three of Diamonds", "Four of Diamonds",
                "Five of Diamonds", "Six of Diamonds", "Seven of Diamonds",
                "Eight of Diamonds", "Nine of Diamonds", "Ten of Diamonds",
                "Jack of Spades", "Queen of Spades", "King of Spades",
                "Joker Red", "Joker Black", "Dragon Card", "Phoenix Card"
        };

        for (int i = 0; i < 30; i++) {
            playerDeck.push(new Card(i, cardNames[i]));
        }

        Random rand = new Random();
        Scanner sc = new Scanner(System.in);
        int turn = 1;

        System.out.println("=== GDSTRUCT MIDTERM : CARD GAME START ===");

        // Game loop
        while (!playerDeck.isEmpty()) {
            System.out.println("\n--- TURN " + turn + " ---");

            int command = rand.nextInt(3);
            int x = rand.nextInt(5) + 1;

            switch (command) {
                case 0: // draw from deck
                    System.out.println("Command: Draw " + x + " card(s)");
                    for (int i = 0; i < x; i++) {
                        if (playerDeck.isEmpty()) {
                            System.out.println("No more cards left in the deck!");
                            break;
                        }
                        Card drawn = playerDeck.pop();
                        playerHand.push(drawn);
                        System.out.println("Drew: " + drawn);
                    }
                    break;

                case 1: // discard
                    System.out.println("Command: Discard " + x + " card(s)");
                    for (int i = 0; i < x; i++) {
                        if (playerHand.isEmpty()) {
                            System.out.println("No cards in hand to discard!");
                            break;
                        }
                        Card discarded = playerHand.pop();
                        discardPile.push(discarded);
                        System.out.println("Discarded: " + discarded);
                    }
                    break;

                case 2: // draw from discard
                    System.out.println("Command: Get " + x + " card(s) from discard pile");
                    for (int i = 0; i < x; i++) {
                        if (discardPile.isEmpty()) {
                            System.out.println("No cards in discard pile!");
                            break;
                        }
                        Card retrieved = discardPile.pop();
                        playerHand.push(retrieved);
                        System.out.println("Retrieved: " + retrieved);
                    }
                    break;
            }

            // game loop display
            System.out.println("\nPlayer Hand:");
            playerHand.displayStack();

            System.out.println("\nCards remaining in deck: " + playerDeck.size());
            System.out.println("Cards in discard pile: " + discardPile.size());

            System.out.println("\nPress ENTER to proceed to next turn...");
            sc.nextLine();
            turn++;
        }

        System.out.println("\n=== GAME OVER ===");
        System.out.println("The deck is now empty!");
        sc.close();
    }
}
