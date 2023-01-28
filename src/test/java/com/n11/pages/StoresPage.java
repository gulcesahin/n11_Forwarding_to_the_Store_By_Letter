package com.n11.pages;

import com.n11.utilities.Commons;
import com.n11.utilities.ConfigReader;
import com.n11.utilities.Driver;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.SearchContext;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import java.util.List;

public class StoresPage {
    public StoresPage() {PageFactory.initElements(Driver.get(), this);}

    static WebDriver driver= Driver.get();

    @FindBy(className = "efilli-layout-n11")
    public List<WebElement> shadowHosts;

    @FindBy(xpath = "//h3[text()='Tüm Mağazalar']")
    public WebElement allStoresBtn;

    public static WebElement storesLetters(String letter){
        return driver.findElement(By.xpath("//span[@data-has-seller='"+ letter +"']"));
    }

    @FindBy(xpath = "(//div[@class='searchInput']/following-sibling::ul[1]//li)[1]")
    public WebElement firstStoreBtn;

    @FindBy(xpath = "//div[@class='resultText ']//h1[1]")
    public WebElement storeText;


    public void goToTheUrl() {
        driver.get(ConfigReader.get("url"));
        Assert.assertEquals(ConfigReader.get("url"),driver.getCurrentUrl());
    }

    public void closeCookies(){

        if(!shadowHosts.isEmpty()){
            WebElement shadowHost = driver.findElement(By.className("efilli-layout-n11"));
            SearchContext shadowRoot = shadowHost.getShadowRoot();
            WebElement acceptCookiesBtn = shadowRoot.findElement(By.className("banner__accept-button"));
            acceptCookiesBtn.click();
        }
    }

    public void clickAllStores(){
        allStoresBtn.click();
    }

    public void clickDesiredStoreLetter(String letter) throws InterruptedException {
        Commons.hover(storesLetters(letter));
        storesLetters(letter).click();
        Thread.sleep(5000);
    }

    public void goToDesiredStore(){
        firstStoreBtn.click();
    }

    public void checkDesiredStoreIsOpened(){
        Assert.assertTrue(storeText.getText().contains("S"));
    }
}
