package com.sberbank.restexample.dao;

import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;


@Repository
public class CounterDaoImpl implements CounterDao {
    private Map<String, Integer> mapOfCounter = new ConcurrentHashMap<>();


    @Override
    public Integer addCounterByName(String counterName) {
        return mapOfCounter.putIfAbsent(counterName, 0);
    }

    @Override
    public void incrementCounterByName(String counterName) {
        mapOfCounter.computeIfPresent(counterName, (key, value) -> ++value);
    }

    @Override
    public Integer getCounterValueByName(String counterName) {
        return mapOfCounter.getOrDefault(counterName, -1);
    }

    @Override
    public Integer deleteCounterByName(String counterName) {
        return mapOfCounter.remove(counterName);
    }

    @Override
    public Integer getValuesOfAllCounters() {
        return mapOfCounter.values()
                .stream()
                .mapToInt(Integer::valueOf)
                .sum();
    }

    @Override
    public List<String> getAllCountersNames() {
        return new ArrayList<>(mapOfCounter.keySet());
    }
}
