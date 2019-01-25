package com.entities;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;

@Entity
@Table(name="UserDetails")
public class UserDetails {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int userDetail_id;

    @Column(name="userDetail_name")
    private String userDetail_name;

    @Column(name="link_id")
    private int link_id;

    @ElementCollection
    @Column(name="UserDetails")
    private Set<Address> listOfAddress=new HashSet();

    public int getUserDetail_id() {
        return userDetail_id;
    }

    public void setUserDetail_id(int userDetail_id) {
        this.userDetail_id = userDetail_id;
    }

    public String getUserDetail_name() {
        return userDetail_name;
    }

    public void setUserDetail_name(String userDetail_name) {
        this.userDetail_name = userDetail_name;
    }

    public int getLink_id() {
        return link_id;
    }

    public void setLink_id(int link_id) {
        this.link_id = link_id;
    }

    /*public Set<Address> getListOfAddress() {
        return listOfAddress;
    }

    public void setListOfAddress(Set<Address> listOfAddress) {
        this.listOfAddress = listOfAddress;
    }*/
}
