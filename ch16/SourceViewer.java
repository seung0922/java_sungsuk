package ch16;

import java.net.*;
import java.io.*;
import java.awt.*;
import java.awt.event.*;

// TextField에 URL을 입력하고 Enter키를 누르면 해당 페이지의 소스를 보여주는 'Source Viewer'프로그램


class SourceViewer extends Frame {
	TextField tf = new TextField();
	TextArea ta = new TextArea();

	SourceViewer(String title) {
		super(title);
		add(tf, "North");
		add(ta, "Center");
		tf.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent ae) {
				displaySource();
			}
		});
		addWindowListener(new WindowAdapter() {
			public void windowClosing(WindowEvent we) {
				System.exit(0);
			}
		});
		setBounds(500, 200, 500, 300);
		setVisible(true);
	}

	void displaySource() {
		URL url = null;
		BufferedReader input = null;
		String address = tf.getText().trim();
		String line = "";
		ta.setText("");
		
		try {
			if (!address.startsWith("http://"))
				address = "http://" + address;
			
			url = new URL(address);
			input = new BufferedReader(new InputStreamReader(url.openStream()));
			
			while((line = input.readLine()) != null) {
				// 계속 똑같은 줄에만 line이 써져서 마지막줄만 남게됨...
				// 어떻게 전체 다 써지게 할까 => setText()가 아니라 append() 해야함!
				ta.append(line);
				ta.append("\n");
			}
			
			input.close();
			
		} catch (Exception e) {
			ta.setText("유효하지 않은 URL입니다.");
		}
	} // displaySource()

	public static void main(String[] args) {
		SourceViewer mainWin = new SourceViewer("Source Viewer");
	}
}