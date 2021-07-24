package Mains;

public class Person {
    public String name;
    public String country;
    public int age;
    public double height;
    public String clubName;
    public String pos;
    public int number;
    public double weeklySalary;

    public Person(String name, String country, int age, double height, String clubName, String pos, int number, double weeklySalary) {
        this.name = name;
        this.country = country;
        this.age = age;
        this.height = height;
        this.clubName = clubName;
        this.pos = pos;
        this.number = number;
        this.weeklySalary = weeklySalary;
    }


    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public double getHeight() {
        return height;
    }

    public void setHeight(double height) {
        this.height = height;
    }

    public String getClubName() {
        return clubName;
    }

    public void setClubName(String clubName) {
        this.clubName = clubName;
    }

    public String getPos() {
        return pos;
    }

    public void setPos(String pos) {
        this.pos = pos;
    }

    public int getNumber() {
        return number;
    }

    public void setNumber(int number) {
        this.number = number;
    }

    public double getWeeklySalary() {
        return weeklySalary;
    }

    public void setWeeklySalary(double weeklySalary) {
        this.weeklySalary = weeklySalary;
    }
}

