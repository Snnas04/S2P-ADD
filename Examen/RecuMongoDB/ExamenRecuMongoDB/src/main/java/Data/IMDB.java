package Data;

public class IMDB {
    private int votes;
    private int rating;

    public IMDB(int votes, int rating) {
        this.votes = votes;
        this.rating = rating;
    }

    public int getVotes() {
        return votes;
    }

    public void setVotes(int votes) {
        this.votes = votes;
    }

    public int getRating() {
        return rating;
    }

    public void setRating(int rating) {
        this.rating = rating;
    }

    @Override
    public String toString() {
        return "IMDB{" +
                "votes=" + votes +
                ", rating=" + rating +
                '}';
    }
}
