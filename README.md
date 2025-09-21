# Employee Management System (Java Swing MVC)

A desktop application built with **Java Swing** following the **MVC architecture**.  
The system supports full **CRUD operations for employees**, **salary calculation**, and **data import/export from Excel files**.

---

## ✨ Features

- **Employee Management**
  - Add, update, delete, search employees
  - View employee list in JTable with pagination/filtering

- **Salary Calculation**
  - Calculate monthly salary based on base salary, working days, and allowances/deductions
  - Export payroll report to Excel

- **Excel Integration**
  - Import employees from Excel (.xlsx)
  - Export employees and salary data to Excel for backup or reporting

- **Architecture (MVC)**
  - **Model**: Employee, Salary, Department entities
  - **View**: Swing GUI (JFrame, JPanel, JTable, etc.)
  - **Controller**: Handle user interactions and business logic

---

## 📂 Project Structure

```
employee-management-swing/
├── src/
│   ├── model/          # POJOs (Employee, Salary…)
│   ├── dao/            # Data access objects (CRUD with JDBC)
│   ├── service/        # Business logic (salary calculation, validation)
│   ├── controller/     # Event handlers, communication between view & service
│   ├── view/           # Swing UI (forms, tables, dialogs)
│   └── util/           # Helpers (ExcelUtils, DB connection, constants)
├── resources/
│   ├── db.properties   # Database config
│   └── employees.xlsx  # Sample Excel file
└── README.md
```

---

## 🗄 Database

Uses **MySQL** (or H2/PostgreSQL, depending on config).  
Example table:

```sql
CREATE TABLE employees (
  id INT AUTO_INCREMENT PRIMARY KEY,
  name VARCHAR(100) NOT NULL,
  gender VARCHAR(10),
  dob DATE,
  department VARCHAR(50),
  position VARCHAR(50),
  base_salary DECIMAL(10,2),
  working_days INT
);
```

---

## ⚙️ Requirements

- JDK 17+  
- Maven or Gradle  
- MySQL (if using real DB)  
- Apache POI (for Excel import/export)

Dependencies (Maven):

```xml
<dependencies>
  <!-- MySQL Connector -->
  <dependency>
    <groupId>mysql</groupId>
    <artifactId>mysql-connector-java</artifactId>
    <version>8.0.33</version>
  </dependency>

  <!-- Apache POI -->
  <dependency>
    <groupId>org.apache.poi</groupId>
    <artifactId>poi-ooxml</artifactId>
    <version>5.2.5</version>
  </dependency>
</dependencies>
```

---

## 🚀 Run the project

1. Clone repo  
   ```bash
   git clone https://github.com/quuynXp/Employee-Management.git
   cd employee-management-swing
   ```

2. Configure `db.properties`  
   ```properties
   db.url=jdbc:mysql://localhost:3306/ems
   db.username=root
   db.password=yourpassword
   ```

3. Import DB schema (`schema.sql`) into MySQL.

4. Build & run  
   ```bash
   mvn clean package
   java -jar target/employee-management-swing.jar
   ```

---

## 📊 Screenshots (optional)

*(add screenshots here)*

---

## 📌 Roadmap

- [ ] Add user authentication (login/logout)  
- [ ] Add department management  
- [ ] Export salary report as PDF  
- [ ] Improve UI/UX with FlatLaf  

---

## 📝 License

MIT © 2025 Your Name  
