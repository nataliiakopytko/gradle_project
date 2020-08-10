package com.wikipedia.core.browser;

import com.hometask.hometask2.PropertiesLoader;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.Point;

public class Browser extends BrowserInit {
    private static ThreadLocal<BrowserWaiter> browserWaiter = new ThreadLocal<>();

    public static BrowserWaiter waiter() {
        if (browserWaiter.get() == null) browserWaiter.set(new BrowserWaiter());
        return browserWaiter.get();
    }

    public static void setBrowserSize() {
        int width = Integer.parseInt(PropertiesLoader.getBrowserWidth());
        int height = Integer.parseInt(PropertiesLoader.getBrowserHeight());
        logger.info(String.format("Setting up browser width to '%s' px and height to '%s' px", width, height));
        getDriver().manage().window().setSize(new Dimension(width, height));
    }

    public static void setBrowserPosition() {
        logger.info("Setting up browser position to 0.0 point");
        getDriver().manage().window().setPosition(new Point(0, 0));
    }
}