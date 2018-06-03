package com.jbhsel;

import com.jbhsel.pages.GithubRepositoryPage;

import org.jbehave.web.selenium.WebDriverProvider;

public class Pages {

    private WebDriverProvider driverProvider;

    private GithubRepositoryPage githubRepositoryPage;

    public Pages(WebDriverProvider driverProvider) {
        super();
        this.driverProvider = driverProvider;
    }

    public GithubRepositoryPage helpdesk() {
        if (githubRepositoryPage == null) {
            githubRepositoryPage = new GithubRepositoryPage(driverProvider);
        }
        return githubRepositoryPage;
    }
}
