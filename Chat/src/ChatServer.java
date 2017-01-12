import java.awt.EventQueue;

import javax.swing.JFrame;
import java.awt.GridLayout;
import java.awt.FlowLayout;
import javax.swing.JLabel;
import java.awt.GridBagLayout;

import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JButton;
import javax.swing.JTextField;
import com.jgoodies.forms.layout.FormLayout;
import com.jgoodies.forms.layout.ColumnSpec;
import com.jgoodies.forms.layout.RowSpec;
import com.jgoodies.forms.factories.FormFactory;
import javax.swing.SwingConstants;
import javax.swing.JTextPane;
import java.awt.BorderLayout;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.OutputStreamWriter;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.Date;


public class ChatServer
{
    private JFrame frame;
    private JTextField port;
    private JTextArea display;
    private JTextArea msg;
    
    private Socket connection;
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
                    ChatServer window = new ChatServer();
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
    public ChatServer()
    {
        initialize();
    }

    /**
     * Initialize the contents of the frame.
     */
    private void initialize()
    {
        frame = new JFrame();
        frame.setTitle("채팅 서버");
        frame.setBounds(100, 100, 450, 350);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.getContentPane().setLayout(null);
        
        JScrollPane scrollPane = new JScrollPane();
        scrollPane.setBounds(0, 36, 434, 230);
        frame.getContentPane().add(scrollPane);
        
        display = new JTextArea();
        display.setEditable(false);
        scrollPane.setViewportView(display);
        
        JButton startButton = new JButton("시작");
       
        startButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent arg0) {
                if (port.getText().equals(""))
                {
                    JOptionPane.showMessageDialog(null, "입력된 값이 없습니다.");
                }
                else
                {
                    ServerRunThread serverRun = new ServerRunThread();
                    serverRun.start();                    
                }
            }
        });

        startButton.setBounds(325, 6, 97, 23);
        frame.getContentPane().add(startButton);
        
        port = new JTextField();
        port.setBounds(197, 6, 116, 23);
        frame.getContentPane().add(port);
        port.setColumns(10);
        
        JLabel lblNewLabel = new JLabel("포트번호");
        lblNewLabel.setBounds(128, 10, 57, 15);
        frame.getContentPane().add(lblNewLabel);
        
        JScrollPane scrollPane_1 = new JScrollPane();
        scrollPane_1.setBounds(0, 268, 370, 44);
        frame.getContentPane().add(scrollPane_1);
        
        msg = new JTextArea();
        scrollPane_1.setViewportView(msg);
        
        JButton btnNewButton = new JButton("전송");
        btnNewButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent arg0) {
                serverData = msg.getText();
                try
                {
                    display.append("\n서버 : " + serverData);
                    output.write(serverData+"\r\n");
                    output.flush();
                    
                    msg.setText("");
                    if (serverData.equals("quit"))
                    {
                        connection.close();
                    }
                }
                catch(Exception e)
                {
                    JOptionPane.showMessageDialog(null, e);
                }
            }
        });
        btnNewButton.setBounds(372, 268, 62, 44);
        frame.getContentPane().add(btnNewButton);
    }

    class ServerRunThread extends Thread
    {
        @Override
        public void run()
        {
            ServerSocket server = null;
            
            try
            {
                server = new ServerSocket(Integer.parseInt(port.getText()),1);
                
                display.append("\n "+port.getText()+"로 서버가 시작 되었습니다.");
                
                while(true)
                {
                    connection = server.accept();
                    
                    InputStream is = connection.getInputStream();
                    input = new BufferedReader(new InputStreamReader(is));
                    
                    OutputStream os = connection.getOutputStream();
                    output = new BufferedWriter(new OutputStreamWriter(os));

                    while(true)
                    {
                        clientData = input.readLine();
                        
                        if (clientData.equals("quit"))
                        {
                            display.append("\n 클라이언트와 접속이 중단 되었습니다.");
                            output.flush();
                            break;
                        }
                        else
                        {
                            display.append("\n클라이언트 메시지 : " + clientData);
                            output.flush();
                        }
                    }
                }
            }
            catch(Exception e)
            {
                JOptionPane.showMessageDialog(null, e);
            }
            finally
            {
                try
                {
                    if(connection != null){
                        connection.close();
                        display.append(port+"에 바인드된 서버 소켓 객체가 종료되었습니다.\n");
                    }
                    
                    if (server != null)
                    {
                        server.close();
                    }
                }
                catch(Exception e){}            
            }

        }
    }
}

