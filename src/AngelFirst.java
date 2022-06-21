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
	private JTextField textField;// �г��� �Է�â
	private  JLabel lblNewLabel;  // �� 
	public  String NickName; // �г��� ���� 
	AngelMain main;
	public AngelFirst() {
		setSize(500,600);
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		setTitle("�ϴÿ��� ���ڰ� �������ٸ�");
		getContentPane().setLayout(null);
		//AngelFirst.setBackground(Color.ORANGE);
		
	    lblNewLabel = new JLabel("�г��� ����");
	    lblNewLabel.setForeground(Color.BLUE);
		lblNewLabel.setFont(new Font("�Ÿ���", Font.PLAIN, 27));
		lblNewLabel.setBounds(88, 33, 382, 32);
		getContentPane().add(lblNewLabel);
		
		textField = new JTextField(); //�г��� �Է�â 
		textField.setFont(new Font("����", Font.BOLD, 24));
		textField.setBounds(24, 261, 238, 66);
		getContentPane().add(textField);
		textField.setColumns(10);
		
		JButton btnNewButton = new JButton("Ȯ��"); //Ȯ�ι�ư 
		btnNewButton.setFont(new Font("����", Font.BOLD, 22));
		btnNewButton.setBounds(290, 261, 156, 66);
		getContentPane().add(btnNewButton);
		btnNewButton.addActionListener(this);
		
		JLabel lblNewLabel_1 = new JLabel("�г���"); // �г��� �� 
		lblNewLabel_1.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_1.setFont(new Font("����", Font.BOLD, 19));
		lblNewLabel_1.setBounds(24, 202, 188, 47);
		getContentPane().add(lblNewLabel_1);
		setVisible(true);
		textField.addKeyListener(this);
	}
	@Override
	public void actionPerformed(ActionEvent e) { 
		if(! textField.getText().equals("")){	
			// �ؽ�Ʈ �Է�â�� ���� �ִٸ� �г��� ������ ���� �� ���� ȭ�� ���� 
			NickName = textField.getText().toString();
			main.showGameView(this, NickName);
		}
		else {
			// �ؽ�Ʈ �Է�â�� ���� ���ٸ� �� �ؽ�Ʈ ���� 
			lblNewLabel.setText("�ùٸ��� ���� �г��� �Դϴ�.");
		}
	}
	//Main ��� 
	public void setAngelMain(AngelMain main) {
		this.main =main;	
	}
	@Override
	public void keyPressed(KeyEvent e) {
		if (e.getKeyCode() == KeyEvent.VK_ENTER){
			// �ؽ�Ʈ �Է�â�� ���� �ִٸ� �г��� ������ ���� �� ���� ȭ�� ���� 
		if(! textField.getText().equals("")){
			NickName = textField.getText().toString();
			System.out.println(NickName);
			main.showGameView(this, NickName);	
		}
		else {
			// �ؽ�Ʈ �Է�â�� ���� ���ٸ� ���ؽ�Ʈ ���� 
			lblNewLabel.setText("�ùٸ��� ���� �г��� �Դϴ�.");
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