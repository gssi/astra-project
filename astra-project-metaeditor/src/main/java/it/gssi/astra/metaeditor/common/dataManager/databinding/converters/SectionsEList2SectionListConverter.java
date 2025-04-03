package it.gssi.astra.metaeditor.common.dataManager.databinding.converters;

import org.eclipse.core.databinding.conversion.Converter;
import org.eclipse.emf.ecore.util.EcoreEList;

import MetaEditor.MetaEditorPersistence.CanvasSection;
import it.gssi.astra.metaeditor.common.canvas.section.CanvasSectionFX;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

/**
 * EList of persistence sections 2 list of SectionFX
 *
 */
public class SectionsEList2SectionListConverter extends Converter<Object, Object> {

	public SectionsEList2SectionListConverter() {
		super(EcoreEList.class, ObservableList.class);
	}

	public Object convert(Object fromObject) {

		@SuppressWarnings("unchecked")
		EcoreEList<CanvasSection> fromEList = (EcoreEList<CanvasSection>) fromObject;

		ObservableList<CanvasSectionFX> myObservableList;

		if (fromObject == null) {
			return null;
		}

		myObservableList = FXCollections.observableArrayList();
		for (int i = 0; i < fromEList.size(); i++) {

			int width = fromEList.get(i).getSectionWidth();
			int height = fromEList.get(i).getSectionHeight();
			String name = fromEList.get(i).getName();

			CanvasSectionFX canvasSectionFX = new CanvasSectionFX(name, width, height, i * width);
			myObservableList.add(canvasSectionFX);
		}

		return myObservableList;
	}

}
