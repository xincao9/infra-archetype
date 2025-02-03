#set( $symbol_pound = '#' )
#set( $symbol_dollar = '$' )
#set( $symbol_escape = '\' )
package ${package}.rpc;

import ${package}.consumer.GreeterConsumer;
import com.github.xincao9.infra.archetype.GreeterRPCServiceGrpc;
import com.github.xincao9.infra.archetype.GreeterSayRequest;
import com.github.xincao9.infra.archetype.GreeterSayResponse;
import io.grpc.stub.StreamObserver;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

@Service
public class GreeterRPCServiceImpl extends GreeterRPCServiceGrpc.GreeterRPCServiceImplBase {

    @Resource
    private GreeterConsumer greeterConsumer;

    @Override
    public void say(GreeterSayRequest request, StreamObserver<GreeterSayResponse> responseObserver) {
        greeterConsumer.sayConsumer.accept(request, responseObserver);
    }
}
