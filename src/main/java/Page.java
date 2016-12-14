import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.interactions.Actions;

import java.util.List;

/**
 * Created by Scynet on 14.12.2016.
 */
public class Page {
    Actions builder;
    WebDriver driver;
    WebElement trash;
    List<WebElement> elemets;
    public WebDriver openWeb(){
        driver=new FirefoxDriver();
        builder =new Actions(driver);
        driver.get("file:///D:/%D0%A1%D0%B0%D0%B9%D1%82/drag_and_drop2/drag_and_drop2/index.html");
        return driver;
    }
    public void initElements(){
        trash=driver.findElement(By.xpath(".//*[@id='drop']"));
        elemets =driver.findElements(By.xpath(".//*[@id='sortable']/li"));
    }
    public void moveToTrash(int which){
        WebElement elem =elemets.get(0);
        for(int i=0;i<elemets.size();i++){
           if(Integer.valueOf(elemets.get(i).getText())== which ){
               elem=elemets.get(i);
               break;
           }
        }
        builder.dragAndDrop(elem,trash).perform();
    }
    public void answerToWindow(String answer){
        if(answer.equals("Yes"))
            driver.switchTo().alert().accept();
        else driver.switchTo().alert().dismiss();
    }

    public boolean checkIfExist(int which){
        boolean exist=false;
        for(int i=0;i<elemets.size();i++){
            if(Integer.valueOf(elemets.get(i).getText())== which ){
                exist=true;
                break;
            }
        }
        return exist;
    }

    public void sortTo(){
        for(int i=0;i<elemets.size();i++){
            for(int j=1;j<elemets.size();j++){
                if((Integer.valueOf(elemets.get(j).getText()))<(Integer.valueOf(elemets.get(j-1).getText()))) {
                    WebElement temp = elemets.get(j - 1);
                    builder.dragAndDrop(elemets.get(j), elemets.get(j - 1)).perform();
                    elemets.set(j - 1, elemets.get(j));
                    elemets.set(j, temp);
                }
            }
        }
    }

    public void sortFrom(){
        for(int i=0;i<elemets.size();i++){
            for(int j=1;j<elemets.size();j++){
                if((Integer.valueOf(elemets.get(j).getText()))>(Integer.valueOf(elemets.get(j-1).getText()))) {
                    WebElement temp = elemets.get(j - 1);
                    builder.dragAndDrop(elemets.get(j), elemets.get(j - 1)).perform();
                    elemets.set(j - 1, elemets.get(j));
                    elemets.set(j, temp);
                }
            }
        }
    }

        public boolean checkSortTo(){
        boolean sorted=true;
        for(int i=1;i<elemets.size();i++){
            if(Integer.valueOf(elemets.get(i).getText())< Integer.valueOf(elemets.get(i).getText())) sorted=false;
        }
            return sorted;
        }

    public boolean checkSortFrom(){
        boolean sorted=true;
        for(int i=1;i<elemets.size();i++){
            if(Integer.valueOf(elemets.get(i).getText())>Integer.valueOf(elemets.get(i).getText())) sorted=false;
        }
        return sorted;
    }
}


