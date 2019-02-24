package com.baie.other.cache;

import lombok.extern.slf4j.Slf4j;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;

@Service
@Slf4j
public class CacheService {

    @Cacheable("students")
    public Student getStudent(String id) {
        try
        {
            log.info("Going to sleep for 5 Secs.. to simulate backend call.");
            Thread.sleep(1000*5);
        }
        catch (InterruptedException e)
        {
            e.printStackTrace();
        }

        return new Student(id,"vincent" ,"lv", "male");

    }
}
