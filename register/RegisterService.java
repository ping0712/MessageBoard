package register;

public class RegisterService {
	// �T�w�O�_�����Ʊb��
	public boolean checkCanCreate(String uid) {
		RegisterDao dao = new RegisterDao();
		if(dao.selectUid(uid).isEmpty()) {
			return true;
		} else {
			return false;
		}
	}
	// �إ߱b��
	public void createAccount(String uid,String pwd) {
		RegisterDao dao = new RegisterDao();
		dao.insertTable(uid, pwd);
	}
}
