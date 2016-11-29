package controler;
import java.awt.Frame;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;

public class TitleScreen extends JFrame {

	private JPanel contentPane;
	private JTextField txtAngry;
	private JButton btnScores;

	

	/**
	 * Create the frame.
	 */
	public TitleScreen() {
		init();
	}
	
	public void init() {
		addToPanel();
	}
	
	public void addToPanel() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(0, 0, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		txtAngry = new JTextField();
		txtAngry.setText("Oiseaux pas contents");
		txtAngry.setBounds(150, 26, 141, 19);
		contentPane.add(txtAngry);
		txtAngry.setColumns(10);
		
		JButton btnPlay = new JButton("Play");
		btnPlay.setBounds(76, 118, 117, 25);
		contentPane.add(btnPlay);
		btnPlay.addMouseListener(new MouseListener() {
			
			@Override
			public void mouseReleased(MouseEvent e) {}
			
			@Override
			public void mousePressed(MouseEvent e) {
				Frame frame = new Frame("Oiseau pas content");
		        final AngryBirds obj = new AngryBirds();
		        frame.addWindowListener(new WindowAdapter() {
		            public void windowClosing(WindowEvent event) {
		                System.exit(0);
		            }
		        });
		        frame.add(obj);
		        frame.pack();
		        frame.setVisible(true);
			}
			
			@Override
			public void mouseExited(MouseEvent e) {}
			
			@Override
			public void mouseEntered(MouseEvent e) {}
			
			@Override
			public void mouseClicked(MouseEvent e) {}
		});
		
		JButton btnHelp = new JButton("Help");
		btnHelp.setBounds(267, 118, 117, 25);
		contentPane.add(btnHelp);
		
		btnScores = new JButton("Scores");
		btnScores.setBounds(174, 159, 117, 25);
		contentPane.add(btnScores);
		btnScores.addMouseListener(new MouseListener() {
			
			@Override
			public void mouseReleased(MouseEvent e) {}
			
			@Override
			public void mousePressed(MouseEvent e) {
				ControlerScores scores = new ControlerScores();
				scores.setVisible(true);
			}
			
			@Override
			public void mouseExited(MouseEvent e) {}
			
			@Override
			public void mouseEntered(MouseEvent e) {}
			
			@Override
			public void mouseClicked(MouseEvent e) {}
		});
	}
	
}
