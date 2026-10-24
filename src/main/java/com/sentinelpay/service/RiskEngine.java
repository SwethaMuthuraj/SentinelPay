package com.sentinelpay.service;
import com.sentinelpay.model.*; import org.springframework.stereotype.Service; import java.time.Instant; import java.util.*;
@Service
public class RiskEngine {
 public Transaction evaluate(TransactionRequest r) {
  int score=0; List<String> reasons=new ArrayList<>();
  if(r.getAmount()>50000){score+=30;reasons.add("High transaction amount (over ₹50,000)");}
  else if(r.getAmount()>20000){score+=15;reasons.add("Elevated transaction amount (over ₹20,000)");}
  String merchant=r.getMerchant().toLowerCase(Locale.ROOT);
  if(merchant.contains("unknown")||merchant.contains("unverified")||merchant.contains("crypto exchange")||merchant.contains("suspicious")){score+=25;reasons.add("Merchant matches a demo high-risk keyword");}
  if("crypto".equalsIgnoreCase(r.getPaymentMethod())){score+=20;reasons.add("Crypto payment method requires additional review");}
  if(r.getLocation()==null||r.getLocation().trim().length()<3){score+=10;reasons.add("Location information is missing or too short");}
  score=Math.min(score,100); String level=score>=50?"HIGH":score>=30?"MEDIUM":"LOW"; String decision=score>=50?"FLAGGED":score>=30?"REVIEW":"APPROVED";
  if(reasons.isEmpty())reasons.add("No configured risk rules were triggered");
  Transaction t=new Transaction();t.setId(UUID.randomUUID().toString().substring(0,8).toUpperCase());t.setCustomerName(r.getCustomerName().trim());t.setAmount(r.getAmount());t.setMerchant(r.getMerchant().trim());t.setLocation(r.getLocation().trim());t.setPaymentMethod(r.getPaymentMethod().trim());t.setCreatedAt(Instant.now());t.setRiskScore(score);t.setRiskLevel(level);t.setDecision(decision);t.setReasons(reasons);return t;
 }
}