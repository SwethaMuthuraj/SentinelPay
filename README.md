# SentinelPay — Fraud Detection & Transaction Risk Engine
Java 21 + Spring Boot demo. No MySQL or database server is required; transactions persist to `data/transactions.json`.

## Run
1. Extract this ZIP and open the project folder in VS Code.
2. Open a terminal in the folder.
3. Run `java -version` (Java 21 recommended).
4. Run `mvn spring-boot:run`.
5. Open http://localhost:8080.

## Rules
- Amount > ₹50,000: +30 points.
- Amount > ₹20,000: +15 points.
- Merchant contains `unknown`, `unverified`, `crypto exchange`, or `suspicious`: +25 points.
- Payment method Crypto: +20 points.
- Location missing/too short: +10 points.
- Scores are capped at 100. 0–29 LOW/APPROVED; 30–49 MEDIUM/REVIEW; 50–100 HIGH/FLAGGED.
This is an explainable academic demo, not production fraud detection.

## API
- `GET /api/transactions`
- `POST /api/transactions` with JSON: `{"customerName":"Asha Kumar","amount":18000,"merchant":"Everyday Store","location":"Chennai, India","paymentMethod":"Card"}`
- `GET /api/dashboard`
- `DELETE /api/transactions` clears local demo data.
