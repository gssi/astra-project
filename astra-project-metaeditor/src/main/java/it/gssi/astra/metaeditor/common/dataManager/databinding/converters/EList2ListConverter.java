package it.gssi.astra.metaeditor.common.dataManager.databinding.converters;

import org.eclipse.core.databinding.conversion.Converter;
import org.eclipse.emf.ecore.util.EcoreEList;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

public class EList2ListConverter extends Converter<Object, Object> {

	public EList2ListConverter() {
		super(EcoreEList.class, ObservableList.class);
	}

	public Object convert(Object fromObject) {
		
		@SuppressWarnings("unchecked")
		EcoreEList<Object> fromEList = (EcoreEList<Object>) fromObject;

		ObservableList<Object> myObservableList;

		if (fromObject == null) {
			return null;
		}

		myObservableList = FXCollections.observableArrayList();
		myObservableList.addAll(fromEList);
		
		return myObservableList;
	}

}
