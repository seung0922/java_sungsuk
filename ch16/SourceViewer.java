package ch16;

import java.net.*;
import java.io.*;
import java.awt.*;
import java.awt.event.*;

// TextField�� URL�� �Է��ϰ� EnterŰ�� ������ �ش� �������� �ҽ��� �����ִ� 'Source Viewer'���α׷�


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
				// ��� �Ȱ��� �ٿ��� line�� ������ �������ٸ� ���Ե�...
				// ��� ��ü �� ������ �ұ� => setText()�� �ƴ϶� append() �ؾ���!
				ta.append(line);
				ta.append("\n");
			}
			
			input.close();
			
		} catch (Exception e) {
			ta.setText("��ȿ���� ���� URL�Դϴ�.");
		}
	} // displaySource()

	public static void main(String[] args) {
		SourceViewer mainWin = new SourceViewer("Source Viewer");
	}
}