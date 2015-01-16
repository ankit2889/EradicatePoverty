/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package Business.Utility;

import java.util.regex.Matcher;
import java.util.regex.Pattern;
import javax.swing.JComboBox;
import javax.swing.JPasswordField;
import javax.swing.JTable;
import javax.swing.JTextArea;
import javax.swing.JTextField;

/**
 *
 * @author JJPL
 */
public class Validation {
    
    public static boolean validateTableSelection(JTable table, int noOfRows)
    {
        if(table.getSelectedRowCount()==noOfRows)
        return true;
        else return false;
    }
    
    public static boolean validateTextFieldsForAmount(JTextField textField)
    {
        try
        {
            Double value=Double.parseDouble(textField.getText().trim());
            if(value<=0)
            {
                return false;
            }
        }
        catch(Exception e)
        {
            return false;
        }
        return true;
    }
    
    
    public static boolean validateTextFieldForPercentage(JTextField textField)
    {
        try
        {
            Double percentage=Double.parseDouble(textField.getText().trim());
            if(percentage<=100.0 &&percentage>=0.0)
            {
                return true;
            }
            else
             return false;
            
        }
        catch(Exception e)
        {
            return false;
        }
    }
    
    public static boolean validateTextAreaForNonEmpty(JTextArea txtArea )
    {
        if(txtArea.getText().trim().equalsIgnoreCase(""))
        {
            return false;
        }
        else return true;
    }
    
    public static boolean validateTextFieldsForNonEmpty(JTextField textField)
    {
        if(textField.getText().trim().equalsIgnoreCase(""))
        {
            return false;
        }
        else return true;
    }
    
    public static boolean validateTextFieldsForString(JTextField textField)
    {
        
        String pattern = "[a-zA-z]+([ '-][a-zA-Z]+)*";
        boolean flag = textField.getText().trim().matches(pattern);
        if(textField.getText().trim().equalsIgnoreCase(""))
            flag = false;
        return flag;
    }
   
    public static boolean validateTextFieldsForInteger(JTextField textField)
    {
        try
        {
            int a=Integer.parseInt(textField.getText().trim());
            if(a<0)
            {
                return false;
            }
        }
        catch(Exception e)
        {
            return false;
        }
        return true;
    }
    
    
    public static boolean validateTextFieldsForNumber(JTextField textField)
    {
        return true;
    }
    
    public static boolean validateTextFieldsForPhoneNumber(JTextField textField)
    {
        Pattern patternMobileNumber = Pattern.compile("\\d{10}");
        Matcher matcher = patternMobileNumber.matcher(textField.getText().trim());
        return matcher.matches();
    }
    
    public static boolean validateTextFieldsForEmailId(JTextField textField)
    {
        try
        {
        String patternEmail = "^[_A-Za-z0-9-]+(\\.[_A-Za-z0-9-]+)*@[A-Za-z0-9]+(\\.[A-Za-z0-9]+)*(\\.[A-Za-z]{2,})$";
        Boolean flag = textField.getText().trim().matches(patternEmail);
        return flag;
        }
        catch(Exception e)
        {
            return false;
        }
    }
    
    public static boolean validateTextFieldsForUserName(JTextField txtUserName)
    {
        String pattern = "^[a-zA-Z0-9]([._](?![._])|[a-zA-Z0-9]){6,18}[a-zA-Z0-9]$";
        boolean flag = txtUserName.getText().trim().matches(pattern);
                
        return flag;
    }
    
    
    
    public static boolean validateComboBoxForSelection(JComboBox comboBox)
    {
        if(comboBox.getSelectedIndex()!=-1)
        return true;
        else 
        return false;
        
    }
    
    public static boolean validateTextFieldForPassword(JPasswordField txtPassword)
    {
       String pattern = "(?=.*[0-9])(?=.*[a-z])(?=.*[A-Z])(?=.*[@#$%^&+=])(?=\\S+$).{5,10}";
       boolean flag = String.valueOf(txtPassword.getPassword()).trim().matches(pattern);
       if(String.valueOf(txtPassword.getPassword()).equalsIgnoreCase(""))
       flag=false;
       
       return flag;
    }

    
    public static boolean validateTextFieldForCCV(JTextField txtCCV)
    {
        
        String pattern = "^[0-9]{3,4}$";
       boolean flag = txtCCV.getText().trim().matches(pattern);
       return flag;
        
    }
    
    public static boolean validateTextFieldForCreditCardNo(JTextField txtField)
    {
        
        String pattern = "^(?:4[0-9]{12}(?:[0-9]{3})?|5[1-5][0-9]{14}|6(?:011|5[0-9][0-9])[0-9]{12}|3[47][0-9]{13}|3(?:0[0-5]|[68][0-9])[0-9]{11}|(?:2131|1800|35\\d{3})\\d{11})$";
       boolean flag = txtField.getText().trim().matches(pattern);
       return flag;
        
    }
    
    
    public static boolean validateTextFieldForId(JTextField txtField)
    {
        String pattern = "[a-zA-z0-9]+(['-][a-zA-Z]+)*";
        boolean flag = txtField.getText().trim().matches(pattern);
        if(txtField.getText().trim().equalsIgnoreCase(""))
            flag = false;
        return flag;
        
        
    }
    
}
