import java.awt.*;
import javax.swing.*;
import javax.swing.table.DefaultTableModel;

import java.awt.event.*;


public class StudentForm extends JFrame implements ActionListener
{
   JScrollPane pane ;
   JLabel dl,nl,rl,yl,er;
  JTextField nt,rt;
  JRadioButton r1,r2,r3;
  JPanel p1;
  JTable jt;
  JButton addb,clearb;
  ButtonGroup bg;
  DefaultTableModel model;
  public StudentForm(){
     dl = new JLabel("Data Entry");
     nl = new JLabel("Name");
     rl = new JLabel("Reg No");
     yl = new JLabel("Year");
     nt = new JTextField(20);
     rt = new JTextField(20);
     r1 = new JRadioButton("2");
     r2 = new JRadioButton("3");
     r3 = new JRadioButton("4");
     bg = new ButtonGroup();
     addb = new JButton("ADD");
     clearb = new JButton("CLEAR");
     model = new DefaultTableModel(0,0);
     jt = new JTable();
     jt.setModel(model);  
     pane = new JScrollPane(jt);
     model.setColumnIdentifiers(new String[]{"Name","Reg No","Year"});
     addb.addActionListener(this);
     clearb.addActionListener(this);
     pane.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_AS_NEEDED);
     pane.setHorizontalScrollBarPolicy(JScrollPane.HORIZONTAL_SCROLLBAR_AS_NEEDED);
     bg.add(r1);
     bg.add(r2);
     bg.add(r3);
     p1 = new JPanel();
     p1.setLayout(null);
     p1.add(dl); 
     p1.add(nl);
     p1.add(nt);
     p1.add(rl);
     p1.add(rt);
     p1.add(yl);
     p1.add(r1);
     p1.add(r2);
     p1.add(r3);
     p1.add(addb);
     p1.add(clearb);
     p1.add(pane);
     dl.setBounds(10,10,100,20);
     nl.setBounds(10,40,50,20);
     nt.setBounds(60,40,100,20);
     rl.setBounds(10,70,50,20);
     rt.setBounds(60,70,100,20);
     yl.setBounds(10,100,50,20);
     r1.setBounds(60,100,40,20);
     r2.setBounds(100,100,40,20);
     r3.setBounds(140,100,40,20);
     addb.setBounds(10,130,70,25);
     clearb.setBounds(90,130,90,25);
     pane.setBounds(200,10,200,130);
     add(p1);
  }
  public void actionPerformed(ActionEvent ae){
   String cmd = ae.getActionCommand();
   if(cmd.equals("CLEAR")){
      nt.setText("");
      rt.setText("");
      bg.clearSelection();
      addb.setEnabled(true);
   }else{
      String val = "";
      if(r1.isSelected()){
         val="2nd year";
      }else if(r2.isSelected()){
         val="3rd year";
      }else if(r3.isSelected()){
         val="4th year";
      }
      //val+="------------------\n";
      //ja.append(val);
      model.addRow(new String[]{nt.getText(),rt.getText(),val});
      addb.setEnabled(false);

   }
  }
  public static void main(String argv[]){
     StudentForm sf = new StudentForm();
     sf.setVisible(true);
     sf.setTitle("Student Form");
     sf.setSize(420,230);
  }
}
