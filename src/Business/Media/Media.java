/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package Business.Media;

/**
 *
 * @author JJPL
 */
public class Media {
    
    public enum MediaType{
        INTERNET("INTERNET") , 
        RADIO("RADIO"), 
        TV("TV");
        
        
        private String value;
        private MediaType(String value) {
            this.value = value;
        }
        public String getValue() {
            return value;
        }
//        public Organization createOrganization(Type t) {
//            return t.createOrganization();
//        }
    }
    
    
    
    
}
