package com.jbhsel;

import org.jbehave.core.annotations.Given;
import org.jbehave.core.annotations.Then;
import org.jbehave.core.annotations.When;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertNotEquals;
import static org.junit.Assert.assertTrue;

public class SiteSteps {

    private final Pages pages;

    public SiteSteps(Pages pages) {
        this.pages = pages;
    }

    @Given("user is on github page")
    public void userOnGithubPage() {

        pages.githubRepositoryPage().openGithub();
    }

    @When("user clicks the $linkText text")
    public void userNameLink(String linkText) {

        pages.githubRepositoryPage().click(linkText);
    }

    @Then("$repositoryName should be displayed alongside other repositories")
    public void thenTheRepositoryShouldBeDisplayedAlongsideOtherRepositories(String repositoryName) {
        assertTrue(pages.githubRepositoryPage().isDisplayedAlongside(repositoryName));
    }

    @Then("the $repositoryName repository should be displayed")
    public void thenTheRepositoryIsDisplayed(String repositoryName) {
        assertTrue(pages.githubRepositoryPage().isRepositoryDisplayed(repositoryName));
    }

    @Then("the $folderName folder should be displayed")
    public void thenTheFolderIsDisplayed(String folderName) {
        assertTrue(pages.githubRepositoryPage().isFolderDisplayed(folderName));
    }

    @Then("the $className entity class should be displayed")
    public void thenTheEntityClassIsDisplayed(String className) {
        assertTrue(pages.githubRepositoryPage().isFolderDisplayed(className));
    }



}
