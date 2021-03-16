package com.zeed.tdd;

import java.util.Set;

public class LoadBalancerService {

    private final LoadBalancerRepository loadBalancerRepository;

    public LoadBalancerService(LoadBalancerRepository loadBalancerRepository) {
        this.loadBalancerRepository = loadBalancerRepository;
    }

    public boolean registerIp(String ipAddress) {
        return loadBalancerRepository.registerIp(ipAddress);
    }

    public Set<String> getRegisteredIps() {
        return loadBalancerRepository.getAll();
    }

    public boolean registerIpsInBulk(Set<String> ipAddresses) {
        return loadBalancerRepository.registerIpsInBulk(ipAddresses);
    }
}
