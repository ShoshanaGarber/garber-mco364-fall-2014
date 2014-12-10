package garber.paint.message;

import garber.paint.Shape;

public class MessageFactory {

	public MessageFactory() {

	}

	public PaintMessage getMessage(String message){
		String[] messagesDesc = new String[9];
		
		
		StringBuilder desc = new StringBuilder();
		
		for(int i = 0; i < message.length();i++){
			while(message.charAt(i) != ' '){
				desc.append(message.charAt(i));
			}
			messagesDesc[i] = desc.toString();
		}
		Shape shape = Shape.valueOf(messagesDesc[0]);
		
		PaintMessage paintMessage;
		
		switch(shape){
		case Rect:
		case Oval:	
			if(messagesDesc[7].equals("true")){
				
			}else{
				
			}
			paintMessage = new ShapeMessage(Integer.parseInt(messagesDesc[1]),Integer.parseInt(messagesDesc[2]), Integer.parseInt(messagesDesc[3]),Integer.parseInt(messagesDesc[4]),Integer.parseInt(messagesDesc[5]),Integer.parseInt(messagesDesc[6]),)
			break;
		
			
			
			break;
		}
		
		
		return paintMessage;
		
	}
}
