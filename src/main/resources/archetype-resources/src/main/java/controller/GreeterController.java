#set( $symbol_pound = '#' )
#set( $symbol_dollar = '$' )
#set( $symbol_escape = '\' )
package ${package}.controller;

import com.github.xincao9.infra.archetype.GreeterSayRequest;
import com.github.xincao9.infra.archetype.GreeterSayResponse;
import ${package}.entity.SysUser;
import ${package}.invoker.GreeterInvoker;
import ${package}.service.SysUserService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

@RestController
@RequestMapping("greeter")
public class GreeterController {

    @Resource
    private SysUserService sysUserService;
    @Resource
    private GreeterInvoker greeterInvoker;

    @GetMapping("say")
    public String say(@RequestParam("name") String name) throws Throwable {
        SysUser sysUser = sysUserService.findByName(name);
        if (sysUser == null) {
            return null;
        }
        GreeterSayRequest request = GreeterSayRequest.newBuilder().setName(sysUser.getEmail()).build();
        GreeterSayResponse response = greeterInvoker.SAY_INVOKER.apply(request);
        return response.getMessage();
    }
}
