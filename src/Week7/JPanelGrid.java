package Week7;
import java.awt.Dimension;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.*;

@SuppressWarnings("serial")
public class JPanelGrid extends JPanel {
	
	static int locationx;
	static int locationy;

    public static void main(String[] args) {
    	JFrame frame = new JFrame();
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        JPanel buttonPanel = new JPanel();
        JPanel containerPanel = new JPanel();
        buttonPanel.setLayout(new GridLayout(8,8));
        for(int i = 0; i < 8; i ++) {
        	for(int k  = 0; k < 8; k ++) {
        		JButton currentButton = new JButton(i + " " + k);
        		locationx = i;
        		locationy = k;
        		currentButton.setPreferredSize(new Dimension(60, 60));
        		currentButton.setName(i + " " + k);
        		currentButton.addActionListener(new ActionListener() { 
					@Override
					public void actionPerformed(ActionEvent e) {
						JButton button = (JButton) e.getSource();
						System.out.println(button.getName());
					} 
        		});
        		buttonPanel.add(currentButton);
        	}
        }
        buttonPanel.setPreferredSize(new Dimension(600, 600));
        containerPanel.add(buttonPanel);

        frame.getContentPane().add(containerPanel);
        frame.pack();
        frame.setVisible(true);
    }
}