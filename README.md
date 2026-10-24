# 🛡️ SentinelPay — Fraud Detection and Transaction Risk Engine

**A lightweight Java-based transaction risk assessment system that evaluates financial transactions, assigns risk scores, and flags potentially suspicious activity.**

<p align="center">
  <img src="https://img.shields.io/badge/Java-21-orange?style=for-the-badge&logo=openjdk" alt="Java 21">
  <img src="https://img.shields.io/badge/Spring%20Boot-3.4.4-6DB33F?style=for-the-badge&logo=springboot" alt="Spring Boot">
  <img src="https://img.shields.io/badge/REST%20API-Integrated-blue?style=for-the-badge" alt="REST API">
  <img src="https://img.shields.io/badge/Storage-JSON-lightgrey?style=for-the-badge&logo=json" alt="JSON Storage">
</p>

---

## 📌 Overview

SentinelPay is a web-based transaction risk assessment application built with Java and Spring Boot. It evaluates transaction details using configurable rules, calculates a risk score, and assigns a risk category with an associated decision.

The application provides an interactive dashboard to submit transactions, review risk assessments, and monitor transaction history. It uses local JSON-based persistence, so a separate database server is not required.

> **Project type:** Educational rule-based risk assessment system. It is not a trained machine-learning model or a production banking fraud detection service.

## 🎯 Problem Statement

Financial transactions can involve suspicious merchants, unusually large amounts, or other risk indicators. Manually reviewing every transaction can be time-consuming.

SentinelPay demonstrates how configurable risk rules can help categorize transactions and prioritize those that may need further review.

## ✨ Key Features

- **Transaction Assessment:** Submit transaction details, including amount, merchant, payment method, and location.
- **Rule-Based Risk Scoring:** Calculate a score using configured transaction risk indicators.
- **Risk Classification:** Categorize transactions as LOW, MEDIUM, or HIGH risk.
- **Automated Decisions:** Map risk levels to APPROVED, REVIEW, or FLAGGED decisions.
- **Explainable Results:** Display reasons that contribute to the transaction's risk score.
- **Interactive Dashboard:** View transaction summaries, risk assessments, and transaction history.
- **REST API Integration:** Connect the frontend to backend transaction services.
- **Persistent Local Storage:** Store transaction records in a JSON file without requiring MySQL.

## ⚙️ How It Works

```text
User Enters Transaction Details
              |
              v
     Spring Boot REST API
              |
              v
      Rule-Based Risk Engine
              |
              v
       Calculate Risk Score
              |
              v
       Classify Risk Level
              |
      +-------+--------+
      |       |        |
      v       v        v
     LOW    MEDIUM    HIGH
      |       |        |
      v       v        v
  APPROVED  REVIEW   FLAGGED
              |
              v
   Save Transaction to JSON
              |
              v
     Update Dashboard
```

## 🧮 Risk Scoring Rules

The current implementation uses configurable rules to calculate a score.

| Risk indicator | Points added |
|---|---:|
| Transaction amount above ₹50,000 | +30 |
| Transaction amount above ₹20,000 | +15 |
| Merchant matches configured suspicious terms | +25 |
| Payment method is Crypto | +20 |
| Location is missing or too short | +10 |

The transaction score is capped at 100.

### Risk Categories

| Risk score | Risk level | Decision |
|---|---|---|
| 0–29 | LOW | APPROVED |
| 30–49 | MEDIUM | REVIEW |
| 50–100 | HIGH | FLAGGED |

*These rules are illustrative and do not establish whether a real financial transaction is fraudulent.*

## 🧰 Technology Stack

| Technology | Purpose |
|---|---|
| Java 21 | Backend business logic |
| Spring Boot | Application framework and REST APIs |
| Maven | Dependency management and build |
| HTML5 | Frontend structure |
| CSS3 | User interface styling |
| JavaScript | Frontend interactions and API requests |
| Jackson / JSON | Data serialization and local persistence |
| JUnit | Automated testing |

## 🏗️ Project Structure

```text
SentinelPay/
├── src/
│   ├── main/
│   │   ├── java/
│   │   │   └── ...          # Spring Boot application
│   │   └── resources/
│   │       ├── static/      # Frontend assets, if stored here
│   │       └── application.properties
│   └── test/                # Automated tests
├── data/
│   └── transactions.json    # Local transaction records
├── pom.xml                  # Maven configuration
├── .gitignore
└── README.md
```

*The structure above is illustrative. Adjust the folders to match the actual files in your repository.*

## 🚀 Getting Started

### Prerequisites

- Java Development Kit (JDK) 21
- Maven, or the Maven wrapper if included
- Git (optional, for cloning the repository)

### 1. Clone the repository

```bash
git clone https://github.com/YOUR-USERNAME/SentinelPay.git
cd SentinelPay
```

Replace `YOUR-USERNAME` with your GitHub username.

### 2. Verify Java

```bash
java -version
```

Confirm that Java 21 is installed.

### 3. Run the application

```bash
mvn spring-boot:run
```

### 4. Open the dashboard

Navigate to:

**http://localhost:8080**

Submit a test transaction to view its risk score, classification, decision, and explanation.

## 🔌 REST API Endpoints

| Method | Endpoint | Purpose |
|---|---|---|
| GET | `/api/transactions` | Retrieve transaction history |
| POST | `/api/transactions` | Submit and assess a transaction |
| GET | `/api/dashboard` | Retrieve dashboard summaries |
| DELETE | `/api/transactions` | Clear transaction records |

### Example transaction request

```json
{
  "amount": 30000,
  "merchant": "Suspicious Exchange",
  "paymentMethod": "Crypto",
  "location": "Mumbai, India"
}
```

Use the exact field names expected by the application's transaction model. The example illustrates the intended request and may need adjustment to match your implementation.

## 🧪 Testing

Try transactions with different amounts, merchant names, payment methods, and locations.

Verify that:
- Risk scores reflect the configured rules.
- Risk categories match the score thresholds.
- Decisions and explanations are displayed correctly.
- The dashboard and transaction history update.
- Stored records remain available after restarting the application.

## 🔮 Future Enhancements

- MySQL integration for structured transaction storage
- User authentication and role-based access
- Machine-learning-based fraud prediction with an evaluated dataset
- Advanced transaction pattern and anomaly analysis
- Transaction filtering, search, and reporting
- Deployment to a cloud platform
