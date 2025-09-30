public class PlayerLinkedList {
    private PlayerNode head;
    private int size;

    public void addToFront(Player player){
        PlayerNode newNode = new PlayerNode(player);
        newNode.setNextPlayerNode(head);
        head = newNode;
        size++;
    }

    public Player removePlayer(){
        if (head == null){
            return null;
        }
        Player removedPlayer = head.getPlayer();
        head = head.getNextPlayerNode();
        size--;
        return removedPlayer;
    }

    public int size(){
        return size;
    }

    //check if player exists in list
    public boolean contains(Player player){
        PlayerNode current = head;
        while (current != null){
            if (current.getPlayer().equals(player)){
                return true;
            }
            current = current.getNextPlayerNode();
        }
        return false;
    }

    public int indexOf(Player player){
        PlayerNode current = head;
        int index = 0;
        while (current != null){
            if (current.getPlayer().equals(player)){
                return index;
            }
            current = current.getNextPlayerNode();
            index++;
        }
        return -1;
    }

    public void printLinkedList(){
        System.out.print("[HEAD] -> ");
        PlayerNode current = head;

        while (current != null){
            System.out.print(current.getPlayer() + " -> ");
            current = current.getNextPlayerNode();
        }

        System.out.print("NULL");
    }
}

