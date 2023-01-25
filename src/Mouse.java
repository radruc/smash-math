public class Mouse {
    private boolean mouse;
    public int spawnTime;
    public int ttl;
    private int points;

    Mouse(boolean m) {
        this.mouse = m;
    }

    public void setMouse(boolean m) {
        this.mouse = m;
        this.spawnTime = Game.timeLeft;
        this.ttl = 50;
    }

    public int getTTL() {
        return ttl;
    }

    public void setPoints(int points) {
        this.points = points;
    }

    public int getPoints() {
        return points;
    }

    public boolean getMouse() {
        return mouse;
    }

}// koniec klasy Mouse
