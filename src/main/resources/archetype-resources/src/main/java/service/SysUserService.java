#set( $symbol_pound = '#' )
#set( $symbol_dollar = '$' )
#set( $symbol_escape = '\' )
package ${package}.service;

import com.baomidou.mybatisplus.extension.service.IService;
import ${package}.entity.SysUser;

public interface SysUserService extends IService<SysUser> {

    SysUser findByName(String name);
}
