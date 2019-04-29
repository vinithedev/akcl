package document;

import javax.swing.JOptionPane;
import javax.swing.text.AttributeSet;
import javax.swing.text.BadLocationException;
import javax.swing.text.PlainDocument;

public class DocLimit extends PlainDocument {
    
    private int limit;
    
    //Limita tamanho de um JTextField
    public DocLimit(int limit) {
        super();
        this.limit = limit;
    }
    
    public void insertString( int offset, String  str, AttributeSet attr ) throws BadLocationException {
        
        if (str == null) return;
        
        if ((getLength() + str.length()) <= limit) {
            super.insertString(offset, str, attr);
        } else {
            JOptionPane.showMessageDialog(null, "Limite de caracteres excedido!");
        }
    }
}
