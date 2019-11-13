package test.pivotal.pal.tracker;

import io.pivotal.pal.tracker.AllocationForm;
import io.pivotal.pal.tracker.AllocationRecord;
import io.pivotal.pal.tracker.AllocationRepository;
import io.pivotal.pal.tracker.AllocationsController;
import org.junit.Before;
import org.junit.Test;
import org.mockito.Mockito;

import static org.mockito.ArgumentMatchers.any;

public class AllocationsControllerTest {
    private AllocationRepository repository;
    private AllocationsController controller;

    @Before
    public void setUp() throws Exception {
        repository = Mockito.mock(AllocationRepository.class);
        controller = new AllocationsController(repository);
    }

    @Test
    public void createTest() {
        //SETUP

        AllocationForm allocationToCreate = new AllocationForm(2L, "New Allocation");
        AllocationRecord expectedResult = new AllocationRecord(1L, 2L, "New Allocation");

        Mockito.doReturn(expectedResult)
                .when(repository)
                .create(any(AllocationForm.class));

        //Action
        AllocationRecord allocationRecord = repository.create(allocationToCreate);

        Mockito.verify(repository).create(allocationToCreate);


        //Verify && Assert
    }
}