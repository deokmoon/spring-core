package hello.core.lifecycle;

import org.springframework.beans.factory.DisposableBean;
import org.springframework.beans.factory.InitializingBean;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;

public class NetworkClient { // implements InitializingBean, DisposableBean
    private String url;

    public NetworkClient() {
        System.out.println("생성자 호출, url = " + url);
        connect();
        call("초기화 연결 메세지");
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public void connect() {
        System.out.println("connect: " + url);
    }

    public void call(String message) {
        System.out.println("call: " + url + " message: " + message);
    }

    // 서비스 종료 시
    public void disconnect() {
        System.out.println("close: " + url);
    }

    @PostConstruct
    public void init() throws Exception {
        System.out.println();
        call("초기화 연결 메시지");
        connect();
    }

    @PreDestroy
    public void close() throws Exception {
        System.out.println();
        disconnect();
    }

    // InitializingBean
//    @Override
//    public void afterPropertiesSet() throws Exception {
//        System.out.println();
//        call("초기화 연결 메시지");
//        connect();
//    }
    // DisposableBean
//    @Override
//    public void destroy() throws Exception {
//        System.out.println();
//        disconnect();
//    }
}
