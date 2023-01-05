
import java.awt.Font;
import java.awt.Graphics;
import java.awt.event.*;
import java.io.*;
import java.util.*;
import javax.swing.*;
import javax.swing.text.*;
import javax.swing.text.StyledEditorKit.BoldAction;
import javax.swing.text.StyledEditorKit.ItalicAction;
import javax.swing.text.rtf.RTFEditorKit;
public class TextEditor extends JFrame implements ActionListener ,Serializable,ItemListener,MouseListener,KeyListener
{  //Declaring Each component and variables that need to be accessed anywhere in the code Globally   
   List<String>  words=new LinkedList<String>();
   List<Integer> location=new LinkedList<Integer>();
   List<Integer> findlocation=new LinkedList<Integer>();
   List<String>  caseul=new LinkedList<String>();
   List<Integer> caselocation=new LinkedList<Integer>();
   List<Integer> caseendlocation=new LinkedList<Integer>();
   int count=0;
   int replacelocation=0;
   int shift=0;
   File f=null;           
   String Copy="";
   JMenu Case, Edit,  File,Find,Format,Replace,insert;
   JButton bold,copy,paste,cut,italic;
   JMenuItem circle,openf,save,replace,lcase,find,ucase,rectangle,RoundRectangle,square,drawline,replaceall,findnext;
   JComboBox<String> font;
   JLabel jLabel1,jLabel2,jLabel4,jLabel5,jLabel6,jLabel7,jLabel8,jLabel9,jLabel10,jLabel11;
   Draw jLabel3;
   JMenuBar jMenuBar1;
   JPanel jPanel1,jPanel2,jPanel3,jPanel4,jPanel5;
   JScrollPane jScrollPane2;
   JTabbedPane jTabbedPane1;
   JTextField jTextField1,jTextField2;    
   JComboBox<String> size;
   JEditorPane t1;
   List list = new ArrayList();
   Line line;
   int clicks = 0;
   int aline=0,arectangle=0,aoval=0,aroundrectangle=0,asquare=0;
    
    TextEditor(){
   
       components();
       openf.addActionListener(this);
       save.addActionListener(this);
       bold.addActionListener(this);
       italic.addActionListener(this);
       save.addActionListener(this);
       copy.addActionListener(this);
       cut.addActionListener(this);
       paste.addActionListener(this);
       size.addItemListener(this);
       font.addItemListener(this);
       find.addActionListener(this);
       findnext.addActionListener(this);
       replace.addActionListener(this);
       ucase.addActionListener(this);
       lcase.addActionListener(this);
       rectangle.addActionListener(this);
       replaceall.addActionListener(this);
       jLabel3.addMouseListener(this);
       drawline.addActionListener(this);
       rectangle.addActionListener(this);
       square.addActionListener(this);
       circle.addActionListener(this);
       RoundRectangle.addActionListener(this);
       t1.addKeyListener(this);
       t1.addMouseListener(this);
}   

    @Override
    public void keyTyped(KeyEvent ke) {}

    @Override
    public void keyPressed(KeyEvent ke) {}

    @Override
    public void keyReleased(KeyEvent ke) {
        count();
        selectedcount();
    }
    //creating a new styled document
    private StyledDocument getNewDocument() {
	StyledDocument doc = new DefaultStyledDocument();
        return doc;              
	}

    @Override
    public void mouseClicked(MouseEvent me) {    }
    //Method that stores x and y co-ordinates in line class.
    @Override
    public void mousePressed(MouseEvent me) {
        int x = me.getX();
        int y = me.getY();
       
        if (clicks == 0) {
            line = new Line();
            line.setP1(new Point(x, y));
            clicks++;
        } else {
            line.setP2(new Point(x, y));
            list.add(line);
          
          
        }
        repaint();
    }

    @Override
    public void mouseReleased(MouseEvent me) {
        count();
        selectedcount();
    }

    @Override
    public void mouseEntered(MouseEvent me) { }

    @Override
    public void mouseExited(MouseEvent me) { }

    public static void main(String[] args) {
       TextEditor j=new TextEditor();
       j.setVisible(true);
       j.setTitle("Untitled");
        
    }
    //Code for Creating GUI
    void components() {
        jTabbedPane1 = new JTabbedPane();
        jPanel3 = new JPanel();
        jPanel2 = new JPanel();
        bold = new JButton(new BoldAction());
        italic = new JButton(new ItalicAction());
        cut = new JButton();
        copy = new JButton();
        paste = new JButton();
        size = new JComboBox<>();
        font = new JComboBox<>();
        jLabel1 = new JLabel();
        jTextField1 = new JTextField(10);
        jLabel2 = new JLabel();
        jTextField2 = new JTextField(10);
        jScrollPane2 = new JScrollPane();
        t1 = new JTextPane();
        jPanel5 = new JPanel();
        jPanel1 = new JPanel();
        jLabel3 = new Draw();
        jLabel5 = new JLabel();
        jLabel4 = new JLabel();
        jLabel9 = new JLabel();
        jLabel10 = new JLabel();
        jLabel11 = new JLabel();
        jLabel6 = new JLabel();
        jLabel8 = new JLabel();
        jLabel7 = new JLabel();
        jMenuBar1 = new JMenuBar();
        File = new JMenu();
        openf = new JMenuItem();
        save = new JMenuItem();
        Edit = new JMenu();
        Find = new JMenu();
        find = new JMenuItem();
        findnext = new JMenuItem();
        Replace = new JMenu();
        replace = new JMenuItem();
        replaceall = new JMenuItem();
        Format = new JMenu();
        Case = new JMenu();
        ucase = new JMenuItem();
        lcase = new JMenuItem();
        insert = new JMenu();
        drawline = new JMenuItem();
        rectangle = new JMenuItem();
        circle = new JMenuItem();
        square = new JMenuItem();
        RoundRectangle = new JMenuItem();

        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);

        jPanel2.setBorder(BorderFactory.createTitledBorder("Edit Text"));

        bold.setFont(new Font("Tahoma", 1, 12)); // NOI18N
        bold.setText("B");

        italic.setFont(new Font("Tahoma", 2, 12)); // NOI18N
        italic.setText("I");

        cut.setText("Cut");

        copy.setText("Copy");

        paste.setText("Paste");

        size.setModel(new DefaultComboBoxModel<>(new String[] { "Font Size", "12", "14", "16", "18", "20", "22", "24", "26", "28", "30" }));

        font.setModel(new DefaultComboBoxModel<>(new String [] {"Font","Arial", "Calibri", "Cambria", "Courier New", "Comic Sans MS", "Dialog", "Georgia", "Helevetica", "Lucida Sans", "Monospaced", "Tahoma", "Times New Roman", "Verdana"}));

        jLabel1.setFont(new Font("Tahoma", 1, 12)); // NOI18N
        jLabel1.setText("Find");

        jLabel2.setFont(new Font("Tahoma", 1, 12)); // NOI18N
        jLabel2.setText("Replace With");

        GroupLayout jPanel2Layout = new GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(bold)
                .addGap(8, 8, 8)
                .addComponent(italic)
                .addGap(8, 8, 8)
                .addComponent(copy)
                .addGap(8, 8, 8)
                .addComponent(cut)
                .addGap(8, 8, 8)
                .addComponent(paste)
                .addGap(8, 8, 8)
                .addComponent(size)
                .addGap(8, 8, 8)
                .addComponent(font)
                .addGap(8, 8, 8)
                .addComponent(jLabel1)
                .addGap(8, 8, 8)
                .addComponent(jTextField1)
                .addGap(8, 8, 8)
                .addComponent(jLabel2)
                .addGap(8, 8, 8)
                .addComponent(jTextField2)
                .addGap(4, 4, 4))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createParallelGroup(GroupLayout.Alignment.BASELINE)
                .addComponent(bold)
                .addComponent(italic)
                .addComponent(cut)
                .addComponent(copy)
                .addComponent(paste)
                .addComponent(size)
                .addComponent(font)
                .addComponent(jLabel1)
                .addComponent(jTextField1)
                .addComponent(jLabel2)
                .addComponent(jTextField2))
        );

        jScrollPane2.setViewportView(t1);

        GroupLayout jPanel3Layout = new GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(GroupLayout.Alignment.LEADING)
            .addComponent(jPanel2, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(jScrollPane2)
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addComponent(jPanel2, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane2, GroupLayout.PREFERRED_SIZE, 540, GroupLayout.PREFERRED_SIZE)
                .addContainerGap(GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jTabbedPane1.addTab("For Text", jPanel3);

        GroupLayout jPanel1Layout = new GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(GroupLayout.Alignment.LEADING)
            .addComponent(jLabel3, GroupLayout.DEFAULT_SIZE, 821, Short.MAX_VALUE)
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(GroupLayout.Alignment.LEADING)
            .addComponent(jLabel3, GroupLayout.DEFAULT_SIZE, 583, Short.MAX_VALUE)
        );

        GroupLayout jPanel5Layout = new GroupLayout(jPanel5);
        jPanel5.setLayout(jPanel5Layout);
        jPanel5Layout.setHorizontalGroup(
            jPanel5Layout.createParallelGroup(GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        jPanel5Layout.setVerticalGroup(
            jPanel5Layout.createParallelGroup(GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        jTabbedPane1.addTab("For Image", jPanel5);

        jLabel5.setText("0");

        jLabel4.setFont(new Font("Tahoma", 1, 11)); // NOI18N
        jLabel4.setText("Total Characters");

        jLabel9.setText("0");

        jLabel10.setFont(new Font("Tahoma", 1, 11)); // NOI18N
        jLabel10.setText("Total Words");

        jLabel11.setText("0");

        jLabel6.setFont(new Font("Tahoma", 1, 11)); // NOI18N
        jLabel6.setText("Selected Word");

        jLabel8.setFont(new Font("Tahoma", 1, 11)); // NOI18N
        jLabel8.setText("Selected Character");

        jLabel7.setText("0");

        File.setText("File");

        openf.setText("Open File");
        File.add(openf);

        save.setText("Save");
        File.add(save);

        jMenuBar1.add(File);

        Edit.setText("Edit");

        Find.setText("Find");

        find.setText("Find");
        Find.add(find);

        findnext.setText("Find Next");
        Find.add(findnext);

        Edit.add(Find);

        Replace.setText("Replace");

        replace.setText("Replace");
        Replace.add(replace);

        replaceall.setText("Replace All");
        Replace.add(replaceall);

        Edit.add(Replace);

        jMenuBar1.add(Edit);

        Format.setText("Format");

        Case.setText("Case");

        ucase.setText("UpperCase");
        
        Case.add(ucase);

        lcase.setText("LowerCase");
        Case.add(lcase);

        Format.add(Case);

        jMenuBar1.add(Format);

        insert.setText("Insert");

        drawline.setText("Line");
        insert.add(drawline);

        rectangle.setText("Rectangle");
        insert.add(rectangle);

        circle.setText("Oval");
        insert.add(circle);

        square.setText("Square");
        
        insert.add(square);

        RoundRectangle.setText("Round Rectangle");
        insert.add(RoundRectangle);

        jMenuBar1.add(insert);

        setJMenuBar(jMenuBar1);

        GroupLayout layout = new GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(GroupLayout.Alignment.LEADING)
            .addComponent(jTabbedPane1, GroupLayout.Alignment.TRAILING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel4)
                .addGap(20,20,20)
                .addComponent(jLabel9)
                .addGap(0,10,60)
                .addComponent(jLabel10)
                .addGap(0,10,10)
                .addComponent(jLabel11)
                .addGap(0,10,60)
                .addComponent(jLabel6)
                .addGap(0,10,10)
                .addComponent(jLabel5)
                .addGap(0,10,60)
                .addComponent(jLabel8)
                .addGap(0,10,10)
                .addComponent(jLabel7)
                .addGap(0,0,0)
            )
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jTabbedPane1, GroupLayout.PREFERRED_SIZE, 611, GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED, 12, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel9)
                    .addComponent(jLabel8)
                    .addComponent(jLabel6)
                    .addComponent(jLabel4)
                    .addComponent(jLabel5)
                    .addComponent(jLabel7)
                    .addComponent(jLabel11)
                    .addComponent(jLabel10))
                    .addContainerGap())
        );

        pack();
    }
    //Taking styled document thats already written in textpane
    StyledDocument getEditorDocument() {
        StyledDocument doc = (DefaultStyledDocument) t1.getDocument();
	return doc;
	}

    @Override
 
    public void actionPerformed(ActionEvent ae) {
        String s=   t1.getText();
        String s1=jTextField1.getText();
        String s2=jTextField2.getText();
        aline=0;arectangle=0;aoval=0;aroundrectangle=0;asquare=0;
        //Code for Open menuitem
        if(ae.getSource()==openf)
        {//
            StyledDocument doc = getEditorDocument();
            RTFEditorKit editorKit = new RTFEditorKit();
            int startPos = 0;
            if(f==null&&(jLabel11.getText()).equals("0"))
            {t1.setText("");
            open();
            setTitle(f.getName());
            try (InputStream in = new FileInputStream(f)) 
            {		
                editorKit.read(in, doc, startPos);
            }   
            catch (IOException ex) 
            {
                
            } 
            catch (BadLocationException ex)
            {
                
            }
            count();
            selectedcount();
            }
            else
                JOptionPane.showMessageDialog(this,"Save Your work");
            
        }
        //Code for save menuitem
        if(ae.getSource()==save)
        {
            save();
            StyledDocument doc = getEditorDocument();
            RTFEditorKit editorKit = new RTFEditorKit();
            int startPos = 0;
            int docLen = doc.getLength();
            try (OutputStream out = new FileOutputStream(f))
            {		
                editorKit.write(out, doc, startPos, docLen);
            }           
            catch (FileNotFoundException ex) 
            {
           
            }
            catch (IOException ex)
            {
            
            } 
            catch (BadLocationException ex) 
            {
            
            }
        }
        //Code for bold button
    if(ae.getSource()==bold)
    {   
        t1.requestFocusInWindow();
    }
    //Code for italic button
    if(ae.getSource()==italic)
    {
        t1.requestFocusInWindow();
    }
    //Code for copy button
    if(ae.getSource()==copy)
    {
        t1.copy();
    }
    ////Code for paste button
    if(ae.getSource()==paste)
    {
        t1.paste();
    }
    //Code for cut button
    if(ae.getSource()==cut)
    {
        t1.cut();
    }
    //Code for find menuitem. Creates the background functionality for findnext, replace, replaceall menuitem.
    if(ae.getSource()==find)
    {//condition to prevent searching an empty string.
        if(!s1.isEmpty())
    {   //clearing the previous stored data
        words.clear();
        findlocation.clear();
        location.clear();
        count=0;replacelocation=0;shift=0;
        String word="";
        int temp=0; 
        int j=1;
        location.add(0);
        s=s+' ';
        //creating a scanner class to read text line by line
        Scanner k=new Scanner(s);
        //reading text from textpane line by line
        while(k.hasNextLine())
        {String s3=k.nextLine();
        s3=s3+' ';
        //inserting each word with its starting index
        for(int i=0;i<s3.length();i++)
          {     char ch=s3.charAt(i);
                if(ch==' '|| ch=='.'||ch==13)
                {if(s3.length()!=0)
                 words.add(word); 
                 location.add(j);
                 word=""; 
                 j++;
                }
                else
                {j++;
                    word=word+ch;
                }
          }
        }
        for(String x:words)
        {   //condition to store the indices of the word that matches the string entered by user
           if(x.equals(s1))
           {
               findlocation.add(location.get(temp));
           } 
           temp++;
        }
        if(findlocation.isEmpty())
         JOptionPane.showMessageDialog(this,"No match found");   
    }
    else
        JOptionPane.showMessageDialog(this,"Enter The String to be found");
    }
    //Code for findnext menuitem using the list created through find menuitem used to select the searched word
    if(ae.getSource()==findnext)
    {   //condition to check wheather the string entered by user exists in textpane
        if(!findlocation.isEmpty())
    {
        if(count<findlocation.size())
        {
        t1.requestFocusInWindow();
        //selecting the text.
        t1.select(findlocation.get(count),findlocation.get(count)+s1.length());
        count++;
        }
        else
        {
        JOptionPane.showMessageDialog(this,"Search Completed");
        t1.select(0, 0);
        }
    }
    else
        JOptionPane.showMessageDialog(this,"Search Completed");
    }
    //Code for replace menuitem using the list created through find menuitem. Replaces searched word one by one.
    if(ae.getSource()==replace)
    {
    //condition to ensure that string is not empty
    if(!s2.isEmpty())
    {//condition to check wheather the string entered by user exists in textpane
    if(!findlocation.isEmpty())
    {
    if(replacelocation<findlocation.size())
    {
    t1.requestFocusInWindow();
    //selecting the text.
    t1.select(findlocation.get(replacelocation),findlocation.get(replacelocation)+s1.length());
    //replacing selected text with the string entered by user.
    t1.replaceSelection(s2);
    replacelocation++;
    //shfting the location of stored element in order to select the correct word on next occuarence of event
    shift=shift+s2.length()-s1.length();
    int dummy=findlocation.get(replacelocation);
    //removing the previous value.
    findlocation.remove(replacelocation);
    //updating it with the new position.
    findlocation.add(replacelocation,dummy+shift);
    }
    }
    else
    {
        JOptionPane.showMessageDialog(this,"Replace Completed");
        
    }
    }
    else
        JOptionPane.showMessageDialog(this,"Enter String to be replaced"); 
    }
    //Code for replaceall menuitem using the list created through find menuitem. Replaces each occurance of searched word with word that we need to replace.
    if(ae.getSource()==replaceall)
    {//condition to ensure that string is not empty
        if(!s2.isEmpty())
    {
    if(!findlocation.isEmpty())
    {
    while(replacelocation<findlocation.size())
    {
    t1.requestFocusInWindow();
    //selecting the text.
    t1.select(findlocation.get(replacelocation),findlocation.get(replacelocation)+s1.length());
    //replacing selected text with the string entered by user.
    t1.replaceSelection(s2);
    replacelocation++;
    //shfting the location of stored element in order to select the correct word on next occuarence of event
    shift=shift+s2.length()-s1.length();
    if(replacelocation<findlocation.size())
    {
    int dummy=findlocation.get(replacelocation);
    //removing the previous value.
    findlocation.remove(replacelocation);
    findlocation.add(replacelocation,dummy+shift);
    }
    else
        JOptionPane.showMessageDialog(this,"Replace Completed");
    }
    }
    }
        else
        JOptionPane.showMessageDialog(this,"Enter String to be replaced"); 
    
    }
    //Code for ucase menuitem. Cspitalizes each character with its attributes(bold, size, font etc) intact.
    if(ae.getSource()==ucase)
    {   t1.requestFocusInWindow();
        //clearing all the previous data 
        caseul.clear();
        caselocation.clear();
        caseendlocation.clear();
        //extracting the selected text.
        String x=t1.getSelectedText();
        //extracting the starting location
        int caret=t1.getSelectionStart();
        //condition to prevent insertion on null in case no text is selected and user presses lower case menuitem by mistake.
        if(x!=null)
        {
        String word="";
        int temp=0;
        int j=caret;
        x=x+' ';
        Scanner k=new Scanner(x);
        //reading text from textpane line by line
        while(k.hasNextLine())
        {String s3=k.nextLine();
        s3=s3+' ';
        //logic to find different selected words and their starting position which can later be used to replace the Selected content with its uppercase version.
        for(int i=0;i<s3.length();i++)
          {     char ch=s3.charAt(i);
                if(ch==' '|| ch=='.'||ch==13)
                {if(s3.length()!=0)
                 word=word.toUpperCase();
                 caseul.add(word); 
                 caseendlocation.add(j);
                 caselocation.add(j-word.length());
                 word=""; 
                 j++;
                }
                else
                {j++;
                    word=word+ch;
                }
          }
        }
        for(int i=0;i<caselocation.size();i++)
        {
        t1.requestFocusInWindow();
         //selects the word
        t1.select(caselocation.get(i),caseendlocation.get(i));
        //replaces the selected word with its uppercase one. And also ensures attributes of selected text does not gets changed upon execution of event.
        t1.replaceSelection(caseul.get(i));
        }
        }
    }
    //Code for lcase menuitem. lowarcases each character with its attributes(bold, size, font etc) intact.
    if(ae.getSource()==lcase)
    {
        t1.requestFocusInWindow();
        //clearing all the previous data 
        caseul.clear();
        caselocation.clear();
        caseendlocation.clear();
        //extracting the selected content
        String x=t1.getSelectedText();
        //extracting the starting location
        int caret=t1.getSelectionStart();
        //condition to prevent insertion on null in case no text is selected and user presses lower case menuitem by mistake.
        if(x!=null)
        {
        String word="";
        int temp=0;
        int j=caret;
        x=x+' ';
        Scanner k=new Scanner(x);
        //reading text from textpane line by line
        while(k.hasNextLine())
        {String s3=k.nextLine();
        s3=s3+' ';
        //logic to find different selected words and their starting position which can later be used to replace the Selected content with its lowercase version.
        for(int i=0;i<s3.length();i++)
          {     char ch=s3.charAt(i);
                if(ch==' '|| ch=='.'||ch==13)
                {if(s3.length()!=0)
                 word=word.toLowerCase();
                 caseul.add(word); 
                 caseendlocation.add(j);
                 caselocation.add(j-word.length());
                 word=""; 
                 j++;
                }
                else
                {j++;
                    word=word+ch;
                }
          }
        } 
        for(int i=0;i<caselocation.size();i++)
        {
        t1.requestFocusInWindow();
        //selects the word
        t1.select(caselocation.get(i),caseendlocation.get(i));
        //replaces the selected word with its lowercase one. And also ensures attributes of selected text does not gets changed upon execution of event.
        t1.replaceSelection(caseul.get(i));
        }
        }
    }
    //codes for drawing on jlabel
    //clicks=0 implies that we need to record first point to draw object each time user presses the menuitms.
    //different variables used to assign a particular shape to jlabel upon triggering actionevent.
    //code for drawing rectangle
    if(ae.getSource()==rectangle)
    {clicks=0;
     arectangle=1;   
     list.clear();
    }
    //code for drawing square
    if(ae.getSource()==square)
    {
     list.clear();   
     asquare=1;   
     clicks=0;
    }
    //code for drawing circle
    if(ae.getSource()==circle)
    {list.clear();
     aoval=1;   
     clicks=0;
    }
    //code for drawing roundrectangle
    if(ae.getSource()==RoundRectangle)
    {list.clear();
     aroundrectangle=1;
     clicks=0;
    }
    //code for drawing drawline
    if(ae.getSource()==drawline)
    { clicks=0;
      list.clear();
     aline=1;   
    }
    }
    
    //code for open
    void open()
  {//popsup to set the path from where the file needs to be opened. 
      JFileChooser j=new JFileChooser();
      j.showOpenDialog(j);
      f=j.getSelectedFile();
      
      
  }
    //code for saveas
    void saveas(){
    if(f==null)
    {//popsup to select the location where the file needs to be saved in case it has been newly written that is not loaded through open menuitem.
            JFileChooser j=new JFileChooser();
            j.showSaveDialog(j);
            f=j.getSelectedFile();
            if(f.exists())
            {
                int k=JOptionPane.showConfirmDialog(this, "File Already Exists. Do you want to replace it.");
             }
            }
             else
             {
                 f=null;  
             }  
          }
    //code for save
    void save()
 {
 if(f==null)
 {
     saveas();
 }
 }
    //method to handle the selction made from font and size combobox.
    @Override
    public void itemStateChanged(ItemEvent ie) {
        if(ie.getSource()==size)
        {//no changes made as size has not been changed by the user.
        if ((ie.getStateChange() != ItemEvent.SELECTED) ||(size.getSelectedIndex() == 0)) 
        {
            return;
	}
	//extracting the selected item from combox.		
	String fontSizeStr = (String) ie.getItem();			
	int newFontSize = 0;
	try {
	newFontSize = Integer.parseInt(fontSizeStr);
	}
	catch (NumberFormatException ex) {
	return;
	}
        //setting attributes to the selected word of the document.
        size.setAction(new StyledEditorKit.FontSizeAction(fontSizeStr, newFontSize));
        //bring cursor back to text pane.
	t1.requestFocusInWindow();
        }
        if(ie.getSource()==font)
        {
        if ((ie.getStateChange() != ItemEvent.SELECTED) ||(font.getSelectedIndex() == 0)) {
	return;
	}
        //extracting the selected item from combox.
	String fontFamily = (String) ie.getItem();
        //setting attributes to the selected word of the document.
	font.setAction(new StyledEditorKit.FontFamilyAction(fontFamily, fontFamily));	
	t1.requestFocusInWindow();    
        }
    }
    
    //class that contains the method to draw on label  
    class Draw extends JLabel {
    public Draw() { }
    public void paint(Graphics g) 
    {
           super.paint(g);
           Line currLine;
           for (int i = 0; i < list.size(); i++) 
        {  //typecasting object from list type to Line.
           currLine = (Line) (list.get(i));
           //to get x1,y1 that is one fixed point of the figure.
           int x=Math.min(currLine.getP1().getX(), currLine.getP2().getX());
           int y=Math.min(currLine.getP1().getY(), currLine.getP2().getY());
           //various checkers implemented as to ensure the drawing of shape upon clicking the suitable input.
           if(aline==1)
           g.drawLine(currLine.getP1().getX(), currLine.getP1().getY(),currLine.getP2().getX(), currLine.getP2().getY());
           if(arectangle==1)
           g.drawRect(x,y,Math.abs(currLine.getP2().getX()- currLine.getP1().getX()),Math.abs(currLine.getP2().getY()- currLine.getP1().getY()));
           if(aoval==1)
           {
            g.drawOval(x,y,Math.abs(currLine.getP2().getX()- currLine.getP1().getX()),Math.abs(currLine.getP2().getY()- currLine.getP1().getY()));   
           }
           if(aroundrectangle==1)
           {
            g.drawRoundRect(x,y,Math.abs(currLine.getP2().getX()- currLine.getP1().getX()),Math.abs(currLine.getP2().getY()- currLine.getP1().getY()),50,50);   
           }
           if(asquare==1)
           {
               g.drawRect(x,y,Math.abs(currLine.getP2().getY()- currLine.getP1().getY()),Math.abs(currLine.getP2().getY()- currLine.getP1().getY()));
           }
          
        }
    }
 
   
}
    //class that contains the points between the shape is to be drawn. In terms of X and Y; 
    class Point {
 int x;
 int y;
 public Point() {   }
 public Point(int x, int y)
    {
        this.x = x;
        this.y = y;
    }
    public int getX() {
        return x;
    }
    public int getY() {
        return y;
    }
    public void setX(int x) {
        this.x = x;
    }
    public void setY(int y) {
        this.y = y;
    }
}
    //class that contains the points between the shape is to be drawn. In terms of Point class.
    class Line {
 
    private Point p1;
    private Point p2;
 
    public Line() {
    }
 
    public Line(Point p1, Point p2) {
        this.p1 = p1;
        this.p2 = p2;
    }
 
    public Point getP1() {
        return p1;
    }
 
    public Point getP2() {
        return p2;
    }
 
    public void setP1(Point p1) {
        this.p1 = p1;
    }
 
    public void setP2(Point p2) {
        this.p2 = p2;
    }
}
    //Method that counts the number of words and characters.
    void count()
    {
        TreeMap<String, Integer> frequencyData = new TreeMap<String, Integer>( );
        TreeMap<String, Integer> sfrequencyData = new TreeMap<String, Integer>( );
        Scanner wordFile;
        String word;     // A word read from the file
        Integer count;   // The number of occurrences of the word
        String k=t1.getText();
        int x=0;
        wordFile = new Scanner((k));
        int t=k.length();
        for(int i=0;i<t;i++)
        {if(k.charAt(i)==' ')
        x++;   
        }
      
        while (wordFile.hasNext( ))
        {// Read the next word and get rid of the end-of-line marker if needed:
	 word = wordFile.next( );
         x=x+word.length();
          
        if (frequencyData.containsKey(word))
        {  
	   count= frequencyData.get(word)+1; 
        }
        else
        {  // No occurrences of this word
        count= 1;
        }
        frequencyData.put(word, count);
       }
        int c=0;
        int b=0;
        for(String word1 : frequencyData.keySet( ))
        {
          c=frequencyData.get(word1)+c;
        }
        jLabel11.setText(""+c);
        jLabel9.setText(""+x);
       
    }
    //Method that counts the number of selected words and characters.
    void selectedcount()
    {
        TreeMap<String, Integer> frequencyData = new TreeMap<String, Integer>( );
        TreeMap<String, Integer> sfrequencyData = new TreeMap<String, Integer>( );
        Scanner wordFile;
        String word;     // A word read from the file
        Integer count;   // The number of occurrences of the word
        String k=t1.getSelectedText();
        int x=0;
        if(k!=null)
        {
        wordFile = new Scanner((k));
        int t=k.length();
        for(int i=0;i<t;i++)
        {if(k.charAt(i)==' ')
        x++;   
        }
      
        while (wordFile.hasNext( ))
        {// Read the next word and get rid of the end-of-line marker if needed:
	 word = wordFile.next( );
         x=x+word.length();
          
        if (frequencyData.containsKey(word))
        {  
	   count= frequencyData.get(word)+1; 
        }
        else
        {  
         count= 1;
        }
          frequencyData.put(word, count);
        }
        int c=0;
        int b=0;
        for(String word1 : frequencyData.keySet( ))
        {
          c=frequencyData.get(word1)+c;
        }
        jLabel5.setText(""+c);
        jLabel7.setText(""+x);
        }
        else
        {
        jLabel7.setText("0");
        jLabel5.setText("0");
        } 
    }
}

