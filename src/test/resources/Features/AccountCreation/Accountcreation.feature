Feature: As an Automation Tester, I want to register and verify the registration details.

  Scenario Outline: Verify registration of account

                            ### Provide details of user for registration ###
    Given Register for Account details
    Then Provide all the value for registration "<RowNumber>"
    And Click on Register

    Examples:
      | RowNumber |
      | 1 |