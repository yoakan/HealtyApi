package com.yoakan.healtyapi.common;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class StatusControllerTest {
    private StatusController statusController = new StatusController();
    @Test
    void status() {
        Assertions.assertNotNull(statusController.status());
    }
}