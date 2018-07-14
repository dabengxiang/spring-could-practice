package com.spring.could.client1.entity;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import javax.persistence.*;
import java.io.Serializable;
import java.math.BigDecimal;

@Entity
@JsonIgnoreProperties(value={"hibernateLazyInitializer","handler","fieldHandler"})
//@JsonIgnoreProperties
public class User implements Serializable {
  @Id
  @GeneratedValue(strategy = GenerationType.AUTO)
  private Long id;

  @Column
  private String username;

  @Column
  private String name;

  @Column
  private Short age;

  @Column
  private BigDecimal balance;

  public Long getId() {
    return this.id;
  }

  public void setId(Long id) {
    this.id = id;
  }

  public String getUsername() {
    return this.username;
  }

  public void setUsername(String username) {
    this.username = username;
  }

  public String getName() {
    return this.name;
  }

  public void setName(String name) {
    this.name = name;
  }

  public Short getAge() {
    return this.age;
  }

  public void setAge(Short age) {
    this.age = age;
  }

  public BigDecimal getBalance() {
    return this.balance;
  }

  public void setBalance(BigDecimal balance) {
    this.balance = balance;
  }

//  @Override
//  public String toString() {
//    return "User{" +
//            "id=" + id +
//            ", username='" + username + '\'' +
//            ", name='" + name + '\'' +
//            ", age=" + age +
//            ", balance=" + balance +
//            '}';
//  }
}
