package messageboard;

import java.util.*;

public class MessageBoardService {
	public ArrayList<MessageBoard> getAll(){
		ArrayList<MessageBoard> result = new ArrayList<>();
		MessageBoardDao dao = new MessageBoardDao();
		result = dao.selectAll();
		return result;
	}
	public void newMessage(String uid,String msg) {
		MessageBoardDao dao = new MessageBoardDao();
		dao.insertTable(uid, msg);
	}
	public void deleteMessage(int index) {
		MessageBoardDao dao = new MessageBoardDao();
		dao.deleteData(index);
	}
	public int selectSerial(int index) {
		MessageBoardDao dao = new MessageBoardDao();
		return dao.selectSerial(index);
	}
	public void updateMessage(int index,String msg) {
		MessageBoardDao dao = new MessageBoardDao();
		dao.updateData(index, msg);
	}
}
