/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package restaurant.reservation;

import com.sun.org.apache.bcel.internal.generic.GOTO;
import javafx.application.Application;
import javafx.stage.Stage;
import javafx.scene.control.*;
import javafx.stage.*;
import javafx.application.*;
import javafx.event.*;
import javafx.scene.layout.*;
import javafx.scene.*;
import javafx.scene.Node;
import javafx.scene.Group; 
import javafx.scene.Scene; 
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;  
import java.awt.font.*;
import java.io.IOException;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.logging.Level;
import java.util.logging.Logger;
import static javafx.application.Application.setUserAgentStylesheet;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.scene.control.cell.PropertyValueFactory;
import java.util.Date;
import java.time.LocalDate;  
import java.time.LocalTime;

/**
 *
 * @author DELL
 */

public class RestaurantReservation extends Application{
    /**
     * @param args the command line arguments
     */
    
    LocalDate date = LocalDate.now(); 
    LocalTime currentTime = LocalTime.now();
    Image img;
    ListView<String>table;
    Restaurant rest=new Restaurant();
    Parser a=new Parser();
    String s=""; 
    String name="";
    String data="";
    Order order;
    
    Image kitchen=new Image("kitchenpic2.jpg");
    Image desk=new Image("manager.jpg");
    Image customer=new Image("customerpic.jpg");
    Image waiterpic=new Image("waiter.jpg");
    Image cashier=new Image("cashier.jpg");
    Image customer2=new Image("customerpic3.jpg");
    Image menupic=new Image("menu.jpg");
    Image reception=new Image("reception.jpg");
    
    public class SortNumberOfSeats implements Comparator<Tables>{
    @Override
    public int compare(Tables o1, Tables o2) {
    return Integer.parseInt(o1.getNumberOfSeats())-Integer.parseInt(o2.getNumberOfSeats());
    }
}    
   public TreeItem<String> makeBranch(String a,TreeItem<String> parent){
        TreeItem<String> item=new TreeItem<>(a);
        item.setExpanded(true);
         parent.getChildren().add(item);
        return item;
        
    } 
   public boolean isInt(String a){

  try {

   Integer.parseInt(a);
   return true;
   }catch(Exception e){
    return false;
    }}
public boolean isFloat(String a){

  try {

   Float.parseFloat(a);
   return true;
   }catch(Exception e){
    return false;
    }

}
    public static void main(String[] args) {
   
        launch(args);
        
        }
TableView<Users> table_users ;
TableView<Tables> table_avtables ;
TableView<Tables> table_restables;
TableView<Order> ordertable;
TreeView<String> orders;
    @Override
    public void start(Stage primaryStage) throws Exception {
    a.parse(rest); 
    Collections.sort(rest.getAvailableTables(), new SortNumberOfSeats());
    int seats;  
    Tables t;
        
    Button reserve=new Button("Reserve Table");
    Button back =new Button("Back");
    Button ok =new Button ("OK");
    Button login=new Button("Login");
    Button close=new Button("Close");
    Button proceed=new Button("proceed");
    Button back2 =new Button("<-Back");
    Button checkout =new Button("Checkout");
    Button exit =new Button("Exit");
    Button home =new Button("Back to Logging in");
    Button addEmployee= new Button("Add Employee");
    Button Status= new Button("Status");
    Button todayOrders= new Button("Today's orders");
    Button allTimeOrders= new Button("All time orders");
    Button logout_Manager= new Button("Logout");
    Button addDish= new Button("Add dish");
    Button Register=new Button("Register");
    Button back3=new Button("back");
    Button back4=new Button("back");
    Button add_dish=new Button("Add");
    Button back5=new Button("back");
    Button back6=new Button("back");
    Button logout2=new Button("Logout");
    Button logout3=new Button("Logout");
    Button signup=new Button("Customer Signup");
    Button back7=new Button("back");
    Button signup2=new Button("Signup");
    Button show1=new Button("show");
    Button show2=new Button("show");
    
    
    Label l1=new Label("Smoking ?");
    Label l=new Label("Welcome !!");
    Label l2=new Label("Number of Seats :");
    Label lMain=new Label("Main Course :");
    Label lAppetizer=new Label ("Appetizer :");
    Label lDesert=new Label("Deserts :");
    Label menu=new Label("Menu :");
    Label LName=new Label();
    Label LDishes=new Label();
    Label LTotalPrice=new Label();
    Label LManager=new Label();
    Label thanks =new Label("THANKS FOR CHOOSING US 😍😍");
    Label register_name=new Label("Name:");
    Label register_username=new Label("Username:");
    Label register_password=new Label("Password:");
    Label register_role=new Label("Role:");
    Label dish_name=new Label("Name:");
    Label dish_type=new Label("Type:");
    Label dish_price=new Label("Price:");
    Label allOrders=new Label("ALL Orders :");
    Label todayorders=new Label("Today's Orders :");
    Label todaymoney=new Label();
    Label error=new Label();
    Label name2=new Label("Enter Name :");
    Label user2=new Label("Enter Username :");
    Label pass2=new Label("Enter password :");
    
    Label lusers=new Label("Scheduled users");
    Label lavtables=new Label("Available tables");
    Label lrestables=new Label("Reserved tables");
    Label ltable=new Label("Please choose a table :");
    
    
    Label error2=new Label("Invalid input");
    Label error3=new Label("");
    Label error4=new Label("Invalid Price");
    
    
    
    
    name2.setLayoutX(40);
    name2.setLayoutY(200);
    
    user2.setLayoutX(40);
    user2.setLayoutY(275);
    
    pass2.setLayoutX(40);
    pass2.setLayoutY(350);
    
    
    back7.setLayoutX(400);
    back7.setLayoutY(650);
    
    signup2.setLayoutX(210);
    signup2.setLayoutY(550);
    
    signup.setLayoutX(70);
    signup.setLayoutY(510);
    
    error.setLayoutX(160);
    error.setLayoutY(320);
     
   error2.setLayoutX(400);
   error2.setLayoutY(300);
   
   error3.setLayoutX(225);
   error3.setLayoutY(600);
   
   ltable.setLayoutX(90);
   ltable.setLayoutY(230);
   
    todaymoney.setLayoutX(50);
    todaymoney.setLayoutY(455);
    todaymoney.setStyle("-fx-text-fill: #000000");
    
    logout2.setLayoutX(500);
    logout2.setLayoutY(500);
    
    logout3.setLayoutX(400);
    logout3.setLayoutY(450);
    
    show1.setLayoutX(300);
    show1.setLayoutY(500);
            
    show2.setLayoutX(200);
    show2.setLayoutY(450);
                    
    back6.setLayoutX(430);
    back6.setLayoutY(450);
    
    back5.setLayoutX(430);
    back5.setLayoutY(450);
    
    allOrders.setLayoutX(20);
    allOrders.setLayoutY(5);
    allOrders.setStyle("-fx-font-size: 25px;");
     
    todayorders.setLayoutX(20);
    todayorders.setLayoutY(5);
    todayorders.setStyle("-fx-font-size: 25px;");
    
    thanks.setTranslateX(30);
    thanks.setTranslateY(60);
    
    
    LManager.setLayoutX(100);
    LManager.setLayoutX(50);
    
    CheckBox yes = new CheckBox("Yes");
    CheckBox no = new CheckBox("NO");
    CheckBox manager = new CheckBox("Manager");
    CheckBox waiter = new CheckBox("Waiter");
    CheckBox cooker = new CheckBox("Cooker");
    CheckBox client = new CheckBox("Client");
    CheckBox manager2 = new CheckBox("Manager");
    CheckBox waiter2 = new CheckBox("Waiter");
    CheckBox cooker2= new CheckBox("Cooker");
    CheckBox manager3 = new CheckBox("Main course");
    CheckBox waiter3 = new CheckBox("Appetizer");
    CheckBox cooker3= new CheckBox("Dessert");
    
    CheckBox dish;
    TextField text;
    ArrayList <CheckBox> mainCourses=new ArrayList<CheckBox>();
    ArrayList <CheckBox> appetizers=new ArrayList<CheckBox>();
    ArrayList <CheckBox> deserts=new ArrayList<CheckBox>();
    ArrayList <TextField> mainFields=new ArrayList<TextField>();
    ArrayList <TextField> appetizerFields=new ArrayList<TextField>();
    ArrayList <TextField> desertFields=new ArrayList<TextField>();
      int i,y;
    for(i=0;i<rest.getMenu().size();i++)
    {
        if(rest.getMenu().get(i).getType().equalsIgnoreCase("main_course"))
        {
            dish=new CheckBox(rest.getMenu().get(i).getName());
            text=new TextField();
            text.setPromptText("Quantity");
            text.setMaxWidth(90);
            mainFields.add(text);
            mainCourses.add(dish);
        }
        if(rest.getMenu().get(i).getType().equalsIgnoreCase("appetizer"))
        {
            dish=new CheckBox(rest.getMenu().get(i).getName());
            text=new TextField();
            text.setPromptText("Quantity");
            text.setMaxWidth(90);
            appetizerFields.add(text);
            appetizers.add(dish);
           
        }
        if(rest.getMenu().get(i).getType().equalsIgnoreCase("desert"))
        {
            dish=new CheckBox(rest.getMenu().get(i).getName());
            text=new TextField();
            text.setPromptText("Quantity");
            text.setMaxWidth(90);
            desertFields.add(text);
            deserts.add(dish);
        }
                    
    }   
        
    TextField seatNo=new TextField();
    TextField user=new TextField();
    TextField pass=new TextField();
    TextField register_nametext=new TextField();
    TextField register_roletext=new TextField();
    TextField register_usernametext=new TextField();
    TextField register_passwordtext=new TextField();
    TextField nameText2=new TextField();
    TextField userText2=new TextField();
    TextField passText2=new TextField();
    TextField dish_nametext= new TextField();
    TextField dish_pricetext=new TextField();
    
    nameText2.setPromptText("Name");
    passText2.setPromptText("Password");
    userText2.setPromptText("Username");
    register_nametext.setPromptText("Name");
    register_roletext.setPromptText("Enter New Employee Details :");
    register_usernametext.setPromptText("Username");
    register_passwordtext.setPromptText("Password");
    dish_nametext.setPromptText("Name");
    dish_pricetext.setPromptText("Price");
    
    
    lusers.setLayoutX(10);
    lusers.setLayoutY(20);
    lusers.setStyle("-fx-font-size: 25px;");
    
    lavtables.setLayoutX(500);
    lavtables.setLayoutY(20);
    lavtables.setStyle("-fx-font-size: 25px;");
     
    lrestables.setLayoutX(900);
    lrestables.setLayoutY(20);
    lrestables.setStyle("-fx-font-size: 25px;");
    
    register_role.setLayoutX(50);
    register_role.setLayoutY(50);
    
    error4.setLayoutX(200);
    error4.setLayoutY(200);
    error4.setStyle("-fx-text-fill: #000000");
    
    nameText2.setLayoutX(200);
    nameText2.setLayoutY(200);
    
    userText2.setLayoutX(200);
    userText2.setLayoutY(275);
    
    passText2.setLayoutX(200);
    passText2.setLayoutY(350);
    
    reserve.setLayoutX(100);
    reserve.setLayoutY(600);
    
    register_name.setLayoutX(75);
    register_name.setLayoutY(100);
    
    register_username.setLayoutX(75);
    register_username.setLayoutY(150);
    
    register_password.setLayoutX(75);
    register_password.setLayoutY(200);
    
   manager2.setLayoutX(90);
   waiter2.setLayoutX(200);
   cooker2.setLayoutX(300);
   
   manager2.setLayoutY(260);
   waiter2.setLayoutY(260);
   cooker2.setLayoutY(260);
    
   
    
    register_nametext.setLayoutX(175);
    register_nametext.setLayoutY(100);
    
    register_usernametext.setLayoutX(175);
    register_usernametext.setLayoutY(150);
    
    register_passwordtext.setLayoutX(175);
    register_passwordtext.setLayoutY(200);
    
   manager3.setLayoutX(100);
   waiter3.setLayoutX(250);
   cooker3.setLayoutX(370);
   
   manager3.setLayoutY(250);
   waiter3.setLayoutY(250);
   cooker3.setLayoutY(250);
    
    dish_name.setLayoutX(100);
    dish_name.setLayoutY(125);
    
    dish_price.setLayoutX(100);
    dish_price.setLayoutY(175);
    
    dish_nametext.setLayoutX(175);
    dish_nametext.setLayoutY(125);
    
    dish_pricetext.setLayoutX(175);
    dish_pricetext.setLayoutY(175);
    
    
    
    back.setLayoutX(400);
    back.setLayoutY(600);
 
    l.setLayoutX(10);
    l.setLayoutY(10);
    l.setStyle("-fx-font-size: 30px");
    
    l1.setLayoutX(145);
    l1.setLayoutY(70);
    
    yes.setLayoutX(145);
    yes.setLayoutY(115);
    
    no.setLayoutX(215);
    no.setLayoutY(115);

    l2.setLayoutX(110);
    l2.setLayoutY(160);
    
    addEmployee.setLayoutX(50);
    addEmployee.setLayoutY(500);
    
   logout_Manager.setLayoutX(900);
   logout_Manager.setLayoutY(500);
   
   Status.setLayoutX(370);
   Status.setLayoutY(500);
   
   todayOrders.setLayoutX(500);
   todayOrders.setLayoutY(500);
   
   allTimeOrders.setLayoutX(700);
   allTimeOrders.setLayoutY(500);
   
   addDish.setLayoutX(250);
   addDish.setLayoutY(500);
   
   Register.setLayoutX(200);
   Register.setLayoutY(300);
   
   back3.setLayoutX(400);
   back3.setLayoutY(300);
   
   add_dish.setLayoutX(200);
   add_dish.setLayoutY(300);
   
   back4.setLayoutX(400);
   back4.setLayoutY(300);
   
    seatNo.setLayoutX(115);
    seatNo.setLayoutY(200);
    seatNo.setMaxWidth(90);
    seatNo.setPromptText("Number");
    
    ok.setLayoutX(255);
    ok.setLayoutY(200);
    
    user.setLayoutX(150);
    user.setLayoutY(220);
    user.setMaxHeight(10);
    user.setPromptText("Username");
 
    pass.setLayoutX(150);
    pass.setLayoutY(270);
    pass.setMaxHeight(10);
    pass.setPromptText("Password");
    
    manager.setLayoutY(370);
    waiter.setLayoutY(370);
    cooker.setLayoutY(370);
    client.setLayoutY(370);
    
    manager.setLayoutX(70);
    waiter.setLayoutX(160);
    cooker.setLayoutX(240);
    client.setLayoutX(330);
    
    login.setLayoutX(300);
    login.setLayoutY(510);
    
    close.setLayoutX(400);
    close.setLayoutY(700);
    
    exit.setLayoutX(280);
    exit.setLayoutY(150);
    
    home.setLayoutX(20);
    home.setLayoutY(150);
    
    menu.setLayoutX(10);
    menu.setLayoutY(10); 
    
    lMain.setLayoutX(50);
    lMain.setLayoutY(70);
    
    lAppetizer.setLayoutX(320);
    lAppetizer.setLayoutY(70);
    
    lDesert.setLayoutX(620);
    lDesert.setLayoutY(70);
    
    LName.setLayoutX(20);
    LName.setLayoutY(80); 
    LName.setStyle("-fx-text-fill: #000000");
     
    LDishes.setLayoutX(60);
    LDishes.setLayoutY(150);
    LDishes.setStyle("-fx-text-fill: #ffffff");
    
    
    y=(int)lMain.getLayoutY();
        for(i=0;i<mainCourses.size();i++)
        {   y+=50;
            mainCourses.get(i).setLayoutX(30);
            mainCourses.get(i).setLayoutY(y);
             mainCourses.get(i).setStyle(" -fx-font-size: 15px;");
            mainFields.get(i).setLayoutX(200);
            mainFields.get(i).setLayoutY(y);
        }
        y=(int)lAppetizer.getLayoutY();
        for(i=0;i<appetizers.size();i++)
        {   y+=50;
            appetizers.get(i).setLayoutX(320);
            appetizers.get(i).setLayoutY(y);
            appetizers.get(i).setStyle(" -fx-font-size: 15px;");
            appetizerFields.get(i).setLayoutX(470);
            appetizerFields.get(i).setLayoutY(y);
        }
        y=(int)lDesert.getLayoutY();
        for(i=0;i<deserts.size();i++)
        {   y+=50;
            deserts.get(i).setLayoutX(620);
            deserts.get(i).setLayoutY(y);
            deserts.get(i).setStyle(" -fx-font-size: 15px;");
            desertFields.get(i).setLayoutX(770);
            desertFields.get(i).setLayoutY(y);
            
        }
    proceed.setLayoutX(deserts.get(i-1).getLayoutX());
    proceed.setLayoutY(deserts.get(i-1).getLayoutY()+100);
    
    ImageView customerimage= new ImageView(); 
    ImageView customerimage3= new ImageView();
    ImageView customerimage2= new ImageView();
    ImageView customerimage4= new ImageView();
    
    ImageView kitchenimage= new ImageView();
    ImageView waiterimage= new ImageView();
    
    ImageView managerimage= new ImageView();
    ImageView managerimage2= new ImageView();
    ImageView managerimage3= new ImageView();
    ImageView managerimage4= new ImageView();
    ImageView managerimage5= new ImageView();
    
    ImageView loginimage= new ImageView();
    ImageView loginimage2= new ImageView();
    
    customerimage.setImage(customer2);
    customerimage2.setImage(menupic);
    customerimage3.setImage(cashier);
  
    
    kitchenimage.setImage(kitchen);
    waiterimage.setImage(waiterpic);
    
    managerimage.setImage(desk);
    managerimage2.setImage(desk);
    managerimage3.setImage(desk);
    managerimage4.setImage(desk);
    managerimage5.setImage(desk);
    
    loginimage.setImage(reception);
    loginimage2.setImage(reception);
    
    
    Stage dashboard =new Stage();
    
    Group loginLayout =new Group(loginimage);
    Group signupLayout= new Group(loginimage2);
    
    Group customerLayout =new Group(customerimage);
    Group menuLayout=new Group(customerimage2);
    Group checkoutLayout=new Group(customerimage3);
    Group thanksLayout=new Group(customerimage4);
    
    Group managerLayout=new Group(managerimage);
    Group manager_addLayout= new Group(managerimage2);
    Group manager_addDishLayout= new Group(managerimage3);
    Group manager_ordersLayout= new Group(managerimage4);
    Group manager_allTimeOrdersLayout= new Group(managerimage5);
    
    Group waiterLayout= new Group(waiterimage);
    Group cookerLayout= new Group(kitchenimage);
    
    
    cookerLayout.getChildren().addAll(logout2,show1);
    waiterLayout.getChildren().addAll(logout3,show2);
    thanksLayout.getChildren().addAll(thanks,home,exit);
    checkoutLayout.getChildren().addAll(LName,LDishes,LTotalPrice,back2,checkout);
    menuLayout.getChildren().addAll(menu,lMain,lAppetizer,lDesert,proceed);
    managerLayout.getChildren().addAll(Status,todayOrders,allTimeOrders,logout_Manager,addEmployee,addDish,LManager);
    manager_addLayout.getChildren().addAll(register_name,register_password,register_username,register_nametext,manager2,waiter2,cooker2 ,register_passwordtext,register_usernametext,back3,Register);
    manager_addDishLayout.getChildren().addAll(add_dish,dish_name,dish_nametext,dish_price,dish_pricetext,waiter3,cooker3 ,manager3,back4);
    manager_allTimeOrdersLayout.getChildren().addAll(allOrders,back5);
    manager_ordersLayout.getChildren().addAll(back6,todayorders,todaymoney);
    signupLayout.getChildren().addAll(signup2,back7,nameText2,userText2,passText2,user2,name2,pass2);
    customerLayout.getChildren().addAll(reserve,back,l1,l,l2,seatNo,yes,no,ok);
    loginLayout.getChildren().addAll(signup,error,login,manager,waiter,cooker,client,user,pass,close);       
    
    
    for(i=0;i<mainCourses.size();i++)
    menuLayout.getChildren().addAll(mainCourses.get(i),mainFields.get(i));
    for(i=0;i<appetizers.size();i++)
    menuLayout.getChildren().addAll(appetizers.get(i),appetizerFields.get(i));
    for(i=0;i<deserts.size();i++)
    menuLayout.getChildren().addAll(deserts.get(i),desertFields.get(i));
    
    
    
    Scene customerScene = new Scene(customerLayout,500,660);
    Scene menuScene = new Scene(menuLayout,900,400);
    Scene loginScene = new Scene(loginLayout,500,750);
    Scene checkoutScene=new Scene(checkoutLayout,600,400);
    Scene thanksScene=new Scene(thanksLayout,520,200);
    Scene managerScene=new Scene(managerLayout,1300,600);
    Scene manageraddScene=new Scene(manager_addLayout,600,360);
    Scene manageraddDishScene=new Scene(manager_addDishLayout,600,360);
    Scene orderLayoutScene=new Scene(manager_ordersLayout,500,500);
    Scene allTimeOrdersScene=new Scene(manager_allTimeOrdersLayout,500,500);
    Scene waiterScene=new Scene(waiterLayout,700,500);
    Scene cookerScene=new Scene(cookerLayout,600,580);
    Scene signupScene=new Scene(signupLayout,500,750);
    
  manageraddScene.getStylesheets().add("managerstyle.css");
  managerScene.getStylesheets().add("managerstyle2.css");
  manageraddDishScene.getStylesheets().add("managerstyle.css");
  orderLayoutScene.getStylesheets().add("managerstyle.css");
  allTimeOrdersScene.getStylesheets().add("managerstyle.css");
  customerScene.getStylesheets().add("customerstyle.css");
  menuScene.getStylesheets().add("customerstyle2.css");
  checkoutScene.getStylesheets().add("checkout.css");
  thanksScene.getStylesheets().add("thanksstyle.css");
  loginScene.getStylesheets().add("loginstyle.css");
  signupScene.getStylesheets().add("loginstyle.css");
    
    customerimage.setX(0); 
    customerimage.setY(0);
    customerimage.setFitHeight(700); 
    customerimage.setFitWidth(500);
    customerimage.setPreserveRatio(true);    
    
    customerimage2.setX(0); 
    customerimage2.setY(0);
    customerimage2.setFitHeight(400); 
    customerimage2.setFitWidth(900);
    customerimage2.setPreserveRatio(false);    
    
    customerimage3.setX(0); 
    customerimage3.setY(0);
    customerimage3.setFitHeight(580); 
    customerimage3.setFitWidth(600);
    customerimage3.setPreserveRatio(true);    
    
    customerimage4.setX(0); 
    customerimage4.setY(0);
    customerimage4.setFitHeight(580); 
    customerimage4.setFitWidth(600);
    customerimage4.setPreserveRatio(true);    
    
    kitchenimage.setX(0); 
    kitchenimage.setY(0);
    kitchenimage.setFitHeight(580); 
    kitchenimage.setFitWidth(600);
    kitchenimage.setPreserveRatio(false);    
    
    waiterimage.setX(0); 
    waiterimage.setY(0);
    waiterimage.setFitHeight(500); 
    waiterimage.setFitWidth(700);
    waiterimage.setPreserveRatio(false);    
    
    managerimage.setX(0); 
    managerimage.setY(0);
    managerimage.setFitHeight(600); 
    managerimage.setFitWidth(1300);
    managerimage.setPreserveRatio(false);    
    
    managerimage2.setX(0); 
    managerimage2.setY(0);
    managerimage2.setFitHeight(580); 
    managerimage2.setFitWidth(600);
    managerimage2.setPreserveRatio(true);    
    
    managerimage3.setX(0); 
    managerimage3.setY(0);
    managerimage3.setFitHeight(580); 
    managerimage3.setFitWidth(600);
    managerimage3.setPreserveRatio(true);    
    
    managerimage4.setX(0); 
    managerimage4.setY(0);
    managerimage4.setFitHeight(500); 
    managerimage4.setFitWidth(500);
    managerimage4.setPreserveRatio(false);    
    
    managerimage5.setX(0); 
    managerimage5.setY(0);
    managerimage5.setFitHeight(500); 
    managerimage5.setFitWidth(500);
    managerimage5.setPreserveRatio(false);    
    
    loginimage.setX(0); 
    loginimage.setY(0);
    loginimage.setFitHeight(750); 
    loginimage.setFitWidth(500);
    loginimage.setPreserveRatio(true);    
    
    loginimage2.setX(0); 
    loginimage2.setY(0);
    loginimage2.setFitHeight(750); 
    loginimage2.setFitWidth(500);
    loginimage2.setPreserveRatio(true);    
    
    
    LTotalPrice.setLayoutX(320);
    LTotalPrice.setLayoutY(checkoutScene.getHeight()-100);
    LTotalPrice.setStyle( "-fx-text-fill: #ffffff");
    
    back2.setLayoutX(350);
    back2.setLayoutY(checkoutScene.getHeight()-50);
    
    checkout.setLayoutX(450);
    checkout.setLayoutY(checkoutScene.getHeight()-50); 
    
    primaryStage.setScene(loginScene);
    primaryStage.setTitle("Restaurant");
    primaryStage.show();
    
   
    
    back.setOnAction(e->{
    dashboard.close();
    user.clear();
    pass.clear();
    yes.setSelected(false);
    no.setSelected(false);
    seatNo.clear();
    customerLayout.getChildren().remove(table);
    waiter.setSelected(false);
    manager.setSelected(false);
    client.setSelected(false);
    cooker.setSelected(false);
    primaryStage.show();
    
    });
     signup.setOnAction(e->{primaryStage.setScene(signupScene);});
     
     signup2.setOnAction(e->{
         
         rest.getUsers().add(new Customers(nameText2.getText(),userText2.getText(),passText2.getText()));
        try {
            a.writeInXml(rest.getUsers(), rest.getAvailableTables(), rest.getReservedTables(), rest.getMenu(), rest.getOrders());
        } catch (IOException ex) {
            Logger.getLogger(RestaurantReservation.class.getName()).log(Level.SEVERE, null, ex);
        }
         primaryStage.setScene(loginScene);});
     back7.setOnAction(e->{primaryStage.setScene(loginScene);});
    
     ok.setOnAction(e->{
        int j,x;
        
        table=new ListView<>();
        table.setLayoutX(100);
        table.setLayoutY(270);
        table.setMaxSize(560,300);
          
         customerLayout.getChildren().remove(ltable);
        if(yes.isSelected()&&no.isSelected())
        {   error3.setText("Invalid Choice");
            customerLayout.getChildren().remove(error3);
             customerLayout.getChildren().add(error3);
            
             
        }
        else if(yes.isSelected()&&isInt(seatNo.getText())&&Integer.parseInt(seatNo.getText())>0)
        {    x=Integer.parseInt(seatNo.getText());
            for(j=0;j<rest.getAvailableTables().size();j++)
                
            if(rest.getAvailableTables().get(j).isSmoking()&&x<=Integer.parseInt(rest.getAvailableTables().get(j).getNumberOfSeats()))
                
                table.getItems().add("Table Number: "+rest.getAvailableTables().get(j).getTableNumber().toString()+"  Seats Number:"+rest.getAvailableTables().get(j).getNumberOfSeats().toString());
                 customerLayout.getChildren().add(ltable);
                customerLayout.getChildren().add(table);
                dashboard.setScene(customerScene);}
        else if(no.isSelected()&&isInt(seatNo.getText())&&Integer.parseInt(seatNo.getText())>0)
        {  x=Integer.parseInt(seatNo.getText());
            for(j=0;j<rest.getAvailableTables().size();j++)
            if(!rest.getAvailableTables().get(j).isSmoking()&&x<=Integer.parseInt(rest.getAvailableTables().get(j).getNumberOfSeats()))
                table.getItems().add("Table Number: "+rest.getAvailableTables().get(j).getTableNumber().toString()+"  Seats Number:"+rest.getAvailableTables().get(j).getNumberOfSeats().toString());
             customerLayout.getChildren().add(ltable);
                customerLayout.getChildren().add(table);
                dashboard.setScene(customerScene);}
        else{error3.setText("Invalid Entry");
            customerLayout.getChildren().remove(error3);
             customerLayout.getChildren().add(error3);
            }
        
    });
    
    
    
    reserve.setOnAction(e->{
    ObservableList<String> reserveTable=table.getSelectionModel().getSelectedItems();
    s=reserveTable.get(0).split(" ")[2];
    dashboard.setScene(menuScene);
    customerLayout.getChildren().removeAll(table);
    yes.setSelected(false);
    no.setSelected(false);
   seatNo.clear();
       dashboard.show();
    });
    
    proceed.setOnAction(e->{
     order=new Order();
     currentTime = LocalTime.now();
     int x=rest.getNumberOfOrders();
     x++;
     int k;
     boolean flag=false;
    DishList lister=new DishList();
   
     for(k=0;k<mainCourses.size();k++)
         
        {
           
            if(mainCourses.get(k).isSelected())
        for(int j=0;j<rest.getMenu().size();j++)
            if(mainCourses.get(k).getText().equals(rest.getMenu().get(j).getName()))
            {  
                if(isInt(mainFields.get(k).getText())&&Integer.parseInt( mainFields.get(k).getText())>0)
                { 
                }
               else{ menuLayout.getChildren().remove(error2);
                    menuLayout.getChildren().add(error2);
                  dashboard.setScene(menuScene);
                  flag=true;
                 
                  
                 }
            }
        }
         for(k=0;k<appetizers.size();k++)
         { 
             if(appetizers.get(k).isSelected())
         for(int j=0;j<rest.getMenu().size();j++)
            if(appetizers.get(k).getText().equals(rest.getMenu().get(j).getName()))
            {
                 if(isInt(appetizerFields.get(k).getText())&&Integer.parseInt(appetizerFields.get(k).getText())>0)
                 { 
               }
                  else{ menuLayout.getChildren().remove(error2);
                     menuLayout.getChildren().add(error2);
                  dashboard.setScene(menuScene);
                   flag=true;
                   
                 }
            }
    }
        for(k=0;k<deserts.size();k++)
        { 
            if(deserts.get(k).isSelected())
        for(int j=0;j<rest.getMenu().size();j++)
            if(deserts.get(k).getText().equals(rest.getMenu().get(j).getName()))
               {
                if(isInt(desertFields.get(k).getText())&&Integer.parseInt(desertFields.get(k).getText())>0)
               { 
               }
                else{ menuLayout.getChildren().remove(error2);
                    menuLayout.getChildren().add(error2);
                  dashboard.setScene(menuScene);
                   flag=true;
                   
                    
                 }
            }
        }
        if(!flag){ order.setDishes( lister.getList(rest, mainCourses, appetizers, deserts, mainFields, appetizerFields, desertFields));
  
    order.setName(name);
    order.setTime(currentTime.toString());
    order.setDate(date.toString());
    order.setTableNumber(Integer.parseInt(s));
    
           int j;
            LName.setText("Name :"+order.getName()+"  Order Number :"+x+"\n       Dishes:");
            data="";
            for(j=0;j<order.getDishes().size();j++)
            data+=order.getDishes().get(j).getName()+"   "+ order.getDishes().get(j).getQuantity()+"   "+order.getDishes().get(j).getFinalPrice()+"\n";
            LDishes.setText(data);
            
            
            
            LTotalPrice.setText("Total Price of Order :"+order.getTotalPrice()+"");
         customerLayout.getChildren().remove(table);
        dashboard.setScene(checkoutScene);}
    });
    
    back2.setOnAction(e->{
    dashboard.setScene(menuScene);
    });
    
    checkout.setOnAction(e->{
        
           int j;
    rest.setNumberOfOrders(rest.getNumberOfOrders()+1);
    order.setOrderNumber((int)(rest.getNumberOfOrders()));
    rest.getOrders().add(order);
    for(j=0;j<rest.getAvailableTables().size();j++)
        if(s.equals(rest.getAvailableTables().get(j).getTableNumber()))
        {   rest.getReservedTables().add(rest.getAvailableTables().get(j));
            rest.getAvailableTables().remove(rest.getAvailableTables().get(j));
            
        }
    for(j=0;j<mainCourses.size();j++)
        {  
            mainCourses.get(j).setSelected(false);
            mainFields.get(j).clear();
        }
    for(j=0;j<appetizers.size();j++)
        {  
            appetizers.get(j).setSelected(false);
            appetizerFields.get(j).clear();
        }
    for(j=0;j<deserts.size();j++)
        {  
            deserts.get(j).setSelected(false);
            desertFields.get(j).clear();
        }
    dashboard.setScene(thanksScene);
    try {
            a.writeInXml(rest.getUsers(), rest.getAvailableTables(), rest.getReservedTables(), rest.getMenu(), rest.getOrders());
        } catch (IOException ex) {
            Logger.getLogger(RestaurantReservation.class.getName()).log(Level.SEVERE, null, ex);
        }
    });
    close.setOnAction(e-> {primaryStage.close();
   
    System.exit(0);
    });
     exit.setOnAction(e-> {primaryStage.close();
         for(Order a:rest.getOrders()){
    }
    System.exit(0);
    });
     
     
     Status.setOnAction(e->{
    managerLayout.getChildren().remove(lusers);
    managerLayout.getChildren().remove(lavtables);
    managerLayout.getChildren().remove(lrestables);
         int p;String u="";
           ObservableList<Users> us=FXCollections.observableArrayList();
           ObservableList<Tables> tb=FXCollections.observableArrayList();
           ObservableList<Tables> tb2=FXCollections.observableArrayList();
        for(p=0;p<rest.getUsers().size();p++){
        if(rest.getUsers().get(p).getRole().equalsIgnoreCase("Manager"))continue;
        us.add(rest.getUsers().get(p));
        TableColumn<Users,String> nameColumn=new TableColumn<>("Name");
        nameColumn.setMaxWidth(125);
        nameColumn.setCellValueFactory(new PropertyValueFactory("name"));
        
          TableColumn<Users,String> userNameColumn=new TableColumn<>("Username");
         userNameColumn.setMaxWidth(125);
         userNameColumn.setCellValueFactory(new PropertyValueFactory("username"));
        
          TableColumn<Users,String> passwordColumn=new TableColumn<>("Password");
        passwordColumn.setMaxWidth(150);
        passwordColumn.setCellValueFactory(new PropertyValueFactory("password"));
          TableColumn<Users,String> roleColumn=new TableColumn<>("Role");
        roleColumn.setMaxWidth(125);
        roleColumn.setCellValueFactory(new PropertyValueFactory("role"));
        table_users=new TableView<>();
        table_users.setItems(us);
        table_users.getColumns().addAll( nameColumn,userNameColumn,passwordColumn,roleColumn);
        table_users.setLayoutX(10);
        table_users.setLayoutY(60);
        table_users.setMinHeight(300);
        table_users.setMinWidth(460);
        managerLayout.getChildren().add(table_users);
       
    }
    for(p=0;p<rest.getAvailableTables().size();p++){
      tb.add(rest.getAvailableTables().get(p));
        TableColumn<Tables,String> nametColumn=new TableColumn<>("Table Number");
        nametColumn.setMaxWidth(125);
        nametColumn.setCellValueFactory(new PropertyValueFactory("tableNumber"));
        
          TableColumn<Tables,String> userNametColumn=new TableColumn<>("Smoking");
         userNametColumn.setMaxWidth(125);
         userNametColumn.setCellValueFactory(new PropertyValueFactory("smoking"));
        
          TableColumn<Tables,String> passwordtColumn=new TableColumn<>("Number of seats");
        passwordtColumn.setMaxWidth(150);
        passwordtColumn.setCellValueFactory(new PropertyValueFactory("numberOfSeats"));
       
        table_avtables=new TableView<>();
        table_avtables.setItems(tb);
        table_avtables.getColumns().addAll(nametColumn,userNametColumn,passwordtColumn);
        table_avtables.setLayoutX(500);
        table_avtables.setLayoutY(60);
        table_avtables.setMinHeight(300);
        table_avtables.setMinWidth(330);
        managerLayout.getChildren().add(table_avtables);
       
    }
     for(p=0;p<rest.getReservedTables().size();p++){
      tb2.add(rest.getReservedTables().get(p));
        TableColumn<Tables,String> nametColumn=new TableColumn<>("Table Number");
        nametColumn.setMaxWidth(125);
        nametColumn.setCellValueFactory(new PropertyValueFactory("tableNumber"));
        
          TableColumn<Tables,String> userNametColumn=new TableColumn<>("Smoking");
         userNametColumn.setMaxWidth(125);
         userNametColumn.setCellValueFactory(new PropertyValueFactory("smoking"));
        
          TableColumn<Tables,String> passwordtColumn=new TableColumn<>("Number of seats");
        passwordtColumn.setMaxWidth(150);
        passwordtColumn.setCellValueFactory(new PropertyValueFactory("numberOfSeats"));
       
        table_restables=new TableView<>();
       table_restables.setItems(tb2);
        table_restables.getColumns().addAll(nametColumn,userNametColumn,passwordtColumn);
        table_restables.setLayoutX(900);
        table_restables.setLayoutY(60);
       table_restables.setMinHeight(300);
        table_restables.setMinWidth(330);
        managerLayout.getChildren().add(table_restables);
       
    }
     managerLayout.getChildren().addAll(lusers,lavtables,lrestables);
    });
     
     
     todayOrders.setOnAction(e->{   
    TreeItem<String> root=new TreeItem<>("Orders");
    orders=new TreeView<>(root);
    orders.setShowRoot(true);
    todaymoney.setText("Total Money Earned Today :"+rest.getTodayMoney()+"$");
    for(int j=0;j<rest.getOrders().size();j++){
        TreeItem<String> ordernumber;
        TreeItem<String>  customerName;
        TreeItem<String> tableNumber;
        TreeItem<String> dishes;
        TreeItem<String> totalPrice;
        TreeItem<String> dishx;
        TreeItem<String> datex;
        
        if(!rest.getOrders().get(j).getDate().equals(date.toString()))continue;
        ordernumber=makeBranch("Order #"+rest.getOrders().get(j).getOrderNumber() +" "+rest.getOrders().get(j).getDate(),root);
        customerName=makeBranch("Customer Name:"+rest.getOrders().get(j).getName(),ordernumber);
        tableNumber=makeBranch("Table Number"+rest.getOrders().get(j).getTableNumber(),ordernumber);
        dishes=makeBranch("Dishes",ordernumber);
        for(int k=0;k<rest.getOrders().get(j).getDishes().size();k++){
            String d;
            d=rest.getOrders().get(j).getDishes().get(k).getName()+" "+rest.getOrders().get(j).getDishes().get(k).getQuantity()+" "+rest.getOrders().get(j).getDishes().get(k).getFinalPrice();
            dishx=makeBranch(d,dishes);}
        totalPrice=makeBranch("Totalprice:"+rest.getOrders().get(j).getTotalPrice(),ordernumber);
    }
    orders.setLayoutX(100);
    orders.setLayoutY(50);
    orders.setMinWidth(300);
manager_ordersLayout.getChildren().add(orders);
    dashboard.setScene(orderLayoutScene);
    dashboard.show();
  
    });
     
     back6.setOnAction(e->{
     manager_allTimeOrdersLayout.getChildren().remove(orders);
     dashboard.setScene(managerScene);
     });
     
     allTimeOrders.setOnAction(e->{
        
    TreeItem<String> root=new TreeItem<>("Orders");
    orders=new TreeView<>(root);
    orders.setShowRoot(true);
    for(int j=0;j<rest.getOrders().size();j++){
        TreeItem<String> ordernumber;
        TreeItem<String>  customerName;
        TreeItem<String> tableNumber;
        TreeItem<String> dishes;
        TreeItem<String> totalPrice;
        TreeItem<String> dishx;
      
        ordernumber=makeBranch("Order #"+rest.getOrders().get(j).getOrderNumber() +" "+rest.getOrders().get(j).getDate(),root);
        customerName=makeBranch("Customer Name:"+rest.getOrders().get(j).getName(),ordernumber);
        tableNumber=makeBranch("Table Number"+rest.getOrders().get(j).getTableNumber(),ordernumber);
        dishes=makeBranch("Dishes",ordernumber);
        for(int k=0;k<rest.getOrders().get(j).getDishes().size();k++){
            String d;
            d=rest.getOrders().get(j).getDishes().get(k).getName()+" "+rest.getOrders().get(j).getDishes().get(k).getQuantity()+" "+rest.getOrders().get(j).getDishes().get(k).getFinalPrice();
            dishx=makeBranch(d,dishes);}
        totalPrice=makeBranch("Totalprice:"+rest.getOrders().get(j).getTotalPrice(),ordernumber);
    }
    orders.setLayoutX(100);
    orders.setLayoutY(50);
    orders.setMinWidth(300);
    
    manager_allTimeOrdersLayout.getChildren().add(orders);
    dashboard.setScene(allTimeOrdersScene);
    dashboard.show();
  
    });
     back5.setOnAction(e->{
  
     dashboard.setScene(managerScene);
     });
   addDish.setOnAction(e->{
    
   dashboard.setScene(manageraddDishScene);
   
   });
   
   addEmployee.setOnAction(e->{
   
  
   dashboard.setScene(manageraddScene);
    
   });
   back3.setOnAction(e->{

   
  
    dashboard.setScene(managerScene);
   });
    back4.setOnAction(e->{
   
  
  
    dashboard.setScene(managerScene);
   });
   Register.setOnAction(e->{
   String username;
   String password;
   Users n=null;
        if(manager2.isSelected())
    {
        username=register_usernametext.getText();
        password=register_passwordtext.getText();
        n=new Manager(register_nametext.getText(),username,password);
      
    }
   
    else if(cooker2.isSelected())
    {
          username=register_usernametext.getText();
        password=register_passwordtext.getText();
        n=new Cooker(register_nametext.getText(),username,password);       
        
    }
    else if(waiter2.isSelected())
    {   
          username=register_usernametext.getText();
        password=register_passwordtext.getText();
        n=new Waiter(register_nametext.getText(),username,password); 
        
    }
       
   rest.getUsers().add(n);
      try {
            a.writeInXml(rest.getUsers(), rest.getAvailableTables(), rest.getReservedTables(), rest.getMenu(), rest.getOrders());
        } catch (IOException ex) {
            Logger.getLogger(RestaurantReservation.class.getName()).log(Level.SEVERE, null, ex);
        }
      waiter2.setSelected(false);
    manager2.setSelected(false);
    cooker2.setSelected(false);
    register_nametext.clear();
    register_passwordtext.clear();
    register_usernametext.clear();
    dashboard.setScene(managerScene);
   });
   add_dish.setOnAction(e->{
       manager_addDishLayout.getChildren().remove(error4);
   String username;
   String price;
   Dishes n=null;
   if(isFloat(dish_pricetext.getText())&&Float.parseFloat(dish_pricetext.getText())>0){
        if(manager3.isSelected())
    {  
        username=dish_nametext.getText();
       price=dish_pricetext.getText();
        n=new MainCourse(username,"main_course",Float.parseFloat(price));
      
    }
   
    else if(waiter3.isSelected())
    {
          username=dish_nametext.getText();
           price=dish_pricetext.getText();
        n=new Appetizer(username,"appetizer",Float.parseFloat(price));       
        
    }
    else if(cooker3.isSelected())
    {   
          username=dish_nametext.getText();
          price=dish_pricetext.getText();
        n=new Dessert(username,"desert",Float.parseFloat(price)); 
        
    }
       
   rest.getMenu().add(n);
   
      try {
            a.writeInXml(rest.getUsers(), rest.getAvailableTables(), rest.getReservedTables(), rest.getMenu(), rest.getOrders());
        } catch (IOException ex) {
            Logger.getLogger(RestaurantReservation.class.getName()).log(Level.SEVERE, null, ex);
        }
    waiter3.setSelected(false);
    manager3.setSelected(false);
    cooker3.setSelected(false);
    dish_nametext.clear();
    dish_pricetext.clear();
    
  
     dashboard.setScene(managerScene);
   }else{manager_addDishLayout.getChildren().add(error4);}
   });
     logout_Manager.setOnAction(e->{
     dashboard.close();
    primaryStage.show();
    user.clear();
    pass.clear();
   managerLayout.getChildren().remove(table_users);
    managerLayout.getChildren().remove(table_restables);
    managerLayout.getChildren().remove(table_avtables);
    managerLayout.getChildren().remove(lusers);
    managerLayout.getChildren().remove(lavtables);
    managerLayout.getChildren().remove(lrestables);
    waiter.setSelected(false);
    manager.setSelected(false);
    client.setSelected(false);
    cooker.setSelected(false);
     });
      home.setOnAction(e-> {primaryStage.close();
    dashboard.close();
    primaryStage.show();
    user.clear();
    pass.clear();
     waiter.setSelected(false);
    manager.setSelected(false);
    client.setSelected(false);
    cooker.setSelected(false);
    });
     
      show1.setOnAction(e->{
       TreeItem<String> root=new TreeItem<>("Orders");
    orders=new TreeView<>(root);
    orders.setShowRoot(true);
    for(int j=0;j<rest.getOrders().size();j++){
        TreeItem<String> ordernumber;
        TreeItem<String> tableNumber;
        TreeItem<String> dishes;
        TreeItem<String> dishx;
        
        if(!rest.getOrders().get(j).getDate().equals(date.toString()))continue;
        ordernumber=makeBranch("Order #"+rest.getOrders().get(j).getOrderNumber() +" "+rest.getOrders().get(j).getDate()+" "+rest.getOrders().get(j).getTime(),root);
        tableNumber=makeBranch("Table Number"+rest.getOrders().get(j).getTableNumber(),ordernumber);
        dishes=makeBranch("Dishes",ordernumber);
        for(int k=0;k<rest.getOrders().get(j).getDishes().size();k++){
            String d;
            d=rest.getOrders().get(j).getDishes().get(k).getName()+" "+rest.getOrders().get(j).getDishes().get(k).getQuantity()+" "+rest.getOrders().get(j).getDishes().get(k).getFinalPrice();
            dishx=makeBranch(d,dishes);}
        
    }
    orders.setLayoutX(100);
    orders.setLayoutY(50);
    orders.setMinWidth(300);
    cookerLayout.getChildren().add(orders);
  
           
      
      });
      
      logout2.setOnAction(e->{
      user.clear();
      pass.clear();
      cookerLayout.getChildren().remove(order);
      dashboard.close();
      primaryStage.show();
      });
      
      show2.setOnAction(e->{
      ObservableList<Order> tb2=FXCollections.observableArrayList();
            for(int p=0;p<rest.getOrders().size();p++){
            if(!rest.getOrders().get(p).getDate().equals(date.toString()))continue;
            tb2.add(rest.getOrders().get(p));
        
            TableColumn<Order,String> nametColumn=new TableColumn<>("Order Number");
            nametColumn.setMaxWidth(125);
            nametColumn.setCellValueFactory(new PropertyValueFactory("orderNumber"));
        
            TableColumn<Order,String> userNametColumn=new TableColumn<>("Customer Name");
            userNametColumn.setMaxWidth(125);
            userNametColumn.setCellValueFactory(new PropertyValueFactory("name"));
        
            TableColumn<Order,String> passwordtColumn=new TableColumn<>("Table Number");
            passwordtColumn.setMaxWidth(150);
            passwordtColumn.setCellValueFactory(new PropertyValueFactory("tableNumber"));
        
             TableColumn<Order,String> timetColumn=new TableColumn<>("Time");
            timetColumn.setMaxWidth(150);
            timetColumn.setCellValueFactory(new PropertyValueFactory("time"));
        
        ordertable=new TableView<>();
        ordertable.setItems(tb2);
        ordertable.getColumns().addAll(nametColumn,userNametColumn,timetColumn,passwordtColumn);
        ordertable.setLayoutX(20);
        ordertable.setLayoutY(10);
        ordertable.setMinHeight(300);
        ordertable.setMinWidth(460);
        waiterLayout.getChildren().add(ordertable);
            }
      
      });
      
      logout3.setOnAction(e->{
      user.clear();
      pass.clear();
      waiterLayout.getChildren().remove(ordertable);
      dashboard.close();
      primaryStage.show();
      });
      
      
    login.setOnAction(e->{
    String username;
    String password;
    Users n;
    
    if(manager.isSelected()&&!client.isSelected()&&!waiter.isSelected()&&!cooker.isSelected())
    {
        username=user.getText();
        password=pass.getText();
        pass.clear();
        if(rest.Validate(username, password)!=null&&rest.Validate(username, password).getRole().equalsIgnoreCase("manager"))
        {error.setText("");
           n=rest.Validate(username, password);
           name=n.getName();
           primaryStage.close();
          dashboard.setScene(managerScene);
          dashboard.show();
        }
        else{
           error.setText("WRONG ENTRY");
           
            
        }
    }
    else if(client.isSelected()&&!waiter.isSelected()&&!cooker.isSelected()&&!manager.isSelected())
    {
        username=user.getText();
        password=pass.getText();
        pass.clear();
        if(rest.Validate(username, password)!=null&&rest.Validate(username, password).getRole().equalsIgnoreCase("client"))
        {
            error.setText("");
            n=rest.Validate(username, password);
            name=n.getName();
            primaryStage.close();
            dashboard.setScene(customerScene);
            dashboard.show();
        }
        else{
            error.setText("WRONG ENTRY");
        }
    }
    else if(cooker.isSelected()&&!client.isSelected()&&!waiter.isSelected()&&!manager.isSelected())
    {   cookerLayout.getChildren().remove(orders);
        username=user.getText();
        password=pass.getText();          
        pass.clear();
          
            primaryStage.close();
            primaryStage.close();
        if(rest.Validate(username, password)!=null&&rest.Validate(username, password).getRole().equalsIgnoreCase("cooker"))
        {   error.setText("");
            n=rest.Validate(username, password);
            name=n.getName();
            
           
            dashboard.setScene(cookerScene);
            dashboard.show();
        }
        else{
            error.setText("WRONG ENTRY");
        }
    }
    else if(waiter.isSelected()&&!client.isSelected()&&!cooker.isSelected()&&!manager.isSelected())
    {   waiterLayout.getChildren().remove(ordertable);
        username=user.getText();
        password=pass.getText();
        pass.clear();
        
        if(rest.Validate(username, password)!=null&&rest.Validate(username, password).getRole().equalsIgnoreCase("waiter"))
        {   error.setText("");
            n=rest.Validate(username, password);
            name=n.getName();
            
            primaryStage.close();
            dashboard.setScene(waiterScene);
            dashboard.show();
        }
        else{
           error.setText("WRONG ENTRY OR CHOICE");
        }
    }
    else error.setText("INVALID CHOICE");
    
    });
    };
    
}
    







