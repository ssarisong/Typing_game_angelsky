import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.util.Random;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;

public class AngelGameView extends JFrame implements ActionListener, KeyListener, ListSelectionListener {
	private JTextField textField_1;
	private JButton btn_gamestart;
	private String[] work = {"�Ѽ���","�ۼ���","���α�","��ǻ��","��ǻ�� ����","��ü������","����","�����ũ","�̷���","���а�",
			"���̰�","�׶��","��������","��Ŭ����","�ڹ�","�ź���","��Ʈ��","�Ѽ����б�","�����","����Ʈ��","�ٳ���","����","������","���",
			"����","�޴���","����","����","���뱹","����","�Ľ�Ÿ","�������","��ȭ","���з�","�Ѽ����Ա�","����ö","����","�����","���ֵ�",
			"��ġ������","����","�ڴ�����","����","Ĭ����","������","���ڶ�","������","�Ｚ","���̹�","����","īī��","����","�λ�","�̱�",
			"�ַ�����","�ڵ�","�ڹٽ�ũ��Ʈ","ȣ��","����","ĳ����","�̿���","�����̵�","����","���ݸ�","�����","�߹�","��â","��â","��â",
			"����","���ø�","����ø�","������","�Ҽ�","����","�Ǵ��Ա�","�Ѿ��","�սʸ�","ũ��������","����","�߼�","����","����","����",
			"����","�����","������","�޹�����","��ġ��","��ħ��","���ɸ�","����Ų���","�������","Ű��","����","������","����","�踻��","Ƣ��",
			"ȣ��","�ؾ","����Ƣ��","�ܹ���","�߰���","Į����","�곫��","¥���","«��","������","�Ե�����","��������","������","�߲�ġ","�߰���",
			"���ø���","Ƽ��","���׸�","��í","īī����","�ν�Ÿ�׷�","���̽���","���̷ε��","�ѷ��ڽ���","��","�뷡��","������","�������","ī��",
			"���帶��","����ģ��","��Ʈ","������","û����","�ݹ���","ġ��","���ǽ�","�縻","�Ź�","�ȭ","����","������","�Ź߲�","�Ƶ�ٽ�","����","�߶��",
			"��Ÿ","�ǾƳ�","�巳","ȣ��","����","�и�","����","��","���","��","�γ�","�������","��������","ġ��","�ູ","���","����","�ÿ���","���","����",
			"��","����","��","�ϴ�","ȣ����","����","������","��","����","�޹�����","����","������","����","����","���","�̻�ȭź��","����","����","�밡��","�Ѹ�Ŭ"};
	private String[] game_LEVEL = {"level 1", "level 2", "level 3", "level 4", "level 5", "level 6", "level 7", "level 8",
			"level 9", "level 10"};
	private JPanel panel_Screen;
	private JLabel label[] = new JLabel[10000];
	private JLabel score;
	private int scorenum = 0;
	private int i = 0;
	private JList list;
	private int speed = 3500;
	private JPanel panel_life1;
	private JPanel panel_life2;
	private JPanel panel_life3;
	private int life = 0;
	private JLabel level;
	private JPanel panel_over;
	private JLabel lblNewLabel;
	private JLabel lblScore;
	private JLabel Label_nickname;
	private JLabel lblNick;
	private String NickName;
	AngelMain main;

	public AngelGameView(String Nick) {
		NickName = Nick;// �г��� ���� ����
		setSize(1200, 800);
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		getContentPane().setLayout(null);

		textField_1 = new JTextField();// �ܾ� �Է�
		textField_1.setBounds(115, 631, 267, 38);
		getContentPane().add(textField_1);
		textField_1.setColumns(10);

		list = new JList(game_LEVEL);// ���� ����Ʈ �����ֱ�
		list.setSelectedIndex(0);
		list.setFont(new Font("����", Font.BOLD, 22));
		list.setBounds(986, 44, 162, 280);
		getContentPane().add(list);

		btn_gamestart = new JButton("����");// ���� ��ư
		btn_gamestart.setFont(new Font("����", Font.BOLD, 23));
		btn_gamestart.setBounds(497, 627, 105, 38);
		getContentPane().add(btn_gamestart);

		// ����ȭ��
		ImageIcon icon = new ImageIcon("angelsky.jpg");
		panel_Screen = new JPanel() {
			public void paintComponent(Graphics g) {
				g.drawImage(icon.getImage(), 0, 0, null);
				setOpaque(false);
				super.paintComponent(g);
			}
		};
		panel_Screen.setBounds(43, 29, 740, 571);
		getContentPane().add(panel_Screen);
		panel_Screen.setLayout(null);
		panel_Screen.setVisible(false);

		JPanel panel_1 = new JPanel(); // ����ȭ�鿡�� ������ ��
		panel_1.setBackground(Color.RED);
		panel_1.setBounds(0, 520, 740, 10);
		panel_Screen.add(panel_1);

		score = new JLabel("0��");// ������
		score.setHorizontalAlignment(SwingConstants.CENTER);
		score.setFont(new Font("����", Font.BOLD, 25));
		score.setBounds(823, 241, 149, 45);
		getContentPane().add(score);

		Label_nickname = new JLabel(Nick); //�г��� 
		Label_nickname.setHorizontalAlignment(SwingConstants.CENTER);
		Label_nickname.setFont(new Font("����", Font.BOLD, 25));
		Label_nickname.setForeground(Color.BLUE);
		Label_nickname.setBounds(823, 71, 149, 27);
		getContentPane().add(Label_nickname);

		level = new JLabel("level 1"); //���� ����Ʈ
		level.setHorizontalAlignment(SwingConstants.CENTER);
		level.setFont(new Font("����", Font.BOLD, 24));
		level.setBounds(846, 142, 99, 42);
		getContentPane().add(level);

		panel_life1 = new JPanel(); // ����1
		panel_life1.setBackground(Color.GREEN);
		panel_life1.setBounds(824, 319, 26, 27);
		getContentPane().add(panel_life1);

		panel_life2 = new JPanel();// ����2
		panel_life2.setBackground(Color.GREEN);
		panel_life2.setBounds(864, 319, 26, 27);
		getContentPane().add(panel_life2);

		panel_life3 = new JPanel(); // ����3
		panel_life3.setBackground(Color.GREEN);
		panel_life3.setBounds(904, 319, 26, 27);
		getContentPane().add(panel_life3);

		// ���� ��� ȭ��
		panel_over = new JPanel();// ���� ��� ���
		panel_over.setBackground(Color.YELLOW);
		panel_over.setBounds(14, 142, 794, 286);
		panel_over.setVisible(false);
		getContentPane().add(panel_over);
		panel_over.setLayout(null);

		lblNewLabel = new JLabel("Game Over"); // ���� ���� �� 
		lblNewLabel.setBounds(0, 36, 794, 63);
		panel_over.add(lblNewLabel);
		lblNewLabel.setForeground(Color.RED);
		lblNewLabel.setFont(new Font("����", Font.BOLD, 54));
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);

		lblNick = new JLabel("Nick");// ���� ��� �г��� 
		lblNick.setBounds(0, 115, 794, 45);
		panel_over.add(lblNick);
		lblNick.setHorizontalAlignment(SwingConstants.CENTER);
		lblNick.setForeground(Color.BLACK);
		lblNick.setFont(new Font("����", Font.BOLD, 54));

		lblScore = new JLabel("Score"); // ���� ��� ���� 
		lblScore.setBounds(0, 232, 794, 42);
		panel_over.add(lblScore);
		lblScore.setHorizontalAlignment(SwingConstants.CENTER);
		lblScore.setForeground(Color.BLACK);
		lblScore.setFont(new Font("����", Font.BOLD, 54));
		setVisible(true);
		btn_gamestart.addActionListener(this); 
		textField_1.addKeyListener(this); 
		list.addListSelectionListener(this); 
		textField_1.requestFocus();
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		// ���ӽ��� ��ư
		if (e.getSource().equals(btn_gamestart)) {
			// ������ 0 = ������ ��� �ִ°�
			life = 0;
			score.setText("0��"); // ���� ���� �� ������ 0��
			scorenum = 0; // �������� = 0
			// ���࿡ ���Ӱ�� ȭ���� ����� ������ �Ⱥ��̰� ��
			if (panel_over.isVisible()) {
				panel_over.setVisible(false);// ���ȭ��X
			}
			// �ܾ ������� �ִ��� Ȯ��
			if (label[0] != null) {
				for (int i = 0; i < label.length; i++) {
					// �����尡 ���ư��� ������ ����
					if (! new AngelThread().isAlive() || ! new AngelMove().isAlive()) {
						new AngelThread().interrupt();// �ܾ� ������ ����
						new AngelMove().interrupt();// �������� ������ ����
					}
					// �ܾ ������� �ִٸ� �Ⱥ��̰� ��
					if (label[i] != null) {
						label[i].setVisible(false);
					}
				}
			}
			// ���� ���� �� �ؽ�Ʈ�ʵ� ��Ŀ�� �ֱ�
			textField_1.requestFocus();
			// �ܾ �ѷ��ִ� ������ ����
			new AngelThread().start();
		}
	}
	// �ܾ �Է��Ͽ� ���� �ܾ �ִ��� Ȯ��
	@Override
	public void keyPressed(KeyEvent e) {
		if (e.getKeyCode() == KeyEvent.VK_ENTER) {
			// �ؽ�Ʈ �ʵ忡 ���� �ִ��� ������ Ȯ��
			if (!textField_1.getText().equals("")) {
				// String ������ �ؽ�Ʈ �� �ֱ�
				String work_answer = textField_1.getText().toString();
				
				 //�ؽ�Ʈ �Է°��� ������ �ܾ� �ִ��� �˻� ���� �ܾ� ������ �Ⱥ��̰� �ϰ� ���� 5�� �ֱ� ,�ؽ�Ʈ��
				for (int i = 0; i <= label.length; i++) { // ���� �ܾ� �˻�
					try {
						if (work_answer.equals(label[i].getText())) {// ���� �ܾ� �˻�
							if (label[i].isVisible()) { // ���� �ܾ ȭ�鿡 ������ �ִ��� �˻�
								scorenum = scorenum += 10; // ���� +10
								score.setText(scorenum + "��"); // ������ ���� ����
								label[i].setVisible(false);// �ܾ ȭ�鿡�� �Ⱥ��̰�
								textField_1.setText("");// �ؽ�Ʈ �� ���ֱ�
							}
						} else {
							textField_1.setText("");
						}
					} catch (Exception e2) {
						e2.getMessage();
					}
				}
			}
		}
	}
	@Override
	public void keyReleased(KeyEvent e) {
	}
	@Override
	public void keyTyped(KeyEvent e) {
	}
	// �ܾ �ϳ��� �ѷ��ִ� ������
	class AngelThread extends Thread {
		@Override
		public void run() {
			panel_Screen.setVisible(true);// ���� ȭ�� ����
			// �ܾ ������ ���� �ӵ��� ���� ȭ�鿡 x�� �������λ���
			for (i = 0; i <= 10000; i++) {
				try {
					Random random = new Random();// ���� ��ü ����
					label[i] = new JLabel(work[random.nextInt(work.length)]);// �ܾ� ���� ����
					label[i].setBounds(0, 0, 80, 20);// �ܾ� �ʱ� ��ġ ����,�� ����
					panel_Screen.add(label[i]);// �ܾ� �߰�
					label[i].setLocation(random.nextInt(678), 2);// x�� �������� �����ֱ�
					// �ܾ �����̴� ������ ����
					new AngelMove().start();
					Thread.sleep(speed);// ���ӷ����� ���� �ܾ� �ӵ�
					//������ ���� ���� �ܾ �������� �ӵ� ������

				} catch (InterruptedException e) {
					e.printStackTrace();
				}

			}

		}
	}
	// �ܾ� ��������,���ӿ��� Ȯ���ϴ� ������
	class AngelMove extends Thread {
		@Override
		public void run() {
			// �ܾ� ���� ���� ��ŭ for ���� �� �ܾ�� y�� ����
			for (int a = 0; a <= i; a++) {
				if (label[a].isVisible()) {
					int sp = label[a].getY();
					int xp = label[a].getX();
					label[a].setLocation(xp, sp + 10);
				}
				//�ܾ ���� ���� �Ѿ���� Ȯ��
				if (label[a].isVisible() && label[a].getY() > 512) {
					label[a].setVisible(false);// �ܾ ���� ���� ������ �ܾ� �����
					life++;// ������ 1 = ������ 1�� ������
				}
			}

			// ������ Ȯ��
			switch (life) {
			case 0:// ������ ��� ����
				panel_life1.setBackground(Color.GREEN);
				panel_life2.setBackground(Color.GREEN);
				panel_life3.setBackground(Color.GREEN);
				break;

			case 1: // ������ 1�� ������
				panel_life1.setBackground(Color.RED);
				panel_life2.setBackground(Color.GREEN);
				panel_life3.setBackground(Color.GREEN);
				break;

			case 2:// ������ 2�� ������
				panel_life1.setBackground(Color.RED);
				panel_life2.setBackground(Color.RED);
				panel_life3.setBackground(Color.GREEN);
				break;
			case 3:// ������ 3�� �� ������=>���ӿ���
				panel_life1.setBackground(Color.RED);
				panel_life2.setBackground(Color.RED);
				panel_life3.setBackground(Color.RED);
				// ���� ���ȭ�� ����
				panel_Screen.setVisible(false);
				panel_over.setVisible(true);
				lblScore.setText(score.getText());
				lblNick.setText(NickName);
				// ������ ����
				new AngelThread().interrupt();
				new AngelMove().interrupt();
				break;
			default:
				break;
			}
		}
	}

	//Main ��� 
	public void setAngelMain(AngelMain main) {
		this.main = main;
	}

	// ���� ����Ʈ �̺�Ʈ ó��
	@Override
	public void valueChanged(ListSelectionEvent arg0) {
		String str;
		if (arg0.getSource() == list) {
			switch (list.getSelectedIndex()) {
			case 0:
				speed = 3500;// ���Ӽӵ�
				str = (String) list.getSelectedValue();// ����Ʈ �̸� ����
				level.setText(str); // ���� �󺧿� �����ֱ�
				break;
			case 1:
				speed = 2900;// ���Ӽӵ�
				str = (String) list.getSelectedValue();// ����Ʈ �̸� ����
				level.setText(str);// ���� �󺧿� �����ֱ�
				break;
			case 2:
				speed = 2600;// ���Ӽӵ�
				str = (String) list.getSelectedValue();// ����Ʈ �̸� ����
				level.setText(str);// ���� �󺧿� �����ֱ�
				break;
			case 3:
				speed = 2300;// ���Ӽӵ�
				str = (String) list.getSelectedValue();// ����Ʈ �̸� ����
				level.setText(str);// ���� �󺧿� �����ֱ�
				break;
			case 4:
				speed = 1900;// ���Ӽӵ�
				str = (String) list.getSelectedValue();// ����Ʈ �̸� ����
				level.setText(str);// ���� �󺧿� �����ֱ�
				break;
			case 5:
				speed = 1600;// ���Ӽӵ�
				str = (String) list.getSelectedValue();// ����Ʈ �̸� ����
				level.setText(str);// ���� �󺧿� �����ֱ�
				break;
			case 6:
				speed = 1300;// ���Ӽӵ�
				str = (String) list.getSelectedValue();// ����Ʈ �̸� ����
				level.setText(str);// ���� �󺧿� �����ֱ�
				break;
			case 7:
				speed = 1000;// ���Ӽӵ�
				str = (String) list.getSelectedValue();// ����Ʈ �̸� ����
				level.setText(str);// ���� �󺧿� �����ֱ�
				break;
			case 8:
				speed = 800;// ���Ӽӵ�
				str = (String) list.getSelectedValue();// ����Ʈ �̸� ����
				level.setText(str);// ���� �󺧿� �����ֱ�
				break;
			case 9:
				speed = 400;// ���Ӽӵ�
				str = (String) list.getSelectedValue();// ����Ʈ �̸� ����
				level.setText(str);// ���� �󺧿� �����ֱ�
				break;
			default:
				break;
			}
		}
	}
}