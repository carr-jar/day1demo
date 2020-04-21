package com.zhuyoupeng.serviceUserInterface;

import lombok.Data;

import java.io.Serializable;
import java.util.Date;

@Data
public class Order implements Serializable {
    private Integer id;
    private String name;
    private Date create;
    private String username;
}
