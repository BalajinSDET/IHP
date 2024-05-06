@RegressionTest
Feature: This is the Job Seeker sign in scenario
  I want to sign in as Job Seeker of Ihp application

  Background:
    Given User is enter the Ihp website URL
    When the user click on login as job seeker at index page
    Then User should navigated to the sign in page

  @RegressionTest
  Scenario Outline: Verify that sign in as Job Seeker functionality of the application
    And The user enter their Email Id as "<email>" and Password as "<password>"
    When User clicks on the sign in button
    And User should navigated to the KYC Verification
    And User clicks the email verification radio button and then user clicks the submit button
    Then User navigates to the dashboard page of the Ihp project successfully

    Examples:
      | email                 | password |
      | lgstester50@gmail.com | Test123  |

  @VerifyKeepMeSignInToThisDevice
  Scenario Outline: Verify that sign in as Job Seeker with keep me as sign to this device functionality

    And The user enter their Email Id as "<email>" and Password as "<password>"
    And User validate the keep me sign in to this device checkbox and Click the checkbox
    When User clicks on the sign in button
    And User should navigated to the KYC Verification
    And User clicks the email verification radio button and then user clicks the submit button
    Then User navigates to the dashboard page of the Ihp project successfully
    And User clicks the profile icon on job seeker dashboard page
    When the user clicks logout button on job seeker and user should navigated to the homepage of the Ihp application
    When The user should able to click on the Login as Job Seeker button in the HomePage
    Then User should navigated to the sign in page
    And The user enter their Email Id as "<email>" and Password as "<password>"
    And User validate the keep me sign in to this device checkbox
    When User clicks on the sign in button
    Then User navigates to the dashboard page of the Ihp project successfully

    Examples:
    #  | email                 | password |
      | lgstester50@gmail.com | Test123 |
      | lgstester50@gmail.com | Test123 |

