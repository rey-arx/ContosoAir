package ContosoAir.Utilities;

import ContosoAir.Util.Recommendation;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

public class RecommendationUtility {
    /**
     * Gets Recommendation details from the element located by the given selector and returns Recommendation object .
     */
    public static Recommendation getRecommendation(WebElement webElement){
        String imgUrl="";
        String desc="";
        WebElement desktopImage = webElement.findElement(By.cssSelector("img.block-cities-list-item-figure-image--desktop"));
        imgUrl = desktopImage.getAttribute("src");
        WebElement caption = webElement.findElement(By.tagName("figcaption"));
        desc = caption.getText();
        return new Recommendation(imgUrl,desc);
    }
}
