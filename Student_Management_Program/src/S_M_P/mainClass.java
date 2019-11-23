/*
Program : Student Management System
Purpose : To access SQL database using java to easily manage and modify data in the database

Author  : Joakim Bongani Munyanyi
Email   : joakimbmunyanyi@gmail.com

>>> Special thanks to Ou Yang laoshi who made this project possible 

*/
package S_M_P;
import java.sql.*;
import java.util.Scanner;
import java.io.*;

public class mainClass 
{
	
//Global Variables for Students 
	static int stuID;//SID
	static int stuCID;//cID
	static int stuScore;//cID
	static String stuFname;//Fname
	static String stuLname;//Lname
	static String stuMID;//MID
	static int year;//year
	static String email;//Email
	static String phone;//Phone
	static String gender;//Gender
	static String Country;//Nationality
	static String OptionYN;
	
//Global Variables for Teachers
	static int teacherID;//TID
	static String teacherName;//Teacher_name
	static String teacherMID;//MID
	static String teacherAddress ;
	
//Global Variables for ADMIN PRIVELLAGES
	static String adminUSER;
	static String adminPASS;
	static String adminUSERcheck;
	static String adminPASScheck;
	
//Global Variables  for PARENTAL PRIVELLAGES
	static String childName;
	static String childSurname;
	static String parentPASS;
	
//Program loop variable	
	static boolean loop = true;
	static boolean loop2 = true;
	
	static String course_list = "\nCS50(Computer Science)\nME49 (Mechatronics)\nPH48 (Pharmacy)\nCE47 (Civil Engineering)\nEE46 (Electrical Engineering)";
	

//MAIN
	public static void main(String[] args) 
	{
		
		
//Input Streams
		Scanner input=new Scanner(System.in);
		BufferedReader buf = new BufferedReader(new InputStreamReader(System.in));
		
//PROGRAM START
		Login_Menu();
		int Option2;
		Option2=input.nextInt();
		
		if(Option2 == 1 )
		{
			
//VALIDATE ADMIN LOGIN
			System.out.println("ENTER ADMIN USERNAME:");
			adminUSER=input.next();
			System.out.println("ENTER ADMIN PASSWORD:");
			adminPASS=input.next();
			boolean status = Admin_Login(adminUSER,adminPASS);
			
			if(status)		  
			{
				
				while(loop)
				{
					Main_Menu();
					int Option;
					
					Option=input.nextInt();
//MENU Option
					switch(Option)
					{
//CASE 1 Main_Menu					
					     case 1:
							   Student_Menu();
//Input Student Menu
								Option=input.nextInt();
//MENU SWITCH
											switch(Option)
											{
//CASE 1 Student_Menu
													case 1:
														//1
														System.out.println("Enter Student ID :");
														 stuID=input.nextInt();
														//2
															System.out.println("Enter Student First name :");
															 stuFname=input.next();
															 //3
																System.out.println("Enter Student Last name :");
																 stuLname=input.next();
																//4 
																	System.out.println("Enter Student Major ID >>  "+ course_list + ":");
																	 stuMID=input.next();
																	 //5
																		System.out.println("Enter Student Current Year :");
																		 year=input.nextInt();
																		 //6
																			System.out.println("Enter Student's  email info :");
																			 email=input.next();
																			//7
																				System.out.println("Enter Student's Phone Number :");
																				 phone=input.next();
																				//8						 
																					System.out.println("Enter Gender (M/F)");
																					 gender=input.next();
																					//9 
																						System.out.println("Enter Student's Country of Origin :");
																						 Country=input.next();
															
														 INSERT_STUDENTS();
															
														 break;
													
//CASE 2 Student_Menu
													case 2:
															DISPLAY_STUDENTS();													
													break;
//CASE 3 Student_Menu
													case 3:
															System.out.println("Enter Student ID to DELETE DATA from :");
															stuID=input.nextInt();
													
															DELETE_STUDENT();
													break;								
														
														
//CASE 4 Student_Menu
													case 4:
															System.out.println("Enter Student ID to UPDATE DATA from :");
															 stuID=input.nextInt();
															 
															 Insert_Scores_Menu();
															 Option2 = input.nextInt();		
															 
															 switch(Option2)
															 {
															 
															 case 1:
																 	System.out.println("Enter a new Phone Number for Student :" + stuID);
																 	phone =input.next();
																 
																 	UPDATE_STUDENT_(/*Phone*/);
															 break;
															
															 case 2:
																	 
																	 System.out.println("Enter Couse ID for Student's Major :" );
																	 stuCID =input.nextInt();
																		 System.out.println("Enter Score for Course :"+stuCID);
																		 stuScore = input.nextInt();
																	 
																	 INSERT_SCORES();																					
															break;
														     }//end switch(Option2)
															 
													break;
//CASE 5 							
													case 5:
															EXIT();
													break;
//DEFAULT								
													default :
														System.out.println("Error :/");
														
								
													
							
								}//end SWITCH Students_Menu 
											

						 break;//CASE 1 Main Menu
//CASE 2 Main_Menu	
											//Teachers_Menu
					     case 2:
					    	 Teacher_Menu();
					    	//Input Student Menu
					    	Option=input.nextInt();
					    	//MENU SWITCH
					    	switch(Option)
					    	{
//CASE 1 Teacher_Menu
					    				case 1:
											//1
						    				System.out.println("Enter Teacher ID :");
						    					 teacherID=input.nextInt();
											//2
							    				System.out.println("Enter Teacher's  name :");
							    				try {
							    				     teacherName=buf.readLine();
							    				    }catch(Exception e)
							    				{
							    				    	System.out.println(e);
							    				}
							    				
							    				 //3
								    				System.out.println("Enter Teacher's Major e.g"+ course_list +":");
								    					 teacherMID=input.next();
								    				//4
									    				System.out.println("Enter Teacher's address:");
									    				
									    				try {
									    				     teacherAddress= buf.readLine();
									    				}catch(Exception e)
									    				{
									    					System.out.println(e);
									    				}
							    			
									    				INSERT_TEACHERS();			
					    				break;
					    														
//CASE 2 Teacher_Menu
					    				case 2:
					    						DISPLAY_TEACHERS();					    						
					    				break;
//CASE 3 Teacher_Menu
					    				case 3:			    						
					    						System.out.println("Enter Teacher ID to DELETE DATA from :");
					    				        teacherID=input.nextInt();
					    														
					    						DELETE_TEACHER();					
					    				break;								
					    												
//CASE 4 Teacher_menu
					    				case 4:
					    						System.out.println("Enter Teacher ID to UPDATE DATA from :");
					    						 teacherID=input.nextInt();
					    															 
					    						 System.out.println("Enter a new ADDRESS for Teacher :" + teacherID);
					    					     teacherAddress =input.next();
					    						
					    					     INSERT_TEACHER_();		    				    
					    				break;
//CASE 5								
					    				case 5:
					    						EXIT();
					    				break;
//DEFAULT								
					    				default :
					    						System.out.println("Error :/");
					    													
					    	}//end SWITCH Teacher_Menu	
					   break;//break CASE 2 Main Menu
					    	
//CASE 3 MAIN MENU					    	
					     case 3:
										    	 //input info
								System.out.println("ENTER Student ID:");
								stuID=input.nextInt();
									System.out.println("ENTER Student First NAME:");
									childName=input.next();
										 System.out.println("ENTER Student Last NAME:");
										 stuLname=input.next();
														
								boolean status3 = Student_Perfomance(stuID,childName,stuLname);
								if(status3) 
								{								
									System.out.println("STUDENTS PERFOMANCE");	
									{
								       System.out.println("\t\nWELCOME TO ZHENGZHOU ACADEMIC REPORT VIEW\n");
									   System.out.println("\t\t\n>>>>>"+childName+"'s Academic Report is as follows :");								
										VIEW_RESULTS();							   
									}
								}//end if(status3=true)
								else
									System.out.println("Sorry,User does not exist");
						 break;
//CASE 4 Main Menu					    	
					    case 4:	    	    				 	      
					 	        loop = false;
    						    EXIT();
	    				break;
	    				default:
	    					System.out.println("Error:/");
	    					
					    	 
					}// end SWITCH Main_Menu
					
					
					
				}//end while(true)
				
			}//end if(status = true)
			else
			{
				System.out.println("USER DOES NOT EXIST");
				System.exit(0);
			}
		
					
		}//end if option2 is 1
		else if(Option2 == 2)
		{
			//VALIDATE ADMIN LOGIN
			System.out.println("ENTER Student ID:");
			stuID=input.nextInt();
			System.out.println("ENTER Student Name:");
			childName=input.next();
			System.out.println("ENTER  PASSWORD:");
			parentPASS=input.next();
			boolean status2 = Parent_Login(stuID,childName,parentPASS);
			
			if(status2)
				VIEW_RESULTS();
			else
				System.out.println("Sorry ,User does not exist");
		
		}//end if(Option2 == 2)
		
		else if(Option2 == 3)
		{
			EXIT();
		}//end if(Option2 == 3)
		
		else
		{
			System.out.println("ERROR");
			System.exit(0);
		}
		
//BUFFER CLOSE

		try 
		{
		input.close();
		buf.close();
		}catch(Exception e)
		{
			System.out.println(e);
		}
		
		
	}//end Main
	
//METHODS
	
	//MENU
	
	static void Main_Menu() 
	{
	System.out.println("##################################################");
	System.out.println("#           STUDENT MANAGEMENT PROGRAM           #");
	System.out.println("#                   MAIN MENU                    #");
	System.out.println("#                                                #");
	System.out.println("# PLEASE SELECT AN OPTION :                      #");
	System.out.println("# 1)ENTER STUDENT MANAGEMENT MENU                #");
	System.out.println("# 2)ENTER TEACHER MANAGEMENT MENU                #");
	System.out.println("# 3)STUDENTS PERFOMANCE                          #");
	System.out.println("# 4)ADMIN LOG OUT                                #");
	System.out.println("#                                                #");
	System.out.println("##################################################");	
	}//end Main Menu Func
	
	static void Student_Menu()
	{
	System.out.println("##################################################");
	System.out.println("#  >>>>>>>>>>>  STUDENT MANAGEMENT MENU          #");
	System.out.println("#                      SUB MENU                  #");
	System.out.println("#                                                #");
	System.out.println("# PLEASE SELECT AN OPTION :                      #");
	System.out.println("# 1)INPUT NEW DATA INTO DATABASE                 #");
	System.out.println("# 2)PRINT DATA FROM DATABASE                     #");
	System.out.println("# 3)DELETE DATA FROM DATABASE                    #");
	System.out.println("# 4)UPDATE STUDENT INFORMATION                   #");
	System.out.println("# 5)EXIT                                         #");
	System.out.println("#                                                #");
	System.out.println("##################################################");
	}//end Student Menu Func

	static void Teacher_Menu()
	{
	System.out.println("##################################################");
	System.out.println("#  >>>>>>>>>>>  TEACHER MANAGEMENT MENU          #");
	System.out.println("#                      SUB MENU                  #");
	System.out.println("#                                                #");
	System.out.println("# PLEASE SELECT AN OPTION :                      #");
	System.out.println("# 1)INPUT NEW DATA INTO DATABASE                 #");
	System.out.println("# 2)PRINT DATA FROM DATABASE                     #");
	System.out.println("# 3)DELETE DATA FROM DATABASE                    #");
	System.out.println("# 4)UPDATE TEACHER INFORMATION                   #");
	System.out.println("# 5)EXIT                                         #");
	System.out.println("#                                                #");
	System.out.println("##################################################");
	}//end TEACHER Menu Func
	
	static void Login_Menu()
	{
	System.out.println("##################################################");
	System.out.println("#                      LOGIN                     #");
	System.out.println("#                                                #");
	System.out.println("# PLEASE SELECT AN OPTION :                      #");
	System.out.println("# 1)ADMIN LOGIN                                  #");
	System.out.println("# 2)PARENTAL LOGIN                               #");
	System.out.println("# 3)EXIT                                         #");
	System.out.println("#                                 Ver 2.1        #");
	System.out.println("##################################################");
	}//end TEACHER Menu Func
	
	static void Insert_Scores_Menu()
	{
	System.out.println("##################################################");
	System.out.println("#                      SCORES                    #");
	System.out.println("#                                                #");
	System.out.println("# PLEASE SELECT AN OPTION TO UPDATE:             #");
	System.out.println("# 1)PHONE NUMBER                                 #");
	System.out.println("# 2)SCORES                                       #");
	System.out.println("# 3)EXIT                                         #");
	System.out.println("#                                                #");
	System.out.println("##################################################");
	}//end TEACHER Menu Func

	//create sql connection

	public static Connection SQLConnect(){
		Connection conn=null;
		try{
			Class.forName("com.mysql.cj.jdbc.Driver");//look for driver(driver is for mysql connection)
			//Linking to mysql database
			conn=DriverManager.getConnection("jdbc:mysql://localhost:3306/sms ver 1.0", "root", "BU##BAby010020");
			//("jdbc:mysql://IP address :port/name of database", "name login", "Password login")
		}catch(Exception e){System.out.println(e);}
		return conn;
	}
	
	public static boolean Admin_Login(String name,String password)
	{
		boolean status=false;
		try{
			Connection con=SQLConnect();
			PreparedStatement ps=con.prepareStatement("select * from admin_info where Username=? and Password=?");
			ps.setString(1,name);
			ps.setString(2,password);
			ResultSet rs=ps.executeQuery();
			status=rs.next();
			con.close();
		   }catch(Exception e)
		   {
			   System.out.println(e);
		   }
		
		
		return status;
	}
	
	public static boolean Parent_Login(int stu_ID,String name,String password)
	{
		boolean status2=false;
		try{
			Connection con=SQLConnect();
			PreparedStatement ps=con.prepareStatement("select * from relatives_info where Stu_ID=?  and Parent_Password=?");
			ps.setInt(1,stu_ID);
			ps.setString(2,name);
			ps.setString(2,password);
			ResultSet rs=ps.executeQuery();
			status2=rs.next();
			con.close();
		   }catch(Exception e)
		   {
			   System.out.println(e);
		   }
		
		
		return status2;
	}
	
	public static boolean Student_Perfomance(int stu_ID,String name,String surname)
	{
		boolean status3=false;
		try{
			Connection con=SQLConnect();
			PreparedStatement ps=con.prepareStatement("select * from students_info where SID=? and Fname=? and Lname=?");
			ps.setInt(1,stu_ID);
			ps.setString(2,name);
			ps.setString(3,surname);
			ResultSet rs=ps.executeQuery();
			status3=rs.next();
			con.close();
		   }catch(Exception e)
		   {
			   System.out.println(e);
		   }
		
		
		return status3;
	}
		
	
	static void VIEW_RESULTS()
	{
		System.out.println("\t\nWELCOME TO ZHENGZHOU ACADEMIC REPORT VIEW\n");
		System.out.println("\t\t\n>>>>>"+childName+"'s Academic Report is as follows :");		
		try {
					
			Connection conn=SQLConnect();
			PreparedStatement command=null;

			command=conn.prepareStatement("select Major_name,Fname,Course_name,Scores,Semester,C_Year "
					                    + "from majors_info join students_info on students_info.MID = majors_info.MID "
					                                     + "join grade_info on  students_info.SID = grade_info.SID "
					                                     + "join Course_info on course_info.CID = grade_info.CID  "					                                     
					                                     
					                    + "where Fname = ? ");//to get data from SQL database
			command.setString(1, childName); //for insert																				 //  ("insert into student values(?,?,?)  //to insert data into SQl database
							
			 ResultSet rs=command.executeQuery(); //for select
			System.out.println("MAJOR\t             STUDENT_NAME\t\t                  COURSE\t\t               SCORE\t\t     SEMESTER\t\t    YEAR");
		    System.out.println("_____________________________________________________________________________________________________________________________________________________________");
			while(rs.next())
			 {
														
				System.out.print(rs.getString(1)); //Major
				System.out.print(String.format("%16s",rs.getString(2)));//Student_name
			    System.out.print(String.format("%40s",rs.getString(3)));//Course
			    System.out.print(String.format("%32s",rs.getInt(4)));//Score
			    System.out.print(String.format("%30s",rs.getInt(5)));//Semester
			    System.out.print(String.format("%30s",rs.getInt(6)+"\n"));//Year
			   // System.out.print(String.format("%21s",rs.getString(5)+"\n"));//MID
		   	 }
			System.out.println();
													
			//close
			command.close();
			rs.close();
													
			} catch (Exception e) //catch errors 
			{
		    System.out.println(e);
			}
	}
	

	
	static void INSERT_SCORES()
	{
			try {
				// TODO Auto-generated method stub
				
				//Class.forName("com.mysql.jdbc.Driver");//look for driver(driver is for mysql connection)																
				//Linking to mysql database
				//conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/student_management", "root", "Jocka@0100#Flex");
				//("jdbc:mysql://IP address :port/name of database", "name login", "Password login")
				
				Connection conn=SQLConnect();
				PreparedStatement command=null;

				
				command=conn.prepareStatement("update grade_info set Scores = ? where SID = ? and CID =?");//to insert data into SQL database
															 //("select * from student")             //to get data
				command.setInt(1, stuScore);
				command.setInt(2, stuID); //for insert
				command.setInt(3, stuCID); //for insert
		
				boolean result=command.execute(); //for insert
				
				if(!result) System.out.println("successful");
				else System.out.println("failed");
				
				//close
				command.close();
					
			} catch (Exception e) //catch errors 
			{
				System.out.println(e);
				// TODO: handle exception
			}//end catch
			
	}
	
	static void INSERT_TEACHERS()
	{
		try {
			// TODO Auto-generated method stub
														
					//Class.forName("com.mysql.jdbc.Driver");//look for driver(driver is for mysql connection)				    																	
					//Linking to mysql database
					//conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/student_management", "root", "Jocka@0100#Flex");
					//("jdbc:mysql://IP address :port/name of database", "name login", "Password login")
			
					Connection conn=SQLConnect();
					PreparedStatement command=null;
			
				    command=conn.prepareStatement("insert into teachers_info values(?,?,?,?)");//to insert data into SQL database
																											 //("select * from student")             //to get data
					command.setInt(1, teacherID); //for insert
				    command.setString(2, teacherName); //for insert
					command.setString(3, teacherMID); //for insert
					command.setString(4, teacherAddress); //for insert
																
						
					boolean result=command.execute(); //for insert
																
				    if(!result) System.out.println("successful");
						else System.out.println("failed");
																
					//close
					command.close();
																	
					} catch (Exception e) //catch errors 
					{
						System.out.println(e);
																// TODO: handle exception
			        }//end catch
	}
	
	static void INSERT_STUDENTS()
	{
		try {
			// TODO Auto-generated method stub
			
			//Class.forName("com.mysql.jdbc.Driver");//look for driver(driver is for mysql connection)
			//Linking to mysql database
			//conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/student_management", "root", "Jocka@0100#Flex");
			//("jdbc:mysql://IP address :port/name of database", "name login", "Password login")
			
			Connection conn=SQLConnect();
			PreparedStatement command=null;
			
			command=conn.prepareStatement("insert into students_info values(?,?,?,?,?,?,?,?,?)");//to insert data into SQL database
														 //("select * from student")             //to get data
			command.setInt(1, stuID); //for insert
			command.setString(2, stuFname); //for insert
			command.setString(3, stuLname); //for insert
			command.setString(4, stuMID); //for insert
			command.setInt(5, year); //for insert
			command.setString(6, email); //for insert
			command.setString(7, phone); //for insert
			command.setString(8, gender); //for insert
			command.setString(9, Country); //for insert

			boolean result=command.execute(); //for insert
			
			if(!result) System.out.println("successful");
			else System.out.println("failed");
			
			//close
			command.close();
				
		} catch (Exception e) //catch errors 
		{
			System.out.println(e);
			// TODO: handle exception
		}//end catch
	}
	
	static void DISPLAY_STUDENTS()
	{
		try {
			// TODO Auto-generated method stub
			
			//Class.forName("com.mysql.jdbc.Driver");//look for driver(driver is for mySQL connection)														
			//Linking to mySQL database
		    //conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/student_management", "root", "Jocka@0100#Flex");
			//("jdbc:mysql://IP address :port/name of database", "name login", "Password login")
			
			Connection conn=SQLConnect();
			PreparedStatement command=null;
			
			command=conn.prepareStatement("select * from students_info");//to get data from SQL database
														 //  ("insert into student values(?,?,?)  //to insert data into SQl database

			  ResultSet rs=command.executeQuery(); //for select
			System.out.println("SID\t  FName\t\t  Lname\t\tMID\t  Year\t      Email\t\t\t Phone\t  Gender   Nationality");
			System.out.println("___________________________________________________________________________________________________________________________");
			while(rs.next())
			 {
				
				System.out.print(rs.getInt(1)); //SID
				System.out.print(String.format("%12s",rs.getString(2)));//Fname
				System.out.print(String.format("%16s",rs.getString(3)));//Lname
				System.out.print(String.format("%12s",rs.getString(4)));//MID
				System.out.print(String.format("%8s",rs.getInt(5)));//year
				System.out.print(String.format("%28s",rs.getString(6)));//email
				System.out.print(String.format("%15s",rs.getString(7)));//phone
				System.out.print(String.format("%7s",rs.getString(8)));//gender
				System.out.print(String.format("%15s",rs.getString(9)+"\n"));//Nationality
				
				
			}
			System.out.println();
			
			//close
			command.close();
			rs.close();
			
		} catch (Exception e) //catch errors 
		{
			System.out.println(e);
		}
	}
	
	static void DELETE_STUDENT()
	{
		try {
			// TODO Auto-generated method stub
			
			//Class.forName("com.mysql.jdbc.Driver");//look for driver(driver is for mysql connection)																
			//Linking to mysql database
			//conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/student_management", "root", "Jocka@0100#Flex");
			//("jdbc:mysql://IP address :port/name of database", "name login", "Password login")
			
			Connection conn=SQLConnect();
			PreparedStatement command=null;
				
			command=conn.prepareStatement("delete from students_info where SID = ?");//to insert data into SQL database
														 //("select * from student")             //to get data
			command.setInt(1, stuID); //for insert

			boolean result=command.execute(); //for insert
			
			if(!result) System.out.println("successful");
			else System.out.println("failed");

			//close
			command.close();
				
		} catch (Exception e) //catch errors 
		{
			System.out.println(e);
			// TODO: handle exception
		}//end catch
	}
	
	static void UPDATE_STUDENT_()
	{
		try {
			// TODO Auto-generated method stub
			
			//Class.forName("com.mysql.jdbc.Driver");//look for driver(driver is for mysql connection)																
			//Linking to mysql database
			//conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/student_management", "root", "Jocka@0100#Flex");
			//("jdbc:mysql://IP address :port/name of database", "name login", "Password login")
			
			Connection conn=SQLConnect();
			PreparedStatement command=null;
			
			command=conn.prepareStatement("update students_info set Phone = ? where SID = ?");//to insert data into SQL database
														 //("select * from student")             //to get data
			command.setString(1, phone);
			command.setInt(2, stuID); //for insert
			

			boolean result=command.execute(); //for insert
			
			if(!result) System.out.println("successful");
			else System.out.println("failed");
			
			//close
			command.close();
				
		} catch (Exception e) //catch errors 
		{
			System.out.println(e);
			// TODO: handle exception
		}//end catch
	}
	
	static void DISPLAY_TEACHERS()
	{
		try {
		    // TODO Auto-generated method stub
													
			//Class.forName("com.mysql.jdbc.Driver");//look for driver(driver is for mySQL connection)					    																
			//Linking to mySQL database
			//conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/student_management", "root", "Jocka@0100#Flex");
            //("jdbc:mysql://IP address :port/name of database", "name login", "Password login")	
			
			Connection conn=SQLConnect();
			PreparedStatement command=null;
			
			command=conn.prepareStatement("select * from teachers_info");//to get data from SQL database
																								 //  ("insert into student values(?,?,?)  //to insert data into SQl database
							
			 ResultSet rs=command.executeQuery(); //for select
			System.out.println("TID\t  Teacher_Name\t\tDepartment\t\tOffice No");
		    System.out.println("___________________________________________________________________________________________________________________________");
			while(rs.next())
			 {
														
				System.out.print(rs.getInt(1)); //TID
				System.out.print(String.format("%19s",rs.getString(2)));//teacher_name
			    System.out.print(String.format("%21s",rs.getString(3)));//MID
			    System.out.print(String.format("%24s",rs.getString(4)+"\n"));//MID
		   	 }
			System.out.println();
													
			//close
			command.close();
			rs.close();
													
			} catch (Exception e) //catch errors 
			{
		    System.out.println(e);
			}		 
	}
	
	static void DELETE_TEACHER()
	{
		try {
			// TODO Auto-generated method stub
														
			//Class.forName("com.mysql.jdbc.Driver");//look for driver(driver is for mysql connection)											
		    //Linking to mysql database
			Connection conn=SQLConnect();
			PreparedStatement command=null;
			
			conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/sms ver1.0", "root", "010020");
			//("jdbc:mysql://IP address :port/name of database", "name login", "Password login")
			
			
			
			
			command=conn.prepareStatement("delete from teachers_info where TID = ?");//to insert data into SQL database
																									 //("select * from student")             //to get data
		    command.setInt(1, teacherID); //for insert
				
			boolean result=command.execute(); //for insert
														
		    if(!result) System.out.println("successful");
			else System.out.println("failed");
				
			//close
			command.close();
															
		     } catch (Exception e) //catch errors 
				{
					System.out.println(e);
					// TODO: handle exception
				}//end catch
	}
	
	static void INSERT_TEACHER_()
	{
		  try {
				// TODO Auto-generated method stub
																
					Class.forName("com.mysql.jdbc.Driver");//look for driver(driver is for mysql connection)
																
					//Linking to mysql database
					//conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/student_management", "root", "Jocka@0100#Flex");
					//("jdbc:mysql://IP address :port/name of database", "name login", "Password login")
					
					Connection conn=SQLConnect();
					PreparedStatement command=null;
					
					
					command=conn.prepareStatement("update teachers_info set Address = ? where TID = ?");//to insert data into SQL database
																											 //("select * from student")             //to get data
					command.setString(1, teacherAddress);
					command.setInt(2, teacherID); //for insert
																
						
					boolean result=command.execute(); //for insert
																
					if(!result) System.out.println("successful");
				    else System.out.println("failed");
																
					//close
					command.close();
																	
					} catch (Exception e) //catch errors 
					{
					  System.out.println(e);
					// TODO: handle exception
				    }//end catch
	}
	
	static void EXIT()
	{
		System.out.println("#                  EXIT PROGRAM                  #");
		System.exit(0);
	}
	

}//end MainClass
