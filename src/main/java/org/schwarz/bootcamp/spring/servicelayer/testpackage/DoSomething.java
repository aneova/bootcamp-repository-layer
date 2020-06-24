package org.schwarz.bootcamp.spring.servicelayer.testpackage;

public class DoSomething {

    public void shee() {
        GenericOvertime genericOvertimeOT = new Overtime();
        GenericOvertime genericPlannedOvertimeOT = new PlannedOvertime();

        Overtime overtime = new Overtime();

        acceptGeneric(overtime);
    }


    private void acceptGeneric(GenericOvertime genericOvertime) {

    }

}
