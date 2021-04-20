package com.example.haba.selenium;

import static java.lang.String.format;
import static java.util.stream.Stream.of;
import static org.apache.commons.lang3.StringUtils.equalsIgnoreCase;

public enum Browser {

    CHROME("chrome", Browser.OS_NAME_PLACEHOLDER + "/chromedriver", "webdriver.chrome.driver"),
    FIREFOX("firefox", Browser.OS_NAME_PLACEHOLDER + "/geckodriver", "webdriver.gecko.driver"),
    SAFARI("safari", "/usr/bin/safaridriver", "webdriver.safari.driver"),
    EDGE("edge", Browser.OS_NAME_PLACEHOLDER + "/msedgedriver", "webdriver.edge.driver");

    private static final String OS_NAME_PLACEHOLDER = "$osname";
    private static final String DRIVERS_BASE_DIR = "selenium/driver";

    String name;
    String driverLocation;
    String driverProperty;

    Browser(String name, String driverLocation, String driverProperty) {
        this.name = name;
        this.driverLocation = driverLocation;
        this.driverProperty = driverProperty;
    }

    public static Browser get(String browserName) {
        return of(Browser.values())
                .filter(browser -> equalsIgnoreCase(browser.name(), browserName))
                .findFirst()
                .orElseThrow(() ->
                        new RuntimeException(format("[%s] browser does not match with any of types in the [%s] enum",
                                browserName, Browser.class.getSimpleName())));
    }

    public String getDriverPath() {
        OSType os = OSType.detect();

        switch (this) {
            case CHROME:
            case FIREFOX:
            case EDGE:
                return String.join("/",
                        DRIVERS_BASE_DIR,
                        driverLocation.replace(OS_NAME_PLACEHOLDER, os.name)
                                + os.executableExtension);
            case SAFARI:
                return driverLocation;

            default:
                throw new RuntimeException(format("Could not generate a path to driver for %s", this));
        }
    }
}

