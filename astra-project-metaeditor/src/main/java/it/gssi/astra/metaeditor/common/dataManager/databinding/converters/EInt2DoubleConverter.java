package it.gssi.astra.metaeditor.common.dataManager.databinding.converters;

import org.eclipse.core.databinding.conversion.Converter;

public class EInt2DoubleConverter extends Converter<Object, Object> {
	
	public EInt2DoubleConverter() {
		super(Integer.class, Double.class);
	}

	@Override
	public Object convert(Object fromObject) {

		return ((Integer)fromObject).doubleValue();
	}

}
