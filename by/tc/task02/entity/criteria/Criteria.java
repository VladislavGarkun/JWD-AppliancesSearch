package by.tc.task02.entity.criteria;

import java.util.HashMap;

public class Criteria {

	private String groupSearchName;
	private HashMap<String, Object> criteria = new HashMap<String, Object>();

	public Criteria(String groupSearchName)
	{
		this.groupSearchName = groupSearchName;
	}
	
	public String getGroupSearchName()
	{
		return groupSearchName;
	}

	public void add(String searchCriteria, Object value)
	{
		criteria.put(searchCriteria, value.toString());
	}
	
	public HashMap<String, Object> getCriteria()
	{
		return criteria;
	}

}
