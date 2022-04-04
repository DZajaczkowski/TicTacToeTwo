package com.example.tictactoetwo.player;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import java.util.UUID;

import static javax.persistence.GenerationType.AUTO;

public class Player {

//    @Id
//    @GeneratedValue(strategy = AUTO)
    public long id;
    @Getter
    @Setter
    public String nickname;

}
