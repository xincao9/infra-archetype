#set( $symbol_pound = '#' )
#set( $symbol_dollar = '$' )
#set( $symbol_escape = '\' )
package ${package}.controller;

import ${package}.properties.AppProperties;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

/**
 * 演示，读取配置中心
 */
@RequestMapping("app")
@RestController
public class AppController {

    @Resource
    private AppProperties appProperties;
    @Value("${symbol_dollar}{app.version}")
    private String version;

    @GetMapping
    public AppProperties get() {
        return this.appProperties;
    }

    @GetMapping("version")
    public String version() {
        return this.version;
    }
}
