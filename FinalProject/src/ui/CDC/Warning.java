package ui.CDC;

public class Warning {
    String id;
    String disease;
    String date;
    String case_number;
    String status;

    public Warning() {
    }

    public Warning(String disease, String date, String case_number, String status) {
        this.disease = disease;
        this.date = date;
        this.case_number = case_number;
        this.status = status;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getDisease() {
        return disease;
    }

    public void setDisease(String disease) {
        this.disease = disease;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public String getCase_number() {
        return case_number;
    }

    public void setCase_number(String case_number) {
        this.case_number = case_number;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

}
