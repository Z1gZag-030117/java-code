package pool;

public class Teacher {
    private int t_id;
    private String t_name;
    private int password;

    public Teacher() {
    }

    public Teacher(int t_id, String t_name, int password) {
        this.t_id = t_id;
        this.t_name = t_name;
        this.password = password;
    }

    public int getT_id() {
        return t_id;
    }

    public void setT_id(int t_id) {
        this.t_id = t_id;
    }

    public String getT_name() {
        return t_name;
    }

    public void setT_name(String t_name) {
        this.t_name = t_name;
    }

    public int getPassword() {
        return password;
    }

    @Override
    public String toString() {
        return "Teacher{" +
                "t_id=" + t_id +
                ", t_name='" + t_name + '\'' +
                ", password=" + password +
                '}';
    }

    public void setPassword(int password) {
        this.password = password;
    }
}
