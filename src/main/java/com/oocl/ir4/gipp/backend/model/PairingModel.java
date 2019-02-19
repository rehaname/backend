package com.oocl.ir4.gipp.backend.model;

import javax.persistence.*;

@Entity
@Table(name = "TOOL_PAIRING")
public class PairingModel {
    @Id
    @GeneratedValue(strategy= GenerationType.AUTO)
    private Integer id;

    private String name;
    private String name1;
    private Integer pairCount;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getName1() {
        return name1;
    }

    public void setName1(String name1) {
        this.name1 = name1;
    }

    public Integer getPairCount() {
        return pairCount;
    }

    public void setPairCount(Integer pairCount) {
        this.pairCount = pairCount;
    }

}
