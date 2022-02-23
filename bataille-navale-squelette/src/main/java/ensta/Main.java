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
		Coords c = new Coords('J',10);
		b.putShip(B1,c);
		b.sendHit(c);
		Coords c1 = new Coords('G',10);
		Coords c2 = new Coords('H',10);
		Coords c3 = new Coords('I',10);
		b.sendHit(c1);
		b.sendHit(c2);
		String h = b.sendHit(c3).toString();
		System.out.println(h);
		b.print();
    }

}
