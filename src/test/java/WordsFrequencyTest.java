import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.HashMap;
import java.util.Map;

public class WordsFrequencyTest {

    private String line;
    Map<String, Integer> words;
    Map<String, Integer> expected;

    @BeforeEach
    public void init() {
        expected = new HashMap<>();
    }

    /**
     * Стандартный тест на количество вхождений; без нюансов
     */
    @DisplayName("Trivial test")
    @Test
    public void trivialTest() {

        line = "И псевдонаучная гиперреальность создана дилетантским " +
                "недопрофессионализмом и высокоразвитой фантазией";
        words = WordsFrequency.wordsFreq(line);
        expected.put("и", 2);
        expected.put("псевдонаучная", 1);
        expected.put("гиперреальность",1);
        expected.put("создана",1);
        expected.put("дилетантским",1);
        expected.put("недопрофессионализмом",1);
        expected.put("высокоразвитой",1);
        expected.put("фантазией",1);
        Assertions.assertEquals(expected, words);
    }

    /**
     * Буквы разных регистров
     */
    @DisplayName("Test for different cases of letters")
    @Test
    public void letterCasesTest() {
        line = "Да да Я я Дублирую дублирую Слова слова Для для Этого этого Теста теста";
        words = WordsFrequency.wordsFreq(line);
        expected.put("да", 2);
        expected.put("я", 2);
        expected.put("дублирую", 2);
        expected.put("слова", 2);
        expected.put("для", 2);
        expected.put("этого", 2);
        expected.put("теста", 2);
        Assertions.assertEquals(expected, words);
    }

    /**
     * Особые случаи пробелов, включая мультипробелы,
     * пробелы в начале и в конце строки
     */
    @DisplayName("Test for special cases of whitespace")
    @Test
    public void specialSpacesTest() {
        line = " Хотелось бы поблагодарить сотрудников зоопарка    " +
                "за ежедневную уборку за больным диареей слоном   ";
        words = WordsFrequency.wordsFreq(line);
        expected.put("хотелось", 1);
        expected.put("бы", 1);
        expected.put("поблагодарить", 1);
        expected.put("сотрудников",1);
        expected.put("зоопарка", 1);
        expected.put("за", 2);
        expected.put("ежедневную", 1);
        expected.put("уборку", 1);
        expected.put("больным",1);
        expected.put("диареей", 1);
        expected.put("слоном", 1);
        Assertions.assertEquals(expected, words);
    }

    /**
     * Особые случаи знаков препинания
     */
    @DisplayName("Test for special cases of punctuation")
    @Test
    public void punctuationTest() {
        line = "Я...не...могу...так...больше...жить..." +
                "хватит...терпеть...первые...пары...это...зло!@#*%&!";
        words = WordsFrequency.wordsFreq(line);
        expected.put("я", 1);
        expected.put("не", 1);
        expected.put("могу", 1);
        expected.put("так", 1);
        expected.put("больше", 1);
        expected.put("жить", 1);
        expected.put("хватит", 1);
        expected.put("терпеть", 1);
        expected.put("первые", 1);
        expected.put("пары", 1);
        expected.put("это", 1);
        expected.put("зло", 1);
        Assertions.assertEquals(expected, words);
    }

    @DisplayName("Test for dashes and hyphens")
    @Test
    public void dashTest() {
        line = "Кое-что меня в этой паре напрягало - наверное, то, что её не было";
        words = WordsFrequency.wordsFreq(line);
        expected.put("кое-что", 1);
        expected.put("меня",1);
        expected.put("в", 1);
        expected.put("этой",1);
        expected.put("паре",1);
        expected.put("напрягало",1);
        expected.put("наверное",1);
        expected.put("то",1);
        expected.put("что",1);
        expected.put("её",1);
        expected.put("не",1);
        expected.put("было",1);
        Assertions.assertEquals(expected, words);
    }
}
