import java.util.Scanner;

public class Main {
    public static void main(String[] args){
        System.out.println("Enter your name: ");
        Scanner reader = new Scanner(System.in);

        String name = reader.next();
        System.out.println("Hello " + name + "!");
    }
}
