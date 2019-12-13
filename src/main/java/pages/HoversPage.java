package pages;


import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;


public class HoversPage {


    private WebDriver driver;
    private By figureBox = By.className("figure");
    private By boxCaption = By.className("figcaption");


    public HoversPage(WebDriver driver) {
        this.driver = driver;
    }

    public FigureCaption hoverOverFigure(int index){
        WebElement figure = driver.findElements(figureBox).get(index - 1);

        Actions actions = new Actions(driver); //contains advanced interactions
        actions.moveToElement(figure).perform(); //Move mouse to element, hoover

        return new FigureCaption(figure.findElement(boxCaption));
    }

    public class FigureCaption{

        private WebElement caption;
        private By header = By.tagName("h5");
        private By link = By.tagName("a");

        public FigureCaption(WebElement caption){
            this.caption = caption;
        }

        //what do we want to know eg is the caption displayed

        public boolean isCaptionDisplayed(){
        return caption.isDisplayed();
        }

        public String getTitle(){
            return caption.findElement(header).getText();
        }

        public String getLink(){
            return caption.findElement(link).getAttribute("href");
        }

        public String getLinkText(){
            return caption.findElement(link).getText();
        }

    }

}
