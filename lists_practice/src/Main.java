import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        List<Player> playerList = new ArrayList<Player>();
        playerList.add(new Player(1, "Ela", 67));
        playerList.add(new Player(2, "Jeya", 17));
        playerList.add(new Player(3, "Raf", 38));

        System.out.println("All current players: \n");
        for(Player player : playerList){
            System.out.println(player);
        }

        //added element
        System.out.println("Adding a new player, Rhy: \n");
        playerList.add(2, new Player(4, "Rhy", 4));

        //removed element/player
        playerList.remove(1);

        System.out.println("\n");
        System.out.println("Player at index 2: " + playerList.get(2));

        System.out.println("All current players: \n");
        for(Player player : playerList){
            System.out.println(player);
        }

        //checks if player object is in list
        boolean contains = playerList.contains(new Player(1,"Ela", 67));