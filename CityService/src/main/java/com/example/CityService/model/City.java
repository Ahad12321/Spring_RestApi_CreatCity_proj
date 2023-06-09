package com.example.CityService.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "City_info")
public class City {
    @Id
    private String id;
    private Date createDate=new Date();
    private String name;
}
