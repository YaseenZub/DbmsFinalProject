package sample;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.security.spec.ECField;
import java.sql.SQLOutput;
import java.util.ArrayList;

public class Gui implements ActionListener {
        JFrame startup,logIn,signUp,dashBoard,transactionFrame,transferMoneyFrame,withDrawFrame;
        JButton logIn_button,signUp_button,logIn_button1,signUp_button1;
        JButton changePassword,changePinCode,transferMoney,transaction,sendMoney,withDrawButton;
        JButton backFromTransfer;
        TextFormatter recipientAccount,sendAmount,cnic_input,firstDeposit_input;
        Password pinCode_input;
        ArrayList<Transactions> transactions=new ArrayList<>();
        JLabel balance;
        JTextField firstName_input,lastName_input,email_input;
        JButton backFromTransaction,backFromSignUp,backFromLogin,signOut;
        JPasswordField pinCode,passwordField;
        Sql sqlObj=new Sql();
        int userId;
        JTextField userName,password;
        Customer customer,receiver;
        protected void setStartup(){
            startup=new JFrame();
            startup.setVisible(true);
            startup.setResizable(false);
            startup.setLayout(null);
            startup.setDefaultCloseOperation(3);
            startup.setSize(400,400);
            startup.getContentPane().setBackground(Color.CYAN);

            JLabel heading=new JLabel("Welcome to our Bank");
            heading.setBounds(100,100,200,50);
            heading.setFont(new Font("Calibri",Font.BOLD+Font.ITALIC,20));
            heading.setForeground(Color.GRAY);
            startup.add(heading);

            logIn_button=new JButton("LogIn");
            logIn_button.setBounds(80,160,90,30);
            logIn_button.setBackground(Color.WHITE);
            logIn_button.setForeground(Color.BLACK);
            logIn_button.setFont(new Font("Consolas",Font.ITALIC,15));
            startup.add(logIn_button);
            logIn_button.addActionListener(this);


            signUp_button=new JButton("SignUp");
            signUp_button.setBounds(205,160,90,30);
            signUp_button.setBackground(Color.WHITE);
            signUp_button.setForeground(Color.BLACK);
            signUp_button.setFont(new Font("Consolas",Font.ITALIC,15));
            startup.add(signUp_button);
            signUp_button.addActionListener(this);
        }

        protected void setLogIn(){
            logIn = new JFrame("Login");
            logIn.setVisible(true);
            logIn.setLayout(null);
            logIn.setDefaultCloseOperation(3);
            logIn.setResizable(false);
            logIn.setSize(400,400);
            logIn.getContentPane().setBackground(Color.CYAN);
            JLabel heading_login=new JLabel("LogIn");
            heading_login.setBounds(150,10,100,50);
            heading_login.setFont(new Font("Calibri",Font.ITALIC+Font.BOLD,40));
            logIn.add(heading_login);

            JLabel userName_login=new JLabel("Enter Username");
            userName_login.setBounds(30,65,200,20);
            userName_login.setFont(new Font("Consolas",Font.ITALIC ,20));
            logIn.add(userName_login);


            userName=new JTextField();
            userName.setBounds(30,95,200,30);
            userName.setFont(new Font("Consolas",Font.ITALIC ,20));
            logIn.add(userName);


            JLabel password_login=new JLabel("Enter Password");
            password_login.setBounds(30,135,200,20);
            password_login.setFont(new Font("Consolas",Font.ITALIC ,20));
            logIn.add(password_login);


            password=new JTextField();
            password.setBounds(30,165,200,30);
            password.setFont(new Font("Consolas",Font.ITALIC,20));
            logIn.add(password);

            logIn_button1=new JButton("Login");
            logIn_button1.setBounds(75,210,100,30);
            logIn_button1.setBackground(Color.WHITE);
            logIn_button1.setFont(new Font("Consolas",Font.ITALIC,15));
            logIn.add(logIn_button1);
            logIn_button1.addActionListener(this);

            backFromLogin=new JButton("Back");
            backFromLogin.setBounds(250,250,100,30);
            backFromLogin.setBackground(Color.WHITE);
            backFromLogin.setFont(new Font("Consolas",Font.BOLD,13));
            backFromLogin.addActionListener(this);
            logIn.add(backFromLogin);
        }
        protected void setSignUp(){
            signUp=new JFrame(" Sign up");
            signUp.setVisible(true);
            signUp.setDefaultCloseOperation(3);
            signUp.setLayout(null);
            signUp.setSize(400,650);
            signUp.setResizable(false);

            JLabel signUp_heading=new JLabel("Sign Up");
            signUp_heading.setBounds(100,10,200,40);
            signUp_heading.setFont(new Font("Consolas",Font.ITALIC+Font.BOLD,30));
            signUp.add(signUp_heading);


            JLabel firstName = new JLabel("First Name:");
            firstName.setBounds(20,70,100,20);
            firstName.setFont(new Font("Consolas",Font.BOLD,15));
            signUp.add(firstName);

            firstName_input=new JTextField();
            firstName_input.setBounds(125,70,150,20);
            firstName_input.setFont(new Font("Consolas",Font.BOLD,12));
            signUp.add(firstName_input);



            JLabel lastName = new JLabel("Last Name:");
            lastName.setBounds(20,110,100,20);
            lastName.setFont(new Font("Consolas",Font.BOLD,15));
            signUp.add(lastName);



            lastName_input=new JTextField();
            lastName_input.setBounds(125,110,150,20);
            lastName_input.setFont(new Font("Consolas",Font.BOLD,12));
            signUp.add(lastName_input);

            JLabel firstDeposit = new JLabel("Deposit:");
            firstDeposit.setBounds(20,150,100,20);
            firstDeposit.setFont(new Font("Consolas",Font.BOLD,15));
            signUp.add(firstDeposit);

            firstDeposit_input = new TextFormatter();
            firstDeposit_input.setBounds(125,150,150,20);
            firstDeposit_input.setFont(new Font("Consolas",Font.BOLD,15));
            firstDeposit_input.setMaxLength(12);
            firstDeposit_input.setPrecision(3);
            signUp.add(firstDeposit_input);

            JLabel cnic_no = new JLabel("Enter Cnic:");
            cnic_no.setBounds(20,190,100,20);
            cnic_no.setFont(new Font("Consolas",Font.BOLD,15));
            signUp.add(cnic_no);

            cnic_input = new TextFormatter();
            cnic_input.setBounds(125,190,150,20);
            cnic_input.setFont(new Font("Consolas",Font.BOLD,15));
            cnic_input.setPrecision(0);
            cnic_input.setAllowNegative(false);
            cnic_input.setMaxLength(13);
            signUp.add(cnic_input);

            JLabel email=new JLabel("Enter email:");
            email.setBounds(20,230,100,20);
            email.setFont(new Font("Consolas",Font.BOLD,15));
            signUp.add(email);

            email_input=new JTextField();
            email_input.setBounds(125,230,150,20);
            email_input.setFont(new Font("Consolas",Font.BOLD,15));
            signUp.add(email_input);


            JLabel password=new JLabel("Enter Password:");
            password.setBounds(20,270,100,20);
            password.setFont(new Font("Consolas",Font.BOLD,15));
            signUp.add(password);

            passwordField=new JPasswordField();
            passwordField.setBounds(125,270,150,20);
            passwordField.setFont(new Font("Consolas",Font.BOLD,15));
            signUp.add(passwordField);



            JLabel pincode=new JLabel("Enter Pincode");
            pincode.setBounds(20,310,100,20);
            pincode.setFont(new Font("Consolas",Font.BOLD,15));
            signUp.add(pincode);

            pinCode_input=new Password();
            pinCode_input.setBounds(125,310,150,20);
            pinCode_input.setFont(new Font("Consolas",Font.BOLD,15));
            signUp.add(pinCode_input);
            pinCode_input.setPrecision(0);
            pinCode_input.setAllowNegative(false);
            pinCode_input.setMaxLength(4);



            signUp_button1=new JButton("Next");
            signUp_button1.setBounds(150,340,100,30);
            signUp_button1.setFont(new Font("Consolas",Font.BOLD,15));
            signUp_button1.setBackground(Color.WHITE);
            signUp.add(signUp_button1);
            signUp_button1.addActionListener(this);

            backFromSignUp= new JButton("Back");
            backFromSignUp.setBounds(250,500,100,40);
            backFromSignUp.setBackground(Color.WHITE);
            backFromSignUp.setFont(new Font("Consolas",Font.BOLD,13));
            backFromSignUp.addActionListener(this);
            signUp.add(backFromSignUp);












        }
        protected void setDashBoard(int uid,Customer customer){
            dashBoard=new JFrame("dashboard");
            dashBoard.setVisible(true);
            dashBoard.setSize(700,400);
            dashBoard.setResizable(false);
            dashBoard.setDefaultCloseOperation(3);
            dashBoard.getContentPane().setBackground(Color.LIGHT_GRAY);
            dashBoard.setLayout(null);

            JLabel name = new JLabel(customer.getFirstName()+" "+customer.getLastName());
            name.setBounds(150,25,300,40);
            name.setFont(new Font("Consolas",Font.ITALIC+Font.BOLD,30));
            name.setForeground(Color.CYAN);
            dashBoard.add(name);

            balance=new JLabel(String.valueOf(customer.getBalance()));
            balance.setBounds(175,150,300,40);
            balance.setFont(new Font("Consolas",Font.ITALIC+Font.BOLD,30));
            balance.setForeground(Color.CYAN);
            dashBoard.add(balance);

            JLabel accountNo=new JLabel(String.valueOf(customer.getAccountNo()));
            accountNo.setBounds(220,190,200,30);
            accountNo.setFont(new Font("Consolas",Font.ITALIC,20));
            accountNo.setForeground(Color.CYAN);
            dashBoard.add(accountNo);

            changePassword=new JButton("Change Password");
            changePassword.setBounds(10,300,150,40);
            changePassword.setFont(new Font("Consolas",Font.ITALIC,12));
            changePassword.setBackground(Color.white);
            changePassword.setForeground(Color.BLACK);
            dashBoard.add(changePassword);
            changePassword.addActionListener(this);

            changePinCode=new JButton("Change PinCode");
            changePinCode.setBounds(170,300,150,40);
            changePinCode.setFont(new Font("Consolas",Font.ITALIC,12));
            changePinCode.setBackground(Color.white);
            changePinCode.setForeground(Color.BLACK);
            dashBoard.add(changePinCode);
            changePinCode.addActionListener(this);


            transferMoney = new JButton("Bank Transfer");
            transferMoney.setBounds(230,250,200,40);
            transferMoney.setFont(new Font("Consolas",Font.ITALIC,20));
            transferMoney.setBackground(Color.WHITE);
            transferMoney.setForeground(Color.BLACK);
            transferMoney.addActionListener(this);
            dashBoard.add(transferMoney);

            transaction=new JButton("Transactions");
            transaction.setBounds(330,300,150,40);
            transaction.setFont(new Font("Consolas",Font.ITALIC,12));
            transaction.setBackground(Color.white);
            transaction.setForeground(Color.BLACK);
            transaction.addActionListener(this);
            dashBoard.add(transaction);


            withDrawButton=new JButton("Withdraw");
            withDrawButton.setBounds(490,300,150,40);
            withDrawButton.setFont(new Font("Consolas",Font.ITALIC,12));
            withDrawButton.setBackground(Color.white);
            withDrawButton.setForeground(Color.BLACK);
            withDrawButton.addActionListener(this);
            dashBoard.add(withDrawButton);

            signOut=new JButton("Sign Out");
            signOut.setBounds(10,10,100,30);
            signOut.setFont(new Font("Consolas",Font.BOLD,13));
            signOut.setBackground(Color.WHITE);
            signOut.addActionListener(this);
            dashBoard.add(signOut);
        }
        protected void setTransactionFrame(){
            transactionFrame=new JFrame("Transactions");
            transactionFrame.setVisible(true);
            JTable table=new JTable(){
                @Override
                public boolean isCellEditable(int row, int column) {
                    return false;
                }
            };
            DefaultTableModel dtm=new DefaultTableModel(0,0);
            dtm.addColumn("S.No");
            dtm.addColumn("Amount");
            dtm.addColumn("Date");
            dtm.addColumn("Transaction with");
            dtm.addColumn("Type of Transaction");
            dtm.addColumn("Beneficiary Name");
            JScrollPane scrollPane=new JScrollPane(table);
            table.setModel(dtm);
            transactionFrame.setSize(700,600);
            transactions=sqlObj.showTransaction(userId);
            int i=transactions.size();
            int counter=0;

            for (int j=0;j<i;j++){
                Transactions transactionObject=transactions.get(j);

                    dtm.addRow(new Object[]{
                            ++counter,
                            transactionObject.getTransactionAmount(),
                            transactionObject.getTransactionDate(),
                            transactionObject.getRecipientAccountNo(),
                            transactionObject.getTypeOfTransaction(),
                            transactionObject.getFullName()
                    });


            }
            transactionFrame.add(scrollPane,BorderLayout.NORTH);
            backFromTransaction =new JButton("Back");
            backFromTransaction.addActionListener(this);
            transactionFrame.add(backFromTransaction,BorderLayout.SOUTH);
        }

        protected void setTransferMoneyFrame(){
            transferMoneyFrame=new JFrame("Transfer");
            transferMoneyFrame.setVisible(true);
            transferMoneyFrame.setLayout(null);
            transferMoneyFrame.setDefaultCloseOperation(3);
            transferMoneyFrame.setResizable(false);
            transferMoneyFrame.setSize(500,500);

            JLabel fullName=new JLabel(customer.getFirstName()+" "+customer.getLastName());
            fullName.setBounds(80,10,300,30);
            fullName.setFont(new Font("Consolas",Font.BOLD+Font.ITALIC,30));
            transferMoneyFrame.add(fullName);

            JLabel accountBalance=new JLabel(String.valueOf(customer.getBalance()));
            accountBalance.setBounds(150,45,160,20);
            accountBalance.setFont(new Font("Consolas",Font.PLAIN,18));
            transferMoneyFrame.add(accountBalance);

            JLabel recipientAccountNo=new JLabel("Enter Recipient Account No");
            recipientAccountNo.setBounds(20,80,300,30);
            recipientAccountNo.setFont(new Font("Segoe Script",Font.BOLD,18));
            transferMoneyFrame.add(recipientAccountNo);

            recipientAccount=new TextFormatter();
            recipientAccount.setMaxLength(12);
            recipientAccount.setPrecision(0);
            recipientAccount.setAllowNegative(false);
            recipientAccount.setBounds(20,120,300,30);
            recipientAccount.setFont(new Font("Segoe Script",Font.BOLD,15));
            transferMoneyFrame.add(recipientAccount);

            JLabel amount_to_transfer=new JLabel("Enter Amount");
            amount_to_transfer.setBounds(20,160,300,30);
            amount_to_transfer.setFont(new Font("Segoe Script",Font.BOLD,18));
            transferMoneyFrame.add(amount_to_transfer);

            sendAmount = new TextFormatter();
            sendAmount.setPrecision(2);
            sendAmount.setAllowNegative(false);
            sendAmount.setMaxLength(10);
            sendAmount.setBounds(20,200,300,30);
            sendAmount.setFont(new Font("Segoe Script",Font.BOLD,15));
            transferMoneyFrame.add(sendAmount);

            JLabel enter_pinCode=new JLabel("Enter PinCode");
            enter_pinCode.setBounds(20,240,300,30);
            enter_pinCode.setFont(new Font("Segoe Script",Font.BOLD,18));
            transferMoneyFrame.add(enter_pinCode);

            pinCode=new JPasswordField();
            pinCode.setBounds(20,280,300,30);
            transferMoneyFrame.add(pinCode);

            sendMoney=new JButton("Confirm");
            sendMoney.setForeground(Color.BLACK);
            sendMoney.setBackground(Color.WHITE);
            sendMoney.setBounds(140,320,100,30);
            sendMoney.setFont(new Font("Consolas",Font.BOLD,15));
            transferMoneyFrame.add(sendMoney);
            sendMoney.addActionListener(this);

            backFromTransfer =new JButton("Back <--");
            backFromTransfer.setBounds(350,400,100,50);
            backFromTransfer.setFont(new Font("Consolas",Font.BOLD,20));
            backFromTransfer.setBackground(Color.white);
            backFromTransfer.setForeground(Color.BLACK);
            transferMoneyFrame.add(backFromTransfer);
            backFromTransfer.addActionListener(this);
        }

    @Override
    public void actionPerformed(ActionEvent e) {
        if(e.getSource()==logIn_button){
            startup.getContentPane().removeAll();
            startup.removeAll();
            startup.dispose();
            setLogIn();
        }
        else if(e.getSource()==signUp_button){
            startup.getContentPane().removeAll();
            startup.removeAll();
            startup.dispose();
            setSignUp();
        }

        else if(e.getSource()==logIn_button1){
            String userName1=userName.getText();
            String password1=password.getText();

            String[] loggedUser=sqlObj.logIn(userName1,password1);
            try {
                int uid = Integer.parseInt(loggedUser[2]);
                userId=uid;
                if (uid>10){
                    logIn.getContentPane().removeAll();
                    logIn.removeAll();
                    logIn.dispose();
                    customer=sqlObj.fetchCustomer(uid);
                    setDashBoard(uid,customer);
                }
            }
            catch (NullPointerException error){
                System.out.println("Incorrect Password");
                System.out.println(error.getStackTrace());
            }
        }
        else if(e.getSource()==transaction){
            dashBoard.getContentPane().removeAll();
            dashBoard.removeAll();
            dashBoard.dispose();
            setTransactionFrame();
        }
        else if(e.getSource()==transferMoney){
            dashBoard.getContentPane().removeAll();
            dashBoard.removeAll();
            dashBoard.dispose();
            setTransferMoneyFrame();
        }

        else if(e.getSource()==sendMoney){
            long account=Long.parseLong(recipientAccount.getText());
            String pass=new String(pinCode.getPassword());
            float sendingAmount=Float.parseFloat(sendAmount.getText());

            if(Integer.parseInt(pass)==customer.getPinCode() && account!=customer.getAccountNo() && sendingAmount<customer.getBalance()){
                receiver=sqlObj.accountValidation(account);
                if(receiver!=null){
//                    System.out.println("Hello");
                    int input=JOptionPane.showConfirmDialog(null,"Confirm Transfer to " + receiver.getFirstName() +" "+receiver.getLastName() +" of" + sendingAmount+"Rs");
                    if(input==0){
                        sqlObj.updateBalanceOnTransaction_Deposit(account,sendingAmount);
                        sqlObj.updateBalanceOnTransaction_Withdraw(customer.accountNo,sendingAmount);
                        customer.setBalance(customer.getBalance()-sendingAmount);
                        String temp=Main.getRandomNumberString();
                        int transactionId=Integer.parseInt(temp);
                        sqlObj.insertTransactions(userId,transactionId,sendingAmount,"withdraw",receiver.getAccountNo(),Main.getDate());
                        JOptionPane.showMessageDialog(null,"Payment Sent to " +receiver.getFirstName()+" Your remaining balance is "+customer.getBalance());
                        temp=Main.getRandomNumberString();
                        transactionId=Integer.parseInt(temp);
                        int recipientUserId=sqlObj.getUserId(receiver.accountNo);
                        sqlObj.insertTransactions(recipientUserId,transactionId,sendingAmount,"deposit",customer.getAccountNo(),Main.getDate());
                    }


                }
            }


        }
        else if(e.getSource()==backFromTransfer){
            transferMoneyFrame.getContentPane().removeAll();
            transferMoneyFrame.removeAll();
            transferMoneyFrame.dispose();
            setDashBoard(userId,customer);
        }
        else if(e.getSource()==changePinCode){
            String pincode_input=JOptionPane.showInputDialog(dashBoard,"Enter Old PinCode");
            try{
                int pincode_int=Integer.parseInt(pincode_input);
                if (pincode_int == customer.getPinCode()) {
                     String newpincode_input=JOptionPane.showInputDialog(dashBoard,"Enter New Pincode");
                     int newpincode=Integer.parseInt(newpincode_input);
                     sqlObj.changePinCode(userId,newpincode);
                     JOptionPane.showMessageDialog(dashBoard,"Success");
                     customer.setPinCode(newpincode);
                }
                else{
                    JOptionPane.showMessageDialog(dashBoard,"Incorrect Pincode");
                }
            }
            catch(NumberFormatException error){
                JOptionPane.showMessageDialog(null,"Enter only numeric data");
            }
        }
        else if(e.getSource()==changePassword){
            String password_input=JOptionPane.showInputDialog(dashBoard,"Enter your current Password");
            System.out.println(customer.getPassword());
            if(password_input.equals(customer.getPassword())){
                String newPassword=JOptionPane.showInputDialog(dashBoard,"Enter new password");
                sqlObj.updatePassword(userId,newPassword);
                customer.setPassword(newPassword);
                JOptionPane.showMessageDialog(dashBoard,"Success");
            }
            else
                JOptionPane.showMessageDialog(dashBoard,"Incorrect Password");
        }
        else if(e.getSource()==transaction){
                setTransactionFrame();
        }

        else if(e.getSource()==withDrawButton){
            String withDrawInput=JOptionPane.showInputDialog(dashBoard,"Enter amount for withdrawal");
            try{
                float withDrawInput_int = Float.parseFloat(withDrawInput);
                if(withDrawInput_int < customer.getBalance()){
                    String pincode_input=JOptionPane.showInputDialog(dashBoard,"Enter your pin");
                    int pincode_validation=Integer.parseInt(pincode_input);
                    if(pincode_validation==customer.getPinCode()){
                        sqlObj.updateBalanceOnTransaction_Withdraw(customer.getAccountNo(),withDrawInput_int);
                        JOptionPane.showMessageDialog(dashBoard,"success");
                        customer.setBalance(customer.getBalance()-withDrawInput_int);
                        String temp=Main.getRandomNumberString();
                        int transactionId=Integer.parseInt(temp);
                        sqlObj.insertTransactions(userId,transactionId,withDrawInput_int,"withdraw",customer.getAccountNo(),Main.getDate());
                        balance.setText(Float.toString(customer.getBalance()));


                    }
                }
            }
            catch (NumberFormatException error){
                error.printStackTrace();
            }
        }
        else if(e.getSource()==signUp_button1){
            String firstName=firstName_input.getText();
            String lastName=lastName_input.getText();
            String firstDeposit=firstDeposit_input.getText();
            String cnic=cnic_input.getText();
            String email=email_input.getText();
            String password=new String(passwordField.getPassword());
            String pin=new String(pinCode_input.getPassword());
            if(firstName!=null && lastName!=null && firstDeposit!=null && cnic!=null && email !=null && password!=null && pin!=null){
                try{
                    long cNic_int=Long.parseLong(cnic);
                    double firstDeposit_double=Double.parseDouble(firstDeposit);
                    int pin_int=Integer.parseInt(pin);
                    if(String.valueOf(cNic_int).length()!=13 && String.valueOf(pin_int).length()!=4){
                        JOptionPane.showMessageDialog(signUp,"Incorrect cnic or pin");
                    }
                    else{
                        String branchCode=JOptionPane.showInputDialog(signUp,"For Admin only: Please enter branch code");
                        if(branchCode.length()==4) {
                            int branchCode_int = Integer.parseInt(branchCode);
                            String accStart= "52"+ branchCode_int;
                            accStart=accStart+Main.get5RandomNumberString();
                            int uid_signup = Integer.parseInt(Main.getRandomNumberString());
                            sqlObj.insertCustomer(firstName,lastName,cNic_int,firstDeposit_double,uid_signup,branchCode_int,Long.parseLong(accStart),pin_int);
                            String userName=JOptionPane.showInputDialog(signUp,"Enter userName for login id");
                            sqlObj.insertOnlineBanking(uid_signup,email,password,userName);
                            JOptionPane.showMessageDialog(signUp,"Your account No is : "+accStart);
                            JOptionPane.showMessageDialog(signUp,"Done, Log Back in");
                            signUp.getContentPane().removeAll();
                            signUp.removeAll();
                            signUp.dispose();
                            setLogIn();
                        }

                    }
                }

                catch (NumberFormatException error){
                    JOptionPane.showMessageDialog(signUp,"Only numeric value allowed in cnic and firstDeposit field");
                    error.printStackTrace();
                }
            }


        }
        else if(e.getSource()==backFromTransaction){
            transactionFrame.getContentPane().removeAll();
            transactionFrame.removeAll();
            transactionFrame.dispose();
            setDashBoard(userId,customer);
        }
        else if(e.getSource()==backFromSignUp){
            signUp.getContentPane().removeAll();
            signUp.removeAll();
            signUp.dispose();
            setStartup();
        }
        else if(e.getSource()==backFromLogin){
            logIn.getContentPane().removeAll();
            logIn.removeAll();
            logIn.dispose();
            setStartup();
        }
        else if(e.getSource()==signOut){
            dashBoard.getContentPane().removeAll();
            dashBoard.removeAll();
            dashBoard.dispose();
            setLogIn();
        }
    }
}

