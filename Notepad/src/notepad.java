
import javax.swing.*;
import java.awt.*;

public class notepad extends JFrame {
    JMenuBar menuBar;
    JMenu fileMenu, editMenu, formatMenu, viewMenu ,helpMenu;
    JMenuItem fileItem[]=new JMenuItem[8];
    String fileStr[]={"New                     Ctrl+N","New Window      Ctrl+Shift+N","Open                   Ctrl+O","Save                    Ctrl+S","Save As...           Ctrl+Shift+S","Page Setup","Print...                 Ctrl+P","Exit"};
    JMenuItem editIem[]=new JMenuItem[13];
    String editStr[]={"Undo                               Ctrl+Z","Cut                                  Ctrl+X","Copy                               Ctrl+C","Paste                              Ctrl+V","Delete                             Del","Search with Bing...        Ctrl+E","Find...                              " +
            "Ctrl+F","find Next                         F3","Find Previous                Shift+F3","Replace...                      Ctrl+H","Go To...                         Ctrl+G","Select All                       Ctrl+A","Time/Date                           F5"};
    JMenuItem formatItem[]=new JMenuItem[2];
    String formatStr[]={"Word Wrap","Font..."};
    JMenuItem viewItem;
    JMenu zoom;
    JMenuItem zoomItem[]=new JMenuItem[3];
    String zoomStr[]={"Zoom In          Ctrl+Plus","Zoom Out        Strl+Minus","Restore Default Zoom     Ctrl+0"};
    JCheckBox statusbar;
    JMenuItem helpItem[]=new JMenuItem[3];
    String helpStr[]={"View Help","Send Feedback","About Notepad"};
    JTextArea textArea;
    JScrollPane scroll;
    JPanel p;
    public notepad() {
        menuBar=new JMenuBar();
        menuBar.setBackground(Color.WHITE);
        fileMenu=new JMenu("File");
        for(int i=0;i<8;i++){
            fileItem[i]=new JMenuItem(fileStr[i]);
            fileMenu.add(fileStr[i]);
        }
        menuBar.add(fileMenu);
        editMenu=new JMenu("Edit");
        for(int i=0;i<13;i++){
            editIem[i]=new JMenuItem(editStr[i]);
            editMenu.add(editStr[i]);
        }
        menuBar.add(editMenu);
        formatMenu=new JMenu("Format");
        for(int i=0;i<2;i++){
            formatItem[i]=new JMenuItem(formatStr[i]);
            formatMenu.add(formatStr[i]);
        }
        menuBar.add(formatMenu);
        viewMenu=new JMenu("View");
        zoom=new JMenu("Zoom");
        for(int i=0;i<3;i++){
            zoomItem[i]=new JMenuItem(zoomStr[i]);
            zoom.add(zoomItem[i]);
        }
        statusbar=new JCheckBox("Status Bar");
        viewMenu.add(zoom);
        viewMenu.add(statusbar);
        menuBar.add(viewMenu);
        helpMenu=new JMenu("Help");
        for(int i=0;i<3;i++){
            helpItem[i]=new JMenuItem(helpStr[i]);
            helpMenu.add(helpItem[i]);
        }
        menuBar.add(helpMenu);
        setJMenuBar(menuBar);
        textArea=new JTextArea();
        scroll = new JScrollPane(textArea,JScrollPane.VERTICAL_SCROLLBAR_AS_NEEDED,JScrollPane.HORIZONTAL_SCROLLBAR_AS_NEEDED);
        add(scroll,BorderLayout.CENTER);
        p=new JPanel();
        p.setBackground(Color.lightGray);
        add(p,BorderLayout.SOUTH);
        ImageIcon icon=new ImageIcon("notepad_37173.jpg");
        setIconImage(icon.getImage());
        setTitle("Untitled - Notepad");
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        setSize(400,300);
        setVisible(true);
    }

    public static void main(String[] args) {
        new notepad();
    }
}
