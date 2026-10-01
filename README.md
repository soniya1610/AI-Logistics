# 🚚 AI Logistics

AI Logistics is a full-stack logistics and shipment management system designed to simplify shipment booking, tracking, driver management, and vehicle selection through a role-based web application.

The project is built using **Java, Spring Boot, Spring Data JPA, MySQL, Spring Security, Google OAuth2, Thymeleaf, JavaScript, and Spring AI with Groq**.

The system provides separate workflows for **Customers, Drivers, and Administrators**, while an AI-powered vehicle recommendation feature selects a suitable vehicle category based on shipment dimensions and weight.

---

## 📌 Project Overview

AI Logistics brings the major operations of a logistics platform into a single application:

- 👤 Customer registration and management
- 📦 Shipment booking
- 📍 Shipment tracking
- 🚛 Driver registration and management
- 🔄 Driver availability/status management
- 🛠️ Admin management
- 🔐 Secure authentication
- 🔑 Google OAuth2 login
- 🤖 AI-powered vehicle recommendation
- 🗄️ MySQL database persistence
- 🌐 REST API based communication
- 🎨 Role-specific web dashboards

---

## ✨ Key Features

### 👤 Customer Module

Customers can:

- Register as a customer
- Access their customer dashboard
- Book shipments
- Provide shipment/package details
- Enter package weight and dimensions
- View shipment details
- Track shipments
- View shipment-related information

---

### 🚛 Driver Module

Drivers can:

- Register as a driver
- Access their driver dashboard
- View driver information
- Manage driver availability/status
- Participate in the shipment workflow
- Update their operational status

---

### 🛠️ Admin Module

Administrators can:

- Access the admin dashboard
- View registered drivers
- Filter/view drivers according to status
- View driver details
- Manage driver-related information

---

### 🤖 AI-Powered Vehicle Recommendation

One of the main features of the project is AI-based vehicle recommendation.

The system takes shipment information such as:

- Weight
- Width
- Height
- Length

and sends the relevant information through **Spring AI** to a Groq-powered AI model.

The AI recommends a suitable vehicle category from:

- 🏍️ Bike
- 🚚 Cargo Auto
- 🚛 Mini Truck
- 🚛 Truck

### AI Flow

```text
Shipment Details
      │
      ▼
Weight + Width + Height + Length
      │
      ▼
Spring AI ChatClient
      │
      ▼
Groq API
      │
      ▼
AI Vehicle Recommendation
      │
      ▼
Bike / Cargo Auto / Mini Truck / Truck
```

This feature helps automate an important logistics decision instead of requiring the vehicle category to be selected manually.

---

## 🔐 Authentication & Security

The application uses **Spring Security** for application security and authentication.

It also supports:

- Google OAuth2 login
- Role-based application flows
- Secure logout
- Customer/Driver/Admin-specific access flows

Google OAuth2 allows users to authenticate through their Google account when the OAuth configuration is enabled.

---

## 🏗️ System Architecture

The project consists of two Spring Boot applications:

```text
                         AI LOGISTICS
                              │
               ┌──────────────┴──────────────┐
               │                             │
               ▼                             ▼
      AILogistics-FrontEnd           AILogistics-BackEnd
               │                             │
               │                             │
       Spring Boot + Thymeleaf       Spring Boot REST APIs
       Spring Security               Spring Data JPA
       Google OAuth2                 Service Layer
       Spring AI                    Repository Layer
               │                             │
               └──────────────┬──────────────┘
                              │
                              ▼
                         MySQL Database
                              │
                              │
                         Spring AI
                              │
                              ▼
                           Groq API
```

---

## 📂 Project Structure

```text
AI-Logistics/
│
├── .github/
│
├── AILogistics-BackEnd/
│   │
│   ├── src/
│   │   ├── main/
│   │   │   ├── java/
│   │   │   │   └── com/
│   │   │   │       └── soniya/
│   │   │   │           ├── controller/
│   │   │   │           ├── entity/
│   │   │   │           ├── repo/
│   │   │   │           └── service/
│   │   │   │
│   │   │   └── resources/
│   │   │       └── application.properties
│   │   │
│   │   └── test/
│   │
│   ├── pom.xml
│   └── mvnw / mvnw.cmd
│
├── AILogistics-FrontEnd/
│   │
│   ├── src/
│   │   ├── main/
│   │   │   ├── java/
│   │   │   │   └── com/
│   │   │   │       └── soniya/
│   │   │   │           ├── bean/
│   │   │   │           ├── controller/
│   │   │   │           ├── security/
│   │   │   │           └── service/
│   │   │   │
│   │   │   └── resources/
│   │   │       ├── templates/
│   │   │       │   ├── admin/
│   │   │       │   ├── customer/
│   │   │       │   └── driver/
│   │   │       │
│   │   │       ├── static/
│   │   │       │   └── assets/
│   │   │       │
│   │   │       └── application.properties
│   │   │
│   │   └── test/
│   │
│   ├── pom.xml
│   └── mvnw / mvnw.cmd
│
└── README.md
```

> **Note:** The project package name has been updated from `com.incapp` to `com.soniya`.

---

## 🧰 Technology Stack

### Backend

- Java 17
- Spring Boot
- Spring MVC
- Spring Data JPA
- Hibernate
- REST APIs
- Maven
- Lombok

### Frontend

- Spring Boot
- Thymeleaf
- HTML5
- CSS3
- JavaScript
- Server-side rendering

### AI

- Spring AI
- Groq API
- OpenAI-compatible API integration
- AI-based vehicle recommendation

### Database

- MySQL
- Hibernate / JPA

### Security

- Spring Security
- Google OAuth2

### Development Tools

- Eclipse / Spring Tool Suite
- IntelliJ IDEA
- VS Code
- Maven
- Git
- GitHub
- MySQL

---

## ⚙️ Application Configuration

The project uses two Spring Boot applications.

### Backend Port

```text
5555
```

Backend URL:

```text
http://localhost:5555
```

### Frontend Port

```text
2222
```

Frontend URL:

```text
http://localhost:2222
```

---

# 🚀 Getting Started

## 1. Prerequisites

Install the following before running the project:

- Java 17 or later
- Maven
- MySQL 8+
- Git
- Internet connection
- Groq API key for AI functionality
- Google OAuth2 credentials if Google login is enabled

Verify Java:

```bash
java -version
```

Verify Maven:

```bash
mvn -version
```

---

## 2. Clone the Repository

```bash
git clone https://github.com/soniya1610/AI-Logistics.git
```

Move into the project:

```bash
cd AI-Logistics
```

---

## 3. Configure MySQL

Create a MySQL database:

```sql
CREATE DATABASE ailogistic;
```

The backend uses MySQL for persistent application data.

Open:

```text
AILogistics-BackEnd/src/main/resources/application.properties
```

Configure your database credentials:

```properties
spring.datasource.username=YOUR_DB_USERNAME
spring.datasource.password=YOUR_DB_PASSWORD
spring.datasource.url=jdbc:mysql://localhost:3306/ailogistic?createDatabaseIfNotExist=true&useSSL=false&allowPublicKeyRetrieval=true
```

Hibernate is configured to manage/update the database schema during development.

---

# 🤖 Configure Groq / Spring AI

The AI functionality uses Spring AI with a Groq OpenAI-compatible endpoint.

Open:

```text
AILogistics-FrontEnd/src/main/resources/application.properties
```

Configure:

```properties
spring.ai.openai.base-url=https://api.groq.com/openai/v1
spring.ai.openai.api-key=YOUR_GROQ_API_KEY
```

Configure the model used by the application according to the model configured in your project.

Example:

```properties
spring.ai.openai.chat.options.model=YOUR_MODEL_NAME
```

Create your Groq API key from the Groq developer console.

---

# 🔑 Configure Google OAuth2

If Google login is enabled, configure your OAuth2 credentials in:

```text
AILogistics-FrontEnd/src/main/resources/application.properties
```

Example:

```properties
spring.security.oauth2.client.registration.google.client-id=YOUR_CLIENT_ID
spring.security.oauth2.client.registration.google.client-secret=YOUR_CLIENT_SECRET
spring.security.oauth2.client.registration.google.scope=profile,email
```

For local development, configure the appropriate redirect URI in your Google Cloud OAuth configuration.

Example:

```text
http://localhost:2222/login/oauth2/code/google
```

---

# ▶️ Running the Project

The backend and frontend are separate Spring Boot applications, so run them independently.

## Start Backend

Open Terminal 1:

```bash
cd AILogistics-BackEnd
```

Linux/macOS:

```bash
./mvnw spring-boot:run
```

Windows:

```cmd
mvnw.cmd spring-boot:run
```

Backend will run on:

```text
http://localhost:5555
```

---

## Start Frontend

Open Terminal 2:

```bash
cd AILogistics-FrontEnd
```

Linux/macOS:

```bash
./mvnw spring-boot:run
```

Windows:

```cmd
mvnw.cmd spring-boot:run
```

Frontend will run on:

```text
http://localhost:2222
```

Open the application in your browser:

```text
http://localhost:2222
```

---

# 🔄 Application Workflow

```text
                    ┌──────────────────────┐
                    │     AI Logistics     │
                    │     Web Platform     │
                    └──────────┬───────────┘
                               │
          ┌────────────────────┼────────────────────┐
          │                    │                    │
          ▼                    ▼                    ▼
      👤 Customer          🚛 Driver             🛠️ Admin
          │                    │                    │
          │                    │                    │
          └────────────────────┼────────────────────┘
                               │
                               ▼
                    ┌──────────────────────┐
                    │   Spring Boot APIs   │
                    │    REST + Services   │
                    └──────────┬───────────┘
                               │
                    ┌──────────┴───────────┐
                    │                      │
                    ▼                      ▼
              🗄️ MySQL Database       🤖 Spring AI
                                             │
                                             ▼
                                         Groq API
                                             │
                                             ▼
                                  Vehicle Recommendation
```

---

# 📦 Shipment Booking Flow

```text
Customer
   │
   ▼
Enter Shipment Details
   │
   ├── Weight
   ├── Width
   ├── Height
   └── Length
   │
   ▼
AI Vehicle Recommendation
   │
   ▼
Vehicle Category
   │
   ▼
Shipment Booking
   │
   ▼
Database
   │
   ▼
Shipment Tracking
```

---

# 🤖 AI Vehicle Recommendation Flow

```text
                    Shipment Information
                           │
                           ▼
                ┌────────────────────┐
                │ Weight + Dimensions│
                └─────────┬──────────┘
                          │
                          ▼
                 Spring AI ChatClient
                          │
                          ▼
                     Groq API
                          │
                          ▼
                  AI Model Response
                          │
                          ▼
             ┌────────────────────────┐
             │ Supported Vehicle Type │
             └────────────┬───────────┘
                          │
        ┌─────────────────┼─────────────────┐
        ▼                 ▼                 ▼
      Bike          Cargo Auto         Mini Truck
                          │
                          ▼
                        Truck
```

---

# 🔐 Security Architecture

```text
User
 │
 ▼
Spring Security
 │
 ├───────────────┐
 │               │
 ▼               ▼
Google OAuth2   Application Authentication
 │               │
 └───────┬───────┘
         │
         ▼
Role / User Flow
         │
 ┌───────┼────────┐
 ▼       ▼        ▼
Admin  Customer  Driver
```

---

# 🗄️ Database

The application uses **MySQL** with **Spring Data JPA** and **Hibernate**.

The backend follows a layered structure:

```text
Controller
    │
    ▼
Service
    │
    ▼
Repository
    │
    ▼
JPA / Hibernate
    │
    ▼
MySQL
```

This separation keeps API handling, business logic, data access, and persistence responsibilities organized.

---

# 🧩 Backend Layers

The backend follows a standard Spring Boot architecture:

```text
com.soniya
│
├── controller
│       └── REST API endpoints
│
├── service
│       └── Business logic
│
├── entity
│       └── Database entities
│
└── repo
        └── Data access layer
```

---

# 🎨 Frontend Layers

The frontend application is structured around Spring Boot and Thymeleaf:

```text
com.soniya
│
├── controller
│       └── Web request handling
│
├── service
│       └── Frontend/business integration
│
├── security
│       └── Authentication & authorization
│
└── bean
        └── Application models / data objects
```

The UI is organized into:

```text
templates/
│
├── admin/
├── customer/
└── driver/
```

This keeps each role's user interface separate and maintainable.

---

# 🧪 Testing

The project contains Maven test source sets for the Spring Boot modules.

Run tests from the respective module:

```bash
mvn test
```

or using the Maven wrapper:

### Windows

```cmd
mvnw.cmd test
```

### Linux/macOS

```bash
./mvnw test
```

---

# 🛡️ Security Best Practices

For local development, configuration files may contain placeholder values.

Never commit real credentials such as:

- Database passwords
- Groq API keys
- Google OAuth client secrets
- Gmail passwords/app passwords
- JWT secrets
- Production credentials

For production, use:

- Environment variables
- External configuration
- Secret managers
- Deployment-platform secrets

Example:

```properties
spring.datasource.password=${DB_PASSWORD}
spring.ai.openai.api-key=${GROQ_API_KEY}
```

---

# 📈 Future Enhancements

Possible future improvements include:

- 📍 Real-time shipment tracking
- 🔔 Email/SMS shipment notifications
- 🤖 Automated driver assignment
- 📊 Admin analytics dashboard
- 🗺️ Map and route integration
- 💳 Online payment integration
- ⭐ Driver/customer ratings
- 📦 Shipment status history
- 🧪 More unit and integration tests
- 🐳 Docker support
- ☁️ Cloud deployment
- 🔐 Centralized secret management
- 📈 Monitoring and logging

---

# 💡 What This Project Demonstrates

This project demonstrates practical experience with:

- Java backend development
- Spring Boot application development
- REST API development
- Spring Data JPA
- Hibernate
- MySQL database integration
- Authentication and authorization
- Google OAuth2
- AI API integration
- Spring AI
- Thymeleaf
- HTML/CSS/JavaScript
- Maven
- Layered architecture
- Git and GitHub
- Full-stack application development

---

# 👩‍💻 Author

## Soniya Meena

B.Tech Computer Science & Engineering

GitHub:  
https://github.com/soniya1610

Project Repository:  
https://github.com/soniya1610/AI-Logistics

---

## ⭐ Support

If you found this project useful or interesting, consider giving the repository a ⭐ on GitHub.

---

**Built with Java + Spring Boot + MySQL + Spring AI + Groq**
