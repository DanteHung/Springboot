package com.vtxlab.bc.bcproductdata.service;

import java.util.List;

import com.vtxlab.bc.bcproductdata.entity.StockListEntity;

public interface StockListService {

    StockListEntity save(StockListEntity stockListEntity);

    List<StockListEntity> saveAll(List<StockListEntity> stockListEntities);

    List<StockListEntity> findAll();

}
