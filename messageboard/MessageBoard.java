package messageboard;

public class MessageBoard {
	private String uid;
	private String text;
	public MessageBoard(String uid,String text) {
		this.uid = uid;
		this.text = text;
	}
	public String getUid() {
		return uid;
	}
	public String getText() {
		return text;
	}
	public void setUid(String uid) {
		this.uid = uid;
	}
	public void setText(String text) {
		this.text = text;
	}
}
