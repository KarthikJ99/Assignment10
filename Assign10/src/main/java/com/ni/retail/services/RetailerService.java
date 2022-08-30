package com.ni.retail.services;

import java.util.ArrayList;
import java.util.List;

import com.ni.retail.Retailer;
import com.ni.retail.respositries.RetailerRepositry;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class RetailerService {
	  
    @Autowired
    RetailerRepositry retailerRepositry;

    public List<Retailer> getAllRetailers() {
        List<Retailer> retailerList = new ArrayList<Retailer>();

        retailerRepositry
                .findAll()
                .forEach(retailer -> retailerList.add(retailer));

        return retailerList;
    }

    public Retailer updateRetailer(Retailer retailer) {
        return retailerRepositry.save(retailer);
    }

    public Retailer addRetailer(Retailer retailer) {
        return  retailerRepositry.save(retailer);
    }

    public void deleteretailer(int retailerId) {
        // farmerRepositry.deleteById(farmerId);
        // deleteById throws Exception when farmer with that id does not exist,
        // Therefore we are trying alternative below

        List<Retailer> retailerList = getAllRetailers();

        for (Retailer retailer : retailerList) {
            if (retailer.getRetailerId() == retailerId)
            	retailerRepositry.deleteById(retailerId);
        }
    }

    @Transactional
    public void deleteRetailerByName(String name) {
    	retailerRepositry.deleteByName(name);
    }
    
    @Transactional
    public void deleteRetailerByAge(int age) {
    	retailerRepositry.deleteByAge(age);
    }

}
