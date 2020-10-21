import java.util.HashMap;
import java.util.Map;

/**
 * Абстрактный класс с методами для подсчёта количества вхождений слов в строке
 */
public abstract class WordsFrequency {

    /**
     * Знаки пунктуации, за исключением тире
     */
    private static final String PUNCTUATION =
            "!\"#$%&'()*+,/:<=>.;?@[\\]^_`{|}~";

    /**
     * Удаление пунктуации в строке
     * @param line строка
     * @return строка без пунктуации
     */
    public static String removePunctuation(String line) {
        StringBuilder result = new StringBuilder(line.length());
        for (int i = 0; i < line.length(); i++) {
            char symbol = line.charAt(i);
            if (PUNCTUATION.indexOf(symbol) != -1) {
                result.append(" ");
                continue;
            }
            result.append(symbol);
        }
        return result.toString();
    }

    /**
     * Количество слов в поступающей на вход строке
     * @param line строка
     * @return мэп со словами и количеством их вхождений
     */
    public static Map<String, Integer> wordsFreq(String line) {
        String updatedLine = removePunctuation(line);
        Map<String, Integer> words = new HashMap<>();
        for (String word : updatedLine.split("\\s+")) {
            if (word.equals("") || word.equals("-")) {
                continue;
            }
            String curWord = word.toLowerCase();
            if (words.computeIfPresent(curWord,(key,value) -> value + 1) == null) {
                words.put(curWord,1);
            }
        }
        return words;
    }
}
