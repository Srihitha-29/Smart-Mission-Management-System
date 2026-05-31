import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        MissionService service = new MissionService();
        service.loadMissionsFromFile();
        while (true) {
            System.out.println("\n===== SMART MISSION MANAGEMENT =====");
            System.out.println("1. Add Mission");
            System.out.println("2. View All Missions");
            System.out.println("3. Search Mission");
            System.out.println("4. Update Mission Status");
            System.out.println("5. Delete Mission");
            System.out.println("0. Exit");
            System.out.print("Enter your choice: ");
            int choice = sc.nextInt();
            sc.nextLine(); // clear buffer Java will read the leftover \n immediately.
            switch (choice) {
                case 1:
                    System.out.println("Enter Mission Details:");

                    System.out.print("Mission ID: ");
                    int missionId = sc.nextInt();
                    sc.nextLine(); // clear buffer

                    System.out.print("Mission Name: ");
                    String missionName = sc.nextLine();

                    System.out.print("Launch Date: ");
                    String launchDate = sc.nextLine();

                    System.out.print("Rocket Name: ");
                    String rocketName = sc.nextLine();

                    System.out.print("Budget: ");
                    double budget = sc.nextDouble();
                    sc.nextLine(); // clear buffer

                    System.out.print("Status: ");
                    String status = sc.nextLine();

                    Mission mission = new Mission(missionId, missionName, launchDate, rocketName, budget, status);
                    service.addMission(mission);

                    break;

                case 2:
                    service.displayAll();
                    break;

                case 3:
                    System.out.print("Enter Id to search: ");
                    int id = sc.nextInt();
                    Mission found = service.searchMissionById(id);
                    if (found != null) {
                        System.out.print("Mission Found:");
                        System.out.println(found);
                    } else {
                        System.out.print("Mission not found.");
                    }
                    break;

                case 4:
                    System.out.print("Enter Id: ");
                    int Uid = sc.nextInt();
                    sc.nextLine();
                    System.out.print("Enter status: ");
                    String st = sc.nextLine();
                    service.updateStatus(Uid, st);
                    break;

                case 5:
                    System.out.print("Enter Id to delete: ");
                    int Did = sc.nextInt();
                    service.deleteMissionId(Did);
                    break;

                case 0:
                    service.saveMissionsToFile();
                    System.out.println("Exiting program...");
                    return;
                default:
                    System.out.print("Invalid choic. Try again");
            }
        }
    }
}