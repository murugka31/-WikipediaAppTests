package com.emurugova.drivers;

import com.codeborne.selenide.WebDriverProvider;
import com.emurugova.config.BrowserstackConfig;
import io.appium.java_client.android.AndroidDriver;
import org.aeonbits.owner.ConfigFactory;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.remote.DesiredCapabilities;

import java.net.MalformedURLException;
import java.net.URL;

public class BrowserstackMobileDriver implements WebDriverProvider {
    public static BrowserstackConfig config = ConfigFactory.create(BrowserstackConfig.class);

    public static URL getBrowserstackUrl() {
        try {
            return new URL(config.getBrowserstackUrl());
        } catch (MalformedURLException e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public WebDriver createDriver(DesiredCapabilities desiredCapabilities) {

        desiredCapabilities.setCapability("browserstack.user", config.getBrowserstackUser());
        desiredCapabilities.setCapability("browserstack.key", config.getBrowserstackKey());
        desiredCapabilities.setCapability("app", "bs://c700ce60cf13ae8ed97705a55b8e022f13c5827c");
        desiredCapabilities.setCapability("device", "Google Pixel 3");
        desiredCapabilities.setCapability("os_version", "9.0");
        desiredCapabilities.setCapability("project", "WikipediaApp");
        desiredCapabilities.setCapability("build", "Java Android");
        desiredCapabilities.setCapability("name", "WikipediaApp Test");

        return new AndroidDriver(getBrowserstackUrl(), desiredCapabilities);
    }
}

