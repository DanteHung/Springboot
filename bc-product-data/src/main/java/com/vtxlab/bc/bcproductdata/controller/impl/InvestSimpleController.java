package com.vtxlab.bc.bcproductdata.controller.impl;

import java.util.List;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.vtxlab.bc.bcproductdata.controller.InvestSimpleOperation;
import com.vtxlab.bc.bcproductdata.dto.investsimple.CandleChart;
import com.vtxlab.bc.bcproductdata.dto.investsimple.QuotePrice;
import com.vtxlab.bc.bcproductdata.infra.ApiResponse;

@RestController
@RequestMapping(value = "/data/api/v1")
public class InvestSimpleController implements InvestSimpleOperation {

    @Override
    public ApiResponse<List<QuotePrice>> getCoins() {
        // POC
        QuotePrice q1 = new QuotePrice("bitcoin", "Bitcoin",
                "https://assets.coingecko.com/coins/images/1/large/bitcoin.png?1696501400",
                56968.0, 1.95906, 1118652151810.0);
        QuotePrice q2 = new QuotePrice("ethereum", "Ethereum",
                "https://assets.coingecko.com/coins/images/279/large/ethereum.png?1696501628",
                3250.67, 0.88762, 390432139361.0);
        QuotePrice q3 = new QuotePrice("bitcoin", "Bitcoin",
                "https://assets.coingecko.com/coins/images/1/large/bitcoin.png?1696501400",
                56968.0, 1.95906, 1118652151810.0);
        QuotePrice q4 = new QuotePrice("ethereum", "Ethereum",
                "https://assets.coingecko.com/coins/images/279/large/ethereum.png?1696501628",
                3250.67, 0.88762, 390432139361.0);
        QuotePrice q5 = new QuotePrice("bitcoin", "Bitcoin",
                "https://assets.coingecko.com/coins/images/1/large/bitcoin.png?1696501400",
                56968.0, 1.95906, 1118652151810.0);
        QuotePrice q6 = new QuotePrice("ethereum", "Ethereum",
                "https://assets.coingecko.com/coins/images/279/large/ethereum.png?1696501628",
                3250.67, 0.88762, 390432139361.0);
        return ApiResponse.<List<QuotePrice>>builder() //
                .ok() //
                .data(List.of(q1, q2, q3, q4, q5, q6)) //
                .build();
    }

    @Override
    public ApiResponse<List<QuotePrice>> getStocks() {
        // POC
        QuotePrice q1 = new QuotePrice("AAPL", "Apple Inc.",
                "https://static2.finnhub.io/file/publicdatany/finnhubimage/stock_logo/AAPL.svg",
                182.63, 1.47, 2820150.7583561465);
        QuotePrice q2 = new QuotePrice("MSFT", "Microsoft Corp.",
                "https://static2.finnhub.io/file/publicdatany/finnhubimage/stock_logo/MSFT.svg",
                407.48, -0.06, 3027754.139088543);
        QuotePrice q3 = new QuotePrice("AAPL", "Apple Inc.",
                "https://static2.finnhub.io/file/publicdatany/finnhubimage/stock_logo/AAPL.svg",
                182.63, 1.47, 2820150.7583561465);
        QuotePrice q4 = new QuotePrice("MSFT", "Microsoft Corp.",
                "https://static2.finnhub.io/file/publicdatany/finnhubimage/stock_logo/MSFT.svg",
                407.48, -0.06, 3027754.139088543);
        QuotePrice q5 = new QuotePrice("AAPL", "Apple Inc.",
                "https://static2.finnhub.io/file/publicdatany/finnhubimage/stock_logo/AAPL.svg",
                182.63, 1.47, 2820150.7583561465);
        QuotePrice q6 = new QuotePrice("MSFT", "Microsoft Corp.",
                "https://static2.finnhub.io/file/publicdatany/finnhubimage/stock_logo/MSFT.svg",
                407.48, -0.06, 3027754.139088543);
        return ApiResponse.<List<QuotePrice>>builder() //
                .ok() //
                .data(List.of(q1, q2, q3, q4, q5, q6)) //
                .build();
    }

    @Override
    public ApiResponse<CandleChart> getCandleChart(String StockId) {
        // POC
        CandleChart.Candle s1 = null;
        CandleChart.Candle s2 = null;
        CandleChart.Candle s3 = null;
        CandleChart candleChart = null;
        if ("AAPL".equals(StockId)) {
            s1 = new CandleChart.Candle("2023-10-23", 184.57, 180.23, 182.99, 183.89);
            s2 = new CandleChart.Candle("2023-10-24", 187.10, 185.13, 186.99, 186.95);
            s3 = new CandleChart.Candle("2023-10-25", 189.10, 187.13, 188.99, 188.95);
            candleChart = new CandleChart(StockId, "Apple Inc.", List.of(s1, s2, s3));
        } else if ("MSFT".equals(StockId)) {
            s1 = new CandleChart.Candle("2023-10-23", 407.57, 403.23, 404.99, 403.89);
            s2 = new CandleChart.Candle("2023-10-24", 408.10, 405.13, 407.99, 407.95);
            s3 = new CandleChart.Candle("2023-10-25", 409.39, 406.13, 408.99, 406.10);
            candleChart = new CandleChart(StockId, "Microsoft Corp.", List.of(s1, s2, s3));
        }
        return ApiResponse.<CandleChart>builder() //
                .ok() //
                .data(candleChart) //
                .build();
    }

}
