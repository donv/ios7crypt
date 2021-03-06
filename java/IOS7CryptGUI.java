import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

public class IOS7CryptGUI extends JPanel implements ActionListener {
	JLabel passwordLabel;
	JTextField passwordField;
	JLabel hashLabel;
	JTextField hashField;

	public IOS7CryptGUI() {
		super(new BorderLayout());

		passwordLabel=new JLabel("Password");
		passwordLabel.setBorder(BorderFactory.createEmptyBorder(5, 5, 5, 5));
		passwordField=new JTextField("", 10);
		passwordLabel.setLabelFor(passwordField);
		passwordField.addActionListener(this);

		hashLabel=new JLabel("Hash");
		hashLabel.setBorder(BorderFactory.createEmptyBorder(5, 5, 5, 5));
		hashField=new JTextField("", 10);
		hashLabel.setLabelFor(hashField);
		hashField.addActionListener(this);

		JPanel passwordPanel=new JPanel(new BorderLayout());
		passwordPanel.setBorder(BorderFactory.createEmptyBorder(5, 5, 5, 5));
		passwordPanel.add(passwordLabel, BorderLayout.WEST);
		passwordPanel.add(passwordField, BorderLayout.EAST);

		JPanel hashPanel=new JPanel(new BorderLayout());
		hashPanel.setBorder(BorderFactory.createEmptyBorder(5, 5, 5, 5));
		hashPanel.add(hashLabel, BorderLayout.WEST);
		hashPanel.add(hashField, BorderLayout.EAST);

		add(passwordPanel, BorderLayout.NORTH);
		add(hashPanel, BorderLayout.SOUTH);
	}

	public void actionPerformed(ActionEvent e) {
		if (e.getSource()==passwordField) {
			hashField.setText(IOS7Crypt.encrypt(passwordField.getText()));
		}
		else if (e.getSource()==hashField) {
			passwordField.setText(IOS7Crypt.decrypt(hashField.getText()));
		}
	}

	public static void main(String[] args) {
		JFrame.setDefaultLookAndFeelDecorated(true);
		JDialog.setDefaultLookAndFeelDecorated(true);

		JFrame frame=new JFrame("IOS7Crypt");
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setResizable(false);
		frame.setContentPane(new IOS7CryptGUI());

		frame.pack();
		Windows.centerOnScreen(frame);
		frame.setVisible(true);
	}
}