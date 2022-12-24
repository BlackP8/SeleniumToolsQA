package framework.driver;

import framework.utilities.config_utility.ConfigManager;
import org.openqa.selenium.WebDriver;

import java.util.concurrent.TimeUnit;

/**
 * @author Pavel Romanov 22.12.2022
 */
public abstract class DriverManager {
    private static String implicitWaitTime = ConfigManager.getConfProperty("implicitWaitTime");
    protected static ThreadLocal<WebDriver> drivers = new ThreadLocal<>();

    protected abstract WebDriver createDriver();

    public void quitDriver() {
        if (null != drivers.get()) {
            drivers.get().quit();
            drivers.remove();

        }
    }

    public WebDriver getDriver() {
        if (null == drivers.get()) {
            drivers.set(this.createDriver());
        }

        drivers.get().manage().timeouts().implicitlyWait(Long.parseLong(implicitWaitTime),
                TimeUnit.SECONDS);
        drivers.get().manage().window().maximize();

        return drivers.get();
    }
}
