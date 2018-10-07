package translator;

import java.util.Scanner;

class App {

    void app(){
        Alphabet alphabet = new Alphabet();
        String typedIn;

        System.out.println("Type in what You want to translate:");
        Scanner type = new Scanner(System.in);
        typedIn = type.nextLine();

        char[] typedLetters = typedIn.toLowerCase().toCharArray();
        String result = "";
        for (char letter : typedLetters){
            String check = alphabet.searchLetter(letter);
            if (check == null) {
                System.out.println("You can only use characters from ASCII standard! Try once again");
                System.exit(0);
            }
            result = result + check;
        }

        System.out.println(result);
    }

}
