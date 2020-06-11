package StockInformationApplication.StockInformation;

import StockInformationApplication.StockHistoryQueryApi.InvalidRequestException;
import StockInformationApplication.StockHistoryQueryApi.StockHistoryQueryRange;
import StockInformationApplication.StockHistoryQueryApi.StockHistoryQueryResponse;
import StockInformationApplication.StockHistoryQueryApi.StockHistoryQueryService;
import org.apache.commons.lang3.ArrayUtils;
import org.apache.commons.math3.util.Precision;
import org.springframework.stereotype.Service;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.NoSuchElementException;
import java.util.stream.Collectors;

@Service
public class BasicStockInformationService implements StockInformationService {
    StockHistoryQueryService stockHistoryQueryService;
    public BasicStockInformationService(StockHistoryQueryService stockHistoryQueryService) {
        this.stockHistoryQueryService = stockHistoryQueryService;
    }

    public BasicStockInformation getBasicStockInformationAsync(String symbol) throws InvalidRequestException, IOException, InterruptedException {
        var response = this.stockHistoryQueryService.Query(symbol, StockHistoryQueryRange.OneWeek);

        var info = new BasicStockInformation();
        info.setStockName(response.getShareName());
        info.setCurrency(response.getCurrency());
        info.setPriceHint(response.getPriceHint());
        info.setMinimumStockPriceForPeriod(calculateMinimumSharePrice(response));
        info.setMaximumStockPriceForPeriod(calculateMaximumSharePrice(response));
        info.setAverageStockPriceForPeriod(calculateAverageSharePrice(response));
        return info;
    }

    private double calculateMaximumSharePrice(StockHistoryQueryResponse apiResponse)
    {
        var quoteIndicatorsHigh = apiResponse.getHistory().getHigh();
        var values = convertToList(quoteIndicatorsHigh);

        var max = values
            .stream()
            .mapToDouble(v -> v)
            .max().orElseThrow(NoSuchElementException::new);

        max = Precision.round(max, apiResponse.getPriceHint());
        return max;
    }

    private double calculateMinimumSharePrice(StockHistoryQueryResponse apiResponse)
    {
        double[] quoteIndicatorsLow = apiResponse.getHistory().getLow();
        var values = convertToList(quoteIndicatorsLow);

        var min = values
                .stream()
                .mapToDouble(v -> v)
                .min().orElseThrow(NoSuchElementException::new);

        min = Precision.round(min, apiResponse.getPriceHint());
        return min;
    }

    private double calculateAverageSharePrice(StockHistoryQueryResponse apiResponse)
    {
        var history = apiResponse.getHistory();
        var timestamp = history.getTimeStamp();
        if (timestamp == null || timestamp.length == 0) {
            return 0; // There is nothing to count
        }

        double[] concatOpenClose = ArrayUtils.addAll(history.getOpen(), history.getClose());
        double[] concatLowHigh = ArrayUtils.addAll(history.getLow(), history.getHigh());
        double[] concatAll = ArrayUtils.addAll(concatOpenClose, concatLowHigh);
        var values = convertToList(concatAll);

        var average = values
                .stream()
                .mapToDouble(v -> v)
                .average().orElseThrow(NoSuchElementException::new);

        average = Precision.round(average, apiResponse.getPriceHint());
        return average;
    }

    private List<Double> convertToList(double[] values)
    {
        return Arrays.stream(values).boxed().collect(Collectors.toCollection(ArrayList::new));
    }
}
