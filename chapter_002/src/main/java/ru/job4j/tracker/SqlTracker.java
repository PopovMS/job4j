package ru.job4j.tracker;



import java.io.InputStream;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Properties;


public class SqlTracker implements Store {

    private Connection connection;
    private Statement statement;

    public SqlTracker() {
        init();
    }

    public SqlTracker(Connection connection) {
        this.connection = connection;
    }

    private void init() {
        try (InputStream input = SqlTracker.class.getClassLoader()
                .getResourceAsStream("app.properties")) {
            Properties config = new Properties();
            config.load(input);
            Class.forName(config.getProperty("driver-class-name"));
            connection = DriverManager.getConnection(
                    config.getProperty("url"),
                    config.getProperty("username"),
                    config.getProperty("password")
            );
        } catch (Exception e) {
            throw new IllegalStateException(e);
        }
        try {
            statement = connection.createStatement();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public void close() throws SQLException {
        if (connection != null) {
            connection.close();
        }
    }

    @Override
    public Item add(Item item) {
        try (PreparedStatement ps =
                     connection.prepareStatement("INSERT INTO items (name, created) VALUES (?, ?)",
                                    Statement.RETURN_GENERATED_KEYS)) {
            ps.setString(1, item.getName());
            ps.setTimestamp(2, Timestamp.valueOf(item.getCreated()));
            ps.execute();
            ResultSet generatedKeys = ps.getGeneratedKeys();
                if (generatedKeys.next()) {
                    item.setId(generatedKeys.getInt(1));
                }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return item;
    }

    @Override
    public boolean replace(int id, Item item) {
        boolean result = false;
        try (PreparedStatement ps =
                     connection.prepareStatement("UPDATE items SET name = ?, created = ? WHERE ID = ?")) {
            ps.setString(1, item.getName());
            ps.setTimestamp(2, Timestamp.valueOf(item.getCreated()));
            ps.setInt(3, id);
            result  = ps.executeUpdate() > 0;
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return result;
    }

    @Override
    public void delete(int id) {
        try (PreparedStatement ps =
                     connection.prepareStatement("DELETE FROM items WHERE ID = ?")) {
            ps.setInt(1, id);
            ps.executeUpdate();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public List<Item> findAll() {
        List<Item> list = new ArrayList<>();
        try (PreparedStatement ps = connection.prepareStatement("SELECT * FROM items")) {
            ResultSet resultSet = ps.executeQuery();
            while (resultSet.next()) {
                list.add(createItem(resultSet));
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return list;
    }

    @Override
    public List<Item> findByName(String key) {
        List<Item> list = new ArrayList<>();
        try (PreparedStatement ps =
                     connection.prepareStatement("SELECT * FROM items WHERE name = ?")) {
            ps.setString(1, key);
            ResultSet resultSet = ps.executeQuery();
            while (resultSet.next()) {
                list.add(createItem(resultSet));
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return list;
    }

    @Override
    public Item findById(int id) {
        Item result = null;
        try (PreparedStatement ps =
                     connection.prepareStatement("SELECT * FROM items WHERE id = ?")) {
            ps.setInt(1, id);
            ResultSet resultSet = ps.executeQuery();
                if (resultSet.next()) {
                    result = createItem(resultSet);
                }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return result;
    }

    private Item createItem(ResultSet resultSet) {
        try {
            return new Item(resultSet.getString("name"),
                    resultSet.getInt("id"),
                    resultSet.getTimestamp("created").toLocalDateTime());
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
}