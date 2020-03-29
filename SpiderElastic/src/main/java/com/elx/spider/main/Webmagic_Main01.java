package com.elx.spider.main;

import com.elx.spider.spider.JobPage;
import us.codecraft.webmagic.Spider;
import us.codecraft.webmagic.pipeline.ConsolePipeline;

public class Webmagic_Main01 {

    public static void main(String[] args) {

        String url = "";
        new Spider(new JobPage()).addPipeline(new ConsolePipeline()).addUrl("").thread(3).start();
    }
}
