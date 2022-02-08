package ensta;

//import ensta.controller.Game;
import ensta.model.Board;

public class Main {

	public static void main(String args[]) {
        //new Game().init().run();
		Board b = new Board("board1",10);
		b.print();
    }

}
