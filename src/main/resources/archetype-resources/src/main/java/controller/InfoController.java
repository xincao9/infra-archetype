#set( $symbol_pound = '#' )
#set( $symbol_dollar = '$' )
#set( $symbol_escape = '\' )
package ${package}.controller;

import ${package}.properties.InfoProperties;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

@RequestMapping("info")
@RestController
public class InfoController {

    @Resource
    private InfoProperties infoProperties;
    @Value("${symbol_dollar}{info.version}")
    private String version;

    @GetMapping
    public InfoProperties get() {
        return this.infoProperties;
    }

    @GetMapping("version")
    public String version() {
        return this.version;
    }
}
