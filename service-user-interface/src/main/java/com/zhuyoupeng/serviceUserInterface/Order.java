package com.zhuyoupeng.serviceUserInterface;

import com.baomidou.mybatisplus.annotation.TableField;
import lombok.Data;

import java.io.Serializable;
import java.util.Date;

@Data
public class Order implements Serializable {
    private Integer id;
    private String name;
    private Date create;
    private Integer uid;
    @TableField("username")
    private String username;
}
