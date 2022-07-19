Feature: Library app search results verification

  User story:
  As a user, I should be able to login as librarian. When I go to Users page, table

Scenario: Table columns names
  Given user is on the login page
  And user enters librarian username
  And user enters librarian password
  And user clicks on "Users" link
  Then table should have following column names:
    | Actions   |
    | User ID   |
    | Full Name |
    | Email     |
    | Group     |
    | Status    |