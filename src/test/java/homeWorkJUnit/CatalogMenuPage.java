package homeWorkJUnit;

import com.codeborne.selenide.ElementsCollection;

import java.util.List;

import static com.codeborne.selenide.CollectionCondition.texts;
import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selenide.$$x;
import static com.codeborne.selenide.Selenide.open;

public class CatalogMenuPage {
    private final ElementsCollection catalogMenuCategories = $$x(".//a[contains(@class, 'CatalogMenu__category-item')]");
    private final ElementsCollection catalogMenuSubcategories = $$x(".//a[contains(@class, 'CatalogCategoryCard__link')]");

    public CatalogMenuPage() {
        open("/#catalog");
    }

    CatalogMenuPage checkCategoryFromCatalogMenu(String category) {
        catalogMenuCategories.find(text(category)).click();
        return this;
    }

    void checkExpectedSubcategoriesFromTheList(List<String> expectedSubcategories) {
//        for (SelenideElement element : catalogMenuSubcategories) {
//            element.scrollIntoView(false);
////            System.out.println(element.getText());
//        }
        catalogMenuSubcategories.shouldBe(texts(expectedSubcategories));
    }


}
