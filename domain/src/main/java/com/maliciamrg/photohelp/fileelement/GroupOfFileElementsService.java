package com.maliciamrg.photohelp.fileelement;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class GroupOfFileElementsService {
    private final GroupOfFileElements groupOfFileElements;
    private int sizeAll = 0;

    public GroupOfFileElementsService(GroupOfFileElements groupOfFileElements) {
        this.groupOfFileElements = groupOfFileElements;
    }

    public int getSizeAll() {
        return sizeAll;
    }

    public List<GroupOfFileElements> groupsByTime(int groupingTimeInMinutes) {

        List<GroupOfFileElements> listGroup = new ArrayList<>();

        int groupingTimeInSecond = groupingTimeInMinutes * 60;

        long maxprev = 0;
        GroupOfFileElements listGroupTmp = new GroupOfFileElements();

        Collections.sort(groupOfFileElements);

        for (FileElement fileElement : groupOfFileElements) {

            long mint = fileElement.getCaptureTime() - (groupingTimeInSecond / 2);
            long maxt = fileElement.getCaptureTime() + (groupingTimeInSecond / 2);

            if (mint > maxprev) {

                listGroup.add(listGroupTmp);
                listGroupTmp = new GroupOfFileElements();

            }

            maxprev = maxt;
            listGroupTmp.setFirstDate(fileElement.getCaptureTime());
            listGroupTmp.add(fileElement);

        }

        listGroup.add(listGroupTmp);

        sizeAll = sizeAll(listGroup);

        return listGroup;
    }

    @Override
    public String toString() {
        return "GroupsOfFileElements{" +
                "listOfFileElements=" + groupOfFileElements +
                ", sizeAll=" + sizeAll +
                '}';
    }

    private int sizeAll(List<GroupOfFileElements> listGroup) {
        sizeAll = 0;
        for (GroupOfFileElements groupOfFileElements : listGroup) {
            sizeAll += groupOfFileElements.size();
        }
        return sizeAll;
    }

}
