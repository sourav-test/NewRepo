Feature: As an Automation Tester, I want to login and verify the registration details.

  Scenario Outline: Verify login details

                                    ### Provide details of user for registration ###
    Given Login for Account details
    Then Provide all the value for login "<RowNumber>"
    And Click on Login button
    Then User creates account "<RowNumber>"
    And User verify account details
    And User verify account id


    Examples:
      | RowNumber |
      | 1 |