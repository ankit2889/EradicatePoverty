/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package Business.Transaction;

import com.db4o.collections.ActivatableArrayList;
import java.util.ArrayList;

/**
 *
 * @author JJPL
 */
public class TransactionDirectory {
    
  private ArrayList<Transactions> transactionList;
  
  public TransactionDirectory()
  {
      this.transactionList = new ArrayList<>();
  }

    public ArrayList<Transactions> getTransactionList() {
        return transactionList;
    }

    public void setTransactionList(ArrayList<Transactions> transactionList) {
        this.transactionList = transactionList;
    }
  
  
    
}
