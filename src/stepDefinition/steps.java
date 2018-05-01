package stepDefinition;

import java.io.File;
import java.io.PrintWriter;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;

public class steps {

	static File f = new File("src");
	static File fs = new File(f, "chromedriver.exe");
	public static WebDriver driver = null;
	public int count;


	@Given("^Launch MailChimps web page$")
	public static void launch() throws Throwable {
		try{
			System.setProperty("webdriver.chrome.driver", fs.getAbsolutePath());
			driver = new ChromeDriver();
			driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
			driver.manage().window().maximize();
			driver.get("https://mailchimp.com/");
		}catch(Exception e){
			System.err.println("Error: " + e.getMessage());
		}	
	}	

	@When("^Navigate to MailChimps about page$")
	public void navigateAbout() throws Throwable {

		try{
			WebElement abt = driver.findElement(By.xpath("//a[@href='/about']"));
			((JavascriptExecutor) driver).executeScript( "arguments[0].scrollIntoView();", abt);
			abt.click();

			count = driver.findElements(By.xpath("//a[@class='bio_link']")).size();
			System.out.println("Lead member count :" + count);

		}catch(Exception e){
			System.err.println("Error: " + e.getStackTrace());

		}
	}


	@Then("^Add leadership team members info into a csv file$")
	public void addMembers() throws Throwable {

		PrintWriter pw = new PrintWriter("Mahendra.csv");

		try{

			for (int j = 0; j<count; j++){
				pw.write(driver.findElements(By.xpath("//a[@class='bio_link']")).get(j).getAttribute("data-title"));
				pw.write(",");
				pw.write(driver.findElements(By.xpath("//a[@class='bio_link']")).get(j).getAttribute("data-position"));
				pw.write(",");
				pw.write(driver.findElements(By.xpath("//a[@class='bio_link']")).get(j).getAttribute("data-description"));
				pw.write("\n");}

			pw.flush();

		}catch(Exception e){
			System.err.println("Error: " + e.getStackTrace());
		}finally{
			pw.close();
			driver.quit();
		}
	}

}
