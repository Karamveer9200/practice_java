package cs110.Lab;

class Money {
    private String currency;
    private Long smallestAmount;


    Money(String currency, Long smallestAmount) {
        this.currency = currency;
        this.smallestAmount = smallestAmount;
    }

    public char getCurrency() {
            if (currency.equalsIgnoreCase("Dollar")) {
                return '$';
            } else if (currency.equalsIgnoreCase("Pound")) {
                return '£';
            } else if (currency.equalsIgnoreCase("Euro")) {
                return '€';
            } else {
                return '0';
            }
    }

    public Long getSmallestAmount() {
        return smallestAmount / 100;
    }

    @Override
    public String toString() {
        return getCurrency() +""+ getSmallestAmount();
    }
}
public class Lab8Stage1Money {
    public static void main(String[] args) {
        Money cents = new Money("Dollar", 10000L);
        Money pence = new Money("pound",1000l);

        System.out.println(cents);
        System.out.println(pence);
    }
}
