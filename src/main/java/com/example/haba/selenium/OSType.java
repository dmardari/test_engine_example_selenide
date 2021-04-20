package com.example.haba.selenium;

import static java.lang.String.format;

public enum OSType {

    // TODO 20/04/2021: consider M1 macos as a separate OS in future
    WINDOWS("windows", ".exe"),
    MAC("macos", ""),
    LINUX("linux", "");

    String name;
    String executableExtension;

    OSType(String name, String executableExtension) {
        this.name = name;
        this.executableExtension = executableExtension;
    }

    public static OSType detect() {
        String osName = System.getProperty("os.name").toLowerCase();
        if (osName.contains("win")) {
            return WINDOWS;
        } else if (osName.contains("nix") || osName.contains("nux")) {
            return LINUX;
        } else if (osName.contains("mac")) {
            return MAC;
        } else {
            throw new RuntimeException(format("[%s] OS does not match with any of types in the [%s] enum",
                    osName, OSType.class.getSimpleName()));
        }
    }
}

