package config;

import com.navercorp.fixturemonkey.FixtureMonkey;
import com.navercorp.fixturemonkey.api.introspector.FieldReflectionArbitraryIntrospector;
import com.navercorp.fixturemonkey.jakarta.validation.plugin.JakartaValidationPlugin;
import java.util.List;
import java.util.Map;

public class FixtureMonkeyProvider {

    private static final FixtureMonkey INSTANCE = FixtureMonkey.builder()
        .objectIntrospector(FieldReflectionArbitraryIntrospector.INSTANCE)
        .plugin(new JakartaValidationPlugin())
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

    public static <T> T giveMeWithFields(Class<T> clazz, Map<String, Object> fields) {
        var builder = INSTANCE.giveMeBuilder(clazz);
        fields.forEach(builder::set);
        return builder.sample();
    }
}