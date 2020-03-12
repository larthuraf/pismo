package com.luiz.pismo.model;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class OperationTypeTest {

    @BeforeEach
    void setUp() {
    }

    @AfterEach
    void tearDown() {
    }

    @Test
    void convertAmountWithPositiveOperationType() {
        OperationType operationType = new OperationType(0, "POSITIVE", false);
        double amount = 15.5;
        double signedAmount = amount * operationType.defineOperationSign();
        assertEquals(signedAmount, amount, 0.0);
    }

    @Test
    void convertAmountWithNegativeOperationType() {
        OperationType operationType = new OperationType(0, "NEGATIVE", true);
        double amount = 15.5;
        double signedAmount = amount * operationType.defineOperationSign();
        assertEquals(signedAmount, -amount, 0.0);
    }
}