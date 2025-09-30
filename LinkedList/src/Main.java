public class Main {
    public static void main(String[] args){
        PlayerLinkedList playerLinkedList = new PlayerLinkedList();

        //initial list
        playerLinkedList.addToFront(new Player(1, "Jeya", 12));
        playerLinkedList.addToFront(new Player(2, "Raf", 13));
        playerLinkedList.addToFront(new Player(3, "Ela", 14));
        playerLinkedList.addToFront(new Player(4, "Rhy", 15));

        //prints initial list
        playerLinkedList.printLinkedList();

        //prints size
        System.out.println("\nList Size: " + playerLinkedList.size());

        //removing first element
        System.out.println("\nRemoved first element: \n" + playerLinkedList.removePlayer());

        //re-print
        System.out.println("\nAfter removing first:");
        playerLinkedList.printLinkedList();
        System.out.println("\n\nList Size: " + playerLinkedList.size());

        //checker
        boolean contains = playerLinkedList.contains(new Player(1, "Jeya", 12));
        System.out.println("\nList has Jeya? " + contains);

        //finds the index of a specific element
        int index = playerLinkedList.indexOf(new Player(1, "Jeya", 12));
        System.out.println("\nIndex of Jeya? " + index);


    }
}
