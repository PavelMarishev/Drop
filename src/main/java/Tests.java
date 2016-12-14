import org.junit.Assert;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

/**
 * Created by Scynet on 14.12.2016.
 */
public class Tests {
    Page p = new Page();
    WebDriver driver;
    @BeforeTest
    public void b4Test(){
        driver=p.openWeb();
    }
    @BeforeMethod
    public void b4Method(){
        p.initElements();
    }
    @Test
    public void TestNumberOne(){
        p.moveToTrash(7);
        p.answerToWindow("Cansel");
        p.initElements();
        Assert.assertTrue(p.checkIfExist(7));
        p.moveToTrash(7);
        p.answerToWindow("Yes");
        p.initElements();
        Assert.assertFalse(p.checkIfExist(7));
    }
    @Test
    public void TestNumberTwo(){
        p.sortTo();
       Assert.assertTrue( p.checkSortTo());
        p.sortFrom();
        Assert.assertTrue(p.checkSortFrom());

    }
    @AfterTest
    public void afterTest(){
        driver.quit();
    }
}
