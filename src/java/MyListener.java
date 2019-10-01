import java.sql.Connection;
import java.sql.DriverManager;
import javax.servlet.ServletContext;
import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;

public class MyListener implements ServletContextListener {

    Connection con;
    
    @Override
    public void contextInitialized(ServletContextEvent sce) {
        try{
            Class.forName("com.mysql.jdbc.Driver");
            con=DriverManager.getConnection("jdbc:mysql://localhost:3306/ecomdata", "root", "root");
            ServletContext context=sce.getServletContext();
            context.setAttribute("data", con);
            System.out.println("Connection Established ........ ");
        }catch(Exception e){
            e.printStackTrace();
        }
    }

    @Override
    public void contextDestroyed(ServletContextEvent sce) {
        try{
            con.close();
            System.out.println("Connection Closed.............");
        }catch(Exception e){
            e.printStackTrace();
        }
    }
}
