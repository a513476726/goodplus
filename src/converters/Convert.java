package converters;

import java.text.SimpleDateFormat;
import java.util.Date;
import org.springframework.core.convert.converter.Converter;

public class Convert implements Converter<String, Date>{
	@Override
	public Date convert(String s) {
		//2017-05-14
		SimpleDateFormat sdf =  new SimpleDateFormat("yyyy-MM-dd");
		try {
			return sdf.parse(s);
		} catch (Exception e) {
			// TODO: handle exception
		}
		return null;
	}
}
