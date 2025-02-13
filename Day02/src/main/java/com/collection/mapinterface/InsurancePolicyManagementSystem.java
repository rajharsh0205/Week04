package com.collection.mapinterface;

import java.time.LocalDate;
import java.util.*;

class Policy {
    String policyNumber;
    String policyHolder;
    LocalDate expiryDate;
    double premiumAmount;

    public Policy(String policyNumber, String policyHolder, LocalDate expiryDate, double premiumAmount) {
        this.policyNumber = policyNumber;
        this.policyHolder = policyHolder;
        this.expiryDate = expiryDate;
        this.premiumAmount = premiumAmount;
    }

    @Override
    public String toString() {
        return "Policy{" +
                "policyNumber='" + policyNumber + '\'' +
                ", policyHolder='" + policyHolder + '\'' +
                ", expiryDate=" + expiryDate +
                ", premiumAmount=" + premiumAmount +
                '}';
    }
}

class InsurancePolicyManager {
    private Map<String, Policy> policyMap = new HashMap<>();
    private LinkedHashMap<String, Policy> orderedPolicies = new LinkedHashMap<>();
    private TreeMap<LocalDate, List<Policy>> policiesByExpiry = new TreeMap<>();

    // Add a policy
    public void addPolicy(Policy policy) {
        policyMap.put(policy.policyNumber, policy);
        orderedPolicies.put(policy.policyNumber, policy);
        policiesByExpiry.computeIfAbsent(policy.expiryDate, k -> new ArrayList<>()).add(policy);
    }

    // Retrieve a policy by policy number
    public Policy getPolicyByNumber(String policyNumber) {
        return policyMap.get(policyNumber);
    }

    // List all policies expiring within the next 30 days
    public List<Policy> getExpiringPolicies() {
        List<Policy> expiringPolicies = new ArrayList<>();
        LocalDate today = LocalDate.now();
        LocalDate nextMonth = today.plusDays(30);

        for (Map.Entry<LocalDate, List<Policy>> entry : policiesByExpiry.subMap(today, true, nextMonth, true).entrySet()) {
            expiringPolicies.addAll(entry.getValue());
        }
        return expiringPolicies;
    }

    // List all policies for a specific policyholder
    public List<Policy> getPoliciesByHolder(String policyHolder) {
        List<Policy> result = new ArrayList<>();
        for (Policy policy : policyMap.values()) {
            if (policy.policyHolder.equalsIgnoreCase(policyHolder)) {
                result.add(policy);
            }
        }
        return result;
    }

    // Remove expired policies
    public void removeExpiredPolicies() {
        LocalDate today = LocalDate.now();
        Iterator<Map.Entry<LocalDate, List<Policy>>> iterator = policiesByExpiry.entrySet().iterator();

        while (iterator.hasNext()) {
            Map.Entry<LocalDate, List<Policy>> entry = iterator.next();
            if (entry.getKey().isBefore(today)) {
                for (Policy policy : entry.getValue()) {
                    policyMap.remove(policy.policyNumber);
                    orderedPolicies.remove(policy.policyNumber);
                }
                iterator.remove();
            }
        }
    }

    // Display all policies
    public void displayPolicies() {
        for (Policy policy : orderedPolicies.values()) {
            System.out.println(policy);
        }
    }
}

public class InsurancePolicyManagementSystem {
    public static void main(String[] args) {
        InsurancePolicyManager manager = new InsurancePolicyManager();

        // Adding policies
        manager.addPolicy(new Policy("P01", "Nikhil Kamath", LocalDate.now().plusDays(10), 5000));
        manager.addPolicy(new Policy("P02", "Pushkar Gupta", LocalDate.now().plusDays(40), 6000));
        manager.addPolicy(new Policy("P03", "Nishant Kumar Bharti", LocalDate.now().plusDays(5), 7000));
        manager.addPolicy(new Policy("P04", "Harsh Raj", LocalDate.now().minusDays(5), 5500));

        // Display policies
        System.out.println("\nAll Policies:");
        manager.displayPolicies();

        // Retrieve a policy by number
        System.out.println("\nRetrieve Policy P01:");
        System.out.println(manager.getPolicyByNumber("P01"));

        // Get policies expiring in next 30 days
        System.out.println("\nExpiring Policies:");
        System.out.println(manager.getExpiringPolicies());

        // Get policies by policyholder
        System.out.println("\nPolicies for Nishant Kumar Bharti:");
        System.out.println(manager.getPoliciesByHolder("Nishant Kumar Bharti"));

        // Remove expired policies
        manager.removeExpiredPolicies();
        System.out.println("\nPolicies after removing expired ones:");
        manager.displayPolicies();
    }
}