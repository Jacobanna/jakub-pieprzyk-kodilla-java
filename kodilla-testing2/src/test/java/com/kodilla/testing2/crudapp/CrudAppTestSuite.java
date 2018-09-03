package com.kodilla.testing2.crudapp;

import com.kodilla.testing2.config.WebDriverConfig;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;

import java.util.Random;
import java.util.stream.Collectors;

import static junit.framework.TestCase.assertTrue;

public class CrudAppTestSuite {
    private static final String BASE_URL = "https://jacobanna.github.io/";
    private WebDriver driver;
    private Random generator;

    @Before
    public void initTests() {
        driver = WebDriverConfig.getDriver(WebDriverConfig.CHROME);
        driver.get(BASE_URL);
        generator = new Random();
    }

    @After
    public void cleanUpAfterTest() {
        driver.close();
    }

    @Test
    public void shouldCreateTrelloCard() throws InterruptedException {
        String taskName = createCrudAppTestTask();
        System.out.println(taskName);
        sendTestTaskToTrello(taskName);
        assertTrue(checkTaskExistsInTrello(taskName));
        System.out.println(taskName);
        deleteCrudAppTestTask(taskName);
    }

    private boolean checkTaskExistsInTrello(String taskName) throws InterruptedException {
        final String TRELLO_URL = "https://trello.com/login";
        boolean result = false;
        WebDriver driverTrello = WebDriverConfig.getDriver(WebDriverConfig.CHROME);
        driverTrello.get(TRELLO_URL);
        driverTrello.findElement(By.id("user")).sendKeys("pieprzyk.jakub@gmail.com");
        driverTrello.findElement(By.id("password")).sendKeys("FOR_TESTING");
        driverTrello.findElement(By.id("login")).submit();
        Thread.sleep(2000);

        driverTrello.findElements(By.xpath("//a[@class=\"board-tile\"]")).stream()
                .filter(aHref -> aHref.findElements(By.xpath(".//div[@title=\"Kodilla Application\"]")).size() > 0)
                .forEach(aHref -> aHref.click());
        Thread.sleep(4000);

        result = driverTrello.findElements(By.xpath("//span")).stream()
                .filter(theSpan -> theSpan.getText().contains(taskName))
                .collect(Collectors.toList())
                .size() > 0;
        driverTrello.close();

        return result;
    }

    private void sendTestTaskToTrello(String taskName) throws InterruptedException {
        driver.navigate().refresh();

        //Wait until page loads content
        while (!driver.findElement(By.xpath("//select[1]")).isDisplayed()) ;

        driver.findElements(By.xpath("//form[@class=\"datatable__row\"]")).stream()
                .filter(anyForm ->
                        anyForm.findElement(By.xpath(".//p[@class=\"datatable__field-value\"]"))
                                .getText().equals(taskName))
                .forEach(theForm -> {
                    WebElement selectedElement = theForm.findElement(By.xpath(".//select[1]"));
                    Select select = new Select(selectedElement);
                    select.selectByIndex(1);
                    WebElement createCardButton = theForm.findElement(By.xpath(".//button[contains(@class, \"card-creation\")]"));
                    createCardButton.click();
                });
        Thread.sleep(5000);
    }

    private String createCrudAppTestTask() throws InterruptedException {
        final String XPATH_TASK_NAME = "//form[contains(@action, \"createTask\")]/fieldset[1]/input";
        final String XPATH_TASK_CONTENT = "//form[contains(@action, \"createTask\")]/fieldset[2]/textarea";
        final String XPATH_ADD_BUTTON = "//form[contains(@action, \"createTask\")]/fieldset[3]/button";
        String taskName = "Task number " + generator.nextInt(100000);
        String taskContent = taskName + " content";

        WebElement name = driver.findElement(By.xpath(XPATH_TASK_NAME));
        name.sendKeys(taskName);
        WebElement content = driver.findElement(By.xpath(XPATH_TASK_CONTENT));
        content.sendKeys(taskContent);
        WebElement addButton = driver.findElement(By.xpath(XPATH_ADD_BUTTON));
        addButton.click();
        Thread.sleep(2000);

        return taskName;
    }

    //TERAZ USUWAM ZAWSZE PIERWSZY TASK NA LISCIE, A NIE TEN DODANY
    private void deleteCrudAppTestTask(String taskName) throws InterruptedException {
        driver.switchTo().alert().accept();

        //Wait until page loads content
        while (!driver.findElement(By.xpath("//select[1]")).isDisplayed()) ;

        driver.findElements(By.xpath("//form[@class=\"datatable__row\"]")).stream()
                .filter(anyForm ->
                        anyForm.findElement(By.xpath(".//p[@class=\"datatable__field-value\"]"))
                                .getText().equals(taskName))
                .forEach(theForm -> {
                    System.out.println(theForm.getText());
                    WebElement deleteButton = theForm.findElement(By.xpath(".//button[4]"));
                    deleteButton.click();
                });
        Thread.sleep(5000);
    }
}
