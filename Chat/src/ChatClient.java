import java.awt.EventQueue;

import javax.swing.JFrame;
import java.awt.GridLayout;

import javax.swing.JOptionPane;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.OutputStreamWriter;
import java.net.Socket;

import javax.swing.JLabel;


public class ChatClient
{

    private JFrame frame;
    private JTextField port;
    private JTextArea display;
    private JTextArea msg;
    
    private Socket client;
    private BufferedWriter output;
    private BufferedReader input;
    
    private String serverData = "";
    private String clientData = "";


    /**
     * Launch the application.
     */
    public static void main(String[] args)
    {
        EventQueue.invokeLater(new Runnable() {
            public void run()
            {
                try
                {
                    ChatClient window = new ChatClient();
                    window.frame.setVisible(true);
                } catch (Exception e)
                {
                    e.printStackTrace();
                }
            }
        });
    }

    /**
     * Create the application.
     */
    public ChatClient()
    {
        initialize();
    }

    /**
     * Initialize the contents of the frame.
     */
    private void initialize()
    {
        frame = new JFrame();
        frame.setTitle("클라이언트");
        frame.setBounds(100, 100, 450, 400);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.getContentPane().setLayout(null);
        
        JScrollPane scrollPane = new JScrollPane();
        scrollPane.setBounds(0, 25, 434, 288);
        frame.getContentPane().add(scrollPane);
        
        display = new JTextArea();
        display.setEditable(false);
        scrollPane.setViewportView(display);
        
        JScrollPane scrollPane_1 = new JScrollPane();
        scrollPane_1.setBounds(0, 316, 366, 46);
        frame.getContentPane().add(scrollPane_1);
        
        msg = new JTextArea();
        scrollPane_1.setViewportView(msg);
        
        JButton btnNewButton = new JButton("전송");
        btnNewButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent arg0) {
                clientData = msg.getText();
                try
                {
                    display.append("\n클라이언트 : " + clientData);
                    output.write(clientData+"\r\n");
                    output.flush();
                    
                    msg.setText("");
                    if (clientData.equals("quit"))
                    {
                        client.close();
                    }
                }
                catch(Exception e)
                {
                    JOptionPane.showMessageDialog(null, e);
                }

            }
        });
        btnNewButton.setBounds(366, 316, 68, 46);
        frame.getContentPane().add(btnNewButton);
        
        port = new JTextField();
        port.setBounds(229, 0, 79, 21);
        frame.getContentPane().add(port);
        port.setColumns(10);
        
        JLabel lblNewLabel = new JLabel("서버포트");
        lblNewLabel.setBounds(138, 3, 79, 15);
        frame.getContentPane().add(lblNewLabel);
        
        JButton btnNewButton_1 = new JButton("연결");
        btnNewButton_1.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                //runClient(Integer.parseInt(port.getText()));
                runClient run = new runClient();
                run.start();
            }
        });
        btnNewButton_1.setBounds(337, -1, 97, 23);
        frame.getContentPane().add(btnNewButton_1);
    }
    
    class runClient extends Thread
    {
        public void run()
        {
            try
            {
                client = new Socket("localhost", Integer.parseInt(port.getText()));
                InputStream is = client.getInputStream();
                OutputStream os = client.getOutputStream();
                input = new BufferedReader(new InputStreamReader(is));
                output = new BufferedWriter(new OutputStreamWriter(os));
                
                display.append("\n"+ port.getText() +"로 서버와 접속 되었습니다");
                
                while(true)
                {
                    serverData = input.readLine();
                    
                    if (serverData.equals("quit"))
                    {
                        display.append("\n서버와 접속 중단되었습니다");
                        output.flush();
                        break;
                    }
                    else
                    {
                       display.append("\n서버 메시지 : "+ serverData);
                       output.flush();
                    }
                }
            }
            catch(IOException ioe)
            {
                JOptionPane.showMessageDialog(null, ioe);
            }
            finally
            {
                try
                {
                    if (client != null) client.close();
                }
                catch(Exception e){}
            }
        }

    }
}
