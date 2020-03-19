package com.sberbank.restexample.controller;


import com.sberbank.restexample.service.CounterService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController("/api")
public class CounterController {

    public final CounterService counterService;

    @Autowired
    public CounterController(CounterService counterService) {
        this.counterService = counterService;
    }

    @PostMapping("/counters/{name}")
    public String addCounter(@PathVariable String name) {
        counterService.addCounterByName(name);
        return "Добавлен счетчик с именем " + name;
    }

    @PutMapping("/counters/{name}")
    public String incrementCounter(@PathVariable String name) {
        counterService.incrementCounterByName(name);
        return "Значение счетчика с именем " + name + " увеличено";
    }

    @GetMapping("/counters/{name}")
    public Integer getCounterValue(@PathVariable String name) {
        return counterService.getCounterValueByName(name);
    }

    @DeleteMapping("/counters/{name}")
    public String deleteCounterByName(@PathVariable String name) {
        counterService.deleteCounterByName(name);
        return "Счетчик с именем " + name + " удален";
    }

    @GetMapping("/counters/names")
    public List<String> getCountersNames() {
        return counterService.getAllCountersNames();
    }

    @GetMapping("/counters/values")
    public Integer getCountersValues() {
        return counterService.getValuesOfAllCounters();
    }
}