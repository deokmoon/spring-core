package hello.core.scan;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.FilterType;

@Configuration
@ComponentScan(
        basePackages = "hello.core.member", // default 해당 Config 가 속한 위치부터 하위
        excludeFilters = @ComponentScan.Filter(type = FilterType.ANNOTATION, classes = Configuration.class)
) // 해당 Config 가 잘 동작하는지 확인하기 위해서는 기존 AppConfig 등 다른 Configuration에 수기로 등록한 빈들을 제외 필요
public class AutoAppConfig {
}
