public class Euro2024 {

    private int ID;
    private String team1;
    private String team2;
    private String date;
    private String city;
    private int capacity;

    public Euro2024(int ID, String team1, String team2, String date, String city, int capacity) {
        this.ID = ID;
        this.team1 = team1;
        this.team2 = team2;
        this.date = date;
        this.city = city;
        this.capacity = capacity;
    }

    public int getID() {
        return ID;
    }

    public void setID(int ID) {
        this.ID = ID;
    }

    public String getTeam1() {
        return team1;
    }

    public void setTeam1(String team1) {
        this.team1 = team1;
    }

    public String getTeam2() {
        return team2;
    }

    public void setTeam2(String team2) {
        this.team2 = team2;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public int getCapacity() {
        return capacity;
    }

    public void setCapacity(int capacity) {
        this.capacity = capacity;
    }

    @Override
    public String toString() {
        return "Euro2024{" +
                "ID=" + ID +
                ", team1='" + team1 + '\'' +
                ", team2='" + team2 + '\'' +
                ", date='" + date + '\'' +
                ", city='" + city + '\'' +
                ", capacity=" + capacity +
                '}';
    }
}
