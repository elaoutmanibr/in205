package ensta.ai;
import java.util.List;

import ensta.model.Board;
import ensta.model.Coords;
import ensta.model.Hit;
import ensta.model.Player;
import ensta.model.ship.AbstractShip;
import ensta.util.Orientation;
import ensta.view.InputHelper;

public class PlayerAI extends Player {
    /* **
     * Attribut
     */
    private BattleShipsAI ai;

    /* **
     * Constructeur
     */
    public PlayerAI(Board ownBoard, Board opponentBoard, List<AbstractShip> ships) {
        super(ownBoard, opponentBoard, ships);
        ai = new BattleShipsAI(ownBoard, opponentBoard);
    }

    public void putShips() {    	    	
    	ai.putShips(this.ships);
    }
    
    public Hit sendHit() {
    	Coords coords = new Coords('A',1);
    	Hit h = ai.sendHit(coords);
    	return h;
    	
    }
}
