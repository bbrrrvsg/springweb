package springweb.chat;

import org.springframework.context.annotation.Configuration;
import org.springframework.messaging.simp.config.MessageBrokerRegistry;
import org.springframework.web.socket.config.annotation.EnableWebSocketMessageBroker;
import org.springframework.web.socket.config.annotation.StompEndpointRegistry;
import org.springframework.web.socket.config.annotation.WebSocketMessageBrokerConfigurer;


@Configuration // 빈(객체) (스프링컨테이너 에)등록, 스프링이 인식할 수 있도록 , IOC
@EnableWebSocketMessageBroker // [2] websocket + stomp 메시지 브로커 활성화
public class WebSocketConfig implements WebSocketMessageBrokerConfigurer {
    // implements : 인터페이스 구현(메소드정의)   vs   extends : 클래스 상속(물려받음)
    // 스프링프레임워크 장점 : 인터페이스 구조라서 만들어진 기능들을 재정의(커스텀) 가능하다.
    // 오버라이딩(재정의) vs 오버로딩(매개변수에따라 메소드/생성자 정의)
    // super(상위객체) vs this(현재객체)

    // [3] 메시지 브로커 설정
    @Override // (오버라이딩 )
    public void configureMessageBroker(MessageBrokerRegistry registry) {
        // [4] 구독 주소 설정 : 클라이언트가 설정한 주소를 요청(구독/연결된상태)하면 (서버에게) 메시지를 받을 수 있다.
        //    ws://localhost:8080/topic/ ~~~~ , ~~~ 은 컨트롤러에서 정의
        registry.enableSimpleBroker("/topic");
        // [5] 발행 주소 설정 : 클라이언트가 서버에게 메시지를 보낼 때 사용되는 주소 앞에 붙는 키워드
        //     ws://localhost:8080/app/ ~~~~   , ~~~ 은 컨트롤러에서 정의
        registry.setApplicationDestinationPrefixes("/app");
    }

    // [6] websocket 접속 주소 설정 : 엔드포인트( 메시지의 종착점 )
    @Override
    public void registerStompEndpoints(StompEndpointRegistry registry) {
        // [7]
        registry.addEndpoint("/ws") // 엔드포인트 : ws://localhost:8080/ws
                // .setAllowedOrigins( "http://localhost:5173") // 특정 도메인 허용
                .setAllowedOriginPatterns("*"); // 요청 가능한 도메인들 , *:모든도메인허용 , CORS
    }
}
