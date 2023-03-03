package com.lupo.nodeport;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.net.InetAddress;
import java.net.UnknownHostException;
import java.util.Date;

@RestController
public class MainConnector {

    @GetMapping(value = "/", produces = "application/json")
    public String hello() throws UnknownHostException {

        InetAddress local = InetAddress.getLocalHost();

        String output = "{'Hostname': '%s', 'Canonical': '%s', 'HostAddress': '%s', 'Timestamp': '%s' }";
        return String.format(output,
                local.getHostName(), local.getCanonicalHostName(), local.getHostAddress(), new Date());
    }
}
