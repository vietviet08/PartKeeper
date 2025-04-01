# Computer Components Management

A Java Swing application for managing computer components, inventory, suppliers, customers, and inbound/outbound invoices.

## Overview

The project follows a typical Java desktop application structure:

- `src/view`: Swing screens for login, dashboard, product management, stock-in, stock-out, and statistics.
- `src/model`: data entities such as accounts, products, CPU, RAM, SSD, VGA, purchase receipts, and sales receipts.
- `src/dao`: data access layer for MySQL.
- `src/db`: database connection utilities.
- `src/decor`, `src/color`, `src/font`, `src/icon`: UI components, colors, fonts, and image assets.
- `database/dbdeploy.sql`: SQL script for creating the `quanlilkmt` schema and sample data.

The application entry point is `src/MainApplication.java`, which currently opens `view.LoginForm`.

## Tech Stack

- Java desktop with Swing
- MySQL/MariaDB
- Eclipse project files (`.project`, `.classpath`)
- Third-party libraries stored directly in `src/lib`
- `mysql-connector-java`
- `flatlaf`
- Apache POI
- iText PDF
- JCalendar
- JFreeChart

## Main Features

- Login and account management
- Component catalog management for CPU, RAM, SSD, VGA, case, mainboard, and PSU
- Customer and supplier management
- Create inbound and outbound invoices and view their details
- Statistics and inventory tracking

## Running the Project

### 1. Prepare the Database

You can import `database/dbdeploy.sql` into MySQL/MariaDB to create the `quanlilkmt` database with sample data.

The repository also includes `docker-compose.yml`, but there is currently a configuration mismatch:

- `src/db/JDBCUntil.java` connects to `localhost:3307`
- `docker-compose.yml` currently publishes `3306:3306`

If you run the database with Docker, choose one of these options:

1. Change `src/db/JDBCUntil.java` to use port `3306`
2. Change the port mapping in `docker-compose.yml` to `3307:3306`

### 2. Open the Project

Open the project in Eclipse as an existing Java project. The repository already includes `.project` and `.classpath`.

### 3. Run the Application

Run `src/MainApplication.java`.

## Notes

- The `bin` directory is the compiled output and should not be tracked in version control.
- Some libraries in `src/lib` exist in multiple versions; it is worth reviewing them during maintenance to reduce duplication.
