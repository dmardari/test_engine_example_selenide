package com.example.haba.pageobject;

import com.codeborne.selenide.Condition;
import com.codeborne.selenide.Driver;
import com.codeborne.selenide.ElementsCollection;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.springframework.stereotype.Component;

import static com.codeborne.selenide.Selenide.*;
import static org.openqa.selenium.By.xpath;

@Component
public class ProductListPage extends PageTemplate {

    public ElementsCollection products() {
        return $$(xpath("//li[contains(@class, 'product-tile')]"));
    }

    public ElementsCollection inStockProducts() {
        return products()
                .filter(new Condition("in stock products") {
                    @Override
                    public boolean apply(Driver driver, WebElement element) {
                        return element.findElements(By.xpath(".//*[contains(@class, 'item_inStock')]")).size() > 0;
                    }
                });
    }
}
