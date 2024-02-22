package justdoit.api.batch;

import lombok.extern.slf4j.Slf4j;
import net.javacrumbs.shedlock.spring.annotation.SchedulerLock;
import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

@Slf4j
@Component
@EnableScheduling
public class SampleBatch {

    /**
     * <pre>
     *      매 1분마다 배치 실행
     *      lockAtLeastFor : 작업이 lock 되어야 할 최소한 시간을 입력합니다.
     *      lockAtMostFor : 작업을 진행 중인 노드가 소멸될 경우에도 lock 이 유지될 시간을 입력합니다.
     *      50s: 50초
     *      50m: 50분
     *      1d: 하루
     * </pre>
     */
    //@Scheduled(cron = "0 */1 * * * *")
    //@SchedulerLock(name = "batchHelloWorld", lockAtLeastFor = "50s", lockAtMostFor = "55s")
    public void batchHelloWorld() {
        log.debug("####################################################################");
        log.debug("SampleBatch.batchHelloWorld() :: {}", "hello world");
        log.debug("####################################################################");
    }
}
