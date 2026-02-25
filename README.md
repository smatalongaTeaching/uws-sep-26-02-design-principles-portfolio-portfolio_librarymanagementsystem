# Library Management System (SOLID Portfolio)

## Overview
This project refactors an initial Library Management System to follow SOLID principles.  
Books are stored in an in-memory “database” (a `List<Book>` behind a repository abstraction).  
JUnit 5 tests demonstrate the lending rules and book-type late fee behaviour.

---

## Group Assignment – Team Members
- B01787017 – Dean Cain  
- B01838418 – Danny Cox  
- B01794144 – James Lough  

---

## SOLID Violations in the Original Code

### Single Responsibility Principle (SRP)
- `Book` handled multiple responsibilities: lending/check-out logic, late fee calculation, and report generation.
- `Library` handled lending rules and report formatting in addition to coordination logic.

### Open/Closed Principle (OCP)
- Book type behaviour was implemented using `if/else` string checks (e.g., `"physical"`, `"ebook"`, `"audio"`).
- Adding a new book type required modifying existing `Book` logic.

### Dependency Inversion Principle (DIP)
- `Library` depended directly on concrete implementations and managed a mutable `List<Book>` as storage.
- Lending rules were hard-coded into `Library`.

### Magic Numbers
- Lending periods were hard-coded (14, 30, 7) directly in logic.

---

## How This Solution Addresses Each Violation

### SRP
- Lending logic moved into `LendingService` (`DefaultLendingService`).
- `Book` now focuses only on book state and behaviour directly related to the book.
- Reporting logic was separated from core domain classes.

### OCP
- Introduced a `BookType` strategy interface.
- Book types (`PhysicalBookType`, `EBookType`, `AudioBookType`) encapsulate type-specific behaviour.
- Adding a new book type requires creating a new `BookType` implementation without modifying existing classes.

### DIP
- `Library` depends on abstractions:
  - `BookRepository`
  - `LendingService`
- `InMemoryBookRepository` provides the required simulated database implementation.

### Magic Numbers
- Lending periods are defined in `LendingPeriods` as named constants:
  - `STUDENT_DAYS`
  - `FACULTY_DAYS`
  - `REGULAR_DAYS`

---

## Project Structure (Key Classes)

- `Library` – Coordinates repository and lending service (high-level module)
- `BookRepository` / `InMemoryBookRepository` – Storage abstraction and implementation
- `LendingService` / `DefaultLendingService` – Lending rules
- `BookType` + implementations – Book-type-specific behaviour
- `LibraryTest` – Unit tests (JUnit 5)

---

## How to Compile and Run Tests

### Prerequisites
- Java (JDK) installed
- JUnit Console Launcher located at:
  `lib/junit-platform-console-standalone-1.13.0-M3.jar`

---

### Windows PowerShell (from repository root)

```powershell
New-Item -ItemType Directory -Force -Path out | Out-Null
$files = Get-ChildItem -Recurse -Filter *.java | ForEach-Object { $_.FullName }
javac -cp "lib\junit-platform-console-standalone-1.13.0-M3.jar" -d out $files
java -jar lib\junit-platform-console-standalone-1.13.0-M3.jar --class-path out --scan-class-path