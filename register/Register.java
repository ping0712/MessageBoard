package register;

public class Register {
	private String uid;
	private String pwd;
	public Register(String uid,String pwd) {
		this.uid = uid;
		this.pwd = pwd;
	}
	public String getUid() {
		return uid;
	}
	public String getPwd() {
		return pwd;
	}
	public void setUid(String uid) {
		this.uid = uid;
	}
	public void setPwd(String pwd) {
		this.pwd = pwd;
	}
}
