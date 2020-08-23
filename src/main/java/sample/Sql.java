package sample;
import javafx.scene.Scene;

import javax.xml.catalog.Catalog;
import java.sql.*;
import java.util.ArrayList;


public class Sql{
protected Connection sqlConnection() {
    String connectionUrl =
                "jdbc:sqlserver://YASEEN\\WANHEDA;"
                        + "databaseName=ATM_MANAGEMENT;";
    String user="sa";
    String password="SilverNitrate!";
    Connection connection=null;
    try {
            connection = DriverManager.getConnection(connectionUrl,user,password);
    }
    catch (SQLException e) {
        e.printStackTrace();
        System.out.println(e);
    }
    return connection;
}
    protected String[] logIn(String userName,String password){
            String Sql ="Select * From onlineBanking where userName=? AND password=?";
        System.out.println("The Sql query used is : " + Sql);
            try{
                Connection conn=this.sqlConnection();
                PreparedStatement pstmt=conn.prepareStatement(Sql);
                pstmt.setString(1,userName);
                pstmt.setString(2,password);
                ResultSet rs=pstmt.executeQuery();
                String userName1=null,emailAddress=null;
                int id=0;
                while (rs.next()) {
                   userName1=rs.getString("userName");
                   emailAddress=rs.getString("emailId");
                   id=rs.getInt("id");
                }
                if(id>1) {
                    String array[] = new String[3];
                    array[0] = userName1;
                    array[1] = emailAddress;
                    array[2] = Integer.toString(id);

                    return array;
                }
            }
            catch (Exception e){
                System.out.println(e.getMessage());
            }
            return null;
    }

    protected Customer fetchCustomer(int uid){
            String sql="Select c.FirstName,c.LastName,c.cnic,c.balance,c.id,c.branchId,c.account_NO,c.pincode, o.password as passwords from Customer c \n" +
                    "inner join onlineBanking o on o.id=c.id where c.id=?;";
            System.out.println("The Sql query used is : " + sql);
            try{
                Connection conn=this.sqlConnection();
                PreparedStatement pstmt=conn.prepareStatement(sql);
                pstmt.setInt(1,uid);
                ResultSet rs=pstmt.executeQuery();
                String FirstName=null,LastName=null,password=null;
                long cnic=0,accountNo=0;
                int pincode=0,branchId=0;
                float balance=0;
                while (rs.next()){
                    FirstName=rs.getString("FirstName");
                    LastName=rs.getString("LastName");
                    cnic=rs.getLong("cnic");
                    balance=rs.getFloat("balance");
                    accountNo=rs.getLong("account_No");
                    pincode=rs.getInt("pincode");
                    branchId=rs.getInt("branchId");
                    password=rs.getString("passwords");
                }
                Customer customer=new Customer();
                customer.setAccountNo(accountNo);
                customer.setBalance(balance);
                customer.setBranchId(branchId);
                customer.setCnic(cnic);
                customer.setFirstName(FirstName);
                customer.setLastName(LastName);
                customer.setPinCode(pincode);
                customer.setPassword(password);
                System.out.println("Customer password is" + password);
                return customer;
            }
            catch (Exception e){
                System.out.println(e.getMessage());
            }
            return null;
    }
    protected void insertBranch(int branchCode,String branchName,String branchAddress,int branchZipCode,double branchAmount,int no_of_employees){
            String sql="Insert into Branch Values(?,?,?,?,?,?)";
        try{
                Connection conn=this.sqlConnection();
                PreparedStatement preparedStatement=conn.prepareStatement(sql);
                preparedStatement.setInt(1,branchCode);
                preparedStatement.setString(2, branchName);
                preparedStatement.setString(3,branchAddress);
                preparedStatement.setInt(4,branchZipCode);
                preparedStatement.setDouble(5,branchAmount);
                preparedStatement.setInt(6,no_of_employees);
                preparedStatement.executeUpdate();
                conn.close();
        }
        catch (Exception e){
            System.out.println(e.getMessage());
        }
    }
    protected void insertCustomer(String FirstName,String LastName,long cnic,double balance,int userId,int branchId,long accountNo,int pincode){
        String sql="Insert into Customer Values(?,?,?,?,?,?,?,?)";
        System.out.println("The Sql query used is : " + sql);
        try{
            Connection conn=this.sqlConnection();
            PreparedStatement preparedStatement=conn.prepareStatement(sql);
            preparedStatement.setString(1,FirstName);
            preparedStatement.setString(2,LastName);
            preparedStatement.setLong(3,cnic);
            preparedStatement.setDouble(4,balance);
            preparedStatement.setInt(5,userId);
            preparedStatement.setInt(6,branchId);
            preparedStatement.setLong(7,accountNo);
            preparedStatement.setInt(8,pincode);
            preparedStatement.executeUpdate();
            conn.close();
        }
        catch (Exception e){
            System.out.println(e.getMessage());
        }
    }

    protected void insertOnlineBanking(int userId,String email,String password,String userName){
        String sql="Insert into onlineBanking Values (?,?,?,?)";
        System.out.println(" The Sql query usd is : " + sql);
        try{
            Connection conn=this.sqlConnection();
            PreparedStatement preparedStatement=conn.prepareStatement(sql);
            preparedStatement.setInt(1,userId);
            preparedStatement.setString(2,email);
            preparedStatement.setString(3,password);
            preparedStatement.setString(4,userName);
            preparedStatement.executeUpdate();
            conn.close();
        }
        catch(Exception e){
            System.out.println(e.getMessage());
        }
    }

    protected void insertTransactions(int userId,int transactionId,double transactionAmount,String typeOfTransaction,long recipientAccount,Date date){
        String sql="Insert into Transactions Values(?,?,?,?,?,?)";
        System.out.println(" The Sql query usd is : " + sql);
        try{
             Connection conn=this.sqlConnection();
             PreparedStatement pstmt=conn.prepareStatement(sql);
             pstmt.setInt(1,userId);
             pstmt.setInt(2,transactionId);
             pstmt.setDouble(3,transactionAmount);
             pstmt.setString(4,typeOfTransaction);
             pstmt.setLong(5,recipientAccount);
             pstmt.setDate(6,date);
             pstmt.executeUpdate();
             conn.close();
        }
        catch (Exception e){
            System.out.println(e.getMessage());
        }
    }

    protected int getUserId(long accountNo){
        String sql="Select id from Customer where account_No=?";
        System.out.println(" The Sql query usd is : " + sql);
        try{
            Connection conn=this.sqlConnection();
            PreparedStatement preparedStatement=conn.prepareStatement(sql);
            preparedStatement.setLong(1,accountNo);
            ResultSet rs=preparedStatement.executeQuery();
            int userId=0;
            while (rs.next()){
                userId=rs.getInt("id");
            }
            return userId;
        }
        catch (Exception e){
            System.out.println(e.getMessage());
        }
        return 0;
    }

    protected void employee(int employeeId,String employeeName,String employeeDesignation,double employeeSalary,long employeeCnic,String employeeAddress,int employeeZipCode,int branchId){
            String sql="Insert into Employee Values(?,?,?,?,?,?,?,?)";
            try {
                Connection conn=this.sqlConnection();
                PreparedStatement pstmt=conn.prepareStatement(sql);
                pstmt.setInt(1,employeeId);
                pstmt.setString(2,employeeName);
                pstmt.setString(3,employeeDesignation);
                pstmt.setDouble(4,employeeSalary);
                pstmt.setLong(5,employeeCnic);
                pstmt.setString(6,employeeAddress);
                pstmt.setInt(7,employeeZipCode);
                pstmt.setInt(8,branchId);
                pstmt.executeUpdate();
                conn.close();
            }
            catch (Exception e){
                System.out.println(e.getMessage());
            }
    }


    protected ArrayList<Transactions> showTransaction(int uId){
        String sql="Select * from Transactions Where id=?";
        System.out.println(" The Sql query usd is : " + sql);
        ArrayList<Transactions> transactionsArray=new ArrayList<>();
        try{
            Connection connection=this.sqlConnection();
            PreparedStatement pstmt=connection.prepareStatement(sql);
            pstmt.setInt(1,uId);
            ResultSet rs=pstmt.executeQuery();
            while (rs.next()) {
                Transactions transactions = new Transactions();
                transactions.setUid(rs.getInt("id"));
                transactions.setTransactionId(rs.getInt("transactionId"));
                transactions.setTransactionAmount(rs.getDouble("transactionAmount"));
                transactions.setTypeOfTransaction(rs.getString("typeOfTransaction"));
                transactions.setTransactionDate(rs.getDate("transactionDate"));
                transactions.setRecipientAccountNo(rs.getLong("transactionFrom"));
                String fullName=this.getFullName(transactions.getRecipientAccountNo());
                transactions.setFullName(fullName);
                transactionsArray.add(transactions);
            }
            connection.close();
            return transactionsArray;
        }
        catch (Exception e){
            System.out.println(e.getMessage());
        }
        return null;
    }

    protected void changePinCode(int uId,int newPincode){
    String Sql="Update Customer Set pincode = ? where id = ?";
        System.out.println(" The Sql query usd is : " + Sql);
    try{
        Connection conn=this.sqlConnection();
        PreparedStatement pstmt=conn.prepareStatement(Sql);
        pstmt.setInt(1,newPincode);
        pstmt.setInt(2,uId);
        pstmt.executeUpdate();
        conn.close();
    }
    catch (Exception e){
        System.out.println(e.getMessage());
    }
    }
    protected void updateBalanceOnTransaction_Withdraw(long account_No,double amount){
        String Sql="Exec dbo.Withdraw ?,?";
        System.out.println(" The Sql query usd is : " + Sql);
        try{
            Connection conn=this.sqlConnection();
            PreparedStatement pstmt=conn.prepareStatement(Sql);
            pstmt.setEscapeProcessing(true);
            pstmt.setQueryTimeout(90);
            pstmt.setLong(1,account_No);
            pstmt.setDouble(2,amount);
            pstmt.executeUpdate();
            conn.close();
        }
        catch (Exception e){
            System.out.println(e.getMessage());
        }
    }
    protected void updateBalanceOnTransaction_Deposit(long accountNo,double amount){
        String Sql = "Exec dbo.Deposit ?,?";
        System.out.println(" The Sql query usd is : " + Sql);
        try{
            Connection connection=this.sqlConnection();
            PreparedStatement pstmt=connection.prepareStatement(Sql);
            pstmt.setEscapeProcessing(true);
            pstmt.setQueryTimeout(90);
            pstmt.setLong(1,accountNo);
            pstmt.setDouble(2,amount);
            pstmt.executeUpdate();
            connection.close();
        }
        catch (Exception e) {
            System.out.println(e.getMessage());
            System.out.println("EXCEPTION OCCURED");
        }
    }

    protected String getFullName(long account_No){
            String sql="Select FirstName,LastName From Customer Where account_NO=?";
        System.out.println(" The Sql query usd is : " + sql);
            try{
                Connection conn=this.sqlConnection();
                PreparedStatement pstmt=conn.prepareStatement(sql);
                pstmt.setLong(1,account_No);
                ResultSet rs=pstmt.executeQuery();
                String fullName=null;
                while (rs.next()){
                    fullName=rs.getString("FirstName")+" "+rs.getString("LastName");
                    return fullName;
                }

            } catch (SQLException e) {
                e.printStackTrace();
            }
        return null;
    }

    protected void updatePassword(int uId,String newPassword){
        String sql="Update onlineBanking set password=? where id=?";
        System.out.println(" The Sql query usd is : " + sql);
        try {
            Connection conn=this.sqlConnection();
            PreparedStatement pstmt=conn.prepareStatement(sql);
            pstmt.setString(1,newPassword);
            pstmt.setInt(2,uId);
            pstmt.executeUpdate();
            conn.close();
        }
        catch (Exception e){
            e.printStackTrace();
        }
    }

    protected Customer accountValidation(long accountNo){
       String sql="Select * From Customer where account_No=?";
        System.out.println(" The Sql query usd is : " + sql);
       try{
           Connection conn=this.sqlConnection();
           PreparedStatement pstmt=conn.prepareStatement(sql);
           pstmt.setLong(1,accountNo);
           ResultSet rs=pstmt.executeQuery();
           if(rs.next()==false){
               System.out.println("Empty");
           }
           else {
               do{
                   Customer customer=new Customer();
                   customer.setFirstName(rs.getString("FirstName"));
                   customer.setLastName(rs.getString("LastName"));
                   customer.setAccountNo(accountNo);
                   return customer;
               }while (rs.next());
           }
       }
       catch (Exception e){
           System.out.println(e.getMessage());
       }
       return null;
    }

}

