package com.vtxlab.bc.bcproductdata.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.vtxlab.bc.bcproductdata.entity.StockListEntity;
import com.vtxlab.bc.bcproductdata.repository.StockListRepository;
import com.vtxlab.bc.bcproductdata.service.StockListService;

@Service
public class StockListServiceHolder implements StockListService {

    @Autowired
    private StockListRepository stockListRepository;

    @Override
    public StockListEntity save(StockListEntity stockListEntity) {
        return stockListRepository.save(stockListEntity);
    }

    @Override
    public List<StockListEntity> saveAll(List<StockListEntity> stockListEntities) {
        return stockListRepository.saveAll(stockListEntities);
    }

    @Override
    public List<StockListEntity> findAll() {
        return stockListRepository.findAll();
    }

}
