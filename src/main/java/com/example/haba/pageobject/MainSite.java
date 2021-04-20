package com.example.haba.pageobject;

import io.qameta.atlas.webdriver.extension.Page;

public interface MainSite extends PageTemplate {

    @Page()
    MainPage mainPage();

    @Page(url = "/cart")
    CartPage cartPage();

    ProductListPage productListPage();

    ProductPage productPage();
}