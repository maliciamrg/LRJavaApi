package com.maliciamrg.photohelp.fileelement;

import org.junit.jupiter.api.Test;

import java.util.List;

import static java.util.Arrays.asList;
import static org.assertj.core.api.Assertions.assertThat;

class GroupOfFileElementsServiceTest {

    @Test
    void group_the_new_pictures() {
//        Given
        GroupOfFileElements listOfFileElementsToGroupStub = new GroupOfFileElements();
        listOfFileElementsToGroupStub.addAll(asList(
                new FileElement("c:/file1/", "file11", 1711919771),
                new FileElement("c:/file1/", "file12", 1711420781),
                new FileElement("c:/file2/", "file21", 1711925871),
                new FileElement("c:/file2/", "file22", 1711317791),
                new FileElement("c:/file3/", "file31", 1711924771),
                new FileElement("c:/file4/", "file41", 1711315371)));
        int groupingTimeInMinutes = 90;

//        When
        GroupOfFileElementsService groupOfFileElementsService = new GroupOfFileElementsService(listOfFileElementsToGroupStub);
        List<GroupOfFileElements> listGroup = groupOfFileElementsService.groupsByTime(groupingTimeInMinutes);


//        Then
        System.out.println(groupOfFileElementsService);
        System.out.println(listGroup);
        assertThat(groupOfFileElementsService.getSizeAll()).isEqualTo(listOfFileElementsToGroupStub.size());

        assertThat(((List<FileElement>) listGroup.get(0)).size()).isEqualTo(0);

        List<FileElement> fileElements1 = listGroup.get(1);
        assertThat(fileElements1.size()).isEqualTo(2);
        assertThat(fileElements1.get(1).getCaptureTime() - fileElements1.get(0).getCaptureTime()).isLessThan(groupingTimeInMinutes * 60);

        List<FileElement> fileElements2 = listGroup.get(2);
        assertThat(fileElements2.size()).isEqualTo(1);

        List<FileElement> fileElements3 = listGroup.get(3);
        assertThat(fileElements3.size()).isEqualTo(3);
        assertThat(fileElements3.get(1).getCaptureTime() - fileElements3.get(0).getCaptureTime()).isLessThan(groupingTimeInMinutes * 60);
        assertThat(fileElements3.get(2).getCaptureTime() - fileElements3.get(1).getCaptureTime()).isLessThan(groupingTimeInMinutes * 60);


//
//        assertThat(fleets.getById(fleet.id())).isEqualTo(fleet);
//
//        //Given
//        var starShips = asList(
//                new StarShip("no-passenger-ship", 0, ZERO),
//                new StarShip("xs", 10, new BigDecimal("1000")),
//                new StarShip("s", 50, new BigDecimal("50000")),
//                new StarShip("m", 200, new BigDecimal("70000")),
//                new StarShip("l", 800, new BigDecimal("150000")),
//                new StarShip("xl", 2000, new BigDecimal("500000")));
//        var numberOfPassengers = 1050;
//
//        StarShipInventory starShipsInventory = new StarShipInventoryStub(starShips);
//        Fleets fleets = new InMemoryFleets();
//        AssembleAFleet assembleAFleet = new FleetAssembler(starShipsInventory, fleets);
//
//        //When
//        Fleet fleet = assembleAFleet.forPassengers(numberOfPassengers);
//
//        //Then
//        System.out.println(fleet);
//        assertThat(fleet.starships())
//                .has(enoughCapacityForThePassengers(numberOfPassengers))
//                .allMatch(hasPassengersCapacity())
//                .allMatch(hasEnoughCargoCapacity(), "hasEnoughCargoCapacity");
//
//        assertThat(fleets.getById(fleet.id())).isEqualTo(fleet);
    }
}