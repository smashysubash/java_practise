import java.awt.*;
import java.awt.event.*;
import java.math.BigInteger;

import javax.swing.*;
import javax.swing.border.TitledBorder;
import javax.swing.table.DefaultTableModel;

public class phonebook extends JFrame implements ActionListener {
    JLabel nl,cl,pl,fl;
    JButton ib,rb;
    JTable jt;
    JScrollPane jp;
    JPanel p1,p2,mp;
    JTextField nt,ct,pt;
    DefaultTableModel model;
    public phonebook(){
        fl = new JLabel("  File");
        nl = new JLabel("Name :");
        cl = new JLabel("City :");
        pl = new JLabel("Phone :");
        ib = new JButton("INSERT");
        rb = new JButton("RESET");
        model = new DefaultTableModel();
        jt = new JTable(model);
        jp = new JScrollPane(jt);
        p1 = new JPanel();
        p2 = new JPanel();
        mp = new JPanel();
        nt = new JTextField();
        ct = new JTextField();
        pt = new JTextField();
        model.addColumn("Name");
        model.addColumn("City");
        model.addColumn("Phone");
        jp.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_AS_NEEDED);
        jp.setHorizontalScrollBarPolicy(JScrollPane.HORIZONTAL_SCROLLBAR_ALWAYS);
        fl.setBorder(BorderFactory.createTitledBorder( BorderFactory.createLineBorder(Color.lightGray)));
		p1.add(nl);
        p1.add(nt);
        p1.add(cl);
        p1.add(ct);
        p1.add(pl);
        p1.add(pt);		
        p1.add(ib);
        p1.add(rb);
        p1.setBorder(BorderFactory.createTitledBorder( BorderFactory.createEtchedBorder(), "Info", TitledBorder.LEFT, TitledBorder.TOP));
        p2.add(jp);
        mp.add(p1);
        mp.add(p2);
        add(fl,BorderLayout.NORTH);
        add(mp);
        ib.addActionListener(this);
        rb.addActionListener(this);
        p1.setLayout(null);
        p2.setLayout(null);
        mp.setLayout(null);
        p1.setBounds(10,10,310,150);
        nl.setBounds(40,20,50,20);
        nt.setBounds(100,20,140,20);
        cl.setBounds(40,50,100,20);
        ct.setBounds(100,50,140,20);
        pl.setBounds(40,80,100,20);
        pt.setBounds(100,80,140,20);
        ib.setBounds(100,110,80,20);
        rb.setBounds(190,110,80,20);
        p2.setBounds(0,130,320,250);
        jp.setBounds(10,35,310,200);
    }
	public void actionPerformed(ActionEvent ae){
		String cmd = ae.getActionCommand();
        if(cmd.equals("RESET")){
			nt.setText("");
            ct.setText("");
            pt.setText("");
		}
		else if (cmd.equals("INSERT")){
			if(nt.getText().equals("")){
                JOptionPane.showMessageDialog(this,"Enter the Name field","Missing Field",JOptionPane.INFORMATION_MESSAGE);
            }
			else if(ct.getText().equals("")){
                JOptionPane.showMessageDialog(this,"Enter the City field","Missing Field",JOptionPane.INFORMATION_MESSAGE);
			}
			else if(pt.getText().equals("")){
                JOptionPane.showMessageDialog(this,"Enter the Phone field","Missing Field",JOptionPane.INFORMATION_MESSAGE);
			}else if(!(isNumeric(pt.getText())||(pt.getText().charAt(0)=='+'&& isNumeric(pt.getText().substring(1))))){
                JOptionPane.showMessageDialog(this,"Enter Only numbers (or start with '+' for country code eg. +91 ) on phone field","Missing Field",JOptionPane.INFORMATION_MESSAGE);
            }else {
				model.addRow(new Object[] { nt.getText(), ct.getText(), pt.getText()});
			}
		}
	}
    public static boolean isNumeric(String str) {
        if (str == null) {
            return false;
        }
        try {
            new BigInteger(str);
            return true;
        } catch (NumberFormatException nfe) {
            return false;
        }
    }

    public static void main(String argv[]){
        phonebook pb = new phonebook();
        pb.setVisible(true);
        pb.setTitle("Student Form");
        pb.setSize(350,435);
		pb.setDefaultCloseOperation(EXIT_ON_CLOSE);
     }
}
