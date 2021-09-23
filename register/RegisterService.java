package register;

public class RegisterService {
	// 確定是否有重複帳號
	public boolean checkCanCreate(String uid) {
		RegisterDao dao = new RegisterDao();
		if(dao.selectUid(uid).isEmpty()) {
			return true;
		} else {
			return false;
		}
	}
	// 建立帳號
	public void createAccount(String uid,String pwd) {
		RegisterDao dao = new RegisterDao();
		dao.insertTable(uid, pwd);
	}
}
