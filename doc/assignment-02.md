# Assigment 2
Library Management System using Binary Search Tree data structure

## INTRODUCTION

Your second assignment in this block will be using binary search tree data struture for implementing a small Library Management System  (LMS) in Java language.
LMS manages information about books, readers and  book lending items. These information are:

*Book specification*

`String code`: the code of the book (this is the key of the tree and thus should be unique).   
`String name`: the title of the book.   
`int quantity`: the number of  books with the same code the library has.   
`int lended`: the number of  books with the same code, which are still lended. Condition: lended ≤ quantity.   
`double price`: The price of the book.   

## YOUR TASKS

You should use a binary search tree to store data to build a class which provide a Book Service for the web server. You should create the data structures from scratch, do not use structures available in java. The class should implement the following interface

```
interface BookService {

 boolean addBook(Book book); // 1. Add book, return true if succeed
 
 void printBook(Book book); 
 
 void showBook(int method); // 2-3.print the book in method 1:In-order, method 2: Breadth-first traverse
 
 Book searchBookbyCode(String bookCode); // 4.search Book by Code
 
 int countBook(); // 5.search Book by Code
 
 boolean removeBook(String bookCode); // 6.remove book
 
 void printAvailableBook(); //7. print all available books whose lended < quantity
 
 void balancing(); //8.simply balance the tree
 
 Book searchBookbyName(String name); //9.simply balance the tree
}

```

1. Add book to BS Tree. Return true if successful.
2. Print the book list with In-order travesal. The method is set 1 when calling the function.
3. Print the book list with Breadth-first travesal. The method is set 1 when calling the function.
4. Search the book by Book code. Return the found book.
5. Count all the books in the library. 
6. Remove a book from the library by the code.
7. Print all available books. The avaiable books are books whose lended < quantity
8. Balance the tree with simply balancing.
9. Make the second tree to search the book by name.

## TASK ASSESSMENT

Your service will be tested with 5 test cases for each function. Your score is  Total passed tests / 45.

You may be asked to modify immediately and to explain your assignment in the interview to be sure that you are really the author  of the assignment you submitted.
