package br.com.servletappexample.model;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class Database {

	private static List<Company> listCompany = new ArrayList<Company>();
	private static Integer sequentialKey = 1;
	
	//It is possible to maintain code linked to the class as well as a static private variable.
	static {
		Company company1 = new Company();
		Company company2 = new Company();
		
		company1.setidCompany(Database.sequentialKey++);
		company1.setName("Alura");
		
		company2.setidCompany(Database.sequentialKey++);
		company2.setName("Caelum");
		
		listCompany.add(company1);
		listCompany.add(company2);
	}

	public void add(Company company) {
		company.setidCompany(Database.sequentialKey++);
		Database.listCompany.add(company);
		System.out.println("Company " + company.getName() + " added with success");
	}
	
	public List<Company> getCompanies(){
		return Database.listCompany;
	}
	
	public void removeCompany(Integer idCompany) {
		
		Iterator<Company> it = listCompany.iterator();
		
		while(it.hasNext()) {
			Company comp = it.next();
			if (comp.getidCompany() == idCompany) {
				System.out.println("Removing company " + comp.getName());
				it.remove();
			}
		}
		
	}

	public Company searchCompanyById(Integer id) {
		for (Company company : listCompany) {
			if(company.getidCompany() == id) {
				return company;
			}
		}
		return null;
	}
}
