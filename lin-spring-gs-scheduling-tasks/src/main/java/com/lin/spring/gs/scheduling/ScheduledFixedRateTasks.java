package com.lin.spring.gs.scheduling;

import java.text.SimpleDateFormat;
import java.time.LocalDateTime;
import java.util.Date;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

@Component
public class ScheduledFixedRateTasks {
	private static final Logger log = LoggerFactory.getLogger(ScheduledFixedRateTasks.class);

	private static final SimpleDateFormat dateFormat = new SimpleDateFormat("HH:mm:ss");

	@Scheduled(fixedRate = 5000)
	public void reportCurrentTime() {
		log.info("fixedRate = 5000,The time is now {}", dateFormat.format(new Date()));
	}
	@Scheduled(fixedDelay = 3000)
    public void scheduled3() throws InterruptedException {
        log.info("scheduled3 上次执行完毕后隔3秒继续执行：{}", LocalDateTime.now());
    }

	
}
