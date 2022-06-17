package org.steps;

import java.util.concurrent.TimeUnit;

import org.base.BaseClass;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class StepDefinition extends BaseClass {
	
	@Given("user will be in the login page")
	public void user_will_be_in_the_login_page() {
		
		chromeBrowser();
		launchUrl("https://www.basharacare.com/ae_en/");
		maxWindow();

	}

	@SuppressWarnings("deprecation")
	@When("user will provide the valid information")
	public void user_will_provide_the_valid_information() {
		WebElement acc = driver.findElement(By.xpath("//a[@class='action login']"));
		btnClick(acc);
		WebElement create = driver.findElement(By.xpath("(//span[text()='Create an Account'])[1]"));
		btnClick(create);
		WebElement fstname = driver.findElement(By.id("firstname"));
		fillTextbox(fstname, "logesh");
		WebElement lstname = driver.findElement(By.id("lastname"));
		fillTextbox(lstname, "kumar");
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		WebElement date = driver.findElement(By.id("dob"));
		date.sendKeys("06/26/1992");
		date.sendKeys(Keys.TAB);
		WebElement gender = driver.findElement(By.xpath("//select[@id='gender']"));
		Select s = new Select(gender);
		s.selectByVisibleText("Male");
		
	}

	@When("user will give signin information")
	public void user_will_give_signin_information() {
		WebElement email = driver.findElement(By.id("email_address"));
		fillTextbox(email, "lokesh@gmail.com");
		WebElement pwd = driver.findElement(By.id("password"));
		fillTextbox(pwd, "1234567890");
		WebElement pwdconf = driver.findElement(By.id("password-confirmation"));
		fillTextbox(pwdconf, "1234567890");
		

	}

	@Then("click create an account")
	public void click_create_an_account() {
	   // WebElement create = driver.findElement(By.xpath("//button[@title='Create an Account']"));
	    // btnClick(create);
	}

	
	

}
