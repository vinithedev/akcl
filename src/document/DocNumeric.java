package document;

import javax.swing.JOptionPane;
import javax.swing.text.AttributeSet;
import javax.swing.text.BadLocationException;
import javax.swing.text.DocumentFilter;

public class DocNumeric extends DocumentFilter {
    
    public static int max;
    
    @Override
    public void replace(DocumentFilter.FilterBypass fb, int i, int i1, String string, AttributeSet as) throws BadLocationException {
        //Transforma 'abc123' em 'abc'. Iteração reversa é necessária.
        for (int n = string.length(); n > 0; n--) {
            //Seleciona o último char e assim por diante
            char c = string.charAt(n-1);
            //Se char for alfabético ou espaço em branco
            if (Character.isDigit(c)) {
                //Substitua-o na string
                super.replace(fb, i, i1, String.valueOf(c), as);
            }else{
                JOptionPane.showMessageDialog(null, "Caracter incorreto! Este campo só aceita números!");
                break;
            }
        }
        
        int documentLength = fb.getDocument().getLength();
        char c = string.charAt(string.length()-1);
        
        if(documentLength - i1 + string.length() > max){
            JOptionPane.showMessageDialog(null, "Limite de caracteres excedido!");
        }
        
        while (documentLength - i1 + string.length() > max){
            super.replace(fb, i, 1, "", as);
        }
    }
}
