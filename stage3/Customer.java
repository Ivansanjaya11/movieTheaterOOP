/**
 * @author Logan Cordova
 */

public class Customer {

    private String name;
    private String email;
    private String phoneNumber;

    //Should void be added to this constructor???
     public void Customer(String name) {
        this.name = name;
     }

     public void Customer(String name, String email, String phoneNumber) {
        this.name = name;
        this.email = email;
        this.phoneNumber = phoneNumber;
     }

     public String getName() {
        return name;
     }

     public String getEmail() {
        return email;
     }

     public String getPhoneNumber() {
        return phoneNumber;
     }

     public void setName(String name) {
        this.name = name;
     }

     public void setEmail(String email) {
        this.email = email;
     }

     public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
     }
}