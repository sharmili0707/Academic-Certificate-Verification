public class Certificate {
    public String studentName;
    public String courseName;
    public String institution;
    public String certificateId;

    public Certificate(String studentName, String courseName, String institution, String certificateId) {
        this.studentName = studentName;
        this.courseName = courseName;
        this.institution = institution;
        this.certificateId = certificateId;
    }

    @Override
    public String toString() {
        return "Certificate{" +
                "studentName='" + studentName + '\'' +
                ", courseName='" + courseName + '\'' +
                ", institution='" + institution + '\'' +
                ", certificateId='" + certificateId + '\'' +
                '}';
    }
}

