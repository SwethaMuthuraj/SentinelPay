package com.sentinelpay.service;
import com.fasterxml.jackson.core.type.TypeReference; import com.fasterxml.jackson.databind.*; import com.sentinelpay.model.Transaction; import jakarta.annotation.PostConstruct; import org.springframework.stereotype.Service; import java.io.IOException; import java.nio.file.*; import java.util.*;
@Service
public class TransactionStore {
 private final ObjectMapper mapper=new ObjectMapper().findAndRegisterModules().enable(SerializationFeature.INDENT_OUTPUT);
 private final Path file=Path.of("data","transactions.json"); private List<Transaction> transactions=new ArrayList<>();
 @PostConstruct public synchronized void load(){try{Files.createDirectories(file.getParent());if(Files.exists(file))transactions=mapper.readValue(file.toFile(),new TypeReference<List<Transaction>>(){});else save();}catch(IOException e){throw new IllegalStateException("Cannot load "+file.toAbsolutePath(),e);}}
 public synchronized List<Transaction> all(){return transactions.stream().sorted(Comparator.comparing(Transaction::getCreatedAt).reversed()).toList();}
 public synchronized Transaction add(Transaction t){transactions.add(t);save();return t;}
 public synchronized void clear(){transactions.clear();save();}
 private void save(){try{Files.createDirectories(file.getParent());mapper.writeValue(file.toFile(),transactions);}catch(IOException e){throw new IllegalStateException("Cannot save "+file.toAbsolutePath(),e);}}
}