package com.sberbank.restexample.service;

import com.sberbank.restexample.dao.CounterDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CounterServiceImpl implements CounterService {

    private CounterDao counterDao;

    @Autowired
    public CounterServiceImpl(CounterDao counterDao) {
        this.counterDao = counterDao;
    }

    @Override
    public Integer addCounterByName(String counterName) {
        return counterDao.addCounterByName(counterName);
    }

    @Override
    public void incrementCounterByName(String counterName) {
        counterDao.incrementCounterByName(counterName);
    }

    @Override
    public Integer getCounterValueByName(String counterName) {
        return counterDao.getCounterValueByName(counterName);
    }

    @Override
    public Integer deleteCounterByName(String counterName) {
        return counterDao.deleteCounterByName(counterName);
    }

    @Override
    public Integer getValuesOfAllCounters() {
        return counterDao.getValuesOfAllCounters();
    }

    @Override
    public List<String> getAllCountersNames() {
        return counterDao.getAllCountersNames();
    }
}
