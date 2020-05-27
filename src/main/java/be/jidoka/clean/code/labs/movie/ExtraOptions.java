package be.jidoka.clean.code.labs.movie;

public enum ExtraOptions {
    THREE_D,
    OVERLENGTH,
    SPECIAL_MOVIE_DAY;

    private double price;

    static {
        THREE_D.price = 3.0;
        OVERLENGTH.price = 1.5;
        SPECIAL_MOVIE_DAY.price = -2.0;
    }

    public double getExtraOptionsPrice() {
        return price;
    }
}
