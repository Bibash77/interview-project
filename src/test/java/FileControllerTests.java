import bqtest.service.Member;
import bqtest.service.impl.MemberFileProcessorImpl;
import bqtest.web.FileController;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.Before;
import org.junit.Test;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.extension.ExtendWith;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnitRunner;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.json.JacksonTester;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.mock.web.MockHttpServletResponse;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;

import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.equalTo;
import static org.hamcrest.Matchers.hasSize;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.when;
import static org.mockito.MockitoAnnotations.initMocks;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;

//@SpringBootTest
@AutoConfigureMockMvc
@RunWith(MockitoJUnitRunner.class)
@WebMvcTest
//@ExtendWith(MockitoExtension.class)
public class FileControllerTests {

    @Autowired
    private MockMvc mockMvc;

    @Mock
    private MemberFileProcessorImpl memberFileProcessor;

    @InjectMocks
    private FileController fileController;

//    @BeforeEach
//    public void setup() {
//        mockMvc = MockMvcBuilders.standaloneSetup(fileController).build();
//    }
@Before
public void setup() {
    initMocks(this);
    this.mockMvc = MockMvcBuilders.standaloneSetup(fileController).build();
}

    @Test
    public void testLoadData() throws Exception {
        when(memberFileProcessor.processFile(any())).thenReturn(new HashMap<>());

        MockHttpServletResponse response = this.mockMvc.perform(
                get("/api/load-data")
                        .contentType(MediaType.APPLICATION_JSON)
        ).andReturn().getResponse();
        assertThat(response.getStatus(), equalTo(HttpStatus.OK.value()));
    }

}
