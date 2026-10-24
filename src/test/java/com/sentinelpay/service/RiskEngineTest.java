package com.sentinelpay.service;
import com.sentinelpay.model.TransactionRequest; import org.junit.jupiter.api.Test; import static org.junit.jupiter.api.Assertions.*;
class RiskEngineTest {
 @Test void flagsHighRiskTransaction(){TransactionRequest r=new TransactionRequest();r.setCustomerName("Test");r.setAmount(65000.0);r.setMerchant("Unverified Crypto Exchange");r.setLocation("Chennai");r.setPaymentMethod("Crypto");var t=new RiskEngine().evaluate(r);assertEquals("HIGH",t.getRiskLevel());assertEquals("FLAGGED",t.getDecision());}
}