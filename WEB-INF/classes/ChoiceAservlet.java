//clicker/servlet.
import java.io.*;
import java.sql.*;
import jakarta.servlet.*;             // Tomcat 10
import jakarta.servlet.http.*;
import jakarta.servlet.annotation.*;
//import javax.servlet.*;             // Tomcat 9
//import javax.servlet.http.*;
//import javax.servlet.annotation.*;

@WebServlet("/select")   // Configure the request URL for this servlet (Tomcat 7/Servlet 3.0 upwards)
public class ChoiceAservlet extends HttpServlet {

   // The doGet() runs once per HTTP GET request to this servlet.
   @Override
   public void doGet(HttpServletRequest request, HttpServletResponse response)
               throws ServletException, IOException {
      // Set the MIME type for the response message
      response.setContentType("text/html");
      // Get a output writer to write the response message into the network socket
      PrintWriter out = response.getWriter();

      // Print an HTML page as the output of the query
        out.println("<html>");
        out.println("<head>");
        out.println("<title>KEK</title>");
        out.println("</head>");
        out.println("<body>");
        out.println("<div>");
        out.println("<!DOCTYPE html>");
        out.println("<html style=\"font-size: 16px;\" lang=\"en\"><head>");
        out.println("<meta name=\"viewport\" content=\"width=device-width, initial-scale=1.0\">");
        out.println("<meta charset=\"utf-8\">");
        out.println("<meta name=\"keywords\" content=\"​Where Can I Camp?\">");
        out.println("<meta name=\"description\" content=\"\">");
        out.println("<title>Home</title>");
        out.println("<link rel=\"stylesheet\" href=\"nicepage.css\" media=\"screen\">");
        out.println("<link rel=\"stylesheet\" href=\"Home.css\" media=\"screen\">");
        out.println("<script class=\"u-script\" type=\"text/javascript\" src=\"jquery.js\" defer=\"\"></script>");
        out.println("<script class=\"u-script\" type=\"text/javascript\" src=\"nicepage.js\" defer=\"\"></script>");
        out.println("<meta name=\"generator\" content=\"Nicepage 5.7.9, nicepage.com\">");
        out.println("<link id=\"u-theme-google-font\" rel=\"stylesheet\" href=\"https://fonts.googleapis.com/css?family=Roboto:100,100i,300,300i,400,400i,500,500i,700,700i,900,900i|Open+Sans:300,300i,400,400i,500,500i,600,600i,700,700i,800,800i\">");
        out.println("<meta name=\"theme-color\" content=\"#478ac9\">");
        out.println("<meta property=\"og:title\" content=\"Home\">");
        out.println("<meta property=\"og:type\" content=\"website\">");
        out.println("<meta data-intl-tel-input-cdn-path=\"intlTelInput/\"></head>");
        out.println("<body data-home-page=\"Home.html\" data-home-page-title=\"Home\" class=\"u-body u-xl-mode\" data-lang=\"en\">");
        out.println("<header class=\"u-clearfix u-header u-header\" id=\"sec-ed9a\"><div class=\"u-clearfix u-sheet u-valign-middle u-sheet-1\">");
        out.println("<a href=\"index.html\" class=\"u-image u-logo u-image-1\">");
        out.println("<img src=\"images/logo.png\" class=\"u-logo-image u-logo-image-1\">");
        out.println("</a>");
        out.println("<nav class=\"u-menu u-menu-dropdown u-offcanvas u-menu-1\">");
         out.println("<div class=\"menu-collapse\" style=\"font-size: 1rem; letter-spacing: 0px;\">");
         out.println("<a class=\"u-button-style u-custom-left-right-menu-spacing u-custom-padding-bottom u-custom-top-bottom-menu-spacing u-nav-link u-text-active-palette-1-base u-text-hover-palette-2-base\" href=\"#\">");
        out.println("<svg class=\"u-svg-link\" viewBox=\"0 0 24 24\"><use xmlns:xlink=\"http://www.w3.org/1999/xlink\" xlink:href=\"#menu-hamburger\"></use></svg>");
        out.println("<svg class=\"u-svg-content\" version=\"1.1\" id=\"menu-hamburger\" viewBox=\"0 0 16 16\" x=\"0px\" y=\"0px\" xmlns:xlink=\"http://www.w3.org/1999/xlink\" xmlns=\"http://www.w3.org/2000/svg\"><g><rect y=\"1\" width=\"16\" height=\"2\"></rect><rect y=\"7\" width=\"16\" height=\"2\"></rect><rect y=\"13\" width=\"16\" height=\"2\"></rect></g></svg>");
        out.println("</g></svg>");
        out.println("</a>");
         out.println("</div>");
         out.println("<div class=\"u-nav-container\">");
         out.println("<ul class=\"u-nav u-unstyled u-nav-1\"><li class=\"u-nav-item\"><a class=\"u-button-style u-nav-link u-text-active-palette-1-base u-text-hover-palette-2-base\" href=\"index.html\" style=\"padding: 10px 20px;\">Home</a>");
         out.println("</ul>");
         out.println("</div>");
         out.println("<div class=\"u-nav-container-collapse\">");
         out.println("<div class=\"u-black u-container-style u-inner-container-layout u-opacity u-opacity-95 u-sidenav\">");
         out.println("<div class=\"u-inner-container-layout u-sidenav-overflow\">");
         out.println("<div class=\"u-menu-close\"></div>");
         out.println("<ul class=\"u-align-center u-nav u-popupmenu-items u-unstyled u-nav-2\"><li class=\"u-nav-item\"><a class=\"u-button-style u-nav-link\" href=\"/Home.html\">Home</a></ul>");
         out.println("</div>");
         out.println("</div>");
         out.println("<div class=\"u-black u-menu-overlay u-opacity u-opacity-70\"></div>");
         out.println("</div>");
         out.println("</nav>");
         out.println("</div></header>");
         
        


      try (
         // Step 1: Allocate a database 'Connection' object
         Connection conn = DriverManager.getConnection(
               "jdbc:mysql://localhost:3306/webapp?allowPublicKeyRetrieval=true&useSSL=false&serverTimezone=UTC",
               "myuser", "xxxx");   // For MySQL
               // The format is: "jdbc:mysql://hostname:port/databaseName", "username", "password"

         // Step 2: Allocate a 'Statement' object in the Connection
         Statement stmt = conn.createStatement();
      ) {
         // Step 3: Execute a SQL SELECT query
         String choice = request.getParameter("choice");
         String sqlStr = "INSERT INTO response (questionNo, choice, userID) VALUES (" + request.getParameter("questionNo") + ", " + "'" + choice + "'" + ", " + "'" + request.getParameter("userID") + "')";
         String poll = "SELECT choice, COUNT(*) FROM response GROUP BY choice";

         out.println("<h3>You have selected " + request.getParameter("choice") + "</h3>");
         
         int count = stmt.executeUpdate(sqlStr);  // Send the query to the server
         ResultSet rset = stmt.executeQuery(poll);
         
         // Step 4: Process the query result set
         out.println("<p>==== " + count + " records updated =====</p>");
         //out.println("<p>" + rset + "</p>"); 

         /* while(rset.next()) {
            
            out.println("<input type='checkbox' name='id' value="
                  + "'" + rset.getString("id") + "' />"
                  + rset.getString("author") + ", "
                  + rset.getString("title") + ", $"
                  + rset.getString("price"));
         } */

         out.println("<footer class=\"u-align-center u-clearfix u-footer u-grey-80 u-footer\" id=\"sec-e92a\">");
         out.println("</footer>");
         out.println("</body></html>");

      } catch(Exception ex) {
         out.println("<p>Error: " + ex.getMessage() + "</p>");
         out.println("<p>Check Tomcat console for details.</p>");
         ex.printStackTrace();
      }  // Step 5: Close conn and stmt - Done automatically by try-with-resources (JDK 7)
 

   }
}