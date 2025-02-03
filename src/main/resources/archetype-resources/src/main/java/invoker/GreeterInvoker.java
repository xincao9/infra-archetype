#set( $symbol_pound = '#' )
#set( $symbol_dollar = '$' )
#set( $symbol_escape = '\' )
package ${package}.invoker;

import com.github.xincao9.infra.archetype.GreeterRPCServiceGrpc;
import com.github.xincao9.infra.archetype.GreeterSayRequest;
import com.github.xincao9.infra.archetype.GreeterSayResponse;
import fun.golinks.grpc.pure.util.GrpcFunction;
import fun.golinks.grpc.pure.util.GrpcInvoker;
import org.springframework.stereotype.Component;

import javax.annotation.Resource;

@Component
public class GreeterInvoker {

    @Resource
    private GreeterRPCServiceGrpc.GreeterRPCServiceBlockingStub greeterRPCServiceBlockingStub;

    public final GrpcInvoker<GreeterSayRequest, GreeterSayResponse> sayInvoker = GrpcInvoker
            .wrap(new GrpcFunction<GreeterSayRequest, GreeterSayResponse>() {
                @Override
                public GreeterSayResponse apply(GreeterSayRequest greeterSayRequest) throws Throwable {
                    return greeterRPCServiceBlockingStub.say(greeterSayRequest);
                }
            });
}
