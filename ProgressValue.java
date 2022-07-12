package week4.day1;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class ProgressValue {
	public static void main(String[] args) {
		WebDriverManager.chromedriver().setup();
		ChromeDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.get("http://www.leafground.com/pages/table.html");
		WebElement elementTable = driver.findElement(By.tagName("table"));
		List<WebElement> rows = elementTable.findElements(By.tagName("tr"));
		for (int i = 1; i < rows.size(); i++) {
			WebElement eachRow = rows.get(i);
			List<WebElement> column = eachRow.findElements(By.tagName("td"));
			for (int j = 0; j < column.size(); j++) {
				if (column.get(j).getText().contains("Learn to interact with Elements")) {
					System.out.println(rows.get(i).getText());
				}
			}
		}
	}
}
