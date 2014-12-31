package garber.paint.message;

import garber.paint.Canvas;

public class PaintMessageFactory {

	private Canvas canvas;

	public PaintMessageFactory(Canvas canvas) {
		this.canvas = canvas;
	}

	public PaintMessage getMessage(String message) {
		String[] messagesDesc = new String[9];
		int messageIndex = 0;

		StringBuilder desc = new StringBuilder();

		for (int i = 0; i < message.length(); i++) {
			if (message.charAt(i) == ' ') {
				messagesDesc[messageIndex++] = desc.toString();
				desc = new StringBuilder();
			}else{
				desc.append(message.charAt(i));
			}
			
		}

		PaintMessage paintMessage = null;

		if(messagesDesc[0] == "SHAPE"){
			paintMessage = new ShapeMessage(Integer.parseInt(messagesDesc[1]), Integer.parseInt(messagesDesc[2]),
					Integer.parseInt(messagesDesc[3]), Integer.parseInt(messagesDesc[4]),
					Type.valueOf(messagesDesc[5]), Boolean.parseBoolean(messagesDesc[6]),
					Integer.parseInt(messagesDesc[7]), Integer.parseInt(messagesDesc[8]));
		}else{
			if (messagesDesc[0] == "CLEAR") {
				paintMessage = new ClearMessage();
			} else if (messagesDesc[0] == "BUCKET_FILL") {
				paintMessage = new BucketFillMessage(Integer.parseInt(messagesDesc[1]),
						Integer.parseInt(messagesDesc[2]), Integer.parseInt(messagesDesc[3]),canvas);
			} else {// LINE
				paintMessage = new LineMessage(Integer.parseInt(messagesDesc[1]), Integer.parseInt(messagesDesc[2]),
						Integer.parseInt(messagesDesc[3]), Integer.parseInt(messagesDesc[4]),
						Integer.parseInt(messagesDesc[5]), Integer.parseInt(messagesDesc[6]));
			}

		}

		return paintMessage;

	}
}
