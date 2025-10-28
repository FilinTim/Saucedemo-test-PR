package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class LoginPage {
    private WebDriver driver;

    // Локаторы элементов
    private By usernameInput = By.id("user-name");
    private By passwordInput = By.id("password");
    private By loginButton = By.id("login-button");
    private By errorMessage = By.cssSelector("[data-test='error']");

    public LoginPage(WebDriver driver) {
        this.driver = driver;
    }

    // Открыть страницу авторизации
    public void open() {
        driver.get("https://www.saucedemo.com");
    }

    // Ввести имя пользователя
    public void enterUsername(String username) {
        driver.findElement(usernameInput).sendKeys(username);
    }

    // Ввести пароль
    public void enterPassword(String password) {
        driver.findElement(passwordInput).sendKeys(password);
    }

    // Нажать кнопку входа
    public void clickLogin() {
        driver.findElement(loginButton).click();
    }

    // Полный процесс авторизации
    public void login(String username, String password) {
        enterUsername(username);
        enterPassword(password);
        clickLogin();
    }

    // Проверить наличие сообщения об ошибке
    public boolean isErrorMessageDisplayed() {
        return driver.findElements(errorMessage).size() > 0;
    }

    // Получить текст сообщения об ошибке
    public String getErrorMessage() {
        if (isErrorMessageDisplayed()) {
            return driver.findElement(errorMessage).getText();
        }
        return "";
    }
}

