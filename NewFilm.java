package ru.st.selenium;

import java.util.regex.Pattern;
import java.util.concurrent.TimeUnit;
import org.testng.*;
import org.testng.annotations.*;
import static org.junit.Assert.*;
import static org.hamcrest.CoreMatchers.*;
import org.openqa.selenium.*;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.Select;

public class NewFilm extends ru.st.selenium.pages.TestBase {
  private boolean acceptNextAlert = true;
  private StringBuffer verificationErrors = new StringBuffer();

  @Test
  public void testNewFilm() throws Exception {
    driver.findElement(By.cssSelector("img[alt=\"Add movie\"]")).click();
    driver.findElement(By.name("name")).clear();
    driver.findElement(By.name("name")).sendKeys("My first film");
    driver.findElement(By.name("aka")).clear();
    driver.findElement(By.name("aka")).sendKeys("new_text");
    driver.findElement(By.name("year")).clear();
    driver.findElement(By.name("year")).sendKeys("2013");
    driver.findElement(By.id("own_no")).click();
    driver.findElement(By.id("seen_no")).click();
    driver.findElement(By.name("notes")).clear();
    driver.findElement(By.name("notes")).sendKeys("Тестовый фильм");
    driver.findElement(By.name("taglines")).clear();
    driver.findElement(By.name("taglines")).sendKeys("тест, фильм, приложение");
    driver.findElement(By.name("plotoutline")).clear();
    driver.findElement(By.name("plotoutline")).sendKeys(":)");
    driver.findElement(By.id("text_languages_0")).clear();
    driver.findElement(By.id("text_languages_0")).sendKeys("english");
    driver.findElement(By.id("submit")).click();
  }

  private boolean isElementPresent(By by) {
    try {
      driver.findElement(by);
      return true;
    } catch (NoSuchElementException e) {
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
