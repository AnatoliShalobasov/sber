package com.sberbank.restexample.dao;

import java.util.List;

public interface CounterDao {
    Integer addCounterByName(String counterName);

    void incrementCounterByName(String counterName);

    Integer getCounterValueByName(String counterName);

    Integer deleteCounterByName(String counterName);

    Integer getValuesOfAllCounters();

    List<String> getAllCountersNames();
}
