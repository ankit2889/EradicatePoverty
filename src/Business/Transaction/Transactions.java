/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package Business.Transaction;

import Business.Payment.Payment;
import java.util.Date;

/**
 *
 * @author JJPL
 */
public class Transactions {
    
    private Payment payment;
    private Date lastReceivedDate;
    
    public Transactions()
    {
        
    }

    public Payment getPayment() {
        return payment;
    }

    public void setPayment(Payment payment) {
        this.payment = payment;
    }

    public Date getLastReceivedDate() {
        return lastReceivedDate;
    }

    public void setLastReceivedDate(Date lastReceivedDate) {
        this.lastReceivedDate = lastReceivedDate;
    }
    
    
    
}
