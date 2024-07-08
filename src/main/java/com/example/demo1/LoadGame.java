package com.example.demo1;

import javafx.stage.Stage;

import java.io.*;
import java.util.HashMap;
import java.util.InputMismatchException;
import java.util.Vector;
import java.util.Scanner;

class AppendingObjectOutputStream extends ObjectOutputStream {

    public AppendingObjectOutputStream(OutputStream out) throws IOException {
        super(out);
    }

    @Override
    protected void writeStreamHeader() throws IOException {
        reset();
    }
}

public class LoadGame implements Serializable { // singleton design pattern has been implemented. also the facade designe pattern.
    private static Vector<User> arr;
    private static Vector<User> rating;
    private static LoadGame load_game;


    private static File file2;

    private  LoadGame() {
        arr=new Vector<>();
        rating=new Vector<>();
        //file1=new File("C:\\Users\\leech\\IdeaProjects\\demo1\\src\\main\\java\\com\\example\\demo1\\leader_board.txt");
        file2=new File("C:\\Users\\leech\\IdeaProjects\\demo1\\src\\main\\java\\com\\example\\demo1\\list_users.txt");



        deserialize(arr,file2);
        User u1=null;
        User u2=null;
        User u3=null;
        rating.add(u1);
        rating.add(u2);
        rating.add(u3);
        int first=0;
        int second=0;
        int third=0;
        for (User user: arr) {
            if (user.getHighest_score()>first) {
                first=user.getHighest_score();
                u1=user;
            } else if (user.getHighest_score()>second) {
                second=user.getHighest_score();
                u2=user;
            } else if (user.getHighest_score()>third) {
                third=user.getHighest_score();
                u3=user;
            }
        }
        if (u1!=null) {
            rating.remove(0);
            rating.add(0,u1);
        }

        if (u2!=null) {
            rating.remove(1);
            rating.add(1,u2);
        }

        if (u3!=null) {
            rating.remove(2);
            rating.add(2,u3);
        }




        print_and_take_input();


    }

    public static void serialize(User user,File file2) {
        //ObjectOutputStream out=null;
//        try {
//            if (file2.length()==0 && file2.exists()) {
//                out=new ObjectOutputStream(new FileOutputStream(file2));
//                out.writeObject(user);
//            } else {
//                out=new ObjectOutputStream(new FileOutputStream(file2,true));
//                out.writeObject(user);
//            }
//        } catch (Exception e) {
//            System.out.println("exception in out");
//        }
        boolean append = file2.exists() && file2.length() > 0;

        try (ObjectOutputStream out = append ? new AppendingObjectOutputStream(new FileOutputStream(file2, true)) : new ObjectOutputStream(new FileOutputStream(file2))) {
            out.writeObject(user); // yourObject is the object you want to write
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void deserialize(Vector<User> arr,File file2) {
        ObjectInputStream in=null;
        try{
            if (file2.length()!=0) {
                in=new ObjectInputStream(new FileInputStream(file2));
                System.out.println("came here");
                boolean b=file2.length()!=0;
                while(true) {
                    try{
                        User u=(User)in.readObject();
                        System.out.println(u.get_name());
                        arr.add(u);
                    } catch (EOFException e) {
                        break;
                    }
                }
            }
        } catch (Exception e) {
            System.out.println("exception hai bc");
            System.out.println(e.getMessage());
            e.printStackTrace();
        }
    }

    private void print_and_take_input() {
        System.out.println("1. Register");
        System.out.println("2. Login");
        int choice=0;
        Scanner sc=new Scanner(System.in);
        try {
            choice=sc.nextInt();
            sc.nextLine();
        } catch (InputMismatchException e) {
            System.out.println("invalid input");
        }
        if (choice==1) {
            System.out.println("Enter the name");
            String name=sc.nextLine();
            System.out.println("Create a password");
            String password=sc.nextLine();
            boolean flag=false;
            for (User user: arr) {
                if (name.equals(user.get_name()) && password.equals(user.get_password())) {
                    System.out.println("Already registered please login to continue");
                    flag=true;
                    break;
                }
            }


            if (flag) {
                print_and_take_input();
            }
            User user=new User(name,password);
            arr.add(user);
            System.out.println("User successfully registered please login to continue");
            //serialize(user,file2);
            print_and_take_input();


        } else if (choice==2) {
            System.out.println("Enter the name");
            String name=sc.nextLine();
            System.out.println("Enter the password");
            String password=sc.nextLine();
            boolean flag=false;
            User u=null;
            for (User user: arr)  {
                if (name.equals(user.get_name()) && password.equals(user.get_password())) {
                    flag=true;
                    u=user;
                    break;
                }
            }

            if (flag) {
                frame1 obj=new frame1();
                frame1.setUser(u);
                HelloApplication objj=new HelloApplication();
                frame1.setObj(objj);
                frame1.l();
                //obj.launch();
                //obj.l();
            } else {
                System.out.println("Invalid user_name or password");
                print_and_take_input();
            }


        }
    }

    public static LoadGame get_load_game() {
        if (load_game==null) {
            load_game=new LoadGame();
        }
        return load_game;
    }

//    public static void add_high_scores(String name,int score) {
//        map.put(name,score);
//    }
//
//    public static void show() {
//        int count=1;
//        for (String name: map.keySet()) {
//            System.out.println(count+"  "+"name: "+name+"        "+map.get(name));
//        }
//    }

    public static Vector<User> get_users() {
        return arr;
    }

    public  static File getFile2() {
        return file2;
    }

    public static void delete_file_content() {
        FileOutputStream f1=null;
        try {
            f1=new FileOutputStream(file2);
        } catch (Exception e) {
            System.out.println("exception hai bc");
        }
    }

    public static void add_to_high_scores(User user,int index) {
        rating.add(index,user);
    }


    public static Vector<User> get_rating() {
        return rating;
    }




}
