/**
 * 
 */
package com.example.associationsrules;

import java.awt.List;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.net.URL;
import java.util.ArrayList;

import org.springframework.core.io.ClassPathResource;
import org.springframework.stereotype.Component;

import weka.associations.Apriori;
import weka.associations.FPGrowth;
import weka.core.Instances;
import weka.core.converters.ArffSaver;
import weka.core.converters.ConverterUtils.DataSource;

import weka.filters.Filter;
import weka.filters.unsupervised.attribute.Discretize;

/**
 * @author ralph
 *
 */
@Component
public class AssociationsRulesExample {

	public void runExample()
	{
		// load data
		
		try {
			URL fileLocation = new ClassPathResource("data.arff").getURL();
			FileReader f = new FileReader(fileLocation.getPath());
			BufferedReader b= new BufferedReader(f);
			DataSource dataS = new DataSource(fileLocation.getPath());
			Instances data = dataS.getDataSet();
			
			Discretize discretizeNumeric = new Discretize();
			int[] discIndices = {1,2};
			discretizeNumeric.setAttributeIndicesArray(discIndices);
			discretizeNumeric.setInputFormat(data);			
			
			Instances discretizeddata = Filter.useFilter(data, discretizeNumeric);
			
			// you can save the discretized instances as new file to see , learn and compare.
			/* 
			ArffSaver loader = new ArffSaver();
			loader.setInstances(discretizeddata);
			loader.setFile(new File("newfile.arff"));
			loader.writeBatch();
			*/
			
			// build model
			Apriori aprioriModel = new Apriori();
			aprioriModel.buildAssociations(discretizeddata);
			System.out.println(aprioriModel);
						
			
			
			
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}	        

		
	}
}
