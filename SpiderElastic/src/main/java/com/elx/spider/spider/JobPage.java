package com.elx.spider.spider;

import us.codecraft.webmagic.Page;
import us.codecraft.webmagic.Site;
import us.codecraft.webmagic.processor.PageProcessor;
import us.codecraft.webmagic.selector.Selectable;

import java.util.List;

/**
 * <h1>页面处理器</h1>
 */
public class JobPage implements PageProcessor {

    private Site site = Site.me().setSleepTime(200).setTimeOut(5).setRetryTimes(2);

    /**
     * <h2>页面内容处理</h2>
     * @param page
     */
    @Override
    public void process(Page page) {

//        page.getHtml().xpath("").nodes();
//        page.getHtml().css("").nodes();
        List<Selectable> list = page.getHtml().css("div#resultList div.el").nodes();
        if (list != null && list.size() != 0) {
            for (Selectable s : list) {
                s.
            }
        }

    }

    /**
     * <h2>站点信息</h2>
     * @return
     */
    @Override
    public Site getSite() {
        return site;
    }

}
