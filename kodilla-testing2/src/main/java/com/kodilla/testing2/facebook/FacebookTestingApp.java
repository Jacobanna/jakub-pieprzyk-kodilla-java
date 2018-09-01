package com.kodilla.testing2.facebook;

import com.kodilla.testing2.config.WebDriverConfig;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;

public class FacebookTestingApp {
    public static final String XPATH_SELECT_1 = "//select[1]";
    public static final String XPATH_SELECT_2 = "//select[2]";
    public static final String XPATH_SELECT_3 = "//select[3]";

    public static void main(String[] args) {
        WebDriver driver = WebDriverConfig.getDriver(WebDriverConfig.CHROME);
        driver.get("https://www.facebook.com/");

        WebElement select1 = driver.findElement(By.xpath(XPATH_SELECT_1));
        Select selectBoard1 = new Select(select1);
        selectBoard1.selectByIndex(3);
        WebElement select2 = driver.findElement(By.xpath(XPATH_SELECT_2));
        Select selectBoard2 = new Select(select2);
        selectBoard2.selectByIndex(8);
        WebElement select3 = driver.findElement(By.xpath(XPATH_SELECT_3));
        Select selectBoard3 = new Select(select3);
        selectBoard3.selectByIndex(25);
    }
}
