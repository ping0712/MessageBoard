package login;

public class LoginService {
	public int checkLogin(String uid,String pwd) {
		LoginDao dao = new LoginDao();
		if(dao.selectUser(uid).isEmpty()) {
			return 3;
		} else {
			if (dao.selectUser(uid).equals(pwd)) {
				return 1;
			} else {
				return 2;
			}
		}
	}
}
