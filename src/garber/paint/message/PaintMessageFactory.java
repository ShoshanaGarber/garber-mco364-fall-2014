package garber.paint.message;


public class PaintMessageFactory {

	public PaintMessageFactory() {

	}

	public PaintMessage getMessage(String message) {
		String[] messagesDesc = new String[9];

		StringBuilder desc = new StringBuilder();

		for (int i = 0; i < message.length(); i++) {
			while (message.charAt(i) != ' ') {
				desc.append(message.charAt(i));
			}
			messagesDesc[i] = desc.toString();
		}
		Type shape = Type.valueOf(messagesDesc[0]);

		PaintMessage paintMessage = null;

		switch (shape) {
		case RECT:
		case OVAL:
			paintMessage = new ShapeMessage(Integer.parseInt(messagesDesc[1]), Integer.parseInt(messagesDesc[2]),
					Integer.parseInt(messagesDesc[3]), Integer.parseInt(messagesDesc[4]),
					Type.valueOf(messagesDesc[5]), Boolean.parseBoolean(messagesDesc[6]),
					Integer.parseInt(messagesDesc[7]), Integer.parseInt(messagesDesc[8]));
			break;
		default:
			if (messagesDesc[0] == "CLEAR") {
				paintMessage = new ClearMessage();
			} else if (messagesDesc[0] == "BUCKET_FILL") {
				paintMessage = new BucketFillMessage(Integer.parseInt(messagesDesc[1]),
						Integer.parseInt(messagesDesc[2]), Integer.parseInt(messagesDesc[3]));
			} else {// LINE
				paintMessage = new LineMessage(Integer.parseInt(messagesDesc[1]), Integer.parseInt(messagesDesc[2]),
						Integer.parseInt(messagesDesc[3]), Integer.parseInt(messagesDesc[4]),
						Integer.parseInt(messagesDesc[5]), Integer.parseInt(messagesDesc[6]));
			}
			break;

		}

		return paintMessage;

	}
}
