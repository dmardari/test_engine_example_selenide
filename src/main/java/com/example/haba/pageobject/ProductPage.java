package com.example.haba.pageobject;

import com.codeborne.selenide.SelenideElement;
import org.springframework.stereotype.Component;

import static com.codeborne.selenide.Selenide.*;
import static org.openqa.selenium.By.xpath;

@Component
public class ProductPage extends PageTemplate {
    public SelenideElement addToCartButton() {
        return $(xpath("//button[@id = 'addToCartButton']"));
    }

    public SelenideElement productTitle() {
        return $(xpath("//div[contains(@class, 'product-title')]"));
    }
}
