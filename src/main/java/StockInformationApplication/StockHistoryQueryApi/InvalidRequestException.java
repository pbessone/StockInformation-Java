package StockInformationApplication.StockHistoryQueryApi;

public class InvalidRequestException extends Exception {
    private String code;

    public InvalidRequestException(String code, String message) {
        super(message);
        this.code = code;
    }

    public String getCode() {
        return this.code;
    }
}
