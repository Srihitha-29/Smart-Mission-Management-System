import java.util.ArrayList;
import java.io.*;

public class MissionService {
    private ArrayList<Mission> missions = new ArrayList<>();

    // Add Mission
    public void addMission(Mission mission) {
        // Validate ID
        if (mission.getMissionId() <= 0) {
            System.out.println("Mission ID must be positive.");
            return;
        }
        // Validate Budget
        if (mission.getBudget() < 0) {
            System.out.println("Budget can't be negative.");
            return;
        }
        // Duplicate check
        for (Mission m : missions) {
            if (m.getMissionId() == mission.getMissionId()) {
                System.out.println("Mission ID already exists.");
                return;
            }
        }

        missions.add(mission);
        System.out.println("Mission added successfully.");
        System.out.println("Total Missions: " + missions.size());
        saveMissionsToFile();
    }

    // Display All Missions
    public void displayAll() {
        if (missions.isEmpty()) {
            System.out.println("No missions available.");
            return;
        }
        for (Mission m : missions) {
            System.out.println(m);
        }
    }

    // Search Mission by ID
    public Mission searchMissionById(int id) {
        for (Mission mission : missions) {
            if (mission.getMissionId() == id) {
                return mission;
            }
        }
        return null;
    }

    // Delete Mission by ID
    public void deleteMissionId(int id) {
        Mission foundMission = searchMissionById(id);
        if (foundMission != null) {
            missions.remove(foundMission);
            System.out.println("Mission removed successfully.");
            saveMissionsToFile();
        } else {
            System.out.println("Mission not found.");
        }
        System.out.println("Total Missions: " + missions.size());
    }

    // Update Status
    public void updateStatus(int id, String newStatus) {
        Mission foundMission = searchMissionById(id);
        if (foundMission != null) {
            foundMission.setStatus(newStatus);
            System.out.println("Mission status updated successfully.");
            saveMissionsToFile();
        } else {
            System.out.println("Mission not found.");
        }
    }

    public void saveMissionsToFile() {
        try {
            BufferedWriter bw = new BufferedWriter(new FileWriter("missions.txt"));

            for (Mission m : missions) {
                String line = m.getMissionId() + "," +
                        m.getMissionName() + "," +
                        m.getLaunchDate() + "," +
                        m.getrocketName() + "," +
                        m.getBudget() + "," +
                        m.getStatus();

                bw.write(line);
                bw.newLine();
            }

            bw.close();
            System.out.println("Missions saved to file.");

        } catch (IOException e) {
            System.out.println("Error saving missions: " + e.getMessage());
        }
    }

    public void loadMissionsFromFile() {
        File file = new File("missions.txt");
        if (!file.exists()) {
            System.out.println("No saved missions found. Starting fresh.");
            return;
        }

        try {
            BufferedReader br = new BufferedReader(new FileReader(file));
            String line;

            while ((line = br.readLine()) != null) {
                String[] data = line.split(",");

                if (data.length < 6)
                    continue; // skip malformed lines

                int id = Integer.parseInt(data[0]);
                String name = data[1];
                String date = data[2];
                String rocket = data[3];
                double budget = Double.parseDouble(data[4]);
                String status = data[5];

                missions.add(new Mission(id, name, date, rocket, budget, status));
            }

            br.close();
            System.out.println("Loaded " + missions.size() + " mission(s) from file.");

        } catch (IOException e) {
            System.out.println("Error loading missions: " + e.getMessage());
        }
    }
}
