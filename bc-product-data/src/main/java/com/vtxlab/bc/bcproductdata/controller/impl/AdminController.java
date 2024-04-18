package com.vtxlab.bc.bcproductdata.controller.impl;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.vtxlab.bc.bcproductdata.controller.AdminOperation;
import com.vtxlab.bc.bcproductdata.dto.admin.CoinList;
import com.vtxlab.bc.bcproductdata.dto.admin.StockList;
import com.vtxlab.bc.bcproductdata.entity.CoinListEntity;
import com.vtxlab.bc.bcproductdata.entity.StockListEntity;
import com.vtxlab.bc.bcproductdata.infra.ApiResponse;
import com.vtxlab.bc.bcproductdata.service.CoinListService;
import com.vtxlab.bc.bcproductdata.service.StockListService;

@RestController
@RequestMapping(value = "/data/api/v1")
public class AdminController implements AdminOperation {

    @Autowired
    private CoinListService coinListService;

    @Autowired
    private StockListService stockListService;

    @Autowired
    private ModelMapper modelMapper;

    @Override
    public ApiResponse<List<CoinListEntity>> saveCoinLists(List<CoinList> coinLists) {
        List<CoinListEntity> coinListEntities = coinLists.stream() //
                .map(e -> modelMapper.map(e, CoinListEntity.class))
                .collect(Collectors.toList());
        return ApiResponse.<List<CoinListEntity>>builder() //
                .ok() //
                .data(coinListService.saveAll(coinListEntities)) //
                .build();
    }

    @Override
    public ApiResponse<List<StockListEntity>> saveStockLists(List<StockList> stockLists) {
        List<StockListEntity> stockListEntities = stockLists.stream() //
                .map(e -> modelMapper.map(e, StockListEntity.class))
                .collect(Collectors.toList());
        return ApiResponse.<List<StockListEntity>>builder() //
                .ok() //
                .data(stockListService.saveAll(stockListEntities)) //
                .build();
    }

}
