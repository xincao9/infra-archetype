#set( $symbol_pound = '#' )
#set( $symbol_dollar = '$' )
#set( $symbol_escape = '\' )
package ${package}.rpc.consumer;

import com.github.xincao9.infra.archetype.GreeterSayRequest;
import com.github.xincao9.infra.archetype.GreeterSayResponse;
import fun.golinks.grpc.pure.util.GrpcConsumer;
import org.springframework.stereotype.Component;

/**
 * 每个grpc service 实现对应一个Consumer类
 */
@Component
public class GreeterConsumer {

    public final GrpcConsumer<GreeterSayRequest, GreeterSayResponse> sayConsumer = GrpcConsumer
            .wrap(greeterSayRequest -> GreeterSayResponse.newBuilder()
                    .setMessage(String.format("Hello %s", greeterSayRequest.getName())).build());

}
