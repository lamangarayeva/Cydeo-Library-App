Feature: Library app login feature
  User Story:
  As a user, I should be able to login with
  correct
  credentials to different accounts

  Background: Assuming user is on the login page
    Given user is on the login page

  @librarian @employee
  Scenario: Login as librarian
    When user enters librarian username "librarian180@library"
    And user enters librarian password "OTnz2koH"
    Then user should see the dashboard

  @student
  Scenario: Login as student
    When user enters student username "student368@library"
    And user enters student password "GXGFyslS"
    Then user should see the dashboard

  Scenario: Login as librarian same line
    When user enters credentials using "librarian180@library" and "OTnz2koH"
    Then user should see the dashboard
    And there should be 9524 users


