# mini-project-1
This program is a basic calculator that performs arithmetic operations on two (2) numbers. The user only has to input their choice of operation and the two numbers, the program is not designed to handle string inputs with symbols.

## Executing program
1. In your **IntelliJ** environment, navigate to this directory `mini-project-1\CruzALC_MP1-Basic-Calculator\src\main\java\org`
2. Open the `Main.java` file
3. On the top part of the window below the navigation bar, click on the **green arrow** next to the main method or **right-click on the file** and select "Run 'Main.main'".
4. Follow the prompts in the console to choose an arithmetic operation and input your numbers.

## Program Flow
1. **Choose an Operation**. The program will display a menu with four options.
2. After selecting an operation, you will be prompted to **enter two integers**.
3. After inputting the second number, the program will perform the chosen operation and **display the result**. However, if you choose division and enter 0 as the second number, the program will not accept it and prompt that division by zero is not allowed.
4. After displaying the result, the program will ask if you want to try another operation. Enter 'y' to continue or 'n' to exit.

## Sample run
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
