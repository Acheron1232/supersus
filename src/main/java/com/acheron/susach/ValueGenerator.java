package com.acheron.susach;

import lombok.RequiredArgsConstructor;
import lombok.SneakyThrows;
import org.springframework.stereotype.Component;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;
import java.util.Random;

import static java.lang.Thread.sleep;

@Component
@RequiredArgsConstructor
public class ValueGenerator {
    private final ValueRepo valueRepo;

    public  void generate(User user) {
        Thread thread = new Thread(new Runnable() {
            @SneakyThrows
            @Override
            public void run() {
                while (true) {
                    try{
                        Thread.sleep(30000);
                        List<Value> all = valueRepo.findAll();
                        Integer max = all.stream().map(Value::getId).max(Integer::compareTo).orElse(0);
                        Value last = all.getLast();
                        Integer random1 = random();
                        Integer random2 = random();
                        Value save = valueRepo.save(new Value(max+1, random1< last.getDay()?100:random1, random()< last.getNight()?80:random2, user, LocalDateTime.now()));
                    }catch (Exception e){
                        e.printStackTrace();
                        break;
                    }
                }
            }
        });
        thread.start();
    }
    public Integer random() {
        Random random = new Random();
        return random.nextInt(251) + 50;
    }
}
