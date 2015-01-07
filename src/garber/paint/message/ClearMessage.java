package garber.paint.message;

import garber.paint.Canvas;

import java.awt.Graphics2D;

public class ClearMessage implements PaintMessage{
	
	private Canvas canvas;
	
	public ClearMessage(Canvas canvas){
		this.canvas = canvas;
	}
	
	
	public String toString(){
		return "CLEAR";
	}

	@Override
	public void apply(Graphics2D g) {

		canvas.clearCanvas();
	}

}
