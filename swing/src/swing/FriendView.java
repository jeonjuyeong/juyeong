package swing;


import java.awt.EventQueue;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JSplitPane;
import java.awt.Dimension;
import java.awt.Panel;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.JButton;

import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.awt.event.ActionEvent;
import javax.swing.JTextArea;
import java.awt.Color;
import java.awt.Font;
import javax.swing.border.LineBorder;
import javax.swing.border.TitledBorder;

import javax.swing.JComboBox;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JScrollPane;

public class FriendView extends JFrame {

	private JPanel contentPane;
	private JSplitPane splitPane;
	private Panel panel;
	private JLabel label;
	private JTextField tfName;
	private JLabel label_1;
	private JLabel label_2;
	private JLabel lblNewLabel;
	private JTextField tfBirth;
	private JTextField tfPhone;
	private JTextField tfAddr;
	private JButton viewBtn;
	private JButton inBtn;
	private JSplitPane splitPane_1;
	private JTextArea taView;
	private JPanel panel_1;
	private JComboBox comSel;
	private JTextField taSearch;
	private JButton btnSearch;
	FriendDBAImpl dba = new FriendDBAImpl();
	
	
	Friend f = new Friend();
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					FriendView frame = new FriendView();
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
	public FriendView() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 758, 535);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		contentPane.add(getSplitPane());
	}

	private JSplitPane getSplitPane() {
		if (splitPane == null) {
			splitPane = new JSplitPane();
			splitPane.setDividerSize(3);
			splitPane.setLocation(5, 5);
			splitPane.setBorder(new TitledBorder(null, "\uCE5C\uAD6C\uB4F1\uB85D", TitledBorder.LEADING, TitledBorder.TOP, null, null));
			splitPane.setSize(new Dimension(731, 500));
			splitPane.setLeftComponent(getPanel());
			splitPane.setRightComponent(getSplitPane_1());
			splitPane.setDividerLocation(360);
		}
		return splitPane;
	}
	private Panel getPanel() {
		if (panel == null) {
			panel = new Panel();
			panel.setBackground(new Color(210, 180, 140));
			panel.setLayout(null);
			panel.add(getLabel());
			panel.add(getTfName());
			panel.add(getLabel_1());
			panel.add(getLabel_2());
			panel.add(getLblNewLabel());
			panel.add(getTfBirth());
			panel.add(getTfPhone());
			panel.add(getTfAddr());
			panel.add(getViewBtn());
			panel.add(getInBtn());
		}
		return panel;
	}
	private JLabel getLabel() {
		if (label == null) {
			label = new JLabel("\uC774\uB984");
			label.setFont(new Font("?‚˜?ˆ”ë°”ë¥¸?Žœ", Font.BOLD, 18));
			label.setBounds(35, 76, 57, 18);
		}
		return label;
	}
	private JTextField getTfName() {
		if (tfName == null) {
			tfName = new JTextField();
			tfName.setBounds(104, 76, 183, 21);
			tfName.setColumns(10);
		}
		return tfName;
	}
	private JLabel getLabel_1() {
		if (label_1 == null) {
			label_1 = new JLabel("\uC0DD\uC77C");
			label_1.setFont(new Font("?‚˜?ˆ”ë°”ë¥¸?Žœ", Font.BOLD, 18));
			label_1.setBounds(35, 125, 57, 18);
		}
		return label_1;
	}
	private JLabel getLabel_2() {
		if (label_2 == null) {
			label_2 = new JLabel("\uC804\uD654\uBC88\uD638");
			label_2.setFont(new Font("?‚˜?ˆ”ë°”ë¥¸?Žœ", Font.BOLD, 18));
			label_2.setBounds(35, 180, 57, 18);
		}
		return label_2;
	}
	private JLabel getLblNewLabel() {
		if (lblNewLabel == null) {
			lblNewLabel = new JLabel("\uC8FC\uC18C");
			lblNewLabel.setFont(new Font("?‚˜?ˆ”ë°”ë¥¸?Žœ", Font.BOLD, 18));
			lblNewLabel.setBounds(35, 237, 57, 21);
		}
		return lblNewLabel;
	}
	private JTextField getTfBirth() {
		if (tfBirth == null) {
			tfBirth = new JTextField();
			tfBirth.setBounds(104, 125, 183, 21);
			tfBirth.setColumns(10);
		}
		return tfBirth;
	}
	private JTextField getTfPhone() {
		if (tfPhone == null) {
			tfPhone = new JTextField();
			tfPhone.setBounds(104, 180, 183, 21);
			tfPhone.setColumns(10);
		}
		return tfPhone;
	}
	private JTextField getTfAddr() {
		if (tfAddr == null) {
			tfAddr = new JTextField();
			tfAddr.setBounds(104, 237, 183, 21);
			tfAddr.setColumns(10);
		}
		return tfAddr;
	}
	private JButton getViewBtn() {
		if (viewBtn == null) {
			viewBtn = new JButton("\uC804\uCCB4\uBCF4\uAE30\r\n");
			viewBtn.setFont(new Font("?‚˜?ˆ”ë°”ë¥¸?Žœ", Font.BOLD, 18));
			viewBtn.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					 ArrayList<Friend> arr = dba.friendView();
			
					for(Friend f : arr) {
					taView.setText("¹øÈ£:" +f.getNum()+"\n"
											+"ÀÌ¸§:" +f.getName()+"\n"
											+"»ýÀÏ:"	+f.getBirth()+"\n"
											+"ÀüÈ­¹øÈ£:" +f.getPhone()+"\n"
											+"ÁÖ¼Ò:" +f.getAddr()+"\n------------------\n");
					}
					
				}
			});
			viewBtn.setBounds(35, 331, 120, 23);
		}
		return viewBtn;
	}
	private JButton getInBtn() {
		if (inBtn == null) {
			inBtn = new JButton("\uC800\uC7A5");
			inBtn.setFont(new Font("?‚˜?ˆ”ë°”ë¥¸?Žœ", Font.BOLD, 18));
			inBtn.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					Friend f = new Friend();
					   f.setName(tfName.getText());	     
			            f.setBirth(tfBirth.getText());
			            f.setPhone(tfPhone.getText());
			            f.setAddr(tfAddr.getText());
			    
					dba.friendInsert(f);
				}
			});
			inBtn.setBounds(190, 331, 112, 23);
		}
		return inBtn;
	}
	private JSplitPane getSplitPane_1() {
		if (splitPane_1 == null) {
			splitPane_1 = new JSplitPane();
			splitPane_1.setDividerSize(3);
			splitPane_1.setOrientation(JSplitPane.VERTICAL_SPLIT);
			splitPane_1.setLeftComponent(getTaView());
			splitPane_1.setRightComponent(getPanel_1());
			splitPane_1.setDividerLocation(300);
		}
		return splitPane_1;
	}
	private JTextArea getTaView() {
		if (taView == null) {
			taView = new JTextArea();
			taView.setBorder(new TitledBorder(new LineBorder(new Color(139, 69, 19), 2), "\uC804\uCCB4\uBCF4\uAE30", TitledBorder.LEFT, TitledBorder.TOP, null, new Color(139, 69, 19)));
		}
		return taView;
	}
	private JPanel getPanel_1() {
		if (panel_1 == null) {
			panel_1 = new JPanel();
			panel_1.setBackground(new Color(255, 222, 173));
			panel_1.setLayout(null);
			panel_1.add(getComSel());
			panel_1.add(getTaSearch());
			panel_1.add(getBtnSearch());
		}
		return panel_1;
	}
	private JComboBox getComSel() {
		if (comSel == null) {
			comSel = new JComboBox();
			comSel.setModel(new DefaultComboBoxModel(new String[] {"\uC120\uD0DD", "\uC774\uB984", "\uC0DD\uC77C", "\uC804\uD654", "\uC8FC\uC18C"}));
			comSel.setBounds(26, 76, 70, 21);
		}
		return comSel;
	}
	private JTextField getTaSearch() {
		if (taSearch == null) {
			taSearch = new JTextField();
			taSearch.setBounds(111, 76, 116, 21);
			taSearch.setColumns(10);
		}
		return taSearch;
	}
	private JButton getBtnSearch() {
		if (btnSearch == null) {
			btnSearch = new JButton("\uBCF4\uAE30");
			btnSearch.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					String key="";
					int index = comSel.getSelectedIndex();
					 if(index==1) key = "name";
				      else if(index==2) key = "birth"; 
				      else if(index==3) key = "phone"; 
				      else if(index==4) key = "Addr"; 
				      else if(index==0) {taView.append("\n");
				      								return;}
					String search = taSearch.getText();
					 ArrayList<Friend> arr =	dba.friendSearch(key, search);				
						for(Friend f : arr) {
						taView.append("¹øÈ£:" +f.getNum()+"\n"
												+"ÀÌ¸§:" +f.getName()+"\n"
												+"»ýÀÏ:"	+f.getBirth()+"\n"
												+"ÀüÈ­¹øÈ£:" +f.getPhone()+"\n"
												+"ÁÖ¼Ò:" +f.getAddr()+"\n----------------\n");
						}	
				}
			});
			btnSearch.setBounds(239, 75, 97, 23);
		}
		return btnSearch;
	}
}
