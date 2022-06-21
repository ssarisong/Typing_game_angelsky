import javax.swing.JFrame;
import javax.swing.JLabel;
import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import javax.swing.JTextField;
import javax.swing.JButton;
import javax.swing.SwingConstants;
import javax.swing.JTextArea;
import javax.swing.JTextPane;
import javax.swing.JList;

class AngelFirst extends JFrame implements ActionListener,KeyListener{
	private JTextField textField;// 닉네임 입력창
	private  JLabel lblNewLabel;  // 라벨 
	public  String NickName; // 닉네임 변수 
	AngelMain main;
	public AngelFirst() {
		setSize(500,600);
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		setTitle("하늘에서 글자가 떨어진다면");
		getContentPane().setLayout(null);
		//AngelFirst.setBackground(Color.ORANGE);
		
	    lblNewLabel = new JLabel("닉네임 설정");
	    lblNewLabel.setForeground(Color.BLUE);
		lblNewLabel.setFont(new Font("신명조", Font.PLAIN, 27));
		lblNewLabel.setBounds(88, 33, 382, 32);
		getContentPane().add(lblNewLabel);
		
		textField = new JTextField(); //닉네임 입력창 
		textField.setFont(new Font("굴림", Font.BOLD, 24));
		textField.setBounds(24, 261, 238, 66);
		getContentPane().add(textField);
		textField.setColumns(10);
		
		JButton btnNewButton = new JButton("확인"); //확인버튼 
		btnNewButton.setFont(new Font("굴림", Font.BOLD, 22));
		btnNewButton.setBounds(290, 261, 156, 66);
		getContentPane().add(btnNewButton);
		btnNewButton.addActionListener(this);
		
		JLabel lblNewLabel_1 = new JLabel("닉네임"); // 닉네임 라벨 
		lblNewLabel_1.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_1.setFont(new Font("굴림", Font.BOLD, 19));
		lblNewLabel_1.setBounds(24, 202, 188, 47);
		getContentPane().add(lblNewLabel_1);
		setVisible(true);
		textField.addKeyListener(this);
	}
	@Override
	public void actionPerformed(ActionEvent e) { 
		if(! textField.getText().equals("")){	
			// 텍스트 입력창에 값이 있다면 닉네임 변수에 저장 후 게임 화면 띄우기 
			NickName = textField.getText().toString();
			main.showGameView(this, NickName);
		}
		else {
			// 텍스트 입력창에 값이 없다면 라벨 텍스트 변경 
			lblNewLabel.setText("올바르지 않은 닉네임 입니다.");
		}
	}
	//Main 등록 
	public void setAngelMain(AngelMain main) {
		this.main =main;	
	}
	@Override
	public void keyPressed(KeyEvent e) {
		if (e.getKeyCode() == KeyEvent.VK_ENTER){
			// 텍스트 입력창에 값이 있다면 닉네임 변수에 저장 후 게임 화면 띄우기 
		if(! textField.getText().equals("")){
			NickName = textField.getText().toString();
			System.out.println(NickName);
			main.showGameView(this, NickName);	
		}
		else {
			// 텍스트 입력창에 값이 없다면 라벨텍스트 변경 
			lblNewLabel.setText("올바르지 않은 닉네임 입니다.");
			}
		}
	}
	@Override
	public void keyReleased(KeyEvent e) {
	}
	@Override
	public void keyTyped(KeyEvent e) {	
	}
}