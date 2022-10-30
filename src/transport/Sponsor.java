package transport;

public class Sponsor {
    private final String name;
    private final String amount;

    public Sponsor(String name, String amount) {
        this.name = name;
        this.amount = amount;
    }

    public String getName() {
        return name;
    }

    public String getAmount() {
        return amount;
    }

    public void toSponsorRace() {
        System.out.printf("спонсор \"%s\" проспонсировал заезд на %n%d",name,amount);
    }

    @Override
    public String toString() {
        return name +", сумма спонсирования: "+ amount ;
    }
}