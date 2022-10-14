public class Person {
    private String lastName;
    private String firstName;
    private String address;

    public void setLastName(String lname) {
        lastName = lname;
    }

    public String getLastName() {
        return lastName;
    }

    public void setFirstName(String fname) {
        firstName = fname;
    }

    public String getFirstName() {
        return firstName;
    }

    public String getName() {
        return getFirstName() + " " + getLastName();
    }

    public void setAddress(String add) {
        address = add;
    }

    public String getAddress() {
        return address;
    }

    public void print() {
        System.out.println("Name: " + this.getName() + "\n");
        System.out.println("Address: " + getAddress() + "\n");
    }
}
