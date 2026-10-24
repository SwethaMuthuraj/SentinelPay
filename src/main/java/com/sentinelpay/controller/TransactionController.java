package com.sentinelpay.controller;
import com.sentinelpay.model.*; import com.sentinelpay.service.*; import jakarta.validation.Valid; import org.springframework.http.HttpStatus; import org.springframework.web.bind.annotation.*; import java.util.*;
@RestController @RequestMapping("/api")
public class TransactionController {
 private final RiskEngine engine; private final TransactionStore store;
 public TransactionController(RiskEngine e,TransactionStore s){engine=e;store=s;}
 @GetMapping("/transactions") public List<Transaction> transactions(){return store.all();}
 @PostMapping("/transactions") @ResponseStatus(HttpStatus.CREATED) public Transaction create(@Valid @RequestBody TransactionRequest r){if(r.getAmount()==null||!Double.isFinite(r.getAmount()))throw new org.springframework.web.server.ResponseStatusException(HttpStatus.BAD_REQUEST,"Invalid amount");return store.add(engine.evaluate(r));}
 @DeleteMapping("/transactions") @ResponseStatus(HttpStatus.NO_CONTENT) public void clear(){store.clear();}
 @GetMapping("/dashboard") public Map<String,Object> dashboard(){List<Transaction> a=store.all();Map<String,Object> m=new LinkedHashMap<>();m.put("totalTransactions",a.size());m.put("flaggedTransactions",a.stream().filter(t->"FLAGGED".equals(t.getDecision())).count());m.put("reviewTransactions",a.stream().filter(t->"REVIEW".equals(t.getDecision())).count());m.put("approvedTransactions",a.stream().filter(t->"APPROVED".equals(t.getDecision())).count());m.put("totalAmount",Math.round(a.stream().mapToDouble(Transaction::getAmount).sum()*100.0)/100.0);return m;}
}