package com.jbhsel;

import com.jbhsel.pages.GithubRepositoryPage;

import org.jbehave.web.selenium.WebDriverProvider;
import org.junit.Ignore;


public class Pages {

    private WebDriverProvider driverProvider;

    private GithubRepositoryPage githubRepositoryPage;

    public Pages(WebDriverProvider driverProvider) {
        super();
        this.driverProvider = driverProvider;
    }

    public GithubRepositoryPage githubRepositoryPage() {
        if (githubRepositoryPage == null) {
            githubRepositoryPage = new GithubRepositoryPage(driverProvider);
        }
        return githubRepositoryPage;
    }
}
