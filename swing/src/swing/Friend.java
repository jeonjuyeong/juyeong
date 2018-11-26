package swing;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;



import javax.swing.JSplitPane;
import javax.swing.JTextField;
import javax.swing.JLabel;
import javax.swing.JButton;
import javax.swing.JTextArea;
import javax.swing.JComboBox;
import javax.swing.DefaultComboBoxModel;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.awt.event.ActionEvent;

public class Friend extends JFrame {

	private JPanel contentPane;
	private JSplitPane splitPane;
	private JPanel panel;
	private JTextField tfName;
	private JTextField tfBirth;
	private JTextField tfPhone;
	private JTextField tfAddr;
	private JLabel label;
	private JLabel label_1;
	private JLabel label_2;
	private JLabel label_3;
	private JButton btnView;
	private JButton button;
	private JPanel panel_1;
	private JTextArea taView;
	private JButton btnNewButton;
	private JTextField tfSearch;
	private JComboBox cb;
	FriendDB db = new FriendDB();
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Friend frame = new Friend();
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
	public Friend() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 695, 438);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		contentPane.setLayout(new BorderLayout(0, 0));
		setContentPane(contentPane);
		contentPane.add(getSplitPane(), BorderLayout.CENTER);
	}

	private JSplitPane getSplitPane() {
		if (splitPane == null) {
			splitPane = new JSplitPane();
			splitPane.setLeftComponent(getPanel());
			splitPane.setRightComponent(getPanel_1());
			splitPane.setDividerLocation(300);
		}
		return splitPane;
	}
	private JPanel getPanel() {
		if (panel == null) {
			panel = new JPanel();
			panel.setLayout(null);
			panel.add(getTfName());
			panel.add(getTfBirth());
			panel.add(getTfPhone());
			panel.add(getTfAddr());
			panel.add(getLabel());
			panel.add(getLabel_1());
			panel.add(getLabel_2());
			panel.add(getLabel_3());
			panel.add(getBtnView());
			panel.add(getButton());
		}
		return panel;
	}
	private JTextField getTfName() {
		if (tfName == null) {
			tfName = new JTextField();
			tfName.setBounds(111, 42, 116, 21);
			tfName.setColumns(10);
		}
		return tfName;
	}
	private JTextField getTfBirth() {
		if (tfBirth == null) {
			tfBirth = new JTextField();
			tfBirth.setColumns(10);
			tfBirth.setBounds(111, 85, 116, 21);
		}
		return tfBirth;
	}
	private JTextField getTfPhone() {
		if (tfPhone == null) {
			tfPhone = new JTextField();
			tfPhone.setColumns(10);
			tfPhone.setBounds(111, 128, 116, 21);
		}
		return tfPhone;
	}
	private JTextField getTfAddr() {
		if (tfAddr == null) {
			tfAddr = new JTextField();
			tfAddr.setColumns(10);
			tfAddr.setBounds(111, 171, 116, 21);
		}
		return tfAddr;
	}
	private JLabel getLabel() {
		if (label == null) {
			label = new JLabel("\uC774\uB984");
			label.setBounds(25, 45, 57, 15);
		}
		return label;
	}
	private JLabel getLabel_1() {
		if (label_1 == null) {
			label_1 = new JLabel("\uC804\uD654\uBC88\uD638");
			label_1.setBounds(25, 88, 57, 15);
		}
		return label_1;
	}
	private JLabel getLabel_2() {
		if (label_2 == null) {
			label_2 = new JLabel("\uC804\uD654\uBC88\uD638");
			label_2.setBounds(25, 131, 57, 15);
		}
		return label_2;
	}
	private JLabel getLabel_3() {
		if (label_3 == null) {
			label_3 = new JLabel("\uC8FC\uC18C");
			label_3.setBounds(25, 174, 57, 15);
		}
		return label_3;
	}
	private JButton getBtnView() {
		if (btnView == null) {
			btnView = new JButton("\uC804\uCCB4\uBCF4\uAE30");
			btnView.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
			
					ArrayList<Friendcon> arr = db.friendView();
					 System.out.println("나오나?");
					for(Friendcon f : arr) {
					taView.setText("번호:" +f.getNum()+"\n"
											+"이름:" +f.getName()+"\n"
											+"생일:"	+f.getBirth()+"\n"
											+"번호:" +f.getPhone()+"\n"
					+"주소:" +f.getAddr()+"\n------------------\n");
	
					}
				}
			});
			btnView.setBounds(158, 254, 97, 30);
		}
		return btnView;
	}
	private JButton getButton() {
		if (button == null) {
			button = new JButton("\uCD94\uAC00");
			button.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent arg0) {
					Friendcon f = new Friendcon();
					db.insert(f);
				}
			});
			button.setBounds(25, 254, 97, 30);
		}
		return button;
	}
	private JPanel getPanel_1() {
		if (panel_1 == null) {
			panel_1 = new JPanel();
			panel_1.setLayout(null);
			panel_1.add(getTaView());
			panel_1.add(getBtnNewButton());
			panel_1.add(getTfSearch());
			panel_1.add(getCb());
		}
		return panel_1;
	}
	private JTextArea getTaView() {
		if (taView == null) {
			taView = new JTextArea();
			taView.setBounds(12, 10, 339, 312);
		}
		return taView;
	}
	private JButton getBtnNewButton() {
		if (btnNewButton == null) {
			btnNewButton = new JButton("\uBCF4\uAE30");
			btnNewButton.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					String key="";
					int index = cb.getSelectedIndex();
					 if(index==1) key = "name";
				      else if(index==2) key = "birth"; 
				      else if(index==3) key = "phone"; 
				      else if(index==4) key = "Addr"; 
				      else if(index==0) {taView.setText("선택해주세요");
				      								return;}
					String search = tfSearch.getText();
					 ArrayList<Friendcon> arr =	db.friendSearch(key, search);				
					 for(Friendcon f : arr) {
							taView.setText("번호:" +f.getNum()+"\n"
													+"이름:" +f.getName()+"\n"
													+"생일:"	+f.getBirth()+"\n"
													+"번호:" +f.getPhone()+"\n"
							+"주소:" +f.getAddr()+"\n------------------\n");
			
					 }
				}
			});
			btnNewButton.setBounds(254, 354, 97, 23);
		}
		return btnNewButton;
	}
	private JTextField getTfSearch() {
		if (tfSearch == null) {
			tfSearch = new JTextField();
			tfSearch.setBounds(111, 355, 131, 21);
			tfSearch.setColumns(10);
		}
		return tfSearch;
	}
	private JComboBox getCb() {
		if (cb == null) {
			cb = new JComboBox();
			cb.setModel(new DefaultComboBoxModel(new String[] {"\uC120\uD0DD", "\uC774\uB984", "\uC0DD\uC77C", "\uC804\uD654\uBC88\uD638 ", "\uC8FC\uC18C"}));
			cb.setBounds(12, 355, 87, 21);
		}
		return cb;
	}
}
