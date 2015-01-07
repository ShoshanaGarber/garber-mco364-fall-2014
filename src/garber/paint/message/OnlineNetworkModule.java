package garber.paint.message;

import garber.paint.Canvas;

import java.io.IOException;
import java.net.UnknownHostException;

public class OnlineNetworkModule implements NetworkModule {
	
	private ClientSide client;
	private Canvas canvas;
	
	public OnlineNetworkModule(Canvas canvas) throws UnknownHostException, IOException{
		this.client = new ClientSide(canvas);
	}

	@Override
	public void sendMessage(PaintMessage message){
		try {
			client.sendMessage(message.toString());
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
	

}
