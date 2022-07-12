package week4.day1;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class HtmlTableValues {
	public static void main(String[] args) {
		WebDriverManager.chromedriver().setup();
		ChromeDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.get("https://html.com/tags/table/");
		List<WebElement> headElement = driver.findElements(By.xpath("//div[@class='render']/table/thead/tr/th"));
		List<WebElement> row1 = driver.findElements(By.xpath("//div[@class='render']/table/tbody/tr[1]/td"));
		List<WebElement> row2 = driver.findElements(By.xpath("//div[@class='render']/table/tbody/tr[2]/td"));
		for (WebElement eachHeader : headElement) {
			System.out.print("  "+eachHeader.getText()+"      ");
		}
			System.out.println();
			for (WebElement firstRow : row1) {
				
				System.out.print(firstRow.getText()+"\t   ");
			}
			System.out.println();
				for (WebElement secondRow : row2) {
				
					System.out.print(secondRow.getText()+"\t   ");
				}
	}
}
