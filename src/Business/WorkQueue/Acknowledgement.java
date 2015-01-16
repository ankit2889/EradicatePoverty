/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package Business.WorkQueue;

/**
 *
 * @author JJPL
 */
public class Acknowledgement extends WorkRequest{
    
    private String acknowledgementMsg;
    private String degreeOfSatisfaction;
    
    public Acknowledgement()
    {
        super();
    }

    public String getAcknowledgementMsg() {
        return acknowledgementMsg;
    }

    public void setAcknowledgementMsg(String acknowledgementMsg) {
        this.acknowledgementMsg = acknowledgementMsg;
    }

    public String getDegreeOfSatisfaction() {
        return degreeOfSatisfaction;
    }

    public void setDegreeOfSatisfaction(String degreeOfSatisfaction) {
        this.degreeOfSatisfaction = degreeOfSatisfaction;
    }
    
    
    
}
