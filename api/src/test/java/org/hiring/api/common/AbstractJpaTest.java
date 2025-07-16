package org.hiring.api.common;

import org.example.config.JpaAuditConfig;
import org.example.config.QueryDslConfig;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.context.annotation.Import;
import org.springframework.test.context.ActiveProfiles;

@DataJpaTest
@ActiveProfiles("test")
@Import({JpaAuditConfig.class, QueryDslConfig.class})
public abstract class AbstractJpaTest {

}
