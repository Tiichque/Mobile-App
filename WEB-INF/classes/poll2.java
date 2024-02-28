
//clicker/servlet. CHOICE A
import java.io.*;
import java.sql.*;
import jakarta.servlet.*;             // Tomcat 10
import jakarta.servlet.http.*;
import jakarta.servlet.annotation.*;


@WebServlet("/poll2")   // Configure the request URL for this servlet (Tomcat 7/Servlet 3.0 upwards)
public class poll2 extends HttpServlet {

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
        out.println("<title>Question 2</title>");
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
        int optionA = 0;
        int optionB = 0;
        int optionC = 0;
        int optionD = 0;


        String respond[] = new String[500];
        int number[] = new int[500];
         // Step 3: Execute a SQL SELECT query

       String poll = "SELECT choice, COUNT(*) FROM response WHERE questionNo = 2 GROUP BY choice";
        ResultSet rset = stmt.executeQuery(poll);  
        int count=0;       // Send the query to the server

         //Bar chart generation//

        while (rset.next()){

            respond[count] = rset.getString(1);
            number[count] = rset.getInt(2);
            if(respond[count].indexOf('a')>-1)
            {
                optionA = number[count];
            }
            if(respond[count].indexOf('b')>-1)
            {
                optionB = number[count];
            }
            if(respond[count].indexOf('c')>-1)
            {
                optionC = number[count];
            }
            if(respond[count].indexOf('d')>-1)
            {
                optionD = number[count];
            }
            ++count;
        }

        out.println("<script src='https://cdnjs.cloudflare.com/ajax/libs/Chart.js/2.5.0/Chart.min.js'></script><body><canvas id='myChart' style='width:100%;max-width:600px'></canvas>");
        out.println("<script> var xValues = ['A','B','C','D',''];");
        out.println("var yValues = ['"+ optionA +"', '"+ optionB +"', '"+ optionC +"', '"+ optionD +"',0];");
        out.println("var barColors = ['red', 'red','red','blue'];");
        out.println("new Chart('myChart', { type: 'bar', data: { labels: xValues, datasets: [{ backgroundColor: barColors, data: yValues }] },");
        out.println("options: { legend: {display: false}, title: { display: true, text: 'Question 2'} } }); </script></body>");
        out.println("<a href='/clicker/poll3'>Continue to review</a><br><br>");
         //end bar chart generation

      } catch(Exception ex) {
         out.println("<p>Error: " + ex.getMessage() + "</p>");
         out.println("<p>Check Tomcat console for details.</p>");
         ex.printStackTrace();
      }  // Step 5: Close conn and stmt - Done automatically by try-with-resources (JDK 7)
 

   }
}