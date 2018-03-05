package upload;

import java.awt.EventQueue;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;

import javax.swing.JButton;
import javax.swing.JFileChooser;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;

@SuppressWarnings("serial")
public class UploadImage extends JFrame {

	private JPanel contentPane;
	private JButton find, load, cancel;
	private JTextField text;
	File arquivo;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					UploadImage frame = new UploadImage();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public UploadImage() {
		
		contentPane = new JPanel();
		contentPane.setLayout(null);
		JLabel info = new JLabel("Image:");
		text = new JTextField();
		find = new JButton("Find");
		load = new JButton("Load");
		cancel = new JButton("Cancel");
		
		info.setLocation(20, 20);
		info.setSize(50, 20);
		text.setLocation(80, 20);
		text.setSize(220,20);
		find.setLocation(330, 20);
		find.setSize(80,20);
		load.setLocation(120,100);
		load.setSize(80,20);
		cancel.setLocation(220,100);
		cancel.setSize(80,20);
		
		contentPane.add(cancel);
		contentPane.add(load);
		contentPane.add(find);
		contentPane.add(text);
		contentPane.add(info);
		
		JButtonHandler handler = new JButtonHandler();
		find.addActionListener(handler);
		load.addActionListener(handler);
		cancel.addActionListener(handler);
		
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		setContentPane(contentPane);
		
		
	}
	
	private class JButtonHandler implements ActionListener {

		@Override
		public void actionPerformed(ActionEvent e) {
			// TODO Auto-generated method stub
			
			if (e.getSource() == find) {
				JFileChooser file = new JFileChooser(); 
		        file.setFileSelectionMode(JFileChooser.FILES_ONLY);
		        int i= file.showSaveDialog(null);
		        if (i==1){
		           text.setText("");
		        } else {
		           arquivo = file.getSelectedFile();
		           text.setText(arquivo.getPath());
		        }
			}
			
			if (e.getSource() == load) {
				DetectionFace image = new DetectionFace(arquivo);
				image.setFile(arquivo);
		        JOptionPane.showMessageDialog(null,"Imagem Carregada!");

			}
			
			if (e.getSource() == cancel) {
				System.exit(0);			
			}
		}
		
	}
}
