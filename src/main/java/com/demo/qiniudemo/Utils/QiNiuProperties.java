package com.demo.qiniudemo.Utils;

import lombok.Data;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

/**
 * @author: Victor
 * @date: 2019/02/18
 */
@Component
@Data
@ConfigurationProperties(prefix = "qiniu")
public class QiNiuProperties {

    private String accessKey;

    private String secretKey;

    private String bucket;

    private String cdnPrefix;

}
