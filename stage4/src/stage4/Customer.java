package stage4;

/** This class represents a customer and stores their name, email, and phone number
 * Allows for access and modification to be made to customer details
 * @author Logan Cordova
 */

public class Customer {

    private String name;
    private String email;
    private String phoneNumber;

    /**
     * Constructor initializing customer with name
     * @param name customer's name
     */
     public Customer(String name) {
        this.name = name;
     }

     /**
      * Constructor initializing name, email address, and phone number of customer
      * @param name customer's name
      * @param email customer's email
      * @param phoneNumber customer's phone number
      */
     public Customer(String name, String email, String phoneNumber) {
        this.name = name;
        this.email = email;
        this.phoneNumber = phoneNumber;
     }

     /**
      * Returns name of customer
      * @return customer's name
      */
     public String getName() {
        return name;
     }

     /**
      * Returns email of customer
      * @return customer's email
      */
     public String getEmail() {
        return email;
     }

     /**
      * Returns phone number of customer
      * @return customer's phone number
      */
     public String getPhoneNumber() {
        return phoneNumber;
     }

     /**
      * Updates customer name
      * Sets new customer name
      * @param name customer's name
      */
     public void setName(String name) {
        this.name = name;
     }

     /**
      * Updates customer email
      * Sets new customer email
      * @param email customer's email
      */
     public void setEmail(String email) {
        this.email = email;
     }

     /**
      * Updates customer phone number
      * Sets new customer phone number 
      * @param phoneNumber customer's phone number
      */
     public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
     }
}
