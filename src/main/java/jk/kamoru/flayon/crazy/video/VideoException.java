package jk.kamoru.flayon.crazy.video;

public class VideoException extends RuntimeException {

	private static final long serialVersionUID = VIDEO.SERIAL_VERSION_UID;

	public VideoException(String message, Throwable cause) {
		super(message, cause);
	}

	public VideoException(String message) {
		super(message);
	}

	public VideoException(Throwable cause) {
		super(cause);
	}
	
}
