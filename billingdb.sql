Create Database BillingDB;
use BillingDB;


CREATE TABLE Customer_tb (
    cust_id INT PRIMARY KEY AUTO_INCREMENT,
    U_Name VARCHAR(100) NOT NULL,
    U_Email VARCHAR(100) NOT NULL UNIQUE,
    Password VARCHAR(255) NOT NULL
);


CREATE TABLE Product_tb (
    p_id INT PRIMARY KEY AUTO_INCREMENT,
    P_name VARCHAR(100) NOT NULL,
    PurchaseDate DATE,
    Price DECIMAL(10, 2) NOT NULL,
    U_id INT,
    FOREIGN KEY (U_id) REFERENCES Customer_tb(cust_id) ON DELETE CASCADE
);


CREATE TABLE Cart_tb (
    cust_id INT,
    p_id INT,
    total_bill DECIMAL(10, 2) NOT NULL,
    PRIMARY KEY (cust_id, p_id),
    FOREIGN KEY (cust_id) REFERENCES Customer_tb(cust_id) ON DELETE CASCADE,
    FOREIGN KEY (p_id) REFERENCES Product_tb(p_id) ON DELETE CASCADE
);