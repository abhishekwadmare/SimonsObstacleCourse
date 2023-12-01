module com.java.simonsobstaclecourse {
    requires javafx.controls;
    requires javafx.fxml;


    opens com.java.simonsobstaclecourse to javafx.fxml;
    exports com.java.simonsobstaclecourse;
}