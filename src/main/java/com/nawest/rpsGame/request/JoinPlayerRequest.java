package com.nawest.rpsGame.request;

public class JoinPlayerRequest {
    public Long gid;
    public String name;
    public String country;

    public JoinPlayerRequest(Long gid, String name, String country) {
        this.gid = gid;
        this.name = name;
        this.country = country;
    }

    public JoinPlayerRequest() {
    }

    public Long getGid() {
        return gid;
    }

    public void setGid(Long gid) {
        this.gid = gid;
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

    @Override
    public String toString() {
        return "JoinPlayerRequest{" +
                "gid=" + gid +
                ", name='" + name + '\'' +
                ", country='" + country + '\'' +
                '}';
    }

}
