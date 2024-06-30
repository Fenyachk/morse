package morse;

import java.util.*;

public class MorseTranslate {
    private static final Map<Character, String> morseMap = new HashMap<>();
    private static final Map<String, Character> reverseMorseMap = new HashMap<>();

    static {
        morseMap.put('a', ".-");
        morseMap.put('b', "-...");
        morseMap.put('c', "-.-.");
        morseMap.put('d', "-..");
        morseMap.put('e', ".");
        morseMap.put('f', "..-.");
        morseMap.put('g', "--.");
        morseMap.put('h', "....");
        morseMap.put('i', "..");
        morseMap.put('j', ".---");
        morseMap.put('k', "-.-");
        morseMap.put('l', ".-..");
        morseMap.put('m', "--");
        morseMap.put('n', "-.");
        morseMap.put('o', "---");
        morseMap.put('p', ".--.");
        morseMap.put('q', "--.-");
        morseMap.put('r', ".-.");
        morseMap.put('s', "...");
        morseMap.put('t', "-");
        morseMap.put('u', "..-");
        morseMap.put('v', "...-");
        morseMap.put('w', ".--");
        morseMap.put('x', "-..-");
        morseMap.put('y', "-.--");
        morseMap.put('z', "--..");

        for (Map.Entry<Character, String> entry : morseMap.entrySet()) {
            reverseMorseMap.put(entry.getValue(), entry.getKey());
        }
    }
    private static String encode(Character morse) {
        return morseMap.getOrDefault(morse, "");
    }
    private static String decode(String morse) {
        return reverseMorseMap.getOrDefault(morse, '?').toString();
    }
    public static String getMorseCode(String text) {
        StringBuilder morseCode = new StringBuilder();
        if (text.matches(".*[a-zA-Z].*"))
        {
            text = text.toLowerCase();
            for (char c : text.toCharArray()) {
                morseCode.append(encode(c));
                morseCode.append(' ');
            }
        }
        else
        {
            String[] words = text.trim().split("\\s");
            for (String word : words) {
                morseCode.append(decode(word));
                morseCode.append(' ');
            }
        }
        return morseCode.toString();
    }
}
