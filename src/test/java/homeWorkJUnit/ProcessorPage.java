package homeWorkJUnit;

import com.codeborne.selenide.ElementsCollection;
import com.codeborne.selenide.SelenideElement;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selenide.*;

public class ProcessorPage {
    private final ElementsCollection searchInputFill = $$x(".//input[@placeholder='Поиск по товарам']");
    private final ElementsCollection processorTypeAndName = $$x(".//a[contains (text(), 'Процессор AMD Ryzen')]");
    private final ElementsCollection productsPrices = $$x(".//div[@class='ProductCardVerticalCart__price-wrapper']");
    private final ElementsCollection price = $$x("//span[contains(@class, 'ProductCardVerticalPrice__price-current_current-price')]");

    public ProcessorPage() {
        open("/");
    }

    ProcessorPage fillProcessorNameForSearchInput(String processorType) {
        sleep(500);
        searchInputFill.get(1).setValue(processorType).submit();
        sleep(500);
        return this;
    }

    ProcessorPage checkProcessorTypeAndName(String processorType) {
        processorTypeAndName.find(text(processorType)).scrollIntoView(false).shouldHave(text(processorType));
        return this;
    }

    void checkProcessorPrice(String expectedPrice) {
        productsPrices.get(0).scrollIntoView("{behavior: 'instant', block: 'center', inline: 'center'}");
        price.get(1).shouldHave(text(expectedPrice));
    }
}
