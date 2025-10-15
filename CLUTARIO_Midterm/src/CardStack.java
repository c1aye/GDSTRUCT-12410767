import java.util.LinkedList;

public class CardStack {
    private LinkedList<Card> stack;

    public CardStack() {
        stack = new LinkedList<>();
    }

    public void push(Card card) {
        stack.push(card); // add to top
    }

    public Card pop() {
        if (!isEmpty()) {
            return stack.pop(); // remove from top
        }
        return null;
    }

    public Card peek() {
        return stack.peek(); // view top card
    }

    public boolean isEmpty() {
        return stack.isEmpty();
    }

    public int size() {
        return stack.size();
    }

    public void displayStack() {
        if (stack.isEmpty()) {
            System.out.println("[Empty]");
        } else {
            for (Card card : stack) {
                System.out.println(" - " + card);
            }
        }
    }
}
