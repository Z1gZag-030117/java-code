package com.jdbc;

/**
 * @author 朱喆
 * @version 1.0
 */
public class animal {
    private int ID;
    private String park;
    private String name;
    private String variety;
    private int nice;


    public int getID() {
        return ID;
    }

    public void setID(int ID) {
        this.ID = ID;
    }

    public String getPark() {
        return park;
    }

    public void setPark(String park) {
        this.park = park;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getVariety() {
        return variety;
    }

    public void setVariety(String variety) {
        this.variety = variety;
    }

    public int getNice() {
        return nice;
    }

    public void setNice(int nice) {
        this.nice = nice;
    }

    @Override
    public String toString() {
        return "animal{" +
                "ID=" + ID +
                ", park='" + park + '\'' +
                ", name='" + name + '\'' +
                ", variety='" + variety + '\'' +
                ", nice=" + nice +
                '}';
    }
}
