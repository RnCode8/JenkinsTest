# Part 1 Boundary Analysis

## Question 1 Multiple Choice

The correct answer would be A. On = 570 and Off = 571 because 570 is the value that meets the condition off numberOfPoints = <= 570 
while the others either aren't in the boundary or smaller than the 570. Off point of 571 is the closest value outside where the condition fails.

## Question 2 Short Answer Question

Using the definitions for on-point and off-point our on point would be 10 the only value that's true and the closest values since this is a equality question
are 9 and 11. (On-point = 10, Off-point = 9,11)

## Question 3 Short Answer Question

As a tester I would like the testing of the letter length to be exact, or lowercase letters. Along with that would be testing the number format, such as
it being smaller like 999 or above the maximum of our limit 4001 and even the special case of a zero starting number such as 0400.

# Part 2 Specification-Based Testing

## Question 1 Understand the Requirements

Method: public static List add? 

Inputs: left and right - lists digits that are not negative, empty list should be 0

Output: returns the digits representing the sum of the two numbers, throws IllgealArgument for any digit outside 0-9

Behavior: Adds digits, has a carry function, removes leading zeros, returns result list

# Part 3 Bug Check

## Does the program have a bug?

Looking our behavior that's described for the program there does not seem to be any apparent bugs that I can see. I would have to personally say there is
no bug within the code. At least that's how it seems from the reading of the behaviors. Everything inputted allows for the sum to be returned intendedly. 
This does not mean there are no bugs but currently as a tester and going through each of the intended behaviors, everything seems to match 
it's respective output and match the goal of the outputs I want. Of course there could be more things that are wanted from the code that I may be missing

### Justification

The file states "It adds these numbers and returns the result also as a list of digits."
The program adds our numbers and the result is the fully combined digits as a list

"Each element in the left and right lists should be a number from [0-9]. An IllegalArgumentException is thrown in case this pre-condition does not hold."
This also happens according to the testing.

" @param left  a list containing the left number. Null returns null, empty means 0. 
@param right a list containing the right number. Null returns null, empty means 0. 
@return the sum of left and right, as a list "
I believe this is also accounted for in the tests.

There are more such as the leading zeros and the reverse lists which also work so from what can be seen all inputs results into the expected output