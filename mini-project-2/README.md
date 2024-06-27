# mini-project-2
This program is a Library Management System that allows you to manage books in a library. The system provides functionalities to add, search, display, and delete books from the library's collection of books. The user interacts with the program through a menu interface.

## Features
1. **Add a Book**
- Users can add new books to the library. The system captures details such as reference number, title, author, ISBN, publication year, and whether the book is fiction or non-fiction. For fiction books, the genre is also captured, while for non-fiction books, the subject is recorded.
2. **Search Books**
- Users can search for books in the library by author, title, or category. The results to be displayed are all the books with the title/author containing the search keyword entered.
3. **Show All Books**
- The program can display all books currently stored in the library. 
4. **Delete a Book**
- Users can remove books from the library by entering the reference number of the book to be deleted.

## Executing program
1. In your **IntelliJ** environment, navigate to this directory `mini-project-2\src\main\java\com.altheacruz.library`
2. There are **two ways** to run the program.
 ### Option 1
 1. Open the `Main.java` file.
 2. On the top part of the window below the navigation bar, click on the **green arrow** next to the main method or **right-click on the file** and select "Run 'Main.main'".
 ### Option 2
 1. Open the Terminal. This is the third button from the bottom of the left panel.
 2. Navigate to the directory where the `pom.xml` file is located. By default, the terminal is in the root directory which is `Java-Intern_Althea-Cruz`. Hence, you need to enter `cd mini-project-2`
 3. Build the project by entering this command in the terminal `mvn clean install`
 4. Lastly, you can run the application by running the command `mvn exec:java`

## Program Flow
1. **Choose an Action**. The program will display a menu with the options.
2. After selecting an action, you will be prompted with input fields depending on your selection.
3. Your action will be logged in the console and it will also tell you whether it is successful or not.
4. After the action has been completed, the menu will be prompted again.
5. To exit, choose the "Exit" option from the menu.

## Sample run
```
====================================
   LIBRARY MANAGEMENT SYSTEM MENU   
====================================
[a] Add a book
[b] Search books
[c] Show all books
[d] Delete a book
[e] Exit
====================================
Action: c
All books in the library:
Displaying 5 of 5 results:
+-------+------------------------------------------------------------+-------------------------------------+---------------+-------+----------+-----------------------------------------------------+
| RefNo | Title                                                      | Author                              | ISBN          | Year  | Category | Additional information                              |
+-------+------------------------------------------------------------+-------------------------------------+---------------+-------+----------+-----------------------------------------------------+
| 1     | Harry Potter and the Philosopher's Stone                   | J.K. Rowling                        | 9780590353403 | 1997  | Fiction  | Genre: Fantasy, Age Rating: 13+                     |
| 2     | To Kill a Mockingbird                                      | Harper Lee                          | 9780061120084 | 1960  | Fiction  | Genre: Classic, Age Rating: 10+                     |
| 3     | Sapiens: A Brief History of Humankind                      | Yuval Noah Harari                   | 9780062316097 | 2011  | Textbook | Subject: History, Academic Level: High School       |
| 4     | The Elements of Style                                      | William Strunk Jr. and E.B. White   | 9780205309023 | 1918  | Textbook | Subject: Language, Academic Level: High School      |
| 5     | Walk This Way                                              | Vogue                               | 9780743273565 | 2014  | Magazine | Issue No: 325, Season Edition: Spring               |
+-------+------------------------------------------------------------+-------------------------------------+---------------+-------+----------+-----------------------------------------------------+
Jun 27, 2024 11:25:30 AM com.altheacruz.library.Main handleMenuOptions
INFO: Action completed. Showing menu again.

```
