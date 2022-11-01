package transport;

import java.util.Objects;

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

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Sponsor sponsor = (Sponsor) o;
        return Objects.equals(name, sponsor.name) && Objects.equals(amount, sponsor.amount);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name, amount);
    }
}