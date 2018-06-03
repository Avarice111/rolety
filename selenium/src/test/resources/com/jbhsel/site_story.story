Scenario: User is using Github repository

Given user is on github page
When user clicks the Repositories text
Then roletyTAU should be displayed alongside other repositories
When user clicks the roletyTAU text
Then the roletyTAU repository should be displayed
When user clicks the RoletyTAU text
Then the RoletyTAU folder should be displayed
When user clicks the src text
Then the src folder should be displayed
When user clicks the main text
Then the main folder should be displayed
When user clicks the java/com/rolety text
Then the rolety folder should be displayed
When user clicks the domain text
Then the domain folder should be displayed
When user clicks the Rolety.java text
Then the Rolety.java entity class should be displayed
