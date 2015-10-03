import java.util.ArrayList;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {

        Players amy = new Players("Amy", 10, 20);
        System.out.println(amy.toString());
        savedObject(amy);

        amy.setHitPoints(30);
        System.out.println(amy);
        amy.setWeapons("Mace");
        System.out.println(amy);
        savedObject(amy);
        loadObject(amy);
        System.out.println(amy);

    }




    public static ArrayList<String> readValues() {

        ArrayList<String> values = new ArrayList<String>();

        Scanner scanner = new Scanner(System.in);

        boolean quit = false;

        int index = 0;

        System.out.println("Choose\n" +
                "1 to enter a string\n" +
                "0 to quit");


        while(!quit) {
            System.out.println("Choose an option:");

            int choice = scanner.nextInt();

            switch(choice) {
                case 0:
                    quit = true;
                    break;

                case 1:
                    System.out.println("Enter a string:");
                    String stringInput = scanner.nextLine();
                    values.add(index, stringInput);
                    index++;
                    break;
                }
        }
        return readValues();
    }



    public static void savedObject(IGame objectToSave) {
        for(int i=0; i<objectToSave.write().size(); i++) {
            System.out.println("Saving " + objectToSave.write().get(i) + " to storage device");
        }
    }



    public static void loadObject(IGame objectToLoad) {
        ArrayList<String> values = readValues();
        objectToLoad.read(values);

    }



}
