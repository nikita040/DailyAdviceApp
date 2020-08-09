package com.company;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.PrintWriter;
import java.net.Socket;

public class SimpleChatClient {

    JTextField field;
    Socket socket;
    PrintWriter writer;

    public void buildGUI(){
        JFrame frame = new JFrame("Simple Chat Client");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        FlowLayout flowLayout = new FlowLayout();
        JPanel panel = new JPanel();
        panel.setBorder(BorderFactory.createEmptyBorder(10,10,10,10));
        field = new JTextField(20);
        panel.add(field);
        JButton button = new JButton("Send");
        button.addActionListener(new SendActionListener());
        panel.add(button);
        frame.getContentPane().add(panel);

        setUpNetworking();
        frame.setSize(400,500);
        frame.setVisible(true);

    }

    public class SendActionListener implements ActionListener{
        @Override
        public void actionPerformed(ActionEvent e) {
            try{
                writer.println(field.getText());
                writer.flush();

            }
            catch(Exception f){
                f.printStackTrace();
            }

            field.setText("");
            field.requestFocus();

        }
    }

    public void setUpNetworking(){
        try{
            socket = new Socket("127.0.0.1", 4242);

            writer = new PrintWriter(socket.getOutputStream());
            System.out.println("Network established");

        }
        catch (Exception e){
            e.printStackTrace();
        }




    }
}
