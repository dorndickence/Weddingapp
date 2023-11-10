import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.scene.layout.GridPane;
import javafx.stage.Stage;

public class GuestEntryScreen extends Application {
    private DatabaseManager dbManager;

    @Override
    public void start(Stage primaryStage) {
        dbManager = new DatabaseManager();

        GridPane grid = new GridPane();
        grid.setPadding(new Insets(20));
        grid.setVgap(10);
        grid.setHgap(10);

        TextField nameField = new TextField();
        TextField emailField = new TextField();
        TextField phoneField = new TextField();
        TextField addressField = new TextField();

        Button saveButton = new Button("Save");
        saveButton.setOnAction(e -> {
            Guest guest = new Guest();
            guest.setName(nameField.getText());
            guest.setEmail(emailField.getText());
            guest.setPhone(phoneField.getText());
            guest.setAddress(addressField.getText());
            dbManager.saveGuest(guest);
        });

        grid.add(nameField, 0, 0);
        grid.add(emailField, 0, 1);
        grid.add(phoneField, 0, 2);
        grid.add(addressField, 0, 3);
        grid.add(saveButton, 0, 4);

        Scene scene = new Scene(grid, 300, 200);
        primaryStage.setTitle("Guest Entry");
        primaryStage.setScene(scene);
        primaryStage.show();
    }

    public static void main(String[] args) {
        launch(args);
    }
}
