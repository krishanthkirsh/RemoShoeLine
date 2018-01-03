/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
*/

package mysql_conn;

/**
 *
 * @author Homepc
 */
import java.sql.*;
import java.util.ArrayList;
import javax.swing.JOptionPane;

public class Mysqlconn {
    
    private final String dbURL = "jdbc:mysql://localhost:3306/itp?user=root&password=";
    private final String jdbcDriver = "com.mysql.jdbc.Driver";

    private Connection connect = null;
    private Statement statement = null;
    private ResultSet resultSet = null;
    private String MySQLQuery;

    public boolean addvehicle(String query) {
        try {
            try {
                // this will load the MySQL driver, each DB has its own driver
                Class.forName(this.jdbcDriver).newInstance();
            } catch (InstantiationException ex) {
                System.out.println("InstantiationException in addvehicle method");
                System.out.println(ex.getMessage());
            } catch (IllegalAccessException ex) {
                System.out.println("IllegalAccessException in addvehicle method");
                System.out.println(ex.getMessage());
            }

            // setup the connection with the DB.
            connect = DriverManager.getConnection(this.dbURL);

            // statements allow to issue SQL queries to the database
            statement = connect.createStatement();

            // resultSet gets the result of the SQL query
            statement.executeUpdate(query);
            connect.close();
            return true;

        } catch (SQLException ex) {
            //Handle errors for JDBC
            System.out.println("SQLException");
            System.out.println(ex.getMessage());
            JOptionPane.showMessageDialog(null, ex.getMessage(), "SQL Exception Error", 0);
        } catch (ClassNotFoundException e) {
            //Handle errors for Class.forName
            System.out.println("ClassNotFoundException in addItem method");
            System.out.println(e.getMessage());
        } //finally {
        //  this.close();
        //   }
        return false;
    }
        public ResultSet getDataa(String query)
    {
          try{
            connect = DriverManager.getConnection(this.dbURL);
            statement = connect.createStatement();
            resultSet=statement.executeQuery(query);
             }
        catch(SQLException se){
            System.out.println(se+" Can't get data");
            
        }
        return resultSet; 
    }
        
        
   public boolean addDrivers(String query) {
        try {
            try {
                // this will load the MySQL driver, each DB has its own driver
                Class.forName(this.jdbcDriver).newInstance();
            } catch (InstantiationException ex) {
                System.out.println("InstantiationException in addvehicle method");
                System.out.println(ex.getMessage());
            } catch (IllegalAccessException ex) {
                System.out.println("IllegalAccessException in addvehicle method");
                System.out.println(ex.getMessage());
            }

            // setup the connection with the DB.
            connect = DriverManager.getConnection(this.dbURL);

            // statements allow to issue SQL queries to the database
            statement = connect.createStatement();

            // resultSet gets the result of the SQL query
            statement.executeUpdate(query);
            connect.close();
            return true;

        } catch (SQLException ex) {
            //Handle errors for JDBC
            System.out.println("SQLException");
            System.out.println(ex.getMessage());
            JOptionPane.showMessageDialog(null, ex.getMessage(), " SQL Exception Error", 0);
        } catch (ClassNotFoundException e) {
            //Handle errors for Class.forName
            System.out.println("ClassNotFoundException in addItem method");
            System.out.println(e.getMessage());
        } //finally {
        //  this.close();
        //   }
        return false;
    }

    public void close() {
        try {
            resultSet.close();
            connect.close();
            statement.close();
        } catch (SQLException e) {
            System.out.println("SQLException in MySQLAccess close method");
            System.out.println(e.getMessage());
        }
        //throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
 public boolean update(String query) {
        try {
            try {
                // this will load the MySQL driver, each DB has its own driver
                Class.forName(this.jdbcDriver).newInstance();
            } catch (InstantiationException ex) {
                System.out.println("InstantiationException in addvehicle method");
                System.out.println(ex.getMessage());
            } catch (IllegalAccessException ex) {
                System.out.println("IllegalAccessException in addvehicle method");
                System.out.println(ex.getMessage());
            }

            // setup the connection with the DB.
            connect = DriverManager.getConnection(this.dbURL);

            // statements allow to issue SQL queries to the database
            statement = connect.createStatement();

            // resultSet gets the result of the SQL query
            statement.executeUpdate(query);
            connect.close();
            return true;

        } catch (SQLException ex) {
            //Handle errors for JDBC
            System.out.println("SQLException");
            System.out.println(ex.getMessage());
            JOptionPane.showMessageDialog(null, ex.getMessage(), "SQL Exception Error", 0);
        } catch (ClassNotFoundException e) {
            //Handle errors for Class.forName
            System.out.println("ClassNotFoundException in addItem method");
            System.out.println(e.getMessage());
        } //finally {
        //  this.close();
        //   }
        return false;
    }
    public boolean validatevehiclenumber(String query) {
        boolean temp;
        try {
            try {
                // this will load the MySQL driver, each DB has its own driver
                Class.forName(this.jdbcDriver).newInstance();
            } catch (InstantiationException ex) {
                System.out.println("InstantiationException in validatevehiclenumber method");
                System.out.println(ex.getMessage());
            } catch (IllegalAccessException ex) {
                System.out.println("IllegalAccessException in validatevehiclenumber method");
                System.out.println(ex.getMessage());
            }

            // setup the connection with the DB.
            connect = DriverManager.getConnection(this.dbURL);

            // statements allow to issue SQL queries to the database
            statement = connect.createStatement();

            // resultSet gets the result of the SQL query
            resultSet = statement.executeQuery(query);

            resultSet.next();
            temp = (resultSet.getInt(1) == 1);
            this.close();
            return temp;

        } catch (SQLException ex) {
            //Handle errors for JDBC
            System.out.println("SQLException in validatevehiclenumber method");
            System.out.println(ex.getMessage());
        } catch (ClassNotFoundException e) {
            //Handle errors for Class.forName
            System.out.println("ClassNotFoundException in validatevehiclenumber method");
            System.out.println(e.getMessage());
        } finally {
            this.close();
        }
        return false;
    }
    
     public ArrayList getvehiclenumber() {

        ArrayList CatList = null;
      

        try {
            // setup the connection with the DB.
            connect = DriverManager.getConnection(this.dbURL);

            // statements allow to issue SQL queries to the database
            statement = connect.createStatement();

            //Select the vehicleNumber
            String query = "SELECT vehicle_No FROM vehicle";

            resultSet = statement.executeQuery(query);

           CatList = new ArrayList();

            while (resultSet.next()) {
                String catName = resultSet.getString(1);
                System.out.println(catName);
                CatList.add(catName);
            }

        } catch (SQLException sQLException) {
            System.out.println(sQLException + "-----------Select query failed at JobCatNames");
        } finally {
            //Close the db connection
            this.close();
        }
        return CatList;
    }
    public ResultSet getSelectResultSet(String query) {
        try {
            try {
                // this will load the MySQL driver, each DB has its own driver
                Class.forName(this.jdbcDriver).newInstance();
            } catch (InstantiationException ex) {
                System.out.println("InstantiationException");
                System.out.println(ex.getMessage());
            } catch (IllegalAccessException ex) {
                System.out.println("IllegalAccessException");
                System.out.println(ex.getMessage());
            }

            // setup the connection with the DB.
            connect = DriverManager.getConnection(this.dbURL);

            // statements allow to issue SQL queries to the database
            statement = connect.createStatement();

            // resultSet gets the result of the SQL query
            resultSet = statement.executeQuery(query);

            return resultSet;

        } catch (SQLException ex) {
            //Handle errors for JDBC
            System.out.println("SQLException");
            System.out.println(ex.getMessage());
        } catch (ClassNotFoundException e) {
            //Handle errors for Class.forName
            System.out.println("ClassNotFoundException");
            System.out.println(e.getMessage());
        } //finally {
        //  this.close();
        //   }
        return null;
    }
    
    //vehicleState
    
     public boolean vehicleState(String query) {
        boolean temp;
        try {
            try {
                // this will load the MySQL driver, each DB has its own driver
                Class.forName(this.jdbcDriver).newInstance();
            } catch (InstantiationException ex) {
                System.out.println("InstantiationException in validatevehiclenumber method");
                System.out.println(ex.getMessage());
            } catch (IllegalAccessException ex) {
                System.out.println("IllegalAccessException in validatevehiclenumber method");
                System.out.println(ex.getMessage());
            }

            // setup the connection with the DB.
            connect = DriverManager.getConnection(this.dbURL);

            // statements allow to issue SQL queries to the database
            statement = connect.createStatement();

            // resultSet gets the result of the SQL query
            resultSet = statement.executeQuery(query);

            resultSet.next();
            temp = (resultSet.getInt(1) == 1);
            this.close();
            return temp;

        } catch (SQLException ex) {
            //Handle errors for JDBC
            System.out.println("SQLException in validatevehiclenumber method");
            System.out.println(ex.getMessage());
        } catch (ClassNotFoundException e) {
            //Handle errors for Class.forName
            System.out.println("ClassNotFoundException in validatevehiclenumber method");
            System.out.println(e.getMessage());
        } finally {
            this.close();
        }
        return false;
    }
     
     
     
     public ArrayList getid() {

        ArrayList CatList = null;
      

        try {
            // setup the connection with the DB.
            connect = DriverManager.getConnection(this.dbURL);

            // statements allow to issue SQL queries to the database
            statement = connect.createStatement();

            //Select the vehicleNumber
            String query = "select max(ve_Maintains_ID) from vehiclemaintains";

            resultSet = statement.executeQuery(query);

           CatList = new ArrayList();

            while (resultSet.next()) {
                String catName = resultSet.getString(1);
                System.out.println(catName);
                CatList.add(catName);
            }

        } catch (SQLException sQLException) {
            System.out.println(sQLException + "-----------Select query failed at JobCatNames");
        } finally {
            //Close the db connection
            this.close();
        }
        return CatList;
    }
     
 
}
