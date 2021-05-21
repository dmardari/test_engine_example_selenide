package com.example.haba.pageobject;

import com.codeborne.selenide.ElementsCollection;
import com.codeborne.selenide.SelenideElement;
import org.springframework.stereotype.Component;

import static com.codeborne.selenide.Selenide.*;
import static java.lang.String.format;
import static org.openqa.selenium.By.xpath;

@Component
public class CartPage extends PageTemplate {
    public SelenideElement emptyCartBlock() {
        return $(xpath("//div[contains(@class, 'empty-cart')]"));
    }

    public ElementsCollection productItems() {
        return $$(xpath("//li[contains(@id, 'productItem')]"));
    }

    public SelenideElement productItem(String productName) {
        return $(xpath(format("//li[contains(@id, 'productItem')]//*[contains(@class, 'name') and normalize-space() = '%s']", productName)));
    }

    public SelenideElement productItemRemoveButton(String productName) {
        return productItem(productName).find(".//*[contains(@class, 'remove-item-btn')]");
    }

    public SelenideElement alertInfo() {
        return $(xpath("//div[contains(@class, 'alert-info')]"));
    }
}