# The Score Assignment - Sannidhi Hegde

## Pre-requsites
- Java version - 21.0.1
- Appium version - 2.4.1
- Android Emulator - Pixel 4, Android 11

## Installation
- Clone the repo `git clone https://github.com/hsannidhi/AppiumTest.git`
    - Repo contains needed dependencies in `pom.xml`
- In a terminal, run appium server `appium --base-path /wd/hub`
- Ensure Andoird emulator is running
- Run test 
    - Via command line by executing `mvn clean test`
    - Via testng - right click on testng.xml and Run As TestNG Suite
- Note: I ran the test on a Windows machine

## Test Specification
The scope of my test scenario involves selecting a preferred league during the onboarding process, then navigating to the favorites home screen to click on the chosen league. Subsequently, I will proceed to select the "Standings" tab within the league and verify if a given team is present in the teams listed in the tab.

## Steps
- Install the app
- Verify welcome screen
- Choose a League on 'Choose your favorite leagues' screen - the league name is passed as parameter from testng.xml
- Allow location permission
- Navigate to Favorites home screen
- Click on the league that was chosen as favorite league in step 3
- Verify page title matches given league name - passed as a parameter
- Click on Standings tab and get the list of team names
- Check if a given team name is present in the list of team names - passed as a parameter
- Navigate back and verify favorites home screen is displayed

## Description of the Framework
- In my Android framework, I've implemented the Page Object Model, to seamlessly integrate and scale across all pages in the app. It also includes a utilities class for common functions and uses a parameterized approach.
- I have considered finding elements explicitly instead of android findby for controlled approach.It Provides flexibility to customize locators to handle dynamic values.Also, it would be beneficial for cross platform scalability.
- How is it scalable? - The code is highly maintainable, which means that adding or removing features, debugging, and integrating new components is simpler.whether we're fixing a bug, adding a new feature, or connecting with other parts of the project, the process is straightforward and efficient.
- How is it robust? - Handles errors and exceptions effectively. It can be optimized to handled numerous fail cases and unexpected issues with repeated testing with data handling.
- Test coverage - The test verifies and interacts with different elements in each page, while choosing from a list of leagues/teams, dynamically.
- The code is well-structured and ready to run. It follows the Arrange-Act-Assert pattern commonly used in testing.

## Scope for enhancements
Here are few things I could do to make the framework efficient end to end
- Integrate the framework with testrail api to post results to testcases in Testrail by using test IDs
- Integrate with AWS device farm to run tests on different devices and OS.
- Add a reporting method to see results with screenshots - TestNG Listerners/Extent reports
- Supply test data test from external sources such as arrays, spreadsheets, databases
- Incorporate API testing if applicable.

## Further More
I can implement the same framework in a pytest framework!