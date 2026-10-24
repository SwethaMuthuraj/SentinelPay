package com.sentinelpay.model;
import java.time.Instant; import java.util.List;
public class Transaction {
 private String id,customerName,merchant,location,paymentMethod,riskLevel,decision;
 private double amount; private Instant createdAt; private int riskScore; private List<String> reasons;
 public String getId(){return id;} public void setId(String v){id=v;}
 public String getCustomerName(){return customerName;} public void setCustomerName(String v){customerName=v;}
 public double getAmount(){return amount;} public void setAmount(double v){amount=v;}
 public String getMerchant(){return merchant;} public void setMerchant(String v){merchant=v;}
 public String getLocation(){return location;} public void setLocation(String v){location=v;}
 public String getPaymentMethod(){return paymentMethod;} public void setPaymentMethod(String v){paymentMethod=v;}
 public Instant getCreatedAt(){return createdAt;} public void setCreatedAt(Instant v){createdAt=v;}
 public int getRiskScore(){return riskScore;} public void setRiskScore(int v){riskScore=v;}
 public String getRiskLevel(){return riskLevel;} public void setRiskLevel(String v){riskLevel=v;}
 public String getDecision(){return decision;} public void setDecision(String v){decision=v;}
 public List<String> getReasons(){return reasons;} public void setReasons(List<String> v){reasons=v;}
}