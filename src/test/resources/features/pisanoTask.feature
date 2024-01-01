Feature:  Send Feedback
  Background:
    Given Navigate to given Url
    Then Access to the given Widget
    Then Open the Send Feedback Screen



  Scenario:  Fill and click all related fields with meaningful test data (using a faker library is highly
  welcome) and validate message on last page

    Then Fills in and Submits User pozitive Feedback
    And Verify that user feedback is successful

  Scenario: Reject User agreement and validate if you have been kicked to the first page
    Then Fills in and Submits User Feedback
    And Verify that User have been kicked to the first page
