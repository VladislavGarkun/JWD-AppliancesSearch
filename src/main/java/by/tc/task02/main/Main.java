package by.tc.task02.main;

import static by.tc.task02.entity.criteria.SearchCriteria.*;

import by.tc.task02.entity.Appliance;
import by.tc.task02.entity.Speakers;
import by.tc.task02.entity.criteria.Criteria;
import by.tc.task02.service.ApplianceService;
import by.tc.task02.service.ServiceFactory;

public class Main {

	public static void main(String[] args) {
		Appliance appliance;

		ServiceFactory factory = ServiceFactory.getInstance();
		ApplianceService service = factory.getApplianceService();


		Criteria criteriaOven = new Criteria("Laptop");
		criteriaOven.add(LaptopCriteria.CPU.toString(), 3.2);

		appliance = service.find(criteriaOven);

		PrintApplianceInfo.print(appliance);


		criteriaOven = new Criteria("Laptop");
		criteriaOven.add(LaptopCriteria.OS.toString(), "Linux");
		criteriaOven.add(LaptopCriteria.DISPLAY_INCHS.toString(), 19);

		appliance = service.find(criteriaOven);

		PrintApplianceInfo.print(appliance);

		
		Criteria criteriaTabletPC = new Criteria("Speakers");
		criteriaTabletPC.add(SpeakersCriteria.POWER_CONSUMPTION.toString(), 17);
		criteriaTabletPC.add(SpeakersCriteria.NUMBER_OF_SPEAKERS.toString(), 4);
		criteriaTabletPC.add(SpeakersCriteria.CORD_LENGTH.toString(), 4);

		appliance = service.find(criteriaTabletPC);

		PrintApplianceInfo.print(appliance);
	}
}
