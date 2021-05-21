package com.example.haba.steps;

import com.example.haba.pageobject.MainPage;
import com.example.haba.pageobject.ProductListPage;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import org.springframework.beans.factory.annotation.Autowired;

import static com.example.haba.utils.RandomUtils.getRandomItem;

public class AtlasSteps { // TODO: 19.05.2021 rename me

    @Autowired
    MainPage mainPage;

    @Autowired
    ProductListPage productListPage;


    @Given("main page is opened")
    public void mainPageIsOpened() {
        mainPage.visit();
    }

    @And("welcome popup is closed")
    public void welcomePopupIsClosed() {
        if (mainPage.welcomeElement().isDisplayed())
            mainPage.welcomeToHabaBannerClose().click();
    }

    @And("cookies popup is closed")
    public void cookiesPopupIsClosed() {
        if (mainPage.welcomeElement().isDisplayed()) {
            mainPage.acceptAllCookiesButton().click();
        }
    }

    @Given("random navigation button is pressed")
    public void randomNavigationButtonIsPressed() {
        getRandomItem(mainPage.navigationButtons()).click();
    }

    @And("random available product tile is pressed")
    public void randomProductTileIsPressed() {
        getRandomItem(productListPage.inStockProducts()).click();
    }
}
