package com.nawest.rpsGame.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Room {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long rid;

    private Long p1id;
    private Long p2id;

    public Room() {
    }

    public Long getRid() {
        return rid;
    }

    public void setRid(Long rid) {
        this.rid = rid;
    }

    public Long getP1id() {
        return p1id;
    }

    public void setP1id(Long p1id) {
        this.p1id = p1id;
    }

    public Long getP2id() {
        return p2id;
    }

    public void setP2id(Long p2id) {
        this.p2id = p2id;
    }
}
