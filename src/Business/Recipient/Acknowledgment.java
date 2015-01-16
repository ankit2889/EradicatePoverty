/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package Business.Recipient;

import java.util.Date;

/**
 *
 * @author JJPL
 */
public class Acknowledgment {
    
    private Recipient recipient;
    private String textAcknowledgment;
    private Date receivedDate;

    public Recipient getRecipient() {
        return recipient;
    }

    public void setRecipient(Recipient recipient) {
        this.recipient = recipient;
    }

    public String getTextAcknowledgment() {
        return textAcknowledgment;
    }

    public void setTextAcknowledgment(String textAcknowledgment) {
        this.textAcknowledgment = textAcknowledgment;
    }

    public Date getReceivedDate() {
        return receivedDate;
    }

    public void setReceivedDate(Date receivedDate) {
        this.receivedDate = receivedDate;
    }
    
    
          
    
}
