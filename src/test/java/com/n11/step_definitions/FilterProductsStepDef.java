package com.n11.step_definitions;

import com.n11.pages.StoresPage;
import io.cucumber.java.en.*;

public class FilterProductsStepDef {

    StoresPage storesPage = new StoresPage();

    @Given("User opens the browser and goes to the stores page")
    public void userOpensTheBrowserAndGoesToTheStoresPage() {
        storesPage.goToTheUrl();
        storesPage.closeCookies();
    }

    @And("User clicks all stores button")
    public void userClicksAllStoresButton() {
        storesPage.clickAllStores();
    }

    @When("User filters the stores with letter {string}")
    public void userFiltersTheStoresWithLetter(String letter) throws InterruptedException {
        storesPage.clickDesiredStoreLetter(letter);
    }

    @Then("User goes to the desired store")
    public void userGoesToTheDesiredStore() {
        storesPage.goToDesiredStore();
        storesPage.checkDesiredStoreIsOpened();
    }
}
