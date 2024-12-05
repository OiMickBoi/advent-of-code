class TestFramework {
    private int passedTests = 0;
    private int failedTests = 0;

    public TestFramework() {
        this.passedTests = 0;
        this.failedTests = 0;
    }

    public void assertEquals(Object expected, Object actual, String testName) {
        boolean passed = (expected == null && actual == null) ||
                        (expected != null && expected.equals(actual));
        
        if (passed) {
            System.out.println("✓ PASSED: " + testName);
            passedTests++;
        } else {
            System.out.println("✗ FAILED: " + testName);
            System.out.println("  Expected: " + expected);
            System.out.println("  Actual:   " + actual);
            failedTests++;
        }
    }

    public void assertTrue(boolean condition, String testName) {
        assertEquals(true, condition, testName);
    }

    public void printTestSummary() {
        System.out.println("\nTest Summary:");
        System.out.println("Total tests: " + (passedTests + failedTests));
        System.out.println("Passed: " + passedTests);
        System.out.println("Failed: " + failedTests);
    }

}
