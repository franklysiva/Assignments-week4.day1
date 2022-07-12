package week4.day1;

import java.util.ArrayList;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class VitalTask {
	public static void main(String[] args) {
		WebDriverManager.chromedriver().setup();
		ChromeDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.get("http://www.leafground.com/pages/table.html");
		List<WebElement> progressValue = driver.findElements(By.xpath("//table//tr/td[2]"));
		List<Integer> progValues = new ArrayList<>();
		for (WebElement progValue : progressValue) {
			progValues.add(Integer.parseInt(progValue.getText().replace("%", "")));
			}
		int minValue = progValues.get(0);
		int minValueRow = 0;
		for (int i = 0; i < progValues.size(); i++) {
			if (minValue > progValues.get(i)) {
				minValue = progValues.get(i);
				minValueRow = i+2;
			}
		}
		driver.findElement(By.xpath("//table//tr["+minValueRow+"]/td[3]")).click();
		boolean vitalChecked = driver.findElement(By.xpath("(//input[@name='vital'])[5]")).isEnabled();
		System.out.println("Vital task for least completed progress is checked: "+vitalChecked);
		}	
	}	

	