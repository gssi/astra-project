package it.gssi.astra.metaeditor.common.dataManager.databinding.converters;

import java.util.ArrayList;
import java.util.Collection;

import org.eclipse.core.databinding.conversion.Converter;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.util.EDataTypeUniqueEList;

import javafx.collections.ObservableList;

public class List2EListConverter extends Converter<Object, Object> {

	Class<?> class1;
	EObject model;
	int id;

	/**
	 * List 2 EList Converter
	 * 
	 * @param i
	 * @param model
	 */
	public List2EListConverter(EObject model, int i) {
		super(ObservableList.class, EDataTypeUniqueEList.class);
		this.class1 = model.eClass().getEStructuralFeature(i).getEType().getInstanceClass();
		this.model = model;
		this.id = i;
	}

	public Object convert(Object fromObject) {
		
		@SuppressWarnings({ "unchecked" })
		ObservableList<Object> fromList = (ObservableList<Object>) fromObject;

		ArrayList<Object> myEList = new ArrayList<>();

		if (fromObject == null) {
			return null;
		}

		myEList.addAll((Collection<Object>) fromList);
		return myEList;
	}
}
