Feature: Login Test 

Background: 
	Given User is on home page
	When User clicks on login 
	And  User enters username and password
	Then User must be logged in and display username on the web site
	
Scenario: Add to cart 
	When User clicks Electronics 
	And Selects Smartphone
	And Selects Add to Cart button 
	Then Item should be added to cart 
	
Scenario: Go to Cart 
	When User clicks Shopping Cart 
	Then User will be redirected to Shopping Cart page 
	
Scenario: Confirm Order 
	When User complete the Checkout Information page
#	And complete the Billing Shipping address section 
#	And complete Shipping method 
#	And complete the payment method 
#	And complete the payment information section
#	And Click Confirm button 
	Then will see a message on the screen that the order is completed  
		
Scenario: Successful Logout
	When User clicks on the logout link 
	Then User will be logged out 
	