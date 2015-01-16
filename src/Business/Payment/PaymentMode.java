/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package Business.Payment;

import java.util.Date;

/**
 *
 * @author JJPL
 */
public class PaymentMode {
    
      private String cardNo;
       private Date cardExpiryDate;
       private String cardHolderName;
       private String ccv;

    public String getCardNo() {
        return cardNo;
    }

    public void setCardNo(String cardNo) {
        this.cardNo = cardNo;
    }

    public Date getCardExpiryDate() {
        return cardExpiryDate;
    }

    public void setCardExpiryDate(Date cardExpiryDate) {
        this.cardExpiryDate = cardExpiryDate;
    }

    public String getCardHolderName() {
        return cardHolderName;
    }

    public void setCardHolderName(String cardHolderName) {
        this.cardHolderName = cardHolderName;
    }
    
   public enum paymentType {
   
       CREDIT("Credit"),
        DEBIT("Debit"),
        CHEQUE("Cheque");
        
        private String value;
        private paymentType(String value){
            this.value = value;
        }

        public String getValue() {
            return value;
        }

        @Override
        public String toString() {
            return value;
        }
       
   }
   
   
    @Override
    public String toString() {
        return this.getClass().getName();
    }

    public String getCcv() {
        return ccv;
    }

    public void setCcv(String ccv) {
        this.ccv = ccv;
    }
    
    
    
}
