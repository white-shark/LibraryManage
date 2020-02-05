package com.example.test.entities;

public class Passreset {
    private String oldpass;
    private String newpass;
    private String confirmpass;

    public String getOldpass() {
        return oldpass;
    }

    public void setOldpass(String oldpass) {
        this.oldpass = oldpass;
    }

    public String getNewpass() {
        return newpass;
    }

    public void setNewpass(String newpass) {
        this.newpass = newpass;
    }

    public String getConfirmpass() {
        return confirmpass;
    }

    public void setConfirmpass(String confirmpass) {
        this.confirmpass = confirmpass;
    }
    public Passreset(){

    }

    public Passreset(String oldpass, String newpass, String confirmpass) {
        this.oldpass = oldpass;
        this.newpass = newpass;
        this.confirmpass = confirmpass;
    }

    @Override
    public String toString() {
        return "Passreset{" +
                "oldpass='" + oldpass + '\'' +
                ", newpass='" + newpass + '\'' +
                ", confirmpass='" + confirmpass + '\'' +
                '}';
    }
}
