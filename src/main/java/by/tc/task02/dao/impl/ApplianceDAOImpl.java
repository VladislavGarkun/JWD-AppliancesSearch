package by.tc.task02.dao.impl;

import by.tc.task02.dao.ApplianceDAO;
import by.tc.task02.entity.Appliance;
import by.tc.task02.entity.criteria.Criteria;
import by.tc.task02.factories.ApplianceFactory;

import java.io.File;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Scanner;

public class ApplianceDAOImpl implements ApplianceDAO{
	@Override
	public Appliance find(Criteria criteria)
	{
		Appliance result = null;

		File file = new File("src\\main\\resources\\appliances_db.txt");

		try(Scanner scanner = new Scanner(file))
		{
			while(scanner.hasNextLine())
			{
				String line = scanner.nextLine();
				String[] columns = null;

				if(!line.isEmpty())
					columns = line.split(" : ");

				if(columns[0].compareTo(criteria.getGroupSearchName()) != 0)
				{
					continue;
				}

				HashMap<String, String> searchMap = new HashMap<String, String>();

				String[] params = columns[1].split(", ");

				for(int i = 0; i < params.length; i++)
				{
					String paramsValues[] = params[i].split("=");

					for(int j = 0; j < paramsValues.length; j += 2)
					{
						searchMap.put(paramsValues[j], paramsValues[j+1]);
					}
				}

				boolean bool = true;

				for(HashMap.Entry<String, Object> criteriaEntry: criteria.getCriteria().entrySet())
				{
					if(!(searchMap.containsKey(criteriaEntry.getKey()) && searchMap.get(criteriaEntry.getKey()).equals(criteriaEntry.getValue())))
						bool = false;

				}

				if(bool)
				{
					ApplianceFactory applianceFactory = new ApplianceFactory();
					ArrayList<String> parameters = new ArrayList<String>();

					for(int i = 0; i < params.length; i++)
					{
						String paramsValues[] = params[i].split("=");

						for(int j = 1; j < paramsValues.length; j += 2)
						{
							parameters.add(paramsValues[j]);
						}
					}

					result = applianceFactory.create(criteria.getGroupSearchName(), parameters);
					return result;
				}
			}
		}
		catch (Exception ex)
		{
			ex.getMessage();
		}

		return result;
	}
}