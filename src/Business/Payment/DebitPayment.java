/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package Business.Payment;

import Business.Bank.SavingsAccount;
import java.util.Date;

/**
 *
 * @author JJPL
 */
public class DebitPayment extends PaymentMode {
    
    private SavingsAccount savingsAccount;
    private int cardNo;
    private String cardHolderName;
    private int ccv;
    private Date expiryDate;
    
    
    
    
    
}
