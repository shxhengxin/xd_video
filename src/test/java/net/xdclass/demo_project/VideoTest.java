package net.xdclass.demo_project;

import junit.framework.TestCase;
import net.xdclass.demo_project.domain.Video;
import net.xdclass.demo_project.service.VideoService;
import org.junit.After;
import org.junit.Before;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;

import java.util.List;

/**
 * @ClassName : VideoTest  //类名
 * @Description :   //描述
 * @Author : shenhengxin  //作者
 * @Date: 2020-09-20 14:58  //时间
 */
@SpringBootTest(classes = {DemoProjectApplication.class})
@AutoConfigureMockMvc
public class VideoTest {
    @Autowired
    private VideoService videoService;
    @Autowired
    private MockMvc mockMvc;
    @Test
    public void testVideoListApi() throws Exception {
       MvcResult mvcResult = mockMvc.perform(MockMvcRequestBuilders.get("/api/v1/pub/video/list"))
                .andExpect(MockMvcResultMatchers.status().isOk()).andReturn();
        int status = mvcResult.getResponse().getStatus();
        System.out.println(status);
        String result = mvcResult.getResponse().getContentAsString();
        System.out.println(result);
    }

    @Before
    public void testBefore() {
        System.out.println("=====before=====");
    }

    @Test
    public void testVideoList() {
        List<Video> videos = videoService.listVideo();
        TestCase.assertTrue(videos.size()>0);
    }

    @After
    public void testAfter() {
        System.out.println("=====After=====");
    }
}
