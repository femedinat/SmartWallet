package br.com.fiap.fintechproject.model;

public class Transaction {
    private int id;
    private String type;
    private int cdUser;
    private double value;

    public Transaction(int id, String type, double value, int cdUser) {
        this.id = id;
        this.type = type;
        this.value = value;
        this.cdUser = cdUser;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public int getCdUser() {
        return cdUser;
    }

    public void setCdUser(int cdUser) {
        this.cdUser = cdUser;
    }

    public double getValue() {
        return value;
    }

    public void setValue(double value) {
        this.value = value;
    }
}
