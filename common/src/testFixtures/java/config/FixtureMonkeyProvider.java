package config;

import com.navercorp.fixturemonkey.FixtureMonkey;
import java.util.List;

public class FixtureMonkeyProvider {

    private static final FixtureMonkey INSTANCE = FixtureMonkey.builder()
        .defaultNotNull(true)
        .build();

    // 단일 객체 생성
    public static <T> T giveMe(Class<T> clazz) {
        return INSTANCE.giveMe(clazz)
            .findFirst()
            .orElseThrow();
    }

    // 여러 객체 생성
    public static <T> List<T> giveMe(Class<T> clazz, int size) {
        return INSTANCE.giveMe(clazz, size);
    }
}