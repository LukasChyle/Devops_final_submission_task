package com.example.Devops_final_submission_task.bootstrap;

import com.example.Devops_final_submission_task.Repositories.MenuRepo;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import java.util.Map;

import static org.mockito.ArgumentMatchers.anyString;
import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
class BootstrapDataTest {

    @Mock
    private MenuRepo menuRepo;

    @Mock
    private Map<Integer, String> mockMenuMap;

    @InjectMocks
    private BootstrapData bootstrapData;

    // sha: fail 811569cb489de8efe4e8cd1fc88c067e58848b3f
    // sha: solve dfb51f8a63cc1d2f7d4d51cecfadde1f3ed20417
    // test must be 7 to succeed

    @Test
    void testMenuReader() {
        when(menuRepo.getMenuMap()).thenReturn(mockMenuMap);
        bootstrapData.menuReader();
        verify(mockMenuMap, times(7)).put(anyInt(), anyString());
    }
}

