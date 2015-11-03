package pt.enter.proxy.udpproxy.service;

import org.springframework.stereotype.Service;

@Service
public class EchoService {
  public String sayHello(String guestName) {
    System.out.println("Input guestName : "+ guestName);
    return "Hello " + guestName;
  }
}