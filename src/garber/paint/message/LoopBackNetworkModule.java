package garber.paint.message;

import garber.paint.Canvas;

public class LoopBackNetworkModule implements NetworkModule{
	
	private Canvas canvas;
	
	public LoopBackNetworkModule(Canvas canvas){
		this.canvas = canvas;
	}

	@Override
	public void sendMessage(PaintMessage message) {
		message.apply(canvas.getGraphics());
		
	}
	
}
