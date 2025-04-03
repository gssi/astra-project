package it.gssi.astra.metaeditor.common.dataManager.databinding.converters;

import org.eclipse.core.databinding.conversion.Converter;

public class String2EintConverter extends Converter<Object, Object> {
	
	public String2EintConverter() {
		super(String.class, int.class);
	}

	@Override
	public Object convert(Object fromObject) {

		String from = (String)fromObject;
		
		if (from.isEmpty()) {
			return 0;
		} else {
			return (int) (Integer.valueOf(from));
		}
		
	}

}
