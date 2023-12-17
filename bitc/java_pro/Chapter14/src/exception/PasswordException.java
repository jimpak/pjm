package exception;

public class PasswordException extends Exception {
	
	public PasswordException(String message) {
		super(message);
		
	}
	
	public void setUserPW(String userPW) throws PasswordException {
		if(userPW == null) {
			throw new PasswordException("비밀번호는 null일 수 없습니다.");
		}
		else if (userPW.matches("[a-zA-Z]")) {
			throw new PasswordException("비밀번호는 문자열만 사용할 수 없습니다.");
		}
		else if (userPW.length() > 5) {
			throw new PasswordException("비밀번호는 5자 미만인 경우 사용할 수 없습니다.");
		}
	}
	
	public static void main(String[] args) {
		
		
	}
	
}
