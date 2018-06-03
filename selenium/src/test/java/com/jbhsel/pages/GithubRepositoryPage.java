package com.jbhsel.pages;

import org.jbehave.web.selenium.WebDriverPage;
import org.jbehave.web.selenium.WebDriverProvider;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;

import java.util.List;
import java.util.concurrent.TimeUnit;

public class GithubRepositoryPage extends WebDriverPage {

    public GithubRepositoryPage(WebDriverProvider driverProvider) {
        super(driverProvider);
    }

    public void click(String linkText) {
        WebElement e = findElement(By.partialLinkText(linkText));
        e.click();
    }

	public void openGithub() {
        get("https://github.com/Avarice111");
        manage().timeouts().implicitlyWait(6, TimeUnit.SECONDS);
	}

	public boolean isFolderDisplayed(String name) {
        WebElement e = findElement(By.cssSelector("div.file-navigation > div.breadcrumb > strong.final-path"));
        return e.getText().contains(name);
        
	}

	public boolean isDisplayedAlongside(String repositoryName) {
        WebElement e = findElement(By.cssSelector("div#user-repositories-list > ul > li:nth-child(1) > div:nth-child(1)"));
        return e.getText().contains(repositoryName);
	}

	public boolean isRepositoryDisplayed(String repositoryName) {
        WebElement e = findElement(By.cssSelector("div.pagehead"));
        return e.getText().contains(repositoryName);
	}

}
