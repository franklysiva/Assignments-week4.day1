package week4.day1;

import io.github.bonigarcia.wdm.WebDriverManager;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Action;
import org.openqa.selenium.interactions.Actions;

public class Sortable {

	public static void main(String[] args) {
		WebDriverManager.chromedriver().setup();
		ChromeDriver driver = new ChromeDriver();
		driver.get("http://www.leafground.com/pages/sortable.html");
		WebElement fromElement = driver.findElement(By.xpath("(//ul[@id='sortable']/li)[6]"));
		WebElement toElement = driver.findElement(By.xpath("(//ul[@id='sortable']/li)[2]"));
		Actions builder = new Actions(driver);
		Action dragAndDrop = builder.clickAndHold(fromElement).moveToElement(toElement).release(toElement).build();
		dragAndDrop.perform();
	}
}
