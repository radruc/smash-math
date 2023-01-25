public class Score implements Comparable<Score> {
    private String playerName;
    private int score;

    public Score(String playerName, int score) {

        this.playerName = playerName;
        this.score = score;

    }

    public String getPlayerName() {
        return playerName;
    }

    public int getScore() {
        return score;
    }

    @Override
    public int compareTo(Score o) {
        return Integer.compare(score, o.score);
    }
}
