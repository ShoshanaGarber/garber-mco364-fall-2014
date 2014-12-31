package garber.paint.message;

import java.awt.Graphics2D;

public class ClearMessage implements PaintMessage{
	
	public ClearMessage(){
		
	}
	
	
	public String toString(){
		return "CLEAR";
	}

	@Override
	public void apply(Graphics2D g) {
		g.fillRect(0, 0, 800, 600);
		
	}

}
