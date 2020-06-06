# CSX42: Design Patterns - Assignment 3


-----------------------------------------------------------------------
-----------------------------------------------------------------------
Citations :

https://www.geeksforgeeks.org/java/
https://stackoverflow.com/
https://www.tutorialspoint.com/design_pattern/state_pattern.html

Citations for BST :
1)https://www.geeksforgeeks.org/binary-search-tree-set-1-search-and-insertion/
2)https://www.sanfoundry.com/java-program-implement-binary-search-tree/

-----------------------------------------------------------------------
-----------------------------------------------------------------------
Following are the commands and the instructions to run ANT on your project.

-----------------------------------------------------------------------
## Instruction to clean:

####Command: ant -buildfile src/build.xml clean

Description: It cleans up all the .class files that were generated when you
compiled your code.

-----------------------------------------------------------------------
## Instruction to compile:

####Command: ant -buildfile src/build.xml all

Description: Compiles your code and generates .class files inside the BUILD folder.

-----------------------------------------------------------------------
## Instruction to run:

In the folder: "Assign_3/studentCoursesBackup" run the following command:

####Command: ant -buildfile src/build.xml run -Darg0=input.txt -Darg1=delete.txt -Darg2=output1.txt -Darg3=output2.txt -Darg4=output3.txt -Darg5=3

for -Darg5 enter values between 0 to 4

-----------------------------------------------------------------------
## Description:

I have used data structures BST and ArrayList.
BST is easy to operate as we get sorted tree and Arraylist is used to store course list and clone tree list.
For 'S' Binary Search Tree with n nodes, its complexity is O(log n) for Search.
For Insert operation : O(log n) in average case and O(n) in worst case.
For traversal of BST it is O(n).
Here we are implementing observer pattern.
So whenever original tree is updated, it calls notifyall() method for its listeners to take backup i.e. to make required changes for cloning.


-----------------------------------------------------------------------
### Academic Honesty statement:
-----------------------------------------------------------------------

"I have done this assignment completely on my own. I have not copied
it, nor have I given my solution to anyone else. I understand that if
I am involved in plagiarism or cheating an official form will be
submitted to the Academic Honesty Committee of the Watson School to
determine the action that needs to be taken. "

Date: -- 07/09/2019
