
-- Database queries for Book store application by Sandor Madacsi 18_05_2023

CREATE DATABASE bookshop;

USE bookshop;

--  CREATING TABLES
CREATE TABLE books(
    b_id INT PRIMARY KEY,
    b_name VARCHAR(50),
    b_author VARCHAR(50),
    b_description VARCHAR(200),
    b_isbn VARCHAR(15),
    b_price DOUBLE
    
);

INSERT INTO books VALUES
(1, "Harry Potter and the Philosopher's Stone ", "J. K ROWLING", "It's a nice book","0001892895489",4.5),
(2, "Atomic Habbits ", "James Clear",  "Building good habits and leaving bad ones","0002301556047",9.9),
(3, "Clean Code", "Robert C. Martin", "Agile Software Craftmanship","0003995746614", 30.47),
(4, "Deep Learning", "Ian Goodfellow", "Deep learning fundamentals","00041193923369", 69.59),
(5, "Crime and Punishment", "Fyodor Dostoevsky", "It's a nice book","0005802722799", 4.5),
(6, "The two prisoners ", "Lajos Zilahy", "A love story during war","0006705995905", 2.0),
(7, "Meditations", "Marcus Aurelius", "Philosophy","0007217191146", 7.9);



CREATE TABLE users(
    user_id int NOT NULL PRIMARY KEY AUTO_INCREMENT,
    first_name VARCHAR(30),
    last_name VARCHAR(30),
    email VARCHAR(50),
    password VARCHAR(30)
    
);





CREATE TABLE basket(
    basket_id varchar(50),
    book_isbn varchar(15),
    quantity INT,
    user_email varchar(50)

);

CREATE TABLE order(
    order_id int NOT NULL PRIMARY KEY AUTO_INCREMENT,
    basket_id varchar(50)
);
