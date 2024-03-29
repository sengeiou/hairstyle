package com.gaocimi.flashpig.entity;

import javax.persistence.*;
import java.util.Date;


/**
 * User - 用户订单类
 *
 *@author xp
 * @date 2019-9-23 03:14:25
 */
@Entity
@Table(name = "haircut_order")
public class HaircutOrder {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    /**该订单中用户提交的联系电话（考虑到用户自身没有绑定手机号码）*/
    @Column(nullable = false)
    private String userPhone;

    /**提交该订单的用户； 定义名为user_id的外键列，该外键引用user表的主键(id)列,采用懒加载*/
    @ManyToOne(targetEntity = User.class, fetch = FetchType.LAZY)
    @JoinColumn(name = "user_id", nullable = false)
    public User user;

    /**该订单对应的发型师； 定义名为hairstylist_id的外键列，该外键引用hairstylist表的主键(id)列,采用懒加载*/
    @ManyToOne(targetEntity = Hairstylist.class, fetch = FetchType.LAZY)
    @JoinColumn(name = "hairstylist_id", nullable = false)
    public Hairstylist hairstylist;

    /**该订单选取的服务； 定义名为service_id的外键列，该外键引用hair_service表的主键(id)列,采用懒加载*/
    @ManyToOne(targetEntity = HairService.class, fetch = FetchType.LAZY)
    @JoinColumn(name = "service_id", nullable = false)
    public HairService hairService;


    /**订单创建时间*/
    @Column(nullable = false)
    private Date createTime;

    /**预约时间*/
    @Column(nullable = false)
    private Date bookTime;

    /**订单状态 “0”表示订单正在进行中，”1“表示已完成，”-1“表示订单已取消，”-2“表示订单被拒绝*/
    @Column(nullable = false)
    private Integer status;

    /**订单完成后用户的评价*/
    @Column(nullable = true)
    private String comment;

    /**订单完成后用户的评分*/
    @Column(nullable = true)
    private Double point;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public Hairstylist getHairstylist() {
        return hairstylist;
    }

    public void setHairstylist(Hairstylist hairstylist) {
        this.hairstylist = hairstylist;
    }

    public HairService getHairService() {
        return hairService;
    }

    public void setHairService(com.gaocimi.flashpig.entity.HairService hairService) {
        this.hairService = hairService;
    }

    public Date getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    public Integer getStatus() {
        return status;
    }

    public void setStatus(Integer status) {
        this.status = status;
    }

    public Date getBookTime() {
        return bookTime;
    }

    public void setBookTime(Date bookTime) {
        this.bookTime = bookTime;
    }

    public String getComment() {
        return comment;
    }

    public void setComment(String comment) {
        this.comment = comment;
    }

    public Double getPoint() {
        return point;
    }

    public void setPoint(Double point) {
        this.point = point;
    }

    public String getUserPhone() {
        return userPhone;
    }

    public void setUserPhone(String userPhone) {
        this.userPhone = userPhone;
    }
}