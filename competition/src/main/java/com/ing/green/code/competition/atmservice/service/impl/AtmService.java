package com.ing.green.code.competition.atmservice.service.impl;

import com.ing.green.code.competition.atmservice.model.ATM;
import com.ing.green.code.competition.atmservice.model.Task;
import com.ing.green.code.competition.atmservice.service.AtmServiceInterface;
import org.springframework.stereotype.Service;

import java.util.*;
import java.util.function.Function;
import java.util.stream.Collectors;

@Service
public class AtmService implements AtmServiceInterface {
    @Override
    public List<ATM> getListOfAtms(List<Task> tasks) {
        Comparator<Task> taskComparator = createTaskComparator();
        LinkedHashMap<AbstractMap.SimpleEntry<Integer, Integer>, Task> taskLinkedHashMap = createTaskLinkedMap(tasks);

        return taskLinkedHashMap.values().stream()
                .sorted(taskComparator)
                .map(this::mapTaskToAtm)
                .toList();
    }

    private Comparator<Task> createTaskComparator() {
        return Comparator.comparingInt(Task::getRegion)
                .thenComparingInt(task -> switch (task.getRequestType()) {
                    case FAILURE_RESTART -> 1;
                    case PRIORITY -> 2;
                    case SIGNAL_LOW -> 3;
                    case STANDARD -> 4;
                });
    }

    private LinkedHashMap<AbstractMap.SimpleEntry<Integer, Integer>, Task> createTaskLinkedMap(List<Task> tasks) {
        return tasks.stream()
                .collect(Collectors.toMap(
                        task -> new AbstractMap.SimpleEntry<>(task.getRegion(), task.getAtmId()),
                        Function.identity(),
                        (t1, t2) -> {
                            if (t1.getRegion().equals(t2.getRegion()) && t1.getAtmId().equals(t2.getAtmId())) {
                                return t1.getRequestType().ordinal() > t2.getRequestType().ordinal() ? t1 : t2;
                            } else {
                                return t1;
                            }
                        },
                        LinkedHashMap::new));
    }

    private ATM mapTaskToAtm(Task task) {
        ATM atm = new ATM();
        atm.setAtmId(task.getAtmId());
        atm.setRegion(task.getRegion());
        return atm;
    }

}
