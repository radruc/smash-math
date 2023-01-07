public class Mouse {
    private boolean mouse;

    Mouse(boolean m) {
        this.mouse = m;
    }

    public void setMouse(boolean x){
        mouse = x;
    }

    public boolean getMouse(){
        return mouse;
    }

//    private void genRandMouses(){
//            Random rnd = new Random(System.currentTimeMillis());
//            int mouse_1 = rnd.nextInt(9);
//            int mouse_2 = rnd.nextInt(9);
//            board[mouse_1] = 1;
//            board[mouse_2] = 1;
//            holes[mouse_1] = new JLabel(mouseOut);
//            holes[mouse_2] = new JLabel(mouseOut);
//    }
}
