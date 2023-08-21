package ETC.lawofdemeter;

public class Ticket {
    private final Movie movie;
    private boolean used;

    public Ticket(Movie movie) {
        this.movie = movie;
        this.used = false;
    }

    public boolean isUsed() {
        return used;
    }
}
