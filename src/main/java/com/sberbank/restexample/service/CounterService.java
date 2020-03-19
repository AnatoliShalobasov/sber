package com.sberbank.restexample.service;

import java.util.List;

public interface CounterService {
    Integer addCounterByName(String counterName);

    void incrementCounterByName(String counterName);

    Integer getCounterValueByName(String counterName);

    Integer deleteCounterByName(String counterName);

    Integer getValuesOfAllCounters();

    List<String> getAllCountersNames();
}
