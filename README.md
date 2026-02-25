[![Review Assignment Due Date](https://classroom.github.com/assets/deadline-readme-button-22041afd0340ce965d47ae6ef1cefeee28c7c493a6346c4f15d667ab976d596c.svg)](https://classroom.github.com/a/-kFyiss-)
[![Open in Visual Studio Code](https://classroom.github.com/assets/open-in-vscode-2e0aaae1b6195c2367325f4f02e2d04e9abb55f0b24a779b69b11b9e10269abc.svg)](https://classroom.github.com/online_ide?assignment_repo_id=22766598&assignment_repo_type=AssignmentRepo)


Solid Violations & Solutions : 

Book.java has multiple responsibilities, this inherently breaks the single responsibility principle - entity data, lending state transitions, late-fee rules by type and reporting text.

Book.Java has if/else statements on type in the calculateLateFee method, this violates OCP.

Library.Java has a concrete dependency on Book.

My solution addresses these violations by moving lending behaviour out of Book.Java into separate classes with single responsibilities e.g LendingService.java and ReportService.java. 

The Library.java class contained logic which was checking conditionals based on type, I've replaced these with further abstractions so that instead of updating these conditionals each time a new type of book is added, you can just add in a class.

Library.java violated the Dependency Inversion Principle as contains hardcoded logic depending on the book type. Abstractions have been implemented, such as LendingService and PatronLoanPolicy which changes Library to become orchestration only.

For a lower level breakdown into specific work carried out, please refer to my Commit messages.


How to Run : 

Install the "Extension Pack for Java" if not already installed
Open LibraryTest.java
You'll see "Run Test" and "Debug Test" buttons above each test method
Click "Run Test" above the class name to run all tests

OR via CLI navigate to he local directory and run : 

javac -cp "lib\junit-platform-console-standalone-1.13.0-M3.jar" -d bin com\uws\solid\excercise\*.java

To then run all tests : 

java -jar lib\junit-platform-console-standalone-1.13.0-M3.jar --class-path bin --scan-class-path
