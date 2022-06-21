public class AngelMain {
	public static void main(String[] args) {
		AngelMain main = new AngelMain(); 
		AngelFirst gui = new AngelFirst();  //닉네임 설정 화면 띄우기 
		gui.setAngelMain(main); // Main 위치 등록 ;
	}	
	//닉네임 가지고 showGameView 실행 
	public void showGameView(AngelFirst gui ,String nick){		
		gui.dispose();//닉네임 화면 없애기
		AngelGameView game = new AngelGameView(nick);// 닉네임 가지고 게임화면 띄우기 		
	}
}