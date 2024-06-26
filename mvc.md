# MVC

# Model class - Login.java
```
public class Login {
    private String username;
    private String password;

    // Constructor, getters, and setters
    public Login(String username, String password) {
        this.username = username;
        this.password = password;
    }

    // Getters and setters
    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
}
```

# DAO - LoginDAO.java
```
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class LoginDAO {

    private static final String SELECT_BY_USERNAME_QUERY = "SELECT * FROM login WHERE username = ?";
    
    // Method to fetch Login details by username from database
    @Override
    public Login getLoginByUsername(String username) {
        Connection conn = null;
        PreparedStatement stmt = null;
        ResultSet rs = null;
        Login login = null;

        try {
            // Replace with your database connection logic
            conn = DriverManager.getConnection("your database url", "username", "password");
            stmt = conn.prepareStatement(SELECT_BY_USERNAME_QUERY);
            stmt.setString(1, username);
            rs = stmt.executeQuery();

            if (rs.next()) {
                // Retrieve data from result set and create Login object
                String dbUsername = rs.getString("username");
                String dbPassword = rs.getString("password");
                login = new Login(dbUsername, dbPassword);
            }
        } catch (SQLException e) {
            e.printStackTrace();
            // Handle exception appropriately
        } finally {
            // Close resources in reverse order of creation if not using try-with-resources
            try { if (rs != null) rs.close(); } catch (SQLException e) { e.printStackTrace(); }
            try { if (stmt != null) stmt.close(); } catch (SQLException e) { e.printStackTrace(); }
            try { if (conn != null) conn.close(); } catch (SQLException e) { e.printStackTrace(); }
        }

        return login;
    }
}
```

# Controller (Servlet)
```
import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class LoginServlet extends HttpServlet {
    private static final long serialVersionUID = 1L;
    private LoginDAO loginDAO;

    public void init() {
        loginDAO = new LoginDAO(); // Initialize DAO implementation
    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String username = request.getParameter("username");
        String password = request.getParameter("password");

        // Fetch Login object from DAO by username
        Login login = loginDAO.getLoginByUsername(username);

        if (login != null && login.getPassword().equals(password)) {
            // Redirect to a success page
            request.setAttribute("message", "Login successful!");
            request.getRequestDispatcher("login.jsp").forward(request, response);
        } else {
            // Redirect to the login page with an error message
            request.setAttribute("message", "Login failed. Please check your username and password.");
            request.getRequestDispatcher("login.jsp").forward(request, response);
        }
    }
}
```
# View - login.jsp
```
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>Login Page</title>
</head>
<body>
    <h2>Login Page</h2>
    <form action="LoginServlet" method="post">
        Username: <input type="text" name="username" required><br>
        Password: <input type="password" name="password" required><br>
        <input type="submit" value="Login">
    </form>
    <% 
        String message = (String) request.getAttribute("message");
        if (message != null) {
            out.println("<p>" + message + "</p>");
        }
    %>
</body>
</html>
```

## Add LoginServlet url mapping as "LoginServlet" to web.xml
```
<servlet>
  <servlet-name>LoginServlet</servlet-name>
  <servlet-class>com.klef.LoginServlet</servlet-class>
</servlet>
<servlet-mapping>
  <servlet-name>LoginServlet</servlet-name>
  <url-mapping>/LoginServlet</url-mapping>
</servlet-mapping>
```
