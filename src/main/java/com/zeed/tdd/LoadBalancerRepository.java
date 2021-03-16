package com.zeed.tdd;

import java.util.Set;

public interface LoadBalancerRepository {
    boolean registerIp(String ipAddress);

    Set<String> getAll();

    boolean registerIpsInBulk(Set<String> ipAddresses);
}
