import java.util.Scanner;

interface MessagingService
{
    void sendMessage();
}
class SMSMessagingservice implements MessagingService
{
    public void sendMessage()
    {
        System.out.println("Enter your Mobile Number : ");
        Scanner scan = new Scanner(System.in);
        String Mobile=scan.nextLine();
        if(Mobile.length()==10 && Integer.parseInt(String.valueOf(Mobile.charAt(0)))>=6 && Integer.parseInt(String.valueOf(Mobile.charAt(0)))<=9)
        {
            System.out.println("Enter Message :");
            String Message=scan.nextLine();
            System.out.println("Message Successfully Sent..");
        }
        else{
            System.out.println("Enter a valid Phone Number..");
        }
    }
}

class EmailMessagingservice implements MessagingService
{
    public void sendMessage()
    {
        System.out.println("Enter your Mail Id : ");
        Scanner scan = new Scanner(System.in);

        String Subject="";
        String Message="";
        String Email=scan.nextLine();
        String[] check=Email.split("@");
        String[] check2=Email.split("[.]");
        int Index1=Email.indexOf("@");
        int Index2=Email.indexOf(".");
        int Length=check.length+ check2.length;
        if(Length==4 && Index1<Index2)
        {
            System.out.println("Enter Your Subject : ");
            Subject=scan.nextLine();
            System.out.println("Enter Your Message : ");
            Message=scan.nextLine();
            System.out.println("Mail Sent..");

        }
        else{
            System.out.println("Enter valid Mail Address..");
        }
    }
}

class WhatsAppMessagingservice implements MessagingService {
    public void sendMessage() {
        System.out.println("Do you hove Whatsapp Enter 1. for yes & 2. for no :");
        Scanner scan = new Scanner(System.in);
        int option = scan.nextInt();
        scan.nextLine();
        if (option == 1) {
            System.out.println("Enter your Mobile Number : ");
            String Mobile = scan.nextLine();
            if (Mobile.length() == 10 && Integer.parseInt(String.valueOf(Mobile.charAt(0))) >= 6 && Integer.parseInt(String.valueOf(Mobile.charAt(0))) <= 9) {
                System.out.println("Enter Message :");
                String Message = scan.nextLine();
                System.out.println("Message Successfully Sent..");
            } else {
                System.out.println("Enter a valid Phone Number..");
            }


        } else {
            System.out.println("You can't Send Message you need to send create account");
        }
    }
}

class MessageApp {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        SMSMessagingservice smsMessagingservice = new SMSMessagingservice();
        EmailMessagingservice emailMessagingservice = new EmailMessagingservice();
        WhatsAppMessagingservice whatsAppMessagingservice = new WhatsAppMessagingservice();
        int option =0;
        do {
            System.out.println("Enter 1. for sending sms" + "\n" + "Enter 2. for sending Mail" + "\n" + "Enter 3. for sending Whatsapp message"+"\n"+"Enter 4. for Exit");
            option = scan.nextInt();
            if (option == 1) {
                smsMessagingservice.sendMessage();
            } else if (option == 2) {
                emailMessagingservice.sendMessage();
            } else if (option == 3) {
                whatsAppMessagingservice.sendMessage();
            }
            else if (option == 4) {
                System.out.println("Thank You Visit Again..!!");;
            }
            else {
                System.out.println("Invalid choice");
            }
        }
        while(option!=4);

    }
}
