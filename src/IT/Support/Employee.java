package IT.Support;

import java.util.Random;
import java.util.Scanner;

public class Employee {
    private String firstName;
    private String lastName;
    private String pass;
    private String email;
    String department;

    public Employee(String firstName, String lastName){
        this.firstName=firstName;
        this.lastName=lastName;
        this.pass = this.generatePassword();
        this.email = this.generateEmail();
    }

    public  String generateEmail(){
        String tail = "@greatlearning.com";
        return this.firstName + this.lastName + tail;
    }

    public String generatePassword(){
        String capitalLetters = "ABCDEFGHIJKLMNOPQRSTUVWXYZ";
        String smallLetter = "abcdefghijklmnopqrstuvwxyz";
        String number = "0123456789";
        String specialCharacter = "@#$&*";
        String combine = capitalLetters + smallLetter + number + specialCharacter;

        Random random = new Random();
        char[] password = new char[8];
//        password[0] = capitalLetters.charAt(random.nextInt(capitalLetters.length()));
//        password[1] = smallLetter.charAt(random.nextInt(smallLetter.length()));
//        password[2] = number.charAt(random.nextInt(number.length()));
//        password[3] = specialCharacter.charAt(random.nextInt(specialCharacter.length()));

        password[0] = capitalLetters.charAt(random.nextInt(capitalLetters.length()));
        password[1] = smallLetter.charAt(random.nextInt(smallLetter.length()));
        password[2] = number.charAt(random.nextInt(number.length()));
        password[3] = specialCharacter.charAt(random.nextInt(specialCharacter.length()));

        for (int i=4; i<8; i++){
            password[i] = combine.charAt(random.nextInt(combine.length()));
        }

        String pass = new String(password);
//        for (int i=0; i<password.length; i++){
//            System.out.println(password[i]);
//        }
        return pass;
    }

    public void departmentOfCompany(){
        Scanner sc = new Scanner(System.in);
        System.out.println("Please Enter the department from the followint ");
        System.out.println("1. Techenical");
        System.out.println("2. Admin");
        System.out.println("3. Human Resorces");
        System.out.println("4. Legal");
        int num = sc.nextInt();
        switch(num){
            case 1:
                this.department = "Technical";
                break;

            case 2:
                this.department = "Admin";
                break;

            case 3:
                this.department = "Human Resorses";
                break;

            case 4:
                this.department = "Leagal";
                break;
        }

    }

    public void showCredential(){
        this.departmentOfCompany();
        System.out.println("Dear " + this.firstName + " your generated credential are as following");
        System.out.println("your email is : " + this.email);
        System.out.println("your password is : " + this.pass);
    }

    public static void main(String[] args) {
        Employee anant = new Employee("anantram", "patel");
        anant.showCredential();

//        ruf anant = new ruf();
//        char[] a;
//        a = anant.generatePassword(8);
//        System.out.println(a);
    }
}
