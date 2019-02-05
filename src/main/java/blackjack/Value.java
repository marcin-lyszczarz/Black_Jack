package blackjack;

/**
 * Created by A&M on 29.01.2019.
 */
public enum Value {

    Dwa(2),
    Trzy(3),
    Cztery(4),
    Piec(5),
    Szesc(6),
    Siedem(7),
    Osiem(8),
    Dziewiec(9),
    Dziesiec(10),
    Walet(10),
    Dama(10),
    Krol(10),
    As(11);

    private final int value;

    Value(int value) {
        this.value = value;
    }

    public int getValue(){
        return value;
    }


}
