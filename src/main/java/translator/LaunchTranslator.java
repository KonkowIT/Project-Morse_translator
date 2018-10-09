package translator;

import java.util.Scanner;

public class LaunchTranslator {
    public static void main(String[] args) {
        AlphabetToMorse alphabetToMorse = new AlphabetToMorse();
        AlphabetToLetters alphabetToLetters = new AlphabetToLetters();
        String typedIn;

        System.out.println("Type in what You want to translate:");
        System.out.println("(Remember: after letter use space, after word use '|')");
        Scanner type = new Scanner(System.in);
        typedIn = type.nextLine();

        char[] typedLetters = typedIn.toLowerCase().toCharArray();

        if (typedLetters[0] == '.' || typedLetters[0] == '-'){
            String morseCode = "";
            String word = "";
            String sentence = "";

            for (char code : typedLetters) {
                if (code != ' ' && code != '|') {
                    morseCode += code;
                } else if(code == ' '){
                    char letter = alphabetToLetters.searchMorse(morseCode);
                    word += letter;
                    morseCode = "";
                } else if(code == '|'){
                    sentence += word + " ";
                    morseCode = "";
                    word = "";
                }
            }
            System.out.println(sentence);

        } else {

            String result = "";
            for (char letter : typedLetters) {
                String check = alphabetToMorse.searchLetter(letter);
                if (check == null) {
                    System.out.println("You can only use characters from ASCII standard! Try once again");
                    System.exit(0);
                }
                if (!(letter == ' ')){
                    result += check + " ";
                } else {
                    result += check;
                }
            }
            result += "|";

            System.out.println(result);
        }
    }
}
