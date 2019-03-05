

Scenario: Load the scope sheet and verify the CAPEX cost calculation
Given a user is logged into C55
When a user launch Cost Estimation tool 271025
And a user click generate button
And a scope sheet is returned with Draft Generated
And a user click cost button
Then verify the cost calculation 25,157,324.66


Scenario: Can add a new asset and generate cost successfully
Given a user is logged into C55
When a user launch Cost Estimation tool 275800
And a user add a new asset
And a user amend a new attribute 1
And a user click generate button
Then verify the cost can be generated successfully

Scenario: Can delete a new asset and generate cost without error
Given a user is logged into C55
When a user launch Cost Estimation tool 275800
And a user delete a new asset
And a user click generate button
Then verify the cost can be generated successfully

