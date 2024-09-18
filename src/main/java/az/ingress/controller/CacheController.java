package az.ingress.controller;

import az.ingress.service.concrete.CacheService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

@RestController
@RequiredArgsConstructor
@RequestMapping("v1/cache")
public class CacheController {
    private final CacheService cacheService;

    @PostMapping
    public void save(@RequestParam Long id, @RequestParam String name){
        cacheService.save(id, name);
    }

    @GetMapping
    public void get(@RequestParam String cacheKey){
        cacheService.get(cacheKey);
    }
}
