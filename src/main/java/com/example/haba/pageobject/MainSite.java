package com.example.haba.pageobject;

import io.qameta.atlas.webdriver.WebSite;
import io.qameta.atlas.webdriver.extension.Page;


public interface MainSite extends WebSite {

    @Page()
    MainPage mainPage();

    @Page(url = "/cart")
    CartPage cartPage();
}