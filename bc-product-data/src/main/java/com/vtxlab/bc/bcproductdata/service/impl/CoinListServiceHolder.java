package com.vtxlab.bc.bcproductdata.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.vtxlab.bc.bcproductdata.entity.CoinListEntity;
import com.vtxlab.bc.bcproductdata.repository.CoinListRepository;
import com.vtxlab.bc.bcproductdata.service.CoinListService;

@Service
public class CoinListServiceHolder implements CoinListService {

    @Autowired
    private CoinListRepository coinListRepository;

    @Override
    public CoinListEntity save(CoinListEntity coinListEntity) {
        return coinListRepository.save(coinListEntity);
    }

    @Override
    public List<CoinListEntity> saveAll(List<CoinListEntity> coinListEntities) {
        return coinListRepository.saveAll(coinListEntities);
    }

    @Override
    public List<CoinListEntity> findAll() {
        return coinListRepository.findAll();
    }

}
