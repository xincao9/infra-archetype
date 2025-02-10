#set( $symbol_pound = '#' )
#set( $symbol_dollar = '$' )
#set( $symbol_escape = '\' )
package ${package}.controller;

import ${package}.entity.SysUser;
import ${package}.invoker.GreeterInvoker;
import ${package}.service.SysUserService;
import ${package}.vo.GreeterSayRequestVO;
import ${package}.vo.GreeterSayResponseVO;
import com.github.xincao9.infra.archetype.GreeterSayRequest;
import com.github.xincao9.infra.archetype.GreeterSayResponse;
import fun.golinks.core.annotate.RateLimited;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import javax.validation.Valid;

/**
 * 演示，一般的业务流程
 */
@RestController
@RequestMapping("greeter")
@Validated
@Tag(name = "问候模块")
public class GreeterController {

    @Resource
    private SysUserService sysUserService;
    @Resource
    private GreeterInvoker greeterInvoker;

    @Operation(summary = "问候说话", description = "根据你输入的名字，返回对这个名字的问候消息")
    @RateLimited(permitsPerSecond = 10)
    @PostMapping("say")
    public GreeterSayResponseVO say(@Valid @RequestBody GreeterSayRequestVO greeterSayRequestVO) throws Throwable {
        // 读取数据库
        SysUser sysUser = sysUserService.findByName(greeterSayRequestVO.getName());
        if (sysUser == null) {
            return null;
        }
        // 调用grpc服务
        GreeterSayRequest request = GreeterSayRequest.newBuilder().setName(sysUser.getEmail()).build();
        GreeterSayResponse response = greeterInvoker.sayInvoker.apply(request);
        return new GreeterSayResponseVO(response.getMessage());
    }
}
