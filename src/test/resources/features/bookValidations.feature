Feature: book categories

  @db
  Scenario: Verify book information with db
    #Given user is in the login page
    #And user logins to application as a librarian
    #And user navigates to "Books" page
    #When user opens book "Chordeiles minor"
    #Then book information must match the database for "Chordeiles minor"

  # create scenario outline
  # compare users , books and borrowed books
  # go to users, look for user with specific id , and compare user info with database
  # go to the same place, change user group and save changes and verify if it is updated in the database or not
  # make status inactive, check if it is inactive in database or not
  # go to user, edit user and compare the info with db
  # books, add new book, put info, save, get from db and compare
  # edit book, change existing book info, change author, and compare with db
