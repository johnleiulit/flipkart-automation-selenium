# Flipkart E-Commerce Test Automation

BDD test automation framework for Flipkart built with Selenium WebDriver, Cucumber, Java, and TestNG. Includes data-driven testing and comprehensive reporting.

## Tech Stack

- **Java 17** - Programming language
- **Selenium WebDriver 4.12.1** - Browser automation
- **Cucumber 7.20.1** - BDD framework
- **TestNG 7.4.0** - Test execution framework
- **Maven** - Build and dependency management
- **WebDriverManager 5.9.2** - Automatic driver management
- **Apache POI 5.2.3** - Excel data handling
- **ExtentReports 5.1.2** - Test reporting
- **Log4j 1.2.17** - Logging

## Project Structure

```
E-CommerceTestsSelenium/
├── src/main/java/com/
│   ├── Baseclass/          # Base configuration and browser setup
│   ├── Hooks/              # Cucumber hooks for setup/teardown
│   ├── ReusableFuntions/   # Reusable Selenium utilities
│   └── Utilities/          # Excel utility for data-driven tests
├── src/test/java/com/
│   ├── Pages/              # Page Object Model classes
│   ├── Stepdefenitions/    # Cucumber step definitions
│   └── TestRunner/         # TestNG runner configuration
└── src/test/resources/
    ├── Features/           # Cucumber feature files
    ├── Properties/         # Configuration files
    ├── Screenshots/        # Test execution screenshots
    └── TestData/           # Excel test data files
```

## Test Scenarios

### 1. Search Functionality (`@tc001`)
- Validates product search with filters
- Tests price range, brand, RAM, and battery capacity filters
- Extracts and displays search results

### 2. Fashion Navigation (`@tc002`)
- Tests navigation through fashion categories
- Validates Men's section with price sorting
- Extracts product titles and details

### 3. Parameterized Search (`@tc003`)
- Data-driven search testing
- Tests multiple search terms: Mobile, TV, Laptop

### 4. Add to Cart (`@tc004`)
- Complete cart workflow validation
- Tests product selection, address entry, and cart addition
- Validates cart page display

### 5. Title & Price Extraction (`@tc005`)
- Extracts product titles and prices from search results

### 6. Excel-Driven Search (`@tc006`)
- Reads search terms from Excel file
- Validates search functionality with external data

## Setup

### Prerequisites
- Java 17 or higher
- Maven 3.6+
- Chrome or Firefox browser

### Installation

1. Clone the repository:
```bash
git clone <repository-url>
cd E-CommerceTestsSelenium
```

2. Install dependencies:
```bash
mvn clean install
```

### Configuration

Edit `src/test/resources/Properties/Config.Property`:
```properties
browser=chrome
url=https://www.flipkart.com/
```

Supported browsers: `chrome`, `firefox`

## Running Tests

### Run all tests:
```bash
mvn test
```

### Run specific test suite:
```bash
mvn test -Dtest=runner
```

### Run with TestNG XML:
```bash
mvn test -DsuiteXmlFile=testng.xml
```

### Run specific tags:
Modify `@CucumberOptions` in `runner.java`:
```java
tags="@tc001"  // Run specific test
tags="@Regression"  // Run all regression tests
```

## Features

### Page Object Model (POM)
- Organized page classes for maintainability
- Separation of test logic and page elements

### BDD with Cucumber
- Gherkin syntax for readable test scenarios
- Reusable step definitions

### Data-Driven Testing
- Excel integration for test data
- Parameterized scenarios with Examples

### Reporting
- ExtentReports for detailed HTML reports
- Screenshots on test failure
- Log4j logging for debugging

### Hooks & Utilities
- Automatic browser setup/teardown
- Screenshot capture on scenario completion
- Reusable Selenium functions

## Test Data

Excel test data location: `src/test/resources/TestData/FlipkartTestData.xlsx`

## Reports

- **ExtentReports**: Generated in `src/test/resources/Reports/`
- **Screenshots**: Saved in `src/test/resources/Screenshots/`
- **Logs**: Application logs in `application.log`

## Maven Profiles

Switch Java versions:
```bash
mvn test -Pjava8   # Use Java 8
mvn test -Pjava11  # Use Java 11
```

## Contributing

1. Follow Page Object Model pattern
2. Write BDD scenarios in Gherkin
3. Add step definitions in appropriate classes
4. Update feature files for new test cases
5. Ensure tests pass before committing

## License

This project is for educational and testing purposes.
