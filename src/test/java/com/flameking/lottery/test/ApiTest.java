package com.flameking.lottery.test;

import com.alibaba.fastjson.JSON;
import com.flameking.lottery.rpc.IActivityBooth;
import com.flameking.lottery.rpc.dto.ActivityDto;
import com.flameking.lottery.rpc.req.ActivityReq;
import lombok.extern.slf4j.Slf4j;
import org.apache.dubbo.config.annotation.Reference;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.Date;

/**
 * @author WangWei
 * @dateTime 2023/6/20 16:59
 */
@RunWith(SpringRunner.class)
@SpringBootTest
@Slf4j
public class ApiTest {


  @Reference(interfaceClass = IActivityBooth.class, url = "dubbo://127.0.0.1:20880")
  IActivityBooth activityBooth;


  @Test
  public void test_insert() {
    ActivityDto activityDto = new ActivityDto();
    activityDto.setActivityId(100001L);
    activityDto.setActivityName("618限时特惠活动");
    activityDto.setActivityDesc("活动期间，所有参加活动的商品均享受低至6折的特惠折扣，数量有限，先到先得。此次活动参与商品包括手机、电脑、智能家居等多个品类。快来抢购吧！");
    activityDto.setBeginDateTime(new Date());
    activityDto.setEndDateTime(new Date());
    activityDto.setStockCount(1000);
    activityDto.setTakeCount(1);
    activityDto.setState(0);
    activityBooth.create(activityDto);
  }

  @Test
  public void test_select() {
    ActivityReq req = new ActivityReq();
    req.setActivityId(100001L);

    log.info("测试结果：{}", JSON.toJSONString(activityBooth.queryActivityById(req).getActivity()));
  }

}
