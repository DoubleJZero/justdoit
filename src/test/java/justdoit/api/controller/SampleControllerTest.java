package justdoit.api.controller;

import justdoit.api.dto.response.SampleResponse;
import justdoit.api.payload.Response;
import justdoit.api.service.SampleService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.HttpStatus;

import static org.junit.jupiter.api.Assertions.assertEquals;

@WebMvcTest(SampleController.class)
@ExtendWith(MockitoExtension.class)
public class SampleControllerTest {

    @MockBean
    private SampleService sampleService;

    private SampleService service;

    private SampleController controller;

    @BeforeEach
    void init() {
        this.service = new SampleService();
        this.controller = new SampleController(service);
    }

    @Test
    @DisplayName("헬로우_월드!")
    void sample() {

        Response<SampleResponse> response = controller.getHelloWorld();
        SampleResponse resp = service.getHelloWorld();

        assertEquals(response.getStatus(), HttpStatus.OK.value());

        System.out.println("##### response.getStatus() :: "
                + response.getStatus()
                + ", HttpStatus.OK.value() :: "
                + HttpStatus.OK.value()
                + " #####");

        assertEquals(resp.getStr(), response.getData().getStr());

        System.out.println("##### resp.getStr() :: "
                + resp.getStr()
                + ", response.getData().getStr() :: "
                + response.getData().getStr()
                + " #####");
    }
}
