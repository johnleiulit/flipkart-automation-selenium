Feature: To validate the Flipkart Application

Background:

Given Launch the Flipkart Application
When Close the popup
Then it should navigate to the Home Page

@tc001 @Regression
Scenario: To validate the Search Functionality

Given User enter the Text in the Search field
When Click the search button
Then it Should navigate to the search result page and display relevant details
Then Extract the Results and print in console
And Select Minimum and Maximum Amount
And Select the Brand
And Select the Ram
And Select the Batterry Capacity
Then It should display the Relevent result

@tc002 @Regression
Scenario: To validate the Mens Functionality

Given User to move the Fashion Link
When enter the Text in the Search field
And Click the Search button
Then It should navigate to the search result page
When Cursor to move Men Link
And Click top wear arrow
And Click price high to low link
Then It should display the relevant details and get title

@tc003 @Regression
Scenario Outline: To validate the search functionality with different values

Given Enter the "<searchtext>" in the search field
When click the search button
Then It should navigate to the next page and display the corresponding page

Examples:
|searchtext|
|Mobile|
|Tv|
|Laptop|
|Speaker|
|T shirt|

@tc004 @Regression
Scenario: To validate the add to cart functionality

Given User hovers the login link
And User clicks on flipkart plus zone
And User hovers over Home&Furniture link
And User clicks the Paintings from the dropdown
Then User should be navigated to Paintings page

When Scroll down the page and click one particular result
Then User should be navigated to the Product Detail page

When User clicks select delivery address
And User enters the pin code in the search field
And Select an address
And User clicks the confirm button
And User clicks the add to cart button
Then Product should be added to cart successfully

When User clicks on Cart icon
Then User should be navigated to Cart page
And It should displayed the order in the cart

@tc005 @Regression
Scenario: To get title and price from search result

Given User enters the search text in the search filed
When User clicks the search icon
Then It should display the search result and get title and price

@tc006 @Regression
Scenario: To text the search functionality with excel sheet

Given User enters search text in the search field
When User clicks seach icon
Then It should display the relevant result


