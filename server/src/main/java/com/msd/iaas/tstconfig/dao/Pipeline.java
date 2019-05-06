package com.msd.iaas.tstconfig.dao;


import lombok.*;

import javax.persistence.*;

@Entity
@Getter
@Setter
@NoArgsConstructor
@ToString
@EqualsAndHashCode

public class Pipeline {

    @Id
    @GeneratedValue
    @Column(name = "id")
    private int id;

    @Column(name = "system")
    private String system;

    @Column(name = "location")
    private String location;

    @Column(name="s_url")
    private String s_url;

    @Column(name="s_user")
    private String s_user;

    @Column(name="t_url")
    private String t_url;

    @Column(name="t_user")
    private String t_user;

    @Column(name = "s_schema")
    private String s_schema;

    @Column(name = "t_schema")
    private String t_schema;

    @Column(name="s_jdbc")
    private String s_jdbc;

    @Column(name="t_jdbc")
    private String t_jdbc;

    @Column(name="json")
    private String json;

    @Column(name = "env")
    private String env;

    public void setId(int id) {
        this.id = id;
    }

    public void setSystem(String system) {
        this.system = system;
    }

    public void setLocation(String location) {
        this.location = location;
    }

    public void setS_url(String s_url) {
        this.s_url = s_url;
    }

    public void setS_user(String s_user) {
        this.s_user = s_user;
    }

    public void setT_url(String t_url) {
        this.t_url = t_url;
    }

    public void setT_user(String t_user) {
        this.t_user = t_user;
    }

    public void setS_schema(String s_schema) {
        this.s_schema = s_schema;
    }

    public void setT_schema(String t_schema) {
        this.t_schema = t_schema;
    }

    public void setS_jdbc(String s_jdbc) {
        this.s_jdbc = s_jdbc;
    }

    public void setT_jdbc(String t_jdbc) {
        this.t_jdbc = t_jdbc;
    }

    public void setJson(String json) {
        this.json = json;
    }

    public int getId() {
        return id;
    }

    public void setEnv(String env) {
        this.env = env;
    }
}
