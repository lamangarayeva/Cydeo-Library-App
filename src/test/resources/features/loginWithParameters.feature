Feature: Library app login feature
  User Story:
  As a user, I should be able to login with correct credentials to different accounts

  Background: Assuming user is on the login page
    Given user is on the login page

  @librarian @employee
  Scenario: Login as librarian
    When user enters librarian username "librarian1@library"
    And user enters librarian password "qU9mrvur"
    Then user should see the dashboard

  @student
  Scenario: Login as student
    When user enters student username "student1@library"
    And user enters student password "d5fv9BtX"
    Then user should see the dashboard

  Scenario: Login as librarian in the same same line
    When user enters credentials using "librarian1@library" and "qU9mrvur"
    Then user should see the dashboard
    And there should be 171 users


