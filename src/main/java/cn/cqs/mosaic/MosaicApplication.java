package cn.cqs.mosaic;

import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.boot.Banner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@Slf4j
@SpringBootApplication
public class MosaicApplication implements ApplicationRunner {


    public static void main(String[] args) {
        SpringApplication application = new SpringApplication(MosaicApplication.class);
        application.setBannerMode(Banner.Mode.OFF);
        application.run(args);
    }

    @Override
    public void run(ApplicationArguments args) throws Exception {
        log.info("Mosaic Server Started! Try initializing...");
    }
}
