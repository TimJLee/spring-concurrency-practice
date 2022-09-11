package com.example.stock.service;

import com.example.stock.domain.Stock;
import com.example.stock.repository.StockRepository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class StockService {
    private StockRepository stockRepository;

    public StockService(StockRepository stockRepository) {
        this.stockRepository = stockRepository;
    }

//    @Transactional
    public synchronized void decrease(Long id, Long quantity) {
        // get stock
        // 재고 감소
        // 저장

        Stock stock = stockRepository.findById(id).orElseThrow();
        stock.decrease(quantity);
        // saveAndFlush: 영속성 컨텍스트가 아닌 db 에 바로 값을 저장.
        stockRepository.saveAndFlush(stock);
    }
}
