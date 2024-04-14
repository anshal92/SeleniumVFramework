# SeleniumVFramework

Framework details:
  - **Language:** Java 11
  - **Build Tool:** Gradle
  - **TestRunner:** Cucumber with TestNG
  - **Test Framework:** Selenium 4.17.0
  - Is multimodule project

Module Details:
  - automation-framework - Has logic for Listner, driver creation and actions
  - core-product-tests - Has test cases for "https://www.nba.com/warriors"
  - derived-product1-tests
  - derived-product2-tests - Has test cases for "https://www.nba.com/bulls/"

How to run:
  - First build project using ```./gradlew clean build -x test --debug --stacktrace```
  - To run tests in core-product-tests use ```./gradlew clean core-product-tests:test -Dweb.userCloud=chrome  --debug``` 
    where -Dweb.userCloud is used for changing browser at runtime.
  - To run tests in derived-product2-tests use ```./gradlew clean derived-product2-tests:test -Dweb.userCloud=chrome --debug ``` 
    where -Dweb.userCloud is used for changing browser at runtime.

How to see reports:
  - Report can be found on the following location post running tests:
    
    ```testNgReport = ${userprojectDir}/build/reports/tests/test/index.html```
    
    ```CucumberReport = ${userprojectDir}/build/generated-reports/cucumber-html-reports/overview-features.html```
    
  - Alternatively the report location are provided in the build logs by searching for ```Links for Reports:``` and opening in require browser
  - Addition data if any could be found in output.csv or output.txt in the submodule folder.

Note: Incase of doubt on driver Binaries being used.
     - Please go through this -> https://www.selenium.dev/blog/2023/whats-new-in-selenium-manager-with-selenium-4.11.0

       tldr; Driver management through Selenium Manager is opt-in for the Selenium bindings.
       Thus, users can continue managing their drivers manually (putting the driver in the PATH or
       using system properties) or rely on a third-party manager to do it automatically.
       Selenium Manager only operates as a fallback: if no driver is provided, Selenium Manager will 
       come to the rescue.
