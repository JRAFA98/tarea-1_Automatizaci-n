package test;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.Test;
public class Main {
	@Test
	public void Login () throws InterruptedException{
		String URL = "https://www.demoblaze.com/";
		WebDriver driver  = new ChromeDriver();
		driver.get(URL);
		//ID 
		WebElement btnLogin = driver.findElement(By.id("login2"));
		//Name
		WebElement txtUserName = driver.findElement(By.id("loginusername"));
		WebElement txtPassword = driver.findElement(By.id("loginpassword"));
		//XPATH
		WebElement login = driver.findElement(By.xpath("//*[@id=\"logInModal\"]/div/div/div[3]/button[2]"));   
		
		//Manipulación_de_elementos
		WebDriverWait wait = new WebDriverWait(driver, 100);
		//Explicit_wait_para_sidebar_Costumer.
		WebElement button = wait.until(ExpectedConditions.elementToBeClickable(By.id("login2")));
		button.click();
		Thread.sleep(1000);
		txtUserName.sendKeys("qwerty5666");
		txtPassword.sendKeys("qwerty5666");
		
		//Uso_ejecutor_de_Javascript
		JavascriptExecutor js = (JavascriptExecutor) driver;
        WebElement BtnSave = driver.findElement(By.xpath("//*[@id=\"logInModal\"]/div/div/div[3]/button[2]"));
        String buttonText = (String) js.executeScript("return arguments[0].innerText", BtnSave);
        js.executeScript("arguments[0].click();", BtnSave);
        js.executeScript("console.log('" + buttonText + "')");
	}
	
	
	@Test 
	public void ManVentanas() {
		String url = "https://the-internet.herokuapp.com/windows";
        WebDriver driver = new ChromeDriver();
        driver.get(url);
        driver.findElement(By.xpath("//*[@id=\"content\"]/div/a")).click();

        String originalWindow = driver.getWindowHandle();
        // Iterar_hasta_encontrar_la_nueva_ventana_y_cambiar_a_ella
        for (String windowHandle : driver.getWindowHandles()) {
            if (!originalWindow.contentEquals(windowHandle)) {
                driver.switchTo().window(windowHandle);
                break;
            }
        }
        // Close the tab or window
        //driver.close();
        // Switch back to the old tab or window
        driver.switchTo().window(originalWindow);
		
	}
}
