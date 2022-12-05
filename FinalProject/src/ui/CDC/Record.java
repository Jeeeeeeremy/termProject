package ui.CDC;

public class Record {
    String id;
    String user_id;
    String hospital;
    String physician_ID;
    String physician;
    String status;
    String diagnosis;
    String temperature;
    String blood_pressure;
    String treatment;
    String reportToCDC;
    String CDCResponse;
    String recorddate;
    String specialty;
    String user_name;

    String date;
    public Record() {
    }

    public Record(String id, String user_id, String hospital, String physician_ID, String physician, String status, String diagnosis, String temperature, String blood_pressure, String treatment, String reportToCDC, String CDCResponse, String recorddate, String specialty, String user_name, String date) {
        this.id = id;
        this.user_id = user_id;
        this.hospital = hospital;
        this.physician_ID = physician_ID;
        this.physician = physician;
        this.status = status;
        this.diagnosis = diagnosis;
        this.temperature = temperature;
        this.blood_pressure = blood_pressure;
        this.treatment = treatment;
        this.reportToCDC = reportToCDC;
        this.CDCResponse = CDCResponse;
        this.recorddate = recorddate;
        this.specialty = specialty;
        this.user_name = user_name;
        this.date = date;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getUser_id() {
        return user_id;
    }

    public void setUser_id(String user_id) {
        this.user_id = user_id;
    }

    public String getHospital() {
        return hospital;
    }

    public void setHospital(String hospital) {
        this.hospital = hospital;
    }

    public String getPhysician_ID() {
        return physician_ID;
    }

    public void setPhysician_ID(String physician_ID) {
        this.physician_ID = physician_ID;
    }

    public String getPhysician() {
        return physician;
    }

    public void setPhysician(String physician) {
        this.physician = physician;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getDiagnosis() {
        return diagnosis;
    }

    public void setDiagnosis(String diagnosis) {
        this.diagnosis = diagnosis;
    }

    public String getTemperature() {
        return temperature;
    }

    public void setTemperature(String temperature) {
        this.temperature = temperature;
    }

    public String getBlood_pressure() {
        return blood_pressure;
    }

    public void setBlood_pressure(String blood_pressure) {
        this.blood_pressure = blood_pressure;
    }

    public String getTreatment() {
        return treatment;
    }

    public void setTreatment(String treatment) {
        this.treatment = treatment;
    }

    public String getReportToCDC() {
        return reportToCDC;
    }

    public void setReportToCDC(String reportToCDC) {
        this.reportToCDC = reportToCDC;
    }

    public String getCDCResponse() {
        return CDCResponse;
    }

    public void setCDCResponse(String CDCResponse) {
        this.CDCResponse = CDCResponse;
    }

    public String getRecorddate() {
        return recorddate;
    }

    public void setRecorddate(String recorddate) {
        this.recorddate = recorddate;
    }

    public String getSpecialty() {
        return specialty;
    }

    public void setSpecialty(String specialty) {
        this.specialty = specialty;
    }

    public String getUser_name() {
        return user_name;
    }

    public void setUser_name(String user_name) {
        this.user_name = user_name;
    }

    @Override
    public String toString() {
        return "Record{" +
                "id='" + id + '\'' +
                ", user_id='" + user_id + '\'' +
                ", hospital='" + hospital + '\'' +
                ", physician_ID='" + physician_ID + '\'' +
                ", physician='" + physician + '\'' +
                ", status='" + status + '\'' +
                ", diagnosis='" + diagnosis + '\'' +
                ", temperature='" + temperature + '\'' +
                ", blood_pressure='" + blood_pressure + '\'' +
                ", treatment='" + treatment + '\'' +
                ", reportToCDC='" + reportToCDC + '\'' +
                ", CDCResponse='" + CDCResponse + '\'' +
                ", recorddate='" + recorddate + '\'' +
                ", specialty='" + specialty + '\'' +
                ", user_name='" + user_name + '\'' +
                ", date='" + date + '\'' +
                '}';
    }
}
