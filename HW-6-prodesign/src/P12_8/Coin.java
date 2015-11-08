package P12_8;

/**
 * Created by Eason on 11/7/15.
 */
public class Coin {
    private CoinType type;
    private double value;

    public Coin(CoinType type) {
        this.type = type;
        if (type == CoinType.Dollar) {
            value = 1;
        } else if (type == CoinType.Quarter) {
            value = 0.25;
        } else if (type == CoinType.Dime) {
            value = 0.1;
        } else if (type == CoinType.Nickel) {
            value = 0.05;
        } else if (type == CoinType.Pennie) {
            value = 0.01;
        }
    }

    public double getValue() {
        return value;
    }
}
