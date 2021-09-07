Feature: As an Automation Tester, I want to transfer funds to different account

  Scenario Outline: Verify transfer funds

                                    ### Provide details of user for registration ###
    Given Accounts Overview
    Then Transfer funds
    And verify the transfer amount

    Examples:
      |  |
