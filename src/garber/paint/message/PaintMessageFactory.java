package garber.paint.message;

import garber.paint.Canvas;

public class PaintMessageFactory {

	private Canvas canvas;

	public PaintMessageFactory(Canvas canvas) {
		this.canvas = canvas;
	}

	public PaintMessage getMessage(String message) {
		String[] messagesDesc = message.split("\\s");

		PaintMessage paintMessage = null;

		if (messagesDesc[0].equals("SHAPE")) {
			paintMessage = new ShapeMessage(Type.valueOf(messagesDesc[1]), Integer.parseInt(messagesDesc[2]),
					Integer.parseInt(messagesDesc[3]), Integer.parseInt(messagesDesc[4]),
					Integer.parseInt(messagesDesc[5]), Integer.parseInt(messagesDesc[6]),
					Integer.parseInt(messagesDesc[7]), Boolean.parseBoolean(messagesDesc[8]));
		} else if (messagesDesc[0].equals("CLEAR")) {
			paintMessage = new ClearMessage(canvas);
		} else if (messagesDesc[0].equals("BUCKET_FILL")) {
			paintMessage = new BucketFillMessage(Integer.parseInt(messagesDesc[1]), Integer.parseInt(messagesDesc[2]),
					Integer.parseInt(messagesDesc[3]), canvas);
		} else if (messagesDesc[0].equals("LINE")) {
			paintMessage = new LineMessage(Integer.parseInt(messagesDesc[1]), Integer.parseInt(messagesDesc[2]),
					Integer.parseInt(messagesDesc[3]), Integer.parseInt(messagesDesc[4]),
					Integer.parseInt(messagesDesc[5]), Integer.parseInt(messagesDesc[6]));

		}

		return paintMessage;

	}
}
