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
	private String[] work = {"한성대","송수진","상상부기","컴퓨터","컴퓨터 공학","객체지향언어","상상관","상상파크","미래관","공학관",
			"우촌관","그라찌에","상상빌리지","이클립스","자바","거북이","노트북","한성대학교","사랑해","스마트폰","바나나","딸기","복숭아","멜론",
			"망고","휴대폰","고구마","감자","순대국","피자","파스타","낙산공원","혜화","대학로","한성대입구","지하철","버스","비행기","제주도",
			"김치볶음밥","빅톤","코다차야","소주","칵테일","녹차라떼","초코라떼","갤럭시","삼성","네이버","구글","카카오","다음","부산","미국",
			"솔로지옥","코딩","자바스크립트","호주","영국","캐나다","미역국","레몬에이드","우유","초콜릿","계란찜","닭발","곱창","막창","대창",
			"삼겹살","물냉면","비빔냉면","구운계란","뚝섬","성수","건대입구","한양대","왕십리","크리스마스","설날","추석","떡국","족발","보쌈",
			"기차","비빔밥","막국수","메밀전병","김치전","부침개","막걸리","베스킨라빈스","서브웨이","키위","순대","떡볶이","오뎅","김말이","튀김",
			"호떡","붕어빵","감자튀김","햄버거","닭갈비","칼국수","산낙지","짜장면","짬뽕","볶음밥","롯데월드","에버랜드","히피펌","닭꼬치","닭강정",
			"넷플릭스","티빙","런닝맨","왓챠","카카오톡","인스타그램","페이스북","자이로드롭","롤러코스터","고래","노래방","오락실","보드게임","카페",
			"포장마차","남자친구","코트","멘투맨","청바지","반바지","치마","원피스","양말","신발","운동화","구두","슬리퍼","신발끈","아디다스","모자","발라드",
			"기타","피아노","드럼","호텔","여행","밀면","만두","빵","우산","떡","두끼","대포찜닭","델리만쥬","치즈","행복","사랑","마음","시월이","사람","동물",
			"돌","바위","흙","하늘","호랑이","사자","지렁이","무","버섯","메밀전병","파전","낙곱새","팽이","공기","산소","이산화탄소","질소","수소","용가리","뿌링클"};
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
		NickName = Nick;// 닉네임 변수 저장
		setSize(1200, 800);
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		getContentPane().setLayout(null);

		textField_1 = new JTextField();// 단어 입력
		textField_1.setBounds(115, 631, 267, 38);
		getContentPane().add(textField_1);
		textField_1.setColumns(10);

		list = new JList(game_LEVEL);// 레벨 리스트 보여주기
		list.setSelectedIndex(0);
		list.setFont(new Font("굴림", Font.BOLD, 22));
		list.setBounds(986, 44, 162, 280);
		getContentPane().add(list);

		btn_gamestart = new JButton("시작");// 시작 버튼
		btn_gamestart.setFont(new Font("굴림", Font.BOLD, 23));
		btn_gamestart.setBounds(497, 627, 105, 38);
		getContentPane().add(btn_gamestart);

		// 게임화면
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

		JPanel panel_1 = new JPanel(); // 게임화면에서 빨간색 선
		panel_1.setBackground(Color.RED);
		panel_1.setBounds(0, 520, 740, 10);
		panel_Screen.add(panel_1);

		score = new JLabel("0점");// 점수판
		score.setHorizontalAlignment(SwingConstants.CENTER);
		score.setFont(new Font("굴림", Font.BOLD, 25));
		score.setBounds(823, 241, 149, 45);
		getContentPane().add(score);

		Label_nickname = new JLabel(Nick); //닉네임 
		Label_nickname.setHorizontalAlignment(SwingConstants.CENTER);
		Label_nickname.setFont(new Font("굴림", Font.BOLD, 25));
		Label_nickname.setForeground(Color.BLUE);
		Label_nickname.setBounds(823, 71, 149, 27);
		getContentPane().add(Label_nickname);

		level = new JLabel("level 1"); //레벨 리스트
		level.setHorizontalAlignment(SwingConstants.CENTER);
		level.setFont(new Font("굴림", Font.BOLD, 24));
		level.setBounds(846, 142, 99, 42);
		getContentPane().add(level);

		panel_life1 = new JPanel(); // 생명1
		panel_life1.setBackground(Color.GREEN);
		panel_life1.setBounds(824, 319, 26, 27);
		getContentPane().add(panel_life1);

		panel_life2 = new JPanel();// 생명2
		panel_life2.setBackground(Color.GREEN);
		panel_life2.setBounds(864, 319, 26, 27);
		getContentPane().add(panel_life2);

		panel_life3 = new JPanel(); // 생명3
		panel_life3.setBackground(Color.GREEN);
		panel_life3.setBounds(904, 319, 26, 27);
		getContentPane().add(panel_life3);

		// 게임 결과 화면
		panel_over = new JPanel();// 게임 결과 배경
		panel_over.setBackground(Color.YELLOW);
		panel_over.setBounds(14, 142, 794, 286);
		panel_over.setVisible(false);
		getContentPane().add(panel_over);
		panel_over.setLayout(null);

		lblNewLabel = new JLabel("Game Over"); // 게임 오버 라벨 
		lblNewLabel.setBounds(0, 36, 794, 63);
		panel_over.add(lblNewLabel);
		lblNewLabel.setForeground(Color.RED);
		lblNewLabel.setFont(new Font("굴림", Font.BOLD, 54));
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);

		lblNick = new JLabel("Nick");// 게임 결과 닉네임 
		lblNick.setBounds(0, 115, 794, 45);
		panel_over.add(lblNick);
		lblNick.setHorizontalAlignment(SwingConstants.CENTER);
		lblNick.setForeground(Color.BLACK);
		lblNick.setFont(new Font("굴림", Font.BOLD, 54));

		lblScore = new JLabel("Score"); // 게임 결과 점수 
		lblScore.setBounds(0, 232, 794, 42);
		panel_over.add(lblScore);
		lblScore.setHorizontalAlignment(SwingConstants.CENTER);
		lblScore.setForeground(Color.BLACK);
		lblScore.setFont(new Font("굴림", Font.BOLD, 54));
		setVisible(true);
		btn_gamestart.addActionListener(this); 
		textField_1.addKeyListener(this); 
		list.addListSelectionListener(this); 
		textField_1.requestFocus();
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		// 게임시작 버튼
		if (e.getSource().equals(btn_gamestart)) {
			// 라이프 0 = 생명이 모두 있는것
			life = 0;
			score.setText("0점"); // 게임 시작 시 점수판 0점
			scorenum = 0; // 게임점수 = 0
			// 만약에 게임결과 화면이 띄어져 있으면 안보이게 함
			if (panel_over.isVisible()) {
				panel_over.setVisible(false);// 결과화면X
			}
			// 단어가 만들어져 있는지 확인
			if (label[0] != null) {
				for (int i = 0; i < label.length; i++) {
					// 스레드가 돌아가고 있으면 중지
					if (! new AngelThread().isAlive() || ! new AngelMove().isAlive()) {
						new AngelThread().interrupt();// 단어 스레드 중지
						new AngelMove().interrupt();// 내려가는 스레드 중지
					}
					// 단어가 만들어져 있다면 안보이게 함
					if (label[i] != null) {
						label[i].setVisible(false);
					}
				}
			}
			// 게임 시작 시 텍스트필드 포커스 주기
			textField_1.requestFocus();
			// 단어를 뿌려주는 스레드 실행
			new AngelThread().start();
		}
	}
	// 단어를 입력하여 동일 단어가 있는지 확인
	@Override
	public void keyPressed(KeyEvent e) {
		if (e.getKeyCode() == KeyEvent.VK_ENTER) {
			// 텍스트 필드에 값이 있는지 없는지 확인
			if (!textField_1.getText().equals("")) {
				// String 변수에 텍스트 값 주기
				String work_answer = textField_1.getText().toString();
				
				 //텍스트 입력값과 동일한 단어 있는지 검사 동일 단어 있을시 안보이게 하고 점수 5점 주기 ,텍스트값
				for (int i = 0; i <= label.length; i++) { // 동일 단어 검사
					try {
						if (work_answer.equals(label[i].getText())) {// 동일 단어 검사
							if (label[i].isVisible()) { // 동일 단어가 화면에 보여져 있는지 검사
								scorenum = scorenum += 10; // 점수 +10
								score.setText(scorenum + "점"); // 점수판 점수 변경
								label[i].setVisible(false);// 단어가 화면에서 안보이게
								textField_1.setText("");// 텍스트 값 없애기
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
	// 단어를 하나씩 뿌려주는 스레드
	class AngelThread extends Thread {
		@Override
		public void run() {
			panel_Screen.setVisible(true);// 게임 화면 등장
			// 단어를 레벨에 따른 속도로 게임 화면에 x값 랜덤으로생성
			for (i = 0; i <= 10000; i++) {
				try {
					Random random = new Random();// 랜덤 객체 생성
					label[i] = new JLabel(work[random.nextInt(work.length)]);// 단어 랜덤 생성
					label[i].setBounds(0, 0, 80, 20);// 단어 초기 위치 높이,폭 설정
					panel_Screen.add(label[i]);// 단어 추가
					label[i].setLocation(random.nextInt(678), 2);// x값 랜덤으로 보여주기
					// 단어를 움직이는 스레드 실행
					new AngelMove().start();
					Thread.sleep(speed);// 게임레벨에 따른 단어 속도
					//레벨이 높을 수록 단어가 떨어지는 속도 빨라짐

				} catch (InterruptedException e) {
					e.printStackTrace();
				}

			}

		}
	}
	// 단어 내려가고,게임오버 확인하는 스레드
	class AngelMove extends Thread {
		@Override
		public void run() {
			// 단어 생성 갯수 만큼 for 돌려 각 단어마다 y값 변경
			for (int a = 0; a <= i; a++) {
				if (label[a].isVisible()) {
					int sp = label[a].getY();
					int xp = label[a].getX();
					label[a].setLocation(xp, sp + 10);
				}
				//단어가 빨간 선을 넘어갔는지 확인
				if (label[a].isVisible() && label[a].getY() > 512) {
					label[a].setVisible(false);// 단어가 빨간 선을 넘으면 단어 사라짐
					life++;// 라이프 1 = 생명이 1개 없어짐
				}
			}

			// 라이프 확인
			switch (life) {
			case 0:// 생명이 모두 있음
				panel_life1.setBackground(Color.GREEN);
				panel_life2.setBackground(Color.GREEN);
				panel_life3.setBackground(Color.GREEN);
				break;

			case 1: // 생명이 1개 없어짐
				panel_life1.setBackground(Color.RED);
				panel_life2.setBackground(Color.GREEN);
				panel_life3.setBackground(Color.GREEN);
				break;

			case 2:// 생명이 2개 없어짐
				panel_life1.setBackground(Color.RED);
				panel_life2.setBackground(Color.RED);
				panel_life3.setBackground(Color.GREEN);
				break;
			case 3:// 생명이 3개 다 없어짐=>게임오버
				panel_life1.setBackground(Color.RED);
				panel_life2.setBackground(Color.RED);
				panel_life3.setBackground(Color.RED);
				// 게임 결과화면 띄우기
				panel_Screen.setVisible(false);
				panel_over.setVisible(true);
				lblScore.setText(score.getText());
				lblNick.setText(NickName);
				// 스레드 중지
				new AngelThread().interrupt();
				new AngelMove().interrupt();
				break;
			default:
				break;
			}
		}
	}

	//Main 등록 
	public void setAngelMain(AngelMain main) {
		this.main = main;
	}

	// 레벨 리스트 이벤트 처리
	@Override
	public void valueChanged(ListSelectionEvent arg0) {
		String str;
		if (arg0.getSource() == list) {
			switch (list.getSelectedIndex()) {
			case 0:
				speed = 3500;// 게임속도
				str = (String) list.getSelectedValue();// 리스트 이름 저장
				level.setText(str); // 레벨 라벨에 보여주기
				break;
			case 1:
				speed = 2900;// 게임속도
				str = (String) list.getSelectedValue();// 리스트 이름 저장
				level.setText(str);// 레벨 라벨에 보여주기
				break;
			case 2:
				speed = 2600;// 게임속도
				str = (String) list.getSelectedValue();// 리스트 이름 저장
				level.setText(str);// 레벨 라벨에 보여주기
				break;
			case 3:
				speed = 2300;// 게임속도
				str = (String) list.getSelectedValue();// 리스트 이름 저장
				level.setText(str);// 레벨 라벨에 보여주기
				break;
			case 4:
				speed = 1900;// 게임속도
				str = (String) list.getSelectedValue();// 리스트 이름 저장
				level.setText(str);// 레벨 라벨에 보여주기
				break;
			case 5:
				speed = 1600;// 게임속도
				str = (String) list.getSelectedValue();// 리스트 이름 저장
				level.setText(str);// 레벨 라벨에 보여주기
				break;
			case 6:
				speed = 1300;// 게임속도
				str = (String) list.getSelectedValue();// 리스트 이름 저장
				level.setText(str);// 레벨 라벨에 보여주기
				break;
			case 7:
				speed = 1000;// 게임속도
				str = (String) list.getSelectedValue();// 리스트 이름 저장
				level.setText(str);// 레벨 라벨에 보여주기
				break;
			case 8:
				speed = 800;// 게임속도
				str = (String) list.getSelectedValue();// 리스트 이름 저장
				level.setText(str);// 레벨 라벨에 보여주기
				break;
			case 9:
				speed = 400;// 게임속도
				str = (String) list.getSelectedValue();// 리스트 이름 저장
				level.setText(str);// 레벨 라벨에 보여주기
				break;
			default:
				break;
			}
		}
	}
}