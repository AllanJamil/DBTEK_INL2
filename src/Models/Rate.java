package Models;

public class Rate {

    private int rate_ID;
    private String rate;

    public Rate(int rate_ID, String rate) {
        this.rate_ID = rate_ID;
        this.rate = rate;
    }

    public int getRate_ID() {
        return rate_ID;
    }

    public String getRate() {
        return rate;
    }
}
