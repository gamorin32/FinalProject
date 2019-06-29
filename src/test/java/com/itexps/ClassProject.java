package com.itexps;

import java.util.regex.Pattern;
import java.util.concurrent.TimeUnit;
import org.junit.*;
import static org.junit.Assert.*;
import static org.hamcrest.CoreMatchers.*;
import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.Select;

public class ClassProject {

    private WebDriver driver;
    private String baseUrl;
    private boolean acceptNextAlert = true;
    private StringBuffer verificationErrors = new StringBuffer();

    @Before
    public void setUp() throws Exception {
        System.setProperty("webdriver.chrome.driver", "c:\\qa\\drivers\\chromedriver-75.exe");
        driver = new ChromeDriver();
        baseUrl = "https://www.katalon.com/";
        driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
        driver.manage().window().maximize();
        driver.manage().timeouts().pageLoadTimeout(60, TimeUnit.SECONDS);
    }

    @Test
    public void testClassProject() throws Exception {
        driver.get("http://automationpractice.com/index.php");
        driver.findElement(By.id("search_query_top")).click();
        driver.findElement(By.id("search_query_top")).sendKeys("blouse");
        driver.findElement(By.xpath("(.//*[normalize-space(text()) and normalize-space(.)='support@seleniumframework.com'])[1]/following::li[1]")).click();
        String itemName = driver.findElement(By.xpath("(.//*[normalize-space(text()) and normalize-space(.)='Next'])[1]/following::h1[1]")).getText();
        String itemQuantity = driver.findElement(By.id("quantity_wanted")).getAttribute("value");
        String itemPrice = driver.findElement(By.id("our_price_display")).getText();
        driver.findElement(By.xpath("(.//*[normalize-space(text()) and normalize-space(.)='S'])[1]/following::span[1]")).click();
        driver.findElement(By.xpath("(.//*[normalize-space(text()) and normalize-space(.)='Check out'])[1]/following::span[1]")).click();
        assertEquals("Product successfully added to your shopping cart", driver.findElement(By.xpath("(.//*[normalize-space(text()) and normalize-space(.)='Check out'])[1]/following::h2[1]")).getText());
        assertEquals(itemName, driver.findElement(By.id("layer_cart_product_title")).getText());
        assertEquals(itemPrice, driver.findElement(By.id("layer_cart_product_price")).getText());
        driver.findElement(By.xpath("//*[@id=\"layer_cart\"]/div[1]/div[2]/div[4]/a/span")).click();
        assertEquals("Your shopping cart", driver.findElement(By.xpath("//*[@id=\"columns\"]/div[1]/span[2]")).getText());
        assertEquals(itemName, driver.findElement(By.xpath("//*[@id=\"product_2_7_0_0\"]/td[2]/p/a")).getText());
        assertEquals(itemPrice, driver.findElement(By.xpath("//*[@id=\"product_price_2_7_0\"]/span")).getText());
        assertEquals(itemQuantity, driver.findElement(By.name("quantity_2_7_0_0")).getAttribute("value"));
        String cartTotal = driver.findElement(By.id("total_price")).getText();
        driver.findElement(By.xpath("//*[@id=\"center_column\"]/p[2]/a[1]/span")).click();
        assertEquals("Authentication", driver.findElement(By.xpath("//*[@id=\"columns\"]/div[1]/span[2]")).getText());
        driver.findElement(By.id("email")).click();
        driver.findElement(By.id("email")).clear();
        driver.findElement(By.id("email")).sendKeys("fanny.fake@gmail.com");
        driver.findElement(By.id("passwd")).click();
        driver.findElement(By.id("passwd")).clear();
        driver.findElement(By.id("passwd")).sendKeys("fanny1");
        driver.findElement(By.xpath("//*[@id=\"SubmitLogin\"]/span")).click();
        assertEquals("Addresses", driver.findElement(By.xpath("//*[@id=\"columns\"]/div[1]/span[2]")).getText());
        driver.findElement(By.xpath("//*[@id=\"center_column\"]/form/p/button/span")).click();
        assertEquals("Shipping", driver.findElement(By.xpath("//*[@id=\"columns\"]/div[1]/span[2]")).getText());
        driver.findElement(By.id("cgv")).click();
        driver.findElement(By.xpath("//*[@id=\"form\"]/p/button/span")).click();
        assertEquals("Your payment method", driver.findElement(By.xpath("//*[@id=\"columns\"]/div[1]/span[2]")).getText());
        assertEquals(itemName, driver.findElement(By.xpath("//*[@id=\"product_2_7_0_185354\"]/td[2]/p/a")).getText());
        assertEquals(itemPrice, driver.findElement(By.xpath("//*[@id=\"product_price_2_7_185354\"]/span")).getText());
        assertEquals(itemQuantity, driver.findElement(By.xpath("//*[@id=\"product_2_7_0_185354\"]/td[5]/span")).getText());
        assertEquals(cartTotal, driver.findElement(By.id("total_price")).getText());
        driver.findElement(By.xpath("//*[@id=\"HOOK_PAYMENT\"]/div[1]/div/p/a")).click();
        assertEquals("Bank-wire payment.", driver.findElement(By.xpath("//*[@id=\"columns\"]/div[1]/span[2]")).getText());
        driver.findElement(By.xpath("//*[@id=\"cart_navigation\"]/button/span")).click();
        assertEquals("Order confirmation", driver.findElement(By.xpath("//*[@id=\"columns\"]/div[1]/span[2]")).getText());
        assertEquals("Your order on My Store is complete.", driver.findElement(By.xpath("//*[@id=\"center_column\"]/div/p/strong")).getText());
        driver.findElement(By.xpath("//*[@id=\"header\"]/div[2]/div/div/nav/div[2]/a")).click();
    }

    @After
    public void tearDown() throws Exception {
        driver.quit();
        String verificationErrorString = verificationErrors.toString();
        if (!"".equals(verificationErrorString)) {
            fail(verificationErrorString);
        }
    }

    private boolean isElementPresent(By by) {
        try {
            driver.findElement(by);
            return true;
        } catch (NoSuchElementException e) {
            return false;
        }
    }

    private boolean isAlertPresent() {
        try {
            driver.switchTo().alert();
            return true;
        } catch (NoAlertPresentException e) {
            return false;
        }
    }

    private String closeAlertAndGetItsText() {
        try {
            Alert alert = driver.switchTo().alert();
            String alertText = alert.getText();
            if (acceptNextAlert) {
                alert.accept();
            } else {
                alert.dismiss();
            }
            return alertText;
        } finally {
            acceptNextAlert = true;
        }
    }
}
