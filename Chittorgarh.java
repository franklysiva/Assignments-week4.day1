package week4.day1;

import java.util.ArrayList;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class Chittorgarh {
	public static void main(String[] args) {
		WebDriverManager.chromedriver().setup();
		ChromeDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.get("https://www.chittorgarh.com/");
		driver.findElement(By.id("navbtn_stockmarket")).click();
		driver.findElement(By.xpath("(//a[text()='NSE Bulk Deals'])[1]")).click();
		List<WebElement> elementNames = driver.findElements(By.xpath("//table[contains(@class,'table table-bordered')]/tbody/tr/td[3]"));
		List<String> secNames = new ArrayList<String>();
		System.out.println("Security Names List:");
		for (int i = 0; i < elementNames.size(); i++) {
			secNames.add(elementNames.get(i).getText());
		}
		System.out.println(secNames);
		System.out.println("\n Duplicate Entries are: ");

		for (int j = 0; j <= secNames.size() - 1; j++) {

			for (int k = j + 1; k < secNames.size(); k++) {
				if (secNames.get(j).equalsIgnoreCase(secNames.get(k))) {
					System.out.println(secNames.get(j));
				}
				break;
			}
		}
	}
}
