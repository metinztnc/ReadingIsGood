package com.readingIsGood.impl;


import com.readingIsGood.repository.StatisticsRepository;
import com.readingIsGood.service.IStatisticsService;
import org.springframework.stereotype.Service;

@Service
public class StatisticsServiceImpl implements IStatisticsService {

    private final StatisticsRepository statisticsRepository;

    public StatisticsServiceImpl(StatisticsRepository statisticsRepository) {
        this.statisticsRepository = statisticsRepository;
    }
}
