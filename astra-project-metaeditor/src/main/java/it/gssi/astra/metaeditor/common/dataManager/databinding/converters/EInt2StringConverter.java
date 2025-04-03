package it.gssi.astra.metaeditor.common.dataManager.databinding.converters;

import org.eclipse.core.databinding.conversion.Converter;

public class EInt2StringConverter extends Converter<Object, Object> {
	
	public EInt2StringConverter() {
		super(Integer.class, String.class);
	}

	@Override
	public Object convert(Object fromObject) {

		return ((Integer)fromObject).toString();
	}

}
