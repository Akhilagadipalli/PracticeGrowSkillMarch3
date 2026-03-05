package Utilites;


import java.io.FileReader;
import java.io.IOException;
import java.util.Properties;

import ConstantsData.Constants;

public class FetchDataFromProperty {
public static Properties getDataFromProperty() throws IOException 

{
	FileReader reader = new FileReader(Constants.PROP_FILE_PATH);
	
	Properties prop =new Properties();
	prop.load(reader);
	return prop;
}



}
