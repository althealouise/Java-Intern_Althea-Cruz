# Java-Intern_Althea-Cruz

## Getting Started

### Pre-conditions
You need to have an IDE installed on your computer. For these projects, it is ideal to use IntelliJ Community Edition. 

#### Installing IntelliJ IDEA
1. You may download it through this link [IntelliJ IDEA Community Edition](https://www.jetbrains.com/idea/download/?section=windows).
2. Make sure to select the installer suitable for your **operating system** (Windows, macOS, or Linux).
3. Run the installer/executable file and follow the on-screen instructions to complete the installation process.

#### Connecting Your GitHub Account to IntelliJ IDEA
1. Open the **IntelliJ IDEA** application.
2. Go to File > Settings (or IntelliJ IDEA > Preferences on macOS).
3. In the Settings/Preferences dialog, select **Version Control > GitHub**.
4. Click "**Add account**:.
5. You can log in using your GitHub credentials or by using a GitHub token:
   - Log in with GitHub: Click on Log In via GitHub, which will open a browser window. Follow the prompts to authorize IntelliJ IDEA to access your GitHub account. You may be asked to use your mobile phone for an authorization code in the GitHub application.
   - Log in with Token: Generate a personal access token from your GitHub account settings (go to Settings > Developer settings > Personal access tokens on GitHub). Copy the token, return to IntelliJ IDEA, and paste the token into the Token field. Click Add account.

#### Cloning this Repository
1. On the Welcome screen, click on Get from VCS (Version Control System).
2. In the URL field, enter the following repository URL: `https://github.com/althealouise/Java-Intern_Althea-Cruz.git`.
3. Choose a directory on your local machine where you want to clone the repository.
4. Click Clone.

## [mini-project-1](https://github.com/althealouise/Java-Intern_Althea-Cruz/tree/main/mini-project-1)
This program is a basic calculator that performs arithmetic operations on two (2) numbers. The user only has to input their choice of operation and the two numbers, the program is not designed to handle string inputs with symbols.

### Executing program
1. In your **IntelliJ** environment, navigate to this directory `mini-project-1\CruzALC_MP1-Basic-Calculator\src\main\java\org`
2. Open the `Main.java` file
3. On the top part of the window below the navigation bar, click on the **green arrow** next to the main method or **right-click on the file** and select "Run 'Main.main'".
4. Follow the prompts in the console to choose an arithmetic operation and input your numbers.

### Program Flow
1. **Choose an Operation**. The program will display a menu with four options.
2. After selecting an operation, you will be prompted to **enter two integers**.
3. After inputting the second number, the program will perform the chosen operation and **display the result**. However, if you choose division and enter 0 as the second number, the program will not accept it and prompt that division by zero is not allowed.
4. After displaying the result, the program will ask if you want to try another operation. Enter 'y' to continue or 'n' to exit.

### Sample run
```
=======================================
          CHOOSE AN OPERATION          
=======================================
[a] Addition
[b] Subtraction
[c] Multiplication
[d] Division
=======================================
Operation: a
----------------------------------------
Enter first number: 8
----------------------------------------
Enter second number: 4
=======================================
Answer = 12
Do you want to try again? (y/n): n
```

## [mini-project-2](https://github.com/althealouise/Java-Intern_Althea-Cruz/tree/main/mini-project-2)
This program is a Library Management System that allows you to manage books in a library. The system provides functionalities to add, search, display, and delete books from the library's collection of books. The user interacts with the program through a menu interface.

### Features
1. **Add a Book**
- Users can add new books to the library. The system captures details such as reference number, title, author, ISBN, publication year, and whether the book is fiction or non-fiction. For fiction books, the genre is also captured, while for non-fiction books, the subject is recorded.
2. **Search Books**
- Users can search for books in the library by author, title, or category. The results to be displayed are all the books with the title/author containing the search keyword entered.
3. **Show All Books**
- The program can display all books currently stored in the library. 
4. **Delete a Book**
- Users can remove books from the library by entering the reference number of the book to be deleted.

### Executing program
1. In your **IntelliJ** environment, navigate to this directory `mini-project-2\src\main\java\com.altheacruz.library`
2. There are **two ways** to run the program.
 #### Option 1
 1. Open the `Main.java` file.
 2. On the top part of the window below the navigation bar, click on the **green arrow** next to the main method or **right-click on the file** and select "Run 'Main.main'".
 #### Option 2
 1. Open the Terminal. This is the third button from the bottom of the left panel.
 2. Navigate to the directory where the `pom.xml` file is located. By default, the terminal is in the root directory which is `Java-Intern_Althea-Cruz`. Hence, you need to enter `cd mini-project-2`
 3. Build the project by entering this command in the terminal `mvn clean install`
 4. Lastly, you can run the application by running the command `mvn exec:java`

### Program Flow
1. **Choose an Action**. The program will display a menu with the options.
2. After selecting an action, you will be prompted with input fields depending on your selection.
3. Your action will be logged in the console and it will also tell you whether it is successful or not.
4. After the action has been completed, the menu will be prompted again.
5. To exit, choose the "Exit" option from the menu.

### Sample run
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

## [mini-project-3](https://github.com/althealouise/Java-Intern_Althea-Cruz/tree/main/mini-project-3)
This program simulates an e-commerce system where users can browse, search, add products to a cart, and view their cart with a total price calculation.

### Features
1. Show all products
- Displays all available products in the system with their details.
2. Search products
- Allows users to search for products based on name or brand criteria.
3. Add products to cart
- Enables users to add products to their shopping cart by entering the product ID.
4. View cart
- Shows the contents of the user's cart including product IDs, names, and prices. It also calculates and displays the total price of all items in the cart.

### Program Flow
1. Menu
- Upon running the program, a menu with options will be displayed.
- Users can choose from options to show all products, search products, add products to cart, view cart contents, or exit the program.
2. Adding to cart
- When adding products to the cart, users enter the product ID.
- Products are validated, and if found, they are added to the cart.
- Entering '0' completes the transaction and proceeds to view the cart.
3. Viewing cart
- The cart displays all added products with details such as ID, name, and price.
- It calculates the total price of all items in the cart.

### Sample run
```
====================================
     ALC E-COMMERCE SYSTEM MENU     
====================================
[a] Show all products
[b] Search products
[c] Add products to cart
[d] View cart
[e] Exit
====================================
Action: a
Displaying 15 of 15 results:
+-------+-----------------------------------------+-----------------------------+---------------+-------------------------------------------------------------+
| ID    | Product Name                            | Brand                       | Price         | Specifications                                              |
+-------+-----------------------------------------+-----------------------------+---------------+-------------------------------------------------------------+
| 101   | Slim Fit T-shirt                        | Nike                        | 19.99         | Size: M, Material: Cotton                                   |
| 102   | Skinny Jeans                            | Levi's                      | 49.99         | Size: 32, Material: Denim                                   |
...
====================================
     ALC E-COMMERCE SYSTEM MENU     
====================================
[a] Show all products
[b] Search products
[c] Add products to cart
[d] View cart
[e] Exit
====================================
Action: c
Enter Product ID (0 to complete transaction): 101
Slim Fit T-shirt is added to your cart
Enter Product ID (0 to complete transaction): 0
Displaying 1 of 1 results:
Your Cart:
+-------+-----------------------------------------+---------------+
| ID    | Product Name                            | Price         |
+-------+-----------------------------------------+---------------+
| 101   | Slim Fit T-shirt                        | 19.99         |
+-------+-----------------------------------------+---------------+
|TOTAL PRICE                                      | 19.99         |
+-------------------------------------------------+---------------+

```

## Author
Althea Louise Cruz
