package tests;

import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import base.TestBase;

public class TestRegisterFeature extends TestBase {
	@BeforeClass
	public void classSetUp() {

		menuBar.registrationLink.click();
	}

	@Test
	public void testFirstNameWithTwoCharacter() {
		registerPage.processTextField(registerPage.firstNameField, "ab");

		Assert.assertTrue(registerPage.getCurrentUrl().contains("/register"));
		Assert.assertEquals(registerPage.errorMessage.get(0).getText(), "*");
	}

	@Test
	public void testWithFirstNameOneCharacter() {
		registerPage.processTextField(registerPage.firstNameField, "a");

		Assert.assertTrue(registerPage.getCurrentUrl().contains("/register"));
		Assert.assertEquals(registerPage.errorMessage.get(0).getText(),
				"* FirstName can not be less than 2 character.");
	}

	@Test
	public void testFirstNameWithThirtyCharacter() {
		registerPage.processTextField(registerPage.firstNameField, "My name is Dewan Nadia Sultana");

		Assert.assertTrue(registerPage.getCurrentUrl().contains("/register"));
		Assert.assertEquals(registerPage.errorMessage.get(0).getText(), "*");

	}

	@Test
	public void testFirstNameWithThirtyOneCharacter() {
		registerPage.processTextField(registerPage.firstNameField, "My name is Dewan Nadia Sultana S");

		Assert.assertTrue(registerPage.getCurrentUrl().contains("/register"));
		Assert.assertEquals(registerPage.errorMessage.get(0).getText(),
				"* FirstName can not be greater than 30 character.");

	}

	@Test
	public void testFirstNameWithEmptyField() {
		registerPage.processTextField(registerPage.firstNameField, "");

		Assert.assertTrue(registerPage.getCurrentUrl().contains("/register"));
		Assert.assertEquals(registerPage.errorMessage.get(0).getText(), "* FirstName can not be empty.");
	}

	@Test
	public void testFirstNameWithNumericData() {
		registerPage.processTextField(registerPage.firstNameField, "345265789345678123456789876543");

		Assert.assertTrue(registerPage.getCurrentUrl().contains("/register"));
		Assert.assertEquals(registerPage.errorMessage.get(0).getText(), "FirstName must be String");
	}

	@Test
	public void testLastNameWithTwoCharacter() {
		registerPage.processTextField(registerPage.lastNameField, "ab");

		Assert.assertTrue(registerPage.getCurrentUrl().contains("/register"));
		Assert.assertEquals(registerPage.errorMessage.get(1).getText(), "*");
	}

	@Test
	public void testLastNameWithOneCharacter() {
		registerPage.processTextField(registerPage.lastNameField, "a");

		Assert.assertTrue(registerPage.getCurrentUrl().contains("/register"));
		Assert.assertEquals(registerPage.errorMessage.get(1).getText(), "* LastName can not be less than 2 character.");
	}

	@Test
	public void testLastNameWithThirtyCharacter() {
		registerPage.processTextField(registerPage.lastNameField, "MynameisDewanNadiaSultanaShumi");

		Assert.assertTrue(registerPage.getCurrentUrl().contains("/register"));
		Assert.assertEquals(registerPage.errorMessage.get(1).getText(), "*");

	}

	@Test
	public void testLastNameWithThirtyOneCharacter() {
		registerPage.processTextField(registerPage.lastNameField, "My name is Dewan Nadia Sultanaa");

		Assert.assertTrue(registerPage.getCurrentUrl().contains("/register"));
		Assert.assertEquals(registerPage.errorMessage.get(1).getText(),
				"* LastName can not be greater than 30 character.");

	}

	@Test
	public void testLastNameWithEmptyField() {
		registerPage.processTextField(registerPage.lastNameField, "");

		Assert.assertTrue(registerPage.getCurrentUrl().contains("/register"));
		Assert.assertEquals(registerPage.errorMessage.get(1).getText(), "* LastName can not be empty.");

	}

	@Test
	public void testLastNameWithNumericData() {
		registerPage.processTextField(registerPage.lastNameField, "3452657893456712345678987653");

		Assert.assertTrue(registerPage.getCurrentUrl().contains("/register"));
		Assert.assertEquals(registerPage.errorMessage.get(1).getText(), "LastName must be String");
	}

	@Test
	public void testGenderWithRanddomOption() {
		registerPage.processDropdownList(registerPage.genderDropdownList);

		Assert.assertTrue(registerPage.getCurrentUrl().contains("/register"));
		Assert.assertEquals(registerPage.errorMessage.get(2).getText(), "*");
	}

	@Test
	public void testGenderWithoutSelectedOption() {
		menuBar.registrationLink.click();
		registerPage.submitButton.click();

		Assert.assertTrue(registerPage.getCurrentUrl().contains("/register"));
		Assert.assertEquals(registerPage.errorMessage.get(2).getText(), "* Gender can not be empty.");
	}
	@Test
	public void testValidDateOfBirth() {
		registerPage.processTextField(registerPage.dateOfBirthField, "1987-12-19");

		Assert.assertTrue(registerPage.getCurrentUrl().contains("/register"));
		Assert.assertEquals(registerPage.errorMessage.get(3).getText(), "*");

	}
	@Test
	public void testDateOfBirthWithFutureDate() {
		registerPage.processTextField(registerPage.dateOfBirthField, "2018-12-19");

		Assert.assertTrue(registerPage.getCurrentUrl().contains("/register"));
		Assert.assertEquals(registerPage.errorMessage.get(3).getText(), "Invalid DateOfBirth");

	}

	@Test
	public void testDateOfBirthWithNoDate() {
		registerPage.processTextField(registerPage.dateOfBirthField, "");


		Assert.assertTrue(registerPage.getCurrentUrl().contains("/register"));
		Assert.assertEquals(registerPage.errorMessage.get(3).getText(), "* DateOfBirth can not be empty.");
	}

	@Test
	public void testPhoneNoWithTwoDigitNumber() {
		registerPage.processTextField(registerPage.phoneNoField, "12");

		Assert.assertTrue(registerPage.getCurrentUrl().contains("/register"));
		Assert.assertEquals(registerPage.errorMessage.get(4).getText(), "* PhoneNo can not be less than 3 character.");

	}

	@Test
	public void testPhoneNoWithThirtyOneDigitNumber() {
		registerPage.processTextField(registerPage.phoneNoField, "1234567890123456789009876543211");

		Assert.assertTrue(registerPage.getCurrentUrl().contains("/register"));
		Assert.assertEquals(registerPage.errorMessage.get(4).getText(),
				"* PhoneNo can not be greater than 30 character.");

	}

	@Test
	public void testPhoneNoWithEmptyField() {
		registerPage.processTextField(registerPage.phoneNoField, "");

		Assert.assertTrue(registerPage.getCurrentUrl().contains("/register"));
		Assert.assertEquals(registerPage.errorMessage.get(4).getText(), "* PhoneNo can not be empty.");

	}
	
	 @Test
	 public void testUserTypeWithoutSelectedOption() {
	 menuBar.registrationLink.click();	 
	 registerPage.submitButton.click();
	
	 Assert.assertTrue(registerPage.getCurrentUrl().contains("/register"));
	 Assert.assertEquals(registerPage.errorMessage.get(5).getText(), "* UserType can not be empty.");
	
	 }

	@Test
	public void testEmailWithInvalidEmail() {
		registerPage.processTextField(registerPage.emailField, "invalid@gmailcom");

		Assert.assertTrue(registerPage.getCurrentUrl().contains("/register"));
		Assert.assertEquals(registerPage.errorMessage.get(6).getText(), "* Invalid Email");

	}

	@Test
	public void testEmailWithEmptyEmailField() {
		registerPage.processTextField(registerPage.emailField, "");

		Assert.assertTrue(registerPage.getCurrentUrl().contains("/register"));
		Assert.assertEquals(registerPage.errorMessage.get(6).getText(), "* Email can not be empty.");

	}

	@Test
	public void testPasswordWithInvalidPassword() {
		registerPage.processTextField(registerPage.passwordField, "InvalidPassword");

		Assert.assertTrue(registerPage.getCurrentUrl().contains("/register"));
		Assert.assertEquals(registerPage.errorMessage.get(7).getText(), "*");

	}

	@Test
	public void testPasswordWithEmptyPassword() {
		registerPage.processTextField(registerPage.passwordField, "");

		Assert.assertTrue(registerPage.getCurrentUrl().contains("/register"));
		Assert.assertEquals(registerPage.errorMessage.get(7).getText(), "* Password can not be empty.");

	}

	@Test
	public void testPasswordWithFiveCharacter() {
		registerPage.processTextField(registerPage.passwordField, "abcde");

		Assert.assertTrue(registerPage.getCurrentUrl().contains("/register"));
		Assert.assertEquals(registerPage.errorMessage.get(7).getText(), "* Password can not be less than 6 character.");

	}

	@Test
	public void testPasswordWithSixDigitNumber() {
		registerPage.processTextField(registerPage.passwordField, "123456");

		Assert.assertTrue(registerPage.getCurrentUrl().contains("/register"));
		Assert.assertEquals(registerPage.errorMessage.get(7).getText(), "*");

	}
	@Test
	public void testPasswordWithTwentyDigitNumber() {
		registerPage.processTextField(registerPage.passwordField, "12345678900987654321");

		Assert.assertTrue(registerPage.getCurrentUrl().contains("/register"));
		Assert.assertEquals(registerPage.errorMessage.get(7).getText(), "*");

	}

	@Test
	public void testPasswordWithTwentyOneCharacter() {
		registerPage.processTextField(registerPage.passwordField, "asdfghjklpoiuytrewqzx");

		Assert.assertTrue(registerPage.getCurrentUrl().contains("/register"));
		Assert.assertEquals(registerPage.errorMessage.get(7).getText(),
				"* Password can not be greater than 20 character.");

	}

	@Test
	public void testConfirmPasswordWithInvalidPassword() {
		registerPage.processTextField(registerPage.passwordField, "InvalidPassword");
		registerPage.processTextField(registerPage.confirmPasswordField, "InvalidPassword");

		Assert.assertTrue(registerPage.getCurrentUrl().contains("/register"));
		Assert.assertEquals(registerPage.errorMessage.get(8).getText(), "* ConfirmPassword did not match.");

	}

	@Test
	public void testConfirmPasswordWithEmptyPassword() {
		registerPage.processTextField(registerPage.passwordField, "");
		registerPage.processTextField(registerPage.confirmPasswordField, "");

		Assert.assertTrue(registerPage.getCurrentUrl().contains("/register"));
		Assert.assertEquals(registerPage.errorMessage.get(8).getText(), "* ConfirmPassword can not be empty.");

	}

	@Test
	public void testCaptchaImageWithEmpty() {
		
		registerPage.processTextField(registerPage.captchaImageField, "");

		Assert.assertTrue(registerPage.getCurrentUrl().contains("/register"));
		Assert.assertEquals(registerPage.errorMessage.get(9).getText(), "* Captcha can not be empty.");

	}

	@Test
	public void testCaptchaImageWithInvalidInput() {
		registerPage.processTextField(registerPage.captchaImageField, "Invalid Image");

		Assert.assertTrue(registerPage.getCurrentUrl().contains("/register"));
		Assert.assertEquals(registerPage.errorMessage.get(9).getText(), "* Wrong Code Entered");

	}

	@Test
	public void testPrivacyPolicyWithEmpty() {
		registerPage.privacyCheckBox.click();
		registerPage.submitButton.click();

		Assert.assertTrue(registerPage.getCurrentUrl().contains("/register"));
		Assert.assertEquals(registerPage.errorMessage.get(10).getText(), "* Privacy can not be empty.");

	}

	@AfterClass
	public void classTearDown() {
		menuBar.jobSearchPageLink.click();
	}

}
