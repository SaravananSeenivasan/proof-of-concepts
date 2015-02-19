/**
 * 
 */
package com.sivalabs.ebuddy.config;

import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;

import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JsonSerializer;
import com.fasterxml.jackson.databind.SerializerProvider;
import com.sivalabs.ebuddy.utils.Constants;

/**
 * @author Siva
 *
 */
public class JsonDateSerializer extends JsonSerializer<Date>{

	@Override
	public void serialize(Date date, JsonGenerator jgen,
			SerializerProvider provider) throws IOException,
			JsonProcessingException {
		if(date == null)
		{
			jgen.writeString("");
		}
		else
		{
			SimpleDateFormat dateFormat = new SimpleDateFormat(Constants.APP_DATE_FORMAT);
			String formattedDate = dateFormat.format(date);
			jgen.writeString(formattedDate);
		}
	}

}
