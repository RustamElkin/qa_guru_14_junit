package homeWorkJUnit;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.*;

import java.util.List;
import java.util.stream.Stream;

public class CitilinkParameterizedTests extends BaseTest {

    @ValueSource(strings = {"APPLE", "ASUS"})
    @ParameterizedTest(name = "Проверяем фильтр по Бренду в категории 'Ноутбуки и компьютеры' {0}")
    void selectFilterAndChekTag(String brandName) {
        new CitiLinkMainPage()
                .openCatalogNoteBookSubcategoryPage()
                .selectBrandFromFilters(brandName)
                .checkTag(brandName);
    }

    @CsvSource(value = {
            "AMD Ryzen 7 3700x, OEM| 15 890",
            "AMD Ryzen 7 3800x, BOX| 22 890"
    }, delimiter = '|')

    @ParameterizedTest(name = "Проверяем стоимость процессора {0} ценой: {1}")
    void priceOfProcessorsForDifferentTypes(String processorType, String expectedPrice) {
        new ProcessorPage()
                .fillProcessorNameForSearchInput(processorType)
                .checkProcessorTypeAndName(processorType)
                .checkProcessorPrice(expectedPrice);
    }

    static Stream<Arguments> CheckingForSubcategoriesInCategoriesTest() {
        return Stream.of(
                Arguments.of("Ноутбуки и компьютеры",
                        List.of("Ноутбуки", "Компьютеры и моноблоки", "Комплектующие для ПК", "Жесткие диски и SSD",
                                "Мониторы", "Игровые", "Сетевые хранилища NAS", "Оргтехника",
                                "Манипуляторы и устройства ввода", "Носители информации", "Защита питания",
                                "Сетевое оборудование", "Колонки для компьютера", "Web-камеры", "Наушники с микрофоном",
                                "Хабы, разветвители", "Серверы и СХД", "Программное обеспечение", "Подарочные сертификаты",
                                "Аксессуары для ноутбуков и ПК", "Платформы"
                        )),
                Arguments.of("Телевизоры, аудио-видео, фото",
                        List.of("Телевизоры", "OLED", "NEO QLED", "Техника Hi-Fi",
                                "Спутниковое и цифровое ТВ", "Видеотехника", "Аудиотехника", "Проекторы и экраны",
                                "LED панели", "Наушники", "Аксессуары для телевизоров",
                                "Музыкальные инструменты", "Кронштейны", "Кабели для ТВ и аудио-видео",
                                "Аксессуары для LFD-панелей", "Видеокамеры", "Фотоаппараты",
                                "Аксессуары для фото и видео", "Студийный свет"))

        );
    }
    @MethodSource("CheckingForSubcategoriesInCategoriesTest")
    @ParameterizedTest(name = "Проверяем наличие подкатегорий: {1}, в категориях: {0}")
    void CheckingForSubcategoriesInCategoriesTest(String category, List<String> expectedSubcategories) {
        new CatalogMenuPage()
                .checkCategoryFromCatalogMenu(category)
                .checkExpectedSubcategoriesFromTheList(expectedSubcategories);
    }

    @EnumSource
    @ParameterizedTest
    void enumCitySelectTest(Cities city) {
        new CitiLinkMainPage()
                .citySelectButton()
                .selectCityAndCheck(city);

    }
}
