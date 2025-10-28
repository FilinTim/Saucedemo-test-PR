package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class ProductsPage {
    private WebDriver driver;

    // Локаторы элементов
    private By productsTitle = By.className("title");
    private By productsContainer = By.className("inventory_container");

    public ProductsPage(WebDriver driver) {
        this.driver = driver;
    }

    // Проверить, что мы на странице продуктов
    public boolean isAt() {
        try {
            return driver.findElement(productsTitle).isDisplayed() &&
                   driver.findElement(productsContainer).isDisplayed();
        } catch (Exception e) {
            return false;
        }
    }

    // Получить URL текущей страницы
    public String getCurrentUrl() {
        return driver.getCurrentUrl();
    }
}

