package io.pivotal.pal.tracker;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;

public class AllocationsController {

    private final AllocationRepository allocationRepository;

    public AllocationsController(AllocationRepository allocationRepository) {
        this.allocationRepository = allocationRepository;
    }

    public ResponseEntity create(AllocationForm form) {
        allocationRepository.create(form);
        return null;
    }
}
