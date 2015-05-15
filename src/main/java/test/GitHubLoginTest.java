package test;

import static setup.SeleniumDriver.getDriver;
import static org.fest.assertions.api.Assertions.assertThat;

import pageobjects.GitHubHomePage;
import pageobjects.GitHubLoginPage;
import org.junit.AfterClass;
import org.junit.Test;

public class GitHubLoginTest {

	@AfterClass
	public static void tearDown() {
		getDriver().close();
	}

	@Test
	public void should_not_login_with_wrong_credentials() {
		//given before
		GitHubLoginPage loginPage = new GitHubHomePage().open().goToLoginPage();
		//when
		loginPage.login("user", "password");
		//then
		assertThat(loginPage.isLoginError()).isTrue();
	}
}
