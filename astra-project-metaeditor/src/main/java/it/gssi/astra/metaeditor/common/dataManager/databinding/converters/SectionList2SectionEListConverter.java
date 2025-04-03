package it.gssi.astra.metaeditor.common.dataManager.databinding.converters;

import java.util.ArrayList;

import org.eclipse.core.databinding.conversion.Converter;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.util.EDataTypeUniqueEList;

import MetaEditor.MetaEditorPersistence.CanvasSection;
import MetaEditor.MetaEditorPersistence.MetaEditorPersistenceFactory;
import it.gssi.astra.metaeditor.common.canvas.section.CanvasSectionFX;
import javafx.collections.ObservableList;

public class SectionList2SectionEListConverter extends Converter<Object, Object> {

	Class<?> class1;
	EObject model;
	int id;

	/**
	 * List of SectionFX 2 EList of persistence section Converter
	 * 
	 * @param i
	 * @param model
	 */
	public SectionList2SectionEListConverter(EObject model, int i) {
		super(ObservableList.class, EDataTypeUniqueEList.class);
		this.class1 = model.eClass().getEStructuralFeature(i).getEType().getInstanceClass();
		this.model = model;
		this.id = i;
	}

	public Object convert(Object fromObject) {

		@SuppressWarnings({ "unchecked" })
		ObservableList<CanvasSectionFX> fromList = (ObservableList<CanvasSectionFX>) fromObject;

		ArrayList<CanvasSection> myEList = new ArrayList<>();

		if (fromObject == null) {
			return myEList;
		}

		for (CanvasSectionFX section : fromList) {

			CanvasSection canvas = MetaEditorPersistenceFactory.eINSTANCE.createCanvasSection();
			canvas.setName(section.getName());
			canvas.setSectionHeight((int) section.getHeight());
			canvas.setSectionWidth((int) section.getWidth());

			myEList.add(canvas);
		}

		return myEList;
	}
}
