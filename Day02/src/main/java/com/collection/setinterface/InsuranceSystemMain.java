package com.collection.setinterface;

import java.util.*;
import java.text.ParseException;
import java.text.SimpleDateFormat;

class Policy implements Comparable<Policy> {
    private String policyNumber;
    private String policyHolder;
    private Date expiryDate;
    private String coverageType;
    private double premiumAmount;

    private static final SimpleDateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy");

    public Policy(String policyNumber, String policyHolder, String expiryDate, String coverageType, double premiumAmount) throws ParseException {
        this.policyNumber = policyNumber;
        this.policyHolder = policyHolder;
        this.expiryDate = dateFormat.parse(expiryDate);
        this.coverageType = coverageType;
        this.premiumAmount = premiumAmount;
    }

    public String getPolicyNumber() { return policyNumber; }
    public String getPolicyHolder() { return policyHolder; }
    public Date getExpiryDate() { return expiryDate; }
    public String getCoverageType() { return coverageType; }
    public double getPremiumAmount() { return premiumAmount; }

    @Override
    public int compareTo(Policy other) {
        return this.expiryDate.compareTo(other.expiryDate);
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) return true;
        if (!(obj instanceof Policy)) return false;
        Policy other = (Policy) obj;
        return this.policyNumber.equals(other.policyNumber);
    }

    @Override
    public int hashCode() {
        return Objects.hash(policyNumber);
    }

    @Override
    public String toString() {
        return "Policy{" +
                "Number='" + policyNumber + '\'' +
                ", Holder='" + policyHolder + '\'' +
                ", Expiry=" + dateFormat.format(expiryDate) +
                ", Type='" + coverageType + '\'' +
                ", Premium=₹" + premiumAmount +
                '}';
    }
}

class InsuranceManagement {
    Set<Policy> hashSetPolicies = new HashSet<>();
    Set<Policy> linkedHashSetPolicies = new LinkedHashSet<>();
    Set<Policy> treeSetPolicies = new TreeSet<>();

    // Add policy to all sets
    public void addPolicy(Policy policy) {
        hashSetPolicies.add(policy);
        linkedHashSetPolicies.add(policy);
        treeSetPolicies.add(policy);
    }

    // Display all unique policies
    public void displayPolicies(Set<Policy> policies, String type) {
        System.out.println("\n" + type + " Policies:");
        for (Policy policy : policies) {
            System.out.println(policy);
        }
    }

    // Get policies expiring within the next 30 days
    public void policiesExpiringSoon() {
        System.out.println("\nPolicies Expiring Soon:");
        Date currentDate = new Date();
        Calendar cal = Calendar.getInstance();
        cal.setTime(currentDate);
        cal.add(Calendar.DAY_OF_MONTH, 30);
        Date thresholdDate = cal.getTime();

        for (Policy policy : treeSetPolicies) {
            if (policy.getExpiryDate().before(thresholdDate)) {
                System.out.println(policy);
            }
        }
    }

    // Get policies with a specific coverage type
    public void filterByCoverageType(String type) {
        System.out.println("\nPolicies with Coverage Type: " + type);
        for (Policy policy : hashSetPolicies) {
            if (policy.getCoverageType().equalsIgnoreCase(type)) {
                System.out.println(policy);
            }
        }
    }

    // Find duplicate policy numbers
    public void findDuplicatePolicies() {
        Set<String> uniqueNumbers = new HashSet<>();
        System.out.println("\nDuplicate Policies:");
        for (Policy policy : hashSetPolicies) {
            if (!uniqueNumbers.add(policy.getPolicyNumber())) {
                System.out.println(policy);
            }
        }
    }

    // Performance Comparison
    public void comparePerformance() throws ParseException {
        int count = 100000;
        Set<Policy> hashSet = new HashSet<>();
        Set<Policy> linkedHashSet = new LinkedHashSet<>();
        Set<Policy> treeSet = new TreeSet<>();

        long start, end;

        // HashSet Performance
        start = System.nanoTime();
        for (int i = 0; i < count; i++) {
            hashSet.add(new Policy("P" + i, "Holder" + i, "10/12/2025", "Auto", 5000));
        }
        end = System.nanoTime();
        System.out.println("\nHashSet Insertion Time: " + (end - start) / 1e6 + " ms");

        // LinkedHashSet Performance
        start = System.nanoTime();
        for (int i = 0; i < count; i++) {
            linkedHashSet.add(new Policy("P" + i, "Holder" + i, "10/12/2025", "Auto", 5000));
        }
        end = System.nanoTime();
        System.out.println("LinkedHashSet Insertion Time: " + (end - start) / 1e6 + " ms");

        // TreeSet Performance
        start = System.nanoTime();
        for (int i = 0; i < count; i++) {
            treeSet.add(new Policy("P" + i, "Holder" + i, "10/12/2025", "Auto", 5000));
        }
        end = System.nanoTime();
        System.out.println("TreeSet Insertion Time: " + (end - start) / 1e6 + " ms");
    }
}

public class InsuranceSystemMain {
    public static void main(String[] args) throws ParseException {
        InsuranceManagement system = new InsuranceManagement();

        // Adding policies
        system.addPolicy(new Policy("P101", "Raj", "15/03/2025", "Health", 5000));
        system.addPolicy(new Policy("P102", "Ram", "05/04/2024", "Auto", 7000));
        system.addPolicy(new Policy("P103", "Babu", "25/02/2024", "Home", 6000));
        system.addPolicy(new Policy("P104", "Raju", "20/06/2024", "Health", 6500));
        system.addPolicy(new Policy("P101", "Jimmy", "15/03/2025", "Health", 5000));

        // Display policies stored in different sets
        system.displayPolicies(system.hashSetPolicies, "HashSet");
        system.displayPolicies(system.linkedHashSetPolicies, "LinkedHashSet");
        system.displayPolicies(system.treeSetPolicies, "TreeSet (Sorted by Expiry)");

        // Policies expiring soon
        system.policiesExpiringSoon();

        // Filter by coverage type
        system.filterByCoverageType("Health");

        // Find duplicate policies
        system.findDuplicatePolicies();

        // Compare performance of different sets
        system.comparePerformance();
    }
}