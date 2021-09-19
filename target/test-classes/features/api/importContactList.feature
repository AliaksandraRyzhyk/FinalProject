@Import
Feature: Import contacts

  Scenario: Import contacts to send email
    Then Get email address list
    Then Add email address of a contact to one list
    Then Exclude e-mail address of a contact from one list
    Then Unsubscribe e-mail address of a contact from one list (tag unsubscribed)
    Then Get the final contact list