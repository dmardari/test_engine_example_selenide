package com.example.haba.steps;

import com.example.haba.pageobject.MainPage;
import com.example.haba.pageobject.MainSite;
import com.example.haba.pageobject.ProductListPage;
import com.example.haba.pageobject.elements.ProductTile;
import com.example.haba.selenium.AtlasService;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.qameta.atlas.webdriver.ElementsCollection;
import org.openqa.selenium.By;
import org.springframework.beans.factory.annotation.Autowired;

import static com.example.haba.utils.RandomUtils.getRandomItem;

public class AtlasSteps {

    @Autowired
    AtlasService atlasService;

    @Given("main page is opened")
    public void mainPageIsOpened() {
        MainSite site = atlasService.get(MainSite.class);
        site.mainPage().open();
    }

    @Then("main page contains header")
    public void mainPageContainsHeader() {
        MainSite site = atlasService.get(MainSite.class);
        site.mainPage().header().isDisplayed();
    }

    @And("welcome popup is closed")
    public void welcomePopupIsClosed() {
        MainPage mainPage = atlasService.get(MainSite.class).mainPage();
        if (mainPage.findElements(By.xpath("//*[@id = 'cssLightbox']")).size() > 0)
            mainPage.welcomeToHabaBannerClose().click();
    }

    @And("cookies popup is closed")
    public void cookiesPopupIsClosed() {
        MainPage mainPage = atlasService.get(MainSite.class).mainPage();
        if (mainPage.findElements(By.xpath("//button[@id = 'onetrust-accept-btn-handler']")).size() > 0)
            mainPage.acceptAllCookiesButton().click();
    }

    @Given("random navigation button is pressed")
    public void randomNavigationButtonIsPressed() {
        MainPage mainPage = atlasService.get(MainSite.class).mainPage();
        getRandomItem(mainPage.navigationButtons()).click(); // TODO 20/04/2021: investigate extention functions
    }

    @And("random available product tile is pressed")
    public void randomProductTileIsPressed() {
        ProductListPage productListPage = atlasService.get(ProductListPage.class);
        ElementsCollection<ProductTile> availableItems = productListPage.products()
                .filter(item -> item.findElements(By.xpath(".//*[contains(@class, 'item_inStock')]")).size() > 0);
        getRandomItem(availableItems).click(); // TODO 20/04/2021: investigate extention functions
    }
}
