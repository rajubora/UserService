package com.lcwr.user.service.entity;



import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.Transient;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.Size;
import java.util.ArrayList;
import java.util.List;


@Entity
@Table(name = "users")
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class User {

    @Id
    @Column(name="ID")
    private  String userId;

     @Column(name = "user_name")
     @Size(max = 15)
    private String name;

     @Column(name = "user_email")
     private  String email;
     @Column(name = "user_description")
     @Size(max = 100)
     private  String about;

    @Transient
    private ArrayList<Rating> rating=new ArrayList<>();






}
