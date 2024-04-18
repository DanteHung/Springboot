package com.vtxlab.bc.bcproductdata.service;

import java.util.List;

import com.vtxlab.bc.bcproductdata.entity.CoinListEntity;

public interface CoinListService {
    
    CoinListEntity save(CoinListEntity coinListEntity);

    List<CoinListEntity> saveAll(List<CoinListEntity> coinListEntities);

    List<CoinListEntity> findAll();
    
}
