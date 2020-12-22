package by.tc.task02.service.impl;

import by.tc.task02.dao.ApplianceDAO;
import by.tc.task02.dao.DAOFactory;
import by.tc.task02.entity.Appliance;
import by.tc.task02.entity.criteria.Criteria;
import by.tc.task02.service.ApplianceService;
import by.tc.task02.service.validation.Validator;

public class ApplianceServiceImpl implements ApplianceService{
	@Override
	public Appliance find(Criteria criteria) {
		if (!Validator.criteriaValidator(criteria)) {
			return null;
		}
		
		DAOFactory factory = DAOFactory.getInstance();
		ApplianceDAO applianceDAO = factory.getApplianceDAO();
		
		Appliance appliance = applianceDAO.find(criteria);

		return appliance;
	}
}
