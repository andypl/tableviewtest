module tableviewtest {
    requires javafx.graphics;
    requires javafx.controls;
    requires javafx.fxml;

    exports pl.info.czerniak.tableviewtest.main to javafx.graphics;
    opens pl.info.czerniak.tableviewtest.table to javafx.fxml, javafx.base;
}