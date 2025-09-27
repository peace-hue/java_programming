package BloodBankSystem;

import java.awt.event.*;
import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.sql.*;
import com.util.DB;

public class UserPanel extends JPanel implements ActionListener {

    JTextField idtxf = new JTextField();
    JTextField nametxf = new JTextField();
    JTextField roletxf = new JTextField();
    JPasswordField passtxf = new JPasswordField();

    JButton addbtn = new JButton("Add");
    JButton updatebtn = new JButton("Update");
    JButton deletebtn = new JButton("Delete");
    JButton loadbtn = new JButton("Load");

    JTable table;
    DefaultTableModel model;

    public UserPanel() {
        setLayout(null);

        String[] labels = {"ID","Username","Password","Role"};
        String[] cols={"id","username","password","role"};
        
        model = new DefaultTableModel(labels, 0);
        table = new JTable(model);
        JScrollPane sp = new JScrollPane(table);
        sp.setBounds(20, 200, 800, 300);

        int y = 20;
        addField("ID", idtxf, y);
        y+=30;
        addField("Username", nametxf, y);
        y+=30;
        addField("Password", passtxf, y);
        y+=30;
        
        y+=30;
        addField("Role", roletxf, y);

        addButtons();
        add(sp);
    }

    private void addField(String lbl, JComponent txf, int y) {
        JLabel l = new JLabel(lbl);
        l.setBounds(20, y, 100, 25);
        txf.setBounds(130, y, 150, 25);
        add(l); add(txf);
    }

    private void addButtons() {
        addbtn.setBounds(350, 20, 100, 30);
        updatebtn.setBounds(350, 60, 100, 30);
        deletebtn.setBounds(350, 100, 100, 30);
        loadbtn.setBounds(350, 140, 100, 30);

        add(addbtn); 
        add(updatebtn);
        add(deletebtn);
        add(loadbtn);

        addbtn.addActionListener(this);
        updatebtn.addActionListener(this);
        deletebtn.addActionListener(this);
        loadbtn.addActionListener(this);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        try (Connection con = DB.getConnection()) {
            if (e.getSource() == addbtn) {
              
                PreparedStatement ps = con.prepareStatement("INSERT INTO users (id, username, password, role) VALUES (?,?,?,?)");

                ps.setString(1, idtxf.getText());
                ps.setString(2, nametxf.getText());
                ps.setString(3, new String(passtxf.getPassword()));
                ps.setString(4, roletxf.getText());
                
                ps.executeUpdate();
            } 
            else if (e.getSource() == updatebtn) {
                String sql = "UPDATE users SET username=?, password=?, role=? WHERE id=?";
                PreparedStatement ps = con.prepareStatement(sql);
                ps.setString(1, nametxf.getText());
                ps.setString(2, new String(passtxf.getPassword()));
               
                ps.setString(5, roletxf.getText());
                ps.setInt(6, Integer.parseInt(idtxf.getText()));
                ps.executeUpdate();
            } 
            else if (e.getSource() == deletebtn) {
                String sql = "DELETE FROM users WHERE id=?";
                PreparedStatement ps = con.prepareStatement(sql);
                ps.setInt(1, Integer.parseInt(idtxf.getText()));
                ps.executeUpdate();
            } 
            else if (e.getSource() == loadbtn) {
                model.setRowCount(0);
                ResultSet rs = con.createStatement().executeQuery("SELECT * FROM users");
                while (rs.next()) {
                    model.addRow(new Object[]{
                        rs.getInt("id"),
                        rs.getString("username"),
                        rs.getString("password"),
                       
                        rs.getString("role")
                    });
                }
            }
        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }
}