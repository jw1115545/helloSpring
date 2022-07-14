package com.example.hello.service;

import com.example.hello.dto.MusicDto;
import com.example.hello.repo.MusicRepository;
import com.example.hello.utils.MyApi;
import com.example.hello.vo.MusicVo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class MusicService {
    @Autowired
    private MusicRepository musicRepository;

    // 전체 데이터 조회
    public List<MusicVo> findAll() {
        List<MusicVo> music = new ArrayList<>();
        musicRepository.findAll().forEach(e -> music.add(e));
        return music;
    }

    // 데이터 넣기(insert)
    public Long save(MusicVo music) {
        return musicRepository.save(music).getId();
    }

    // 멜론 차트를 크롤링 해서 리스트를 전달
    public List<MusicDto> getMelonMusicList() {
        return MyApi.getMelonMusicList();
    }

}