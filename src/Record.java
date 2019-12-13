


import java.time.LocalDate;
import java.time.ZoneId;
import java.time.format.DateTimeFormatter;
import java.util.Date;

public class Record {
    private String firstName;
    private String lastName;
    private Date startDate;
    private String address1;
    private String address2;
    private String city;
    private String state;
    private String country;
    private String zip;

    public Record() {
    }

    public Record(String firstName, String lastName, Date startDate, String address1, String address2, String city, String state, String country, String zip) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.startDate = startDate;
        this.address1 = address1;
        this.address2 = address2;
        this.city = city;
        this.state = state;
        this.country = country;
        this.zip = zip;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public Date getStartDate() {
        return startDate;
    }

    public void setStartDate(Date startDate) {
        this.startDate = startDate;
    }

    public String getAddress1() {
        return address1;
    }

    public void setAddress1(String address1) {
        this.address1 = address1;
    }

    public String getAddress2() {
        return address2;
    }

    public void setAddress2(String address2) {
        this.address2 = address2;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getState() {
        return state;
    }

    public void setState(String state) {
        this.state = state;
    }

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }

    public String getZip() {
        return zip;
    }

    public void setZip(String zip) {
        this.zip = zip;
    }

    @Override
    public String toString() {
        StringBuilder returnString =  new StringBuilder();
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("MMMM dd, yyyy");
        LocalDate newDate = startDate.toInstant().atZone(ZoneId.systemDefault()).toLocalDate();
        String dateText = newDate.format(formatter);
        returnString.append(getFirstName().trim() + " ");
        returnString.append(getLastName().trim() + ", ");
        returnString.append("(" + dateText.trim() + "),\n");
        if(!address1.trim().equals("")){
            returnString.append(address1.trim() + ", ");
        }
        if(!address2.trim().equals("")){
            returnString.append(address2.trim() +",\n");
        }
        if(!city.trim().equals("")){
            returnString.append(city.trim() + ",");
        }
        if(!state.trim().equals("")){
            returnString.append(state.trim() + ",\n");
        }
        if(!country.trim().equals("")){
            returnString.append(country.trim() + ",");
        }
        if(!zip.trim().equals("")){
            returnString.append(zip.trim() + "\n");
        }
        else{
            returnString.append("\n");
        }
        return returnString.toString();

    }
}
