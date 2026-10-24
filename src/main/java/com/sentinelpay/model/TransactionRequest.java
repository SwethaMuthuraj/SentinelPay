package com.sentinelpay.model;
import jakarta.validation.constraints.*;
public class TransactionRequest {
 @NotBlank @Size(max=80) private String customerName;
 @NotNull @DecimalMin("0.01") private Double amount;
 @NotBlank @Size(max=100) private String merchant;
 @NotBlank @Size(max=100) private String location;
 @NotBlank @Size(max=40) private String paymentMethod;
 public String getCustomerName(){return customerName;} public void setCustomerName(String v){customerName=v;}
 public Double getAmount(){return amount;} public void setAmount(Double v){amount=v;}
 public String getMerchant(){return merchant;} public void setMerchant(String v){merchant=v;}
 public String getLocation(){return location;} public void setLocation(String v){location=v;}
 public String getPaymentMethod(){return paymentMethod;} public void setPaymentMethod(String v){paymentMethod=v;}
}