[![Review Assignment Due Date](https://classroom.github.com/assets/deadline-readme-button-22041afd0340ce965d47ae6ef1cefeee28c7c493a6346c4f15d667ab976d596c.svg)](https://classroom.github.com/a/-kFyiss-)
[![Open in Visual Studio Code](https://classroom.github.com/assets/open-in-vscode-2e0aaae1b6195c2367325f4f02e2d04e9abb55f0b24a779b69b11b9e10269abc.svg)](https://classroom.github.com/online_ide?assignment_repo_id=22766598&assignment_repo_type=AssignmentRepo)






Excercise 1. 
______________________________
Single Responsibility Principle

original `Book` class was doing too much — it held book data, managed lending, calculated late fees, and generated reports all in one place.

Fixed by splitting The class  into four focused classes, each with one job:

Book.java— stores book data only (id, title, author, type)
BookLending.java— handles checkout, returns, and lending periods
LateFeeCalculator.java— works out late fees by on book type
BookReportGenerator.java— produces  report strings



Exercise 2. 
_______________________________
Open/Closed Principle 

`LateFeeCalculator` used a `switch` statement on a  `String` type. Adding any new book type meant opening and editing that class 

Fixed by introducing `BookType` interface   with two methods: `getTypeName()` and `getDailyLateFee()`. Each book type is  its own class:

Adding a new book type now only requires creating one new file — nothing else needs to change.


Exercise 3
_________________________________

Dependency Inversion Principle

The `Library` class directly depended on concrete book type implementations (e.g. `PhysicalBookType`, `EBookType`) when working out lending periods.

Fixed by changing the `Library` to depend on the `BookType` abstraction instead of specific classes. Lending period  was moved into a private  method `getLendingPeriod()` that works with any `BookType` implementation. Adding a new book type like `DigitalComic` only requires creating a class implementing `BookType` — the `Library` class works with it automatically, no modifications needed.


Excercise 4
____________________________________________
Magic Numbers
All magic numbers (lending periods and late fee rates) were replaced with named constants in LendingPeriod and LateFee, so any change should be a one-line edit in one place.
