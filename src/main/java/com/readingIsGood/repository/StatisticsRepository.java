package com.readingIsGood.repository;


import com.readingIsGood.entity.Stock;
import org.springframework.stereotype.Repository;

@Repository
public interface StatisticsRepository extends BaseJpaRepository<Stock,Long> {
}
