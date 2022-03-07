package base;

public class CardBase {
    static final int[] cardBase = {1458, 4563, 5623, 9512, 6541, 7894};

    public Boolean checkCardNumber(int number) {
        for (int s : cardBase) {
            if (number == s) {
                return true;
            }
        }
        return false;
    }
}
