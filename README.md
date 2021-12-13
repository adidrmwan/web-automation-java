# WEB AUTOMATION TESTING - JAVA

System Under Test:
1. Website

Features:
1. Junit
2. Selenium for Website
3. Cucumber

## Prerequisites
* [JDK 11](https://docs.oracle.com/en/java/javase/11/install/overview-jdk-installation.html#GUID-8677A77F-231A-40F7-98B9-1FD0B48C346A)
* [Git](https://git-scm.com/downloads)
* [Intellij IDEA](https://www.jetbrains.com/idea/download/)
* [Gradle](https://gradle.org/install/)
* [Chromedriver](https://formulae.brew.sh/cask/chromedriver)
* [Chrome Browser](https://www.google.com/chrome/)
* [Geckodriver](https://formulae.brew.sh/formula/geckodriver)
* [Firefox Browser](https://www.mozilla.org/en-US/firefox/new/)

## Getting started
1. Clone the repository
2. Open the project using intellij
3. Open terminal
4. Run `gradle build`

## Intellij Plugin
### Cucumber for Java
Add IntelliJ Cucumber for Java plugin:

* Open `Preferences` (⌘ + ,)
* Go to `Plugins > Marketplace`
* Search for `Cucumber for Java` and Install

### Lombok Plugin
Add IntelliJ Cucumber for Java plugin:
* Open `Preferences` (⌘ + ,)
* Go to `Plugins > Marketplace`
* Search for `Lombok` and Install

## Running the Test
* To execute Login Test cases
  > ./gradlew clean cucumber --tags @Login generateCucumberReports

* To execute Transaction Test cases
    > ./gradlew clean cucumber --tags @Transaction generateCucumberReports

## Report
* Find the reporting file on `build/customreport/overview-features.html`
* Open the reporting file in browser