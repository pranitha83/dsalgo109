Feature: Evaluate Tree module

  Scenario: user is able to navigate to "Tree" Page
    Given user is on the "home page" after logged in
    When user selects Tree item from the drop down menu
    Then user should be redirected to the "Tree" Page

  Scenario: user is able to navigate to "Overview of Trees" page
    Given user is on the "Tree page" after logged in
    When user clicks on the Overview of Trees link
    Then user should be redirected to the "Overview of Trees" of tree Page

  Scenario: user is able to navigate to a page having an tryEditor from Overview of Trees page
    Given user is on the "overview of trees" after logged in
    When user clicks "Try Here" button in a "tree" page
    Then user should be redirected to a page having tryEditor with a Run button to test

  Scenario Outline: user is able to run code in tryEditor for Overview of Trees page
    Given The user is in trees page having an tryEditor with a Run button to test
    When The user gets input from sheet "<Sheetname>" and <RowNumber> in trees
    And The user clicks on Run button after Entering valid python code in trees tryEditor
    Then The user should be presented with Run output for trees

    Examples: 
      | Sheetname | RowNumber |
      | Sheet1    |         0 |

  Scenario Outline: The user is able to get the alert message for invalid syantax for Overview of Trees page
    Given The user is in trees page having an tryEditor with a Run button to test
    When The user gets invalid input from sheet "<Sheetname>" and <RowNumber> in trees
    And The user clicks on Run button after Entering invalid python code in trees tryEditor
    Then The user should get the alert message for trees

    Examples: 
      | Sheetname | RowNumber |
      | Sheet1    |         1 |

  Scenario: The user is able to navigate to "Terminologies" Page
    Given The user is on the "Tree page" after logged in
    When The user clicks on the Terminologies button
    Then The user should be directed to the terminologieslink "Terminologies" of tree Page

  Scenario: The user is able to navigate to Terminologies page having an tryEditor
    Given The user is on the "terminologies page" after logged in
    When The user clicks tryhere "Try Here" button in a "Terminologies" page
    Then The user should be redirected to a page having an tryEditor with a Run button to test for terminologies page

  Scenario Outline: The user is able to run code in tryEditor for Terminologies page
    Given The user is in trees page having an tryEditor with a Run button to test for terminologies page
    When The user gets input from sheet "<Sheetname>" and <RowNumber> in trees for terminologies page
    And The user clicks on Run button after Entering valid python code in trees tryEditor for terminologies
    Then The user should be presented with Run output for trees in terminologies page

    Examples: 
      | Sheetname | RowNumber |
      | Sheet1    |         0 |

  Scenario Outline: The user is able to get the error message for invalid syntax for Terminologies page
    Given The user is in trees page having an tryEditor with a Run button to test
    When The user gets invalid input from sheet "<Sheetname>" and <RowNumber> in trees for terminologies page
    And The user clicks on Run button after Entering invalid python code in trees tryEditor for terminologies page
    Then The user should get the error message for trees in terminologies

    Examples: 
      | Sheetname | RowNumber |
      | Sheet1    |         1 |

  Scenario: The user is able to navigate to "Types of Trees" Page
    Given The user is on the "Tree page" after logged in
    When The user clicks on the Types of Trees button
    Then The user should be directed to the typesOftreeslink "Types of Trees" in tree Page
    
  Scenario: The user is able to navigate to a page having an tryEditor from Types of Trees page
    Given The user is on the "types of trees" after logged in
    When The user clicks tryhere "Try Here" button in a "types of tree" link page
    Then The user should be redirected to a page having tryEditor with a Run button to test for typesoftrees
    

  Scenario Outline: The user is able to run code in tryEditor for Types of Trees page
    Given The user is in trees page having tryEditor with a Run button to test for typesoftrees
    When The user gets input from sheet "<Sheetname>" and <RowNumber> in trees for typesoftrees
    And The user clicks on Run button after Entering valid python code in trees tryEditor for typesoftrees
    Then The user should be presented with Run output for typesoftrees in trees 
    Examples: 
      | Sheetname | RowNumber |
      | Sheet1    |         0 |

  Scenario Outline: The user is able to get the error message for invalid syntax for Types of Trees page
    Given The user is in trees page having an tryEditor with a Run button to test
    When The user gets invalid input from sheet "<Sheetname>" and <RowNumber> in trees for ttp
    And The user clicks on Run button after Entering invalid python code in trees tryEditor
    Then The user should get the alert message for trees in ttp

    Examples: 
      | Sheetname | RowNumber |
      | Sheet1    |         1 |

  Scenario: The user is able to navigate to "Tree Traversals" Page
    Given The user is on the "Tree page" after logged in
    When The user clicks on the Tree Traversals button
    Then The user should be directed to the ttlink "Tree Traversals" of tree Page

  Scenario: The user is able to navigate to a page having an tryEditor from Tree Traversals Page
    Given The user is on the "tree traversals" after logged in
    When The user clicks "Try Here" button in a "tree traversals" ttlink page
    Then The user should be redirected to a page having an tryEditor with a Run button to test for ttpage

  Scenario Outline: The user is able to run code in tryEditor for Tree Traversals Page
    Given The user is in trees page having an tryEditor with a Run button to test for ttl
    When The user gets input from sheet "<Sheetname>" and <RowNumber> in trees for ttl
    And The user clicks on Run button after Entering valid python code in trees tryEditor for ttl
    Then The user should be presented with Run output for trees

    Examples: 
      | Sheetname | RowNumber |
      | Sheet1    |         0 |

  Scenario Outline: The user is able to get the error message for invalid syntax for Tree Traversals Page
    Given The user is in trees page having an tryEditor with a Run button to test
    When The user gets invalid input from sheet "<Sheetname>" and <RowNumber> in trees for ttl
    And The user clicks on Run button after Entering invalid python code in trees tryEditor for ttl
    Then The user should get the error message for trees for ttl

    Examples: 
      | Sheetname | RowNumber |
      | Sheet1    |         1 |

  Scenario: The user is able to navigate to "Traversals illustration" Page
    Given The user is on the "Tree page" after logged in
    When The user clicks on the Traversal illustration button
    Then The user should be directed to the "Traversals-Illustration" of tree Page for ti

  Scenario: The user is able to navigate to a page having an tryEditor from Traversals-Illustration Page
    Given The user is on the "traversal illustration" after logged in
    When The user clicks "Try Here" button in a "traversal illustration" page for ti
    Then The user should be redirected to a page having an tryEditor with a Run button to test for ti

  Scenario Outline: The user is able to run code in tryEditor for Traversals-Illustration Page
    Given The user is in trees page having an tryEditor with a Run button to test for ti
    When The user gets input from sheet "<Sheetname>" and <RowNumber> in trees for ti
    And The user clicks on Run button after Entering valid python code in trees tryEditor for ti
    Then The user should be presented with Run output for trees

    Examples: 
      | Sheetname | RowNumber |
      | Sheet1    |         0 |

  Scenario Outline: The user is able to get the error message for invalid syntax for Traversals-Illustration Page
    Given The user is in trees page having an tryEditor with a Run button to test
    When The user gets invalid input from sheet "<Sheetname>" and <RowNumber> in trees for ti
    And The user clicks on Run button after Entering invalid python code in trees tryEditor for ti
    Then The user should get the error message for trees for ti

    Examples: 
      | Sheetname | RowNumber |
      | Sheet1    |         1 |

  Scenario: The user is able to navigate to "Binary trees" Page
    Given The user is on the "Tree page" after logged in
    When The user clicks on the binary trees button
    Then The user should be directed to the "Binary Trees" of tree Page for btl

  Scenario: The user is able to navigate to a page having an tryEditor from Binary Trees Page
    Given The user is on the "binary trees" after logged in
    When The user clicks "Try Here" button in a "binary tree" page for btl
    Then The user should be redirected to a page having an tryEditor with a Run button to test for btl

  Scenario Outline: The user is able to run code in tryEditor for Binary Trees Page
    Given The user is in trees page having an tryEditor with a Run button to test for bt
    When The user gets input from sheet "<Sheetname>" and <RowNumber> in trees for bt
    And The user clicks on Run button after Entering valid python code in trees tryEditor for bt
    Then The user should be presented with Run output for trees

    Examples: 
      | Sheetname | RowNumber |
      | Sheet1    |         0 |

  Scenario Outline: The user is able to get the error message for invalid syntax for Binary Trees Page
    Given The user is in trees page having an tryEditor with a Run button to test
    When The user gets invalid input from sheet "<Sheetname>" and <RowNumber> in trees for bt
    And The user clicks on Run button after Entering invalid python code in trees tryEditor for bt
    Then The user should get the error message for trees for bt

    Examples: 
      | Sheetname | RowNumber |
      | Sheet1    |         1 |

  Scenario: The user is able to navigate to "Types of Binary trees" Page
    Given The user is on the "Tree page" after logged in
    When The user clicks on the types of binary trees button for tbt
    Then The user should be directed to the "Types of Binary Trees" of tree Page 

  Scenario: The user is able to navigate to a page having an tryEditor from Types of Binary Trees Page
    Given The user is on the "types of binary trees" after logged in
    When The user clicks "Try Here" button in a "types of binary trees" page
    Then The user should be redirected to a page having an tryEditor with a Run button to test for tbt

  Scenario Outline: The user is able to run code in tryEditor for Types of Binary Trees Page
    Given The user is in trees page having an tryEditor with a Run button to test for tbt
    When The user gets input from sheet "<Sheetname>" and <RowNumber> in trees for tbt
    And The user clicks on Run button after Entering valid python code in trees tryEditor for tbt
    Then The user should be presented with Run output for trees for tbt

    Examples: 
      | Sheetname | RowNumber |
      | Sheet1    |         0 |

  Scenario Outline: The user is able to get the error message for invalid syntax for Types of Binary Trees Page
    Given The user is in trees page having an tryEditor with a Run button to test
    When The user gets invalid input from sheet "<Sheetname>" and <RowNumber> in trees for tbt
    And The user clicks on Run button after Entering invalid python code in trees tryEditor for tbt
    Then The user should get the error message for trees for tbt

    Examples: 
      | Sheetname | RowNumber |
      | Sheet1    |         1 |

  Scenario: The user is able to navigate to Implementation in Python Page
    Given The user is on the "Tree page" after logged in
    When The user clicks on the Implementation in Python button
    Then The user should be directed to the "Implementation in Python" of tree Page for ip

  Scenario: The user is able to navigate to a page having an tryEditor from Implementation in Python Page
    Given The user is on the "Implementation in Python" after logged in
    When The user clicks "Try Here" button in a "implementation in python" page for ip
    Then The user should be redirected to a page having an tryEditor with a Run button to test

  Scenario Outline: The user is able to run code in tryEditor for Implementation in Python Page
    Given The user is in trees page having an tryEditor with a Run button to test for ip
    When The user gets input from sheet "<Sheetname>" and <RowNumber> in trees for ip
    And The user clicks on Run button after Entering valid python code in trees tryEditor for ip
    Then The user should be presented with Run output for trees for ip

    Examples: 
      | Sheetname | RowNumber |
      | Sheet1    |         0 |

  Scenario Outline: The user is able to get the error message for invalid syntax for Implementation in Python Page
    Given The user is in trees page having an tryEditor with a Run button to test for ip
    When The user gets invalid input from sheet "<Sheetname>" and <RowNumber> in trees for ip
    And The user clicks on Run button after Entering invalid python code in trees tryEditor for ip
    Then The user should get the error message for trees for ip

    Examples: 
      | Sheetname | RowNumber |
      | Sheet1    |         1 |

  Scenario: The user is able to navigate to binary tree traversals Page
    Given The user is on the "Tree page" after logged in
    When The user clicks on the binary tree traversals button for btt
    Then The user should be directed to the "Binary Tree Traversals" of tree Page

  Scenario: The user is able to navigate to a page having an tryEditor from Binary Tree Traversals page
    Given The user is on the "Binary Tree Traversals" after logged in
    When The user clicks "Try Here" button in a "binary tree traversals" page
    Then The user should be redirected to a page having an tryEditor with a Run button to test for btt

  Scenario Outline: The user is able to run code in tryEditor for Binary Tree Traversals page
    Given The user is in trees page having an tryEditor with a Run button to test for btt
    When The user gets input from sheet "<Sheetname>" and <RowNumber> in trees for btt
    And The user clicks on Run button after Entering valid python code in trees tryEditor for btt
    Then The user should be presented with Run output for trees for btt

    Examples: 
      | Sheetname | RowNumber |
      | Sheet1    |         0 |

  Scenario Outline: The user is able to get the error message for invalid syntax for Binary Tree Traversals page
    Given The user is in trees page having an tryEditor with a Run button to test
    When The user gets invalid input from sheet "<Sheetname>" and <RowNumber> in trees for btt
    And The user clicks on Run button after Entering invalid python code in trees tryEditor for btt
    Then The user should get the error message for trees for btt

    Examples: 
      | Sheetname | RowNumber |
      | Sheet1    |         1 |

  Scenario: The user is able to navigate to Implementation of Binary Trees Page
    Given The user is on the "Tree page" after logged in
    When The user clicks on the Implementation of Binary Trees button for ibt
    Then The user should be directed to the "Implementation of Binary Trees" of tree Page for ibt

  Scenario: The user is able to navigate to a page having an tryEditor from Implementation of Binary Trees Page
    Given The user is on the "Implementation Of Binary Trees" after logged in 
    When The user clicks "Try Here" button in a "Implementation of binary trees" page for ibt
    Then The user should be redirected to a page having an tryEditor with a Run button to test for ibt

  Scenario Outline: The user is able to run code in tryEditor for Implementation of Binary Trees Page
    Given The user is in trees page having an tryEditor with a Run button to test for ibt
    When The user gets input from sheet "<Sheetname>" and <RowNumber> in trees for ibt
    And The user clicks on Run button after Entering valid python code in trees tryEditor for ibt
    Then The user should be presented with Run output for trees for ibt

    Examples: 
      | Sheetname | RowNumber |
      | Sheet1    |         0 |

  Scenario Outline: The user is able to get the error message for invalid syntax for Implementation of Binary Trees Page
    Given The user is in trees page having an tryEditor with a Run button to test
    When The user gets invalid input from sheet "<Sheetname>" and <RowNumber> in trees for ibt
    And The user clicks on Run button after Entering invalid python code in trees tryEditor for ibt
    Then The user should get the error message for trees for ibt

    Examples: 
      | Sheetname | RowNumber |
      | Sheet1    |         1 |

  Scenario: The user is able to navigate to Applications of Binary Trees Page
    Given The user is on the "Tree page" after logged in
    When The user clicks on the Applications of Binary Trees button for abt
    Then The user should be directed to the "Applications of Binary trees" of tree Page for abt

  Scenario: The user is able to navigate to a page having an tryEditor from Applications of Binary trees Page
    Given The user is on the "Applications Of Binary Trees" after logged in
    When The user clicks "Try Here" button in a "Applications of binary trees" page for abt
    Then The user should be redirected to a page having an tryEditor with a Run button to test for abt

  Scenario Outline: The user is able to run code in tryEditor for Applications of Binary trees Page
    Given The user is in trees page having an tryEditor with a Run button to test for abt
    When The user gets input from sheet "<Sheetname>" and <RowNumber> in trees for abt
    And The user clicks on Run button after Entering valid python code in trees tryEditor for abt
    Then The user should be presented with Run output for trees for abt

    Examples: 
      | Sheetname | RowNumber |
      | Sheet1    |         0 |

  Scenario Outline: The user is able to get the error message for invalid syntax for Applications of Binary trees Page
    Given The user is in trees page having an tryEditor with a Run button to test
    When The user gets invalid input from sheet "<Sheetname>" and <RowNumber> in trees for abt
    And The user clicks on Run button after Entering invalid python code in trees tryEditor for abt
    Then The user should get the error message for trees for abt

    Examples: 
      | Sheetname | RowNumber |
      | Sheet1    |         1 |

  Scenario: The user is able to navigate to "Binary Search Trees" Page
    Given The user is on the "Tree page" after logged in
    When The user clicks on the Binary Search Trees button for bst
    Then The user should be directed to the "Binary Search Trees" of tree Page for bst

  Scenario: The user is able to navigate to a page having an tryEditor from Binary Search Trees Page
    Given The user is on the "Binary Search Trees" after logged in
    When The user clicks "Try Here" button in a "Binary Search Trees" page for bst
    Then The user should be redirected to a page having an tryEditor with a Run button to test for bst

  Scenario Outline: The user is able to run code in tryEditor for Binary Search Trees Page
    Given The user is in trees page having an tryEditor with a Run button to test for bst
    When The user gets input from sheet "<Sheetname>" and <RowNumber> in trees for bst
    And The user clicks on Run button after Entering valid python code in trees tryEditor for bst
    Then The user should be presented with Run output for trees for bst

    Examples: 
      | Sheetname | RowNumber |
      | Sheet1    |         0 |

  Scenario Outline: The user is able to get the error message for invalid syntax for Binary Search Trees Page
    Given The user is in trees page having an tryEditor with a Run button to test
    When The user gets invalid input from sheet "<Sheetname>" and <RowNumber> in trees for bst
    And The user clicks on Run button after Entering invalid python code in trees tryEditor for bst
    Then The user should get the error message for trees for bst

    Examples: 
      | Sheetname | RowNumber |
      | Sheet1    |         1 |

  Scenario: The user is able to navigate to "Implementation of BST" Page
    Given The user is on the "Tree page" after logged in
    When The user clicks on the Implementation of BST button for ibst
    Then The user should be directed to the "Implementation Of BST" of tree Page for ibst

  Scenario: The user is able to navigate to a page having an tryEditor from Implementation Of BST Page
    Given The user is on the "Implementation Of BST" after logged in
    When The user clicks "Try Here" button in a "Implementation of BST" page for ibst
    Then The user should be redirected to a page having an tryEditor with a Run button to test for ibst

  Scenario Outline: The user is able to run code in tryEditor for Implementation Of BST Page
    Given The user is in trees page having an tryEditor with a Run button to test for ibst
    When The user gets input from sheet "<Sheetname>" and <RowNumber> in trees for ibst
    And The user clicks on Run button after Entering valid python code in trees tryEditor for ibst
    Then The user should be presented with Run output for trees for ibst

    Examples: 
      | Sheetname | RowNumber |
      | Sheet1    |         0 |

  Scenario Outline: The user is able to get the error message for invalid syntax for Implementation Of BST Page
    Given The user is in trees page having an tryEditor with a Run button to test
    When The user gets invalid input from sheet "<Sheetname>" and <RowNumber> in trees for ibst
    And The user clicks on Run button after Entering invalid python code in trees tryEditor for ibst
    Then The user should get the error message for trees for ibst

    Examples: 
      | Sheetname | RowNumber |
      | Sheet1    |         1 |

  Scenario: The user validating "Practice Questions" page
    Given The user is on the "Tree page" after logged in
    When The user clicks on the Overview of Trees link
    When The user clicks on the Practice Questions in Overview of Trees
    Then The user should be directed to Practice Questions of tree page Page
