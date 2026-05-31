class Mission {
    private int missionId;
    private String missionName;
    private String launchDate;
    private String rocketName;
    private double budget;
    private String status;

    public Mission(int missionId, String missionName, String launchDate, String rocketName, double budget,
            String status) {
        this.missionId = missionId;
        this.missionName = missionName;
        this.launchDate = launchDate;
        this.rocketName = rocketName;
        this.budget = budget;
        this.status = status;
    }

    public int getMissionId() {
        return missionId;
    }

    public void setMissionId(int missionId) {
        this.missionId = missionId;
    }

    public String getMissionName() {
        return missionName;
    }

    public void setMissionName(String missonName) {
        this.missionName = missionName;
    }

    public String getLaunchDate() {
        return launchDate;
    }

    public void setLaunchDate(String launchDate) {
        this.launchDate = launchDate;
    }

    public String getrocketName() {
        return launchDate;
    }

    public void setrocketName(String rocketName) {
        this.rocketName = rocketName;
    }

    public double getBudget() {
        return budget;
    }

    public void setBudget(double budget) {
        this.budget = budget;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    @Override
    public String toString() {
        return "Mission ID: " + missionId +
                "\nMission Name: " + missionName +
                "\nLaunch Date: " + launchDate +
                "\nRocket Name: " + rocketName +
                "\nBudget: " + budget +
                "\nStatus: " + status +
                "\n----------------------";

    }

    // public static void main(String[] args) {
    // MissionService service = new MissionService();
    // Mission m1 = new Mission(1, "Chandrayaan", "2025-03-10", "LVM3", 250000000,
    // "Planned");
    // // System.out.println(m1);
    // service.addMission(m1);
    // service.displayAll();

    // }
}
