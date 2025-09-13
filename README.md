# BusTravelio

**Short Description**: BusTravelio is a Java-based bus ticketing application with a graphical user interface (GUI) that simplifies the process of searching bus routes, booking tickets, and making payments. The system supports both users and administrators, integrates a MySQL database, and introduces a digital payment method called *Travelio Coin*.

---

## Table of Contents

* [Overview](#overview)
* [Main Features](#main-features)
* [Technologies](#technologies)
* [Architecture](#architecture)
* [Database Model](#database-model)
* [Scenarios](#scenarios)
* [Installation & Execution](#installation--execution)
* [Poster](#poster)
* [Future Work](#future-work)
* [Team & Project Management](#team--project-management)
* [License](#license)

---

## Overview

This project was developed as a university project to digitalize bus ticket booking in Germany. Instead of manually buying tickets at kiosks, users can:

* Search bus connections between cities
* Book and pay tickets conveniently
* Use either cash payment or *Travelio Coin*

Motivation: A digital bus ticketing system improves convenience, reduces errors, saves time, and enhances user experience.

---

## Main Features

* **Login System**: Role-based (Admin/User)
* **User Functions**:

  * Search bus connections without login
  * Register and log in
  * Book trips (choose departure, destination, date, seats, class)
  * Pay with cash or *Travelio Coin*
* **Admin Functions**:

  * Manage trips (add, edit, delete)
  * Manage users (add, edit, remove, set privileges)
  * Generate and manage coupons
  * Distribute *Travelio Coins*

---

## Technologies

* Programming Language: Java
* GUI: Java Swing (JFrame)
* Database: MySQL
* Security: Passwords encrypted with SHA hash algorithm
* Tools: GitHub (Version control), LaTeX (Documentation), Figma (Poster/Design)

---

## Architecture

The system follows a role-based two-tier structure:

```
User: Search trips → Book → Login/Register → Payment (Cash/Travelio Coin)
Admin: Login → Manage Users | Manage Trips | Manage Payments & Coupons
```

Key Classes:

* **Login / Register** – Handles user authentication and registration
* **Encryption** – Password hashing with SHA
* **User Management** – Admin control over user accounts
* **Travel Management** – Trip CRUD operations
* **Booking** – Reservation of trips
* **Payment Method** – Cash or Travelio Coin
* **Travelio Coin** – Manage balance, transactions, and coupon codes

---

## Database Model

The MySQL relational schema consists of the following main tables:

* **Users** – Stores user data (username, email, password (encrypted), isAdmin flag)
* **Travels** – Stores all trips (departure, destination, date, price, seats)
* **Payment Users** – Manages user balances and payments
* **Payment Userstory** – Logs transactions made with Travelio Coins
* **Payment Coupons** – Stores admin-generated codes for payments

Relationships:

* User ↔ Travels (n\:m) via Bookings
* User ↔ Payments (1\:n)
* Admin ↔ Coupons (1\:n)

---

## Scenarios

**Admin** can:

* Log in
* Manage trips (add, update, delete)
* Manage users (edit, remove, set admin role)
* Generate Travelio Coin coupons and gift codes
* Monitor user payments and transactions

**User** can:

* Search bus connections without login
* Register and log in
* Book tickets (choose date, time, seats, class)
* Pay with cash or *Travelio Coin*
* Manage their Travelio Coin account (balance, transactions, send coins)

---

## Installation & Execution

### Requirements

* Java Development Kit (JDK)
* IDE (IntelliJ, Eclipse, or NetBeans)
* MySQL Database

### Setup

1. Clone the repository:

   ```bash
   git clone https://github.com/YousefSGhanem/BusTravelio.git
   cd BusTravelio
   ```
2. Create a MySQL database and import the required tables (see [SQL\_Tables.txt](BusTravelio/ducs/SQL_Tables.txt)).
3. Open the project in your IDE and build it.
4. Set your JDBC connection details (username, password, DB name) in the code.
5. Start the program → Login as Admin or register as User.

---

## Team & Project Management

* Process model: Agile / Scrum
* Development phases: Planning → Implementation → Testing → Review → Release
---

## License

This project is a university learning project and is intended for demonstration purpose
