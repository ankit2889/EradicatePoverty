/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package Business.Payment;

import java.util.ArrayList;

/**
 *
 * @author JJPL
 */
public class PaymentHistory {
    
    private ArrayList<Payment> paymentHistory;
    
    public PaymentHistory ()
    {
        this.paymentHistory = new ArrayList<Payment>();
    }

    public ArrayList<Payment> getPaymentHistory() {
        return paymentHistory;
    }

    public void setPaymentHistory(ArrayList<Payment> paymentHistory) {
        this.paymentHistory = paymentHistory;
    }
    
    
    public Payment addPayment()
    {
        Payment payment = new Payment();
        paymentHistory.add(payment);
        return payment;
    }
    
    
    public Payment findPayment (int paymentId)
    {
        for (Payment payment:paymentHistory)
        {
            if (payment.getPaymentId()==paymentId)
            {
                return payment;
            }
        }
        return null;
    }
    
}

