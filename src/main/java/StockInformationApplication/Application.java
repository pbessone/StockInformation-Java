package StockInformationApplication;

import StockInformationApplication.StockHistoryQueryApi.InvalidRequestException;
import StockInformationApplication.StockInformation.*;
import org.apache.commons.lang3.StringUtils;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

@SpringBootApplication
class Application implements CommandLineRunner {
    private StockInformationService stockInformationService;
    private StockInformationExporter stockInformationExporter;

    public Application(
            StockInformationService stockInformationService,
            StockInformationExporter stockInformationExporter)
    {
        this.stockInformationService = stockInformationService;
        this.stockInformationExporter = stockInformationExporter;
    }

    public static void main(String[] args) {
        SpringApplication.run(Application.class, args);
    }

    @Override
    public void run(String... args) throws Exception {
        System.out.println("Welcome to the StockInformationApplication.StockInformation Application");
        System.out.println("-------------------------------------------");
        System.out.println();

        var yesNoOptions = Arrays.asList("Y", "N");
        var shouldContinue = true;
        while (shouldContinue)
        {
            var stockSymbol = this.handleUserInput("Please type the name of the stock (example: GOOG, AAPL, CSCO):", "Please enter a valid stock symbol");

            var currentStockInformation = this.getStockInformation(stockSymbol);
            if (currentStockInformation != null)
            {
                this.printStockInformation(currentStockInformation);

                var exportChoice = this.handleUserInput("Do you want to export this stock information as JSON?", "Not a valid option", yesNoOptions);
                if (exportChoice.equalsIgnoreCase("Y"))
                {
                    this.exportStockInformation(currentStockInformation);
                }
            }

            var continueChoice = this.handleUserInput("Do you want to query another stock?", "Not a valid option", yesNoOptions);
            if (continueChoice.equalsIgnoreCase("N"))
            {
                shouldContinue = false;
            }
        }

        System.out.println();
        System.out.println("Thank you for using the StockInformationApplication.StockInformation Application");
    }

    private BasicStockInformation getStockInformation(String symbol)
    {
        try {
            var info = stockInformationService.getBasicStockInformationAsync(symbol);
            return info;
        } catch(InvalidRequestException e) {
            System.out.println("There has been an issue fetching the Stock information");
            System.out.println(e.getCode());
            System.out.println(e.getMessage());
        } catch(Exception e) {
            System.out.println("There has been an unexpected issue fetching the Stock information.");
        }

        return null;
    }

    private void printStockInformation(BasicStockInformation info)
    {
        System.out.printf("Stock Name: %s%n", info.getStockName());
        System.out.printf("Currency: %s%n", info.getCurrency());
        System.out.printf("Price Hint: %d%n", info.getPriceHint());
        System.out.printf("Minimum Stock Price: %f%n", info.getMinimumStockPriceForPeriod());
        System.out.printf("Maximum Stock Price: %f%n", info.getMaximumStockPriceForPeriod());
        System.out.printf("Average Stock Price: %f%n", info.getAverageStockPriceForPeriod());
    }

    private void exportStockInformation(BasicStockInformation info) {
        var jsonString = this.stockInformationExporter.getJsonString(info);
        System.out.println(jsonString);
    }

    private String handleUserInput(String inputMessage, String errorMessage) {
        return this.handleUserInput(inputMessage, errorMessage, null);
    }

    private String handleUserInput(String inputMessage, String errorMessage, List<String> validOptions) {
        while (true) {
            if (validOptions != null && validOptions.size() > 0) {
                System.out.printf("%s (%s) ", inputMessage, String.join("/", validOptions));
            } else {
                System.out.printf("%s ", inputMessage);
            }

            var scanner = new Scanner(System.in);
            var userInput = scanner.nextLine();
            if (StringUtils.isBlank(userInput) ||
                    (validOptions != null && validOptions.size() > 0 && !validOptions.contains(userInput.toUpperCase()))) {
                System.out.println(errorMessage);
                continue;
            }

            return userInput;
        }
    }
}
