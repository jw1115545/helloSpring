package com.example.hello.utils;

import com.example.hello.dto.MusicDto;
import org.jsoup.Connection;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class MyApi {
    public static List<MusicDto> getMelonMusicList() {

        final String stockList = "https://www.melon.com/chart/index.htm";
        Connection conn = Jsoup.connect(stockList);
        List<MusicDto> list = new ArrayList<>();
        try {
            Document document = conn.get();
            Elements stockTableBody = document.select("div.wrap_song_info");
            List<String> songList = new ArrayList<>();
            int rank = 1;
            for (Element element : stockTableBody.select("div.ellipsis.rank01")) {
                String song = element.select("a").text();   // 노래 제목
                songList.add(song);
//                System.out.println((rank++) + ": " + song);
            }
            rank = 1;
            for (Element element : stockTableBody.select("span.checkEllipsis")) {
                String gasu = element.select("a").text();   // 노래 제목
                MusicDto dto = new MusicDto();
                dto.setSong(songList.get(rank-1));
                dto.setGasu(gasu);
                dto.setRank(rank++);
                list.add(dto);
//                System.out.println((rank++) + ": " + song);
            }
        } catch (IOException ignored) {
        }
        return list;
    }


}