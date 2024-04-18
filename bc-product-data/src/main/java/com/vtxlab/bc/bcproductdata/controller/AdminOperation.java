package com.vtxlab.bc.bcproductdata.controller;

import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseStatus;

import com.vtxlab.bc.bcproductdata.dto.admin.CoinList;
import com.vtxlab.bc.bcproductdata.dto.admin.StockList;
import com.vtxlab.bc.bcproductdata.entity.CoinListEntity;
import com.vtxlab.bc.bcproductdata.entity.StockListEntity;
import com.vtxlab.bc.bcproductdata.infra.ApiResponse;


public interface AdminOperation {

    @PostMapping(value = "/product/admin/coinLists")
    @ResponseStatus(code = HttpStatus.OK)
    ApiResponse<List<CoinListEntity>> saveCoinLists(@RequestBody List<CoinList> coinLists);

    @PostMapping(value = "/product/admin/stockLists")
    @ResponseStatus(code = HttpStatus.OK)
    ApiResponse<List<StockListEntity>> saveStockLists(@RequestBody List<StockList> stockList);

}
