package com.baie.other.cache;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/cache")
public class CacheController {
    @Autowired
    private CacheService cacheService;

    @GetMapping("/student/{id}")
    public Student getCacheInfo(@PathVariable String id) {
        return cacheService.getStudent(id);
    }
}
