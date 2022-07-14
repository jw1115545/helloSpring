package com.example.hello.vo;

import lombok.*;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Data
@AllArgsConstructor
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@Entity(name="tb_music")
public class MusicVo {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private int rank;
    private String song;
    private String gasu;

    @Builder
    public MusicVo(int rank, String song,  String gasu) {
        this.rank = rank;
        this.song = song;
        this.gasu = gasu;
    }

}