package by.tc.task02.service.validation;

import by.tc.task02.entity.criteria.Criteria;

public class Validator {
	public static boolean criteriaValidator(Criteria criteria) {
		if(criteria.getGroupSearchName().isEmpty() || criteria.getGroupSearchName() == null)
			return false;

		if(criteria.getCriteria() == null)
			return false;
		
		return true;
	}
}