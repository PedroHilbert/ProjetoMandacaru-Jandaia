package cucumber.steps;

import com.controller.ProductController;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.spring.CucumberContextConfiguration;

import java.util.ArrayList;
import java.util.List;

import static org.springframework.test.util.AssertionErrors.assertTrue;

@CucumberContextConfiguration
public class StoreProductsSteps {
    @Given("I have more than {int} products in my store")
    public void iHaveMoreThanProductsInMyStore(int productNumber) {
        ProductController products = new ProductController();

        assertTrue("I Have more than {int} products in my store",
                products.getAllProducts().size()>productNumber);
    }

    @And("One of these products is a CellPhone")
    public void oneOfTheseProductsIsACellPhone(){
        ProductController products = new ProductController();
        assertTrue("One of these products is a CellPhone",
                products.getAllProducts().contains("CellPhone"));
    }

    @Then("All products should be returned successfully")
    public void allProductsShouldBeReturnedSuccessfully() {
        // Tripe Arrange
        List<String> productToBeVerified = new ArrayList<String>();
        productToBeVerified.add("Mouse");
        productToBeVerified.add("Keyboard");
        productToBeVerified.add("Pen");
        productToBeVerified.add("Screen");
        productToBeVerified.add("Notebook");
        productToBeVerified.add("CellPhone");
 
        // Act
        ProductController products = new ProductController();

        // Assert
        assertTrue("All products should be returned successfully",
                products.getAllProducts().containsAll(productToBeVerified));

    }
}
