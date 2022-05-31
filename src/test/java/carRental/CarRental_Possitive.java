package carRental;

import org.testng.Assert;
import org.testng.annotations.Test;
import pages.BrcPage;
import utilities.ConfigReader;
import utilities.Driver;

public class CarRental_Possitive {

    @Test
    public void possitiveLoginTest() {

        // Bir test method olustur positiveLoginTest()
        //https://www.bluerentalcars.com/ adresine git
        BrcPage brcPage=new BrcPage();
        Driver.getDriver().get(ConfigReader.getProperty("brcUrl"));

        //login butonuna bas
        brcPage.firstLoginButonu.click();

        //test data user email: customer@bluerentalcars.com
        brcPage.emailTextBox.sendKeys(ConfigReader.getProperty("brcValidEmail"));

        //test data password : 12345
        brcPage.passwordTextBox.sendKeys(ConfigReader.getProperty("brcValidPassword"));

        //Login butonuna tiklayin
        brcPage.secondLoginButton.click();

        //Degerleri girildiginde sayfaya basarili sekilde girilebildigini test et

        String actualUserName=brcPage.accountName.getText();
        String expectedUserName=ConfigReader.getProperty("brcValidUserName");

        Assert.assertEquals(actualUserName,expectedUserName);

        Driver.closeDriver();


    }
}
