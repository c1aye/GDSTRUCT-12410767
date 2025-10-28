public class Main {
    public static void main(String[] args){
        Player pikachu = new Player(25, "Pikachu", 25);
        Player celebi = new Player(251, "Celebi", 251);
        Player gengar = new Player(189, "Gengar", 28);
        Player starmie = new Player(58, "Starmie", 14);
        Player mankey = new Player(71, "Mankey", 99);
        Player lapras = new Player(83, "Lapras", 971);

        SimpleHashtable hashtable = new SimpleHashtable();

        hashtable.put(pikachu.getUsername(), pikachu);
        hashtable.put(celebi.getUsername(), celebi);
        hashtable.put(gengar.getUsername(), gengar);
        hashtable.put(starmie.getUsername(), starmie);
        hashtable.put(mankey.getUsername(), mankey);
        hashtable.put(lapras.getUsername(), lapras);

        hashtable.printHashtable();

        //removing

        hashtable.remove("Gengar");
        System.out.println("\nAfter removing Gengar:\n");
        hashtable.printHashtable();
    }

}
