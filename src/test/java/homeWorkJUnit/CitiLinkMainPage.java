package homeWorkJUnit;

import com.codeborne.selenide.ElementsCollection;
import com.codeborne.selenide.SelenideElement;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selenide.*;

public class CitiLinkMainPage {
    private final ElementsCollection filters = $$x(".//span[@class='css-1sylyko erq45vj0']");
    private final ElementsCollection citiesList = $$x(".//li[contains(@class, 'cities-list')]/a");
    private final SelenideElement tag = $x(".//div[@class='FilterTags__tag js--FilterTags__tag']/p");
    private final SelenideElement brandFilterTitle = $x("//span[text() = 'Бренд']");
    private final SelenideElement subcategoryTitle = $x(".//h1[text() = 'Ноутбуки']");
    private final SelenideElement citySelectButton = $x(".//div[contains(@class, 'city')]/button[contains(@class,'CitiesSearch')]");



    CitiLinkMainPage openCatalogNoteBookSubcategoryPage() {
        open("/catalog/noutbuki/");
        return this;
    }

    CitiLinkMainPage citySelectButton() {
        open("/");
        citySelectButton.click();
        return this;
    }

    void selectCityAndСheck(Cities city) {
        citiesList.find(text(city.getCity())).click();
        citySelectButton.shouldHave(text(city.getCity()));
    }



    CitiLinkMainPage selectBrandFromFilters(String brandName) {
        sleep(1000);
        brandFilterTitle.scrollIntoView("{behavior: 'instant', block: 'center', inline: 'center'}");
        filters.find(text(brandName)).ancestor("div").click();
        return this;
    }

    void checkTag(String brandName) {
        subcategoryTitle.scrollIntoView(false);
        tag.shouldHave(text(brandName));
    }
}
