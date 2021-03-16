package com.zeed.tdd;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

public class LoadBalancerTest {

    @Test
    @DisplayName("Should be able to register IP Address")
    public void registerIps() {
        LoadBalancerRepository loadBalancerRepository = new LoadBalancerRepositoryStub();
        LoadBalancerService loadBalancerService = new LoadBalancerService(loadBalancerRepository);
        Assertions.assertTrue(loadBalancerService.registerIp("120.21.32.34"), "IP address must be registered successfully");
    }

    @Test
    public void testNoTwoIpsCanBeSame() {
        LoadBalancerRepository loadBalancerRepository = new LoadBalancerRepositoryStub();
        LoadBalancerService loadBalancerService = new LoadBalancerService(loadBalancerRepository);
        String ipAddress = "121.234.12.00";
        loadBalancerService.registerIp(ipAddress);
        Assertions.assertFalse(loadBalancerService.registerIp(ipAddress), "No two Ips must be same");
    }

    @Test
    @DisplayName("Should be able to get all registered empty and empty array should be returned if there is no IP Address")
    public void getListOfIpAddresses() {
        LoadBalancerRepository loadBalancerRepository = new LoadBalancerRepositoryStub();
        LoadBalancerService loadBalancerService = new LoadBalancerService(loadBalancerRepository);
        Set<String> ipAddresses = loadBalancerService.getRegisteredIps();
        Assertions.assertNotNull(ipAddresses, "Registered IPs object cannot be null. Should rather be empty");
    }

    @Test
    @DisplayName("Should be able to do bulk registration successfully")
    public void testBulkIpRegistration() {
        LoadBalancerRepository loadBalancerRepository = new LoadBalancerRepositoryStub();
        LoadBalancerService loadBalancerService = new LoadBalancerService(loadBalancerRepository);
        Assertions.assertTrue(loadBalancerService.registerIpsInBulk(new HashSet<>(Arrays.asList("100.213.09.23", "209.213.761.09"))));
    }

    static class LoadBalancerRepositoryStub implements LoadBalancerRepository {
        private final Set<String> ipAddresses = new HashSet<>();

        @Override
        public boolean registerIp(String ipAddress) {
            return this.ipAddresses.add(ipAddress);
        }
        @Override
        public Set<String> getAll() {
            return this.ipAddresses;
        }

        @Override
        public boolean registerIpsInBulk(Set<String> ipAddresses) {
            return this.ipAddresses.addAll(ipAddresses);
        }
    }

}
