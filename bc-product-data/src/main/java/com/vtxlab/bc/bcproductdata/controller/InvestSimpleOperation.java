package com.vtxlab.bc.bcproductdata.controller;

import java.util.List;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseStatus;
import com.vtxlab.bc.bcproductdata.dto.investsimple.CandleChart;
import com.vtxlab.bc.bcproductdata.dto.investsimple.QuotePrice;
import com.vtxlab.bc.bcproductdata.infra.ApiResponse;

public interface InvestSimpleOperation {

  @GetMapping(value = "/product/coins")
  @ResponseStatus(code = HttpStatus.OK)
  ApiResponse<List<QuotePrice>> getCoins();

  @GetMapping(value = "/product/stocks")
  @ResponseStatus(code = HttpStatus.OK)
  ApiResponse<List<QuotePrice>> getStocks();

  @GetMapping(value = "/product/stock/daily")
  @ResponseStatus(code = HttpStatus.OK)
  ApiResponse<CandleChart> getCandleChart(
      @RequestParam(value = "code") String stockId);

}
