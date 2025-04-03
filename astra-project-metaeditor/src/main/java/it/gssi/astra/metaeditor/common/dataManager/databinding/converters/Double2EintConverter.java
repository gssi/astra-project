package it.gssi.astra.metaeditor.common.dataManager.databinding.converters;

import org.eclipse.core.databinding.conversion.Converter;

public class Double2EintConverter extends Converter<Object, Object> {
	
	public Double2EintConverter() {
		super(Double.class, int.class);
	}

	@Override
	public Object convert(Object fromObject) {

		return (int) Math.round((Double) fromObject);
	}

}
