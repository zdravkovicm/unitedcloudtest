package main.java.Utils;

import org.openqa.selenium.*;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import static main.java.Utils.BaseClass.driver;

public interface Waiter {

    default WebDriverWait waiter() {
        return new WebDriverWait(driver, 70, 500);
    }


    /**
     * Waits implicit wait argument
     */
    default void waitImplicit(int miliseconds) {
        try {
            Thread.sleep(miliseconds);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    /**
     * Waiting for given URL to be contained inside current one
     *
     * @return boolean
     */
    default void waitUntilUrlContains(String url) {
        waiter().until(ExpectedConditions.urlContains(url));
    }


    /**
     * Waiting for exact number of seconds for given URL to be contained inside current one
     *
     * @return boolean
     */
    default boolean waitUntilUrlContainsBool(String url) {
        try {
            waiter().until(ExpectedConditions.urlContains(url));
            return true;
        } catch (TimeoutException e) {
            return false;
        }
    }


    /**
     * Verify if element is displayed
     *
     * @param element Web element
     * @return boolean
     */
    default boolean isElementDisplayed(WebElement element) {
        try {
           return element.isDisplayed();
        } catch (NoSuchElementException e) {
          return false;
        }
    }


    /**
     * Wait until element is visible
     *
     * @param element Web element
     */
    default void waitUntilElementIsVisible(WebElement element) {
        waiter().until(ExpectedConditions.visibilityOf(element));
    }


    /**
     * Wait until element is clickable
     *
     * @param element Web element
     */
    default void waitUntilElementIsClickable(WebElement element) {
        waiter().until(ExpectedConditions.elementToBeClickable(element));
    }


    /**
     * Execute JavaScript click when element is not clickable.
     *
     * @param element - Webelement selector
     */
    default void jsElementClick(WebElement element) {
        JavascriptExecutor executor = (JavascriptExecutor)driver;
        executor.executeScript("arguments[0].click();", element);
    }



}