
package Login;

import java.awt.Color;
import javax.swing.JPasswordField;
import javax.swing.JTextField;

/**
 *
 * @author Q2602
 */
public class DataValidator {
    public static void validateEmty(JTextField field,StringBuilder sb,String errorMessage){
        if(field.getText().equals("")){
            sb.append(errorMessage).append("\n");
            field.setBackground(Color.red);
            field.requestFocus();
        }
        else{
             field.setBackground(Color.green);
        }
    }
    public static void validateEmty(JPasswordField field,StringBuilder sb,String errorMessage){
        String pass=new String(field.getPassword()); 
        if(pass.equals("")){
            sb.append(errorMessage).append("\n");
            field.setBackground(Color.red);
            field.requestFocus();
        }
        else{
             field.setBackground(Color.green);
        }
    }
}
