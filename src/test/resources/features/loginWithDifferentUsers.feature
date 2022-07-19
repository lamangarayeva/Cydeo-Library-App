Feature: Data driven testing

  User story:
  As a user, I should be able to login with different users using their correct emails
  and passwords. When I login, I should be able to see username in the account username section.

  Scenario Outline: Verify user information <email>
    Given user is on the login page
    When user enters credentials using "<email>" and "<password>"
    Then account holder name should be "<name>"

    @students
    Examples:
      | email             | password | name            |
      | student1@library  | d5fv9BtX | Test Student 1  |
      | student2@library  | zyxa10vg | Test Student 2  |
      | student3@library  | rPjgZ86a | Test Student 3  |
      | student4@library  | pG3V6qaL | Test Student 4  |
      | student5@library  | i1oDgf2d | Test Student 5  |
      | student6@library  | NXhpXJdC | Test Student 6  |
      | student7@library  | QfYjDNXj | Test Student 7  |
      | student8@library  | 1DaJSz1z | Test Student 8  |
      | student9@library  | DFDYll1P | Test Student 9  |
      | student10@library | F8u6OrI2 | Test Student 10 |


    @librarians
    Examples:
      | email               | password | name              |
      | librarian1@library  | qU9mrvur | Test Librarian 1  |
      | librarian2@library  | uYrhHmmj | Test Librarian 2  |
      | librarian3@library  | DFvU4b1i | Test Librarian 3  |
      | librarian4@library  | 3lwxJ1Kk | Test Librarian 4  |
      | librarian5@library  | hj65YBiE | Test Librarian 5  |
      | librarian6@library  | QaG7mkXA | Test Librarian 6  |
      | librarian7@library  | C5WUiPUP | Test Librarian 7  |
      | librarian8@library  | UECJkTnl | Test Librarian 8  |
      | librarian9@library  | MSx8u9n4 | Test Librarian 9  |
      | librarian10@library | ZIkOcbCa | Test Librarian 10 |