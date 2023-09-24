Feature: This is the equivalent of a test class

  Scenario: Customer make order in prestashop
    Given Open prestashop and registration new client
    Given Move cursor to menu accessories and click to home accessories
    Given Click and add to product with name mug the best
    And   Wait to block cart modal and  click close
    Given Click  add to cart button
    Then  View product label and equals "Mug The best is yet to come" on page
    Given Click to proceed to checkout button
    Given Complete address info
    And   Click continue
    And   Also click continue
    Given Click to payment method button
    And   Select Agree
    Given Click place order button
    Then  Find and equals info "Your order is confirmed"


  Scenario: As customer completes the Contact Us form
    Given Open prestashop and switch to frame
    When click the Contact Us button
    And Write email address
    And Write message
    And Click the send button
    Then Find message sent equals "Your message has been successfully sent to our team." on the page