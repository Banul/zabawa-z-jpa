package com.example.demo;

import jakarta.persistence.EntityManager;
import jakarta.transaction.Transactional;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;
import java.util.stream.Stream;

@RestController
public class Controller {
    private final UserDataRepository userDataRepository;
    private final EntityManager entityManager;

    public Controller(UserDataRepository userDataRepository, EntityManager entityManager) {
        this.userDataRepository = userDataRepository;
        this.entityManager = entityManager;
    }

    @GetMapping("test/list")
    public void readAllDataInList() {
        List<UserData> allData = userDataRepository.findAll();
        allData.forEach(System.out::println);
    }

    @GetMapping("test/stream")
    @Transactional
    public void readAllDataInStream() {
        try(Stream<UserData> data = userDataRepository.findAllUsingStream()) {
            data.forEach(System.out::println);
        }
    }

    @GetMapping("test/stream-new")
    @Transactional
    public void readAllDataInStreamNew() {
        try(Stream<UserData> data = userDataRepository.stream(null, UserData.class)) {
            data.forEach(System.out::println);
        }
    }

    @GetMapping("test/stream-new-detatching")
    @Transactional
    public void readAllDataInStreamNewWithDetatching() {
        try(Stream<UserData> data = userDataRepository.stream(null, UserData.class)) {
            data.forEach(entity -> {
                System.out.println(entity);
                entityManager.detach(entity);
            });
        }
    }


    @GetMapping("/populateData")
    public void test() {
        int numThreads = Runtime.getRuntime().availableProcessors();
        ExecutorService executor = Executors.newFixedThreadPool(numThreads);
        List<Future<?>> futures = new ArrayList<>();

        for (int i = 0; i < 10; i++) {
            Future<?> future = executor.submit(() -> {
                for (int k = 0; k < 50000; k++) {
                    userDataRepository.saveAndFlush(new UserData());
                }
            });
            futures.add(future);
        }
    }
}
