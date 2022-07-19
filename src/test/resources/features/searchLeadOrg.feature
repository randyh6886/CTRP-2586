Feature:  Search for Lead Organization
  Scenario:  Search for CTEP ID WQ456
    Given I click on organizations menu option
    When I type WQ456 in CTEP ID
    Then I select Research organization into Organization Type
    Then I click on Search
    Then I assert Novartis Pharmaceuticals matches Novartis Pharmaceuticals
    Then I click logout