/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package Business.EnrollmentStaff;

/**
 *
 * @author JJPL
 */
public interface Staff {
    
    
    public enum StaffType{
        FIELDSTAFF("Field Staff"),
        SENIORSTAFF("Senior Staff");
        
        private String value;
        private StaffType(String value){
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
    
    
    
}
