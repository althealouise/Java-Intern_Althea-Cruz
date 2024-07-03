# mini-project-3
This program simulates an e-commerce system where users can browse, search, add products to a cart, and view their cart with a total price calculation.

## Features
1. **Show all products**
- Displays all available products in the system with their details.
2. **Search products**
- Allows users to search for products based on name or brand criteria.
3. **Add products to cart**
- Enables users to add products to their shopping cart by entering the product ID.
4. **View cart**
- Shows the contents of the user's cart including product IDs, names, and prices. It also calculates and displays the total price of all items in the cart.

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
1. **Menu**
- Upon running the program, a menu with options will be displayed.
- Users can choose from options to show all products, search products, add products to cart, view cart contents, or exit the program.
2. **Adding to cart**
- When adding products to the cart, users enter the product ID.
- Products are validated, and if found, they are added to the cart.
- Entering '0' completes the transaction and proceeds to view the cart.
3. **Viewing cart**
- The cart displays all added products with details such as ID, name, and price.
- It calculates the total price of all items in the cart.

## Sample run
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
