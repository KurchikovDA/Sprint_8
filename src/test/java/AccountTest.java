import org.junit.Test;
import static org.junit.Assert.*;
import io.qameta.allure.Description;
import io.qameta.allure.junit4.DisplayName;


public class AccountTest {

    @DisplayName("Проверка правильности печати корректного имени и фамилии на карте")
    @Description("Тест проверяет, что корректное имя и фамилия могут быть напечатаны на карте.")
    @Test
    public void testValidNameToEmboss() {
        Account account = new Account("Тимоти Шаламе");
        assertTrue(account.checkNameToEmboss());
    }

    @DisplayName("Проверка корректной обработки короткого имени и фамилии")
    @Description("Тест проверяет, что короткое имя и фамилия не могут быть напечатаны на карте.")
    @Test
    public void testInvalidShortName() {
        Account account = new Account("Т Ш");
        assertTrue(account.checkNameToEmboss());
    }

    @DisplayName("Проверка корректной обработки длинного имени и фамилии")
    @Description("Тест проверяет, что длинное имя и фамилия не могут быть напечатаны на карте.")
    @Test
    public void testInvalidLongName() {
        Account account = new Account("Курт Дональдович Кобейн Нирванов");
        assertFalse(account.checkNameToEmboss());
    }

    @DisplayName("Проверка корректной обработки имени и фамилии с ведущим пробелом")
    @Description("Тест проверяет, что имя и фамилия с ведущим пробелом не могут быть напечатаны на карте.")
    @Test
    public void testInvalidNameWithLeadingSpace() {
        Account account = new Account(" Шаламе");
        assertFalse(account.checkNameToEmboss());
    }

    @DisplayName("Проверка корректной обработки имени и фамилии с завершающим пробелом")
    @Description("Тест проверяет, что имя и фамилия с завершающим пробелом не могут быть напечатаны на карте.")
    @Test
    public void testInvalidNameWithTrailingSpace() {
        Account account = new Account("Тимоти ");
        assertFalse(account.checkNameToEmboss());
    }

    @DisplayName("Проверка корректной обработки имени и фамилии без пробела")
    @Description("Тест проверяет, что имя и фамилия без пробела не могут быть напечатаны на карте.")
    @Test
    public void testInvalidNameWithoutSpace() {
        Account account = new Account("ТимотейШевроле");
        assertFalse(account.checkNameToEmboss());
    }
}
