import java.sql.*;

public class DatabaseManager {
    private static final String DB_URL = "jdbc:mysql://localhost:3306/wedding_app";
    private static final String DB_USERNAME = "your_username";
    private static final String DB_PASSWORD = "your_password";

    public void saveGuest(Guest guest) {
        try (Connection conn = DriverManager.getConnection(DB_URL, DB_USERNAME, DB_PASSWORD)) {
            String query = "INSERT INTO guests (name, email, phone, address) VALUES (?, ?, ?, ?)";
            PreparedStatement statement = conn.prepareStatement(query);
            statement.setString(1, guest.getName());
            statement.setString(2, guest.getEmail());
            statement.setString(3, guest.getPhone());
            statement.setString(4, guest.getAddress());
            statement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    // Implement other database operations (e.g., saveRSVP, saveVendor, etc.) similarly

    public static void main(String[] args) {
        // Test the database operations here
        DatabaseManager dbManager = new DatabaseManager();
        Guest guest = new Guest();
        guest.setName("John Doe");
        guest.setEmail("johndoe@example.com");
        guest.setPhone("1234567890");
        guest.setAddress("123 Main St");
        dbManager.saveGuest(guest);
    }
}
