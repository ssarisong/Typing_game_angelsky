public class AngelMain {
	public static void main(String[] args) {
		AngelMain main = new AngelMain(); 
		AngelFirst gui = new AngelFirst();  //�г��� ���� ȭ�� ���� 
		gui.setAngelMain(main); // Main ��ġ ��� ;
	}	
	//�г��� ������ showGameView ���� 
	public void showGameView(AngelFirst gui ,String nick){		
		gui.dispose();//�г��� ȭ�� ���ֱ�
		AngelGameView game = new AngelGameView(nick);// �г��� ������ ����ȭ�� ���� 		
	}
}