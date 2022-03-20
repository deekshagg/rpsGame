package com.nawest.rpsGame.request;

public class PlayGame {
    public Long pid;
    public String choice;
    public Long gid;


    public PlayGame() {
    }

    public PlayGame(Long pid, String choice, Long gid) {
        this.pid = pid;
        this.choice = choice;
        this.gid = gid;
    }

    public Long getPid() {
        return pid;
    }

    public void setPid(Long pid) {
        this.pid = pid;
    }

    public String getChoice() {
        return choice;
    }

    public void setChoice(String choice) {
        this.choice = choice;
    }

    public Long getGid() {
        return gid;
    }

    public void setGid(Long gid) {
        this.gid = gid;
    }

    @Override
    public String toString() {
        return "PlayGame{" +
                "pid=" + pid +
                ", choice='" + choice + '\'' +
                '}';
    }

}
