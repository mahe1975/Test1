Feature: Save leadership team members info into a csv file
  
  @Smoke
  Scenario: Add name, position, and description into a .csv file
   Given Launch MailChimps web page
   When Navigate to MailChimps about page
   Then Add leadership team members info into a csv file
