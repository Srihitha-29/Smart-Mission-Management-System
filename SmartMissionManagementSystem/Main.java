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
            sc.nextLine();
            switch (choice) {
                case 1:
                    System.out.println("Enter Mission Details:");

                    System.out.print("Mission ID: ");
                    int missionId = sc.nextInt();
                    sc.nextLine();

                    System.out.print("Mission Name: ");
                    String missionName = sc.nextLine();

                    System.out.print("Launch Date (YYYY-MM-DD): ");
                    String launchDate = sc.nextLine();

                    System.out.print("Rocket Name: ");
                    String rocketName = sc.nextLine();

                    System.out.print("Budget: ");
                    double budget = sc.nextDouble();
                    sc.nextLine();

                    System.out.print("Status: ");
                    String status = sc.nextLine();

                    Mission mission = new Mission(missionId, missionName, launchDate, rocketName, budget, status);
                    service.addMission(mission);
                    break;
                case 2:
                    service.displayAll();
                    break;

                case 3:
                    System.out.print("Enter ID to search: ");
                    int id = sc.nextInt();
                    sc.nextLine();
                    Mission found = service.searchMissionById(id);
                    if (found != null) {
                        System.out.println("Mission Found:");
                        System.out.println(found);
                    } else {
                        System.out.println("Mission not found.");
                    }
                    break;

                case 4:
                    System.out.print("Enter ID: ");
                    int uid = sc.nextInt();
                    sc.nextLine();
                    System.out.print("Enter new status: ");
                    String newStatus = sc.nextLine();
                    service.updateStatus(uid, newStatus);
                    break;

                case 5:
                    System.out.print("Enter ID to delete: ");
                    int did = sc.nextInt();
                    sc.nextLine();
                    service.deleteMissionId(did);
                    break;

                case 0:
                    service.saveMissionsToFile();
                    System.out.println("Exiting program...");
                    sc.close();
                    return;

                default:
                    System.out.println("Invalid choice. Try again.");
            }
        }
    }
}
