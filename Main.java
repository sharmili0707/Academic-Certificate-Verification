import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        Blockchain certificateChain = new Blockchain();
        int index = 1;

        while (true) {
            System.out.println("\n==============================");
            System.out.println(" Academic Certificate Verification using Blockchain");
            System.out.println("==============================");
            System.out.println("1  Add New Certificate");
            System.out.println("2  Display Blockchain");
            System.out.println("3  Verify Certificate");
            System.out.println("4  Check Blockchain Validity");
            System.out.println("5  Exit");
            System.out.print("👉 Enter your choice: ");

            int choice = sc.nextInt();
            sc.nextLine(); // consume newline

            switch (choice) {
                case 1:
                    System.out.print("Enter Student Name: ");
                    String name = sc.nextLine();

                    System.out.print("Enter Course Name: ");
                    String course = sc.nextLine();

                    System.out.print("Enter Institution: ");
                    String institution = sc.nextLine();

                    System.out.print("Enter Certificate ID: ");
                    String certId = sc.nextLine();

                    Certificate cert = new Certificate(name, course, institution, certId);
                    certificateChain.addBlock(
                        new Block(index, certificateChain.getLatestBlock().hash, cert.toString())
                    );
                    index++;
                    System.out.println(" Certificate added successfully to Blockchain!");
                    break;

                case 2:
                    certificateChain.displayChain();
                    break;

                case 3:
                    System.out.print("Enter Certificate ID to verify: ");
                    String id = sc.nextLine();
                    certificateChain.verifyCertificate(id);
                    break;

                case 4:
                    System.out.println("Blockchain valid? " + certificateChain.isChainValid());
                    break;

                case 5:
                    System.out.println(" Exiting... Thank you for using the system!");
                    sc.close();
                    return;

                default:
                    System.out.println(" Invalid choice. Please try again.");
            }
        }
    }
}

