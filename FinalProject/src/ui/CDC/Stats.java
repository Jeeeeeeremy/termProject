package ui.CDC;

public class Stats {
    String name;
    String count;

    public Stats() {
    }

    public Stats(String name, String count) {
        this.name = name;
        this.count = count;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getCount() {
        return count;
    }

    public void setCount(String count) {
        this.count = count;
    }

    @Override
    public String toString() {
        return "stats{" +
                "name='" + name + '\'' +
                ", count='" + count + '\'' +
                '}';
    }
}
