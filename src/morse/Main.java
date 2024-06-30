package morse;


import java.util.*;

public class Main {
    public static void main(String[] args) {
        var scanner = new Scanner(System.in);
        System.out.println("Введите текст для перевода:");
        String text = scanner.nextLine();
        String morseCode = MorseTranslate.getMorseCode(text);
        System.out.println("Translate '" + text + "': " + morseCode);
    }
}