import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import java.util.ArrayList;
import java.util.List;

public class UltimateQATest extends PageSetup{


    @Test
    public void testOne() {
        WebElement buttonUsingId = driver.findElement(By.id("idExample"));
        buttonUsingId.click();
        WebElement buttonSuccessText = driver.findElement(By.className("entry-title"));
        Assertions.assertEquals("Button success", buttonSuccessText.getText());
    }
    @Test
    public void testTwo() throws InterruptedException {
        WebElement nameInput = driver.findElement(By.id("et_pb_contact_name_0"));
        nameInput.sendKeys("Tester");

        WebElement emailInput = driver.findElement(By.id("et_pb_contact_email_0"));
        emailInput.sendKeys("tester@tester.pl");

        Thread.sleep(2000);

        WebElement emailMebutton = driver.findElement(By.name("et_builder_submit_button"));
        emailMebutton.click();

        Thread.sleep(2000);
        WebElement thanksText =driver.findElement(By.xpath("//div[@class='et-pb-contact-message']/p"));
        Assertions.assertEquals("Thanks for contacting us",thanksText.getText());
    }
    @Test
    public void testThree() {
        List<String> listOfCars = new ArrayList<>();
        listOfCars.add("volvo");
        listOfCars.add("saab");
        listOfCars.add("opel");
        listOfCars.add("audi");

        WebElement dropdown = driver.findElement(By.xpath("//div[text()='Select an option and validate that it is selected']"));

        for (int i = 0; i < listOfCars.size(); i++) {
            dropdown.click();
            WebElement dropdownOption = driver.findElement(By.xpath("//option[@value='" + listOfCars.get(i) + "']"));
            dropdownOption.click();
            Assertions.assertTrue(dropdownOption.isSelected());
            Assertions.assertEquals(listOfCars.get(i), dropdownOption.getText().toLowerCase());
        }
    }
    @Test
    public void testFour(){
        WebElement blueField = driver.findElement(By.xpath("//*[contains(@class, 'et_pb_module et_pb_cta_0 et_pb_promo')]"));
        Assertions.assertEquals("rgba(46, 163, 242, 1)", blueField.getCssValue("background-color"));
    }

}
