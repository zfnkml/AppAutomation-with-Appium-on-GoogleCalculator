# App Automation with Appium on Google Calculator

This project automates functional testing of the Google Calculator app using **Appium**, **TestNG**, and **Selenium**. It follows a **Page Object Model (POM)** architecture for better modularity and maintainability.

## Features : [Automation Video](https://go.screenpal.com/watch/cTV0Innfr9T)

1. **Dynamic Series Calculation**
    - Automates series calculations on the Google Calculator app.
    - Example: Calculate `100 / 10 * 5 - 10 + 60` using the `doSeries()` function.
2. **CSV-Based Testing**
    - Reads input series from a CSV file (`data.csv`) and validates results.
    - Example inputs:
        - `50 + 40 - 30 / 2 + 20` (Expected: 95)
        - `10 * 2 / 2 + 10 - 20` (Expected: 0)
        - `4π2^3` (Expected: 100.53)
3. **Allure Reporting**
    - Generates detailed test execution reports.
    - Includes test summaries, behaviors, and detailed logs.
4. **Page Object Model (POM)**
    - Modular architecture for better code maintenance.

## Project Structure

```
src
├── main
│   ├── java
│   └── resources
└── test
    ├── java
    │   └── com.google.android.calculator
    │       ├── page
    │       │   └── CalculatorScreen.java       # Handles calculator app elements and actions
    │       ├── runner
    │       │   └── TestRunner.java            # Configures and triggers test execution
    │       ├── setup
    │       │   └── Setup.java                 # Handles Appium server and driver setup
    │       └── utils
    │           └── MyUtils.java               # Utilities for common functions
    └── resources
        ├── calculator.apk                     # The APK file for the Google Calculator app
        ├── data.csv                           # Input test data for automated tests
        └── suite.xml                          # TestNG XML suite configuration

```

### Dependencies

```
dependencies {
    // TestNG for test framework
    testImplementation 'org.testng:testng:7.10.2'

    // Selenium for browser and mobile testing
    implementation 'org.seleniumhq.selenium:selenium-java:4.20.0'

    // Appium Java client
    implementation 'io.appium:java-client:9.2.2'

    // Apache Commons CSV for handling CSV files
    implementation 'org.apache.commons:commons-csv:1.13.0'

    // Allure for reporting
    implementation 'io.qameta.allure:allure-testng:2.29.1'
}

```

## Prerequisites

1. **Appium**
    
    ```bash
    appium --use-plugins=execute-driver
    
    ```
    
2. **Android Studio**
    - **Android SDK**: Android 11.0 ("R")
    - **Virtual Device**: Pixel 6 Pro (API 30)
3. **Gradle**
    - Ensure Gradle is installed and properly configured.

## Steps to Run

1. Clone the repository:
    
    ```bash
    git clone https://github.com/zfnkml/AppAutomation-with-Appium-on-GoogleCalculator
    cd AppAutomation-with-Appium-on-GoogleCalculator
    
    ```
    
2. Start the Appium server:
    
    ```bash
    appium --use-plugins=execute-driver
    
    ```
    
3. Open **Android Studio**, configure:
    - SDK: Android 11.0 ("R")
    - Virtual Device: Pixel 6 Pro API 30
4. Execute the tests:
    
    ```bash
    ./gradlew test
    
    ```
    
5. Generate Allure reports:
    
    ```bash
    allure serve build/allure-results
    
    ```
    

## Allure Report

Example Allure report includes:

![image](https://github.com/user-attachments/assets/21dbfb4f-80fb-4290-8bca-2fd17865e86e)

![image](https://github.com/user-attachments/assets/22326665-e6e4-4862-a389-c3f25658982c)

## Recorded Automation Process

Watch the automation process in action: [Automation Video](https://go.screenpal.com/watch/cTV0Innfr9T)

## Key Highlights

- Modular POM design for reusability and scalability.
- Comprehensive test execution reports using Allure.
- Integration with TestNG and Gradle for smooth builds and test runs.

---
