package ensta;

//import ensta.controller.Game;
import ensta.model.Board;
import ensta.model.Coords;
import ensta.model.ship.BattleShip;
import ensta.util.Orientation;

public class Main {

	public static void main(String args[]) {
        //new Game().init().run();
		Board b = new Board("board1",10);
		//b.print();
		BattleShip B1 = new BattleShip(Orientation.WEST);
		Coords c = new Coords('D',3);
		b.putShip(B1,c);
		b.print();
    }

}
